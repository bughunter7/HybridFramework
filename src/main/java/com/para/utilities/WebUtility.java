package com.para.utilities;



import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

import com.para.base.BaseDriver;

import com.para.pages.LoginPage;
import com.para.pages.PayBillPage;
import com.para.pages.RegisterPage;

public class WebUtility extends BaseDriver{

	LoginPage lp;
	RegisterPage rp;
	PayBillPage pb;
	
	DataDriven data=new DataDriven();

	public void loginutil() {
		
		lp = new LoginPage(driver);
		
		lp.username().sendKeys("bughunter YoJWZ");
		lp.password().sendKeys("test123");
		lp.login().click();

	}
	
	public void fillregistrationdetails() throws IOException, InterruptedException
	{
		ArrayList<String> testdata=data.getData("Register");
		rp=new RegisterPage(driver);
		
		rp.firstname().sendKeys(testdata.get(1));
		rp.lastname().sendKeys(testdata.get(2));
		rp.address().sendKeys(testdata.get(3));
		rp.city().sendKeys(testdata.get(4));
		rp.state().sendKeys(testdata.get(5));
		rp.zip().sendKeys(testdata.get(6));
		rp.phone().sendKeys(testdata.get(7));
		rp.ssn().sendKeys(testdata.get(8));
		
		rp.username().sendKeys(testdata.get(9)+" "+RandomStringUtils.randomAlphanumeric(5));
		rp.password().sendKeys(testdata.get(10));
		rp.cpassword().sendKeys(testdata.get(11));
		Thread.sleep(5000);
		
	}
	
	public void fillinbilldetails() throws IOException
	{
		ArrayList<String> testdata=data.getData("PayBill");
		pb=new PayBillPage(driver);
		
		pb.payeename().sendKeys(testdata.get(1));
		pb.address().sendKeys(testdata.get(2));
		pb.city().sendKeys(testdata.get(3));
		pb.state().sendKeys(testdata.get(4));
		pb.zipcode().sendKeys(testdata.get(5));
		pb.phone().sendKeys(testdata.get(6));
		pb.account().sendKeys(testdata.get(7));
		pb.vaccount().sendKeys(testdata.get(8));
		pb.amount().sendKeys(testdata.get(9));
		
	}
}
