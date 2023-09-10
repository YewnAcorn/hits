public class Cell
{
	private int x;
	private int y;
	private boolean alive;
	private int neighborCount;
	
	public Cell()
	{
		this.alive = false;
	}
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.alive = false;
	}
	public int[] getxy()
	{
		int[] coord = {this.x, this.y};
		return coord;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public boolean getAlive()
	{
		return this.alive;
	}
	public void setAlive(boolean a)
	{
		this.alive = a;
	}
	public int getCount()
	{
		return neighborCount;
	}
	public void setCount(int c)
	{
		this.neighborCount = c;
	}

	
	public void setStatus()
	{
		if(this.alive == true && neighborCount <= 2)
		{
			this.alive = false;
		}
		if(this.alive == false && neighborCount == 3)
		{
			this.alive = true;
		}
		if(this.alive == true && neighborCount > 3)
		{
			this.alive = false;
		}
	}



}
