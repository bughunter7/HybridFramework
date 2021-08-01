package com.para.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.para.base.DriverFactory;

public class DemoRun extends DriverFactory {

	@Test
	public void test() {
		WebDriver driver = initdriver();
	}
}
