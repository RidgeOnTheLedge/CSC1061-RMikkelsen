
public class Farm
{
	public static void main(String[] args)
	{
		Animal[] barn = new Animal[3];
		
		Cat cat = new Cat(3);
		Horse horse = new Horse();
		Dog dog = new Dog();
		
		barn[0] = cat;
		barn[1] = horse;
		barn[2] = dog;
		
		for (int i = 0; i < barn.length; i++)
		{
			System.out.println(barn[i].makeSound());
		}
	}
	
	private static void printAnimal(Animal anim)
	{
		if (anim instanceof Cat)
		{
			int lengthOfWhiskers = ((Cat)anim).getWhiskerLength();
		}
	}
}
