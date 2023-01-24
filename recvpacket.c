#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/ip.h>

int main()
{
	struct sockaddr_in server;
	struct sockaddr_in client;
	int clientlen;
	char buf[1500];


	//c create network socket
	//socket(IPV4, UPD, UDP) its redundant
	int sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP); 

	//provide needed information about 
	memset((char *) &server, 0, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = htonl(INADDR_ANY); 
	server.sin_port =htons(9090);

	if(bind(sock, (struct sockaddr *) &server, sizeof(server)) < 0)
		error("ERROR on binding!!1");
	
	while (1) {
		bzero(buf, 1500);
		recvfrom(sock, buf, 1500-1, 0, (struct sockaddr *) &client, &clientlen);
		printf("%s\n", buf);
	}
	close(sock);
}


	//Send the packet out
	sendto(sock,data, strlen(data), 0,
			(struct sockaddr *)&dest_info, sizeof(dest_info));
	close(sock);

	return 0;
}



