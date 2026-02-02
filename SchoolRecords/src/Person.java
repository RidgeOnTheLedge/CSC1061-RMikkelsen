
public class Person
{
	private String name;
	private String address;
	private String phoneNum;
	private String emailAdd;
	
	
	
	public Person(String name, String address, String phoneNum, String emailAdd)
	{
		super();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.emailAdd = emailAdd;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public String getEmailAdd()
	{
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd)
	{
		this.emailAdd = emailAdd;
	}

	@Override
	public String toString()
	{
		return " Person Name: " + name + ", Address" + address + ", Phone Num: " 
				+ phoneNum + ", Email: " + emailAdd;
	}
	
	
}
