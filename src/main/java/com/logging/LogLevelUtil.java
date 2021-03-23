package com.logging;

import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogLevelUtil {
	private static final Logger classlogger;

	static {
		classlogger = LoggerFactory.getLogger((Class) LogLevelUtil.class);
	}

	public static String modifyLogLevel(String loggerName, String newLogLevel) {
		try {
			final org.apache.log4j.Logger logger4j = org.apache.log4j.Logger.getLogger(loggerName);
			logger4j.setLevel(Level.toLevel(newLogLevel.toUpperCase()));
			return "Successfully updated log level";
		} catch (Exception e) {
			return "Fail to update log level";
		}
	}

	public static String getLogLevel(String loggerName) {
		try {
			final org.apache.log4j.Logger logger4j = org.apache.log4j.Logger.getLogger(loggerName);
			return logger4j.getLevel().toString();
		} catch (Exception e) {
			return "Fail to fetch log level";
		}
	}

}
