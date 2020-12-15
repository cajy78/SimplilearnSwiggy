package org.test.smplrn.swiggy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumWebDriver
{
	private static WebDriver driver;
	
	public static WebDriver chromeDriver()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver firefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");
		driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver remoteChromeDriver() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		String hubURL = "http://192.168.1.34:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL), cap);
		return driver;
	}
	
	public static WebDriver remoteFirefoxDriver() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.ANY);
		String hubURL = "http://192.168.1.34:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL), cap);
		return driver;
	}
	
	public static WebDriver remoteSafariDriver() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("safari");
		cap.setPlatform(Platform.ANY);
		String hubURL = "http://192.168.1.34:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL), cap);
		return driver;
	}
}
