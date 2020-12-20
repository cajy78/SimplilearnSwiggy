package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class AccountSignup
{
	private WebDriver driver;
	private HomePage home;
	private ExtentReports extent;
	private ExtentTest logger;
	
	@Given("^user accesses swiggy$")
    public void user_accesses_swiggy() throws Throwable
	{
		driver = CucumberSetup.driver;
		extent = new ExtentReports("./extentReports/SwiggyRegressionTests_ExtentReport.html", false);
		home = new HomePage(driver);
		logger = extent.startTest("Swiggy Signup Page Test");
    }
	
	@When("^user clicks on Sign up$")
    public void user_clicks_on_sign_up() throws Throwable {
		home.signUpClick();
    }
	
	@Then("^site should display signup page$")
    public void site_should_display_signup_page() throws Throwable {
        home.validateSignUpPage(logger);
        extent.endTest(logger);
        extent.flush();
        extent.close();
    }
	
	@Given("^Unregistered user accesses swiggy and clicks on signup$")
    public void unregistered_user_accesses_swiggy_and_clicks_on_signup() throws Throwable
	{	//logger = extent.startTest("Swiggy Signup Test");
		driver = CucumberSetup.driver;
		extent = new ExtentReports("./extentreports/Signup.html", false);
		home = new HomePage(driver);
		logger = extent.startTest("Swiggy Signup  Test");
		home.signUpClick();
    }

    @When("^user enters (.+), (.+), (.+), and (.+)$")
    public void user_enters_and(String phonenumber, String name, String emailaddress, String password) throws Throwable
    {
    	home.runSignUpTest(phonenumber, name, emailaddress, password);
    }

    @Then("^site should create user account$")
    public void site_should_create_user_account() throws Throwable {
        home.validateSignUpTest(logger);
        extent.endTest(logger);
        extent.flush();
        extent.close();
    }

//    @And("^send a one time pin to verify user number$")
//    public void send_a_one_time_pin_to_verify_user_number() throws Throwable {
//        throw new PendingException();
//    }
}
