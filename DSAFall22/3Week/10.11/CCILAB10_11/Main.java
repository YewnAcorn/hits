//worked with griffin
//this is the microsoft question
//from CCI lab 10.11.22
public class Main
{

	public static int findTheSingle(int sortedArray[])
	{
		int singleNum = -1;
		int n = sortedArray.length;
		//since its sorted of twins we can count
		//up by 2 instead of 1
		for (int i = 0; i < n - 1; i +=2)
		{
			if (sortedArray[i] != sortedArray[i + 1]){
				singleNum = sortedArray[i];
				break;
			}
		}
		//counting up by 2 would miss one at the end
		if (sortedArray[n - 2] != sortedArray[n - 1])
		{
			singleNum = sortedArray[n - 1];
		}
		return singleNum;
		//-1 if its not in there
	}	
	public static void main(String args[])
	{
		int myArray[] = {1, 1, 2, 2, 3, 3, 5};

		int answer = findTheSingle(myArray);
		System.out.println(answer);
	}
}
