
public class Student extends Person
{


	private String status;// freshman, sophomore, junior, or senior
	
	public Student(String name, String address, String phoneNum, 
			String emailAdd, String status)
	{
		super(name, address, phoneNum, emailAdd);
		this.status = status;
	}
	
}
