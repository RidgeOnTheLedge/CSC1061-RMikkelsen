
public class Dog extends Animal
{
	private int barkVolume;

	public Dog()
	{

	}

	public Dog(String name, double weight, double height, int barkVolume)
	{
		super(name, weight, height);
		this.barkVolume = barkVolume;
	}

	@Override
	public String makeSound()
	{
		return "Bow Wow";
	}
	public int getBarkVolume()
	{
		return barkVolume;
	}

	public void setBarkVolume(int barkVolume)
	{
		this.barkVolume = barkVolume;
	}

	@Override
	public String toString()
	{
		return super.toString() + " Dog [barkVolume=" + barkVolume + "]";
	}
	
	
	
}
