package com.para.testcase;


import org.testng.annotations.Test;

import com.para.base.BaseDriver;
import com.para.listener.CustomListener;
import com.para.utilities.WebUtility;

public class LoginAccount extends BaseDriver {
	
	WebUtility util=new WebUtility();
	
	RegisterAccount rac=new RegisterAccount();
	@Test
	public void login()
	{
		initilization();
		util.loginutil();
		
		
	}

}
