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

public class Defect_Tracking_296 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_296";
   @Given("^user logins as manager Credentials to Zephyr$")
   public void user_logins_as_manager_Credentials_to_Zephyr() throws Throwable {
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

@When("^user goes to adminstration and Clicks on Defect admin$")
public void user_goes_to_adminstration_and_Clicks_on_Defect_admin() throws Throwable {
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

@When("^User goes to preferences and Edits and Change the Value for defects\\.timeout and Saves$")
public void user_goes_to_preferences_and_Edits_and_Change_the_Value_for_defects_timeout_and_Saves() throws Throwable {
	try
	{
		String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 1);
    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 3, 2));
    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
    	actual[5]=ccp.moveToPreferences();
    	bp.waitForElement();
    	ccp.editCategoriesOperation(category, name, value, active);
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

@Then("^Should be Able to Modify General Configuration property value$")
public void should_be_Able_to_Modify_General_Configuration_property_value() throws Throwable {
	try
	{
		String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 1);
    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 3, 2));
    	bp.waitForElement();
    	actual[7]=ccp.validateCategories(name, value);
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
