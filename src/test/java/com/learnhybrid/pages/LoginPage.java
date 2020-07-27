package com.learnhybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	@CacheLookup
	@FindBy(name="username") WebElement uname;
	
	@CacheLookup
	@FindBy(name="password") WebElement pass;
	
	@CacheLookup
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	@CacheLookup
	@FindBy(xpath="/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a") WebElement logoutbtn;
	
	 
	public void logintoCRM(String usernameApp, String passwordApp) throws Exception
	{
		Thread.sleep(3000);
		uname.sendKeys(usernameApp);
		pass.sendKeys(passwordApp);
		loginButton.click();
		
	}
	public void logouttoCRM() throws Exception
	{
		Actions act = new Actions(driver);
		
	act.moveToElement(logoutbtn).click().build();
	}
	
	
	
	
	
}
