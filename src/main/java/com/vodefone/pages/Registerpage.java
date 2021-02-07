package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registerpage extends PageBase{

	public Registerpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="id_gender1")
	WebElement malegenderradiobutton;
	
	@FindBy(id="id_gender2")
	WebElement femalegenderradiobutton;
	
	@FindBy(id="customer_firstname")
	WebElement firstname;
	
	@FindBy(id="customer_lastname")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement emailtxtfield;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement daysbirthdate;
	
	@FindBy(id="months")
	WebElement monthbirthdate;
	
	@FindBy(id="years")
	WebElement yearsbirthdate;
	
	@FindBy(id="firstname")
	WebElement fnameaddress;
	
	@FindBy(id="lastname")
	WebElement lnameaddress;
	
	@FindBy(id="company")
	WebElement companyname;
	
	@FindBy(id="address1")
	WebElement addresstxtbox;
	
	@FindBy(id="city")
	WebElement cityname;
	
	@FindBy(id="id_state")
	WebElement statename;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement countryname;
	
	@FindBy(id="phone_mobile")
	WebElement phonenumber;
	
	@FindBy(id="alias")
	WebElement assignaddress;
	
	@FindBy(id="submitAccount")
	WebElement registerbutton;
	
	public void RegisterNewUser(String fname,String lname,String email,String passwordnum,
			String address,String city,String state,String postal,String country,String phone,String alixaddress)
	{
		
		malegenderradiobutton.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		emailtxtfield.clear();
		emailtxtfield.sendKeys(email);
		password.sendKeys(passwordnum);
//		Select select =new Select(daysbirthdate);
//		daysbirthdate.click();
//		select.selectByIndex(10);
//		Select select2 =new Select(monthbirthdate);
//		monthbirthdate.click();
//		select2.selectByIndex(5);
//		Select select3 =new Select(yearsbirthdate);
//		yearsbirthdate.click();
//		select3.selectByIndex(4);
//		fnameaddress.clear();
//		fnameaddress.sendKeys(firstnameaddress);
//	   lnameaddress.clear();
//		lnameaddress.sendKeys(lastnameaddress);
//		companyname.sendKeys(comapnyname);
		addresstxtbox.sendKeys(address);
		cityname.sendKeys(city);
		Select statenm =new Select(statename);
		statename.click();
		statenm.selectByIndex(5);
		postcode.sendKeys(postal);
		Select counrtynm =new Select(countryname);
		countryname.click();
		counrtynm.selectByIndex(1);
		
		phonenumber.sendKeys(phone);
		registerbutton.click();
		
		
	}
	
	
	
	

}
