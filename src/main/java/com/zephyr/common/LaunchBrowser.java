package com.zephyr.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ProjectPage;




public class LaunchBrowser implements AutomationConstants
{
 public static WebDriver driver;
 public static WebDriver driver2;
public static long timeout;
//public static String url;
ProjectPage pp;
//public static String browserType;

public Logger log;

public LaunchBrowser()
{
  log=Logger.getLogger(this.getClass());
  Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
  BasicConfigurator.configure();
}



 public boolean preCond() throws Exception
  {
	 try
	 {
	log.info("Initialising Framework");
	String browserType=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Browser");
	//String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	timeout=Long.parseLong((Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"IMPLICIT")));
	
	
	log.info("Browser:"+browserType);
	if(browserType.equalsIgnoreCase("chromeBrowser"))
	{
		//System.setProperty(CHROME_KEY,"C:/Users/RAJNEESH/Desktop/chrome/chrome.exe");
		System.setProperty(CHROME_KEY,DRIVER_PATH+CHROME_FILE);
		ChromeOptions option = new ChromeOptions();
		//option.setBinary("C:\\Users\\ThinkCenter\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		option.addArguments("disable-infobars");
		driver = new ChromeDriver(option);
		//driver=new ChromeDriver();
	}
	else if(browserType.equalsIgnoreCase("ieBrowser"))
	{
		System.setProperty(IE_KEY,DRIVER_PATH+IE_FILE);
		driver=new InternetExplorerDriver();
		
	}
	else
	{
		System.setProperty(GECKO_KEY,DRIVER_PATH+GECKO_FILE);
		driver=new FirefoxDriver();
	}

    driver.manage().window().maximize();
    log.info("TimeOut:"+timeout);
    
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
  

    return true;
	 }
	 catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
   


}
 
 public void getUrl(String url)
 {
	 driver.get(url);
	 
 }
 
 
// @After
// public void tearDown(Scenario scenario) {
//	 pp=new ProjectPage(driver);
//	 
// if (scenario.isFailed()) 
// {
//          final byte[] screenshot = ((TakesScreenshot) driver)
//    					.getScreenshotAs(OutputType.BYTES);
//         				scenario.embed(screenshot, "image/png"); //stick it in the report
//          
//  }
// }
// try 
// {
//	  pp.clickOnLogout();
// }
// catch (InterruptedException e) {
//	//e.printStackTrace();
//}
// 
//}
 

 
 public void getScreenShot(String fileName) throws IOException
 {
     DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
     Date date = new Date();
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     try
     {
    	 FileUtils.copyFile(scrFile, new File("./Screenshots/"+fileName+"-"+dateFormat.format(date)+".png"));
     } 
 	catch (IOException e)
 	 {
 	  System.out.println(e.getMessage()) ;
 	 }
 }
 
 
 
 
 
 
 public boolean preCond2(String browserType2) throws Exception
 {
 	 try
 	 {
 	log.info("Initialising Framework");
 	//String browserType=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Browser");
 	//String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
 	timeout=Long.parseLong((Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"IMPLICIT")));
 	
 	
 	log.info("Browser:"+browserType2);
 	if(browserType2.equalsIgnoreCase("chromeBrowser"))
 	{
 		//System.setProperty(CHROME_KEY,"C:/Users/RAJNEESH/Desktop/chrome/chrome.exe");
 		System.setProperty(CHROME_KEY,DRIVER_PATH+CHROME_FILE);
 		ChromeOptions option = new ChromeOptions();
 		option.addArguments("disable-infobars");
 		driver2 = new ChromeDriver(option);
 		
 	}
 	else if(browserType2.equalsIgnoreCase("ieBrowser"))
 	{
 		 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		  
		 capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		 capabilities.setCapability(InternetExplorerDriver.
		   INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
 		System.setProperty(IE_KEY,DRIVER_PATH+IE_FILE);
 		driver2=new InternetExplorerDriver();
 		
 	}
 	else
 	{

		System.setProperty(GECKO_KEY,DRIVER_PATH+GECKO_FILE);
		 driver2 = new FirefoxDriver();
 		
 	}

   driver2.manage().window().maximize();
   log.info("TimeOut:"+timeout);
   
   driver2.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
  
   return true;
 	 }
 	 catch(Exception e)
 		{
 			e.printStackTrace();
 			throw e;
 		}
   }

  public void close()
{
  log.info("Finalising Frmework");
	driver.quit();
}
  
  
  
  
  public void getUrl2(String url,WebDriver driver2) throws InterruptedException
  {
 	//this.driver=driver2;
	  BasePage bp=new BasePage();
	 
 	 driver2.get(url);
 	 bp.waitForElement();
 	log.info("Application Launced Sucessfully");
 	 
  }

}