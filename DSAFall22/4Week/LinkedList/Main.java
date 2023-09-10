public class Main
{
	public static void main(String args[])
	{
		LinksList myList = new LinksList();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(7);
		myList.add(8);
		myList.add(9);

		for(int i = 0; i < myList.getSize(); ++i)
		{
			IntNode tempNode;
			tempNode = myList.findSpot(i);
			tempNode.printNodeData();
	
		}
	}
}

