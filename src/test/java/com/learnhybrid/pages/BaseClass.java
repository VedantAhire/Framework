package com.learnhybrid.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnhybrid.utility.BrowserFactory;
import com.learnhybrid.utility.ConfigDataProvider;
import com.learnhybrid.utility.ExcelDataProvider;
import com.learnhybrid.utility.Helper;


public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		
		
		Reporter.log("Setting up reports and Test is ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent =  new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done - Test can be Started", true);
		
		 
	}
	
	@BeforeClass

	
	public void setup() {
		
		Reporter.log("Trying to start browser and getting Url ", true);
		
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingURL());
		
		Reporter.log("launched browser and Url running successfully ", true);
		
	}
	
	
	
     @AfterClass
	
	public void tearDown()
	{

    	
    	 
	BrowserFactory.quitBrowser(driver);
		
	
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end ", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
		
		logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		Reporter.log("Test completed and external report generated ", true);
		
		report.flush();
	}
}
	
	
	
	
	

