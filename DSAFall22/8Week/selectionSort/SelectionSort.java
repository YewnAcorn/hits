public class SelectionSort
{
	public static void sort(int[] array)
	{
		int mindex;
		int temp;

		for(int i = 0; i < array.length; ++i)
		{
			mindex = i;
			for(int j = i + 1; j < array.length; ++j)
			{
				if(array[j] < array[mindex])	
				{
					mindex = j;
				}
			}

			temp = array[i];
			array[i] = array[mindex];
			array[mindex] = temp;
		}
	}
}
