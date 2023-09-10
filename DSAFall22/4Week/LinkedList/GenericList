public class LinksList<T>
{
	
	private GenericNode headNode;
	private GenericNode tailNode;
	private int size;

	public LinksList()
	{
		headNode = new GenericNode(-1, null);
		tailNode = headNode;
		size = 0;
	}	

	// clear the list
	public void clear()
	{
		headNode = new GenericNode(-1, null);
		tailNode = headNode;
		size = 0;
	}

	// add a tail at the end of the list
	public void add(int value)
	{
		GenericNode tempNode = new GenericNode(value);
		tailNode.insertAfter(tempNode);
		tailNode = tempNode;
		++size;
	}

	//add at index
	public void add(int index, T value)
	{
		if(0 <= index && index < size - 1)
		{
			GenericNode tempNode = new GenericNode(value);
			GenericNode findNode = this.findSpot(index);
			findNode.insertAfter(tempNode);
		}
	}

	// remove value at index
	public void remove(int index)
	{
		if(0 <= index && index < size - 1)
		{
			GenericNode beforeNode = headNode;
			for (int i = 0; i < index; ++i)
			{
				beforeNode = beforeNode.getNext();
			}
			beforeNode.removeAfter();
		}
	}
	public GenericNode findSpot(int index) 
	{
		GenericNode tempNode = headNode;
		for (int i = 0; i < index; ++i)
		{
			tempNode = tempNode.getNext();
		}
		return tempNode.getNext();
	}
	public int getSize()
	{
		return size;
	}

}
