package com.para.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	public static Properties prop;
	public static WebDriver driver;

	public BaseDriver() {
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\user\\eclipse-workspace\\HybridFramework\\src\\main\\java\\com\\para\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initilization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("unable to invoke browser.....please check config file.");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}

	// screenshot utilities

	public static String getdesiredshot(WebDriver driver) {
		TakesScreenshot tkscr = (TakesScreenshot) driver;

		File src = tkscr.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/TestCaseScreenShots/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {

			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Detected Failure while taking screenshot " + e.getMessage());
		}
		return path;
	}

	public static String ShotonFailure(WebDriver driver, String Testcase) {
		TakesScreenshot tkscr = (TakesScreenshot) driver;

		File src = tkscr.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/TestCaseScreenShots/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {

			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Detected Failure while taking screenshot " + e.getMessage());
		}
		return path;
	}

}
