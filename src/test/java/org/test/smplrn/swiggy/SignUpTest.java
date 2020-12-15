package org.test.smplrn.swiggy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SignUpTest
{
	@Test
	public void testSignUp()
	{
		WebDriver driver = SeleniumWebDriver.chromeDriver();
		driver.get("https://www.swiggy.com");
		driver.manage().window().maximize();
		
		HomePage home = new HomePage(driver);
		home.runSignUpTest();
	}
}
