public class Plant
{
	protected String name;
	protected int numleaves;
	protected boolean isFlower;
	
	public Plant()
	{
		this.name = "noname";
		this.numleaves = 0;
		this.isFlower = false;
	}
	public Plant(String name)
	{
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void printPlant()
	{
		System.out.println("Your plant: " + this.name);
	}
}	
