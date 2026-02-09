	import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase
{	
	public static final String FILE_NAME = "PersonDatabase.txt";
	private File outFile;
	private PrintWriter printer;
		
	public DataBase()
	{
		Path path = Paths.get(FILE_NAME);
		outFile = new File(FILE_NAME);

		try
		{
			printer = new PrintWriter(outFile);	
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Database could not be found");
			System.exit(-1);
		}
	}

	/**
	 * Method calls the .toCVS instead of toString so you can format the 
	 * to string without having it to work with .CVS
	 * @param person
	 */
	public void writePerson(Person person)
	{	
		printer.write(person.toCVS() + "\n");
		printer.flush();
	}

	
	public ArrayList<Person> readDataBase()
	{
		ArrayList<Person> personList = new ArrayList<Person>();
		String line;
			
		try(Scanner reader = new Scanner(outFile);)
		{			
			while(reader.hasNext())
			{
				line = reader.nextLine();
				// Make sure to not put , in the date, or else this will break
				String[] tokens = line.split(","); 
				
				Person person = null;
				
				// Person class does not call className() in toString.
				// Employee class does not call className() also.
				if(tokens[0].equals("Student"))
				{
					person = new Student(tokens[1], tokens[2], 
							tokens[3], tokens[4], tokens[5]);
				}
				else if(tokens[0].equals("Faculty"))
				{
					person = new Faculty(tokens[1], tokens[2], 
							tokens[3], tokens[4],
							Integer.parseInt(tokens[5]), 
							Double.parseDouble(tokens[6]),
							tokens[7], tokens[8], tokens[9]);		
				}
				else if(tokens[0].equals("Staff"))
				{
					person = new Staff(tokens[1], tokens[2], 
							tokens[3], tokens[4],
							Integer.parseInt(tokens[5]), 
							Double.parseDouble(tokens[6]),
							tokens[7], tokens[8]);
				}
				personList.add(person);
			}		
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Database Not found");
			return null;
		}
		
		return personList;
	}
	
	public void close()
	{
		if(printer != null)
		{
			printer.close();
		}
	}
}
