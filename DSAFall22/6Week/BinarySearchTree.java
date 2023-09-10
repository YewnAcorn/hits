import java.util.LinkedList;
public class BinarySearchTree
{
	TreeNode root;
	TreeNode rightNode;
	TreeNode leftNode;
	int height;
	LinkedList<Double> treebeard;
	public BinarySearchTree()
	{
		treebeard = new LinkedList<Double>();
		root = new TreeNode(1.5);
		height = 0;
		System.out.println("constructing..");
	}
	
	public void setRoot(double data)
	{
		root.set(data);
	}
	
	public void add(double d)
	{
		
		System.out.println("adding " + d);
		if(root.get() < d)
		{
			if(root.getRightNode() == null)
			{
				root.setRight(d);
				rightNode = root.getRightNode();
				height++;
				System.out.println("adding " + d + " to the right at height " + height);
				
			}
			else
			{
				TreeNode temp = root;
				root = root.getRightNode();
				this.add(d);
				root = temp;
				System.out.println("right side full, going to next height: " + height + 1);
			}
		}
		if(root.get() >= d)
		{
			if(root.getLeftNode() == null)
			{
				root.setLeft(d);
				leftNode = root.getLeftNode();
				height++;
				System.out.println("adding " + d + " to the left at height " + height);
			}
			else
			{
				TreeNode temp = root;
				root = root.getLeftNode();
				this.add(d);
				root = temp;
				System.out.println("left side full, going to next height: " + height + 1);
			
			}
		}
	}
	public LinkedList<Double> harvest()
	{
		LinkedList<Double> out = new LinkedList<Double>();
		out.add(root.get());
		while((root.getLeftNode() != null) || (root.getRightNode() != null))

		{
			out.add(root.getLeft());
			out.add(root.getRight());
			for(int i = 0; i < height; i++)
			{
				for(int j = 0; j < 1; j++)
				{
					if(j == 0 && root.getLeftNode() != null)
					{
						root = root.getLeftNode();
						this.harvest();
					}
					else if(j == 1 && root.getRightNode() != null)
					{
						root = root.getRightNode();
						this.harvest();
					}
				}
			}
		}
		this.treebeard = out;
		return out;
	}

	public void printTree()
	{
		this.harvest();
		for(int i = 0; i < treebeard.size(); i++)
		{
			double x = treebeard.get(i);
			System.out.println(x);
		}

	}
}
	

