package edu.frcc.csc1060j.SpellChecker;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MyTreeSet<E extends Comparable<E>> implements Set<E>
{
	private Node root = null;
	private int size = 0;
	private List<Node> path = new ArrayList<>();

	private class Node
	{
		protected E data;
		protected Node lChild;
		protected Node rChild;
		protected int height;

		public Node(E data)
		{
			this.data = data;
		}
	}

	public int getTreeHeight()
	{
		// Check if root exists, if not return -1 	
		return (root == null) ? -1 : root.height;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public boolean add(E e)
	{
		path.clear();
		if (root == null)
		{
			root = new Node(e);
			size++;
			return true;
		}

		Node current = root;
		Node parent = null;

		while (current != null)
		{
			path.add(current);
			if (e.compareTo(current.data) < 0)
			{
				parent = current;
				current = current.lChild;
			} else if (e.compareTo(current.data) > 0)
			{
				parent = current;
				current = current.rChild;
			} else // No repeat Data! 0_0
			{
				return false;
			}
		}

		Node newNode = new Node(e);
		if (e.compareTo(parent.data) > 0)
		{
			parent.rChild = newNode;
		} else
		{
			parent.lChild = newNode;
		}

		size++;

		balancePath();
		return true;
	}

	@Override
	public Iterator<E> iterator()
	{
		return new InOrder();
	}

	private class InOrder implements Iterator<E>
	{
		private Queue<E> queue = new ArrayDeque<>();

		public InOrder()
		{
			inorder(root);
		}

		private void inorder(Node node)
		{
			if (node == null)
			{
				return;
			}

			inorder(node.lChild);
			queue.add(node.data);
			inorder(node.rChild);

		}

		@Override
		public boolean hasNext()
		{
			return !queue.isEmpty();
		}

		@Override
		public E next()
		{
			return queue.remove();
		}

	}

	private void updateHeight(Node node)
	{
		node.height = Math.max(height(node.lChild), height(node.rChild)) + 1;
	}
	private int height(Node n)
	{
		return (n == null) ? -1: n.height;
	}

	private int balanceFactor(Node node)
	{
		int balanceFactor = 0;
		if (node.rChild == null && node.lChild == null)
		{
			return 0;
		} else if (node.rChild == null)
		{
			balanceFactor = (-1) - node.lChild.height;
		} else if (node.lChild == null)
		{
			balanceFactor = node.rChild.height - (-1);
		} else
		{
			balanceFactor = node.rChild.height - node.lChild.height;
		}

		return balanceFactor;
	}

	private void balancePath()
	{
		for (int i = path.size() - 1; i >= 0; i--)
		{
			Node current = path.get(i);
			updateHeight(current);

			Node parent = null;
			if (i > 0)
			{
				parent = path.get(i - 1);
			}

			int balanceFactor = balanceFactor(current);

			switch (balanceFactor) {
			case -2:
				if (balanceFactor(current.lChild) <= 0)
				{
					balanceLL(current, parent);
				} else
				{
					balanceLR(current, parent);
				}
				break;
			case 2:
				if (balanceFactor(current.rChild) >= 0)
				{
					balanceRR(current, parent);
				} else
				{
					balanceRL(current, parent);
				}
				break;
			}

		}

	}

	private void balanceRR(Node node, Node parent)
	{
		Node ggp = parent;
		Node gp = node;
		Node par = node.rChild;

		if (gp == root)
		{
			root = par;
		} else
		{
			if (ggp.lChild == gp)
			{
				ggp.lChild = par;
			} else
			{
				ggp.rChild = par;
			}
		}

		gp.rChild = par.lChild;
		par.lChild = gp;
		
		updateHeight(gp);
		updateHeight(par);
	}

	private void balanceLL(Node node, Node parent)
	{
		Node ggp = parent;
		Node gp = node;
		Node par = node.lChild;

		if (gp == root)
		{
			root = par;
		} else
		{
			if (ggp.lChild == gp)
			{
				ggp.lChild = par;
			} else
			{
				ggp.rChild = par;
			}
		}

		gp.lChild = par.rChild;
		par.rChild = gp;

		updateHeight(gp);
		updateHeight(par);
	}

	private void balanceLR(Node node, Node parent)
	{
		Node ggp = parent;
		Node gp = node;
		Node par = gp.lChild;
		Node child = par.rChild;

		if (gp == root)
		{
			root = child;
		} else
		{
			if (ggp.lChild == gp)
			{
				ggp.lChild = child;
			} else
			{
				ggp.rChild = child;
			}
		}

		gp.lChild = child.rChild;
		par.rChild = child.lChild;

		child.lChild = par;
		child.rChild = gp;

		updateHeight(par);
		updateHeight(gp);
		updateHeight(child);
	}

	private void balanceRL(Node node, Node parent)
	{
		Node ggp = parent;
		Node gp = node;
		Node par = gp.rChild;
		Node child = par.lChild;

		if (gp == root)
		{
			root = child;
		} else
		{
			if (ggp.lChild == gp)
			{
				ggp.lChild = child;
			} else
			{
				ggp.rChild = child;
			}
		}

		gp.rChild = child.lChild;
		par.lChild = child.rChild;

		child.lChild = gp;
		child.rChild = par;

		updateHeight(par);
		updateHeight(gp);
		updateHeight(child);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object obj)
	{
		E value = (E) obj;
		
		Node node = root;
		while(node != null)
		{
			int compare = value.compareTo(node.data);
			
			if(compare < 0)
			{
				node = node.lChild;
			}
			else if(compare > 0)
			{
				node = node.rChild;
			}
			else
			{
				return true;
			}
			
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
