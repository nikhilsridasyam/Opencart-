package wrap;

import org.apache.log4j.Logger;

//import com.relevantcodes.extentreports.ExtentReports;

public class Criticalclass 
{
	public static Logger log;	
	public static void logger(String msg)
	{
		log = Logger.getLogger(Criticalclass.class.getName());
		log.info(msg);
	}
	
	
}
