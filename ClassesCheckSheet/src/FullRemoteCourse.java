
public class FullRemoteCourse extends OnlineCourse
{
	private String courseContact; // email

	public FullRemoteCourse()
	{
		super();
	}

	public FullRemoteCourse(String courseNum, int numStudents, int maxStudents, 
			int credits, String courseContact)
	{
		super(courseNum, numStudents, maxStudents, credits);
	}

	@Override
	public String toString()
	{
		return "Type: Full Remote Course \nCourse Contact: " + 
				courseContact + super.toString();
	}
	
	
}
