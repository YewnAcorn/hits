public class Main
{
	public static void main(String args[])
	{
		BST theTree = new BST();
		
		theTree.insert(10);
		theTree.insert(5);
		theTree.insert(15);
		theTree.insert(2);
		theTree.insert(7);
		theTree.insert(12);
		theTree.insert(16);
		System.out.println("in order: ");
		theTree.printInOrder();
		System.out.println("pre order: ");
		theTree.printPreOrder();
		System.out.println("post order: ");
		theTree.printPostOrder();

		
		theTree.search(5);
		theTree.deleteByValue(5);
		theTree.printInOrder();
	}
}

