package com.para.testcase;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.para.base.BaseDriver;

import com.para.listener.CustomListener;

import com.para.utilities.WebUtility;


public class Login extends CustomListener {

	WebUtility util = new WebUtility();

	@Test(priority = 1)
	public void login() throws IOException {

		util.loginutil();
		child.log(Status.PASS, "Test Executed");
		child.addScreenCaptureFromPath(getdesiredshot(driver));
	}

}
