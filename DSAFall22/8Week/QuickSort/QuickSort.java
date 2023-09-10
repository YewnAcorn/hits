public class QuickSort
{
	private static void sort(int[] array, int left, int right)
	{
		int pivot = right;
		int leftMarker = left;
		int rightMarker = right - 1;	

		while(leftMarker < rightMarker)
		{

			while(array[leftMarker] < array[pivot])
			{
				leftMarker++;
			}
			while(array[rightMarker] > array[pivot])
			{
				rightMarker--;
			}
			
			if(array[leftMarker] > array[rightMarker])
			{
				int temp = array[leftMarker];
				array[leftMarker] = array[rightMarker];
				array[rightMarker] = temp;
			}

			System.out.println("preswap");
			System.out.println("Left: " + array[leftMarker]);
			System.out.println("pivot " + array[pivot]);
			System.out.println("right: " + array[rightMarker]);
			
		}

		/*
		System.out.println("Left left " + left);
		System.out.println("left right " + (right+left)/2);
		System.out.println("right-left" + (right+left)/2+1);
		System.out.println("Right: " + right);
		*/
		sort(array, left, (right+left)/2);
		sort(array, ((right+left)/2 + 1) + 1, right);
	}

	public static void sort(int[] array)
	{
		sort(array, 0, array.length - 1);
	}
}
