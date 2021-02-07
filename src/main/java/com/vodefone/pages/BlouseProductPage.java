package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BlouseProductPage extends PageBase {

	public BlouseProductPage(WebDriver driver) {
		super(driver);
		Action=new Actions(driver);
	}
	//@FindBy(xpath="//img[@title='Blouse']")
	@FindBy(xpath = "//a[@class='product-name' and @title='Blouse']")
	WebElement blouseproduct;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addtocartbutton;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedtocheckoutbutton;
	
	@FindBy(css="span.ajax_cart_product_txt ")
	public WebElement successmessageproductaddtocart;

	@FindBy(css="a.button lnk_view btn btn-default")
	WebElement morebutton;

	@FindBy(id ="group_1")
	WebElement size;

	@FindBy(id="color_8")
	WebElement whitecolor;


	public void click_on_product()
	{
		blouseproduct.click();
	}
	public void choose_color_size()
	{
		Select sizem =new Select(size);
		size.click();
		sizem.selectByVisibleText("M");
		Action.moveToElement(whitecolor).click().build().perform();
	}
	public void add_product_to_cart()
	{
		addtocartbutton.click();
		proceedtocheckoutbutton.click();
	}


}
