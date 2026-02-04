
public class Circle extends GeometricObject
{
	private double radius;
	
	
	public Circle()
	{
		this.radius = 1.0;
	}
	
	public Circle(String color, boolean isFilled, double radius)
	{
		super(color, isFilled);
		this.radius = radius;
	}

	public double getRadius()
	{
		return radius;
	}

	public double getArea()
	{
		radius = Math.abs(radius);
		return Math.PI * radius * radius;
	}
	
	public static double getArea(double radius)
	{
		return Math.PI * radius * radius;
	}
	
	public static double getArea(int radius)
	{
		return Math.PI * radius * radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	public double getCircum()
	{
		return 2 * Math.PI * radius;
	}
	@Override
	public String toString()
	{
		return "Circle Radius: " + radius + " " + super.toString();
	}
	
	
}

