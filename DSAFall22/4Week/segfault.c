/**
 * segfault.c
 * create a segmentation fault
 * the poitner points to null
 * trying to dereference null at runtime
 * crashes with a segmentation fault.
 */


/* also testing foo to see how
 * to copy pointer to an array
 */

#include <stdio.h>
#include <stdlib.h>

void foo(int *ptr, int length)
{
	int array[10];
	
	for(int i = 0; i < length; i++)
	{
		array[i] = ptr[i];

	}


	return;
}




int main()
{
	int *ptr = (int *)malloc(sizeof(int) * 20);
	foo(ptr, 20);


	printf("the value is: %d\n", ptr[0] );


	return 0;
}
