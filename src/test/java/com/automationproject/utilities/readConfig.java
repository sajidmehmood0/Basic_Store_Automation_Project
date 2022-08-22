package com.automationproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig 
{
	Properties pro;
	public readConfig()
	{
		File src = new File("./Configurations/config.propertise");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e)
		{
			System.out.print("Exception is"+e.getMessage());
		}
	}
	public String getAppUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
}
