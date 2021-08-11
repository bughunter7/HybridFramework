package com.para.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.para.listener.CustomListener;
import com.para.utilities.WebUtility;

public class Login extends CustomListener {

	
	WebUtility util=new WebUtility();
	
	@Test(priority = 1)
	public void login() throws IOException {
		//initilization();
		child.addScreenCaptureFromPath(getdesiredshot(driver));
		util.loginutil();
	}
}
