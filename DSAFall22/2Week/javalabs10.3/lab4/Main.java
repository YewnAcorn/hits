import java.util.Scanner;

//String reverser
public class Main
{
	public static void main(String args[])
	{
		String userString;
		String reverseString;
		Scanner scnr = new Scanner(System.in);
		int l;

		System.out.println("Enter string to be reversed: ");
		userString = scnr.nextLine();
		
		l = userString.length();
		int limit = l - 1;
		char reversed[] = new char[l];

		for (int i = 0; i < l; ++i)
		{
			reversed[i] = userString.charAt(limit - i);
		}

		//reverseString = reversed.toString();
		//System.out.println(reverseString);
		for (int j = 0; j < l; ++j)
		{
			System.out.print(reversed[j]);
		}

		System.out.println();
	}
}	
