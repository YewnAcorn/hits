/*
 * Partition
 * write a code for a linked list
 * that creates a partition around value x
 * such that all nodes less than x come before
 * all nodes greater than or equal to x
 * if x is contained within the list, the values
 * of x only need to be after the elements less
 * than x 
 * group members: Brianna, Winston
 * O(n) where n = size of original list
 */
import java.util.LinkedList;

public class Main
{
	public static void main(String args[])
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		LinkedList<Integer> bb = new LinkedList<Integer>();
		
		ll.add(1);
		ll.add(2);
		ll.add(7);
		ll.add(7);
		ll.add(5);
		ll.add(3);
		ll.add(4);
		ll.add(8);
		ll.add(9);
		
		//ll.sort(null);
		System.out.println(ll.toString());
		ll = partition(7, ll);
		System.out.println(ll.toString());
	}
	static LinkedList<Integer> partition(int x, LinkedList<Integer> ll)
	{
		LinkedList<Integer> left = new LinkedList<Integer>();
		LinkedList<Integer> right = new LinkedList<Integer>();

		for(int i = 0; i < ll.size(); ++i)
		{
			int current = ll.get(i);
			if (current < x)
			{
				left.add(current);
			}
			else if (current >= x)
			{
				right.add(current);
			}
		}
		
		left.addAll(right);
		return left;
	}


}
