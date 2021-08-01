package com.para.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.para.base.BaseDriver;

public class LoginPage {

	public WebDriver driver;

	By username = By.xpath("//*[@name='username']");
	By password = By.xpath("//*[@name='password']");
	By login=By.xpath("(//*[@class='login'])[3]/input");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}

}

