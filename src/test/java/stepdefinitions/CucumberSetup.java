package stepdefinitions;

import java.net.MalformedURLException;

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
	public void initiate() throws MalformedURLException
	{
		osName = System.getProperty("os.name");
		if(osName.contains("Windows"))
		{
			if(TestingProperties.getRemoteFlag().equalsIgnoreCase("n"))
			{
				if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
					driver = SeleniumWebDriver.winChromeDriver();
				else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
					driver = SeleniumWebDriver.winFirefoxDriver();
				driver.get(TestingProperties.getWebsiteUrl());
				driver.manage().window().maximize();
			}
			else if(TestingProperties.getRemoteFlag().equalsIgnoreCase("y"))
			{
				if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
					driver = SeleniumWebDriver.remoteChromeDriver();
				else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
					driver = SeleniumWebDriver.remoteFirefoxDriver();
				driver.get(TestingProperties.getWebsiteUrl());
				driver.manage().window().maximize();
			}
		}
		else if(osName.contains("Mac"))
		{
			if(TestingProperties.getRemoteFlag().equalsIgnoreCase("n"))
			{
				if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
					driver = SeleniumWebDriver.macChromeDriver();
				else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
					driver = SeleniumWebDriver.macFirefoxDriver();
				driver.get(TestingProperties.getWebsiteUrl());
				driver.manage().window().maximize();
			}
			else if(TestingProperties.getRemoteFlag().equalsIgnoreCase("y"))
			{
				if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
					driver = SeleniumWebDriver.remoteChromeDriver();
				else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
					driver = SeleniumWebDriver.remoteFirefoxDriver();
				driver.get(TestingProperties.getWebsiteUrl());
				driver.manage().window().maximize();
			}
		}
		else if(osName.contains("Linux"))
		{
			if(TestingProperties.getRemoteFlag().equalsIgnoreCase("n"))
			{
				if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
					driver = SeleniumWebDriver.linuxChromeDriver();
				else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
					driver = SeleniumWebDriver.linuxFirefoxDriver();
				driver.get(TestingProperties.getWebsiteUrl());
				driver.manage().window().maximize();
			}
			else if(TestingProperties.getRemoteFlag().equalsIgnoreCase("y"))
			{
				if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("chrome"))
					driver = SeleniumWebDriver.remoteChromeDriver();
				else if(TestingProperties.getDesignatedBrowser().equalsIgnoreCase("firefox"))
					driver = SeleniumWebDriver.remoteFirefoxDriver();
				driver.get(TestingProperties.getWebsiteUrl());
				driver.manage().window().maximize();
			}
		}
	}
	
	@After
	public void terminate()
	{
		driver.quit();
	}
}
