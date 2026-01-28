
public class Horse extends Animal
{
	
	private int speed;

	public Horse()
	{

	}

	public Horse(String name, double weight, double height, int speed)
	{
		super(name, weight, height);
		this.speed = speed;
	}

	// Methods
	
	@Override
	public String makeSound()
	{
		return "Neigh Neigh";
	}
	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	@Override
	public String toString()
	{
		return super.toString() + " Horse [speed=" + speed + "]";
	}
	
	
}
