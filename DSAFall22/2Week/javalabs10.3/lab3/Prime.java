import java.util.Scanner;

public class Prime {

	public static int isPrime(int testVal, int divVal)
	{
		//base case 1: 0 and 1 are not prime, testVal is not prime
		if ((testVal == 1) || (testVal == 0))
		{
			return 0;
		}
		//base case 2: testVal is only divisible by 1, testVal is prime
		else if (divVal == 1)
		{	
			return 1;
		}

		//recursive case:
		//can testVal be evenly divided by divVal
		else if (testVal % divVal != 0)
		{
			return isPrime(testVal, divVal - 1);
			//if not, call recursion 
		}
		return 0;
	}		
	
}
