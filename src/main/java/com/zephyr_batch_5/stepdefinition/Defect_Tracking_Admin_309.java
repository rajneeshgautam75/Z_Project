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

public class Defect_Tracking_Admin_309 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[60];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_309";

	@Given("^user Logged to zephyr as Manager credentials$")
	public void user_Logged_to_zephyr_as_Manager_credentials() throws Throwable {
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

	@When("^user clicks on the Administration page$")
	public void user_clicks_on_the_Administration_page() throws Throwable {
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

	@When("^User further clicks to Defect Admin and Preferences$")
	public void user_further_clicks_to_Defect_Admin_and_Preferences() throws Throwable {
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

	@When("^user Enters value for existing property with upper case in General Configuration$")
	public void user_Enters_value_for_existing_property_with_upper_case_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 10);
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

	@Then("^Property value should be saved with upper case in General Configuration$")
	public void property_value_should_be_saved_with_upper_case_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 10);
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

	@When("^user Enters value for existing property with lower case in General Configuration$")
	public void user_Enters_value_for_existing_property_with_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 10);
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

	@Then("^Property value should be saved with lower case in General Configuration$")
	public void property_value_should_be_saved_with_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 10);
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

	@When("^user Enters value for existing property with upper case and lower case in General Configuration$")
	public void user_Enters_value_for_existing_property_with_upper_case_and_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 10);
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

	@Then("^Property value should be saved with both upper case and lower case in General Configuration$")
	public void property_value_should_be_saved_with_both_upper_case_and_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 10);
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

	@When("^user Enters value for existing property with numbers in General Configuration$")
	public void user_Enters_value_for_existing_property_with_numbers_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 10));
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

	@Then("^Property value should be saved with numbers only in General Configuration$")
	public void property_value_should_be_saved_with_numbers_only_in_General_Configuration() throws Throwable {
		try
		{
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 10));
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

	@When("^user Enters value for existing property with alphanumeric characters in General Configuration$")
	public void user_Enters_value_for_existing_property_with_alphanumeric_characters_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 10);
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

	@Then("^Property value should be saved with Alphanumeric characters in General Configuration$")
	public void property_value_should_be_saved_with_Alphanumeric_characters_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 10);
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

	@When("^user Enters  value for existing property with special characters in General Configuration$")
	public void user_Enters_value_for_existing_property_with_special_characters_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 10);
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

	@Then("^Property value should be saved with Special characters in General Configuration$")
	public void property_value_should_be_saved_with_Special_characters_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 10);
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

	@When("^user Enters value for existing property with international characters in General Configuration$")
	public void user_Enters_value_for_existing_property_with_international_characters_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 10);
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

	@Then("^Property value should be saved with International characters in General Configuration$")
	public void property_value_should_be_saved_with_International_characters_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 10);
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

	@When("^user Enters property value with leading space in General Configuration$")
	public void user_Enters_property_value_with_leading_space_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 10);
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

	@Then("^Property value should be saved with leading space in General Configuration$")
	public void property_value_should_be_saved_with_leading_space_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 10);
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

	@When("^user Enters property value with trailing space in General Configuration$")
	public void user_Enters_property_value_with_trailing_space_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 10);
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

	@Then("^Property value should be saved with trailing space in General Configuration$")
	public void property_value_should_be_saved_with_trailing_space_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 10);
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

	@When("^user Enters value for existing property with upper case in Chart Options$")
	public void user_Enters_value_for_existing_property_with_upper_case_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[24]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with upper case in Chart Options$")
	public void property_value_should_be_saved_with_upper_case_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 10);
	    	bp.waitForElement();
	    	actual[25]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with lower case in Chart Options$")
	public void user_Enters_value_for_existing_property_with_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[26]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with lower case in Chart Options$")
	public void property_value_should_be_saved_with_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 10);
	    	bp.waitForElement();
	    	actual[27]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with upper case and lower case in Chart Options$")
	public void user_Enters_value_for_existing_property_with_upper_case_and_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[28]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with both upper case and lower case in Chart Options$")
	public void property_value_should_be_saved_with_both_upper_case_and_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 10);
	    	bp.waitForElement();
	    	actual[29]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with numbers in Chart Options$")
	public void user_Enters_value_for_existing_property_with_numbers_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 10));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[30]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with numbers only in Chart Options$")
	public void property_value_should_be_saved_with_numbers_only_in_Chart_Options() throws Throwable {
		try
		{
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 10));
	    	bp.waitForElement();
	    	actual[31]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with alphanumeric characters in Chart Options$")
	public void user_Enters_value_for_existing_property_with_alphanumeric_characters_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[32]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with Alphanumeric characters in Chart Options$")
	public void property_value_should_be_saved_with_Alphanumeric_characters_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 10);
	    	bp.waitForElement();
	    	actual[33]=ccp.validateCategories(name, value);
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

	@When("^user Enters  value for existing property with special characters in Chart Options$")
	public void user_Enters_value_for_existing_property_with_special_characters_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[34]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with Special characters in Chart Options$")
	public void property_value_should_be_saved_with_Special_characters_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 10);
	    	bp.waitForElement();
	    	actual[35]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with international characters in Chart Options$")
	public void user_Enters_value_for_existing_property_with_international_characters_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[36]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with International characters in Chart Options$")
	public void property_value_should_be_saved_with_International_characters_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 10);
	    	bp.waitForElement();
	    	actual[37]=ccp.validateCategories(name, value);
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

	@When("^user Enters property value with leading space in Chart Options$")
	public void user_Enters_property_value_with_leading_space_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[38]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with leading space in Chart Options$")
	public void property_value_should_be_saved_with_leading_space_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 10);
	    	bp.waitForElement();
	    	actual[39]=ccp.validateCategories(name, value);
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

	@When("^user Enters property value with trailing space in Chart Options$")
	public void user_Enters_property_value_with_trailing_space_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[40]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with trailing space in Chart Options$")
	public void property_value_should_be_saved_with_trailing_space_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 10);
	    	bp.waitForElement();
	    	actual[41]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with upper case in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_upper_case_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[42]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with upper case in Custom Fields$")
	public void property_value_should_be_saved_with_upper_case_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 10);
	    	bp.waitForElement();
	    	actual[43]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with lower case in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[44]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with lower case in Custom Fields$")
	public void property_value_should_be_saved_with_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 10);
	    	bp.waitForElement();
	    	actual[45]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with upper case and lower case in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_upper_case_and_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[46]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with both upper case and lower case in Custom Fields$")
	public void property_value_should_be_saved_with_both_upper_case_and_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 10);
	    	bp.waitForElement();
	    	actual[47]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with numbers in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_numbers_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 10));
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[48]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with numbers only in Custom Fields$")
	public void property_value_should_be_saved_with_numbers_only_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 10));
	    	bp.waitForElement();
	    	actual[49]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with alphanumeric characters in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_alphanumeric_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[50]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with Alphanumeric characters in Custom Fields$")
	public void property_value_should_be_saved_with_Alphanumeric_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 10);
	    	bp.waitForElement();
	    	actual[51]=ccp.validateCategories(name, value);
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

	@When("^user Enters  value for existing property with special characters in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_special_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[52]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with Special characters in Custom Fields$")
	public void property_value_should_be_saved_with_Special_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 10);
	    	bp.waitForElement();
	    	actual[53]=ccp.validateCategories(name, value);
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

	@When("^user Enters value for existing property with international characters in Custom Fields$")
	public void user_Enters_value_for_existing_property_with_international_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[54]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with International characters in Custom Fields$")
	public void property_value_should_be_saved_with_International_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 10);
	    	bp.waitForElement();
	    	actual[55]=ccp.validateCategories(name, value);
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

	@When("^user Enters property value with leading space in Custom Fields$")
	public void user_Enters_property_value_with_leading_space_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[56]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with leading space in Custom Fields$")
	public void property_value_should_be_saved_with_leading_space_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 10);
	    	bp.waitForElement();
	    	actual[57]=ccp.validateCategories(name, value);
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

	@When("^user Enters property value with trailing space in Custom Fields$")
	public void user_Enters_property_value_with_trailing_space_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 10);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 100, 100);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
			actual[58]=ccp.editCategories(category, name, value, active);
			
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

	@Then("^Property value should be saved with trailing space in Custom Fields$")
	public void property_value_should_be_saved_with_trailing_space_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 10);
	    	bp.waitForElement();
	    	actual[59]=ccp.validateCategories(name, value);
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
