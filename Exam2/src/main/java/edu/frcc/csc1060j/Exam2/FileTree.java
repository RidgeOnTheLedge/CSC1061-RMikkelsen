package edu.frcc.csc1060j.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FileTree implements Iterable<FileNode>
{

	private FileNode root;

	public FileTree(String path)
	{
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator
	 */
	@Override
	public Iterator<FileNode> iterator()
	{
		return new DepthFirstIterator();
	}

	/**
	 * TODO for Exam 2 Use recursion to build the tree from the directory structure.
	 * For each of node starting from the root node use listFiles() from File to get
	 * the list of files in that directory/folder. Create a node for each of the
	 * files and add it to a list of child nodes for the node Do this recursively
	 * for all the nodes.
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode)
	{
		File file = fileNode.getFile();
		if (!file.isDirectory())
		{
			return;
		}

		File[] files = file.listFiles();

		if (files == null)
		{
			return;
		}

		for (int i = 0; i < files.length; i++)
		{
			FileNode node = new FileNode(files[i]);
			fileNode.getChildNodes().add(node);
			buildTree(node);
		}
	}

	/**
	 * TODO for Exam 2 Iterator that does a post order traversal of the tree. For
	 * post-order traversal use the 2 stack approach outlined here:
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return
	 */
	private class DepthFirstIterator implements Iterator<FileNode>
	{
		Stack<FileNode> stack1 = new Stack<>();
		Stack<FileNode> stack2 = new Stack<>();

		public DepthFirstIterator()
		{
			depthFirst(root);
		}

		@Override
		public boolean hasNext()
		{
			return !stack2.isEmpty();
		}

		@Override
		public FileNode next()
		{
			return stack2.pop();
		}

		private void depthFirst(FileNode node)
		{
			stack1.push(node);

			while (!stack1.isEmpty())
			{
				FileNode removed = stack1.pop();
				stack2.push(removed);

				List<FileNode> children = removed.getChildNodes();
				for (int i = 0; i < children.size(); i++)
				{
					stack1.push(children.get(i));
				}
			}

		}
	}

	/**
	 * Returns an iterator that does a breadth first traversal of the tree using a
	 * queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator()
	{

		return new BreadthFirstIterator();

	}

	/**
	 * TODO for Exam 2 Iterator that does a breadth first traversal of the tree
	 * using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode>
	{
		Queue<FileNode> queue = new LinkedList<>();

		public BreadthFirstIterator()
		{
			queue.add(root);
		}

		@Override
		public boolean hasNext()
		{
			return !queue.isEmpty();
		}

		@Override
		public FileNode next()
		{
			FileNode current = queue.poll();
			for (FileNode child : current.getChildNodes())
			{
				queue.add(child);
			}
			
			return current;
		}
	}
}
