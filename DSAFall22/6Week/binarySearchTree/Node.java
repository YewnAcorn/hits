public class Node
{
	public String data;
	public Node left;
	public Node right;

	//constructor
	public Node()
	{
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public Node(String s)
	{
		this.data = s;
		this.left = null;
		this.right = null;
	}
	
	public void setVal(String s)
	{
		data = s;
	}
	public String getVal()
	{
		return this.data;
	}
	
}
