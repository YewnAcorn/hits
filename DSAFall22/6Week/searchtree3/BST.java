public class BST
{
	public Node root;
	
	public void insert(int newData)
	{
		Node current;
		Node next;

		if(root == null)
		{
			root = new Node();
			root.data = newData;
			System.out.println("root: " + newData);
		}
		else 
		{
			current = root;
			next = root;

			while(current != null)
			{
				if(newData <= current.data)
				{
					current = current.left;
				}
				else
				{
					current = current.right;
				}
			}
			current.data = newData;
			System.out.println("Added: " + newData);
		}

	}
}
