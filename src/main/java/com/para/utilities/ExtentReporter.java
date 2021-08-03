package com.para.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {

		String timestamp=new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(new Date());
		String path = System.getProperty("user.dir") + "\\Reports\\Reports_"+timestamp+ ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("ParaBank Automation Results");
		reporter.config().setDocumentTitle("ParaBank Automation Results");
		
		reporter.config().setTheme(Theme.DARK);
		
	

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shubham Parab");
		extent.setSystemInfo("Host", "Windows");
		extent.setSystemInfo("Environment", "Staging");
		
		
		return extent;

		

	}
	
	public static ExtentReports getInstance() {
        if(extent == null) {
           getReportObject();
        }   
        return extent;
    }

}
