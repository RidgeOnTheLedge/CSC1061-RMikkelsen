
public class SalariedEmployee extends Employee
{
	private double weeklySalary;

	
	public SalariedEmployee(String firstName, String lastName, long sSN, 
			double weeklySalary)
	{
		super(firstName, lastName, sSN);
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double getPaymentAmount()
	{		
		return weeklySalary;
	}

	public double getWeeklySalary()
	{
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary)
	{
		this.weeklySalary = weeklySalary;
	}

	@Override
	public String toString()
	{
		return super.toString() 
				+ "\nPayment Amount: " + getPaymentAmount();
	}
	
	
	

}
