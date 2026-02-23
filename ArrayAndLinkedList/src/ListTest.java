import java.util.Iterator;
import java.util.List;

public class ListTest
{
	public static void main(String[] args)
	{
		List<Integer> myArrList = new MyArrayList();

		for (int i = 0; i < 100; i++)
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
	}
}
