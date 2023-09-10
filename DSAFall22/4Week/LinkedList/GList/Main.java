public class Main
{
	public static void main(String args[])
	{
		GenericList<Integer> intList = new GenericList<Integer>();
		GenericList<Character> charList = new GenericList<Character>();
		GenericList<Float> floatList = new GenericList<Float>();

		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);

		intList.printList();
	}
}
