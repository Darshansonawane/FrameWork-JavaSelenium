package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Data {
	
	
	public static String getData(String key) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:/Users/darsh/FrameWork/PropertyFiles/data.properties");
		
		
		
		prop.load(fis);

		return prop.getProperty(key);
		
	}
	
	

}
