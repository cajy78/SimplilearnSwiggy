package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HomePage;

public class FoodSearchTest
{
	@Test
	public void findFood() throws InterruptedException
	{
		WebDriver driver = SeleniumWebDriver.chromeDriver();
		driver.get("https://www.swiggy.com");
		driver.manage().window().maximize();
		
		HomePage home = new HomePage(driver);
		home.runLocationTest();
	}
}
