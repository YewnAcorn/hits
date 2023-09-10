/*
I supposed to make a queue using a stack or two?

stack is FILO
fist in last out

queue is FIFO

stack 1:[HEAD] [PUSH1] [PUSH2]
stack 2:[PUSH2][PUSH1][HEAD]
			^
queue:                 <First out>

ok I got it all the items get pushed to stack one, then popped to stack two
once they get popped out of stack two, they are in the right order, so 
return stack2.pop()
*/

public class Queuethulu<T>
{
	private GenStack<T> stackIn;
	private GenStack<T> stackOut;
	private int size;
	public Queuethulu()
	{
		stackIn = new GenStack<T>();
		stackOut = new GenStack<T>();
		size = 0;
	}
	
	public void enqueue(T obj)
	{
		stackIn.push(obj);
		size++;
	}
	public T dequeue()
	{
		stackOut.clear();
		while(!(stackIn.isEmpty()))
		{
			stackOut.push(stackIn.pop());
		}
		T temp =  stackOut.pop();
		while(!(stackOut.isEmpty()))
		{
			stackIn.push(stackOut.pop());
		}
		return temp;
		
	}
}

		
