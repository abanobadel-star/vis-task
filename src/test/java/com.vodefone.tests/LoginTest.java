package com.vodefone.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vodefone.pages.Accountpage;
import com.vodefone.pages.Homepage;
import com.vodefone.pages.Loginpage;

import Data.JsonDataReader;

public class LoginTest extends TestBase {

	public LoginTest() throws IOException {
		super();
	}
	Homepage homeobject;
	Loginpage loginobject;
	Accountpage accountobject;
	
	@Test(priority=2)
	public void LoginUser() throws IOException, ParseException
	{
		JsonDataReader jsonreader = new JsonDataReader();
        jsonreader.JsonReader();
		homeobject=new Homepage(driver);
		homeobject.openLoginPage();
		loginobject=new Loginpage(driver);
		loginobject.login_user(jsonreader.email, jsonreader.password);
		accountobject=new Accountpage(driver);
		Assert.assertTrue(accountobject.logoutbutton.isDisplayed());
		
	}
}
