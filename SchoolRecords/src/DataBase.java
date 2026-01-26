import java.io.FileWriter;
import java.io.IOException;

public class DataBase
{
	
	public static void main(String[] args)
	{
		Person person = new Person();
		System.out.println(person);
		writePerson(person);
	}
	
	public static void writePerson(Person person)
	{
	
		try 
		{
			FileWriter writer = new FileWriter("PersonDatabase.txt");
			writer.write(person.toString());	
			writer.close();
			System.out.println("Complete");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
	}
}
