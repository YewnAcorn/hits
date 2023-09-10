import java.util.LinkedList;

// a class for a handmade dynamic stack using a linked list 
public class myStack
{
	int stackSize = 0;
	LinkedList<String> newStack = new LinkedList<String>();

	public myStack()
	{
		LinkedList<String> newStack = new LinkedList<String>();
	}
	
	//adds a string element to the end of the stack
	public void push(String s)
	{
		newStack.add(newStack.size(), s);
		stackSize++;
	}
	
	//returns the element off the end of the stack and deletes it
	public String pop()
	{
		String x = newStack.get(stackSize - 1);
		stackSize--;
		return x;
	}
	
	// returns the element off the end of the stack without deleting it
	public String peek()
	{
		String x = newStack.get(newStack.size() - 1);
		return x;
	}
	// clears the whole stack
	public void clear()
	{
		for (int i = 0; i < newStack.size(); ++i)
		{
			String x = newStack.get(i);
			x = null;
		}
		stackSize = 0;
	}
	
	//returns the number of elements in the stack
	public int count()
	{
		return stackSize;
	}
	
	//returns true if the stack is empty
	public boolean isEmpty()
	{
		boolean x = true;
		if(stackSize == 0)
		{
			x = true;
		}
		else
		{
			x = false;
		}
		return x;
	}

}
