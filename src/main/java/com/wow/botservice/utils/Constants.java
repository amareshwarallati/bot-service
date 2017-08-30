package com.wow.botservice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Constants{
	
	public static final Properties props = new Properties();
	
	public static final String COMMA = ",";
	
	static{
		try {
			InputStream inputStream = Constants.class.getClassLoader().getResourceAsStream("application.properties"); 
			props.load(inputStream);
		} catch (IOException e) {
			LogHelper.logError(Constants.class, "Exception occurrred while reading the global properties file.", e);
		}
	}
	
}