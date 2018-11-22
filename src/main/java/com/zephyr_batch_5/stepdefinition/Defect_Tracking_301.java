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

public class Defect_Tracking_301 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_301";
	
	@Given("^logins as Manager to zephyr by User$")
	public void logins_as_Manager_to_zephyr_by_User() throws Throwable {
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

	@When("^user Goes to adminstation and clicks on defect admin and preferences$")
	public void user_Goes_to_adminstation_and_clicks_on_defect_admin_and_preferences() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[4]=pp.launchAdministration();
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

	@When("^user navigates to Custom Fields and edits the value for jira\\.customfield\\.field\\.maxlength$")
	public void user_navigates_to_Custom_Fields_and_edits_the_value_for_jira_customfield_field_maxlength() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
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

	@Then("^should able to modify the value$")
	public void should_able_to_modify_the_value() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
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

	@When("^Edits the value for dts\\.customfield\\.jira\\.date_format$")
	public void edits_the_value_for_dts_customfield_jira_date_format() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	actual[8]=ccp.editCategories(category, name, value, active);
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

	@Then("^To be able to modify custom field property value$")
	public void to_be_able_to_modify_custom_field_property_value() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 2);
	    	bp.waitForElement();
	    	actual[9]=ccp.validateCategories(name, value);	
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

	@When("^user edits the value for jira\\.customfield\\.createmeta\\.allproject\\.online$")
	public void user_edits_the_value_for_jira_customfield_createmeta_allproject_online() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 9, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 9, 2);
	    	String lower=value.toLowerCase();
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	actual[10]=ccp.editCategories(category, name, lower, active);
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

	@Then("^should be able to modify the customfield property value$")
	public void should_be_able_to_modify_the_customfield_property_value() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 9, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 9, 2);
	    	bp.waitForElement();
	    	actual[11]=ccp.validateCategories(name, value);	
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

	@When("^User edit the value for jira\\.customfield\\.socket\\.timeout$")
	public void user_edit_the_value_for_jira_customfield_socket_timeout() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 11, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 11, 2));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	actual[12]=ccp.editCategories(category, name, value, active);
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

	@Then("^should be able to modify the cutom field property value$")
	public void should_be_able_to_modify_the_cutom_field_property_value() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 11, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 11, 2));
	    	bp.waitForElement();
	    	actual[13]=ccp.validateCategories(name, value);	
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

	@When("^user edits custom field property value for jira\\.customfield\\.zephyr\\.field\\.mapping$")
	public void user_edits_custom_field_property_value_for_jira_customfield_zephyr_field_mapping() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
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

	@Then("^should be able to Modify the Cutom field property value$")
	public void should_be_able_to_Modify_the_Cutom_field_property_value() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 2);
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
