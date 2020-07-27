package com.learnhybrid.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	
	
	public ConfigDataProvider() 
	{	
		File src = new File(".//Configuration//config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} 
		
		
		catch (Exception e) 
		{
			System.out.println("Not able to load config file>>"+e.getMessage());
		
		}
	}
	
	//Abstraction hiding the implementation showing only functionality 
	
public String getDatafFromConfig(String keyToSearch)	
{
	return pro.getProperty(keyToSearch);
}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}

	public String getStagingURL() 
	{
		return pro.getProperty("qaUrl");
	}
}
	
	
