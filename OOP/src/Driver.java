
public class Driver
{

	public static void main(String[] args)
	{
		Car car = new Car("Pink");
		System.out.println(car);
		System.out.println("f");

		Car car2 = new Car("Blue", 2.0);
		car2.setGrndClearance(12);
		System.out.println(car2);
		car2.drive(10);
		
	}

}
