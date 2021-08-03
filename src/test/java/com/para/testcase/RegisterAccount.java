package com.para.testcase;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.base.BaseDriver;
import com.para.listener.CustomListener;
import com.para.pages.RegisterPage;
import com.para.utilities.WebUtility;

public class RegisterAccount extends CustomListener {

	public static RegisterPage rp;
	
	public static String username;
	
	static String  fstr;
	
	WebUtility util=new WebUtility();
	
	
	
	@Test(priority = 1)
	public void navigatetoregister()
	{
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
	public static void verifyregistration()
	{
		String expected="Your account was created successfully. You are now logged in.";
		Assert.assertEquals(rp.message().getText(), expected);
	}
	
	
		
}
