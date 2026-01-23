
public class Fan
{
	// Constants for fan speeds
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;

	private int speed; // (SLOW, MEDIUM, FAST)
	private boolean isOn;
	private double radius;
	private String color;

	// Identifier for each fan
	private int id;
	private static int nextId;

	public Fan()
	{
		speed = SLOW;
		isOn = false;
		radius = 5;
		color = "blue";
		nextId++; // static counter for unique ids
		id = nextId;
	}

	public int getSpeed()
	{
		return speed;
	}

	/**
	 * Set the fan speed only allowing SLOW, MEDIUM, or FAST throw
	 * IllegalArgumentExpection other wise.
	 */
	public void setSpeed(int speed)
	{
		if (speed == SLOW || speed == MEDIUM || speed == FAST)
		{
			this.speed = speed;
		} else
		{
			throw new IllegalArgumentException("Speed Must be between 1 and 3");
		}

	}

	public boolean isOn()
	{
		return isOn;
	}

	public void setOn(boolean isOn)
	{
		this.isOn = isOn;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		if (radius < 0)
		{
			throw new IllegalArgumentException("Radius cannot be negative");
		}
		this.radius = radius;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	/**
	 * Id is read only for uniqueness
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * If the fan is on, it returns speed, color, radius, and id If off, returns
	 * color, radius, and "fan is off"
	 */
	@Override
	public String toString()
	{
		if (isOn)
		{
			return "Fan " + id + " [fan is on, " + "speed=" + speed + ", radius=" + radius + ", color=" + color + "]";
		}

		return "Fan " + id + " [" + "fan is off" + ", radius=" + radius + ", color=" + color + "]";
	}
}
