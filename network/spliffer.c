

#include <pcap.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/ip.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <arpa/inet.h>

/*4 bytes IP address */
typedef struct ip_address{
        u_char byte1;
        u_char byte2;
        u_char byte3;
        u_char byte4;
}ip_address;

/*Ethernet header*/
typedef struct eth_header{
        u_char dhost[6];
        u_char shost[6];
        u_short type;
}eth_header;

/*ICMP header*/
typedef struct icmp_header{
        u_short type_code;
        u_short checksum;
        u_short id;
        u_short seq;
}icmp_header;


/*IPv4 header */
typedef struct ip_header{
        u_char ver_ihl; //Version (4 bits) + Internet header length (4 bits)
        u_char tos;     //Type of service
        u_short tlen;   //Total length;
        u_short id;
        u_short flags_fo; // Flags (3 bits) + Fragment offset (13 bits)
        u_char ttl;
        u_char proto;
        u_short checksum;
        ip_address saddr; //source address
        ip_address daddr; //destination address
        u_int op_pad; //Option + Padding
}ip_header;


/*UDP header*/
typedef struct udp_header{
        u_short sport; //source port
        u_short dport; //Destination port
        u_short len; //Datagram length
        u_short crc; //checksum
}udp_header;



/* This function will be invoked by pcap for each captured
 * packet We can process each packet inside the function 
 */

void got_packet (u_char *args, const struct pcap_pkthdr *header, const u_char *packet)
{
        printf("Got a packet\n");
}


/*
void send_raw_ip_packet(struct ipheader* ip)
{
        struct sockaddr_in dest_info;
        int enable = -1;

        //Create raw socet
        int sock = socket(AF_INET, SOCK_RAW, IPPROTO_RAW);

        setsockopt(sock, IPPROTO_IP, IP_HDRINCL, &enable, sizeof(enable));
        
        //Destination info
        
        dest_info.sin_family = AF_INET;
        dest_info.sin_addr   = ip->daddr;

        //Send the packet
        printf("Sending spoofed IP packet..\n");
        if(sendto(sock, ip, ntohs(ip->tlen), 0,
                                (struct sockaddr *)&dest_info, sizeof(dest_info)) <0 ) {
                perror("Packet nont sent!!1\n");
                return;
        }
        close(sock);

}
*/



// A function to determine the size of the layer2
// for different layer2 types
int pcap_dloff(pcap_t *pd)
{
        int offset = -1;

        switch (pcap_datalink(pd)) {
        case DLT_EN10MB: //Ethernet
                offset = 14;
                break;
        case DLT_IEEE802: //Wifi 802.11
                offset = 22;
                break;
        case DLT_FDDI: //Fiber Distributed Data Interface
                offset = 21;
                break;
#ifdef DLT_LOOP
        case DLT_LOOP:
#endif
        case DLT_NULL:
                offset = 4;
                break;
        default:
                warnx("unsupported datalink type");
                break;
        }

        return (offset);

}

void processPacket(int arg, const struct pcap_pkthdr* pkthdr, const u_char* packet)
{
        int i = 0;
        int counter = 0;
        int offset = arg;

        u_char *buffer = (u_char *)malloc(pkthdr->len);
        memset(buffer, 0, pkthdr->len);
        u_int ip_len;
        pcap_t *nhandle;
        char errbuf[PCAP_ERRBUF_SIZE];

        //Assuming its ethernet for now:
        struct eth_header *eth = (struct eth_header *)packet;

		struct ip_header *ip = (struct ip_header *)(packet + offset);

        //Get the position for the ICMP header:
        ip_len = (ip->ver_ihl & 0xf) * 4;
        struct icmp_header *icmp = (struct icmp_header *)((u_char*)ip + ip_len);

        //struct udp_header *udp = (struct udp_header *)((u_char*)ip + ip_len);

        //Convert the network byte order o the host byte order
        //u_short sport = ntohs(udp->sport);
        //u_short dport = ntohs(udp->dport);


        for(i=0;i<pkthdr->len; i++){
                buffer[i] = packet[i];
        }

        struct eth_header *speth = (struct eth_header*)buffer;
        struct ip_header *spoofip = (struct ip_header *)(buffer+offset);
        struct icmp_header *spooficmp = (struct icmp_header *)((u_char*)spoofip + ip_len);


        for(i=0;i<6;i++){
                speth->dhost[i] = eth->shost[i];
                speth->shost[i] = eth->dhost[i];
        }

        /*
        spoofip->ver_ihl = ip->ver_ihl;
        spoofip->tos = ip->tos;
        spoofip->tlen = ip->tlen;
        spoofip->id = ip->id;
        spoofip->flags_fo = ip->flags_fo;
        spoofip->ttl = ip->ttl;
        spoofip->proto = ip->proto;
        spoofip->checksum = ip->checksum;
        */
        spoofip->saddr = ip->daddr;
        spoofip->daddr = ip->saddr;

        spooficmp->type_code = 0;
        //spooficmp->checksum = 3;
        //spooficmp->id = 3; 
        //spooficmp->seq = 3;
        //spooficmp->op_pad = icmp->op_pad;



        printf("##[IP]##\n");
        printf("version, ihl = %d\n", ip->ver_ihl);
        printf("tos = %d\n", ip->tos);
        printf("len = %d\n", ip->tlen);
        printf("proto = %d\n", ip->proto);
        printf("id = %d\n", ip->id);
        printf("flags, frag = %d\n", ip->flags_fo);
        printf("source = %d.%d.%d.%d\n", ip->saddr.byte1,
                                         ip->saddr.byte2,
                                         ip->saddr.byte3,
                                         ip->saddr.byte4);

        printf("destination = %d.%d.%d.%d\n", ip->daddr.byte1,
                                              ip->daddr.byte2,
                                              ip->daddr.byte3,
                                              ip->daddr.byte4);


        printf("##[ICMP]##\n");
        printf("type and code = %d\n", icmp->type_code);
        printf("checksum = %x\n", icmp->checksum);
        printf("ID = %x\n", icmp->id);
        printf("seq = %x\n", icmp->seq);

        printf("##SPOOF##\n");

        printf("##[IP]##\n");
        printf("version, ihl = %d\n", spoofip->ver_ihl);
        printf("tos = %d\n", spoofip->tos);
        printf("len = %d\n", spoofip->tlen);
        printf("proto = %d\n", spoofip->proto);
        printf("id = %d\n", spoofip->id);
        printf("flags, frag = %d\n", spoofip->flags_fo);
        printf("source = %d.%d.%d.%d\n", spoofip->saddr.byte1,
                                         spoofip->saddr.byte2,
                                         spoofip->saddr.byte3,
                                         spoofip->saddr.byte4);

        printf("destination = %d.%d.%d.%d\n", spoofip->daddr.byte1,
                                              spoofip->daddr.byte2,
                                              spoofip->daddr.byte3,
                                              spoofip->daddr.byte4);


        printf("##[ICMP]##\n");
        printf("type and code = %d\n", spooficmp->type_code);
        printf("checksum = %x\n", spooficmp->checksum);
        printf("ID = %x\n", spooficmp->id);
        printf("seq = %x\n", spooficmp->seq);

        /*
        printf("##[UDP]##\n");
        printf("source port = %d\n", udp->sport);
        printf("destination port = %d\n", udp->dport);
        */

        printf("Offset: %d\n", offset);
        printf("Packet Count: %d\n", ++(counter));
        printf("Recieved Packet Size: %d\n", pkthdr->len);
        printf("Payload \n");

        for(i=0; i<pkthdr->len; i++){
                printf("%x", packet[i]);
        }
		printf("\nSpoofed packet:\n");
        for(i=0; i<pkthdr->len; i++){
                printf("%x", buffer[i]);
        }



        nhandle = pcap_open_live("br-33c97c64bea6", pkthdr->len, 1, 1000, errbuf);
        if(pcap_inject(nhandle, buffer, pkthdr->len) == -1)
        {
                printf("error!!11 packet not sent");
        }else{
                printf("spoof away!");
        }

        pcap_close(nhandle);
}

int main()
{
        pcap_t *handle;
        int offset;
        char errbuf[PCAP_ERRBUF_SIZE];
        struct bpf_program fp;
        char filter_exp[] = "icmp";
        bpf_u_int32 net;
        memset(errbuf, 0, PCAP_ERRBUF_SIZE);

        handle = pcap_open_live("br-33c97c64bea6", BUFSIZ, 1, 1000, errbuf);

        pcap_compile(handle, &fp, filter_exp, 0, net);
        if(pcap_setfilter(handle, &fp) !=0) {
                pcap_perror(handle, "Error:");
                exit(EXIT_FAILURE);
        }


        offset = pcap_dloff(handle);
        //pcap_loop(handle, -1, got_packet, NULL);
        pcap_loop(handle, 1, processPacket, offset);

        pcap_close(handle);





        return 0;
}


