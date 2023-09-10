//I made mine different than the one in class
//this one uses static methods to mainpulate arrays in main

public class BarrayList
{
	public static int[] insert(int[] oldArray, int newElement, int index)
	{

		int newArray[];
		int newSize = oldArray.length + 1;
                newArray = new int[newSize];
		for(int i = 0; i < index; ++i)  // copy the array up to the point where they're still the same
		{
			newArray[i] = oldArray[i];	
		}
		
		newArray[index] = newElement; // add the new element at the desired index

		for (int i = (index + 1) ; i < newSize; ++i) //paste the original values in the right places
							     //after the new value is inserted
		{
			newArray[i] = oldArray[i - 1];
		}

		return newArray;
	}

	public static int[] delete(int[] oldArray, int index)
	{
		int newSize = (oldArray.length - 1);
		int newArray[];
		newArray = new int[newSize];

		for (int i = 0; i < index; ++i) //copy array up to the point where the deletion should happen
		{
			newArray[i] = oldArray[i]; 
		}
		for (int i = index; i < newSize; ++i) //overwrite the array at the index to be deleted
		{
			newArray[i] = oldArray[i + 1];
		}

		return newArray;
	}

	public static int[] quarter(int[] oldArray)
	{
		int newSize = (oldArray.length / 2);
		int newArray[];
		newArray = new int[newSize];
		for (int i = 0; i < newSize; ++i) //this was for another method we used in class
						  //but its not really needed in this one
						  //it was for if your arraylist class has empty elements
						  //and only adds more when it gets too full
		{
			newArray[i] = oldArray[i];
		}
		return newArray;
	}

	public static void replace(int[] oldArray, int index, int newValue)
	{
		oldArray[index] = newValue;
	}
	public static int[] deleteByValue(int[] oldArray, int value)
	{
		for (int i = 0; i < oldArray.length; ++i)
			if (oldArray[i] == value)
			{
				oldArray = BarrayList.delete(oldArray, i);
			}
	
		return oldArray;

	}

	public static int[] clear(int[] oldArray)
	{
		int newArray[];
		newArray = new int[0];
		return newArray;

	}
}

