public class MergeSort
{
	void merge(int arr[], int tmp[], int startA, int startB, int endB)
	{
		int aptr = startA;
		int bptr = startB;
		int idx = startA;
		while(aptr < startB && bptr < endB + 1)
		{
			if(arr[aptr] < arr[bptr])
			{
				tmp[idx++] = arr[apt++];
			}
		
			else
			{
				tmp[idx++] = arr[bptr++];
			}
		}
		while(aptr < startB)
		{
			tmp[idx++] = arr[aptr++];
		}
		while(bptr < endB + 1)
		{
			tmp[idx++] = arr[bptr++];
		}
		for(int i = startA; i <= endB; ++i)
		{
			arr[i] = tmp[i];
		}
	}

