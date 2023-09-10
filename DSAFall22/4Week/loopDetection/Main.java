/*
 * loop detection
 * make a prgram to detect the head node
 * of a circular linked list
 * group: Brianna and Winston
 */

import java.util.LinkedList;

public class Main
{
	public static void main(String args[])
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int x = 1;
		ll.add(x);		
		ll.add(2);		
		ll.add(3);		
		ll.add(4);		
		ll.add(5);		
		ll.add(6);		
		ll.add(7);		
		ll.add(8);
		ll.addLast(x);

		System.out.println(ll.toString());
	}
}	
		
