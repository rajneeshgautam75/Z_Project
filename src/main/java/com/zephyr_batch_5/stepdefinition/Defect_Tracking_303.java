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

public class Defect_Tracking_303 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_303";
	
	@Given("^user logins as Manager Credentials to Zephyr application$")
	public void user_logins_as_Manager_Credentials_to_Zephyr_application() throws Throwable {
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

	@When("^clicks on Administration Page$")
	public void clicks_on_Administration_Page() throws Throwable {
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

	@When("^Further Clicks on Defect admin and Preferences$")
	public void further_Clicks_on_Defect_admin_and_Preferences() throws Throwable {
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

	@When("^Enable the disabled property and save$")
	public void enable_the_disabled_property_and_save() throws Throwable {
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

	@Then("^should be able to enable the property$")
	public void should_be_able_to_enable_the_property() throws Throwable {
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

	@When("^Disable the enabled property and cancel$")
	public void disable_the_enabled_property_and_cancel() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[8]=ccp.editCategoriesOperation(category, name, value, active);
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

	@Then("^Warning Message will Pop Up$")
	public void warning_Message_will_Pop_Up() throws Throwable {
		try
		{
			bp.waitForElement();
	    	ccp.clickOnCancelPreference.click();
	    	bp.waitForElement();
	    	ccp.clickOnCancelPreferencePopWindow.click();
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

	@When("^disable the enabled property and save$")
	public void disable_the_enabled_property_and_save() throws Throwable {
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

	@Then("^To be able to disable the property$")
	public void to_be_able_to_disable_the_property() throws Throwable {
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
