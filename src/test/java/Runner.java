

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
       // plugin = {"pretty", "html:target/index.html", "json:target/cucumber.json"},
        features = "src/test/resources/features",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"summary" }/* , tags = "@both" */ )

public class Runner {

}
