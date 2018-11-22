package com.zephyr_batch_5.stepdefinition;



import org.openqa.selenium.TimeoutException;

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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_1 extends LaunchBrowser
{
	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	CreateCustomFieldsPage ccf;
	DefectTracking dt;
	ExternalJiraPage ext;
	String fileName="Defect_Tracking_Search_1";
	
	
	@Given("^Login as admin user$")
	public void login_as_admin_user() throws Throwable {
	   try
	   {
		pp=new ProjectPage(driver);
	    lp=new LoginPage(driver);
	    bp=new BasePage();
	    String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	    
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
	

	
	@When("^admin navigate to System Configuration of administration Page$")
	public void admin_navigate_to_System_Configuration_of_administration_Page() throws Throwable {
	   try
	   {
		pp.launchAdministration();
		
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

	@When("^save zephyr URL to desktop URL$")
	public void save_zephyr_URL_to_desktop_URL() throws Throwable {
	  try
	  {
	    ccf=new CreateCustomFieldsPage(driver);
	   
	   String desktop_URL=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	   String dasboard_URL="";
	   ccf.enterAcessURl(desktop_URL, dasboard_URL);
	   
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


@Then("^desktop url should be saved successfully$")
public void desktop_url_should_be_saved_successfully() throws Throwable {
  try
  {
	String url=ccf.desktopURL.getText();
	String zephyrUrl=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	if(url.equals(zephyrUrl))
	{
		System.out.println("desktop url successfully saved");
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

	
	@When("^user navigate to defect Tracking System Page$")
	public void user_navigate_to_defect_Tracking_System_Page() throws Throwable {
	   try
	   {
		pp.clickOnDefectTracking();
		
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

	@Then("^user successfully navigated to DTS Page$")
	public void user_successfully_navigated_to_DTS_Page() throws Throwable {
	   
		try
		{
			
			
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

	@When("^set the Defect Tracking System to Jira$")
	public void set_the_Defect_Tracking_System_to_Jira() throws Throwable {
		try
		{
		String dtsType=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"DTS_Type");
		 String jiraURL=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 
		 pp.setDTS(dtsType, jiraURL, jiraUname, jiraPwd);
		
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

	@Then("^able to set the DTS to Jira$")
	public void able_to_set_the_DTS_to_Jira() throws Throwable {
	    
		try
		{
		pp.validateSetDTS();
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

	@When("^user open the external Jira Page$")
	public void user_open_the_external_Jira_Page() throws Throwable {
		try
		{
			ext=new ExternalJiraPage(driver);
		String jiraURL=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		driver.navigate().to(jiraURL);
		 String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		    
		ext.loginToExternalJira(userName, passWord);
		
		
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

	@When("^navigate to Webhooks page of Jira administration$")
	public void navigate_to_Webhooks_page_of_Jira_administration() throws Throwable {
	    try
	    {
		
		String option="System";
	    ext.launchJiraAdministration(option);
	    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	    
	    ext.enterAdministratorAccessPassword(passWord);
	   
	    
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

	@Then("^verify the new webhook will be created with ZEE ip$")
	public void verify_the_new_webhook_will_be_created_with_ZEE_ip() throws Throwable {
	    try
	    {
	    	String webhook=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
		ext.verifyWebhooks(webhook);
		ext.closeNotificationMsg();
		ext.logOutFromExternal_JIRA();
		
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

	@When("^switch back to ZEE application and refresh the page$")
	public void switch_back_to_ZEE_application_and_refresh_the_page() throws Throwable {
	   
		try
		{
			String zephyrUrl=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
		driver.navigate().to(zephyrUrl);
	    lp=new LoginPage(driver);
	    String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	    
	    pp.clickOnLogout();
	   
	    lp.enterUname(userName);
	    lp.enterPass(passWord);
	    lp.clickOnLogin();
	    
	    driver.navigate().refresh();
	    
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

	@When("^navigate to Defect Tracking Page and enter valid credentials and save it$")
	public void navigate_to_Defect_Tracking_Page_and_enter_valid_credentials_and_save_it() throws Throwable {
	  try
	  {
		rp=new ReleasePage(driver);
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		pp.selectProject(projectName);
		pp.selectRelease(releaseName);
	    rp.clickOnDefectTracking();
	    bp.waitForElement();
	    dt=new DefectTracking(driver);
	    exep=new ExecutionPage(driver);
//	    String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//	    String jiraPassWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
//	    exep.loginToDTS(jiraUserName, jiraPassWord);
//	    bp.waitForElement();
	  
	  
		  
	  
//	    bp.waitTillElementIsVisible(dt.dtsPoup);
//	    bp.explicitWait(dt.dtsUsername);
//    	//username.click();
//    	bp.waitForElement();
//    	dt.dtsUsername.sendKeys(jiraUserName);
//    	bp.explicitWait(exep.dtsPassword);
//    	bp.waitForElement();
//    	dt.dtsPassword.sendKeys(jiraPassWord);
//    	bp.waitForElement();
//    	//reEnterPassword.click();
//    	bp.explicitWait(exep.reEnterPass);
//    	dt.reEnterPass.sendKeys(jiraPassWord);
//    	
//    	bp.waitForElement();
//    	dt.dtsUpdateButton.click();
//    	
	    
	    
	    
	   
    	
	    	 String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	 	    String jiraPassWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
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

	@Then("^should be launched to defect tracking page$")
	public void should_be_launched_to_defect_tracking_page() throws Throwable {
	    try
	    {
		dt.validateDefectTrackingPage();
		
		
//		pp.launchAdministration();
//		pp.clickOnDefectTracking();
	
//		ccf=new CreateCustomFieldsPage(driver);
//		String dtsType="None";
//		String url="";
//		String username="";
//		String password="";
//		ccf.setDTS(dtsType, url, username, password);
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
