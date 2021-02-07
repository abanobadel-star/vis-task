package Steps;

import Data.JsonDataReader;
import com.vodefone.pages.Accountpage;
import com.vodefone.pages.Homepage;
import com.vodefone.pages.Loginpage;
import com.vodefone.pages.Registerpage;
import com.vodefone.tests.TestBaseCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;


public class RegisterSteps extends TestBaseCucumber {

    Homepage homeobject;
    Loginpage loginobject;
    Registerpage registerobject;
    Accountpage accountobject;



    public RegisterSteps() throws IOException {
    }

    @Given("user in home page")
    public void user_in_home_page()
    {
        startdriver();
        homeobject=new Homepage(driver);
       loginobject= (Loginpage) homeobject.openLoginPage();


    }
    @When("user enter {string} and click on create an account")
    public void user_enter_and_click_on_create_anaccount(String string) throws IOException, ParseException {
        loginobject=new Loginpage(driver);
        JsonDataReader jsonreader = new JsonDataReader();
        jsonreader.JsonReader();
        loginobject.send_email_to_create_new_account(jsonreader.email);

    }
    @When("enter {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and click on register button")
    public void enter_and_and_and_and_and_and_and_and_and_and_and_click_on_register_button(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) throws IOException, ParseException {
        registerobject=new Registerpage(driver);
        JsonDataReader jsonreader = new JsonDataReader();
        jsonreader.JsonReader();
      registerobject.RegisterNewUser(jsonreader.firstname,jsonreader.lastname,jsonreader.email,jsonreader.password,jsonreader.address,jsonreader.city,jsonreader.state,jsonreader.zipcode,jsonreader.country,jsonreader.mobile,jsonreader.alias);
    }
    @Then("user register successfully")
    public void user_register_successfully()
    {
        accountobject=new Accountpage(driver);
        Assert.assertTrue(accountobject.logoutbutton.isDisplayed());
        accountobject.logout();
    }
}
