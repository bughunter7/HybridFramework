package com.para.testcase;

import org.testng.annotations.Test;

import com.para.base.BaseDriver;
import com.para.utilities.WebUtility;

public class TestClass extends BaseDriver {
	
	WebUtility util=new WebUtility();
	@Test
	public void login()
	{
		initilization();
		util.loginutil();
		
	}

}
