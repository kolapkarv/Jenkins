package com.xuriti.dev.TestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xuriti.dev.PageClass.SignupPage;
import com.xuriti.dev.TestBase.Baseclass;

public class Tc_01_Signup extends Baseclass
{
	
	SignupPage sp;
	
	
  @BeforeClass
  public void startUp() throws IOException 
  {
	  openBrowseruserlogin();
  }
  
  @Test
  public void signUpUser() throws InterruptedException
  {
	  sp = new SignupPage(driver);
	  sp.clickonsignup();
	  sp.sendkeysfirstname("VK");
	  sp.sendkeyslastname("KO");
	  sp.sendmobno("9999900000");
	  sp.clickonsubmit();
	  Thread.sleep(2000);
	  
	  String Act = "OTP is sent on your mobile number";
	  String Exp = driver.findElement(By.xpath("//span [text()='OTP is sent on your mobile number']")).getText();
	  
	 
	  Reporter.log("Mobile number sent to user");
	  driver.quit();
  }
  
  
}
