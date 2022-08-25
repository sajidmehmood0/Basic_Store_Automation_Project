package com.automationproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.registerPage;

public class Tc_RegisterWithEmptyData_13 extends baseClass {
	@Test
	public void registerWithEmptyData() throws InterruptedException, IOException
	{
		registerPage rPage = new registerPage(driver);
		logger.info("URL is opened");
		rPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		
		rPage.clickRegister();
		logger.info("Registration button is clicked");
		
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Please provide a valid email address."))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
			
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Test case Failed \n");
			captureScreen(driver, "registerWithEmptyData");
			
		}
	}
	

}
