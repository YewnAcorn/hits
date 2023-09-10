public class IntNode
{
	private int data;
	private IntNode nextNodePtr;
	
	public IntNode()
	{
		data = 0;
		nextNodePtr = null;
	}

	// constructor
	public IntNode(int value)
	{
		data = value;
		IntNode nextNodePtr = null;
	}

	// constructor
	public IntNode(int value, IntNode nextLoc)
	{
		this.data = value;
		this.nextNodePtr = nextLoc;
	}
	
	//get and set:
	public void setVal(int value)
	{
		data = value;
	}
	public int getVal()
	{
		return this.data;
	}

	//add and remove:
	
	/*
	 * Insert node after this node
	 * Before: this -- next
	 * After: this -- node -- next
	 */

	public void insertAfter(IntNode nodeLoc)
	{
		IntNode tempNext;

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
	
	// get location pointed to by nextNodePtr
	public IntNode getNext()
	{
		return this.nextNodePtr;
	}

	public void printNodeData()
	{
		System.out.println(this.data);
	}
}

