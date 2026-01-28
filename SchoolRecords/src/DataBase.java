	import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataBase
{	
	public static final String FILE_NAME = "PersonDatabase.txt";
	
	public static void main(String[] args)
	{
		DataBase db = new DataBase();

		Person person = new Person();
		Person person2 = new Person();
		System.out.println(person);
		db.writePerson(person);
		db.writePerson(person2);
		db.readDataBase();
	}
	
	public DataBase()
	{
		Path path = Paths.get(FILE_NAME);
		if(Files.exists(path))
		{
			System.out.println("File exists");
		}
		else 
		{
			System.out.println("File does not Exist");
			try
			{
				Files.createFile(path);
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void writePerson(Person person)
	{	
		try(FileWriter writer = new FileWriter(FILE_NAME, true)) 
		{			
			writer.write(person.toString() + "\n");	
			System.out.println("Complete");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Person> readDataBase()
	{
		
		try(FileReader reader = new FileReader(FILE_NAME))
		{
			int i;
			while((i = reader.read()) != -1)
			{
				
				System.out.println((char) (i));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
