import java.util.LinkedList;
//this is a handmade dynamic queue using a linked list
public class myQueue
{
	private LinkedList<Integer> queue;
	private int size;
	public myQueue()
	{
		queue = new LinkedList<Integer>();
		size = 0;
	}


	//add a new element to the back of the queue
	public void enqueue(int newElement)
	{
		queue.add(queue.size(), newElement);
		size++;
	}
	//return the first element in the queue and remove it
	public int dequeue()
	{
		int temp = queue.get(0);
		queue.remove(0);
		size--;
		return temp;
	}

	//return the first element in the queuue and dont remove it
	public int peek()
	{
		int temp = queue.get(0);
		return temp;
	}
	//returns current size of queue
	public int size()
	{
		return size;
	}
}

