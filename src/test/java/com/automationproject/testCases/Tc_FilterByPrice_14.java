package com.automationproject.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Tc_FilterByPrice_14 extends baseClass {
	@Test
	public void filterByPrice() throws InterruptedException	
	{
		WebElement slider =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/aside/div[2]/form/div/div[1]/span[1]"));
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 150,0);
		
		Thread.sleep(4000);
		
		
	}

}
