package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Pages
{
	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Login")
	private WebElement loginLink;
	
	@FindBy(how = How.ID_OR_NAME, using = "mobile")
	private WebElement mobileNumber;
	
	@FindBy(how = How.ID_OR_NAME, using = "name")
	private WebElement userName;
	
	@FindBy(how = How.ID_OR_NAME, using = "email")
	private WebElement email;
	
	@FindBy(how = How.ID_OR_NAME, using = "password")
	private WebElement pwd;
	
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
	
	public void loginClick()
	{
		loginLink.click();
	}
	
	public void signUpClick()
	{
		signUpLink.click();
	}
	
	public void runLoginTest(String mobile)
	{
		//loginLink.click();
		mobileNumber.sendKeys(mobile);
		submitLogin.click();
	}
	
	public void validateLogin(ExtentTest logger) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Assert.assertEquals(otpMsg.getText(),"Enter OTP");
			logger.log(LogStatus.PASS, "Login test passed successfully");
		}
		catch(AssertionError e)
		{
			logger.log(LogStatus.FAIL, "Login test has failed due to an exception - check console log");
			throw e;
		}
	}
	
	public void unregisteredSignup(String name, String emailAddress, String password)
	{
		userName.sendKeys(name);
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		submitLogin.click();
	}
	
	public void validateSignUpPage(ExtentTest logger) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Assert.assertEquals(otpMsg.getText(),"Sign up");
			logger.log(LogStatus.PASS, "Initial Signup Page test passed successfully");
		}
		catch(AssertionError e)
		{
			logger.log(LogStatus.FAIL, "Initial Signup Pagetest failed due to an exception - check console log");
			throw e;
		}
	}
	public void runSignUpTest(String mobile, String name, String emailAddress, String password)
	{
		mobileNumber.sendKeys(mobile);
		userName.sendKeys(name);
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		//dynamicWait(driver, otpMsg,"Sign up");
		//System.out.println("the OTP Message displayed is: "+otpMsg.getText());
		submitLogin.click();
	}
	
	public void validateSignUpTest(ExtentTest logger) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Assert.assertEquals(submitLogin.getText(),"VERIFY OTP");
			logger.log(LogStatus.PASS, "Signup test passed successfully");
		}
		catch(AssertionError e)
		{
			System.out.println("Assertion Error Catch block entered");
			logger.log(LogStatus.FAIL, "Signup test failed due to an error - check console log");
			throw e;
		}
	}
	
	public void runLocationTest(String location) throws InterruptedException
	{
		locationSearch.sendKeys(location);
		//findFood.click();
		//System.out.println("Size of the elements:" +findFoodSearch.size());
		findFoodSearch.get(0).click();
		//Thread.sleep(5000);
	}
}
