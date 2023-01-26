from scapy.all import *
import time

# two machines on the same LAN
# the VM and the user container
# from the user container ping IP X
# this generates an ICMP echo request packet
# if X is alive the ping program will recieve an echo reply
# and print out the response

# this sniffnspoof.py runs on the VM which monitors the LAN thru
# packet sniffing. Whenever it sees an ICMP echo request, regardless
# of what the target IP address is, this program will immediately
# send an echo-reply using the packet spoofing technique

# therefore whether machine X is alive or not, the user container
# will always revieve a reply indicating x is alive

def send_reply(packet):
    a = packet

    print(a[IP].src)
    #ethernet[needs to be reversed too]

    a.show()

    #eth_src = a.src
    #eth_dst = a.dst



    pkt_src = a[IP].src
    pkt_dst = a[IP].dst
    pkt_ttl = a[IP].ttl
    new_id = a[ICMP].id
    new_seq = a[ICMP].seq

    data = a[Raw].load
    e = IP()
    e[IP].src = pkt_dst
    e[IP].dst = pkt_src
    e[IP].ttl = pkt_ttl-3
    e[IP].flags = 'DF'
    #q = Ether()
    #q.src = eth_dst
    #q.dst = eth_src

    #maybe need to redo the checksum


    b = ICMP(type=0, code=0, id=new_id, seq=new_seq)
    p = e/b/data
    del p.chksum
    # del p[ICMP].chksum
    p = p.__class__(bytes(p))
    p.show()
    send(p, verbose=0)

filt = 'icmp[icmptype] = icmp-echo'

packet = sniff(iface= 'br-f04cb60e7f26', filter=filt, prn=send_reply)
