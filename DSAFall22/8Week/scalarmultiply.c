#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

/*error handling function: prints out error message*/
int print_error(char *msg) {
    fprintf(stderr, "%s\n", msg);
    exit(2);
}

struct t_arg {
    int *array; // pointer to shared array
    long length; // num elements in array
    long s; //scaling factor
    long numthreads; // total number of threads
    long id; //  logical thread id
};


void *scalar_multiply(void *id) {
    long *myid = (long *) id;
    int i;

    //assign each thread its own chunk of elements to process
    long chunk = length / nthreads;
    long start = *myid * chunk;
    long end  = start + chunk;
    if (*myid == nthreads - 1) {
        end = length;
    }

    //perform scalar multiplication on assigned chunk
    for (i = start; i < end; i++) {
        array[i] *= s;
    }

    return NULL;
}

int main(int argc, char **argv) {
    int i;
    pthread_t *thread_array; //pointer to future thread array
    long *thread_ids;
    int ret; //useful for error detection
    


    /* Read the number of threads to create from the command line. */
    if (argc != 2) {
        fprintf(stderr, "usage: %s <n>\n", argv[0]);
        fprintf(stderr, "where <n> is the number of threads\n");
        return 1;
    }
	
    int *array = malloc(length*sizeof(int));

	//allocate space for thread structs and identifiers
	pthread_t *thread_array = malloc(nthreads * sizeof(pthread_t));
	struct t_arg *thread_args = malloc(nthreads * sizeof(struct t_arg));

	//Populate thread arguments for all the threads
	for (i = 0; i < nthreads; i++){
	    thread_args[i].array = array;
	    thread_args[i].length = length;
	    thread_args[i].s = s;
	    thread_args[i].numthreads = nthreads;
	    thread_args[i].id = i;
}

    long nthreads = strtol(argv[1], NULL, 10); //get number of threads
    long length = strtol(argv[2], NULL, 10); //get length of array
    long s = strtol( argv[3], NULL, 10 ); //get scaling factor

    if (nthreads < 1) print_error("ERROR: enter a positive number of threads");

    /* Allocate space for thread structs and identifiers. */
    thread_array = malloc(nthreads * sizeof(pthread_t));
    thread_ids = malloc(nthreads * sizeof(long));
    if (!thread_array || !thread_ids) print_error("ERROR: malloc failed");

    /* Assign each thread an ID and create all the threads. */
    for (i = 0; i < nthreads; i++) {
        thread_ids[i] = i;
        ret = pthread_create(&thread_array[i], NULL, scalar_multiply, &thread_ids[i]);
	//if(*myid % 4 == 0) { sleep(1); }
        if (ret) print_error("ERROR: pthread create failed");
    }

    /* Join all the threads. Main will pause in this loop until all threads
     * have returned from the thread function. */
    for (i = 0; i < nthreads; i++) {
        ret = pthread_join(thread_array[i], NULL);
        if (ret) print_error("ERROR: pthread join failed");
    }

    free(thread_array);
    free(thread_ids);

    return 0;
}
