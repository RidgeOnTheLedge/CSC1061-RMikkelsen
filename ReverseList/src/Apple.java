
public class Apple implements  Comparable<Apple>
{
	private String color = "red";
	private int dia = 1;
	
	public Apple()
	{
		
	}

	@Override
	public int compareTo(Apple other)
	{
		if (dia < other.dia)
		{
			return -1;
		}
		if(dia > other.dia)
		{
			return 1;
		}
		return 0;
	}
}
