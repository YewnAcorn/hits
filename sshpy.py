import paramiko
import time

# Update the next four lines with your
# server's information

host = "127.0.0.1"
u = "group33user1"
p = "VAuYw5cLuZqKwzG2"
edu_port = 49176

"""
level 0
"""
client = paramiko.client.SSHClient()
client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
client.connect(hostname="localhost", port=edu_port, username="group33user1", password="VAuYw5cLuZqKwzG2", look_for_keys=False)
time.sleep(.01)


"""
The game needs us to ssh into different IPs
but the IPs are different each time
for example the first IP we need to ssh into is
OCTET.0.0.4 -p 444
where octet is defined in
/home/ubuntu/adjust_motd

"""

_stdin, _stdout,_stderr = client.exec_command("ip route show dev eth0")
stdout = _stdout.readlines()

def find_octet():
    ip_raw = open("ip_raw.txt", "x")
    ip_raw = open("ip_raw.txt", "a")
    ip_raw.writelines(f"{stdout}")
    ip_raw.close()

    ip_raw = open("ip_raw.txt", "r")
    ip_string = ip_raw.read()

    ip_actual = ip_string[14] + ip_string[15]
    ip_raw.close()
    return ip_actual

octet = find_octet()

hosts = [client] 

def quaid(dest_addr, dest_port, local_addr, local_port, hosts):

    last_host = len(hosts) - 1
    jhost = hosts[last_host]

    client_transport_n = jhost.get_transport()
    dest_addr_n = (dest_addr, dest_port) 
    local_addr_n = (local_addr, local_port)
    client_channel_n = client_transport_n.open_channel("direct-tcpip", dest_addr_n, local_addr_n)

    nhost = paramiko.SSHClient() 
    nhost.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    nhost.connect(port=dest_port, hostname=dest_addr, username=u, password=p, sock=client_channel_n)
    hosts.append(nhost)

    f = open(f"logs_{last_host}.txt", "x")
    f = open(f"logs_{last_host}.txt", "a")
    f.write("cat /etc/motd\n")
    _stdin, _stdout,_stderr = nhost.exec_command("cat /etc/motd")
    f.write("cat /etc/motd\n")
    stdout_n = _stdout.read()
    f.write(str(stdout_n))
    f.close()
    



quaid(f"{octet}.0.0.4", 444, f"{octet}.0.0.2", edu_port, hosts)
quaid(f"{octet}.0.0.101", 22, f"{octet}.0.0.4", 444, hosts)
quaid(f"{octet}.0.0.24", 666, f"{octet}.0.0.101", 22, hosts)
quaid(f"{octet}.0.217.33", 22, f"{octet}.0.0.24", 666, hosts)
quaid(f"{octet}.0.204.64", 123, f"{octet}.0.217.33", 22, hosts)
quaid(f"{octet}.0.234.8", 632, f"{octet}.0.204.64", 123, hosts)



