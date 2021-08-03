package com.para.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.base.BaseDriver;
import com.para.listener.CustomListener;
import com.para.pages.RequestLoanPage;
import com.para.utilities.WebUtility;

public class ApplyLoanPositiveScenario extends CustomListener{

	WebUtility util=new WebUtility();
	RequestLoanPage rl;
	@Test(priority = 1)
	public void login()
	{
		//initilization();
		util.loginutil();
	}
	
	@Test(priority = 2)
	public void navigatetorequestload()
	{
		rl=new RequestLoanPage(driver);
		rl.requestloan().click();
	}
	
	@Test(priority = 3)
	public void fillinloandetails()
	{
		rl.amouunt().sendKeys("100");
		rl.downpayment().sendKeys("100");
		
	}
	@Test(priority = 4)
	public void applyloan()
	{
		rl.button().click();
	}
	
	@Test(priority = 5)
	public void verifystatus() throws InterruptedException
	{
		Thread.sleep(5000);
		String status=rl.status().getText();
		System.out.println(status);
		String expected="Congratulations, your loan has been approved.";
		Assert.assertEquals(status, expected);
	}
}
