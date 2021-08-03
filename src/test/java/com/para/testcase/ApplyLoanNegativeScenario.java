package com.para.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.listener.CustomListener;
import com.para.pages.RequestLoanPage;
import com.para.utilities.WebUtility;

public class ApplyLoanNegativeScenario extends CustomListener {
	
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
		rl.amouunt().sendKeys("10000000000000000");
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
		String expected="We cannot grant a loan in that amount with your available funds.";
		Assert.assertEquals(status, expected);
	}

}
