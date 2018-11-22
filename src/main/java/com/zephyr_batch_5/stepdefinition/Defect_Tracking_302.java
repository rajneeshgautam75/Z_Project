package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_302 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_302";
	
    @Given("^user logins as Manager Credential to zephyr Application$")
    public void user_logins_as_Manager_Credential_to_zephyr_Application() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
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

	@When("^clicks ON administration$")
	public void clicks_ON_administration() throws Throwable {
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

	@When("^further clicks On Defect Admin and Preferences$")
	public void further_clicks_On_Defect_Admin_and_Preferences() throws Throwable {
		try
		{
			bp.waitForElement();
	    	actual[5]=ccp.moveToPreferences();	
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

	@When("^In Custom fields Disable the system default Enabled Property and save$")
	public void in_Custom_fields_Disable_the_system_default_Enabled_Property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[6]=ccp.editCategories(category, name, value, active);
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

	@Then("^should be able to disable the Property$")
	public void should_be_able_to_disable_the_Property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
	    	bp.waitForElement();
	    	actual[7]=ccp.validateCheckBoxEnabledOrDisabled(name);
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

	@When("^Enable the disabled Property and Cancel$")
	public void enable_the_disabled_Property_and_Cancel() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[8]=ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	ccp.clickOnCancelPreference.click();
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

	@Then("^warning message will popup$")
	public void warning_message_will_popup() throws Throwable {
		try
		{
			bp.waitForElement();
			ccp.clickOnCancelPreferencePopWindow.click();
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
		@When("^Enable the disabled Property and Save$")
		public void enable_the_disabled_Property_and_Save() throws Throwable {
			try
			{
				String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
		    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
		    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
		    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 100, 100);
		    	bp.waitForElement();
		    	actual[9]=ccp.editCategories(category, name, value, active);
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

		@Then("^should be enabled the property$")
		public void should_be_enabled_the_property() throws Throwable {
			try
			{
				String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
		    	bp.waitForElement();
		    	actual[10]=ccp.validateCheckBoxEnabledOrDisabled(name);
		    	for(int k=0;k<=actual.length-1;k++)
				{
					soft.assertEquals(actual[k], true);
				}
				soft.assertAll();
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


