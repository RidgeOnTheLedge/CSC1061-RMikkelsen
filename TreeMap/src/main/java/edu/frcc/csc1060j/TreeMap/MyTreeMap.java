package edu.frcc.csc1060j.TreeMap;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyTreeMap<K extends Comparable<K>, V> implements Map<K, V>, Iterable<V>
{
	private Node root = null;
	private int size = 0;

	private class Node
	{
		protected K key;
		protected V value;
		protected Node lChild;
		protected Node rChild;

		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;

		}

	}

	@Override
	public void clear()
	{
		root = null;
		size = 0;

	}

	@Override
	public boolean containsKey(Object arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object key)
	{
		Node parent = null;
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;

		while (current != null)
		{
			if (k.compareTo(current.key) < 0)
			{
				current = current.lChild;
			} else if (k.compareTo(current.key) > 0)
			{
				current = current.rChild;
			} else
			{
				return current.value;
			}
		}

		return null;
	}

	@Override
	public boolean isEmpty()
	{
		return root == null;
	}

	@Override
	public Set<K> keySet()
	{
		TreeSet<K> tree = new TreeSet<>();

		return tree;
	}

	@Override
	public V put(K key, V value)
	{
		if (root == null)
		{
			root = new Node(key, value);
			size++;
			return null;
		}

		Node parent = null;
		Node current = root;
		while (current != null)
		{
			parent = current;
			if (key.compareTo(current.key) < 0)
			{
				current = current.lChild;
			} else if (key.compareTo(current.key) > 0)
			{
				current = current.rChild;
			} else
			{
				V oldValue = current.value;
				current.value = value;
				return oldValue;
			}
		}

		Node newNode = new Node(key, value);
		if (key.compareTo(parent.key) < 0)
		{
			parent.lChild = newNode;
		} else
		{
			parent.rChild = newNode;
		}

		size++;
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public V remove(Object key)
	{
		Comparable<K> k = (Comparable<K>) key;
		V value = null;
		Node current = root;
		Node parent = null;
		while (current != null)
		{
			if (k.compareTo(current.key) < 0)
			{
				parent = current;
				current = current.lChild;
			} else if (k.compareTo(current.key) > 0)
			{
				parent = current;
				current = current.rChild;
			}
			else
			{
				value = current.value;
				break;
			}
		}
		
		// Case 1 no children
		if(current.lChild == null || current.rChild == null)
		{
			if (current == parent.lChild)
			{
				parent.lChild = null;
			}
			else
			{
				parent.rChild = null;
			}
			current = null;	
		}
		
		// Case 3 one child
		
		else if(current.lChild == null)
		{
			if(current == parent.lChild)
			{
				parent.lChild = current.rChild;	
			}
			else
			{
				parent.rChild = current.rChild;
			}
		}
		else if(current.rChild == null)
		{
			if(current == parent.lChild)
			{
				parent.lChild = current.lChild;	
			}
			else
			{
				parent.rChild = current.lChild;
			}
		}
		
		if(current.lChild != null && current.rChild != null)
		{
			Node inOrderPred = current.lChild;
			Node parentOfInOrderPred = current;
			while(inOrderPred.rChild != null)
			{
				parentOfInOrderPred = inOrderPred;
				inOrderPred = inOrderPred.rChild;
			}
			
			current.key = inOrderPred.key;
			current.value = inOrderPred.value;
			
			if(parentOfInOrderPred == current)
			{
				current.lChild = inOrderPred.lChild;
			}
			else
			{
				current.rChild = inOrderPred.rChild;
			}
		}
		
	
		return value;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public Collection<V> values()
	{
		List<V> values = new LinkedList<>();
		Iterator<V> it = iterator();

		while (it.hasNext())
		{
			values.add(it.next());
		}

		return values;
	}

	@Override
	public Iterator<V> iterator()
	{
		return new RecursiveIterator();
	}

	public class NonRecursiveIterator implements Iterator<V>
	{
		private Deque<Node> stack = new ArrayDeque<>();

		@Override
		public boolean hasNext()
		{

			return !stack.isEmpty();
		}

		@Override
		public V next()
		{
			Node node = stack.pop();
			pushOnStack(node);
			return node.value;
		}

		public void pushOnStack(Node node)
		{
			Node current = node;
			while (current != null)
			{
				stack.push(current);
				current = current.lChild;
			}
		}
	}

	public class RecursiveIterator implements Iterator<V>
	{

		private List<V> list = new LinkedList<V>();
		private int index = 0;

		public RecursiveIterator()
		{
			inorder(root);
		}

		@Override
		public boolean hasNext()
		{
			return index < list.size();
		}

		@Override
		public V next()
		{
			return list.get(index++);
		}

		public void inorder(Node node)
		{
			if (node == null)
			{
				return;
			}

			inorder(node.lChild);
			list.add(node.value);
			inorder(node.rChild);
		}

		public void preorder(Node node)
		{
			if (node == null)
			{
				return;
			}

			list.add(node.value);
			preorder(node.lChild);
			inorder(node.rChild);
		}

	}
}
