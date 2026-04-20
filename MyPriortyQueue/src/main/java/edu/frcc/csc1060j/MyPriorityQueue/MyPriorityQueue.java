package edu.frcc.csc1060j.MyPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue<E extends Comparable<E>>
{
	private List<E> heapArray;
	
	public MyPriorityQueue()
	{
		heapArray = new ArrayList<>();
	}
	
	public int size()
	{
		return heapArray.size();
	}
	
	public boolean isEmpty()
	{
		return heapArray.isEmpty();
	}
	
	private int lChild(int parIndex)
	{
		if(parIndex < 0 || parIndex >= heapArray.size())
		{
			return -1;
		}
		
		return (2 * parIndex) + 1;
	}
	
	private int rChild(int parIndex)
	{
		if(parIndex < 0 || parIndex >= heapArray.size())
		{
			return -1;
		}
		
		return (2 * parIndex) + 2;
	}
	
	private int parent(int pos)
	{
		if(pos < 0 || pos >= heapArray.size())
		{
			return -1;
		}
		
		return (pos - 1) / 2;
	}
	
	private boolean isLeafNode(int pos)
	{
		return (pos >= heapArray.size()/2 && pos < heapArray.size());
	}
	
	public void add(E elem)
	{
		heapArray.add(elem);
		swimUp(heapArray.size() - 1);
	}
	
	private void swimUp(int curr)
	{
		int par = parent(curr);
		while (curr != 0 && (heapArray.get(curr).compareTo(heapArray.get(par)) < 0))
		{
			swap(curr, par);
			curr = par;
			par = parent(curr);
		}
	}
	
	private void swap(int curr, int par)
	{
		E temp = heapArray.get(curr);
		heapArray.set(curr, heapArray.get(par));
		heapArray.set(par, temp);
	}
	
	public E remove()
	{
		return remove(0);
	}
	
	public E remove(int pos)
	{
		
		swap(pos, heapArray.size() - 1);
		E removedEntry = heapArray.remove(heapArray.size() - 1);
		
		if(!heapArray.isEmpty())
		{
			siftDown(pos);
		}
		
		return removedEntry;
	}
	
	private void siftDown(int currentPos)
	{
		while(!isLeafNode(currentPos))
		{
			int lc = lChild(currentPos);
			int rc = rChild(currentPos);
			int child = lc; 
			E childElement = heapArray.get(lc);
			
			if(rc > -1 && rc < heapArray.size())
			{
				E rcElem = heapArray.get(rc);
				
				// Turns out right child is  less than left child
				if(rcElem.compareTo(childElement) < 0)
				{
					childElement = rcElem;
					child = rc;
				}
			}
			
			if(heapArray.get(currentPos).compareTo(childElement) > 0)
			{
				swap(currentPos, child);
				currentPos = child;
			}
			else
			{
				break;
			}
		}
	}
}

