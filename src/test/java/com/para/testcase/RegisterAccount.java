package com.para.testcase;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.base.BaseDriver;

import com.para.pages.RegisterPage;
import com.para.utilities.WebUtility;

public class RegisterAccount extends BaseDriver {

	RegisterPage rp;
	
	WebUtility util=new WebUtility();
	
	
	@Test(priority = 1)
	public void navigatetoregister()
	{
		initilization();
		rp=new RegisterPage(driver);
		rp.registerlink().click();
	}
	
	@Test(priority = 2)
	public void fillinalldetails()
	{
		util.fillregistrationdetails();
		
	}
	@Test(priority = 3)
	public void submitregisterbutton()
	{
		rp.registerbutton().click();
	}
	
	@Test(priority = 4)
	public void verifyregistration()
	{
		String message=rp.message().getText();
		String expected="Your account was created successfully. You are now logged in.";
		Assert.assertEquals(message, expected);
	}
	
	
		
}
