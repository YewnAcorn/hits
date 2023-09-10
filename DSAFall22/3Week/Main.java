import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String args[])
	{
		int myArray[];
	        myArray = new int[10];	
		Scanner scnr = new Scanner(System.in);
		for (int i = 0; i < 10; ++i)
		{	
			System.out.println("enter integer: ");
			myArray[i] = scnr.nextInt();

		}
		//if the array is of undetermined size / how to add to the size of an array
		System.out.println("enter new size of array");
		int newSize = scnr.nextInt();
		int newArray[];
		newArray = new int[newSize];
		for (int i = 0; i < newSize; ++i)
		{
			if (i < myArray.length)
			{
				newArray[i] = myArray[i];
			}
			else if (i >= myArray.length)
			{
				System.out.println("enter integer: ");
				newArray[i] = scnr.nextInt();

			}

		}
		myArray = newArray;
		System.out.println(Arrays.toString(myArray));
		//how to remove the first element from an array
		//I'm thinking you'd have to make a new array of length - 1
		//and then copy everything over and shifted 1 position
	}
}


