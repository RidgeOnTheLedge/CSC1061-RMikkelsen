
public class Test
{
	public static void main(String[] args)
	{
		Vehicle bike = new Bike("Blue", 23423);
		System.out.println(bike);
		Animal horse = new Animal("Horse", 233);
		horse.feed(13);
		System.out.println();
	}
}
