package edu.frcc.csc1061j.LoggingWithLog4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Method
{
	protected static final Logger logger = LogManager.getLogger();
	public static void callThis()
	{
		logger.info("This method was called");
		
		int[] arr = new int[5];
		
		try {
			arr[6] = 5;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			logger.error("Oopsie" + e);
		}
	}
}
