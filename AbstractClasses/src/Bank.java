
public class Bank extends FinancialInstitution
{
	public Bank(String name)
	{
		super(name);
	}

	@Override
	public double getInterestRate()
	{
		return 0;
	}
}
