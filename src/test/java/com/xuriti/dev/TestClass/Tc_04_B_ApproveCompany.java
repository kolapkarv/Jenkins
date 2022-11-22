package com.xuriti.dev.TestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xuriti.dev.PageClass.Adminpage_login;
import com.xuriti.dev.PageClass.CompanyapprovePage;
import com.xuriti.dev.TestBase.Baseclass;
import com.xuriti.dev.Utility.Utility;

public class Tc_04_B_ApproveCompany extends Baseclass

{
	CompanyapprovePage ca;
	Adminpage_login al;

	@BeforeClass
	public void adminsetup() throws IOException
	{
			openBrowseruseradmin();
			al = new Adminpage_login(driver);
			al.adminLogin("krishna.kshirsagar@xuriti.com", "Xuriti#10");
	}
	
	@Test
  public void CompanyApprove() throws IOException, InterruptedException
	{
	
		  
		  Properties prop = new Properties();
		  FileInputStream ip = new FileInputStream("/home/tech-trail/workspace/xd/src/main/resources/Xuriti_dev.properties");
		  prop.load(ip);
		  ca = new CompanyapprovePage(driver);
		  Thread.sleep(3000);
		  ca.clickonmanagecompany();
		  Thread.sleep(3000);
		  
		  int rows=driver.findElements(By.xpath("//table/tbody/tr")).size();
	      System.out.println(rows);
	      Thread.sleep(2000);
	      
	      for(int r=1;r<=rows;r++) 
	        {           
	        String Name = driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[1]")).getText();
	        if (Name.contentEquals(prop.getProperty("bgstName")))
	          {
	             driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[7]/mat-list-item/span/mat-icon")).click();   
	             break;
	          }
	        }
		  //ca.selectcompany(prop.getProperty("bgstName"));
		  ca.clickoneditco();
		  Thread.sleep(5000);
		  ca.approveandsubmit("411016", "1000000", "1000000");
		  Thread.sleep(3000);
		  
		  String exp="Credit limit is changed, it will be reflected once the credit manager will approve this request.";
		  String act=driver.findElement(By.xpath("//*[@id=\"cdk-overlay-4\"]/snack-bar-container/div/div/simple-snack-bar/span")).getText();
		  
		  
		  Reporter.log("Buyer Company Approved and Creadit limit set succefully");
		  driver.quit();
	}
	
}
