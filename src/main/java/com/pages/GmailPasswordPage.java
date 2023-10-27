package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailPasswordPage extends BasePage {

	public GmailPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By pass = By.xpath("//input[@class='whsOnd zHQkBf']");
	private By submit = By.xpath("//span[normalize-space()='Next']");
	public void setPasswordAndLogin() throws InterruptedException
	{
		getElement(pass).sendKeys("abc");
		Thread.sleep(4000);
		getElement(submit).click();
		Thread.sleep(8000);
		
	}
}
