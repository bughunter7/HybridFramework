package com.para.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory extends ConfigReader {
	
	WebDriver driver;
	public WebDriver initdriver() {
		String browserName=configreader().getProperty("browser");
		//String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("Not a valid browser...please check config.properties");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		return driver;

	}

}
