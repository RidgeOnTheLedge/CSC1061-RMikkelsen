import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Database
{
	private File outFile = new File("database.csv");
	private PrintWriter printer;
	private Scanner reader;
	
	public Database() 
	{
		try
		{ 
			if(!outFile.exists())
			{
				outFile.createNewFile();
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Database could not be created");
			System.exit(-1);
		}

		try 
		{
			printer = new PrintWriter(outFile.getName());
			reader = new Scanner(outFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Database could not be found");
			System.exit(-1);
		}
	}
	
	// Methods
	public void write(GeometricObject shape)
	{
		printer.print(shape.getClass().getName());
		printer.print("," + shape.getColor());
		printer.print("," + shape.isFilled());
		if(shape instanceof Rectangle)
		{
			printer.print("," + ((Rectangle)shape).getArea());
			printer.print("," + ((Rectangle)shape).getPerimeter());
			printer.print("," + ((Rectangle)shape).getHeight());
			printer.print("," + ((Rectangle)shape).getWidth());
		}
		else if(shape instanceof Circle)
		{
			printer.print("," + ((Circle)shape).getRadius());
			printer.print("," + ((Circle)shape).getArea());
		}
		printer.println();
		printer.flush();
	}
	
	public GeometricObject readObject()
	{
		String line;
		if(reader.hasNext())
		{
			line = reader.next();
			
		}
		else
		{
			return null;
		}
		
		String[] tokens = line.split(",");
		
		GeometricObject obj = null;
		if(tokens[0].equals("Circle"))
		{
			obj = new Circle(tokens[1], 
					Boolean.parseBoolean(tokens[2]), 
					Double.parseDouble(tokens[3]));
		}
		else if (tokens[0].equals("Rectangle"))
		{
			obj = new Rectangle();
		}
		
		return obj;
		
	}
}
