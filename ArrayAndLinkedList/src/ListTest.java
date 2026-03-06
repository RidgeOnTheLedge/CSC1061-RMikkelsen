import java.util.Iterator;
import java.util.List;

import edu.frcc.csc1061j.PlaylistManager.MyDoubleLinkedList;

public class ListTest
{
	public static void main(String[] args)
	{
		List<Integer> myArrList = new MyArrayList();
		
		for (int i = 0; i < 10; i++)
		{
			myArrList.add(i);
		}
		

		
		// This automatically creates an iterator
		for (Integer integer : myArrList)
		{
			System.out.print(integer + " ");
		}

		// This is an enhanced for each loop
		Iterator<Integer> iter = myArrList.iterator();
		while(iter.hasNext())
		{
			Integer ans = iter.next();
			System.out.println(myArrList.get(ans));
		}
		
		System.out.println();
		
		List<Integer> ll = new MyDoubleLinkedList<>();
		ll.add(6);
		ll.add(7);
		ll.add(null);
		ll.add(9);
		ll.add(10);
		
		// Quadratic .get is another for loop
		for (int i = 0; i < ll.size(); i++)
		{
			System.out.print(ll.get(i) + " "); 
		}
		System.out.println();
		
		iter = ll.iterator();
		while(iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		
		for(Integer x : ll)
		{
			System.out.print(x + " ");
		}
	}
}
