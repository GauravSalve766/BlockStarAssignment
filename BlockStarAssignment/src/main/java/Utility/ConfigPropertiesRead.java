package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigPropertiesRead {

	public static String configPropFileRead(String value) throws Exception {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\gaura\\eclipse-workspace\\BlockStarAssignment\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
		
	}
}
