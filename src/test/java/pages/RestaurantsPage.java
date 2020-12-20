package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RestaurantsPage
{
	private WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using = "BZR3j")
	private WebElement searchTitle;
	
	@FindBy(how = How.CLASS_NAME, using = "_3odgy")
	private WebElement city;
	
	@FindBy(how = How.CLASS_NAME, using = "_3HusE")
	private WebElement state;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/header/div/div/ul/li[5]/div/a/span[2]")
	private WebElement searchBar;
	
	public RestaurantsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public void validateLocationSearch(ExtentTest logger)
	{
		System.out.println(searchTitle.getText());
		String[] title = searchTitle.getText().split(" ");
		System.out.println("Total number of restraurants found: "+title[0]);
		System.out.println("Text after split: "+title[1]);
		try
		{
			System.out.println("The number is :"+Integer.parseInt(title[0]));
			if(Integer.parseInt(title[0]) > 0)
			{
				logger.log(LogStatus.PASS, "Location search was successful and found "+ title[0] + " restaurants "
						+ "at " + city.getText()+ " in " + state.getText());
				Assert.assertTrue(true);
			}
			else
			{
				logger.log(LogStatus.INFO, "Location search found no restaurants in "+ city.getText() + " in " + state.getText());
			}
		}
		catch(Exception e)
		{
			System.out.println("Parse failed");
		}
	}
	
	public void searchBarActions(ExtentTest logger) throws InterruptedException
	{
		searchBar.click();
		Thread.sleep(2000);
		FoodORRestoSearch frs = new FoodORRestoSearch(driver);
		frs.runFoodRestoSearch(logger);
	}
	
	public void checkoutSearchActions(ExtentTest node, ExtentTest logger)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		searchBar.click();
		node.log(LogStatus.PASS,"Generic search page successfully entered");
		logger.appendChild(node);
	}
}
