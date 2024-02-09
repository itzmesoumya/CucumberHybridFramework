package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",
				glue = {"stepdefinations","hooks"},
				publish = true,
				plugin = {"pretty","html:target/CucumberReports/cucumberReport.html",
						  "json:target/CucumberReports/cucumberReport.json",
						  "junit:target/CucumberReports/cucumberReport.xml"}
                 )
public class TestRunner {

	
}