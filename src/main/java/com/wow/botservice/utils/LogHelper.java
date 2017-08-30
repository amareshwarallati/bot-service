package com.wow.botservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper{
	public static Logger getLogger(Class<? extends Object> c){
		return LoggerFactory.getLogger(c);
	}
	
	public static void logInfo(Class<? extends Object> c, String message){
		Logger logger = LoggerFactory.getLogger(c);
		logger.info(message);
	}
	
	public static void logInfo(Class<? extends Object> c, String message, Throwable t){
		Logger logger = LoggerFactory.getLogger(c);
		logger.info(message, t);
	}
	
	public static void logError(Class<? extends Object> c, String message){
		Logger logger = LoggerFactory.getLogger(c);
		logger.error(message);
	}
	
	public static void logError(Class<? extends Object> c, String message, Throwable t){
		Logger logger = LoggerFactory.getLogger(c);
		logger.error(message, t);
	}
	
	public static void logDebug(Class<? extends Object> c, String message){
		Logger logger = LoggerFactory.getLogger(c);
		logger.debug(message);
	}
	
	public static void logDebug(Class<? extends Object> c, String message, Throwable t){
		Logger logger = LoggerFactory.getLogger(c);
		logger.debug(message, t);
	}
}