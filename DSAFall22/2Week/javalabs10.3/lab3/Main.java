import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	public static void main(String args[])
	{
		int num;
		ArrayList<Integer> primes = new ArrayList<Integer>(1);
		int i = 2;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("How many prime numbers do you want to see?");

		num = scnr.nextInt();
		
		System.out.println("Ok I'll show you " + num +" prime numbers, cause you asked so nice");

		while (primes.size() < num)
		{
			if (Prime.isPrime(i, i - 1) == 1)
			{
				primes.add(i);
			}
		++i;
		}
		for (int j = 0; j < primes.size(); ++j)
		{
			int primeNum = primes.get(j);
			System.out.println(primeNum);
		}

	}
}

