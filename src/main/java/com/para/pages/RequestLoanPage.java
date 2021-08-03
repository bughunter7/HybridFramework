package com.para.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestLoanPage {
	
	WebDriver driver;
	public RequestLoanPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	By requestloan=By.xpath("//*[@id='leftPanel']/ul/li[7]");
	
	By amount=By.xpath("//*[@id='amount']");
	By downpayment=By.xpath("//*[@id='downPayment']");
	By button=By.xpath("(//*[@class='button'])[2]");
	By status=By.xpath("(//*[@class='ng-scope'])[4]/p[1]");
	
	
	public WebElement requestloan()
	{
		return driver.findElement(requestloan);
	}

	public WebElement amouunt()
	{
		return driver.findElement(amount);
	}
	
	public WebElement downpayment()
	{
		return driver.findElement(downpayment);
	}
	
	public WebElement button()
	{
		return driver.findElement(button);
	}
	
	public WebElement status()
	{
		return driver.findElement(status);
	}
}
