
public abstract class Vehicle implements Feedable
{	
	private String color;
	private long id;
	
	public Vehicle(String color, long id)
	{
		this.color = color;
		this.id = id;
	}
	
	public abstract String drive();

	@Override
	public void feed(int numGallons)
	{
		System.out.println("This many gallons: " + numGallons);	
	}

	@Override   
	public String toString()
	{
		return "Vehicle [color=" + color + ", id=" + id + "]";
	}	
}

