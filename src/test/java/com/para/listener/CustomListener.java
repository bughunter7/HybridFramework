package com.para.listener;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.para.base.BaseDriver;
import com.para.utilities.ExtentReporter;

public class CustomListener extends BaseDriver {

	public static ExtentTest parent;
	public static ExtentTest child;

	public static ExtentTest logger;
	public static ExtentReports extent;

	@BeforeSuite
	public void beforesuite() {
		extent = ExtentReporter.getInstance();
	}

	@BeforeClass
	public void beforeClassrun(ITestContext content) throws InterruptedException {
		initilization();

		String Suitename = content.getCurrentXmlTest().getSuite().getName();
		parent = extent.createTest(getClass().getSimpleName()).assignCategory(Suitename);

		System.out.println("Before class");

	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("Before Test");
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		System.out.println("Before Method");

		child = parent.createNode(method.getName());

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("After Method");

		if (result.getStatus() == ITestResult.SUCCESS) {

			// parent.log(Status.PASS,"test pass");
			child.log(Status.PASS, "Test Pass");
			child.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

		} else if (result.getStatus() == ITestResult.FAILURE) {

			String temp = BaseDriver.ShotonFailure(driver, result.getMethod().getMethodName());
			// parent.log(Status.FAIL,"test fail");
			child.log(Status.FAIL, "Test Fail");
			child.log(Status.FAIL, result.getThrowable());
			child.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

			try {

				child.log(Status.FAIL, "Failed Screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		} else if (result.getStatus() == ITestResult.SKIP) {

			// parent.log(Status.SKIP,"test skip" );
			child.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
			child.log(Status.SKIP, "Test Skip");

		}

	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");

	}

	@AfterClass
	public void afterClassrun() {
		// driver.close();
		System.out.println("After Class");

	}

	@AfterSuite
	public void aftersuite() {
		extent.flush();
	}

}
