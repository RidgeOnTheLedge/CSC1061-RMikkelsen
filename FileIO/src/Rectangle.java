
public class Rectangle extends GeometricObject
{
	
	private double width;
	private double height;
	
	public Rectangle()
	{
		width = 2;
		height = 1;
	}

	public Rectangle(String color, boolean isFilled, double width, 
			double height)
	{
		super(color, isFilled);
		this.width = width;
		this.height = height;
	}
	
	// Methods
	
	public double getArea()
	{
		return height * height;
	}

	public double getPerimeter()
	{
		return 2 * (height + width);
	}
	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	@Override
	public String toString()
	{
		return "Rectangle Width: " + width + ", Height: " + height 
				+ super.toString();
	}
	
	
}
