package edu.frcc.csc1060j.TreeMap;

import java.util.Map;

public class TreeMapTest
{

	public static void main(String[] args)
	{
		MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
		treeMap.put(8, 8);
		treeMap.put(12, 12);
		treeMap.put(4, 4);
		treeMap.put(14, 14);
		treeMap.put(10, 10);
		treeMap.put(6, 6);
		treeMap.put(2, 2);
		treeMap.put(1, 1);
		treeMap.put(3, 3);
		treeMap.put(7, 7);
		treeMap.put(5, 5);
		treeMap.put(11, 11);
		treeMap.put(9, 9);
		treeMap.put(13, 13);
		treeMap.put(15, 15);
		
		for (Integer value : treeMap) {
		    System.out.println(value);
		}
		
		System.out.println();
		
	}

}
