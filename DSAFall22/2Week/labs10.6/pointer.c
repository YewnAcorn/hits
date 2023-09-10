/* Name: Carter Gunderson
 * this is my code for doing the things
 * that were described in PDC - LAB Week 2
 * some are commented out but can be put back
 * in to show that they work
 */

#include <stdio.h>
#include <stdlib.h>

struct square {
	int length;
};

struct rectangle {
	int length;
	int height;
};

struct circle {
	int radius;
};



int area_sq(struct square s){
	return (s.length * s.length);
}

int area_rect(struct rectangle r) {
	return (r.length * r.height);
}

int area_circle(struct circle c) {
	return (3.14159265358979 * c.radius * c.radius);
}

void init_array(int size, int array[]) {
	int i;
	//loop
	for (i = 0; i < size; ++i) {
		array[i] = i;
	}
}

void print_array(int size, int array[]) {
	size = 10;
	printf("%d\n", size);
	for (int i = 0; i < size; ++i) {
		printf("%d\n", array[i]);
	}
}

void swap(int *ptr1, int *ptr2)
{
	int *temp;
	*temp = *ptr1;
	*ptr1 = *ptr2;
	*ptr2 = *temp;

}

void initArr0(int *arrFirst)
{
	for (int i = 0; i < 10; ++i)
	{
		*(arrFirst + i) = 0;
	}
}


int main() {

	int x = 0;
	int *px = &x;
	
	*px = 10;

//	printf("%d\n", x);

	
	//MALLOC
	int *myArray =(int *) malloc(10 * sizeof(int));
	if (myArray == NULL) {
		printf("Bad malloc error\n");
		exit(1);
	}

	initArr0(myArray);	
        print_array(10, myArray);
	//MALLOC ^
	
	struct square mySquare;
	mySquare.length = 10;

	struct rectangle myRect;
	myRect.length = 10;
	myRect.height = 5;

	struct circle myCircle;
	myCircle.radius = 12;

	double areaSquare;
	double areaRect;
	double areaCircle;

	areaSquare = area_sq(mySquare);
	areaRect = area_rect(myRect);
	areaCircle = area_circle(myCircle);
	
	printf("%f\n", areaSquare);
	printf("%f\n", areaRect);
	printf("%f\n", areaCircle);

	int a = 5;
	int b = 3;
	int *pa;
        pa = &a;
	int *pb;
        pb = &b;

	swap (pa, pb);
//	printf("%d %d\n", a, b);

	//mArray(10);
	//print_array(10, newArray);

	//init_array(10, myArray);	
	//print_array(10, myArray);
	free(myArray);
	myArray = NULL;	
	return 0;
}

