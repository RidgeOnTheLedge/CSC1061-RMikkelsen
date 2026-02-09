
public class Motorbike extends Vehicle
{

	public Motorbike(String color, long id)
	{
		super(color, id);
	}

	@Override
	public String drive()
	{
		return "Vroom Vroom";
	}

	@Override
	public void feed(int numGallons)
	{
		System.out.println("This many gallons: " + numGallons);
	}

	@Override
	public String toString()
	{
		return "Motorbike [drive()=" + drive() + ", " + super.toString() + "]";
	}
	
	
}
