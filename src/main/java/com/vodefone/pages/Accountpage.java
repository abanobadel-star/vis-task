package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Accountpage extends PageBase {

	public Accountpage(WebDriver driver) {
		super(driver);
		 Action =new Actions(driver);
	}
	
	@FindBy(linkText ="Sign out")
    public WebElement logoutbutton;
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement womentab;
	
	@FindBy(linkText="Blouses")
	WebElement blousestab;
	
	@FindBy(css="span.cat-name")
	 public WebElement blouseshowinpage;
	
	public void chooseBlousesPage()
	{
		
		Action.moveToElement(womentab).build().perform();
		Action.moveToElement(blousestab).click().build().perform();
	}
	
	public void logout()
	{
		logoutbutton.click();
	}

}
