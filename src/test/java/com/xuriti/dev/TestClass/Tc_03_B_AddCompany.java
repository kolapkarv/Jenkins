package com.xuriti.dev.TestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xuriti.dev.PageClass.AddcompanyPage;
import com.xuriti.dev.PageClass.Adminpage_login;
import com.xuriti.dev.PageClass.CompanyapprovePage;
import com.xuriti.dev.PageClass.LoginPage;
import com.xuriti.dev.TestBase.Baseclass;

public class Tc_03_B_AddCompany extends Baseclass
{
	AddcompanyPage ap;
	LoginPage lp;
	
	
	 @BeforeClass
	  public void Startbrowser() throws IOException 
	  {
		  openBrowseruserlogin();
	  }
	
	
  @Test ()
  public void AddBuyercompany_buyer() throws IOException, InterruptedException 
  {
	  Properties prop = new Properties();
	  FileInputStream ip = new FileInputStream("/home/tech-trail/workspace/xd/src/main/resources/Xuriti_dev.properties");
	  prop.load(ip);
	  
	  ap = new AddcompanyPage(driver);
	  lp = new LoginPage(driver);
	  lp.userLogin("varsha.patil@tech-trail.com", "Xuriti#10");
	  ap.clickonaddcomapny();
	  Thread.sleep(2000);
	  ap.sendkeysgstno(prop.getProperty("bgstNo"));
	  System.out.println(prop.getProperty("bgstNo"));
	  Thread.sleep(5000);
	  ap.clickondetails();
	  Thread.sleep(5000);
	  ap.clickoncreate();	
	  
	  driver.quit();
  }
  
  
}
