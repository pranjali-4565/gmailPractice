package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailUsernamePage extends BasePage {

	public GmailUsernamePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By emailField = By.xpath("//input[@class='whsOnd zHQkBf']");
	private By nextButton = By.xpath("//span[normalize-space()='Next']");
	
	public GmailPasswordPage setEmail() throws InterruptedException
	{
		getElement(emailField).sendKeys("pranjali@iimjobs.com");
		getElement(nextButton).click();
		Thread.sleep(4000);
		return getInstance(GmailPasswordPage.class);
	}

}
