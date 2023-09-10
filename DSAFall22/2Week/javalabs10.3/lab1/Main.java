import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		String userString;
		char userChar;
		int count = 0;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		userString = scnr.nextLine();

		System.out.println("Enter a character:" );
		userChar = scnr.next().charAt(0);
		
		for (int i = 0; i < userString.length(); i++)
		{
			if (userString.charAt(i) == userChar)
			{
				count++;
			}
		}
		System.out.println("number of times " + userChar + " occurs in " + 
		userString + ": " + count);
	}
}
