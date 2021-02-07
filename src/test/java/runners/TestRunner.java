package runners;


import com.vodefone.tests.TestBaseCucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/features",glue ={"steps"}, plugin= {"pretty","html:target/report/cucumber-html-report.html"})
public class TestRunner  {

}
