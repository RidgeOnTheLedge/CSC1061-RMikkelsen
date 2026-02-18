import java.util.LinkedList;
import java.util.List;

public class ReverseList <E extends Comparable<E>> 
{
	private List<E> list = new LinkedList<E>();
	
	public void add(E input)
	{
		list.add(0, input); 
	}
	
	public List<E> getList()
	{
		return list;
	}
	
	public int size()
	{
		return list.size();
	}
	
	public E get(int index)
	{
		return list.get(index);
	}
	
}
