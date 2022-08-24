package com.automationproject.testCases;

// Login test with invalid credentials

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.loginPage;

public class Tc_LoginTest_07 extends baseClass
{
	@Test
	public void loginTestCaseSensitive() throws InterruptedException, IOException
	{
		
		loginPage lPage = new loginPage(driver);
		logger.info("URL is opened");
		lPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		lPage.setUsername("ABCDEGH@gmail.com");
		logger.info("Username entered");
		lPage.setPassword("oXYGENh2o1234");
		logger.info("Passwrod entered");
		
		lPage.clickLogin();
		
		if(driver.getPageSource().contains("password you entered for the username"))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
		}
		else
		{
			captureScreen(driver, "loginTestCaseSensitive");
			logger.warn("Test case Failed \n");
			Assert.assertTrue(false);
		}
		
	}
}
