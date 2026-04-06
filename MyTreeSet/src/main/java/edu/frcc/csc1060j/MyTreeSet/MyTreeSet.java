package edu.frcc.csc1060j.MyTreeSet;

import java.awt.geom.QuadCurve2D;
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
		return root.height;
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
			if(node == null)
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
		if (node.lChild == null && node.rChild == null)
		{
			node.height = 0;
		} else if (node.lChild == null)
		{
			node.height = node.rChild.height + 1;
		} else if (node.rChild == null)
		{
			node.height = node.lChild.height + 1;
		} else
		{
			node.height = Math.max(node.lChild.height, node.rChild.height) + 1;
		}
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
		for (int i = path.size() - 1; i > 0; i--)
		{
			Node current = path.get(i);
			updateHeight(current);

			Node parent = null;
			if (i > 0)
			{
				parent = path.get(i - 1);
			}

			int balanceFactor = balanceFactor(path.get(i));
			
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
					// TODO: Right right imbalance
				} else
				{
					// TODO: Right left imbalance
				}
				break;
			}
			
		}

	}
	
	private void balanceLR(Node node, Node parent)
	{
		Node ggp = parent;
		Node gp = node;
		Node par = node.lChild;
		Node ch = par.rChild;
		
		if (gp == root)
		{
			root = ch;
		}
		else
		{
			if(ggp.lChild == gp)
			{
				ggp.lChild = ch;
			}
			else
			{
				ggp.rChild = ch;
			}
		}
		
		par.rChild = ch.lChild;
		gp.lChild = ch.rChild;
		
		ch.lChild = par;
		ch.rChild = gp;

		updateHeight(gp);
		updateHeight(par);
		updateHeight(ch);
	}

	private void balanceLL(Node node, Node parent)
	{
		Node ggp = parent;
		Node gp = node;
		Node par = node.lChild;
		
		if(gp == root)
		{
			root = par;
		}
		else
		{
			if(ggp.lChild == gp)
			{
				ggp.lChild = parent;
			}
			else
			{
				ggp.rChild = parent;
			}
		}
		
		gp.lChild = par.rChild;
		par.rChild = gp;
		
		updateHeight(par.lChild);
		updateHeight(gp);
		updateHeight(par);
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
	public boolean contains(Object arg0)
	{
		// TODO Auto-generated method stub
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
