
public class FullRemoteCourse extends OnlineCourse
{
	private String courseContact; // email

	public FullRemoteCourse()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public FullRemoteCourse(String courseNum, int numStudents, int maxStudents, int credits, String courseContact)
	{
		super(courseNum, numStudents, maxStudents, credits);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return "FullRemoteCourse [courseContact=" + courseContact + ", toString()=" + super.toString() + "]";
	}
	
	
}
