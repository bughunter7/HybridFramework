package com.para.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayBillPage {

	WebDriver driver;

	public PayBillPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By paybill = By.xpath("//*[@id='leftPanel']/ul/li[4]");

	By payeename = By.xpath("//*[@name='payee.name']");
	By address = By.xpath("//*[@name='payee.address.street']");
	By city = By.xpath("//*[@name='payee.address.city']");
	By state = By.xpath("//*[@name='payee.address.state']");
	By zipcode = By.xpath("//*[@name='payee.address.zipCode']");
	By phone = By.xpath("//*[@name='payee.phoneNumber']");
	By account = By.xpath("//*[@name='payee.accountNumber']");
	By vaccount = By.xpath("//*[@name='verifyAccount']");
	By amount = By.xpath("//*[@name='amount']");
	By sendpayment = By.xpath("(//*[@class='button'])[2]");
	
	By messagetitle=By.xpath("//*[@class='ng-scope']/div[2]/h1");

	public WebElement paybill() {
		return driver.findElement(paybill);
	}

	public WebElement payeename()
	{
		return driver.findElement(payeename);
	}
	public WebElement address() {
		return driver.findElement(address);
	}

	public WebElement city() {
		return driver.findElement(city);
	}

	public WebElement state() {
		return driver.findElement(state);
	}

	public WebElement zipcode() {
		return driver.findElement(zipcode);
	}

	public WebElement phone() {
		return driver.findElement(phone);
	}

	public WebElement account() {
		return driver.findElement(account);
	}

	public WebElement vaccount() {
		return driver.findElement(vaccount);
	}

	public WebElement amount() {
		return driver.findElement(amount);
	}

	public WebElement sendpayment() {
		return driver.findElement(sendpayment);
	}
	
	public WebElement message()
	{
		return driver.findElement(messagetitle);
	}
	

}
