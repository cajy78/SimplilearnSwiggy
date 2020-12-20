package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testproperties.TestingProperties;

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
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, Integer.parseInt(TestingProperties.getLoadAndWaitTimeout())), this);
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
		mobileNumber.sendKeys(mobile);
		submitLogin.click();
	}
	
	public void validateLogin(ExtentTest node) throws InterruptedException, IOException
	{
		try {
			Thread.sleep(1000);
			takeSS(driver,TestingProperties.getScreenshotFolder()+"/RegisteredNoLogin.jpg");
			Assert.assertEquals(otpMsg.getText(),"Enter OTP");
			node.log(LogStatus.PASS, "Login test passed successfully");
		}
		catch(AssertionError e)
		{
			node.log(LogStatus.FAIL, "Login test has failed due to an exception - check console log");
			throw e;
		}
	}
	
	public void unregisteredSignup(String name, String emailAddress, String password, ExtentTest node) throws InterruptedException, IOException
	{
		userName.sendKeys(name);
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		submitLogin.click();
		takeSS(driver,TestingProperties.getScreenshotFolder()+"/UnRegisteredNoLogin.jpg");
		validateSignUpTest(node);
	}
	
	public void validateSignUpPage(ExtentTest node) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Assert.assertEquals(otpMsg.getText(),"Sign up");
			node.log(LogStatus.PASS, "Initial Signup Page test passed successfully");
		}
		catch(AssertionError e)
		{
			node.log(LogStatus.FAIL, "Initial Signup Pagetest failed due to an exception - check console log");
			throw e;
		}
	}
	public void runSignUpTest(String mobile, String name, String emailAddress, String password) throws IOException
	{
		mobileNumber.sendKeys(mobile);
		userName.sendKeys(name);
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		takeSS(driver,TestingProperties.getScreenshotFolder()+"/AccountSignupDetails.jpg");
		submitLogin.click();
	}
	
	public void validateSignUpTest(ExtentTest node) throws InterruptedException, IOException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(TestingProperties.getLoadAndWaitTimeout()));
			wait.until(ExpectedConditions.textToBePresentInElement(submitLogin, "VERIFY OTP"));
			takeSS(driver,TestingProperties.getScreenshotFolder()+"/AccountSignupClick.jpg");
			Assert.assertEquals(submitLogin.getText(),"VERIFY OTP");
			node.log(LogStatus.PASS, "Signup test passed successfully");
		}
		catch(AssertionError e)
		{
			System.out.println("Assertion Error Catch block entered");
			node.log(LogStatus.FAIL, "Signup test failed due to an error - check console log");
			throw e;
		}
	}
	
	public void runLocationTest(String location) throws InterruptedException, IOException
	{
		locationSearch.sendKeys(location);
		findFoodSearch.get(0).click();
		takeSS(driver,TestingProperties.getScreenshotFolder()+"/FindFoodSubmitted.jpg");
	}
}
