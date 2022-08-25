package com.automationproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.loginPage;
@Test
public class Tc_LoginTest_06 extends baseClass {
	
	public void loginPasswordMasked() throws InterruptedException, IOException
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
		
		WebElement check_pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		System.out.println(check_pass.isDisplayed());
		
		if(check_pass.isDisplayed())
		{
			Assert.assertTrue(false);
			logger.info("Test case Failed \n");
			captureScreen(driver, "loginPasswordMasked");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed \n");
		}
	}
}
