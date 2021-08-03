package com.para.testcase;

import org.testng.annotations.Test;

import com.para.listener.CustomListener;
import com.para.utilities.WebUtility;

public class PayBill extends CustomListener {

	WebUtility util = new WebUtility();

	RegisterAccount rac = new RegisterAccount();

	@Test
	public void login() {
		// initilization();
		util.loginutil();
	}
	
	public void navigatetopaybill()
	{
		
	}
	public void fillinalldetails()
	{
		
	}
	public void submit()
	{
		
	}
	public void verifymessage()
	{
		
	}

}
