package com.learnhybrid.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learnhybrid.pages.BaseClass;
import com.learnhybrid.pages.LoginPage;


public class LoginTestCRM extends BaseClass {

	
	
	
	
	
	@Test(priority=1)
	public void loginApp() throws Exception
	{
    logger =report.createTest("Login to CRM");
    
    LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
    
	logger.info("Starting Application");
		
    loginpage.logintoCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

	
	Reporter.log("Entering username and Password", true);
	
		
	Reporter.log("Login successfully ", true);
	
	logger.pass("Login passed");
	
	}
	@Test(priority=2)
	
	public void logout() throws Exception
	{
		
		Reporter.log("Logout of CRM shows", true);
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
	
		loginpage.logouttoCRM();
		
		Reporter.log("Logout successfully", true);
		logger.pass("Logout Passed");
	
	
	}
	
	
	
	
	
	
	
	
	
	
}
