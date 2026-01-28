
public class InPersonCourse extends Course 
{
	private String roomNum;

	public InPersonCourse()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public InPersonCourse(String courseNum, int numStudents, int maxStudents, int credits, String roomNum)
	{
		super(courseNum, numStudents, maxStudents, credits);
		this.roomNum = roomNum;
	}

	@Override
	public String toString()
	{
		return "InPersonCourse [roomNum=" + roomNum + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
