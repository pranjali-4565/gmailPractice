package com.gmailLogin;

import org.testng.annotations.Test;

import com.pages.GmailHomePage;
import com.pages.GmailPasswordPage;
import com.pages.GmailUsernamePage;

public class loginTC extends BaseTest {
	
	@Test(priority=1)
	public void loginUser() throws InterruptedException
	{
		GmailHomePage gmailHomePage = page.getInstance(GmailHomePage.class);
		GmailUsernamePage gmailUsernamePage = gmailHomePage.goToUsernamePage();
		GmailPasswordPage gmailPasswordPage = gmailUsernamePage.setEmail();
		gmailPasswordPage.setPasswordAndLogin();
		
	}

}
