#!/usr/bin/env python3

# PROXY.py

import threading
import socket
import ssl
import sys
import pprint


PROXY_CERT = './server-certs/gprox.crt'
PROXY_PRIVATE = './server-certs/gprox.key'
CLIENT_CA_DIR = './client-certs'

def main():
    server_name = sys.argv[1]

    # Create TCP server
    sock_listen = socket.socket(socket.AF_INET, socket.SOCK_STREAM, 0)
    sock_listen.bind(('0.0.0.0', 443))
    sock_listen.listen(100)

    # Server context
    context_srv = ssl.SSLContext(ssl.PROTOCOL_TLS_SERVER)
    context_srv.load_cert_chain(PROXY_CERT, PROXY_PRIVATE)

    while True:
        sock_cli, fromaddr = sock_listen.accept()
        try:
            ssock_cli = context_srv.wrap_socket(sock_cli, server_side=True)
        except Exception:
            print("TLS connection failed")
            continue

        print("TLS connection with client succeeds!")
        x = threading.Thread(target=deal_with_client, args=(ssock_cli, server_name))
        x.start()


def deal_with_client(ssock_cli, server_name):

    #Establish TLS connection with server
    
    hostname = "www.gunderserver.com"
    try: 
        sock_for_server = socket.create_connection((hostname, 443))
        print("socket created")
        context = ssl.SSLContext(ssl.PROTOCOL_TLS_CLIENT)
        print("context created")
        context.load_verify_locations(capath=CLIENT_CA_DIR)
        print("ca loaded")
        ssock_for_server = context.wrap_socket(sock_for_server, server_hostname=hostname)
        print("TLS socket wrapped")
    except Exception:
        print("TLS conneciton with the server fails!")
        return

    #read the request from the client and forward to the server
    request = ssock_cli.recv(1000)

    if request:
        # Forward request to server
        ssock_for_server.sendall(request)

        # Get response from server
        response = ssock_for_server.recv(1000)
        while response:
            ssock_cli.sendall(response) # forward to browser
            response = ssock_for_server.recv(1000)

    ssock_cli.shutdown(socket.SHUT_RDWR)
    ssock_cli.close()

main()
