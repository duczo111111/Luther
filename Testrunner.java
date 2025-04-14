package saucelab;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "src/test/resources/Feature",
				glue = "saucelab",
				plugin = {"pretty", "html:target/REPORT/HTML-REPORT.html"}
				)

public class Testrunner {

}
