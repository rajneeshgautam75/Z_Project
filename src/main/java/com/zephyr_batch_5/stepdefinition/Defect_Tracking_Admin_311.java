package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Admin_311 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_311";
	
	@Given("^user will login as manager credential to zephyr$")
	public void user_will_login_as_manager_credential_to_zephyr() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			dt=new DefectTracking(driver);
			ccp=new CreateCustomFieldsPage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			bp.waitForElement();
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);       
			actual[3]=lp.clickOnLogin();  
			bp.waitForElement(); 
			
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

	@When("^user go to administration page$")
	public void user_go_to_administration_page() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[4]=pp.launchAdministration();
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

	@When("^clicks on Defect admin app$")
	public void clicks_on_Defect_admin_app() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[5]=pp.launchDefectAdmin();
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

	@When("^view the tab of Jira custom Field Management$")
	public void view_the_tab_of_Jira_custom_Field_Management() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 31, 5);
			bp.waitForElement();
			actual[6]=ccp.validateJIRACustomFieldsManagement(name);
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

	@Then("^should able to view the label of Clear cache of online JIRA custom fields$")
	public void should_able_to_view_the_label_of_Clear_cache_of_online_JIRA_custom_fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 31, 9);
			bp.waitForElement();
			actual[7]=ccp.validateClearCacheOfOnlineJIRACustomFields(name);
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

	@Then("^should able to view the label of Clear Selected$")
	public void should_able_to_view_the_label_of_Clear_Selected() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 14, 2);
			bp.waitForElement();
			actual[8]=ccp.validateClearSelectedOrClearAll(name);
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

	@Then("^should able to view the label of Clear All$")
	public void should_able_to_view_the_label_of_Clear_All() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 15, 2);
			bp.waitForElement();
			actual[9]=ccp.validateClearSelectedOrClearAll(name);
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
