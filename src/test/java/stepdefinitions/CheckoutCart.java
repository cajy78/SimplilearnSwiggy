package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FoodORRestoSearch;
import pages.HomePage;
import pages.RestaurantsPage;

public class CheckoutCart
{
	private WebDriver driver;
	private HomePage home;
	private ExtentReports extent;
	private ExtentTest logger;
	private ExtentTest node;
	RestaurantsPage restoList;
	FoodORRestoSearch frs;
	
	@Given("^user accesses Swiggy$")
    public void user_accesses_swiggy() throws Throwable {
		driver = CucumberSetup.driver;
		extent = new ExtentReports("./extentReports/SwiggyRegressionTests_ExtentReport.html",false);
		home = new HomePage(driver);
		logger = extent.startTest("Add to cart and Checkout");
    }
	
	@And("^user searches for restaurant at (.+)$")
    public void user_searches_for_restaurant_at(String location) throws Throwable {
		home.runLocationTest(location);
		node = extent.startTest("Search restaurants in "+location);
		node.log(LogStatus.PASS, "Search restaurants in "+location+" Completed");
		logger.appendChild(node);
		extent.endTest(node);
    }

    @When("^user runs a generic search for (.+)$")
    public void user_runs_a_generic_search_for(String fooditem) throws Throwable {
    	restoList = new RestaurantsPage(driver);
    	node = extent.startTest("Enter Generic Search Page");
        restoList.checkoutSearchActions(node, logger);
        extent.endTest(node);
        node = extent.startTest("Search food item "+ fooditem);
        frs = new FoodORRestoSearch(driver);
        frs.runFoodAddToCartSearch(node, logger, fooditem);
        logger.appendChild(node);
    }
    
    @And("^user clicks on Add$")
    public void user_clicks_on_add() throws Throwable
    {
    	node = extent.startTest("Add to cart Test");
    	frs.addToCartTest();
    }

    @Then("^website should add items to food cart$")
    public void website_should_add_items_to_food_cart() throws Throwable
    {
    	frs.validateCartTest(node);
    	logger.appendChild(node);
    }

    @And("^allow user to purchase items in cart$")
    public void allow_user_to_purchase_items_in_cart() throws Throwable {
    	node = extent.startTest("Allow user to purchase");
    	node.log(LogStatus.SKIP, "Test skipped since purchase requires user login and payment details");
    	logger.appendChild(node);
    	extent.endTest(node);
    	extent.endTest(logger);
        extent.flush();
        extent.close();
        throw new SkipException("Test skipped since purchase without login is not possible");
    }
}
