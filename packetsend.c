#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/ip.h>

int main()
{
	struct sockaddr_in dest_info;
	char *data = "hello server\n";

	//c create network socket
	//socket(IPV4, UPD, UDP) its redundant
	int sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP); 

	//provide needed information about destination
	memset((char *) &dest_info, 0, sizeof(dest_info));
	dest_info.sin_family = AF_INET;
	dest_info.sin_addr.s_addr = inet_addr("127.0.0.1");
	dest_info.sin_port =htons(9090);

	//Send the packet out
	sendto(sock,data, strlen(data), 0,
			(struct sockaddr *)&dest_info, sizeof(dest_info));
	close(sock);

	return 0;
}



