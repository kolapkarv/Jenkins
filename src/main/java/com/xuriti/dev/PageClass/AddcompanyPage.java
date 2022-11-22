package com.xuriti.dev.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xuriti.dev.TestBase.Baseclass;

public class AddcompanyPage extends Baseclass

{
	
	@FindBy(partialLinkText="Add New Company")private WebElement Addcompanytab;
	@FindBy(id="mat-input-2")private WebElement gstnotab;
	@FindBy(xpath="//span [text()=' Get Company Details ']")private WebElement getdetailstab;
	@FindBy(xpath="//span [text()=' CREATE ']")private WebElement createtab;
	
	
	
	
	public AddcompanyPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	
	
	public void clickonaddcomapny()
	{
		Addcompanytab.click();
	}
	public void sendkeysgstno(String gst)
	{
		gstnotab.sendKeys(gst);
	}
	public void clickondetails()
	{
		getdetailstab.click();
	}
	public void clickoncreate()
	{
		createtab.click();
	}
	
	
}
