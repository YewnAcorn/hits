#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>


struct t_args
{
	int rows;
	int columns;
	char *simulation;
};
void begin(int rows, int columns); 
char* create(int rows, int columns);
double getRandomDoubleInRange(double min, double max);
void display(int rows, int columns, char* simulation);
int countNeighborhood(int rows, int columns, int x, int y, char* simulation);
char* step(int rows, int columns, char* prevSimulation);

int main(int argc, char* argv[]){

	if(argc != 4)
	{
		fprintf(stderr, "usage: %s <r> <c> <t>\n", argv[0]);
		fprintf(stderr, "where <r> is the number of rows\n");
		fprintf(stderr, "where <c> is the number of columns\n");
		fprintf(stderr, "where <t> is the number of threads\n");
		return 1;
	}

	//mutlithreading
	int nthreads;
	pthread_t *thread_array;
	struct t_args *args;
	int ret;
	
	//allocte space for thread structs and identifiers
	
	thread_array = malloc(nthreads * sizeof(pthread_t));
	args = malloc(nthreads * sizeof(args));
	if (!thread_array || !args) printf("error: malloc failed");

	//BUT NOW WHERE TO CREATE/JOIN?



	int rows = atoi(argv[1]);
	if (rows <= 0)
	{
		printf("Rows cant be 0 or negative, was %d", rows);
		return -1;
	}
	rows += 2;

	int columns = atoi(argv[2]);
	if (columns <= 0)
	{
		printf("Columns cant be 0 or negative, was %d", columns);
		return -1;
	}
	columns += 2;
	
	nthreads = atoi(argv[3]);
	if (nthreads <= 0)
	{
		printf("threads cannot be nonpositive, was %d", nthreads);
		return -1;
	}
	begin(rows, columns);
}

void display(int rows, int columns, char* simulation)
{
//	printf("\n\n\n\n\n\n\n\n\n\n\n");
	for(int y = 1; y < rows-1; ++y)
	{
		for(int x = 1; x < columns-1; ++x)
		{
			printf("%c ", *(simulation + y*columns + x));
		}
		printf("\n");
	}
}

int countNeighborhood(int rows, int columns, int x, int y, char* simulation)
{
	int count = 0;

	int pivot = y * columns + x;

	for (int i = -1; i <= 1; ++i)
	{
		for(int j = -1; j <=1; ++j)
		{
			char c = *(simulation+pivot+(i*columns)+j);

			if (c == '#') count++;
		}
	}
	return count;
}
/*   GAME OF LIFE:
 *   
 *   Any live cell with fewer than two live neighbours dies, as if by underpopulation.
 *   Any live cell with two or three live neighbours lives on to the next generation.
 *   Any live cell with more than three live neighbours dies, as if by overpopulation.
 *   Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 *
 */


char* step(int rows, int columns, char* prevSimulation)
{
	char* steppedSimulation = calloc(rows*columns, sizeof(char));
	if(steppedSimulation == NULL) return NULL;

	for(int y = 1; y < rows - 1; ++y)
	{
		for(int x = 1; x < columns - 1; ++x)
		{
			int live = countNeighborhood(rows, columns, x, y, prevSimulation);
			char cell = *(prevSimulation+y*columns+x);
			if(cell == '#') live--;
			*(steppedSimulation+y*columns+x) = cell;
			if(live < 2)
			{
				*(steppedSimulation+y*columns+x) = '.';
			}
			if((live == 2 || live == 3) && cell == '#')
			{
				*(steppedSimulation+y*columns+x) = '#';
			}
			if((live > 3) && cell == '#')
			{
				*(steppedSimulation+y*columns+x) = '.';
			}
			if((live == 3) && cell =='.')
			{
				*(steppedSimulation+y*columns+x) = '#';
			}
		}
	}

	return steppedSimulation;

}
void begin(int rows, int columns)
{
	puts("begin! ctrl C to exit");
	char* simulation = create(rows, columns);
	if(simulation == NULL) return;
	display(rows, columns, simulation);

	while(1)
	{
		char* newSim = step(rows, columns, simulation);
		if(newSim == NULL) return;

		free(simulation);
		simulation = newSim;
		display(rows, columns, simulation);
		usleep(9000);
	}

		
}
double getRandomDoubleInRange(double min, double max)
{
	return ((double)rand()/RAND_MAX)*(max-min) + min;


}
char* create(int rows, int columns)
{
	char* simulation = (char*)calloc(rows*columns, sizeof(char));
	if(simulation == NULL)
	{
		return NULL;
	}
	for(int y = 1; y < rows-1; ++y)
	{
		for(int x = 1; x < columns-1; ++x)
		{
			if(getRandomDoubleInRange(0.0, 1.0) <= 0.35)
			{
				*(simulation + y*columns + x) = '#';
			}
			else
			{
				*(simulation + y*columns + x) = '.';
			}	
		}
	}
	return simulation;
}

