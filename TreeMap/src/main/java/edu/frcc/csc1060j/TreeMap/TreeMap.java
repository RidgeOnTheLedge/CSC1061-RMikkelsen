package edu.frcc.csc1060j.TreeMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V>
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
		// TODO Auto-generated method stub

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
	public V get(Object arg0)
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
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
		if (key.compareTo(key) < 0)
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
	public V remove(Object arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
