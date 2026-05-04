package project.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App
{
	protected static final Logger logger = LogManager.getLogger();
    public static void main( String[] args )
    {
    	logger.info("This method was called");
    	
    	logger.info("Hellow World");
    	logger.error("what is wrong");
    	logger.debug("LL");
    	
    	
    }
}
