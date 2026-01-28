
public class RealTimeRemoteCourse extends OnlineCourse
{
	private String zoomInfo;

	public RealTimeRemoteCourse()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public RealTimeRemoteCourse(String courseNum, int numStudents, int maxStudents, int credits)
	{
		super(courseNum, numStudents, maxStudents, credits);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return "RealTimeRemoteCourse [zoomInfo=" + zoomInfo + ", toString()=" + super.toString() + "]";
	}
	
	
}
