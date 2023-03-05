#!/bin/bash


# Generate RSA key pair and certificate request
openssl req -newkey rsa:2048 -batch \
	-sha256 -days 3650 \
	-keyout gprox.key -out gprox.csr \
	-subj "/CN=www.gunderserver.net" \
	-config ./my_openssl.cnf \
	-passout pass:dees #encrypt private key with pw dees



