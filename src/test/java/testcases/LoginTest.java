package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import testproperties.TestingProperties;

@Listeners(TestCaseListeners.class)
public class LoginTest extends TestCase
{
	private String osName;
	
	@BeforeTest
	public void osNameCheck()
	{
		osName = getOSName();
	}
	
	@Test(dataProvider="getTestData")
	public void testLogin(Hashtable<String, String> testData)
	{
		if(osName.contains("Windows"))
		{
			if(testData.get("browser").equalsIgnoreCase("chrome"))
				driver = SeleniumWebDriver.winChromeDriver();
			else if(testData.get("browser").equalsIgnoreCase("firefox"))
				driver = SeleniumWebDriver.winFirefoxDriver();
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		}
		else if(osName.contains("Mac"))
		{
			if(testData.get("browser").equalsIgnoreCase("chrome"))
				driver = SeleniumWebDriver.macChromeDriver();
			else if(testData.get("browser").equalsIgnoreCase("firefox"))
				driver = SeleniumWebDriver.macFirefoxDriver();
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		}
		else if(osName.contains("Linux"))
		{
			if(testData.get("browser").equalsIgnoreCase("chrome"))
				driver = SeleniumWebDriver.macChromeDriver();
			else if(testData.get("browser").equalsIgnoreCase("firefox"))
				driver = SeleniumWebDriver.macFirefoxDriver();
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		}
		
		HomePage home = new HomePage(driver);
		home.runLoginTest(testData.get("loginid"));
	}
	
	@DataProvider
	public Object[][] getTestData() throws IOException
	{
		String filePath = TestingProperties.getTestDataFilePath();
		String fileName = "testdata.xlsx";
		String sheetName="Login";
		return ExcelReader.ReadTestData(filePath, fileName, sheetName);
	}
	
	@AfterTest
	public void quitBrowsers()
	{
		if(!driver.equals(null))
			driver.quit();
	}
}