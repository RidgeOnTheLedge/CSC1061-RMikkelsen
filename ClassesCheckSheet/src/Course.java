
public class Course
{
	private String courseNum;
	private int numStudents;
	private int maxStudents;
	private int credits;
	
	public Course()
	{
		
	}

	public Course(String courseNum, int numStudents, int maxStudents, int credits)
	{
		super();
		this.courseNum = courseNum;
		this.numStudents = numStudents;
		this.maxStudents = maxStudents;
		this.credits = credits;
	}

	@Override
	public String toString()
	{
		return "Course \ncourseNum=" + courseNum + ", \nnumStudents=" + numStudents + ", \nmaxStudents=" + maxStudents
				+ ", \ncredits=" + credits;
	}
	
	
}
