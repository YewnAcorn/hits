import java.util.Scanner;

public class Main
{
	public static void revString(String original)
	{
		String s[] = original.split(" ");
		String reverse = "";
		
		for (int i = 0; i < s.length; ++i)
		{
			reverse = s[i] + " " + reverse;
		}	
		System.out.println(reverse);
	}
	// I was stuck on this one so I looked up help online and
	// found another way to do it that uses recursion
	// which I thought was cool and will reproduce here 
	// for coolness sake
	
	public static String recursiveString(String original)
	{
		int x = original.indexOf(" ");

		// base case
		if(x == -1)
		{
			return original;
		}
		// recursive call
		return recursiveString(original.substring(x+1)) + " " + original.substring(0, x);
	}
	public static void main(String args[])
	{
		String myString = "Hello people welcome to the computer";
		revString(myString);
		String otherString = recursiveString(myString);
		System.out.println(otherString);
	}
}
