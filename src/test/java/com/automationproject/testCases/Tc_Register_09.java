package com.automationproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.registerPage;

public class Tc_Register_09 extends baseClass {
	@Test
	public void registerWithValidData() throws InterruptedException, IOException
	{
		registerPage rPage = new registerPage(driver);
		logger.info("URL is opened");
		rPage.clickMyAccount();
		logger.info("My Account button is clicked");
		Thread.sleep(2000);
		
		rPage.setEmail(randomestring());
		logger.info("Email is entered");
		
		rPage.setPassword("assdsdsdY6H");
		logger.info("Password is entered");
		
		rPage.clickRegister();
		logger.info("Registration button is clicked");
		
		Thread.sleep(5000);
		if(driver.getPageSource().contains("From your account dashboard you can view your"))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Test case Failed \n");
			captureScreen(driver, "registerWithValidData");
		}
	}
	

}
