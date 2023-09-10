import java.util.Random;

public class GameBoard
{
	private Cell board[][] = new Cell[102][102];
	private int length = 102;
	public GameBoard()
	{
		for(int i = 0; i < this.board.length; ++i)
		{
			for(int j = 0; j < this.board.length; ++j)
			{
				this.board[i][j] = new Cell(i, j);
			}
		}
	}
	public int getLength()
	{
		return this.length;
	}
	public Cell[][] getBoard()
	{
		return this.board;
	}

	public void cellInit()
	{
		for(int i = 1; i < this.board.length - 1; ++i)
		{
			for(int j = 1; j < this.board.length - 1; ++j)
			{
				Random rand = new Random();
				int x = rand.nextInt(2);
				boolean a = true;
				if(x == 0)
				{
					a = true;
				}
				if(x == 1)
				{
					a = false;
				}
				this.board[i][j].setAlive(a);
			}
		}
	}
	public void count(Cell g)
	{
		int count = 0;
		int x = g.getX();
		int y = g.getY();
		for(int i = - 1; i < 1; ++i)
		{
			for(int j = - 1; j < 1; ++j)
			{
				Cell n = new Cell();
				n = board[x+i][y+j];
				if(n.getAlive() == true)			
				{
					count++;
				}
			}
		}
		g.setCount(count);
	}

	public Cell getCell(int x, int y)
	{
		return board[x][y];
	}


	public void setCell(int x, int y, Cell c)
	{
		Cell v = new Cell(c.getX(), c.getY());
		v.setAlive(c.getAlive());
	}


	
}	
	
		
