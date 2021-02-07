package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage  extends PageBase{

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="email_create")
	public WebElement createemail;
	
	@FindBy(id="SubmitCreate")
	WebElement createaccountbutton;
	
	@FindBy(id="email")
	WebElement emailaddress;
	
	@FindBy(id="passwd")
	WebElement passwordtxt;
	
	@FindBy(id="SubmitLogin")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	 public WebElement confirmuserlogin;
	
	public  void send_email_to_create_new_account(String email)
	{
		createemail.sendKeys(email);
		createaccountbutton.click();
	}
	public void login_user(String email, String password)
	{
		emailaddress.sendKeys(email);
		passwordtxt.sendKeys(password);
		loginbutton.click();
    }
	

}
