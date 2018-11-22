package com.zephyr_batch_5.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_3 extends LaunchBrowser {

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
	TestRepositoryPage tr;
	String fileName="Defect_Tracking_3";
	
	
//	
//	@Given("^Login as manager role credential$")
//	public void login_as_manager_role_credential() throws Throwable {
//	 
//		try
//		   {
//			pp=new ProjectPage(driver);
//		    lp=new LoginPage(driver);
//		    String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
//		    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
//		    
//		    pp.clickOnLogout();
//		   
//		    lp.enterUname(userName);
//		    lp.enterPass(passWord);
//		    lp.clickOnLogin();
//		    
//		   }
//			catch(Exception e)
//			{
//			   lb=new LaunchBrowser();
//			   lb.getScreenShot(fileName);
//			   e.printStackTrace();
//			   driver.close();
//		      	Relogin_TPE rl=new Relogin_TPE();
//		      	rl.reLogin();
//		      	throw e;
//			}  
//		    
//
//	}

	@When("^user navigate to defect tracking page$")
	public void user_navigate_to_defect_tracking_page() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
		pp.selectProject(projectName);
		pp.selectRelease(releaseName);
		rp=new ReleasePage(driver);
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

	@When("^click on reset button and change the login credential and save it$")
	public void click_on_reset_button_and_change_the_login_credential_and_save_it() throws Throwable {
	    try
	    {
		exep=new ExecutionPage(driver);
		String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_2");
	   	 String jiraPassWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_2");

		exep.loginToDTS(jiraUserName, jiraPassWord);
		
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

	@When("^navigate to requirement page$")
	public void navigate_to_requirement_page() throws Throwable {
	   try
	   {
		rp.clickOnRequirements();
		req=new RequirementsPage(driver);
		req.clickOnImport();
		String importType="JIRA";
		
		req.chooseImportType(importType);
		
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

	@Then("^check the credential is updated$")
	public void check_the_credential_is_updated() throws Throwable {
	    
		try
		{
		String validateUser=exep.dtsUsername.getText();
		String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_2");
		if(validateUser.equals(jiraUserName))
		{
			System.out.println("Jira Credential updated successfully");
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

	@When("^navigate to test execution page$")
	public void navigate_to_test_execution_page() throws Throwable {
	   try
	   {
		rp.clickOnTestExecution();
	    tr=new TestRepositoryPage(driver);
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
	    
	
	    String[] navigation=new String[2];
	    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
	    navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
	    tr.navigateToNode(releaseName, navigation);
	    
	   // int testcases=Excel_Lib.getNumberData(INPUT_PATH_3, sheetName, rowNum, cellNum);
	    int testcase=1;
	    exep.clickOnDefectButton(testcase);
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

	@Then("^check the credential is updated in execution page$")
	public void check_the_credential_is_updated_in_execution_page() throws Throwable {
		
		try
		{
		String validateUser=exep.dtsUsername.getText();
		String jiraUserName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_2");
		if(validateUser.equals(jiraUserName))
		{
			System.out.println("Jira Credential updated successfully");
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
}
