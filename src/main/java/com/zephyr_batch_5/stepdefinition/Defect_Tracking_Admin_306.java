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

public class Defect_Tracking_Admin_306 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[22];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_306";
	
    @Given("^user Logged as Manager to zephyr$")
    public void user_Logged_as_Manager_to_zephyr() throws Throwable {
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

	@When("^user navigates to Administration page$")
	public void user_navigates_to_Administration_page() throws Throwable {
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

	@When("^user navigates to Defect admin and Preferences$")
	public void user_navigates_to_Defect_admin_and_Preferences() throws Throwable {
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

	@When("^Disable the system default enabled property for chart option and save$")
	public void disable_the_system_default_enabled_property_for_chart_option_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 3);
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

	@Then("^Should be able to disable the property for chart option$")
	public void should_be_able_to_disable_the_property_for_chart_option() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
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

	@When("^Enable the disabled property and cancel for chart option$")
	public void enable_the_disabled_property_and_cancel_for_chart_option() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 3);
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

	@Then("^Warning message will popup in for chart option$")
	public void warning_message_will_popup_in_for_chart_option() throws Throwable {
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

	@When("^Enable a disabled property for chart option and save$")
	public void enable_a_disabled_property_for_chart_option_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 3);
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

	@Then("^should be enabled the property for chart option$")
	public void should_be_enabled_the_property_for_chart_option() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 4, 2);
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


	@When("^Disable the system default enabled property for General Configuration and save$")
	public void disable_the_system_default_enabled_property_for_General_Configuration_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 15, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 15, 0));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[11]=ccp.editCategories(category, name, value, active);
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

	@Then("^Should be able to disable the property for General Configuration$")
	public void should_be_able_to_disable_the_property_for_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 15, 1);
	    	bp.waitForElement();
	    	actual[12]=ccp.validateCheckBoxEnabledOrDisabled(name);
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

	@When("^Enable the disabled property and cancel for General Configuration$")
	public void enable_the_disabled_property_and_cancel_for_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 15, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 15, 0));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[13]=ccp.editCategoriesOperation(category, name, value, active);
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

	@Then("^Warning message will popup in General Configuration$")
	public void warning_message_will_popup_in_General_Configuration() throws Throwable {
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
	@When("^Enable a disabled property for General Configuration and save$")
	public void enable_a_disabled_property_for_General_Configuration_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 15, 1);
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomValues", 15, 0));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 100, 100);
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

	@Then("^should be enabled the property for General Configuration$")
	public void should_be_enabled_the_property_for_General_Configuration() throws Throwable {
		try
		{
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 15, 1);
	    	bp.waitForElement();
	    	actual[15]=ccp.validateCheckBoxEnabledOrDisabled(name);
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

	@When("^user adds new property$")
	public void user_adds_new_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 6);
			bp.waitForElement();
			boolean res=ccp.checkAvailableCategories(category,name, value);
			if(res==false)
			{
			ccp.addNewProperty(category, name, value);	
			
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

	@Then("^new property should be added$")
	public void new_property_should_be_added() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 6);
	    	bp.waitForElement();
	    	actual[16]=ccp.validateCategories(name, value);
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

	@When("^Disable added new property the enabled property and cancel$")
	public void disable_added_new_property_the_enabled_property_and_cancel() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[17]=ccp.editCategoriesOperation(category, name, value, active);
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

	@Then("^warning message popuped$")
	public void warning_message_popuped() throws Throwable {
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

	@When("^disable the added enable property and save$")
	public void disable_the_added_enable_property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 100, 100);
	    	bp.waitForElement();
	    	actual[18]=ccp.editCategories(category, name, value, active);
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

	@Then("^should be disable the property$")
	public void should_be_disable_the_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	bp.waitForElement();
	    	actual[19]=ccp.validateCheckBoxEnabledOrDisabled(name);
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

	@When("^Enable the disabled added new property and save$")
	public void enable_the_disabled_added_new_property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
	    	bp.waitForElement();
	    	actual[20]=ccp.editCategories(category, name, value, active);
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

	@Then("^to be enabled the new property$")
	public void to_be_enabled_the_new_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 5);
	    	bp.waitForElement();
	    	actual[21]=ccp.validateCheckBoxEnabledOrDisabled(name);
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
