package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Processcheckoutpage extends PageBase {

	public Processcheckoutpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//i[@class='icon-plus']")
	WebElement increasebutton;
	
	 @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedbutton1;
	
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement proceedbutton2;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement agreecheckbox;
	
    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedbutton3;
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankwire;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement confirmmyorder;
	
	@FindBy(css="p.cheque-indent")
	 public WebElement ordercompletemssage;
	
	public void checkout_product()
	{
		increasebutton.click();
		proceedbutton1.click();
		proceedbutton2.click();
		agreecheckbox.click();
		proceedbutton3.click();
		bankwire.click();
		confirmmyorder.click();
		
	}

}
