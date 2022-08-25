package com.automationproject.testCases;

// Login test with invalid credentials

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.loginPage;

public class Tc_LoginTest_02 extends baseClass
{
	@Test
	public void loginTestWithIncorrectCredentials() throws InterruptedException, IOException
	{
		
		loginPage lPage = new loginPage(driver);
		logger.info("URL is opened");
		lPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		lPage.setUsername("sajid@gmail.com");
		logger.info("Username entered");
		lPage.setPassword("sasasjas");
		logger.info("Passwrod entered");
		
		lPage.clickLogin();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("A user could not be found with this email address"))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
		}
		else
		{
			captureScreen(driver, "loginTestWithIcorrectCredentials");
			logger.warn("Test case Failed \n");
			Assert.assertTrue(false);
		}
		
	}
}
