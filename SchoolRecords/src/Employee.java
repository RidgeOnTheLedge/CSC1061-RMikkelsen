
public class Employee extends Person
{

	private int office;
	private double salary;
	private String dateHired;
	
	public Employee(String name, String address, String phoneNum, String emailAdd,
			int office, double salary, String dateHired)
	{
		super(name, address, phoneNum, emailAdd);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	public int getOffice()
	{
		return office;
	}

	public void setOffice(int office)
	{
		this.office = office;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public String getDateHired()
	{
		return dateHired;
	}

	public void setDateHired(String dateHired)
	{
		this.dateHired = dateHired;
	}

	@Override
	public String toString()
	{
		return " Employee Office: " + office + ", Salary: " + salary 
				+ ", Date Hired: " + dateHired +  super.toString();
	}
	
	
}
