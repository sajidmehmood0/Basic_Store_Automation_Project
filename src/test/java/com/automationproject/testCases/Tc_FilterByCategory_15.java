package com.automationproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.shopPage;

public class Tc_FilterByCategory_15 extends baseClass
{

	@Test
	public void filterByCategory() throws InterruptedException, IOException	
	{
		shopPage sPage = new shopPage(driver);
		
		logger.info("Url is opened");
		
		sPage.clickShop();
		logger.info("Shop button is clicked");
		
		Thread.sleep(4000);
		
		
		sPage.clickCategory();
		logger.info("Category button is clicked");
		
		Thread.sleep(4000);
	
		int books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li")).size();
		
		for(int i=1;i<=books;i++)
		{
			try
			{
				String name = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[1]/h3")).getText().toLowerCase();
				if(!(name.contains("javascript") || name.contains("js" )))
				{
					logger.warn("Test case Failed \n");
					Assert.assertTrue(false);
					captureScreen(driver,"filterByCategory");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		logger.info("Test case Passed \n");
		Assert.assertTrue(true);
		
	}
}

