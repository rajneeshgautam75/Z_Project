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

public class Defect_Tracking_Admin_308 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_308";
	@Given("^User Logged as Manager credentials to Zephyr application$")
	public void user_Logged_as_Manager_credentials_to_Zephyr_application() throws Throwable {
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

	@When("^User Navigates to Administration$")
	public void user_Navigates_to_Administration() throws Throwable {
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

	@When("^User Launches Defects Admin app and$")
	public void user_Launches_Defects_Admin_app_and() throws Throwable {
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

	@When("^Selects the General Configuration Category,click on Add button and Enters single character in name field and save$")
	public void selects_the_General_Configuration_Category_click_on_Add_button_and_Enters_single_character_in_name_field_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 5);
	    	actual[6]=bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
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

	@Then("^Property name should be saved with single character for General Configuration category$")
	public void property_name_should_be_saved_with_single_character_for_General_Configuration_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	bp.waitForElement();
	    	actual[7]=ccp.validatePropertyName(name); 
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

	@When("^Selects the Chart Options Category,click on Add button and Enters single character in Name field and save$")
	public void selects_the_Chart_Options_Category_click_on_Add_button_and_Enters_single_character_in_Name_field_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 5);
	    	actual[8]=bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
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

	@Then("^Property name should be saved with single character for Chart Options category$")
	public void property_name_should_be_saved_with_single_character_for_Chart_Options_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	bp.waitForElement();
	    	actual[9]=ccp.validatePropertyName(name); 
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

	@When("^Selects the Custom Fields Category,click on Add button and Enters single character in name field and save$")
	public void selects_the_Custom_Fields_Category_click_on_Add_button_and_Enters_single_character_in_name_field_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 5);
	    	actual[10]=bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
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

	@Then("^Property name should be saved with single character for Custom Fields category$")
	public void property_name_should_be_saved_with_single_character_for_Custom_Fields_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	bp.waitForElement();
	    	actual[11]=ccp.validatePropertyName(name); 
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

	@When("^selects the General Configuration Category,click on Add button and Enters Maximum two fifty five characters in name field and save$")
	public void selects_the_General_Configuration_Category_click_on_Add_button_and_Enters_Maximum_two_fifty_five_characters_in_name_field_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 19, 2);
	    	actual[12]=bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
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

	@Then("^property name should be saved with Maximum two fifty five characters for General Configuration category$")
	public void property_name_should_be_saved_with_Maximum_two_fifty_five_characters_for_General_Configuration_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 2);
	    	bp.waitForElement();
	    	actual[13]=ccp.validatePropertyName(name); 
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

	@When("^Selects the chart Options Category,click on Add button and Enters Maximum two fifty five characters in Name field and save$")
	public void selects_the_chart_Options_Category_click_on_Add_button_and_Enters_Maximum_two_fifty_five_characters_in_Name_field_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 19, 2);
	    	actual[14]=bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
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

	@Then("^Property name should be saved with Maximum Two fifty five characters for Chart Options category$")
	public void property_name_should_be_saved_with_Maximum_Two_fifty_five_characters_for_Chart_Options_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 2);
	    	bp.waitForElement();
	    	actual[15]=ccp.validatePropertyName(name); 
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

	@When("^Selects the custom Fields Category,click on Add button and Enters Maximum two fifty five characters in name field and save$")
	public void selects_the_custom_Fields_Category_click_on_Add_button_and_Enters_Maximum_two_fifty_five_characters_in_name_field_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 2);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 19, 2);
	    	actual[16]=bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
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

	@Then("^Property name should be saved with Maximum Two Fifty Five characters for Custom Fields category$")
	public void property_name_should_be_saved_with_Maximum_Two_Fifty_Five_characters_for_Custom_Fields_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 17, 2);
	    	bp.waitForElement();
	    	actual[17]=ccp.validatePropertyName(name); 
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
