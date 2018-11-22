//package com.zephyr.stepdefinition;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import com.zephyr.common.LaunchBrowser;
//import com.zephyr.generic.Excel_Lib;
//
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//
//public class Hooks extends LaunchBrowser {
//
//	
//	
//	
//	@After
//	 public void tearDown(Scenario scenario) throws Throwable 
//	 {
//		String status=scenario.getStatus();
//		System.out.println(status);
//		String scnName=scenario.getName();
//		String[] id=scnName.split(" ");
//		System.out.println(id[0]);
//		
//		
//		
//		//System.out.println(id[1]);
//		
//		for(int i=0;i<=0;i++)
//		{
//			String statusId=Integer.toString(Excel_Lib.getNumberData(STATUS, "Sheet1", i+1, 0));
//			System.out.println(statusId);
//		
//			if(id[0].equals(statusId))
//			{
//		   if(status.equals("passed"))
//		     {
//			
//			    Excel_Lib.setData(STATUS, "Sheet1", i+1, 1, "P");
//		    }
//		  else if(status.equals("failed"))
//		
//			
//			{
//				Excel_Lib.setData(STATUS, "Sheet1", i+1, 1, "F");
//			}
//		}
//		
//		//String fileName=scenario.getName();
//		}//System.out.println("Name-"+fileName);
////		String id=scenario.getId();
////		System.out.println("ID="+id);
//		 
//	 if (scenario.isFailed()) 
//	 {
//	          final byte[] screenshot = ((TakesScreenshot) LaunchBrowser.driver)
//	    					.getScreenshotAs(OutputType.BYTES);
//	         				scenario.embed(screenshot, "image/png");
//	         				
////	         				String fileeName=scenario.toString();
////	         				System.out.println(fileeName);
//	         				String fileName=scenario.getName();
//	         				System.out.println("Name-"+fileName);
//	         				
//	         				
//	         				
//	         				//stick it in the report
//	         				 File scrFile = ((TakesScreenshot)LaunchBrowser.driver).getScreenshotAs(OutputType.FILE);
//	         			     try
//	         			     {
//	         			    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h-m-s");
//	         			       Date date = new Date();
//	         			    	 FileUtils.copyFile(scrFile, new File("./Screenshots/"+fileName+"-"+dateFormat.format(date)+".png"));
//	         			    	 
//	         			    	driver.close();
//	         			       Relogin_TPE rl=new Relogin_TPE();
//	         			       rl.reLogin();
//	         			      
//	         			    	 
//	         			    	 
//	         			     } 
//	         			 	catch (IOException e)
//	         			 	 {
//	         			 	  System.out.println(e.getMessage()) ;
//	         			 	 }
//	          
//	  }
//	 }
//}
