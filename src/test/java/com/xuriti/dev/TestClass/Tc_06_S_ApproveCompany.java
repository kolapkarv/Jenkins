package com.xuriti.dev.TestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
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

public class Tc_06_S_ApproveCompany extends Baseclass
{
	CompanyapprovePage ca;
	Adminpage_login al;

	@BeforeClass
	public void adminsetup() throws IOException, InterruptedException
	{
			openBrowseruseradmin();
			al = new Adminpage_login(driver);
			al.adminLogin("krishna.kshirsagar@xuriti.com", "Xuriti#10");
			Thread.sleep(2000);
	}
	@Test
	  public void SellerCompanyApprove() throws IOException, InterruptedException
		{
		
			  
			  Properties prop = new Properties();
			  FileInputStream ip = new FileInputStream("/home/tech-trail/workspace/xd/src/main/resources/Xuriti_dev.properties");
			  prop.load(ip);
			  ca = new CompanyapprovePage(driver);
			  ca.clickonmanagecompany();
			  Thread.sleep(3000);
			  
			  int rows=driver.findElements(By.xpath("//table/tbody/tr")).size();
		      System.out.println(rows);
		      Thread.sleep(2000);
		      
		      for(int r=1;r<=rows;r++) 
		        {           
		        String Name = driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[1]")).getText();
		        if (Name.contentEquals(prop.getProperty("sgstName")))
		          {
		             driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[7]/mat-list-item/span/mat-icon")).click();   
		             break;
		          }
		        }
			  //ca.selectcompany(prop.getProperty("bgstName"));
		      Thread.sleep(3000);
			  ca.clickoneditco();
			  Thread.sleep(5000);
			  ca.approveandsubmit("411016", "1000000", "0");
			  Thread.sleep(3000);
			  
			  String exp="Company details updated successfully";
			  String act=driver.findElement(By.xpath("//*[@id=\"cdk-overlay-11\"]/snack-bar-container/div/div/simple-snack-bar/span")).getText();
			  
			  
			  Reporter.log("Seller Company Approved");
			  
			  driver.quit();
		}
	
  
}
