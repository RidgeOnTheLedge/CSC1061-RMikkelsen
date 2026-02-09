
public class Car extends Vehicle
{
	public Car(String color, long id)
	{
		super(color, id);
	}

	@Override
	public String drive()
	{
		return "Whee Whee";
	}

	@Override
	public void feed(int numGallons)
	{
		System.out.println("This many gallons: " + numGallons);	
	}

	@Override
	public String toString()
	{
		return "Car [drive()=" + drive() + ", toString()=" + super.toString() + "]";
	}
	
}
