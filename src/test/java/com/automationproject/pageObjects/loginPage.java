package com.automationproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how = How.XPATH, using ="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
	@CacheLookup
	WebElement btnMyAccount;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"username\"]")
	@CacheLookup
	WebElement username;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"password\"]")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/form/p[3]/input[3]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(how=How.XPATH, using = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/nav/ul/li[6]/a")
	@CacheLookup
	WebElement btnLogout;
	
	public void clickMyAccount()
	{
		btnMyAccount.click();
	}
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	
}
