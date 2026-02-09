import java.util.ArrayList;

public class TestSchoolRecords
{
	public static void main(String[] args)
	{
		DataBase db = new DataBase();

		Student student1 = new Student("Bob", "2222 Hen St", "970-1233-123", 
				"student1@gmail.com", "Freshman");
		Student student2 = new Student("Ross", "2322 Blue St", "970-1560-123", 
				"student2@gmail.com", "Junior");
		Person faculty1 = new Faculty("Joe", "2355 St", "970-1550-123", "Faculty1@gmail.com", 
				213, 1000, "02/02/2026", "1am-2pm", "Junior");
		Person faculty2 = new Faculty("Lisa", "9225 St", "970-1230-123", "Faculty2@gmail.com", 
				212, 10000, "02/11/2026", "8am-5pm", "Senior");
		Person staff1 = new Staff("Terra", "2515 St", "970-9999-123", "Staff1@gmail.com",
				110, 200000, "12/12/2012", "Teacher");
		Person staff2 = new Staff("Yoshi", "2533 St", "970-9029-123", "Staff2@gmail.com",
				111, 2000000, "12/12/2026", "Principal");
	
		db.writePerson(student1);
		db.writePerson(student2);
		db.writePerson(faculty1);
		db.writePerson(faculty2);
		db.writePerson(staff1);
		db.writePerson(staff2);
		ArrayList<Person> personList = db.readDataBase();
		for (Person person : personList)
		{
			System.out.println(person);
		}	
		
		db.close();
	}
}
