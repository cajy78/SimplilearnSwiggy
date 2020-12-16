package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HomePage;

public class SignUpTest
{
	@Test
	public void testSignUp()
	{
		WebDriver driver = SeleniumWebDriver.firefoxDriver();
		driver.get("https://www.swiggy.com");
		driver.manage().window().maximize();
		
		HomePage home = new HomePage(driver);
		home.runSignUpTest();
	}
}
