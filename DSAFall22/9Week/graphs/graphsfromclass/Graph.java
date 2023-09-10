import java.util.*;

public class Graph
{
	public ArrayList<Edge> edgeList = new ArrayList<Edge>();
	public ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	
	public void addVertex(int newData)
	{
		Vertex newVertex = new Vertex(newData);
		vertexList.add(newVertex);
	}
	
	public void removeVertex(int index)
	{

		for(int i = 0; i < edgeList.size(); i++)
		{
			if( edgeList.get(i).from == vertexList.get(index) || edgeList.get(i).to == vertexList.get(index)  )
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
	}
	
	public void removeEdge(int index)
	{
		edgeList.remove(index);
	}
}