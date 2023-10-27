package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(15));
	}
	
	//abstracts methods
	public abstract String getPageTitle();
	
	public abstract void scrollToView(WebElement element);
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public abstract void moveToElement(WebElement locator);
	
	public abstract int getNumberOfElements(By locator);
	
	public abstract void getWindowHandles();

	public abstract void scrollPageDown();

	public abstract void scrollPageUp();

	public abstract void hover(WebElement element);
	
	public abstract String getNumericStringOfLengthN(int n);
	
	public abstract String getAlphaStringOfLengthN(int n);
	
	public abstract int getNumberOfLengthN(int n);
	
	public abstract Integer checkForBrokenImages();
	
	public abstract void showElement(WebElement element);
	
	public abstract void goBack();

	public abstract String switchWindow();
	
	public abstract void scrollLoop(WebElement element) throws InterruptedException;
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
