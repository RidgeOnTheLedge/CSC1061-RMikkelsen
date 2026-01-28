import java.util.ArrayList;
import java.util.Scanner;

public class CSclasses
{

	private static final int IN_PERSON = 1;
	private static final int ONLINE = 2;
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		ArrayList<Course> courses = new ArrayList<Course>();
		
		int courseAmount = 3;
		
		Course course = null;
		for (int i = 0; i < courseAmount; i++)
		{
			System.out.println("Enter Course Num: ");
			String courseNum = scnr.nextLine();
			
			System.out.println("Enter Number of Students: ");
			int numStudents = scnr.nextInt();
			
			System.out.println("Enter Max Students: ");
			int maxStudents = scnr.nextInt();
			
			System.out.println("Enter Credits: ");
			int credits = scnr.nextInt();
			
			System.out.println("Enter Course Type (1-2) "
					+ "\n1) In Person Course \n2) Online Course");
			int selection = scnr.nextInt();
			if(selection == IN_PERSON)
			{
				System.out.println("Enter Room Number: ");
				String roomNum = scnr.nextLine();
				
				course = new InPersonCourse(courseNum, numStudents, maxStudents, credits, roomNum);
			}
			else if(selection == ONLINE)
			{
				System.out.println("Enter Online Course Type(1-2) \nFull Remote Course \nFull Remote Course");
				selection = scnr.nextInt();
				if(selection == 1)
				{
					
					System.out.println("Enter Course Contact: ");
					String courseContact = scnr.nextLine();
					course = new FullRemoteCourse(courseNum, numStudents, maxStudents, credits, courseContact);
				}
				else if(selection == 2)
				{
					
				}
			}
			
			courses.add(course);
		}

	}

}
