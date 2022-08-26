package com.automationproject.testCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationproject.pageObjects.shopPage;

public class Tc_FilterByPrice_14 extends baseClass {
	@Test
	public void filterByPrice() throws InterruptedException	
	{
		Actions action = new Actions(driver);
		shopPage sPage = new shopPage(driver);
		
		logger.info("Url is opened");
		
		sPage.clickShop();
		logger.info("Shop button is clicked");
		
		Thread.sleep(6000);
		
		action.dragAndDropBy(sPage.sliderLeft(), 20,0);
		logger.info("Left edge of price slider moved");
		
		Thread.sleep(6000);
		
		action.dragAndDropBy(sPage.sliderRight(), -30,0);
		logger.info("Right edge of price slider moved");
		
		Thread.sleep(6000);
		
		
		Thread.sleep(6000);
		
		
	}

}
