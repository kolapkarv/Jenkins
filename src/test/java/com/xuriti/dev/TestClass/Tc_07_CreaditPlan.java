package com.xuriti.dev.TestClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xuriti.dev.PageClass.Adminpage_login;
import com.xuriti.dev.PageClass.CreaditPlanPage;
import com.xuriti.dev.TestBase.Baseclass;

public class Tc_07_CreaditPlan extends Baseclass 

{
	CreaditPlanPage cp;
	Adminpage_login al;

@BeforeClass
public void startBrowser() throws IOException
{
	openBrowseruseradmin();
	al = new Adminpage_login(driver);
	al.adminLogin("krishna.kshirsagar@xuriti.com", "Xuriti#10");
}
 
@Test
public void addCreditplan() throws InterruptedException, IOException
{
	  Properties prop = new Properties();
	  FileInputStream ip = new FileInputStream("/home/tech-trail/workspace/xd/src/main/resources/Xuriti_dev.properties");
	  prop.load(ip);
	  Actions act = new Actions(driver);
	  
	  
	cp = new CreaditPlanPage(driver);
	
	cp.clickonmanagecompany();
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
    
    cp.clickoncreditplan();
    Thread.sleep(2000);
    cp.clickonaddplan();
    Thread.sleep(2000);
    cp.sendkeyscreditname("Plan1");
    cp.sendkeyscreditperiod("30");
    Thread.sleep(2000);
    cp.selectintervals();
    Thread.sleep(2000);
    cp.sendkeysdays("30");
    Thread.sleep(2000);
    cp.sendkeysdiscount();
    Thread.sleep(2000);
    cp.clickonsubmit();
    Thread.sleep(5000);
    
    //editplan
    cp.clickoncreditplan();
    Thread.sleep(2000);
    cp.clickonaddbuyer();
    Thread.sleep(2000);
    cp.sendkeysbuyername(prop.getProperty("bgstName"));
    act.sendKeys(Keys.ENTER).build().perform();
    Thread.sleep(2000);
    cp.clickonmapbuyer();
    

}
}
