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

public class Defect_Tracking_View_299 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[14];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_View_299";
	@Given("^Login as Manager to Zephyr$")
	public void login_as_Manager_to_Zephyr() throws Throwable {
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

	@When("^user clicks on Administration$")
	public void user_clicks_on_Administration() throws Throwable {
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

	@When("^User clicks on Defects Admin and Prefrences and further clicks on General Configuration$")
	public void user_clicks_on_Defects_Admin_and_Prefrences_and_further_clicks_on_General_Configuration() throws Throwable {
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

	@Then("^Should be able to see the pre defined defect\\.timeout General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_defect_timeout_General_Configuration_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 15, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 15, 0));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	ccp.editCategoriesOperation(category, name, value, active);
	    	bp.waitForElement();
	    	ccp.editCategories(category, name, value, active);
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

	@Then("^Should be able to see the pre defined defect\\.user\\.lookup_size General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_defect_user_lookup_size_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 16, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 16, 0));
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

	@Then("^Should be able to see the pre defined jira\\.activitystream\\.enabled General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_jira_activitystream_enabled_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 0);
	    	String lower=value.toLowerCase();
	    	bp.waitForElement();
	    	actual[8]=ccp.validateCategories(name, lower);
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

	@Then("^Should be able to see the pre defined jira\\.remote\\.link\\.additional\\.link\\.req-defect\\.enabled General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_jira_remote_link_additional_link_req_defect_enabled_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 18, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 18, 0);
	    	String lower=value.toLowerCase();
	    	bp.waitForElement();
	    	actual[9]=ccp.validateCategories(name, lower);
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

	@Then("^Should be able to see the pre defined jira\\.remote\\.link\\.additional\\.link\\.req-defect\\.relation General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_jira_remote_link_additional_link_req_defect_relation_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 19, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 19, 0);
	    	bp.waitForElement();
	    	actual[10]=ccp.validateCategories(name, value);
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

	@Then("^Should be able to see the pre defined jira\\.remote\\.link\\.additional\\.link\\.req-tc\\.enabled General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_jira_remote_link_additional_link_req_tc_enabled_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 20, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 20, 0);
	    	bp.waitForElement();
	    	String lower=value.toLowerCase();
	    	actual[11]=ccp.validateCategories(name, lower);
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

	@Then("^Should be able to see the pre defined jira\\.remote\\.link\\.enabled General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_jira_remote_link_enabled_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 21, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 21, 0);
	        String lower=value.toLowerCase();
	    	bp.waitForElement();
	    	actual[12]=ccp.validateCategories(name, lower);
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

	@Then("^Should be able to see the pre defined jira\\.rest\\.api\\.activity\\.url_fragment General Configuration property$")
	public void should_be_able_to_see_the_pre_defined_jira_rest_api_activity_url_fragment_General_Configuration_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 22, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 22, 0);
	    	bp.waitForElement();
	    	actual[13]=ccp.validateCategories(name, value);
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
