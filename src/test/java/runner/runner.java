package runner;

import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/feature",
        glue="steps",
        tags="@Amazon1",
        plugin = {"json:target/cucumber.json"}
)
public class runner {
	/*@AfterClass
	public static void cleanDriver(){
	BasePage.closeBrowser();*/
	//}
}