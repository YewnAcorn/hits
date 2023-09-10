import java.util.LinkedList;

public class TreeNode
{
	double data;
	TreeNode leftChild;
	TreeNode rightChild;

	public TreeNode()
	{
		this.data = 0.0;
	}
	public TreeNode(double d) 
	{
		this.data = d;
	}	
	public void set(double d)
	{
		this.data = d;
	}

	public double get()
	{
		return this.data;
	}
	
	public void setLeft(double d)
	{
		this.leftChild = new TreeNode(d);
	}

	public void setRight(double d)
	{
		this.rightChild = new TreeNode(d);
	}
	public double getLeft()
	{
		return this.leftChild.data;
	}
	public double getRight()
	{
		return this.rightChild.data;
	}
	public TreeNode getLeftNode()
	{
		return this.leftChild;
	}
	public TreeNode getRightNode()
	{
		return this.rightChild;
	}


}
