package testrunner;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testcases.TestCaseListeners;

@CucumberOptions(
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber-html", "json:target/cucumber.json"},
		features = "src/test/java/features",
		//tags = "~@Ignore"
		glue = {"stepdefinitions"}
		)
@Test
@Listeners(TestCaseListeners.class)
public class TestRunner extends AbstractTestNGCucumberTests
{
}
