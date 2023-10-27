package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page{
	
	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	//method to get the page title

	@Override
	public String getPageTitle() {

		return driver.getTitle();
	}
	
	//method to get the page header

	@Override
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
	}
	
	//method to get the element

	@Override
	public WebElement getElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions . elementToBeClickable (locator));
			return element;
		}
		catch (Exception e){
			System.out.println("Some error occured while creating element " + locator.toString());
			e.printStackTrace();
		}

		return element;
	}
	
	//method to wait until the required element is present

	@Override
	public void waitForElementPresent(By locator) {

       try {
    	   wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       }
       catch (Exception e) {
    	   System.out.println("Some exception/error occured while waiting for the element " + locator.toString());
    	   e.printStackTrace();
    	   
       }
		
	}
	
	//method to wait until the page title is completely loaded

	@Override
	public void waitForPageTitle(String title) {

		try {
	    	   wait.until(ExpectedConditions.titleContains(title) );
	       }
	       catch (Exception e) {
	    	   System.out.println("Some exception/error occured while waiting for the element " + title.toString());
	    	   e.printStackTrace();
	    	   
	       }
	}
	
	//method to get the number of elements present
	
	@Override
	public int getNumberOfElements(By locator) {
		List<WebElement> list = driver.findElements(locator);
		return list.size();
	}
	
	//method to switch to the child window and close the parent window
	
	@Override
	public void getWindowHandles() {
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(0));
		driver.close();
		driver.switchTo().window(newTb.get(1));
	}
	
	//method to scroll page down
	
	@Override
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//method to scroll page up
	
	@Override
	public void scrollPageUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,0)");
	}
	
	//method to hover on the required element
	
	@Override
	public void hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	//method to scroll till the required element is visible
	
	@Override
	public void scrollToView(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element); 
	}
	
	//method to move to a certain element
	
	@Override
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	//method to load a hidden element
	
	@Override
	public void showElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	//method to create a string of alphabets of required length
	
	@Override
	public  String getAlphaStringOfLengthN(int n)
	{

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
									+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
				= (int)(AlphaNumericString.length()
						* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
						.charAt(index));
		}

		return sb.toString();
	}
	
	//method to generate a string of numbers of required length
	
	@Override
	public String getNumericStringOfLengthN(int n) {
		String NumericString = "123456789";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
				= (int)(NumericString.length()
						* Math.random());

			// add Character one by one in end of sb
			sb.append(NumericString
						.charAt(index));
		}

		return sb.toString();
	}
	
	//method to generate a number of required length
	
	@Override
	public int getNumberOfLengthN(int n) {
		String NumericString = "123456789";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
				= (int)(NumericString.length()
						* Math.random());

			// add Character one by one in end of sb
			sb.append(NumericString
						.charAt(index));
		}

		return Integer. parseInt(sb.toString());
	}
	
	//method to scroll in loop to load page
	
	@Override
	public void scrollLoop(WebElement element) throws InterruptedException {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		long initialHeight = (long)(js.executeScript("return document.body.scrollHeight"));
		
		while(true) {
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			long currentHeight = (long)(js.executeScript("return document.body.scrollHeight"));
			boolean b = (boolean) js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			if(b==true || initialHeight==currentHeight)
				break;
			initialHeight=currentHeight;
		}
		
	}
	
	//method to go back 
	
	@Override
	public void goBack() {
		driver.navigate().back();
	}
	
	//method to switch window to get page title of child window
	
	@Override 
	public String switchWindow() {
		String title = null;
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext()){
			String child_window=I1.next();
				if(!parent.equals(child_window)){
					driver.switchTo().window(child_window);
					title = getPageTitle();
				}
				
		}
		driver.switchTo().window(parent);
		return title;
	}
	
	//method to check for broken images :
	
	public Integer checkForBrokenImages() {
		Integer iBrokenImageCount = 0;
        List<WebElement> image_list = driver.findElements(By.tagName("img"));
        for (WebElement img : image_list){
        	if (img != null){
        		if (img.getAttribute("naturalWidth").equals("0")){
        			System.out.println(img.getAttribute("outerHTML") + " is broken.");
                    iBrokenImageCount++;
                    }
        		}
            }
		return iBrokenImageCount;
	}

}
