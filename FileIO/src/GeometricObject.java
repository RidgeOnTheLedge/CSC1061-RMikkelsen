import java.util.Date;

public class GeometricObject
{
	private String color = "white";
	private boolean isFilled = false;
	private Date dateCreated;
	
	// Constructors
	public GeometricObject(String color, boolean isFilled)
	{
		this.color = color;
		this.isFilled = isFilled;
		dateCreated = null;
	}
	
	public GeometricObject()
	{
		dateCreated = new Date();
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public boolean isFilled()
	{
		return isFilled;
	}

	public void setFilled(boolean isFilled)
	{
		this.isFilled = isFilled;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}

	@Override
	public String toString()
	{
		return getColor() + "," + isFilled();
	}
	
	
}
