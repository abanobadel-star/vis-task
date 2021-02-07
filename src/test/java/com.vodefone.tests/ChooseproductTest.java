package com.vodefone.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vodefone.pages.Accountpage;

public class ChooseproductTest extends TestBase {

	public ChooseproductTest() throws IOException {
		super();
		
	}

	Accountpage accountobject;
	
	@Test(priority=3)
	public void SelectBlouse()
	{
		accountobject=new Accountpage(driver);
		accountobject.chooseBlousesPage();
		String ExpectedResult="BLOUSES ";
		String ActualResult=accountobject.blouseshowinpage.getText();
		System.out.println(ActualResult);
		Assert.assertEquals(ExpectedResult, ActualResult);
       
		
	}
}
