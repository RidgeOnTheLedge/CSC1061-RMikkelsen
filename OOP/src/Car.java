
public class Car
{
	// Data Members
	private String color;
	private double amountOfGas;
	private int mileage;
	private int grndClearance;
	
	public Car(String color)
	{
		this.color = color;
		amountOfGas = 1.0;
		mileage = 10;
	}
	
	public Car()
	{
		
	}
	
	public Car(String color, double gas)
	{
		this.color = color;
		amountOfGas = gas;
		mileage = 10;
	}
	
	public void drive(int numMiles)
	{
		for(int i = 0; i < mileage; i++)
		{
			System.out.println("+");
		}
		mileage = mileage + numMiles;
		System.out.println();
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

	@Override
	public String toString()
	{
		return "Car [color=" + color + ", amountOfGas=" + amountOfGas + ", mileage=" + mileage + ", grndClearance="
				+ grndClearance + "]";
	}
}
