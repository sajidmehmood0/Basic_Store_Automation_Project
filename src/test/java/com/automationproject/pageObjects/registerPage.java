package com.automationproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
	
	WebDriver ldriver;
	
	public registerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how = How.XPATH, using ="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
	@CacheLookup
	WebElement btnMyAccount;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"reg_email\"]")
	@CacheLookup
	WebElement email;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"reg_password\"]")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[2]/form/p[3]/input[3]")
	@CacheLookup
	WebElement btnRegister;
	
	
	public void clickMyAccount()
	{
		btnMyAccount.click();
	}
	public void setEmail(String email)
	{
		this.email.sendKeys(email);
	}
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickRegister()
	{
		btnRegister.click();
	}
	
	
}

