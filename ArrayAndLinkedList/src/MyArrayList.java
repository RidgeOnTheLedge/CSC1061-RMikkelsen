import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T>
{
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		array = (T[]) new Object[4];
		size = 0;
	}


	@Override
	public int size() {return size;}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}


	@Override
	public boolean contains(Object o)
	{		
		return false;
	}

	@Override
	public Iterator<T> iterator()
	{	
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>
	{
		private int index = 0;
		
		@Override
		public boolean hasNext()
		{	
			if(index < size)
			{
				return true;
			}	
			
			return false;		
		}

		@Override
		public T next()
		{
			if(index >= size)
			{
				throw new IndexOutOfBoundsException("Index exceeds size");
			}
			return array[index++];
		}
	}

	@Override
	public Object[] toArray()
	{
		
		return null;
	}


	@Override
	public <T> T[] toArray(T[] a)
	{
		
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T e)
	{
		if(size >= array.length)
		{
			T[] bigger = (T[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; i++)
			{
				bigger[i] = array[i];
			}
			array = bigger;
		}
		
		array[size] = e;
		size++;
		return true;
	}


	@Override
	public boolean remove(Object o)
	{
		int index = indexOf(o);
		if(index < 0)
		{
			return false;
		}
		
		remove(index);
		return true;
	}


	@Override
	public boolean containsAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> c)
	{
		boolean flag = false;
		for (Object obj : c)
		{
			if(remove(obj))
			{
				flag = true;
			}
		}
		
		return flag;
	}


	@Override
	public boolean retainAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear()
	{
		size = 0;	
	}


	@Override
	public T get(int index)
	{
		if(index > size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public T set(int index, T element)
	{	
		if(index > size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		T old = array[index];
		array[index] = element;
		return old;
	}


	@Override
	public void add(int index, T element)
	{
		if(index > size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		// Add the element to get the resizing of the array
		add(element);
		
		//Shift Elements
		for (int i = size - 1; i > index; i--)
		{
			array[i] = array[i - 1];
		}	
		
		// Put the new element in the right place
		array[index] = element;
	}


	@Override
	public T remove(int index)
	{
		T old = array[index];
		for (int i = index; i < size; i--)
		{
			array[i] = array[i + 1];
		}	
		size--;
	
		return old;
	}


	@Override
	public int indexOf(Object o)
	{
		for (int i = 0; i < size; i++)
		{
			if(equals(array[i], 0))
			{
				return i;
			}
		}
		
		return -1;
	}

	private boolean equals(Object o1, Object o2)
	{
		if(o1 == null || o2 == null)
		{
			return false;
		}
		return o1.equals(o2);
	}
	
	@Override
	public int lastIndexOf(Object o)
	{
		for (int i = size - 1; i >= 0; i--)
		{
			if(equals(array[i], o))
			{
				return i;
			}
		}
		return -1;
	}


	@Override
	public ListIterator<T> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator<T> listIterator(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
