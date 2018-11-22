package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.UserDefinedException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_2 extends LaunchBrowser {

	
	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	CreateCustomFieldsPage ccf;
	DefectTracking dt;
	ExternalJiraPage ext;
	RequirementsPage req;
	String fileName="Defect_Tracking_2";
	
	

//@Given("^Login as manager role Credential$")
//public void login_as_manager_role_Credential() throws Throwable {
//	 try
//	   {
//		pp=new ProjectPage(driver);
//	    lp=new LoginPage(driver);
//	    bp=new BasePage();
//	    String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
//	    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
//	    
//	    pp.clickOnLogout();
//	   
//	    lp.enterUname(userName);
//	    lp.enterPass(passWord);
//	    lp.clickOnLogin();
//	    
//	   }
//		catch(Exception e)
//		{
//		   lb=new LaunchBrowser();
//		   lb.getScreenShot(fileName);
//		   e.printStackTrace();
//		   driver.close();
//	      	Relogin_TPE rl=new Relogin_TPE();
//	      	rl.reLogin();
//	      	throw e;
//		}  
//	    
//}
//
	
	@Given("^unset the defect tracking system$")
	public void unset_the_defect_tracking_system() throws Throwable {
	    
		try
		{
		pp=new ProjectPage(driver);
		String dtsType="None";
		 pp.launchAdministration();
		 pp.clickOnDefectTracking();
		pp.unsetDTS(dtsType);
		
		pp.backToProjectPage();
		
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
		}  
	}
	
	
@When("^try to navigate to defect tracking page,if dts is not set$")
public void try_to_navigate_to_defect_tracking_page_if_dts_is_not_set() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	pp.selectProject(projectName);
	pp.selectRelease(releaseName);
	rp=new ReleasePage(driver);
	
	String status=driver.findElement(By.xpath("//a[@title='Defect Tracking']/..")).getAttribute("class");
	
	if(status!="disabled")
	{
		new UserDefinedException("Defect tracking module is enabled");
	}
	
   
    
}
catch(Exception e)
{
   lb=new LaunchBrowser();
   lb.getScreenShot(fileName);
   e.printStackTrace();
   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
}  
}

@Then("^should not be able to launch defect tracking page$")
public void should_not_be_able_to_launch_defect_tracking_page() throws Throwable {
   
   try
   {
	
	   System.out.println("Defect tracking page is not enabled");
   }
catch(Exception e)
{
   lb=new LaunchBrowser();
   lb.getScreenShot(fileName);
   e.printStackTrace();
   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
}  
}

@When("^Login as lead role Credential role$")
public void login_as_lead_role_Credential_role() throws Throwable {
	try
	   {
		   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
		    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
		    
		    pp.clickOnLogout();
		   
		    lp.enterUname(userName);
		    lp.enterPass(passWord);
		    lp.clickOnLogin();
		    
		   }
			catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
		    
}

@When("^Login as tester Credential$")
public void login_as_tester_Credential() throws Throwable {
	
	try
	{
	String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Tester_Username_1");
    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Tester_Password_1");
    
    pp.clickOnLogout();
   
    lp.enterUname(userName);
    lp.enterPass(passWord);
    lp.clickOnLogin();
    
   }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}  
    
}
//
//@When("^Login as manager role Credential$")
//public void login_as_manager_role_Credential1() throws Throwable {
//	try
//	{
//		pp=new ProjectPage(driver);
//	    lp=new LoginPage(driver);
//	String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
//    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
//    
//    pp.clickOnLogout();
//   
//    lp.enterUname(userName);
//    lp.enterPass(passWord);
//    lp.clickOnLogin();
//    
//   }
//	catch(Exception e)
//	{
//	   lb=new LaunchBrowser();
//	   lb.getScreenShot(fileName);
//	   e.printStackTrace();
//	   driver.close();
//      	Relogin_TPE rl=new Relogin_TPE();
//      	rl.reLogin();
//      	throw e;
//	}  
//    
//}

@When("^set the DTS and navigate to defect tracking page$")
public void set_the_DTS_and_navigate_to_defect_tracking_page() throws Throwable {
   
	try
	{
		String dtsType=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"DTS_Type");
		 String jiraURL=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	pp.launchAdministration();
	pp.clickOnDefectTracking();
	pp.setDTS(dtsType, jiraURL, jiraUname, jiraPwd);
	
	pp.backToProjectPage();
	pp.selectProject(projectName);
	pp.selectRelease(releaseName);
	bp.waitForElement();
	driver.navigate().refresh();
	bp.waitForElement();
	rp.clickOnDefectTracking();
	
   
	}
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
     	Relogin_TPE rl=new Relogin_TPE();
     	rl.reLogin();
     	throw e;
	}  
   
}

@When("^enter the valid credentials$")
public void enter_the_valid_credentials() throws Throwable {
    try
    {
    	dt=new DefectTracking(driver);
    	 String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
    	 String jiraPassWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
    	 
    	//req=new RequirementsPage(driver);
    	
//    	
//    	bp.explicitWait(exep.dtsUsername);
//    	//username.click();
//    	bp.waitForElement();
//    	exep.dtsUsername.sendKeys(jiraUserName);
//    	bp.explicitWait(exep.dtsPassword);
//    	bp.waitForElement();
//    	exep.dtsPassword.sendKeys(jiraPassWord);
//    	bp.waitForElement();
//    	//reEnterPassword.click();
//    	bp.explicitWait(exep.reEnterPass);
//    	exep.reEnterPass.sendKeys(jiraPassWord);
//    	
//    	bp.waitForElement();
//    	exep.dtsUpdateButton.click();
//    	
    	dt.loginToDTS(jiraUserName, jiraPassWord);
    	//req.DTSLoginDetail(jiraUname, jiraPwd, jiraPwd);
    	
    }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
     	Relogin_TPE rl=new Relogin_TPE();
     	rl.reLogin();
     	throw e;
	}  
}

@Then("^should be able to launch defect tracking page$")
public void should_be_able_to_launch_defect_tracking_page() throws Throwable {
    try
    {
	dt=new DefectTracking(driver);
	dt.validateDefectTrackingPage();
	
    }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
     	Relogin_TPE rl=new Relogin_TPE();
     	rl.reLogin();
     	throw e;
	}  
}

@When("^Login as lead role Credential$")
public void login_as_lead_role_Credential() throws Throwable {
	try
	{
	String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
    
    pp.clickOnLogout();
   
    lp.enterUname(userName);
    lp.enterPass(passWord);
    lp.clickOnLogin();
    
   }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}  
    
}

@When("^navigate to defect tracking page and enter the valid credentials$")
public void navigate_to_defect_tracking_page_and_enter_the_valid_credentials() throws Throwable {
   
	try
	{
		String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
   	 String jiraPassWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
   	 
   	//req=new RequirementsPage(driver);
   	
   	
//   	bp.explicitWait(exep.dtsUsername);
//   	//username.click();
//   	bp.waitForElement();
//   	exep.dtsUsername.sendKeys(jiraUserName);
//   	bp.explicitWait(exep.dtsPassword);
//   	bp.waitForElement();
//   	exep.dtsPassword.sendKeys(jiraPassWord);
//   	bp.waitForElement();
//   	//reEnterPassword.click();
//   	bp.explicitWait(exep.reEnterPass);
//   	exep.reEnterPass.sendKeys(jiraPassWord);
//   	
//   	bp.waitForElement();
//   	exep.dtsUpdateButton.click();
   	
   	dt.loginToDTS(jiraUserName, jiraPassWord);
   	
	
}
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
     	Relogin_TPE rl=new Relogin_TPE();
     	rl.reLogin();
     	throw e;
	}  
	
}


}
