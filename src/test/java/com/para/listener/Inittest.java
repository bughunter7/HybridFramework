package com.para.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.para.base.BaseDriver;
import com.para.utilities.ExtentReporter;

public class Inittest extends BaseDriver implements ITestListener {

	ExtentReports extent = ExtentReporter.getReportObject();

	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static ExtentTest child;
	public static ExtentTest logger;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		initilization();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		test.get().pass("Test passed");
		child.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		if (result.getStatus() == ITestResult.FAILURE) {

			String temp = ShotonFailure(driver, result.getMethod().getMethodName());

			try {
				test.get().fail(result.getMethod().getMethodName(),
						MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

				test.get().fail("Test Failed");
				test.get().fail(result.getThrowable());
				child.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		child = parentTest.get().createNode(result.getMethod().getMethodName());
		test.set(child);
		child.log(Status.SKIP, "Test skipped");
		test.get().skip(result.getThrowable());
		child.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		try {
			initilization();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("test started");

		ExtentTest parent = extent.createTest(getClass().getSimpleName());

		parentTest.set(parent);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		child.log(Status.PASS, "Driver Closed");
		extent.flush();

		driver.close();
	}

}
