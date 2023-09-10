/*
 * Palindrome
 * a CCI test problem
 * implement a function to check
 * if a given signgly linked list
 * is a palindrome
 *
 */
import java.util.LinkedList;

public class Main
{
	public static void main(String args[])
	{
		LinkedList<Character> ll = new LinkedList<Character>();
		ll.add('r');	
		ll.add('a');	
		ll.add('c');	
		ll.add('e');	
		ll.add('c');	
		ll.add('a');	
		ll.add('r');	
		

		boolean answer = palindrome(ll);
		if(answer)
		{
			System.out.println("it is a palindrome");
		}
		else
		{
			System.out.println("not a palindrome");	
		}
	}
	
	public static boolean palindrome(LinkedList<Character> input)
	{
		boolean isPalindrome = false;

		for (int i = 0; i < input.size(); ++i)
		{
			if(input.get(i) == input.get(input.size() - 1 - i))
			{
				isPalindrome = true;
			}
			else
			{
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

}
