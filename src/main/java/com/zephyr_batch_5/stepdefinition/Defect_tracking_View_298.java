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

public class Defect_tracking_View_298 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_tracking_View_298";
	@Given("^user Logins to zephyr as Manager Credentials$")
	public void user_Logins_to_zephyr_as_Manager_Credentials() throws Throwable {
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

	@When("^user goes to Adminstration$")
	public void user_goes_to_Adminstration() throws Throwable {
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

	@When("^User clicks on Defects admin and prefrences$")
	public void user_clicks_on_Defects_admin_and_prefrences() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[5]=ccp.moveToPreferences();
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

	@Then("^Should be able to see the pre defined dts\\.customfield\\.jira\\.date_format customfield property$")
	public void should_be_able_to_see_the_pre_defined_dts_customfield_jira_date_format_customfield_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	actual[6]=ccp.validateCategories(name, value);
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

	@Then("^Should be able to see the pre defined jira\\.customfield\\.createmeta\\.allproject\\.online customfield property$")
	public void should_be_able_to_see_the_pre_defined_jira_customfield_createmeta_allproject_online_customfield_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 9, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 9, 2);
			String lower=value.toLowerCase();
	    	bp.waitForElement();
	    	actual[7]=ccp.validateCategories(name, lower);
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

	@Then("^Should be able to see the pre defined jira\\.customfield\\.field\\.maxlength customfield property$")
	public void should_be_able_to_see_the_pre_defined_jira_customfield_field_maxlength_customfield_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 10, 2);
	    	bp.waitForElement();
	    	actual[8]=ccp.validateCategories(name, value);
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

	@Then("^Should be able to see the pre defined jira\\.customfield\\.socket\\.timeout customfield property$")
	public void should_be_able_to_see_the_pre_defined_jira_customfield_socket_timeout_customfield_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 11, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 11, 2));
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

	@Then("^Should be able to see the pre defined jira\\.customfield\\.zephyr\\.field\\.mapping customfield property$")
	public void should_be_able_to_see_the_pre_defined_jira_customfield_zephyr_field_mapping_customfield_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 2);
	    	bp.waitForElement();
	    	actual[10]=ccp.validateCategories(name, value);
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
