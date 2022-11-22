package com.xuriti.dev.TestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.xuriti.dev.PageClass.LoginPage;
import com.xuriti.dev.TestBase.Baseclass;

public class Tc_02_Login extends Baseclass {
	
		LoginPage lp;
	 @BeforeClass
	  public void Startbrowser() throws IOException 
	  {
		  openBrowseruserlogin();
	  }
	
	@Test
  public void Login() throws InterruptedException 
	{
		lp= new LoginPage(driver);
		lp.sendkeysmail("varsha.patil@tech-trail.com");
		lp.sendkeyspassword("Xuriti#10");
		lp.clickonlogin();
		Thread.sleep(5000);
		
		String act = "Xuriti";
		String exp = driver.getTitle();
		
	
		Reporter.log("WelCome to Xuriti");
		driver.quit();
	}
}
