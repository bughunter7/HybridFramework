package com.para.utilities;

import com.para.base.BaseDriver;

import com.para.pages.LoginPage;

public class WebUtility extends BaseDriver {

	LoginPage lp;

	public void loginutil() {
		
		lp = new LoginPage(driver);
		lp.username().sendKeys("username");
		lp.password().sendKeys("user");
		lp.login().click();

	}
}
