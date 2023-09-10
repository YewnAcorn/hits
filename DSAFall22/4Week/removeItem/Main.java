/*
 * Remove item
 * remove an item from a linked list
 * without knowing the head node
 *
 * worked with Brianna and Winston
 *
 */

import java.util.LinkedList;

public class Main
{
	public static void main(String args[])
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1); //head node (unknown)
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5); //remove this node
		ll.add(6);
		
		ll.removeFirstOccurrence(5);
		System.out.println(ll.toString());
	}
}
