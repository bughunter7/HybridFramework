package com.para.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.base.BaseDriver;
import com.para.pages.PayBillPage;
import com.para.utilities.WebUtility;

public class PayBill extends BaseDriver {

	WebUtility util = new WebUtility();
	PayBillPage pb;

	@Test(priority = 1)
	public void login() {
		initilization();
		util.loginutil();
	}

	@Test(priority = 2)
	public void navigatetopaybill() {
		pb = new PayBillPage(driver);
		pb.paybill().click();
	}

	@Test(priority = 3)
	public void fillinalldetails() {
		pb.payeename().sendKeys("test");
		pb.address().sendKeys("test address");
		pb.city().sendKeys("test city");
		pb.state().sendKeys("test state");
		pb.zipcode().sendKeys("1234");
		pb.phone().sendKeys("999999999");
		pb.account().sendKeys("1234");
		pb.vaccount().sendKeys("1234");
		pb.amount().sendKeys("1");
	}

	@Test(priority = 4)
	public void submit() {
		pb.sendpayment().click();
	}

	@Test(priority = 5)
	public void verifymessage() throws InterruptedException {
		Thread.sleep(5000);
		String expected = "Bill Payment Complete";
		String verifymessage = pb.message().getText();
		Assert.assertEquals(verifymessage, expected);
	}

}
