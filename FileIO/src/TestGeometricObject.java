
public class TestGeometricObject
{
	public static void main(String[] args)
	{
		Circle cir1 = new Circle("Green", true, 1.0);
		System.out.println("Area of cir1: " + cir1.getArea());
		
		int radius = 5;
		System.out.println("A circle with radius: " + radius );
		
		Rectangle rect1 = new Rectangle("Red", true, 2.0, 3.0);
		System.out.println("Perimeter = " + rect1.getPerimeter());
		
		Database db = new Database();
		db.write(cir1);
		db.write(rect1);
		GeometricObject ob = db.readObject();
		System.out.println(ob);
	}
}
