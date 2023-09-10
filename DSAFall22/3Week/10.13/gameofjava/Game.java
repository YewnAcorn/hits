public class Game
{
	char[][] board;
	int rows;
	int columns;

	public Game(int x, int y)
	{
		char[][] board = new char[x][y];
		rows = x + 2; //plus two for the borders of the board
		columns = y + 2;
	}

	public char cycler(char[][] board)
	{
		for(int i = 1; i < rows - 1; ++i)
		{
			for (int j = 1; j < columns - 1; ++j)
			{
				return char[i][j];
			}
		}
	}

	public int neighborCounter(char[][] board)
	{
		int count = 0;
		for(int i = 1; i < rows - 1; ++i)
		{
			for (int j = 1; j < columns - 1; ++j)
			{
				cell = char[i][j]; //maybe this should be done w cycler() ?
				for (int n = -1; n < 1; ++n)
				{
					for (int m = -1; m < 1; ++m)
					{
						if (cell == '#')
						{
							++count;
						}
					}
				}
			}
		}
		return c
	}

		}
	}	

