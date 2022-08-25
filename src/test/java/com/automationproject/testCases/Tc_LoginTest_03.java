package com.automationproject.testCases;

// Login test with invalid credentials

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.loginPage;

public class Tc_LoginTest_03 extends baseClass
{
	@Test
	public void loginTestWithEmptyPassword() throws InterruptedException, IOException
	{
		
		loginPage lPage = new loginPage(driver);
		logger.info("URL is opened");
		lPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		lPage.setUsername(username);
		logger.info("Username entered");
		lPage.setPassword("");
		logger.info("Empty passwrod entered");
		
		lPage.clickLogin();
		
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Password is required."))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
		}
		else
		{
			captureScreen(driver, "loginTestWithEmptyPassword");
			logger.warn("Test case Failed \n");
			Assert.assertTrue(false);
		}
		
	}
}
