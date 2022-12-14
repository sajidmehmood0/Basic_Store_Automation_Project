package com.automationproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.shopPage;

public class Tc_FilterByPrice_14 extends baseClass {
	@Test
	public void filterByPrice() throws InterruptedException, IOException	
	{
		Actions action = new Actions(driver);
		shopPage sPage = new shopPage(driver);
		String value;
		
		logger.info("Url is opened");
		
		sPage.clickShop();
		logger.info("Shop button is clicked");
		
		Thread.sleep(4000);
		
		
		action.dragAndDropBy(sPage.sliderLeft(), 20,0).perform();
		logger.info("Left edge of price slider moved");

		
		action.dragAndDropBy(sPage.sliderRight(), -30,0).perform();;
		logger.info("Right edge of price slider moved");
		
		
		sPage.clickFilter();
		logger.info("Filter button is clicked");
		
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
			
			if(testValue<185 || testValue>448)
			{
				logger.warn("Test case Failed \n");
				Assert.assertTrue(false);
				captureScreen(driver,"filterByPrice");
				
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		logger.info("Test case Passed \n");
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
