public class Main
{
	public static void main(String args[])
	{
		Graph newGraph = new Graph();

		newGraph.addVertex("A", 100);
		newGraph.addVertex("B", 200);
		newGraph.addVertex("C", 300);

		newGraph.addEdge(0, 1, 1, false);
		newGraph.addEdge(1, 2, 1, false);
		newGraph.addEdge(0, 2, 1, false);

		newGraph.print();
/*
		for(int i = 0; i < newGraph.edgeList.size(); ++i)
		{
			System.out.println("**********");	
			System.out.println(newGraph.edgeList.get(i).from.data);
			System.out.println(newGraph.edgeList.get(i).to.data);
		}
		
		newGraph.removeVertex(1);

		System.out.println("****DELETE*****");

		for(int i = 0; i < newGraph.edgeList.size(); ++i)
		{	
			System.out.println("**********");	
			System.out.println(newGraph.edgeList.get(i).from.data);
			System.out.println(newGraph.edgeList.get(i).to.data);
		}
*/
	}
}
