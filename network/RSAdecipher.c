/* Carter Gunderson RSA Lab
 * compile with -lcrypto flag */
 
#include <openssl/bn.h>
#include <stdio.h>

void printBN(char*msg, BIGNUM*a)
{
    
        /* Use BN_bn2hex(a) for hex string
         * Use BN_bn2dec(a) for decimal string */
        char*number_str = BN_bn2hex(a);
        printf("%s %s\n", msg, number_str);
        OPENSSL_free(number_str);
}


int main(int argc, char *argv[])
{
        if(argc != 2)
        {
                printf("error expecting 1 argument");
                return 1;
        }
	
	printf("begin decrypt\n");

        char *ciphertext = argv[1];
	BN_CTX *ctx = BN_CTX_new();
	BIGNUM * p = BN_new();
        BIGNUM * pMinOne = BN_new();
        BIGNUM * q = BN_new();
        BIGNUM * qMinOne = BN_new();
        BIGNUM * e = BN_new();
        BIGNUM * n = BN_new();
        BIGNUM * phiN = BN_new();
        BIGNUM * one = BN_new();
        BIGNUM * d = BN_new();
        BIGNUM * cmsg = BN_new();
	BIGNUM * decoded = BN_new();

        BN_hex2bn(&p, "F7E75FDC469067FFDC4E847C51F452DF");
        BN_hex2bn(&q, "E85CED54AF57E53E092113E62F436F4F");
        BN_hex2bn(&e, "0D88C3");
        BN_hex2bn(&one, "1");
        BN_hex2bn(&cmsg, ciphertext);

        printBN("cmsg = ", cmsg);

        BN_sub(pMinOne, p, one);
        BN_sub(qMinOne, q, one);

	// n = p * q
        BN_mul(n, p, q, ctx);
	// phi(n) = p-1 * q-1
        BN_mul(phiN, pMinOne, qMinOne, ctx);

	//e * d mod phi(n) = 1, solve for d
	//d = private key
        BN_mod_inverse(d, e, phiN, ctx);

	
	// use d to decode the message
	BN_mod_exp(decoded, cmsg, d, n, ctx);
        printBN("decoded = ", decoded);
	
	return 0;
}
	
