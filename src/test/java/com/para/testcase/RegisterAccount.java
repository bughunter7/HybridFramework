package com.para.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.base.BaseDriver;
import com.para.listener.CustomListener;
import com.para.listener.Inittest;
import com.para.pages.RegisterPage;
import com.para.utilities.WebUtility;

public class RegisterAccount extends CustomListener {

	RegisterPage rp;
	
	WebUtility util=new WebUtility();
	
	
	@Test(priority = 1)
	public void navigatetoregister()
	{
		//initilization();
		rp=new RegisterPage(driver);
		rp.registerlink().click();
	}
	
	@Test(priority = 2)
	public void fillinalldetails() throws IOException, InterruptedException
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
