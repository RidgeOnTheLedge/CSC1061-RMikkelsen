import java.util.ArrayList;
import java.util.List;

public class BreakStatement
{
	public static void main(String[] args)
	{
		int[][] intArray = 	{
				{1, 2, 3},
				{5, 8},
				{7, 8, 9}
		};
		
		List<Integer> intList = new ArrayList();
		
		intList.add(Integer.valueOf(1));
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(2);
		
		for (int i = 0; i < intList.size(); i++)
		{
			System.out.println(intList.get(i));
		}
		
		// Auto Un-boxing when using int
		for (int integer : intList)
		{
			System.out.println(integer);
		}
		
		int index = findIndex(intList, 3);

		System.out.println("Index: " + index);
		
		int indexRow = -1;
		int indexCol = -1;
		boolean found = false;
		for (int i = 0; i < intArray.length; i++)
		{
			for (int j = 0; j < intArray[i].length; j++)
			{
				if(intArray[i][j] == 8)
				{
					indexRow = i;
					indexCol = j;
					found = true;
					break;
				}
			}
			if(found)
			{
				break;
			}
		}
		
		System.out.println("Row: " + indexRow + " Col: " + indexCol);
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		for (int i = 0; i < arr.length; i++)
		{
			System.out.println("Start of iteration");
			if(arr[i] % 2 > 0)
			{
				continue;
			}
			System.out.println("");
			System.out.println("Print something...");
		}
		
		
	}
	
	public static int findIndex(List<Integer> ints, int num)
	{
		int index = -1;
		for(int i = 0; i < ints.size(); i++)
		{
			if(ints.get(i) == num)
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
}
