package com.zephyr_batch_1.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.AutomationConstants;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.pom.DefectTracking_POM;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SetDefectTracking extends LaunchBrowser {
    
	String fileName="DefectTracking";
	LoginPage lp;
	BasePage bp;
	DefectTracking_POM dts;
	SoftAssert soft=new SoftAssert();
	LaunchBrowser lb=new LaunchBrowser();
	
//	@When("^Select Dt in Dropdown$")
//	public void select_Dt_in_Dropdown() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		try
//	 	 {
//	 		 bp=new BasePage();
//	 		 dts=new DefectTracking_POM(driver);
//	 				dts.clickOnDefectTracking.click();
//	 		 bp.waitForElement();
//	 		 
//	 		 
//	 		 
//	 		dts.selectdropDown.click();
//	 		
//	 		
//	 	 }
//	 		 catch(Exception e)
//		     {e.printStackTrace();
//			  lb.getScreenShot(fileName);
//			  driver.close();
//			  Relogin rl=new Relogin();
//			  rl.reLogin();
//			  throw e;
//		     }
//		 
//	}
//
//	@When("^Enter User Details Click on Save$")
//	public void enter_User_Details_Click_on_Save() throws Throwable {
//		try
//	 	 {
//			String text=dts.selectdropDown.getText();
//			if(!text.equals("JIRA"))
//			{
//		 		dts.selectjira.click();
//		 		bp.waitForElement();
//		bp.eraseText(dts.enterJiraconnectionname);
//		bp.waitForElement();
//		String connection=Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE,"ConnectionName");
//		dts.enterJiraconnectionname.sendKeys(connection);
//		bp.eraseText(dts.enterJiraUrl);
//		bp.waitForElement();
//		String url=Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE,"Url");
//		dts.enterJiraUrl.sendKeys(url);
//		bp.waitForElement();
//		bp.eraseText(dts.enterJiraUsername);
//		bp.waitForElement();
//		String username=Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE,"Username");
//		dts.enterJiraUsername.sendKeys(username);
//		bp.waitForElement();
//		bp.eraseText(dts.enterJiraUserPassword);
//		bp.waitForElement();
//		String password=Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE,"Password");
//		dts.enterJiraUserPassword.sendKeys(password);
//		bp.waitForElement();
//		dts.clickOnSave.click();
//		bp.waitForElement();
//		dts.confirmSave.click();
//
//			}
//	 	 }
//	    // Write code here that turns the phrase above into concrete actions
//	 	
//		catch(Exception e)
//	     {
//			e.printStackTrace();
//			  lb.getScreenShot(fileName);
//			  driver.close();
//			  Relogin rl=new Relogin();
//			  rl.reLogin();
//			  throw e;
//			
//	     }
//	    
//		
//	}
//
//	@Then("^Successfully Saved$")
//	public void successfully_Saved() throws Throwable {
//	    
//		try
//		{
//			driver.navigate().refresh();
//		  dts.vaidateDTS();
//				
//		}
//
//		// Write code here that turns the phrase above into concrete actions
//			
//		catch(Exception e)
//	     {
//			e.printStackTrace();
//			  lb.getScreenShot(fileName);
//			  driver.close();
//			  Relogin rl=new Relogin();
//			  rl.reLogin();
//			  throw e;
//			
//	     }
//	    
//	}

}
