package com.xuriti.dev.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xuriti.dev.TestBase.Baseclass;

public class CompanyapprovePage extends Baseclass
{
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/app-layout/mat-sidenav-container/mat-sidenav/div/app-sidebar/div/div/div[3]/mat-nav-list/mat-list-item[4]/span/mat-icon")private WebElement managecompany;
	
	@FindBy (xpath="//mat-icon [text()='edit']") private WebElement editcompany;
	@FindBy(xpath="//div [@class=\"mat-select-trigger ng-tns-c119-52\"]")private WebElement selectoption;
	@FindBy(xpath="//span [text()=' Approved ']")private WebElement Approvedtab;
	@FindBy(xpath="//input [@formcontrolname=\"pinCode\"]")private WebElement pincode;
	@FindBy(xpath="//input [@formcontrolname=\"annual_turnover\"]")private WebElement AnnualTurnover;
	@FindBy(xpath="//input [@formcontrolname=\"creditLimit\"]")private WebElement CreditLimit;
	@FindBy(xpath="//*[@id=\"mat-checkbox-1\"]/label/span[1]")private WebElement Echeckbox;
	@FindBy(xpath="//textarea [@formcontrolname=\"comment\"]")private WebElement commentbox;
	@FindBy (xpath="//span [text()=' VERIFY AND APPROVE ']") private WebElement verifytab;
	
	//Table
	@FindBy (xpath="//table/tbody/tr") private WebElement rows;
	
	
	
	
	
	
	
	
	public CompanyapprovePage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	
	
	public void clickonmanagecompany()
	{
		managecompany.click();
	}
	public void selectcompany(String company)
	{
		int rows=driver.findElements(By.xpath("//table/tbody/tr")).size();
	      System.out.println(rows);
	      
	      for(int r=1;r<=rows;r++) 
	        {
	            
	        String Name = driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[1]")).getText();
	        
	         if (Name.contentEquals(company))
	         {
	             driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[7]/mat-list-item/span/mat-icon")).click();
	             
	             break;
	         }
	      
	        }
	}
	
	public void clickoneditco()
	{
		editcompany.click();
	}
	public void approveandsubmit(String pcode,String at,String creditlim) throws InterruptedException
	{
		selectoption.click();
		Thread.sleep(2000);
		Approvedtab.click();
		pincode.sendKeys(pcode);
		AnnualTurnover.clear();
		AnnualTurnover.sendKeys(at);
		Thread.sleep(2000);
		CreditLimit.clear();
		CreditLimit.sendKeys(creditlim);
		Thread.sleep(2000);
		Echeckbox.click();
		commentbox.sendKeys("DONE");
		verifytab.click();
	}
	

}
