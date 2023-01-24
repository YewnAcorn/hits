

char buffer[PACKET_LEN];
memset(buffer, 0, PACKET_LEN); // set everything to 0, no residual from RAM

//Find the starting point of each layer
struct ipheader *ip = (struct ipheader *)buffer;
struct udpheader *udp = (struct udpheader *)
			(buffer + sizeof(struct ipheader));
char *data = buffer + sizeof(struct ipheader)
		    + sizeof(struct udpheader);

char * msg= "Hello Server.\n";
int data_len=strlen(msg);
strncpy(data, msg, data_len);

udp -> udp_dport = htons(DST_PORT);
udp -> udp_sport = htons(9999);
udp -> udp_ulen = htons(sizeof(struct udpheader) + data_len);
udp -> udp_sum = 0; //checksum isnt important in UDP


ip->iph_ver=4;
ip->iph_ihl=5;
ip->iph_ttl=20
ip->iph_sourceip.s_addr = inet_addr(SRC_IP);
ip->iph_destip.s_addr = inet_addr(DEST_IP);
ip->iph_protocol = IPROTO_UDP; //protocol of next header is UDP
ip->iph_len = htons(sizeof(struct ipheader) +
		    sizeof(struct udpheader) + data_len);
ip->iph_chksum = 0; //leave it to the os to set this field

send_raw_ip_packet(ip);

void send_raw_ip_packet(struct ipheader* ip)
{
	struct sockaddr_in dest_info;
	int enable = -1;

	// Create a raw socket
	int sock = socket(AF_INET, SOCK_RAW, IPPROTO_RAW);

	setsockopt(sock, IPPROTO_IP, IP_HDRINCL, &enable, sizeof(enable)); //maybe redundant
	
	//Destination info
	dest_info.sin_family = AF_INET;
	dest_info.sin_addr   = ip->iph_destip; //maybe redundant
	
	//Send the packet out
	printf("Sending spoofed IP packet...\n");
	if(sendto(sock, ip, ntohs(ip->iph_len), 0,
				(struct sockaddr *)&dest_info, sizeof(dest_info)) <0) {
			perror("PACKET NOT SENT\n");
			return;
	}
	close(sock);
}
