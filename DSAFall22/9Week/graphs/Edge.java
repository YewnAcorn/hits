public class Edge
{
	public Vertex from, to;
	public int weight;
	boolean biDirectional;	

	public Edge(Vertex initFrom, Vertex initTo, int initWeight, boolean initBiDirectional)
	{
		from = initFrom;
		to = initTo;
		weight = initWeight;
		biDirectional = initBiDirectional;

	}


}


