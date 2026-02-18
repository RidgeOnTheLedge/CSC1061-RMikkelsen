import java.util.Arrays;

public class Driver
{
	/**
	 * Tests the conversion methods
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(args));
		
		double answer = 0.0;
		
		if(args[0].equals("-f"))
		{
			answer = TempConverter.ConvertCelToFah(Double.parseDouble(args[1]));
			System.out.println("Fah: " + answer);
		}
		else if(args[0].equals("-c"))
		{
			answer = TempConverter.ConvertFahToCel(Double.parseDouble(args[1]));
			System.out.println("Cel: " + answer);
		}
		else
		{
			System.out.println("Unregonized Command: " + args[0]);
			System.out.println("-f <temp> to convert Fah");
			System.out.println("-c <temp> to convert Cel");
		}
		
	}
}


