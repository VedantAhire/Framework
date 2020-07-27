package com.learnhybrid.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Screenshot, alerts,frames,windows,Sync issue,javascript executor
	
	public static String captureScreenshot(WebDriver driver) 
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath= System.getProperty("user.dir")+"/Screenshot/FreeCRM_"+getCurrentDateTime()+".png";
		try {
		
			FileHandler.copy(src, new File("./Screenshot/FreeCRM_"+getCurrentDateTime()+  ".png"));
			
		
			
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return screenshotpath;
		
	}
	public static String getCurrentDateTime()
	{
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return customformat.format(currentDate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
