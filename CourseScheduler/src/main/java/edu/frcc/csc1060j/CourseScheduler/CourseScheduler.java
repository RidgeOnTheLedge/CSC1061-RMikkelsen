package edu.frcc.csc1060j.CourseScheduler;

import java.util.Stack;

// This class contains the components used in the topological sort
// The topological sort is Depth First Search
public class CourseScheduler
{
	Graph<String> graph;
	boolean[] visited;
	boolean[] inStack;
	Stack<String> stack;
	boolean[][] matrix;

	public CourseScheduler(Graph<String> graph)
	{
		this.graph = graph;
		visited = new boolean[graph.getSize()];
		inStack = new boolean[graph.getSize()];
		stack = new Stack<>();
		matrix = graph.getMatrix();
	}
	
	public boolean topologicalSort()
	{
		boolean valid = true;
		for (int i = 0; i < visited.length; i++)
		{
			if (!visited[i])
			{
				if (!DFS(i))
				{
					valid = false;
				}
			}
		}

		if (valid)
		{
			System.out.println("first = last prerequisite \nlast = earliest prerequisite");
			while (!stack.isEmpty())
			{
				System.out.println(stack.pop());
			}
		} else
		{
			System.out.println("No topological ordering");
		}

		return valid;
	}

	private boolean DFS(int row)
	{		
		// Prevent revisited nodes
		visited[row] = true;
		
		// Used to check for if topological ordering is invalid
		inStack[row] = true;

		for (int column = 0; column < matrix[row].length; column++)
		{
			if (matrix[row][column]) // matrix is true 
			{
				if (!visited[column]) // 
				{
					//column is used to get the next row
					if (!DFS(column)) 
					{
						return false;
					}
				} else if (inStack[column])
				{
					return false;
				}

			}
		}

		inStack[row] = false;

		stack.push(graph.getValue(row));
		return true;
	}
}
