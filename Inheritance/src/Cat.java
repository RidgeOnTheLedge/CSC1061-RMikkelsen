
public class Cat extends Animal
{
	private int whiskerLength;

	public Cat(int whiskerLength)
	{
		super(); 
		this.whiskerLength = whiskerLength;
	}
	
	public Cat(String name, double weight, double height, int whiskerLength)
	{
		super(name, weight, height); 
		this.whiskerLength = whiskerLength;
	}
	
	// Methods
	
	@Override
	public String makeSound()
	{
		return "Meow Meow";
	}

	public int getWhiskerLength()
	{
		return whiskerLength;
	}

	public void setWhiskerLength(int whiskerLength)
	{
		this.whiskerLength = whiskerLength;
	}

	
	@Override
	public String toString()
	{
		return  "Cat [whiskerLength=" + whiskerLength + " " + super.toString();
	}
	
	
	
	
}
