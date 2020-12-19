package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends Pages
{
	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Login")
	private WebElement loginLink;
	
	@FindBy(how = How.ID, using = "mobile")
	private WebElement loginID;
	
	@FindBy(how = How.ID, using = "otp")
	private WebElement otp;
	
	@FindBy(how = How.CLASS_NAME, using = "a-ayg")
	private WebElement submitLogin;
	
	@FindBy(how = How.CLASS_NAME, using = "_1Tg1D")
	private WebElement otpMsg;
	
	@FindBy(how = How.LINK_TEXT, using = "Sign up")
	private WebElement signUpLink;
	
	@FindBy(how = How.CLASS_NAME, using = "_3iFC5")
	private WebElement findFood;
	
	@FindBy(how = How.ID, using = "location")
	private WebElement locationSearch;
	
	@FindBys({@FindBy(how = How.CLASS_NAME, using = "_2W-T9")})
	private List<WebElement> findFoodSearch;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public void runLoginTest(String mobile)
	{
		loginLink.click();
		loginID.sendKeys(mobile);
		//Actions ma = new Actions(driver);
		//ma.moveToElement(submitLogin).build().perform();
		//ma.click(submitLogin).build().perform();
		//loginID.submit();
		submitLogin.click();
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		//WebElement otpMsg = driver.findElement(By.className("_1Tg1D"));//)(By.xpath("//*[text()='Enter OTP']"));
		//dynamicWait(otpMsg,"Sign up");
		//dynamicWait(otpMsg,"Login");
		dynamicWait(driver, otpMsg,"Enter OTP");
		System.out.println("the OTP Message displayed is: "+otpMsg.getText());
		/*if(otpMsg.isDisplayed())
		{
			System.out.print("OTP Message is displayed");
		}
		else
		{
			System.err.println("OTP Message not displayed");
		}*/
	}
	
	public void runSignUpTest()
	{
		signUpLink.click();
		dynamicWait(driver, otpMsg,"Sign up");
		System.out.println("the OTP Message displayed is: "+otpMsg.getText());
	}
	
	public void runLocationTest(String location) throws InterruptedException
	{
		locationSearch.sendKeys(location);
		//findFood.click();
		//Thread.sleep(2000);
		System.out.println("Size of the elements:" +findFoodSearch.size());
		findFoodSearch.get(0).click();
	}
}
