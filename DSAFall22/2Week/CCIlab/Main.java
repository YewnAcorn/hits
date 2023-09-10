// carter Briana Michael
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static boolean charChecker(String inputString)
	{
		ArrayList<Character> uniques = new ArrayList<Character>();
		for (int i = 0; i < inputString.length(); ++i)
		{
			if (!(uniques.contains(inputString.charAt(i))))
			{
				uniques.add(inputString.charAt(i));
			}
			else if(uniques.contains(inputString.charAt(i)))
			{
				return false;
			}
				
		}
		return true;
	}
	public static boolean isPermutation(String firstString, String secondString)
	{		
		int fs = firstString.length();
		int s = secondString.length();
		
		if (fs != s)
		{
			return false;
		}


		char[] firstChars = new char[fs]; 
		char[] secondChars = new char[s];
		
		for (int i = 0; i < fs; ++i)
		{
			firstChars[i] = firstString.charAt(i);
		}
		for (int i = 0; i < s; ++i)
		{
			secondChars[i] = secondString.charAt(i);
		}
		
			

		Arrays.sort(firstChars);
		Arrays.sort(secondChars);
		

		if(firstString.length() != secondString.length())
		{
			System.out.println("not even close");
			return false;
		}
		for (int i = 0; i < firstString.length(); ++i)
		{
			if (!(firstChars[i] == secondChars[i]))
			{
				System.out.println("not a permutation");
				return false;
			}
		}
		System.out.println("is a permutation");
		return true;

		

	}
	public static void main(String args[])
	{
		String ourString;
		System.out.println("Enter a string: ");
		Scanner scnr = new Scanner(System.in);
		ourString = scnr.nextLine();
		/* if (charChecker(ourString))
		{
			System.out.println("yes, all uniques");
		}
		else
		{
			System.out.println("no, repeat characters");
		}
		*/


		System.out.println("Enter another string: ");
		String otherString = scnr.nextLine();
		if(isPermutation(ourString, otherString))
		{
			System.out.println("yes its a permutation");
		}
		else
		{
			System.out.println("no its not a permutation");
		}

	}
}
