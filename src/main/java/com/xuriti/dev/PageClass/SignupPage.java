package com.xuriti.dev.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage 
{

	
	@FindBy(xpath="//a [text()=' Sign Up ']")private WebElement signup;
	@FindBy(id="mat-input-2")private WebElement firstname;
	@FindBy(id="mat-input-3")private WebElement lastname;
	@FindBy(id="mat-input-4")private WebElement mobileno;
	@FindBy(xpath="//span[text()=' SEND OTP ']")private WebElement sendotp;
	
	
	public SignupPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	
	public void clickonsignup()
	{
		signup.click();
	}
	public void sendkeysfirstname(String Fname)
	{
		firstname.sendKeys(Fname);
	}
	public void sendkeyslastname(String Lname)
	{
		lastname.sendKeys(Lname);
	}
	public void sendmobno(String Mno)
	{
		mobileno.sendKeys(Mno);
	}
	public void clickonsubmit()
	{
		sendotp.click();
	}

}


