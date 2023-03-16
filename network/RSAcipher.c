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
	/*
	if(argc != 2)
	{
		printf("error expecting 1 argument");
		return 1;
	}
	*/
	printf("begin encrypt\n");

	char *plaintext = argv[1];

	BN_CTX *ctx = BN_CTX_new();
	
	BIGNUM * p = BN_new();
	BIGNUM * q = BN_new();
	BIGNUM * e = BN_new();
	BIGNUM * n = BN_new();
	BIGNUM * msg = BN_new();

	BN_hex2bn(&p, "F7E75FDC469067FFDC4E847C51F452DF");
	BN_hex2bn(&q, "E85CED54AF57E53E092113E62F436F4F");
	BN_hex2bn(&e, "0D88C3");
	BN_hex2bn(&msg, plaintext);

	printBN("msg = ", msg);


	BN_mul(n, p, q, ctx);

	BIGNUM * ctext = BN_new();

	// encode the message
	BN_mod_exp(ctext, msg, e, n, ctx);
	printBN("ctext =  ", ctext);
	


	return 0;
}




