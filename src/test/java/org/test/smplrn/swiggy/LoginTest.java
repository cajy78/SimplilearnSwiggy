package org.test.smplrn.swiggy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest
{
	@BeforeTest
	public void launchBrowser()
	{	
	}
	
	@Test
	public void testLogin()
	{
		WebDriver driver = SeleniumWebDriver.chromeDriver();
		driver.get("https://www.swiggy.com");
		driver.manage().window().maximize();
		
		HomePage home = new HomePage(driver);
		home.runLoginTest();
		home.runSignUpTest();
	}
}