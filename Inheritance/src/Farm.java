
public class Farm
{
	public static void main(String[] args)
	{
		Cat cat = new Cat(3);
		System.out.println(cat);
		cat.getName();
		
		Horse horse = new Horse();
		Dog dog = new Dog();
		
		System.out.println(horse.makeSound());
		System.out.println(dog);
	}
}
