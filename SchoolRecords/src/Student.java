
public class Student extends Person
{


	private String status;// freshman, sophomore, junior, or senior
	
	public Student(String name, String address, String phoneNum, 
			String emailAdd, String status)
	{
		super(name, address, phoneNum, emailAdd);
		this.status = status;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toCVS()
	{
		return this.getClass().getSimpleName() + "," + super.toString() + "," + status;
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + "," + super.toString() + "," + status;
	}
}
