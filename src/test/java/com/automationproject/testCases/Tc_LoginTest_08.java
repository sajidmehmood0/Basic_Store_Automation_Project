package com.automationproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.loginPage;

public class Tc_LoginTest_08 extends baseClass
{
	@Test
	public void loginTestAuthentication() throws InterruptedException, IOException
	{
		
		loginPage lPage = new loginPage(driver);
		logger.info("URL is opened");
		lPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		lPage.setUsername(username);
		logger.info("Username entered");
		lPage.setPassword(password);
		logger.info("Passwrod entered");
		
		lPage.clickLogin();
		
		if(driver.getPageSource().contains("From your account dashboard you can view your"))
		{
			lPage.clickLogout();
			Thread.sleep(2000);
			if(driver.getPageSource().contains("From your account dashboard you can view your"))
			{
				Assert.assertTrue(false);
				logger.info("Test case Failed \n");
				captureScreen(driver, "loginTestAuthentication");
			}
			else
			{
				Assert.assertTrue(true);
				logger.info("Test case Passed \n");
			}
			
		}
		else
		{
			captureScreen(driver, "loginTestAuthentication");
			logger.warn("Test case Failed \n");
			Assert.assertTrue(false);
		}
		
	}
}
