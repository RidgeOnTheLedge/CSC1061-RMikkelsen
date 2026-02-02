import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO
{
	public static void main(String[] args) throws IOException
	{
		File myFile = new File("fileWriteTest");
		
		if(!myFile.exists())
		{
			myFile.createNewFile();
		}
		
		FileOutputStream fileOut = new FileOutputStream(myFile.getName(), false);
		PrintWriter printer = new PrintWriter(fileOut);
		printer.println("The moon is full today!");
		printer.flush();
	}

}
