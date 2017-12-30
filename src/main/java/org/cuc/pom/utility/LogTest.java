package org.cuc.pom.utility;

import org.apache.log4j.Logger;

public class LogTest {
	
	public static Logger log = Logger.getLogger("devPinoyLogger");
	
	public static void startTest(String message)
	{
		log.info("|START TEST CASE|START TEST CASE|START TEST CASE|");
		log.info("Start of Test Case: "+message);
		log.info("|START TEST CASE|START TEST CASE|START TEST CASE|");
	}
	
	public static void endTest(String message)
	{
		log.info("|END TEST CASE|END TEST CASE|END TEST CASE|");
		log.info("End of Test Case: "+message);
		log.info("|END TEST CASE|END TEST CASE|END TEST CASE|");
	}
	
	public static void info(String message)
	{
		
		log.info("INFO "+message+" INFO");
	}
	
	public static void fatalTest(String message)
	{
		log.info("|FATAL|FATAL|FATAL|FATAL|");
		log.fatal(message);
		log.info("|FATAL|FATAL|FATAL|FATAL|");
		
	}
	
	public static void errorTest(String message)
	{
		log.info("|ERROR|ERROR|ERROR|ERROR|");
		log.error(message);
		log.info("|ERROR|ERROR|ERROR|ERROR|");
	}

}
