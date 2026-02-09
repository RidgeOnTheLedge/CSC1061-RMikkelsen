
public class Staff extends Employee
{
	private String title;	
	
	public Staff(String name, String address, String phoneNum, String emailAdd, 
			int office, double salary, String dateHired, String title)
	{
		super(name, address, phoneNum, emailAdd, office, salary, dateHired);
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	
	@Override
	public String toCVS()
	{
		return this.getClass().getSimpleName() + "," + super.toString() + "," + title;
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + "," + super.toString() + "," + title;
	}
	
	
}
