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
		
		
		action.dragAndDropBy(sPage.sliderLeft(), 20,0).perform();
		logger.info("Left edge of price slider moved");
		
		
		action.dragAndDropBy(sPage.sliderRight(), -30,0).perform();;
		logger.info("Right edge of price slider moved");
		
		//*[@id="content"]/ul/li[1]/a[1]/span[2]
		
		
	}

}
