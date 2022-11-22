package com.xuriti.dev.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreaditPlanPage 
{
	@FindBy(xpath="/html/body/app-root/app-dashboard/app-layout/mat-sidenav-container/mat-sidenav/div/app-sidebar/div/div/div[3]/mat-nav-list/mat-list-item[4]/span/mat-icon")private WebElement managecompany;
	@FindBy (xpath="//mat-icon [text()='account_balance_wallet']") private WebElement creaditplan;
	@FindBy(xpath="//span [text()=' ADD PLAN ']")private WebElement addplanbtn;
	@FindBy(xpath="//input [@formcontrolname='plan_name']")private WebElement creditplanename;
	@FindBy(xpath="//input [@formcontrolname='credit_period']") private WebElement creditperiod;
	@FindBy(xpath="//span [text()='Select Payment Intervals']")private WebElement selectintervals;
	@FindBy(xpath="//*[@id=\"mat-option-23\"]") private WebElement selectnumber;
	@FindBy(xpath="(//input [@type='text'])[4]")private WebElement days;
	@FindBy (xpath="(//input [@type='text'])[5]")private WebElement discount;
	@FindBy(xpath="//span [text()='SAVE']") private WebElement savebtn;
	@FindBy(xpath="//mat-icon [text()='edit']") private WebElement editbtn;
	@FindBy(xpath="//span [text()=' ADD ']")private WebElement addbuyer;
	@FindBy(id="mat-input-25")private WebElement buyername;
	@FindBy(xpath="//span [text()=' Map Buyers ']")private WebElement mapbuyer;
	
	
	public CreaditPlanPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	
	
	public void clickonmanagecompany()
	{
		managecompany.click();
	}
	
	public void clickoncreditplan()
	{
		creaditplan.click();
	}
	public void clickonaddplan()
	{
		addplanbtn.click();
	}
	public void sendkeyscreditname(String cname)
	{
		creditplanename.sendKeys(cname);
	}
	public void sendkeyscreditperiod(String cperiod)
	{
		creditperiod.sendKeys(cperiod);
	}	
	public void selectintervals() throws InterruptedException
	{
		selectintervals.click();
		Thread.sleep(2000);
		selectnumber.click();
	}
	public void sendkeysdays(String day)
	{
		days.sendKeys(day);
	}
	public void sendkeysdiscount()
	{
		discount.sendKeys("5");
	}
	public void clickonsubmit()
	{
		savebtn.click();
	}
	public void clickoneditplan()
	{
		editbtn.click();
	}
	public void clickonaddbuyer()
	{
		addbuyer.click();
	}
	public void sendkeysbuyername(String bname)
	{
		buyername.sendKeys(bname);
	}
	public void clickonmapbuyer()
	{
		mapbuyer.click();
	}
	
	
	
	
}
