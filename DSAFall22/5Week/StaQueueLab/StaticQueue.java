public class StaticQueue
{
	private String[] queue;
	private int capacity;
	private int head;
	private int tail;

	StaticQueue(int initCapacity)
	{
		capacity = initCapacity;
		queue = new String[capacity];
		head = tail = 0;
	}

	public void enqueue(String newData)
	{
		if(queue[tail] == null)
		{
			queue[tail] = newData;
			tail++;
		
			if(tail >= capacity)
			{
				tail = 0;
			}
		}
		else
		{
			System.out.println("Queue is full.");
		}
	}

	public String dequeue()
	{
		String temp = null;

		if(queue[head] != null)
		{
			temp = queue[head];
			queue[head] = null;
			++head;
		

			if (head>= capacity)
			{
				head = 0;
			}
		}
		else
		{
			System.out.println("Queue is empty");
		}
		return temp; 
	}
	public void clear()
	{

		for(int i = 0 ; i < capacity; ++i)
		{
			queue[i] = null;
			head = tail = 0;
		}
	

	}

	public int returnHead()
	{
		return head;
	}

	public int returnTail()
	{
		return tail;
	}
	
	public boolean isEmpty()
	{
		return(head == tail && queue[head] == null);
	}
}

