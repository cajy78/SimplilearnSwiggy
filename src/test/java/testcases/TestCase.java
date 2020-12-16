package testcases;

import org.openqa.selenium.WebDriver;

public class TestCase
{
	private String osName = System.getProperty("os.name");
	public WebDriver driver;
	public String getOSName()
	{
		return osName;
	}
}