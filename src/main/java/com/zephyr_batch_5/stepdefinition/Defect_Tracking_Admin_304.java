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

public class Defect_Tracking_Admin_304 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_304";
	
	@Given("^user logins as Manager Credentials To Zephyr$")
	public void user_logins_as_Manager_Credentials_To_Zephyr() throws Throwable {
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

	@When("^clicks on Administration$")
	public void clicks_on_Administration() throws Throwable {
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

	@When("^Further clicks on Defect admin and Preferences$")
	public void further_clicks_on_Defect_admin_and_Preferences() throws Throwable {
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

	@When("^Adds a new property$")
	public void adds_a_new_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
			boolean res=ccp.checkAvailableCategories(category,name, value);
			if(res==false)
			{
			actual[6]=ccp.addNewProperty(category, name, value);	
			
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

	@Then("^New property should be added$")
	public void new_property_should_be_added() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
	    	bp.waitForElement();
	    	actual[7]=ccp.validateCategories(name, value);
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

	@When("^disable the Enabled property and cancel$")
	public void disable_the_Enabled_property_and_cancel() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
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

	@Then("^Warning message will be popuped$")
	public void warning_message_will_be_popuped() throws Throwable {
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

	@When("^disable the Enabled property and save$")
	public void disable_the_Enabled_property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
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

	@Then("^should be able To Disable property$")
	public void should_be_able_To_Disable_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 5);
	    	bp.waitForElement();
	    	actual[10]=ccp.validateCheckBoxEnabledOrDisabled(name);
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

	@When("^enable the disabled Property and save$")
	public void enable_the_disabled_Property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 11, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 11, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);	
	    	bp.waitForElement();
	    	pp.launchAdministration();
	    	bp.waitForElement();
	    	ccp.moveToPreferences();
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	actual[11]=ccp.editCategories(category, name, value, active);
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

	@Then("^Should be able to enable the Property$")
	public void should_be_able_to_enable_the_Property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 11, 5);
	    	bp.waitForElement();
	    	actual[12]=ccp.validateCheckBoxEnabledOrDisabled(name);	
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
