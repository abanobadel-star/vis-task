package steps;

import com.vodefone.pages.BlouseProductPage;
import com.vodefone.pages.Processcheckoutpage;
import com.vodefone.tests.TestBaseCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class ProductProcessSteps extends TestBaseCucumber {

    BlouseProductPage blouseobject;
    Processcheckoutpage processobject;

    public ProductProcessSteps() throws IOException {
    }

    @Given("After user choose product")
    public void After_user_choose_product()
    {

       blouseobject=new BlouseProductPage(driver);
       blouseobject.click_on_product();
    }
    @When("select size and color")
    public void select_size_and_color()
    {
        blouseobject.choose_color_size();
    }
    @And("click add product to cart")
    public void click_add_product_to_cart()
    {
        blouseobject.add_product_to_cart();
    }
    @Then("product add successfully to cart")
    public  void product_add_successfully_to_cart()
    {
        String ExpectedResult="Product";
        String ActualResult=blouseobject.successmessageproductaddtocart.getText();
        System.out.println(ActualResult);
        Assert.assertEquals(ExpectedResult,ActualResult);
    }
    @Given("product in cart")
    public void product_in_cart()
    {

    }
    @When("choose payment type and confirm process")
    public void choose_payment_type()
    {
        processobject=new Processcheckoutpage(driver);
        processobject.checkout_product();

    }
    @Then("product sucessfully checkout")
    public void product_sucessfully_checkout()
    {
        Assert.assertEquals("Your order on My Store is complete.",processobject.ordercompletemssage.getText());
    }

}
