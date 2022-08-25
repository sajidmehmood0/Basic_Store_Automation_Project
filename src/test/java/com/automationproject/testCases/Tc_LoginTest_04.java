package com.automationproject.testCases;

// Login test with invalid credentials

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.loginPage;

public class Tc_LoginTest_04 extends baseClass
{
	@Test
	public void loginTestWithEmptyUsername() throws InterruptedException, IOException
	{
		
		loginPage lPage = new loginPage(driver);
		logger.info("URL is opened");
		lPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		lPage.setUsername("");
		logger.info("Empty username entered");
		lPage.setPassword("sasasjas");
		logger.info("Passwrod entered");
		
		lPage.clickLogin();
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Username is required."))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
		}
		else
		{
			captureScreen(driver, "loginTestWithEmptyUsername");
			logger.warn("Test case Failed \n");
			Assert.assertTrue(false);
		}
		
	}
}
