/*
 * Do they intersect?
 * A CCI test question
 * create a program to test
 * to see if two linked lists
 * have an intersection
 *
 */


import java.util.LinkedList;

public class Main
{
	public static void main(String[] args)
	{
		LinkedList<Character> ll = new LinkedList<Character>();
		LinkedList<Character> bb = new LinkedList<Character>();
		

		ll.add('a');
		ll.add('b');
		ll.add('c');
		ll.add('d');
		ll.add('e');
		
		bb.add('z');
		bb.add('y');
		bb.add('x');
		bb.add('w');
		bb.add('v');

		Character j = new Character('j');

		ll.add(j);
		bb.add(j);


	}

}
