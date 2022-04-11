package com.pwc.util;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {
	
	public static String getInputValue(String key) {
		try {
			FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/main/java/com/pwc/input/"+"input.properties");
			Properties p = new Properties();
			p.load(reader);
			return p.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  

	}

}
