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

public class Defect_Tracking_View_300 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_View_300";
	@Given("^user loginas manager to zephyr$")
	public void user_loginas_manager_to_zephyr() throws Throwable {
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

	@When("^user clicks on aministration$")
	public void user_clicks_on_aministration() throws Throwable {
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

	@When("^user clicks on defects admin and preferences and further clicks on custom fields$")
	public void user_clicks_on_defects_admin_and_preferences_and_further_clicks_on_custom_fields() throws Throwable {
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

	@When("^changes the value for dts\\.trendchart\\.t(\\d+)\\.defectseries(\\d+)\\.status as new,assigned,reopened$")
	public void changes_the_value_for_dts_trendchart_t_defectseries_status_as_new_assigned_reopened(int arg1, int arg2) throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 3);
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

	@Then("^Should be able to see the pre defined Chart options property$")
	public void should_be_able_to_see_the_pre_defined_Chart_options_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 3);
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

	@When("^user changes the value for dts\\.trendchart\\.t(\\d+)\\.defectseries(\\d+)\\.status as resolved,verified,closed$")
	public void user_changes_the_value_for_dts_trendchart_t_defectseries_status_as_resolved_verified_closed(int arg1, int arg2) throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 3);
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

	@Then("^Should be able to See the pre defined Chart options property$")
	public void should_be_able_to_See_the_pre_defined_Chart_options_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 5, 3);
	    	bp.waitForElement();
	    	actual[9]=ccp.validateCategories(name, value);
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
