package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import testproperties.TestingProperties;

public class AccountLogin
{
	private WebDriver driver;
	private HomePage home;
	private ExtentReports extent;
	private ExtentTest logger;
	
	@Given("^registered user accesses website and attempts to login$")
    public void registered_user_accesses_website_and_attempts_to_login() throws Throwable
	{
		driver = CucumberSetup.driver;
		extent = new ExtentReports(TestingProperties.getExtentReportLocation(), false);
		home = new HomePage(driver);
		logger = extent.startTest("Registered User Login");
		home.loginClick();
    }
	
	@When("^enters the (.+)$")
    public void enters_the_something(String registeredmobilenumber) throws Throwable
    {
		
		//System.out.println("Registered And run with "+registeredmobilenumber);
		//System.out.println("The logger status is "+logger.getTest().getStatus());
		home.runLoginTest(registeredmobilenumber);
    }
	
    @Then("^a One Time Pin is sent to the users number to login$")
    public void a_one_time_pin_is_sent_to_the_users_number_to_login() throws Throwable
    {
    	home.validateLogin(logger);
    	//System.out.println("The logger status is "+logger.getTest().getStatus());
    	//loggerResult(logger.getTest());
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
    }

    @Given("^unregistered user accesses website and attempts to login$")
    public void unregistered_user_accesses_website_and_attempts_to_login() throws Throwable
    {
    	driver = CucumberSetup.driver;
		home = new HomePage(driver);
		home.signUpClick();
    }
    
    @When("^enters unregistered (.+)$")
    public void enters_unregistered_something(String unregisteredmobilenumber) throws Throwable
    {
    	//System.out.println("Un-Registered And run "+ unregisteredmobilenumber);
    	home.runLoginTest(unregisteredmobilenumber);
    }

    @Then("^website should display signup options to enter (.+), (.+), and (.+)$")
    public void website_should_display_signup_options_to_enter_and(String name, String email, String password) throws Throwable
    {
    	home.unregisteredSignup(name, email, password);
    }
}
