package com.para.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	public static Properties prop;
	WebDriver driver;

	public static Properties configreader()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\ParaBank_Automation\\src\\main\\java\\com\\para\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

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
