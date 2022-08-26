package com.automationproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class shopPage 
{
	WebDriver ldriver;
	
	public shopPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how =How.XPATH, using ="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")
	@CacheLookup
	WebElement btnShop;
	
	@FindBy(how =How.XPATH, using ="/html/body/div[1]/div[2]/div/aside/div[2]/form/div/div[1]/span[1]")
	@CacheLookup
	WebElement sliderEdgeLeft;
	
	@FindBy(how =How.XPATH, using ="/html/body/div[1]/div[2]/div/aside/div[2]/form/div/div[1]/span[2]")
	@CacheLookup
	WebElement sliderEdgeRight;
	
	@FindBy(how =How.XPATH, using ="/html/body/div[1]/div[2]/div/aside/div[2]/form/div/div[2]/button")
	@CacheLookup
	WebElement btnFilter;
	
	public void clickShop()
	{
		btnShop.click();
	}
	public WebElement sliderLeft()
	{
		return sliderEdgeLeft;
	}
	public WebElement sliderRight()
	{
		return sliderEdgeRight;
	}
	public void clickFilter()
	{
		btnFilter.click();
	}
	
	
	
	
}
