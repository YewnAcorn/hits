import java.util.ArrayList;
public class Garden
{
	public String name;

	private final ArrayList<Plant> plants;

	public Garden(String name, ArrayList<Plant> plants)
	{
		this.name = name;
		this.plants = plants;
	}

	public ArrayList<Plant> getAllPlants()
	{
		return plants;
	}

}

