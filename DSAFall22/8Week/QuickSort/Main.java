import java.util.Random;
/*
 * Thursday 11.17
 * week8
 * for QuickSort algorithms
 */

public class Main 
{
	public static void main(String args[])
	{
		Random rnd = new Random();
		int[] myArray;
		myArray = new int[10];

		for(int i = 0; i < 10; ++i)
		{
			myArray[i] = rnd.nextInt(100);
		}	

		for(int i = 0; i < 10; ++i)
		{
			System.out.println(myArray[i]);
		}
		
		System.out.println("*****sorted below******");

		QuickSort.sort(myArray);

		for(int i = 0; i < 10; ++i)
		{
			System.out.println(myArray[i]);
		}
	}
}	
