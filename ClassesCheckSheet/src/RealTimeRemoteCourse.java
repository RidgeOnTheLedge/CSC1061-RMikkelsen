
public class RealTimeRemoteCourse extends OnlineCourse
{
	private String zoomInfo;

	public RealTimeRemoteCourse()
	{
		super();
	}

	public RealTimeRemoteCourse(String courseNum, int numStudents, int maxStudents, int credits, String zoomInfo)
	{
		super(courseNum, numStudents, maxStudents, credits);
		this.zoomInfo = zoomInfo;
	}

	public String getZoomInfo()
	{
		return zoomInfo;
	}

	public void setZoomInfo(String zoomInfo)
	{
		this.zoomInfo = zoomInfo;
	}
	
	@Override
	public String toString()
	{
		return "Type: Real Time Remote Course \nZoom Info: " + zoomInfo + super.toString();
	}
	
	
}
