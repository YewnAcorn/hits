public class BST
{
	public Node root;
	
	public void insert(int newData)
	{
		if(root == null)
		{
//			System.out.println("root " + newData);
			root = new Node();
			root.data = newData;
		}
		else
		{
//			System.out.println("Start: " + newData);
			root = insertSupport(root, newData);
		}
	}	

	private Node insertSupport(Node current, int newData)
	{
		if(current == null)
		{
//			System.out.println("Current Data: null"); 
		}
		else
		{
//			System.out.println("Current Data: " + current.data);
		}
		if(current == null)
		{
//			System.out.println("InsertNode " + newData);
			current = new Node();
			current.data = newData;
		}
		else
		{
			if(newData <= current.data)
			{
//				System.out.println("go left "+ newData);
				current.left = insertSupport(current.left, newData);
			}
			else
			{
//				System.out.println("go right " + newData);

				current.right = insertSupport(current.right, newData);
			}
		}
		return current;
	}

	public void deleteByValue(int searchData)
	{

		Node nodeToDelete = searchSupport(root, searchData);	
		Node parent = findParent(root, searchData);
		
		/*** code to delete non-leaves with only one child */
		if(nodeToDelete == parent.left)
		{	
			if(nodeToDelete.left != null)
			{
				parent.left = nodeToDelete.left;
			}
			else if(nodeToDelete.right != null)
			{
				parent.left = nodeToDelete.right;
			}
		}
		else if(nodeToDelete == parent.right)
		{
			if(nodeToDelete.left != null)
			{
				parent.right = nodeToDelete.left;
			}
			else if(nodeToDelete.right != null)
			{
				parent.right = nodeToDelete.right;
			}
		}

		/*** code to delete leaves *//*
		if(parent != null)
		{
			if(parent.left == nodeToDelete)
			{
				parent.left = null;
			}
			else if(parent.right == nodeToDelete)
			{
				parent.right = null;
			}
		}
		else
		{
			System.out.println("Nothing to delete");
		}
		*/

		//System.out.println(nodeToDelete.data);
		//System.out.println(parent.data);

		//System.out.println("parent: " + parent.data); 
		//System.out.println("child : " + child.data); 
		//System.out.println("left child : " + child.left.data); 
		//System.out.println("right child : " + child.right.data);
	}
	
	/* 
	 * Ways to traverse a tree:
	 * InOrder
	 * PreeOrder
	 * PostOrder
	 */

	//InOrder -  left child, parent, right child
	public void printInOrder()
	{
		printInOrderSupport(root);	
	}
	public void  printInOrderSupport(Node current)
	{
		if(current.left != null)
		{
			printInOrderSupport(current.left);
		}
		if(current != null)
		{
			System.out.println(current.data);
		}
		if(current.right != null)
		{
			printInOrderSupport(current.right);
		}

	}



	public void printPreOrder()
	{
		printPreOrderSupport(root);
	}
	

	// PreOrder is print left until there is no more left
	private void printPreOrderSupport(Node current)
	{

		if(current != null)
		{
			System.out.println(current.data);
		}

		if(current.left != null)
		{
			printPreOrderSupport(current.left);
		}

		if(current.right != null)
		{
			printPreOrderSupport(current.right);
		}

	}
	// PostOrder - left child, right child, parent
	public void printPostOrder()
	{
		printPostOrderSupport(root);

	}
	private void printPostOrderSupport(Node current)
	{
		if(current.left !=null)
		{
			printPostOrderSupport(current.left);
		}
		if(current.right != null)
		{
			printPostOrderSupport(current.right);
		}
		if(current != null)
		{
			System.out.println(current.data);
		}


	}
	public void search(int searchData)
	{
		System.out.println("searching " + searchData);
		System.out.println(searchSupport(root, searchData).data);
	}

	private Node searchSupport(Node current, int searchData)
	
	{
		if(current != null)
		{
			if(searchData == current.data)
			{
				return current;
			}
			else if(searchData <= current.data)
			{
				return searchSupport(current.left,  searchData);
			}
			else
			{
				return searchSupport(current.right, searchData);
			}
		}

		return null;
	}
	private Node findParent(Node current, int searchData)
	{
		if((current.left != null && current.left.data == searchData) || (current.right != null && current.right.data == searchData))
		{
			return current;
		}
		else
		{
			if(current.left != null && searchData <= current.data)
			{
				return findParent(current.left, searchData);
			}
			else if(current.right != null && searchData > current.data)
			{
				return findParent(current.right, searchData);
			}

		}
		return null;
	}
}
