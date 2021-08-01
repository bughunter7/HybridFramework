package com.para.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	
	public static Properties prop;
	

	public static Properties configreader()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\ParaBank_Automation\\src\\main\\java\\com\\para\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
