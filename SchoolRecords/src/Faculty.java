
public class Faculty extends Employee
{

	private String officeHours;
	private String rank; // junior senior
	public Faculty(String name, String address, String phoneNum, 
			String emailAdd, int office, double salary, String dateHired, 
			String officeHours, String rank)
	{
		super(name, address, phoneNum, emailAdd, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	public String getOfficeHours()
	{
		return officeHours;
	}
	public void setOfficeHours(String officeHours)
	{
		this.officeHours = officeHours;
	}
	public String getRank()
	{
		return rank;
	}
	public void setRank(String rank)
	{
		this.rank = rank;
	}
	
	@Override
	public String toCVS()
	{
		return this.getClass().getSimpleName() + "," + super.toString() + "," + officeHours
				+ "," + rank;
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + "," + super.toString() + "," + officeHours
				+ "," + rank;
	}
	
	
}
