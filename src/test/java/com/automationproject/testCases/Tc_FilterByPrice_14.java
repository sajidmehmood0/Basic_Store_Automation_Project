package com.automationproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
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
		boolean checkTest = true;
		
		//logger.info("Url is opened");
		
		sPage.clickShop();
		logger.info("Shop button is clicked");
		
		Thread.sleep(4000);
		
		action.dragAndDropBy(sPage.sliderLeft(), 20,0).perform();
		logger.info("Left edge of price slider moved");

		
		action.dragAndDropBy(sPage.sliderRight(), -30,0).perform();;
		logger.info("Right edge of price slider moved");
		
		
		sPage.clickFilter();
		logger.info("Filter button is clicked");
		
		Thread.sleep(9000);
		
		int books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li")).size();
		
		String a=driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[1]/span/span")).getText();
		
		System.out.println(a);
		
		for(int i=2;i<=books;i++)
		{
			System.out.println("insode");
			int price =Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li["+i+"]/a[1]/span/span")).getText());
			System.out.println(price);
			if(price< 185 || price>448)
			{
				checkTest = false;	
				break;
			}
		}
		if(checkTest)
		{
			logger.info("Test case Passed \n");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "filterByPrice");
			logger.warn("Test case Failed \n");
			Assert.assertTrue(false);
		}
		
		
		
	}

}
