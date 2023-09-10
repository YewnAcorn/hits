import java.util.ArrayList;

public class Tree extends Plant
{
	double heightInInches;
	boolean isConiferous;
	ArrayList<Bird> birds = new ArrayList<Bird>();

	public Tree()
	{
		this.heightInInches = 22.2;
	       	this.isConiferous = true;
	}
	public Tree(String name)
	{
		this.name = name;
	}
	public void grow()
	{
		this.heightInInches = ++this.heightInInches;
	}
	public void birdLighted(Bird newBird)
	{
		this.birds.add(newBird);
	}

}

