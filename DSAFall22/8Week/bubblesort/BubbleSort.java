public class BubbleSort
{
	public static void sort(int[] array)		
	{
		boolean sorted;
		int temp;
		int i = 0;
		//for(int i = 0; i < array.length; ++i)
		do
		{
			sorted = true;

			for(int j = 0; j < array.length - i - 1; ++j)
			{
				if(array[j] > array[j+1])
				{
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

					sorted = false;
				}

			}
			++i;
		}
		while(!sorted);
	}

}
