import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File myFile = new File("fileWriteTest");
		Scanner scnr = null;
		
		try
		{
			scnr = new Scanner(myFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		
		while(scnr.hasNextLine())
		{
			String line = scnr.nextLine();
			System.out.println(line);
			
		}
		
		int[] nums = {1, 2, 3};
		try
		{
			addOne(nums, 4);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		}		
	}
	
	public static void addOne(int[] nums, int index)
	{
		nums[index]++;
	}
}
