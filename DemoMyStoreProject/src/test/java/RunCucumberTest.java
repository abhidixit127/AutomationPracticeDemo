

import org.junit.runner.RunWith;
 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Features/" }, plugin = { "pretty", "json:target/cucumber/cucumber.json","html:target/cucumber-reports" })

 
public class RunCucumberTest {
 
}