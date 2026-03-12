package com.qa.projectname.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JUtil {
	
	public static Logger log = LogManager.getLogger(Log4JUtil.class);

	
	public static void info (String mesg) {
		log.info(mesg);
	}
	public static void warn (String mesg) {
		log.info(mesg);
	}
	
	public static void error (String mesg) {
		log.info(mesg);
	}
	
	public static void fatal (String mesg) {
		log.info(mesg);
	}
}

