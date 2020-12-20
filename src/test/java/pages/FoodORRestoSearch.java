package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FoodORRestoSearch
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div/div/div/div/div/input")
	private WebElement genericSearchBar;
	
	@FindBy(how = How.CLASS_NAME, using = "_1RPOp")
	private List<WebElement> addFood;
	
	@FindBy(how = How.CLASS_NAME, using = "GPl4U")
	private List<WebElement> foodItems;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]")
	private WebElement cart;
	
	@FindBy(how = How.CLASS_NAME, using = "_2EQ3T")
	private WebElement checkoutTitle;
	
	@FindBy(how = How.CLASS_NAME, using = "ZBf6d")
	private WebElement payMsg;
	
	public FoodORRestoSearch(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
		wait = new WebDriverWait(driver,10);
	}
	
	public void runFoodRestoSearch(ExtentTest logger)
	{
		wait.until(ExpectedConditions.elementToBeClickable(genericSearchBar));
		try
		{
			Assert.assertEquals(genericSearchBar.getAttribute("placeholder"), "Search for restaurants or dishes");
			logger.log(LogStatus.PASS, "Website successfully showed generic search option");
		}
		catch(AssertionError e)
		{
			logger.log(LogStatus.FAIL, "Website failed to showed generic search option");
			throw e;
		}
	}
	
	public void runFoodAddToCartSearch(ExtentTest node, ExtentTest logger, String foodItem) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(genericSearchBar));
		genericSearchBar.click();
		genericSearchBar.sendKeys(foodItem);
		//wait.until(ExpectedConditions.textToBePresentInElement(genericSearchBar.getText(), foodItem));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_3sbqM")));
		foodItems.get(0).click();
		node.log(LogStatus.PASS, "Searching food item "+foodItem+ " successfully completed");
		//logger.appendChild(node);
		//addFood.click();
	}
	
	public void addToCartTest() throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("_1RPOp")));
		//Thread.sleep(5000);
		System.out.println("The number of food items to be added is: "+addFood.size());
		addFood.get(0).click();
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cart)));
		Thread.sleep(3000);
		cart.click();
	}
	
	public void validateCartTest(ExtentTest node)
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_2EQ3T")));
			String title = checkoutTitle.getText();
			System.out.println("The title is: "+title);
			System.out.println("The page message is: "+payMsg.getText());
			if(title.equalsIgnoreCase("SECURE CHECKOUT") && payMsg.getText().contains("TO PAY"))
			{
				node.log(LogStatus.PASS, "Add to cart feature successfully completed");
				Assert.assertTrue(true);
				
			}
			else
			{
				node.log(LogStatus.FAIL, "Add to cart failed");
				Assert.assertTrue(false);
			}
		}
		catch(AssertionError e)
		{
			node.log(LogStatus.FAIL, "Add to cart failed due to an assertion error");
			throw e;
		}
	}
}
