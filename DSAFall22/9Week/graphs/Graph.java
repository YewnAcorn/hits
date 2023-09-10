import java.util.*;

public class Graph
{
	
	
	public ArrayList<Edge> edgeList = new ArrayList<Edge>();
	public ArrayList<Vertex> vertexList =  new ArrayList<Vertex>();
	public Stack<Vertex> graphStack = new Stack<Vertex>();

	public void addVertex(String newLabel, int newData)
	{
		Vertex newVertex = new Vertex(newLabel, newData);
		vertexList.add(newVertex);

	}

	public void removeVertex(int index)
	{
		for(int i = edgeList.size()-1; i >= 0; --i)
		{
			if(edgeList.get(i).from == vertexList.get(index) || edgeList.get(i).to == vertexList.get(index) )
			{

				edgeList.remove(i);
			}
		}
		vertexList.remove(index);
	}
	public void addEdge(int from, int to, int weight, boolean biDirectional)
	{
		Edge newEdge = new Edge(vertexList.get(from), vertexList.get(to), weight, biDirectional);
		edgeList.add(newEdge);
		vertexList.get(to).inDegree++;

	}
	public void removeEdge(int index)
	{
		edgeList.get(index).to.inDegree--;
		edgeList.remove(index);
	}

	public void print()
	{
		for(int i = 0; i < vertexList.size(); ++i)
		{
			System.out.print("Vertex Label:\t" + vertexList.get(i).label);
			System.out.print("   Vertex Data:\t" + vertexList.get(i).data);

			for(int j = 0; j < edgeList.size(); ++j)
			{
				if(edgeList.get(j).from == vertexList.get(i))
				{
					System.out.print("   Connection:\t" + edgeList.get(j).to.label);
					System.out.print("   Weight:\t" + edgeList.get(j).weight);

				}
				if(edgeList.get(j).to == vertexList.get(i))
				{
					System.out.print("   Connection:\t" + edgeList.get(j).from.label);
					System.out.print("   Weight:\t" + edgeList.get(j).weight);
				}


			}
			System.out.println();
		}
	}
	
	public void pushToStack()
	{
		boolean noInEdge;

		for(int i = 0; i < vertexList.size(); ++i)
		{
			if(vertexList.get(i).inDegree == 0)
			{
				graphStack.push(vertexList.get(i));
				removeVertex(i);
			}
		}
	}
}
