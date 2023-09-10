import java.util.LinkedList;
/*
 * remove duplicates 
 * CII test question
 * write a program to
 * take an unsorted linked list
 * and remove any duplicates
 * how would you solve the problem
 * if a temporary buffer is not allowed
 *
 */

public class Main
{
	public static void main(String args[])
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);
		ll.add(1);
		ll.add(5);
		ll.add(5);
		ll.add(4);
		ll.add(3);
		ll.add(2);
		ll.add(2);
		ll.add(2);
		ll.add(1);
		ll.add(4);
		ll.add(2);
		int count = 0;
		for(int i = 0; i < ll.size(); ++i)
		{
			System.out.println(ll.get(i));
		}
		for(int i = 0; i < ll.size(); ++i)
		{
			int x = ll.get(i);
			if(ll.indexOf(x) != ll.lastIndexOf(x))
			{
				System.out.println("Removing: " + x + " at index: " + ll.lastIndexOf(x));
				ll.remove(ll.lastIndexOf(x));
				--i;
			}
				
		}
		for(int i = 0; i < ll.size(); ++i)
		{
			System.out.println(ll.get(i));
		}
	}
}



