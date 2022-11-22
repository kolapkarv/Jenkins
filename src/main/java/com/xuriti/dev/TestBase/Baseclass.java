package com.xuriti.dev.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Baseclass 
{
	protected  WebDriver driver;

	
	public void openBrowseruserlogin() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/home/tech-trail/workspace/xd/src/main/resources/Xuriti_dev.properties");
	      
		 prop.load(ip);
		
		System.setProperty("webdriver.chrome.driver", "/home/tech-trail/workspace/xd/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.xuriti.app/");
	 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public void openBrowseruseradmin() throws IOException 
	{
	
		System.setProperty("webdriver.chrome.driver", "/home/tech-trail/workspace/xd/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.xuriti.app/adminpanel/");
	 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public org.openqa.selenium.support.ui.WebDriverWait waits()
	{
		org.openqa.selenium.support.ui.WebDriverWait  Wait = new org.openqa.selenium.support.ui.WebDriverWait
				(driver, Duration.ofMillis(5000));
		return Wait;
	}
	 
}
