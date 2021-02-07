package steps;

import com.vodefone.pages.Accountpage;
import com.vodefone.pages.Homepage;
import com.vodefone.pages.Loginpage;
import com.vodefone.pages.Registerpage;
import com.vodefone.tests.TestBaseCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class ChooseBlouseSteps extends TestBaseCucumber {
    Homepage homeobject;
    Loginpage loginobject;
    Registerpage registerobject;
    Accountpage accountobject;

    public ChooseBlouseSteps() throws IOException {
    }


    @Given("user in account page")
    public void user_in_account_page()
    {


    }
    @When("choose women category and sub category blouse")
    public void choose_women_category_and_subcategory_blouse()
    {
        accountobject=new Accountpage(driver);
        accountobject.chooseBlousesPage();
    }
    @Then("blouse page open successfully")
    public void blouse_page_open_successfully()
    {
        String ExpectedResult="BLOUSES ";
        String ActualResult=accountobject.blouseshowinpage.getText();
        System.out.println(ActualResult);
        Assert.assertEquals(ExpectedResult,ActualResult);
    }
}
