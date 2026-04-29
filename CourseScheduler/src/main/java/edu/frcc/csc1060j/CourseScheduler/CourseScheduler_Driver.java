package edu.frcc.csc1060j.CourseScheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class CourseScheduler_Driver
{

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("args is null");
			return;
		}
		
		String fileName = args[0];
		Graph<String> graph = loadFile(fileName);
		
		CourseScheduler courseSch = new CourseScheduler(graph);
		courseSch.topologicalSort();
	}

	// loadFile assumes a specific formatting
	public static Graph<String> loadFile(String fileName)
	{
		Graph<String> graph = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			line = reader.readLine();
			int graphSize = Integer.parseInt(line);

			graph = new Graph<>(graphSize);
			int index = 0;
			while ((line = reader.readLine()) != null)
			{
				if (line.trim().isEmpty())
				{
					continue;
				}

				String[] tokens = line.split(" ");
				if (tokens.length < 2)
				{
					continue;
				}

				graph.setValue(index, tokens[0]);
				index++;
			}

		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			return null;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			line = reader.readLine();

			int index = 0;
			while ((line = reader.readLine()) != null)
			{
				if (line.trim().isEmpty())
				{
					continue;
				}

				String[] tokens = line.split(" ");
				if (tokens.length < 2)
				{
					continue;
				}

				for (int i = 2; i < tokens.length; i++)
				{
					graph.insertEdge(tokens[0], tokens[i]);
				}
			}

			System.out.println("File Loaded");
			return graph;
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
