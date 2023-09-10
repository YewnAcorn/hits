import java.util.LinkedList;

// A generic stack of type T
public class GenStack<T>
{
	int top = -1;
	LinkedList<T> newStack = new LinkedList<T>();

	public GenStack()
	{
		LinkedList<T> newStack = new LinkedList<T>();
	}
	
	//adds a string element to the end of the stack
	public void push(T s)
	{
		top++;
		newStack.add(top, s);
	}
	
	//returns the element off the end of the stack and deletes it
	public T pop()
	{
		T x = newStack.pop();
		top--;
		return x;
	
	}
	
	// returns the element off the end of the stack without deleting it
	public T peek()
	{
		T x = newStack.get(newStack.size() - 1);
		return x;
	}
	// clears the whole stack
	public void clear()
	{
		for (int i = 0; i < newStack.size(); ++i)
		{
			T x = newStack.get(i);
			x = null;
		}
		 top = -1;
	}
	
	//returns the index of the last in element
	public int top()
	{
		return top;
	}
	
	//returns true if the stack is empty
	public boolean isEmpty()
	{
		boolean x = true;
		if(top == -1)
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
