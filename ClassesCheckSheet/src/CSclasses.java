import java.util.ArrayList;
import java.util.Scanner;

public class CSclasses
{
	private enum Constants
	{
		IN_PERSON(1),
		ONLINE(2),
		FULL_REMOTE(1),
		REAL_TIME_REMOTE(2);
		
		private final int constant;
		Constants(int constant)
		{
			this.constant = constant;
		}
		 
		public int getConstant()
		{
			return this.constant;
		}
	}

	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		ArrayList<Course> courses = new ArrayList<Course>();

		int courseAmount = 3;

		
		for (int i = 0; i < courseAmount; i++)
		{
			Course course = null;
			System.out.println("Enter Course " + (i + 1) + " Num: ");
			String courseNum = scnr.nextLine();

			System.out.println("Enter Number of Students: ");
			int numStudents = Integer.parseInt(scnr.nextLine());;

			System.out.println("Enter Max Students: ");
			int maxStudents = Integer.parseInt(scnr.nextLine());;

			System.out.println("Enter Credits: ");
			int credits = Integer.parseInt(scnr.nextLine());;

			System.out.println("Enter Course Type (1-2) " + 
					"\n1) In Person Course \n2) Online Course");
			int selection = Integer.parseInt(scnr.nextLine());;

			if (selection == Constants.IN_PERSON.getConstant())
			{
				System.out.println("Enter Room Number: ");
				String roomNum = scnr.nextLine();

				course = new InPersonCourse(courseNum, numStudents, maxStudents, 
						credits, roomNum);
			} 
			else if (selection == Constants.ONLINE.getConstant())
			{
				System.out.println("Enter Online Course Type(1-2) "
						+ "\n1) Full Remote Course \n2) Real Time Remote Course");
				selection = Integer.parseInt(scnr.nextLine());;
				if (selection == Constants.FULL_REMOTE.getConstant())
				{
					System.out.println("Enter Course Contact: ");
					String courseContact = scnr.nextLine();
					
					course = new FullRemoteCourse(courseNum, numStudents, maxStudents, credits, courseContact);
				} 
				else if (selection == Constants.REAL_TIME_REMOTE.getConstant())
				{
					System.out.println("Enter Zoom Info: ");
					String zoomInfo = scnr.nextLine();
					course = new RealTimeRemoteCourse(courseNum, numStudents, maxStudents, credits, zoomInfo);
				}
			}

			courses.add(course);
		}
		
		for (Course course: courses)
		{
			printCourse(course);
		}
		
		for(Course course: courses)
		{
			printWithoutToString(course);
		}

	}
	
	private static void printCourse(Course course)
	{
		System.out.println(course);
	}

	private static void printWithoutToString(Course course)
	{
		System.out.println("Course Num: " + course.getCourseNum());
		System.out.println("Num Students: " + course.getNumStudents());
		System.out.println("Max Students: " + course.getMaxStudents());
		System.out.println("Credits: " + course.getCredits());

		if(course instanceof FullRemoteCourse)
		{
			System.out.println ("Course Number: " + 
					((FullRemoteCourse)course).getCourseNum());
		}
		else if(course instanceof RealTimeRemoteCourse)
		{
			System.out.println ("Zoom Info: " +
					((RealTimeRemoteCourse)course).getZoomInfo());
		}
		else if(course instanceof InPersonCourse)
		{
			System.out.println ("Room Num: " + 
					((InPersonCourse)course).getRoomNum());
		}

	}
}
