package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testproperties.TestingProperties;

public class Pages
{
	public void waitForLoad(WebDriver driver)
	{
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(TestingProperties.getLoadAndWaitTimeout()));
		wait.until(pageLoadCondition);
	}
	
	public void dynamicWait(WebDriver driver, WebElement element, String textToCheck)
	{
		WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt(TestingProperties.getLoadAndWaitTimeout()));
		wait.until(ExpectedConditions.textToBePresentInElement(element, textToCheck));
	}
	
	public static void takeSS(WebDriver driver, String path) throws IOException
	{
		TakesScreenshot scrnSht = ((TakesScreenshot)driver);
		File scrFile = scrnSht.getScreenshotAs(OutputType.FILE);
		File destFile = new File(path);
		FileUtils.copyFile(scrFile, destFile);
	}
}
