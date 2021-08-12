package com.para.testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.para.base.BaseDriver;

import com.para.listener.CustomListener;
import com.para.pages.PayBillPage;
import com.para.utilities.DataDriven;
import com.para.utilities.WebUtility;


public class PayBill extends CustomListener {

	WebUtility util = new WebUtility();

	PayBillPage pb;

	@Test(priority = 1)
	public void login() {
		// initilization();
		util.loginutil();
	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void navigatetopaybill() {
		pb = new PayBillPage(driver);
		pb.paybill().click();
	}

	@Test(priority = 3, dependsOnMethods = "navigatetopaybill")
	public void fillinalldetails() throws IOException {

		util.fillinbilldetails();
	}

	@Test(priority = 4, dependsOnMethods = "fillinalldetails")
	public void submit() {
		pb.sendpayment().click();
	}

	@Test(priority = 5, dependsOnMethods = "submit")
	public void verifymessage() throws InterruptedException {
		Thread.sleep(5000);
		String expected = "Bill Payment Complete";
		String verifymessage = pb.message().getText();
		AssertJUnit.assertEquals(verifymessage, expected);
	}

}
