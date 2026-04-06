package edu.frcc.csc1060j.MyTreeSet;

public class MyTreeSetTest
{

	public static void main(String[] args)
	{
		MyTreeSet<Integer> ts = new MyTreeSet<>();
		ts.add(6);
		ts.add(1);
		ts.add(4);
		ts.add(7);
		ts.add(5);
		ts.add(8);
		ts.add(2);
		ts.add(3);
		ts.add(9);
		
		System.out.println("Tree Height: " + ts.getTreeHeight());
		
		for(Integer value : ts)
		{
			System.out.print(value + " ");
			
		}
	}
}
