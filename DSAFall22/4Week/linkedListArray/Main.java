/*
 * given a linked list of elements
 * and an array of elements
 * delete elements that are found in
 * the array */
 
import java.util.LinkedList;

public class Main
{
	public static void main(String args[])
	{
		LinkedList<Character> ll = new LinkedList<Character>();
		char bb[] = new char[2];

		ll.add('x');
		ll.add('a');
		ll.add('b');
		ll.add('c');
		ll.add('d');
		ll.add('e');

		bb[0] = 'x';
		bb[1] = 'a';

		for (int j = 0; j < bb.length; ++j)
		{
			if(ll.contains(bb[j]))
			{
				ll.removeFirstOccurrence(bb[j]);
			}
		}

		System.out.println(ll.toString());
	}
}
