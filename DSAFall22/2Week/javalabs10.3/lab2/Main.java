import java.util.Scanner;

public class Main {

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
	public static void main(String args[])
	{
		Scanner scnr = new Scanner(System.in);
		int num; 	

		System.out.println("Enter an integer to see if it is prime: ");
		num = scnr.nextInt();
		
		if(isPrime(num, (num - 1)) == 1)
		{
			System.out.println(num + " is prime!");
		}
		else
		{
			System.out.println(num + " is not prime");
		}
	}
}
