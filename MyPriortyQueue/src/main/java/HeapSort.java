import java.util.Collections;
import java.util.PriorityQueue;

import edu.frcc.csc1060j.MyPriorityQueue.MyPriorityQueue;

public class HeapSort
{
	public static void main(String args[])
	{
		int[] nodes = {88, 85, 83, 72, 42, 57, 6, 48, 60};
		MyPriorityQueue<Integer> priQueue = new MyPriorityQueue<>();
		
		for(int node: nodes)
		{
			priQueue.add(node);
		}
		
		System.out.println("Priority Removal");
		
		while(!priQueue.isEmpty())
		{
			System.out.print(priQueue.remove() + " ");
		}
		System.out.println();
		
		// Theirs
		PriorityQueue<Integer> pqs = new PriorityQueue<>(Collections.reverseOrder());

		for(int node: nodes)
		{
			pqs.add(node);
		}
		
		System.out.println("Priority Removal");
		
		while(!pqs.isEmpty())
		{
			System.out.print(pqs.remove() + " ");
		}
		System.out.println();
		
	}
}
