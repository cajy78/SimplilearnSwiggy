package testproperties;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestingProperties
{
	private static Properties prop;
	private static String siteURL, tdFilePath, tdFile, designatedBrowserType, loginPage, windowsDriverLocation, testDataFile, macDrivers, linuxDrivers;
	private static List<String> browserList = new ArrayList<String>();
	
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
	
	public static String getTestDataFilePath()
	{
		//getPropertiesFile();
		tdFilePath = System.getProperty("user.dir");
		return tdFilePath;
	}
	
	public static String getTestDataFileName()
	{
		getPropertiesFile();
		tdFile = prop.getProperty("testData.fileName");
		System.out.println("the file name is: "+tdFile);
		return tdFile;
	}
	
	public static String getTestDataFile()
	{
		getPropertiesFile();
		testDataFile = System.getProperty("testData.file");
		System.out.println(testDataFile);
		return testDataFile;
	}
}
