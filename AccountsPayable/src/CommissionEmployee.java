
public class CommissionEmployee extends Employee
{
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstName, String lastName, long socialSecurityNumber, 
			double grossSales, double commissionRate)
	{
		super(firstName, lastName, socialSecurityNumber);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return grossSales * commissionRate;
	}

	public double getGrossSales()
	{
		return grossSales;
	}

	public void setGrossSales(double grossSales)
	{
		this.grossSales = grossSales;
	}

	public double getCommissionRate()
	{
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate)
	{
		this.commissionRate = commissionRate;
	}
	
	@Override
	public String toString()
	{
		return super.toString() 
				+ "\nPayment Amount: " + getPaymentAmount();
	}

}
