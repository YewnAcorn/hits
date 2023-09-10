#include <stdlib.h>
#include <stdio.h>


int main()
{
	int x = 5;
	int y = 7;
	int* ptr1 = &x;
	int* ptr2 = ptr1;
	ptr1 = &y;
	printf("%d\n", *ptr2);
	return 0;
}
