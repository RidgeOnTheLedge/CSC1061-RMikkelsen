
public class OnlineCourse extends Course
{
	
	public OnlineCourse()
	{
		super();
	}

	public OnlineCourse(String courseNum, int numStudents, int maxStudents,
			int credits)
	{
		super(courseNum, numStudents, maxStudents, credits);
	}

	@Override
	public String toString()
	{
		return "\nOnline Course: " +  super.toString();
	}
	
	
	

	
}
