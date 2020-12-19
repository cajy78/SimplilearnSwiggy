package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testcases.SeleniumWebDriver;
import testproperties.TestingProperties;

public class CucumberSetup
{
	public static WebDriver driver;
	private String osName;
	
	@Before
	public void initiate()
	{
		osName = System.getProperty("os.name");
		if(osName.contains("Windows"))
		{
			if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
				driver = SeleniumWebDriver.winChromeDriver();
			else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
				driver = SeleniumWebDriver.winFirefoxDriver();
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		}
		else if(osName.contains("Mac"))
		{
			if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
				driver = SeleniumWebDriver.macChromeDriver();
			else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
				driver = SeleniumWebDriver.macFirefoxDriver();
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		}
		else if(osName.contains("Linux"))
		{
			if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
				driver = SeleniumWebDriver.linuxChromeDriver();
			else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
				driver = SeleniumWebDriver.linuxFirefoxDriver();
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		}
	}
	
	@After
	public void terminate()
	{
		driver.close();
	}
}
