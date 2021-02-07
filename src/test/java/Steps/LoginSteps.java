package Steps;

import Data.JsonDataReader;
import com.vodefone.pages.Accountpage;
import com.vodefone.pages.Homepage;
import com.vodefone.pages.Loginpage;
import com.vodefone.tests.TestBaseCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;


public class LoginSteps extends TestBaseCucumber {

    Homepage homeobject;
    Loginpage loginobject;
    Accountpage accountobject;

    public LoginSteps() throws IOException {
    }

    @Given("the user in home page")
    public void the_user_in_home_page()
    {

        homeobject=new Homepage(driver);
        homeobject.openLoginPage();
    }
    @When("Enter {string} and {string} and click on login button")
    public void Enter_and_and_click_on_login_button(String email,String password) throws IOException, ParseException {
        loginobject=new Loginpage(driver);
        JsonDataReader jsonreader = new JsonDataReader();
        jsonreader.JsonReader();
        loginobject.login_user(jsonreader.email,jsonreader.password);
    }
    @Then("user successfully login")
    public void user_successfully_login()
    {
        accountobject=new Accountpage(driver);
        Assert.assertTrue(accountobject.logoutbutton.isDisplayed());

    }
}
