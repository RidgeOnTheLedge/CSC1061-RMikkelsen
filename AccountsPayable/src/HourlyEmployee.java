
public class HourlyEmployee extends Employee
{

	private double hourlyWage;
	private int hours;
	
	public HourlyEmployee(String firstName, String lastName, long socialSecurityNumber, 
			double hourlyWage, int hours)
	{
		super(firstName, lastName, socialSecurityNumber);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}

	@Override
	public double getPaymentAmount()
	{
		return hourlyWage * hours;
	}

	public double getHourlyWage()
	{
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage)
	{
		this.hourlyWage = hourlyWage;
	}

	public int getHours()
	{
		return hours;
	}

	public void setHours(int hours)
	{
		this.hours = hours;
	}
	
	@Override
	public String toString()
	{
		return super.toString() 
				+ "\nPayment Amount: " + getPaymentAmount();
	}

}
