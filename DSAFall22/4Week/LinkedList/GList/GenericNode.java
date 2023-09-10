public class GenericNode<T>
{
	private T data;
	private GenericNode nextNodePtr;
	
	public GenericNode()
	{
	
		nextNodePtr = null;
	}

	// constructor
	public GenericNode(T value)
	{
		data = value;
		GenericNode nextNodePtr = null;
	}

	// constructor
	public GenericNode(T value, GenericNode nextLoc)
	{
		this.data = value;
		this.nextNodePtr = nextLoc;
	}
	
	//get and set:
	public void setVal(T value)
	{
		data = value;
	}
	public T getVal()
	{
		return this.data;
	}

	//add and remove:
	
	/*
	 * Insert node after this node
	 * Before: this -- next
	 * After: this -- node -- next
	 */

	public void insertAfter(GenericNode nodeLoc)
	{
		GenericNode tempNext;

		tempNext = this.nextNodePtr;
		this.nextNodePtr = nodeLoc;
		nodeLoc.nextNodePtr = tempNext;
	}

	/*
	 * Remove node after this node
	 * Before: this -- node -- next
	 * After: this -- next
	 * 	or at the tail of the list
	 * Before: this -- null
	 * After: this -- null
	 */

	public void removeAfter()
	{
		if (this.nextNodePtr != null)
		{
			this.nextNodePtr =  this.getNext().getNext();
		}
	}
	
	// get location poTed to by nextNodePtr
	public GenericNode getNext()
	{
		return this.nextNodePtr;
	}

	public void printNodeData()
	{
		System.out.println(this.data);
	}
}

