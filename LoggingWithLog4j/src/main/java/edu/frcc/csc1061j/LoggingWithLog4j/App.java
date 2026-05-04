package edu.frcc.csc1061j.LoggingWithLog4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App
{
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args)
	{
	  	Method method = new Method();
	  	method.callThis();
    	logger.info("This method was called");
    	
    	logger.info("Hellow World");
    	logger.error("what is wrong");
    	logger.debug("LL");
    	

	}
}
