package testproperties;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestingProperties
{
	private static Properties prop;
	private static String windowsDriverLocation, macDrivers, linuxDrivers;
	
	private static void getPropertiesFile()
	{
		prop = new Properties();
		try
		{
			String projDir = System.getProperty("user.dir");
			FileInputStream fin = new FileInputStream(projDir+"/src/test/java/testproperties/test.properties");
			prop.load(fin);
			fin.close();
		}
		catch(Exception e)
		{
			System.err.println("An exception has occurred while reading the properties file");
			e.printStackTrace();
		}
	}
	
	public static String getWinDriverLocation()
	{
		getPropertiesFile();
		macDrivers = prop.getProperty("windows.drivers");
		return macDrivers;
	}
	
	public static String getLinuxDriverLocation()
	{
		getPropertiesFile();
		linuxDrivers = prop.getProperty("linux.drivers");
		return linuxDrivers;
	}
	
	public static String getMacDriverLocation()
	{
		getPropertiesFile();
		windowsDriverLocation = prop.getProperty("mac.drivers");
		return windowsDriverLocation;
	}
	
	public static String getDesignatedBrowser()
	{
		getPropertiesFile();
		return prop.getProperty("designatedBrowser.type");
	}
	
	public static String getLoadAndWaitTimeout()
	{
		getPropertiesFile();
		return prop.getProperty("loadAndWait.timeout");
	}
	
	public static String getExtentReportLocation()
	{
		getPropertiesFile();
		return prop.getProperty("extentreport.file");
	}
	
	public static String getScreenshotFolder()
	{
		getPropertiesFile();
		return prop.getProperty("screenshot.folder");
	}
}
