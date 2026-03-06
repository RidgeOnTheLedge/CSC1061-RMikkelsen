package edu.frcc.csc1061j.BookTree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BookTree implements Iterable<BookNode>
{
	private BookNode root;

	public BookTree(String title)
	{
		root = new BookNode(title, 0, 0, 0);
	}

	public boolean addBookNode(String title, int chapNum, int secNum, int subSecNum)
	{
		BookNode node = new BookNode(title, chapNum, secNum, subSecNum);

		// This is a chapter
		if (secNum == 0)
		{
			root.getChildNodes().add(node);
			Collections.sort(root.getChildNodes());
			return true;
		}

		// This is a section node
		if (subSecNum == 0)
		{
			for (BookNode chapter : root.getChildNodes())
			{
				if (chapter.getChapNum() == chapNum)
				{
					chapter.getChildNodes().add(node);
					Collections.sort(chapter.getChildNodes());
					return true;
				}
			}
		}

		// This is the subsection node
		for (BookNode chapter : root.getChildNodes())
		{
			if (chapter.getChapNum() == chapNum)
			{
				for (BookNode section : chapter.getChildNodes())
				{
					if (section.getSecNum() == secNum)
					{
						section.getChildNodes().add(node);
						Collections.sort(section.getChildNodes());
						return true;
					}
				}
			}
		}

		return false;
	}

	/*
	 * @Override public Iterator<BookNode> iterator() {
	 * 
	 * return new Iterator<BookNode>() {
	 * 
	 * @Override public BookNode next() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * @Override public boolean hasNext() { // TODO Auto-generated method stub
	 * return false; } }; }
	 */

	public Iterator<BookNode> iterator()
	{
		return new BookIterator();
	}

	private class BookIterator implements Iterator<BookNode>
	{
		Deque<BookNode> stack;

		public BookIterator()
		{
			stack = new ArrayDeque<>();
			stack.push(root);
		}

		@Override
		public boolean hasNext()
		{
			return !stack.isEmpty();
		}

		@Override
		public BookNode next()
		{
			BookNode node = stack.pop();

			List<BookNode> children = node.getChildNodes();
			List<BookNode> copy = new ArrayList<>(children);

			// Reverse the copy list
			Collections.reverse(copy);

			for (BookNode child : copy)
			{
				stack.push(child);
			}
			
			return node;
		}

	}

}
