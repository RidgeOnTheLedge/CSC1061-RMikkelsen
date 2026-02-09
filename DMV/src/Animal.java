
public class Animal implements Feedable
{
	private String name;
	private int weight;
	
	public Animal(String name, int weight)
	{
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public void feed(int numGallons)
	{
		System.out.println("This many gallons: " + numGallons);
	}

	@Override
	public String toString()
	{
		return "Animal [name=" + name + ", weight=" + weight + ", toString()=" + super.toString() + "]";
	}
	

}
