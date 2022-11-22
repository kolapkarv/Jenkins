package com.xuriti.dev.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminpage_login
{
	//2 Admin Login
		@FindBy(id="mat-input-0")private WebElement adminemailid;
		@FindBy(id="mat-input-1")private WebElement adminpassword;
		@FindBy(xpath="//span [text()=' LOGIN ']")private WebElement adminlogin;
		
		public Adminpage_login(WebDriver driver)
		{
		PageFactory.initElements(driver,this);	
		}
	
		public void adminLogin(String ID, String PWD)
		{
			adminemailid.sendKeys(ID);
			adminpassword.sendKeys(PWD);
			adminlogin.click();
		}
}
