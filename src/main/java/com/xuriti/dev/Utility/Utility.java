package com.xuriti.dev.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.xuriti.dev.TestBase.Baseclass;

public class Utility extends Baseclass
{

	 //1. rows = tbody/tr
   //2. name = tbody/tr["+r+"]/td[1].gettext();
   //3. value = "Varsha";
   //4. btn = tbody/tr["+r+"]/td5]
   
   /*
    Thread.sleep(5000);
    
   int rows=driver.findElements(By.xpath("//table/tbody/tr")).size();
   System.out.println(rows);
   
   for(int r=1;r<=rows;r++) 
     {
         
     String Name = driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[1]")).getText();
     
      if (Name.contentEquals("KIRLOSKAR OIL ENGINES LIMITED"))
      {
          driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[6]/button[2]")).click();
          
          break;
      }
      System.out.println(Name);
     }
   */
   
   
   
   
   //FOR DROPDOWNS
   public static void selectfromdropdown(WebElement ele , String Value)
   {
   
   Select drp = new Select(ele);
   List<WebElement> alloptions = drp.getOptions();
   
   for(WebElement option:alloptions)
   {
       if(option.getText().equals(Value))
       {
           option.click();
           break;
       }
       
   }
   }
   
   public static void Selectfromlist(List<WebElement> ele, String Value)
   {
           
   for(WebElement option: ele)
   {
       if(option.getText().contentEquals(Value))
       {
           option.click();
           break;
       }
       
     
       
   }
          
   }
   
   public void handletable(String company)
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
	         System.out.println(company);
	        }
	   
   }
   
   

}
