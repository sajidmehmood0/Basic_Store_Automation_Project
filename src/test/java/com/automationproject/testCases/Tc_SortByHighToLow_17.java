
package com.automationproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.shopPage;

public class Tc_SortByHighToLow_17 extends baseClass {
	@Test
	public void filterByHighToLow() throws InterruptedException, IOException	
	{
		shopPage sPage = new shopPage(driver);
		String value;
		float tempValue = 1000;
		
		logger.info("Url is opened");
		
		sPage.clickShop();
		logger.info("Shop button is clicked");
		
		Thread.sleep(4000);
		
		WebElement element = sPage.getOptions();
		
		Select option = new Select(element);
		 option.selectByVisibleText("Sort by price: high to low");
		 
		 logger.info("Dropdown value get selected");
		 
		 Thread.sleep(4000);
		
		 int books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li")).size();
		
		 for(int i=1;i<=books;i++)
		 {
			if(isElementPresent(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[1]/span/span")))
			{
				value = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[1]/span/span")).getText();
			}
			else
			{
				value = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[1]/span[2]/ins/span")).getText();
			}
			StringBuilder sb = new StringBuilder(value);
			float testValue = Float.parseFloat(sb.deleteCharAt(0).toString());
			
			if(testValue>tempValue)
			{
				logger.warn("Test case Failed \n");
				Assert.assertTrue(false);
				captureScreen(driver,"filterByHighToLow");	
			}
			else
			{
				tempValue = testValue;
			}
			
		 }
		 logger.info("Test case Passed \n");
		 Assert.assertTrue(true);
	}
	
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			return false;
		}
	}
	

}
