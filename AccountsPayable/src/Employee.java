
public abstract class Employee
{
	private String firstName;
	private String lastName;
	private long socialSecurityNumber;
	
	public Employee()
	{
		firstName = "";
		lastName = "";
		socialSecurityNumber = 0;
	}

	public Employee(String firstName, String lastName, long socialSecurityNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public abstract double getPaymentAmount();

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public long getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(long socialSecurityNumber)
	{
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public String toString()
	{
		return "Employee"
				+ "\nFirst Name: " + firstName  
				+ "\nLast Name: " + lastName 
				+ "\nSocial Security Number: " + socialSecurityNumber;
	}
	
}
