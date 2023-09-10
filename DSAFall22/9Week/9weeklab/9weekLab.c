#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

int sum = 0;

pthread_mutex_t mutex;


/*error handling function: prints out error message*/
int print_error(char *msg) {
    fprintf(stderr, "%s\n", msg);
    exit(2);
}
struct args_t
{
	int* arr;
	int size;
	int id;
	long nthreads;
};


void* partial_sum(void* args)
{
	//extract the arguments
	struct args_t *myargs = (struct args_t *)args;
	int* array = myargs -> arr;
	int size = myargs -> size;
	int id  = myargs -> id;
	int nthreads = myargs -> nthreads;

	long chunk = size / nthreads;
	int start = id * chunk;
	int  end = (id + 1) * chunk;
	int val;
	if (id == nthreads - 1)
	{
		end = size;
	}


	int r;

	for(r = start; r < end; r++)
	{
		val += array[r];

	}
	pthread_mutex_lock(&mutex);
	sum += val;
	pthread_mutex_unlock(&mutex);
	

	return NULL;

}
int main(int argc, char **argv) {

	int i;
	int nthreads; //number of threads
	pthread_t *thread_array; //pointer to future thread array
	long *thread_ids;
	int ret; //useful for error detection

	/* Read the number of threads to create from the command line. */
	if (argc != 2) {
	fprintf(stderr, "usage: %s <n>\n", argv[0]);
	fprintf(stderr, "where <n> is the number of threads\n");
	return 1;
	}
	nthreads = strtol(argv[1], NULL, 10);
	if (nthreads < 1) print_error("ERROR: enter a positive number of threads");

	/* Allocate space for thread structs and identifiers. */
	thread_array = malloc(nthreads * sizeof(pthread_t));
	thread_ids = malloc(nthreads * sizeof(long));
        if (!thread_array || !thread_ids) print_error("ERROR: malloc failed");
		




	struct args_t* args0 = malloc(sizeof(int) * 150);
	
	int* array0;
	int len0;

	len0 = 100;

	array0 = malloc(sizeof(int) * len0);
	if(!array0) print_error("ERROR: malloc failed");
	
	
	int u;
	
	for(u = 0; u < len0; u++)
	{
		array0[u] = 5;
	}

	args0 -> arr = array0;
	args0 -> size = len0; 
	args0 -> nthreads = nthreads;
		
	pthread_mutex_init(&mutex, NULL); //initialize the mutex	

	/* Assign each thread an ID and create all the threads. */
	int q;
        for (q = 0; q < nthreads; q++) 
	{
		thread_ids[q] = q;
		args0 -> id = thread_ids[q];
		ret = pthread_create(&thread_array[q], NULL, partial_sum, args0);
		if (ret) print_error("ERROR: pthread create failed");
        }


	/* Join all the threads. Main will pause in this loop until all threads
	* have returned from the thread function. */
	int z;
	for (z = 0; z < nthreads; z++) 
	{
		ret = pthread_join(thread_array[z], NULL);
		if (ret) print_error("ERROR: pthread join failed");
	}
	pthread_mutex_destroy(&mutex); //destroy the mutex, free it
	
	printf("%d\n", sum); //sum should be good now thanks to mutex
	
	free(thread_array);
	free(thread_ids);
	free(args0);
	free(array0);		

	return 0;
}

