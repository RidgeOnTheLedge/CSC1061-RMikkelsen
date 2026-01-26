
public class Car
{
	// Data Members
	private String color;
	private double amountOfGas;
	private int mileage;
	private int grndClearance;
	private static int count;
	private Radio radio;
	
	public Car(String color)
	{
		this.color = color;
		amountOfGas = 1.0;
		mileage = 10;
		count++;
		radio = new Radio();
	}
	
	public Car()
	{
		count++;
		radio = new Radio();
	}
	
	public Car(String color, double gas)
	{
		this.color = color;
		amountOfGas = gas;
		mileage = 10;
		count++;
		radio = new Radio();
	}
	

	// Methods 
	public void drive(int numMiles)
	{
		for(int i = 0; i < mileage; i++)
		{
			System.out.print("+ ");
		}
		mileage = mileage + numMiles;
		System.out.println();
	}

	// Getters and Setters
	public static int getCount()
	{
		return count;
	}
	
	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public double getAmountOfGas()
	{
		return amountOfGas;
	}

	public void setAmountOfGas(double amountOfGas)
	{
		this.amountOfGas = amountOfGas;
	}

	public int getMileage()
	{
		return mileage;
	}

	public int getGrndClearance()
	{
		return grndClearance;
	}

	public void setGrndClearance(int grndClearance)
	{
		this.grndClearance = grndClearance;
	}
	public Radio getRadio()
	{
		return radio;
	}
	
	public void setRadio(int volume, boolean hasAntenna)
	{
		
	}

	@Override
	public String toString()
	{
		return "Car [color=" + color + ", amountOfGas=" + amountOfGas + ", mileage=" + mileage + ", grndClearance="
				+ grndClearance + "]";
	}
}
