package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailHomePage extends BasePage {

	public GmailHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locator
	private By signInButton = By.xpath("//a[normalize-space()='Sign in']");
	
	public GmailUsernamePage goToUsernamePage() throws InterruptedException
	{
		getElement(signInButton).click();
		Thread.sleep(4000);
		return getInstance(GmailUsernamePage.class);
	}

}
