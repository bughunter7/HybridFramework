package com.para.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	By registerlink=By.xpath("//*[@id='leftPanel']/div/p[2]/a");
	By firstname=By.xpath("//*[@id='customer.firstName']");
	By lastname=By.xpath("//*[@id='customer.lastName']");
	By address=By.xpath("//*[@id='customer.address.street']");
	By city=By.xpath("//*[@id='customer.address.city']");
	By state=By.xpath("//*[@id='customer.address.state']");
	By zip=By.xpath("//*[@id='customer.address.zipCode']");
	By phone=By.xpath("//*[@id='customer.phoneNumber']");
	By ssn=By.xpath("//*[@id='customer.ssn']");
	By username=By.xpath("//*[@id='customer.username']");
	By password=By.xpath("//*[@id='customer.password']");
	By cpassword=By.xpath("//*[@id='repeatedPassword']");
	By registerbutton=By.xpath("//*[@value='Register']");
	By registersuccess=By.xpath("//*[@id='rightPanel']/p");
	
	
	By extractor=By.xpath("//*[@id='rightPanel']/h1");
	
	public WebElement registerlink()
	{
		return driver.findElement(registerlink);
	}
	
	public WebElement firstname()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement lastname()
	{
		return driver.findElement(lastname);
	}
	
	public WebElement address()
	{
		return driver.findElement(address);
	}
	
	public WebElement city()
	{
		return driver.findElement(city);
	}
	
	public WebElement state()
	{
		return driver.findElement(state);
	}
	
	public WebElement zip()
	{

		return driver.findElement(zip);
	}
	
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement ssn()
	{
		return driver.findElement(ssn);
	}
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement cpassword()
	{
		return driver.findElement(cpassword);
	}
	
	public WebElement registerbutton()
	{
		return driver.findElement(registerbutton);
	}
	
	public WebElement message()
	{
		return driver.findElement(registersuccess);
	}
	
	public WebElement extractor()
	{
		return driver.findElement(extractor);
	}
}
