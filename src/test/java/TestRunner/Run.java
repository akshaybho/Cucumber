package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/Customer.feature",".//Features/LoginPageFeature.feature"},
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@Sanity",
		//tags = "@sanity" - only sanity scenarios
		//tags = "@sanity or @regression" - willl run sanity or regression
		//tags = "@sanity and @regression" - will run sanity as well as regression both tags in one scenario
		//tags = "@sanity and not @regression" - will run sanity not regression
		plugin = {"pretty", "html:target/cucumber-reports/reports1.html"}
		)
public class Run {

}
