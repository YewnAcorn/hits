import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	public static void main(String args[])
	{
		Plant tomato = new Plant("tomato");
		Tree apple = new Tree("apple");
		Bird woody = new Bird("woody", "woodpecker");
		apple.birdLighted(woody); //this is supposed to be
				  //an example of aggregation,
				  //adding a bird object to a tree
				  
		ArrayList<Plant> myPlants = new ArrayList<Plant>();

		myPlants.add(tomato);
		myPlants.add(apple);

		Garden myGarden = new Garden("myGarden", myPlants);
		//this is supposed to be an example of composition
		//all the plants are the garden's

		
		ArrayList<Plant> testList = new ArrayList<Plant>();
		//this is to test that it worked 

		testList = myGarden.getAllPlants();

		for (int i = 0; i < testList.size(); ++i)
		{
			System.out.println(testList.get(i).name);
		}

	}
}
