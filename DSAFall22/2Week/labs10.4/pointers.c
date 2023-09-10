#include <stdlib.h>
#include <stdio.h>

struct number_T 
{
	int y;
};

int main(int argc, char *args[])
{
	int *ptr;
	int x = 3;
	
	ptr = &x;

	printf("x = %d, ptr = %p\n", x, ptr);

	struct number_T *ptr_n;
	struct number_T num;
	num.y = 7;
	//ptr_n = &num;
	


	ptr_n = malloc(sizeof(struct number_T));
	

	//these two lines mean the same thing
	//value at ptr_n (a struct) getting the data out of it (.y)
	//and changing it to 5

	//*ptr_n.y = 5;

	ptr_n -> y = 5;
	printf("number_T num.y = %d at location %p\n", num.y, ptr_n);
	return 0;
}

