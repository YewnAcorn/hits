// Search a sorted array for the first element larger than k.
// What is the runtime?
// can you solve it in O(log n)?

public class Main
{
	public static void main(String args[])
	{
		int sortedArray[] = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 6, 6, 6};
		int k = 3;
		for (int i = 0; i < sortedArray.length; ++i)
		{
			if ((sortedArray[i] == k) && sortedArray[i + 1] != k)
			{
				System.out.println(sortedArray[i + 1]);
			}
		}

	}
}


