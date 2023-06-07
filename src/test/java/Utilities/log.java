package Utilities;

import java.util.logging.Logger;

import com.aventstack.extentreports.model.Log;

public class log {

	public static Logger log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String testCaseName) {
		log.info("======"+testCaseName+"Test Case Start");
	}
	public static void endTestCase(String testCaseName) {
		log.info("======"+testCaseName+"Test Case End");

	}
	//
	public static void info(String message) {
		
	}
	public static void warn(String message) {
		log.warning(message);
	}
	
	
	
	
	
}
