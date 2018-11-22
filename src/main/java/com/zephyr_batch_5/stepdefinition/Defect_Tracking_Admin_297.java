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

public class Defect_Tracking_Admin_297 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_297";
    @Given("^user logins as Manager Credentials to zephyr$")
    public void user_logins_as_Manager_Credentials_to_zephyr() throws Throwable {
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

    @When("^user goes to Adminstration and Clicks on defect admin$")
    public void user_goes_to_Adminstration_and_Clicks_on_defect_admin() throws Throwable {
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

@When("^User goes to preferences and Edits and changes the value for dts\\.trendchart\\.t(\\d+)\\.defectSeries(\\d+)\\.status and save$")
public void user_goes_to_preferences_and_Edits_and_changes_the_value_for_dts_trendchart_t_defectSeries_status_and_save(int arg1, int arg2) throws Throwable {
	try
	{
		String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 1);
    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
    	actual[5]=ccp.moveToPreferences();
    	actual[6]=ccp.editCategoriesOperation(category, name, value, active);
    	bp.waitForElement();
    	ccp.editCategories(category, name, value, active);
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

@Then("^Should be able to modify  Chart Option property value$")
public void should_be_able_to_modify_Chart_Option_property_value() throws Throwable {
	try
	{
		String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 1);
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

@When("^user logins as manager to zephyr$")
public void user_logins_as_manager_to_zephyr() throws Throwable {
	try
	{
		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		bp.waitForElement();
		actual[8]=pp.clickOnLogout();
		bp.waitForElement();
		actual[9]=lp.enterUname(uname);
		actual[10]=lp.enterPass(password);       
		actual[11]=lp.clickOnLogin();  
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

@When("^user clicks on adminstration and clicks on defect admin$")
public void user_clicks_on_adminstration_and_clicks_on_defect_admin() throws Throwable {
	try
	{
		bp.waitForElement();
		actual[12]=pp.launchAdministration();
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

@When("^user navigates to preferences,Edits and changes the value for dts\\.trendchart\\.t(\\d+)\\.defectSeries(\\d+)\\.status and save$")
public void user_navigates_to_preferences_Edits_and_changes_the_value_for_dts_trendchart_t_defectSeries_status_and_save(int arg1, int arg2) throws Throwable {
	try
	{
		String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
		String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 2);
    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 1);
    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
    	actual[13]=ccp.moveToPreferences();
    	bp.waitForElement();
    	ccp.editCategoriesOperation(category, name, value, active);
    	bp.waitForElement();
    	actual[14]=ccp.editCategories(category, name, value, active);
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

@Then("^To be able to Modify Chart Option property value$")
public void to_be_able_to_Modify_Chart_Option_property_value() throws Throwable {
	try
	{
		String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 2);
    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 1);
    	bp.waitForElement();
    	actual[15]=ccp.validateCategories(name, value);
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
