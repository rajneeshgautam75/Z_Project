package com.zephyr.reusablemethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.AutomationConstants;
import com.zephyr.common.LaunchBrowser;

public class BasePage
{
	 public WebDriver driver=null;
 
	 public BasePage()
     {
		
		this.driver = LaunchBrowser.driver;
	 }

   
  
     public void waitTillElementIsVisible(WebElement element)
     {
    	WebDriverWait wait= new WebDriverWait(driver,30);
    	 wait.until(ExpectedConditions.visibilityOf(element));
     }
	

	public boolean moveToElement(WebElement element) throws Exception
	{
		try
		{
		  Actions actions=new Actions(driver);
		  actions.moveToElement(element).perform();
		  
		  return true;
		}
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  throw e;
		  }
		  
  }

	public void moveToElementAndClick(WebElement element)
	{
		  Actions actions=new Actions(driver);
		  actions.moveToElement(element).click().build().perform();
		  
  

	}
	public boolean eraseText(WebElement ele)
	{
		
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).click().build().perform();
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		a1.sendKeys(selectAll).sendKeys(Keys.DELETE).build().perform();
		return true;
		
		
		
	}
	
	public boolean waitForElement() throws InterruptedException
	{
		Thread.sleep(3000);
		return true;
	}
	
	public void alertmsg()
	{
		Alert a1=driver.switchTo().alert();
		a1.getText();
		
				
	}
	public void windowHandle()
	{
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    driver.close();
    driver.switchTo().window(tabs2.get(0));

 }
	
	public boolean explicitWait(WebElement ele) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
	}

	public boolean maxExplicitWait(WebElement ele) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
	}

	
	
	public boolean switchToFrame(WebElement ele) throws Exception
	{
		try
		{
		driver.switchTo().frame(ele);
		return true;
		//a1.sendKeys(keys)
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
//	public void switchWindowTab(String title)
//	{
//	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//    String pagetitle=driver.switchTo().window(tabs.get(tabNo)).getTitle();
//    
//    if(title.equals(pageTitle))
//    {
//    	driver.switchTo().window(tabs.get(tabNo))
//    }
//
//     }
	
	public void switchWindowTab(int tabNo)
	{
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(tabNo));

     }
	
	public void dragAndDrop(WebElement source,int xoffset,int yoffset)
	{
		try
		{
			Actions act=new Actions(driver);

			act.dragAndDropBy(source, xoffset, yoffset).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
//	public void dragAndDropOptionList(int source,int destination)
//	{
//		try
//		{
//			Actions act=new Actions(driver);
//			String src1="//*[@id='custom-field-options-list']/li[";
//			String src2="]/div[1]";
//					
//			String dest1="//*[@id='custom-field-options-list']/li[";
//			String dest2="]/div[1]";
//			WebElement srcElement=driver.findElement(By.xpath(src1+source+src2));
//			WebElement destElement=driver.findElement(By.xpath(dest1+destination+dest2));
//           
//            
//            
//			act.dragAndDrop(srcElement, destElement).perform();
//			
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//	
	public void pageLoad()
	{
		
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		boolean status=js.executeScript("return document.readyState").toString().equals("complete");
		if(status==true)
		{
		System.out.println("Page Loaded Completely");
		}
		else
		{
			System.out.println("Page not loaded Completely");
			
		}
	

}
	
	
	public String currentDate()
	{
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 return date1;
	}

}
	

