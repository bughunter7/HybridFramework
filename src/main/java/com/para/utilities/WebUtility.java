package com.para.utilities;



import org.apache.commons.lang3.RandomStringUtils;

import com.para.base.BaseDriver;

import com.para.pages.LoginPage;
import com.para.pages.RegisterPage;

public class WebUtility extends BaseDriver{

	LoginPage lp;
	RegisterPage rp;
	
	

	public void loginutil() {
		
		lp = new LoginPage(driver);
		
		lp.username().sendKeys("testuser ayTAj");
		lp.password().sendKeys("test123");
		lp.login().click();

	}
	
	public void fillregistrationdetails()
	{
		rp=new RegisterPage(driver);
		
		rp.firstname().sendKeys("test");
		rp.lastname().sendKeys("test");
		rp.address().sendKeys("test address");
		rp.city().sendKeys("test city");
		rp.state().sendKeys("test state");
		rp.zip().sendKeys("1234");
		rp.phone().sendKeys("9999999999");
		rp.ssn().sendKeys("123456");
		
		rp.username().sendKeys("testuser "+RandomStringUtils.randomAlphanumeric(5));
		rp.password().sendKeys("test123");
		rp.cpassword().sendKeys("test123");
		
	}
}
