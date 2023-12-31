/**
* Conway's Game of Life
* sequential version
* try padding the board with a border of 0s
*/
#include <stdlib.h>
#include <stdio.h>


void print_board_indices(short **board, int xlimit, int ylimit) {
   /* print out final board */
   int i,j;
  for (i = 0; i < xlimit; i++) {
    for (j = 0; j < ylimit; j++) {
      if (board[i][j] == 1) {
	printf("%d %d\n", i, j);
      }
    }
  }
}

void print_board(short **board, int xlimit, int ylimit) {
   /* print out final board */
   int i,j;
  for (i = 0; i < xlimit; i++) {
    for (j = 0; j < ylimit; j++) {
    	printf("%d ", board[i][j]);
    }
    printf("\n");
  }
}

void init_board(short **board, int xlimit, int ylimit) {
   /* print out final board */
   int i,j;
  for (i = 0; i < xlimit; i++) {
    for (j = 0; j < ylimit; j++) {
      
    }
  }
}


int main (int argc, char* argv[]) {

  char *fname;
  FILE *fd;
  int xlimit, ylimit, iterations, iter;
  short *board1_data = NULL, *board2_data = NULL;
  short **b1_rows, **b2_rows;
  short **oldb = NULL, **newb = NULL, **tempb;
  int i, j, x, y, count;
  

  /* you can initialize the input for development*/
  xlimit = 5;
  ylimit = 5;
  iterations = 2;

  /* if you read from the command line */
  

  /* set up the boards - use 2, 1 for previous and 1 for current iteration,
   switching them every iteration */

  /* allocate space and initialize board to all 0's */
  board1_data = (short *) calloc(xlimit * ylimit, sizeof(short));
  if (board1_data == NULL) {
    fprintf(stderr, "Allocation failed for board1\n");
    exit(-1);
  }
  board2_data = (short *) calloc(xlimit * ylimit, sizeof(short));
  if (board2_data == NULL) {
    fprintf(stderr, "Allocation failed for board1\n");
    exit(-1);
  }

  /* row pointers */
  b1_rows = (short **) malloc(xlimit * sizeof(short*));
  b1_rows[0] = board1_data;
  for (i = 1; i < xlimit; i++) {
    b1_rows[i] = b1_rows[i-1] + ylimit;
  }
  b2_rows = (short **) malloc(xlimit * sizeof(short*));
  b2_rows[0] = board2_data;
  for (i = 1; i < xlimit; i++) {
    b2_rows[i] = b2_rows[i-1] + ylimit;
  }

  /* initialize board1 with input data */
  

  /* perform the iterations, each time switching boards */
  for (iter = 0; iter < iterations; iter++) {
    /* switch boards */
    tempb = oldb;
    oldb = newb;
    newb = tempb;
    /* compute the new board, treating first/last row/column specially */
    /* first row has no row above */
    i = 0;
    /* first column has no cell on left */
    j = 0;
   
    }

    /* last column has no cell on right */
    
    
    /* middle rows */
    
      /* last column has no cell on right */
      

    /* last row has no row below */
    i = xlimit - 1;
    /* first column has no cell on left */
    
    /* last column has no cell on right */
    

  }

 
