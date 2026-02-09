
public class Bike extends Vehicle
{

	public Bike(String color, long id)
	{
		super(color, id);
	}

	@Override
	public String drive()
	{
		return "Click Click";
	}

	@Override
	public void feed(int numGallons)
	{
		System.out.println("This many gallons: " + numGallons);	
	}

	@Override
	public String toString()
	{
		return "Bike [drive()=" + drive() + ", " + super.toString() + "]";
	}

	
}
