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

public class Defect_Tracking_Admin_310 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[60];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_310";
	@Given("^user Logged as Manager to Zephyr application$")
	public void user_Logged_as_Manager_to_Zephyr_application() throws Throwable {
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

	@When("^User navigates to  Administration app$")
	public void user_navigates_to_Administration_app() throws Throwable {
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

	@When("^user Launches defects Admin app and preferences$")
	public void user_Launches_defects_Admin_app_and_preferences() throws Throwable {
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

	@When("^Selects the General Configuration Category,click on Add button and enter value for existing property with single character and save$")
	public void selects_the_General_Configuration_Category_click_on_Add_button_and_enter_value_for_existing_property_with_single_character_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[6]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with single character for General Configuration category$")
	public void property_value_should_be_saved_with_single_character_for_General_Configuration_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
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

	@When("^Selects the Chart Options Category,click on Add button and Enters value for existing property with single character and save$")
	public void selects_the_Chart_Options_Category_click_on_Add_button_and_Enters_value_for_existing_property_with_single_character_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[8]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with single character for Chart Options category$")
	public void property_value_should_be_saved_with_single_character_for_Chart_Options_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
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

	@When("^Selects the Custom Fields Category,click on Add button and enter value for existing property with single character and save$")
	public void selects_the_Custom_Fields_Category_click_on_Add_button_and_enter_value_for_existing_property_with_single_character_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[10]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with single character for Custom Fields category$")
	public void property_value_should_be_saved_with_single_character_for_Custom_Fields_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
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

	@When("^selects the General Configuration Category,click on Add button and Enters Maximum more than five thousand characters and save$")
	public void selects_the_General_Configuration_Category_click_on_Add_button_and_Enters_Maximum_more_than_five_thousand_characters_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 7, 0);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[12]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with more than five thousand characters for General Configuration category$")
	public void property_value_should_be_saved_with_more_than_five_thousand_characters_for_General_Configuration_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 21, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 7, 0);
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

	@When("^Selects the chart Options Category,click on Add button and Enters Maximum more than five thousand characters and save in value field$")
	public void selects_the_chart_Options_Category_click_on_Add_button_and_Enters_Maximum_more_than_five_thousand_characters_and_save_in_value_field() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 7, 0);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[14]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with more than five thousand characters for Chart Options category$")
	public void property_value_should_be_saved_with_more_than_five_thousand_characters_for_Chart_Options_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 22, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 7, 0);
	    	bp.waitForElement();
	    	actual[15]=ccp.validateCategories(name, value);
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

	@When("^Selects the custom Fields Category,click on Add button and Enters Maximum more than five thousand characters and save in value field$")
	public void selects_the_custom_Fields_Category_click_on_Add_button_and_Enters_Maximum_more_than_five_thousand_characters_and_save_in_value_field() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 7, 0);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[16]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with more than five thousand characters for Custom Fields category$")
	public void property_value_should_be_saved_with_more_than_five_thousand_characters_for_Custom_Fields_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 23, 4);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 7, 0);
	    	bp.waitForElement();
	    	actual[17]=ccp.validateCategories(name, value);
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

	@When("^Selects the General Configuration Category,click on Add button,Enters empty value for existing property and save$")
	public void selects_the_General_Configuration_Category_click_on_Add_button_Enters_empty_value_for_existing_property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[18]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Should  be able to save property without value field for General Configuration$")
	public void should_be_able_to_save_property_without_value_field_for_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
			String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	bp.waitForElement();
	    	actual[19]=ccp.validateCategories(name, value);
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

	@When("^Selects the Chart Options Category,click on Add button,Enters empty value for existing property and save$")
	public void selects_the_Chart_Options_Category_click_on_Add_button_Enters_empty_value_for_existing_property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[20]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Should  be able to save property without value field for Chart Options category$")
	public void should_be_able_to_save_property_without_value_field_for_Chart_Options_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
			String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	bp.waitForElement();
	    	actual[21]=ccp.validateCategories(name, value);
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

	@When("^Selects the Custom Fields Category,click on Add button,Enters empty value for existing property and save$")
	public void selects_the_Custom_Fields_Category_click_on_Add_button_Enters_empty_value_for_existing_property_and_save() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[22]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Should  be able to save property without value field for Custom Fields category$")
	public void should_be_able_to_save_property_without_value_field_for_Custom_Fields_category() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
			String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	bp.waitForElement();
	    	actual[23]=ccp.validateCategories(name, value);
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
