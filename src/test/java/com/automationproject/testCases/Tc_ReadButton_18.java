
package com.automationproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.shopPage;

public class Tc_ReadButton_18 extends baseClass {
	@Test
	public void readButton() throws InterruptedException, IOException	
	{
		shopPage sPage = new shopPage(driver);
		logger.info("Url is opened");
		
		sPage.clickShop();
		logger.info("Shop button is clicked");
		
		Thread.sleep(4000);
		
		int books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li")).size();
		
		for(int i=1;i<=books;i++)
		{
			
			String value = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[2]")).getText().toLowerCase();
			if(value.equals("read more"))
			{
				try
				{
					driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[2]")).click();
					logger.info("read button is clicked");
					Thread.sleep(3000);
					if(!(driver.getPageSource().contains("Out of stock")))
					{
						logger.warn("Test case Failed \n");
						Assert.assertTrue(false);
						captureScreen(driver,"readButton");
					}
					logger.info("Out of stock is found");
					logger.info("Navigating to previous page");
					driver.navigate().back();
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				continue;
			}
			
		 }
		 logger.info("Test case Passed \n");
		 Assert.assertTrue(true);
	}
	

}
