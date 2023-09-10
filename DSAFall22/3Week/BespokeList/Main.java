import java.util.Arrays;

public class Main
{
	public static void main(String args[])
	{
		int arrayOfDoom[];
		arrayOfDoom = new int[]{ 0,1,2,3,4,5,6,7,8,9 };

		arrayOfDoom = BarrayList.insert(arrayOfDoom, 9000, 5);
		
		System.out.println(Arrays.toString(arrayOfDoom));


		arrayOfDoom = BarrayList.delete(arrayOfDoom, 5);

		System.out.println(Arrays.toString(arrayOfDoom));

		arrayOfDoom = BarrayList.clear(arrayOfDoom);

		System.out.println(Arrays.toString(arrayOfDoom));

		for (int i = 0; i < 10; ++i)
		{
			arrayOfDoom = BarrayList.insert(arrayOfDoom, i + 1, i);
		}

		System.out.println(Arrays.toString(arrayOfDoom));
		
		arrayOfDoom = BarrayList.deleteByValue(arrayOfDoom, 7);

		arrayOfDoom = BarrayList.deleteByValue(arrayOfDoom, 9);

		System.out.println(Arrays.toString(arrayOfDoom));

		arrayOfDoom = BarrayList.insert(arrayOfDoom, 3333, 3);
		arrayOfDoom = BarrayList.insert(arrayOfDoom, 444, 4);

		System.out.println(Arrays.toString(arrayOfDoom));

	

	}
}
