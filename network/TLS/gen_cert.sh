#!/usr/bin/bash


# Generate a certificate

openssl ca -config ./my_openssl.cnf -policy policy_anything \
        -md sha256 -days 3650 \
        -in gprox.csr -out gprox.crt -batch \
        -cert ca.crt -keyfile ca.key -passin pass:dees


