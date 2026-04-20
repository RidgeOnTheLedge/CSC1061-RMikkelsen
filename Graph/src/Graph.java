import java.util.ArrayList;
import java.util.List;

public class Graph<K, E>
{
	private List<Vertex> vertices = new ArrayList();
	
	class Vertex
	{
		protected K key;
		protected List<Edge> neighbors = new ArrayList();
		
		public Vertex(K key)
		{
			this.key = key;
		}
		
		@Override
		public String toString()
		{
			return key.toString();
		}
	}
	
	private class Edge
	{
		protected E data;
		protected Vertex src;
		protected Vertex dst;
		
		
		public Edge()
		{
		}
		
		
		public boolean equals(Object other)
		{
			if(other == null || !(other instanceof Graph.Edge))
			{
				return false;
			}
			Edge oEdge = (Edge)other;
			if(src.equals(oEdge.src) && dst.equals(oEdge.dst))
			{
				return true;
			}
			
			return false;
		}
	}
	
	public boolean addVertex(K key)
	{
		Vertex newVertex = new Vertex(key);
		if(vertices.contains(newVertex))
		{
			return false;
		}
		vertices.add(newVertex);
		return true;
	}
	
	public boolean addEdge(K src, K dst, E edgeData)
	{
		Edge newEdge = new Edge();
		
		newEdge.src = findVertex(src);
		newEdge.dst = findVertex(dst);
		newEdge.data = edgeData;
		
		if(newEdge.src.neighbors.contains(newEdge))
		{
			return false;
		}
		newEdge.src.neighbors.add(newEdge);
		return true;
	}
	
	private Edge findEdge()
	{
		
	}
	
	public Vertex findVertex(K src)
	{
		int indexOfVertex = vertices.indexOf(new Vertex(key));
		if(indexOfVertex < 0)
		{
			return null;
		}
		return vertices.get(indexOfVertex);
	}
	
	public void print()
	{
				
	}
	
}
