package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RestaurantsPage;

public class Search
{
	private WebDriver driver;
	private HomePage home;
	private ExtentReports extent;
	private ExtentTest logger;
	RestaurantsPage location; 
	
	@Given("^user access swiggy website$")
    public void user_access_swiggy_website() throws Throwable
	{
		driver = CucumberSetup.driver;
		extent = new ExtentReports("./extentReports/SwiggyRegressionTests_ExtentReport.html",false);
		home = new HomePage(driver);
		logger = extent.startTest("Location Search");
    }

    @When("^user enters location (.+)$")
    public void user_enters_location(String location) throws Throwable
    {
    	home.runLocationTest(location);
    }

    @Then("^site should display restaurants available in location$")
    public void site_should_display_restaurants_available_in_location() throws Throwable
    {
    	location = new RestaurantsPage(driver);
    	location.validateLocationSearch(logger);
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
    }
    
    @And("^provide generic search functionality to run additional food or restaurant searches$")
    public void provide_generic_search_functionality_to_run_additional_food_or_restaurant_searches() throws Throwable
    {
    	extent = new ExtentReports("./extentReports/Search.html",false);
    	logger = extent.startTest("Allow generic food or restaurant search");
    	location.searchBarActions(logger);
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
    }
}
