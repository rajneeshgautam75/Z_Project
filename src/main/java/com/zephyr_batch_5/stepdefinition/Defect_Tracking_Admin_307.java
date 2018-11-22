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

public class Defect_Tracking_Admin_307 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[33];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_307";
	
	@Given("^user Logged as Manager credentials to zephyr$")
	public void user_Logged_as_Manager_credentials_to_zephyr() throws Throwable {
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

	@When("^user Navigates to Administration page$")
	public void user_Navigates_to_Administration_page() throws Throwable {
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

	@When("^User navigates to Defect Admin and Preferences$")
	public void user_navigates_to_Defect_Admin_and_Preferences() throws Throwable {
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

	@When("^user Enters property name with upper case in General Configuration$")
	public void user_Enters_property_name_with_upper_case_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with upper case in General Configuration$")
	public void property_name_should_be_saved_with_upper_case_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	bp.waitForElement();
	    	actual[6]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with lower case in General Configuration$")
	public void user_Enters_property_name_with_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with lower case in General Configuration$")
	public void property_name_should_be_saved_with_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
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

	@When("^user Enter property name with both upper case and lower case in General Configuration$")
	public void user_Enter_property_name_with_both_upper_case_and_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with both upper case and lower case in General Configuration$")
	public void property_name_should_be_saved_with_both_upper_case_and_lower_case_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	bp.waitForElement();
	    	actual[8]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with numbers only in General Configuration$")
	public void user_Enters_property_name_with_numbers_only_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with numbers only in General Configuration$")
	public void property_name_should_be_saved_with_numbers_only_in_General_Configuration() throws Throwable {
		try
		{
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
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

	@When("^user Enters property name with Alphanumeric characters in General Configuration$")
	public void user_Enters_property_name_with_Alphanumeric_characters_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Alphanumeric characters in General Configuration$")
	public void property_name_should_be_saved_with_Alphanumeric_characters_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	bp.waitForElement();
	    	actual[10]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Special characters in General Configuration$")
	public void user_Enters_property_name_with_Special_characters_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Special characters in General Configuration$")
	public void property_name_should_be_saved_with_Special_characters_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
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

	@When("^user Enters property name with International characters in General Configuration$")
	public void user_Enters_property_name_with_International_characters_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with International characters in General Configuration$")
	public void property_name_should_be_saved_with_International_characters_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	bp.waitForElement();
	    	actual[12]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with leading space in General Configuration$")
	public void user_Enters_property_name_with_leading_space_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with leading space in General Configuration$")
	public void property_name_should_be_saved_with_leading_space_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
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

	@When("^user Enters property name with trailing space in General Configuration$")
	public void user_Enters_property_name_with_trailing_space_in_General_Configuration() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 3, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with trailing space in General Configuration$")
	public void property_name_should_be_saved_with_trailing_space_in_General_Configuration() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	bp.waitForElement();
	    	actual[14]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Uppercase in Chart Options$")
	public void user_Enters_property_name_with_Uppercase_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Upper Case in Chart Options$")
	public void property_name_should_be_saved_with_Upper_Case_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
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

	@When("^user Enters property name with lower case in Chart Options$")
	public void user_Enters_property_name_with_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with lower case Chart Options$")
	public void property_name_should_be_saved_with_lower_case_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	bp.waitForElement();
	    	actual[16]=ccp.validatePropertyName(name); 
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

	@When("^user Enter property name with both Upper case and lower case in Chart Options$")
	public void user_Enter_property_name_with_both_Upper_case_and_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with both Upper case and lower case in Chart Options$")
	public void property_name_should_be_saved_with_both_Upper_case_and_lower_case_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	bp.waitForElement();
	    	actual[17]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Numbers only in Chart Options$")
	public void user_Enters_property_name_with_Numbers_only_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Numbers only in Chart Options$")
	public void property_name_should_be_saved_with_Numbers_only_in_Chart_Options() throws Throwable {
		try
		{
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	bp.waitForElement();
	    	actual[18]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Alphanumeric characters in Chart Options$")
	public void user_Enters_property_name_with_Alphanumeric_characters_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Alphanumeric characters in Chart Options$")
	public void property_name_should_be_saved_with_Alphanumeric_characters_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	bp.waitForElement();
	    	actual[19]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Special Characters in Chart Options$")
	public void user_Enters_property_name_with_Special_Characters_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Special Characters in Chart Options$")
	public void property_name_should_be_saved_with_Special_Characters_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	bp.waitForElement();
	    	actual[20]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with International characters in Chart Options$")
	public void user_Enters_property_name_with_International_characters_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with international characters in Chart Options$")
	public void property_name_should_be_saved_with_international_characters_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	bp.waitForElement();
	    	actual[21]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Leading space in Chart Options$")
	public void user_Enters_property_name_with_Leading_space_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Leading space in Chart Options$")
	public void property_name_should_be_saved_with_Leading_space_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	bp.waitForElement();
	    	actual[22]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with Trailing space in Chart Options$")
	public void user_Enters_property_name_with_Trailing_space_in_Chart_Options() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with Trailing space in Chart Options$")
	public void property_name_should_be_saved_with_Trailing_space_in_Chart_Options() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	bp.waitForElement();
	    	actual[23]=ccp.validatePropertyName(name); 
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

	@When("^User Enters property name with upper case in Custom Fields$")
	public void user_Enters_property_name_with_upper_case_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^property name should be saved with upper case in Custom Fields$")
	public void property_name_should_be_saved_with_upper_case_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 9);
	    	bp.waitForElement();
	    	actual[24]=ccp.validatePropertyName(name); 
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

	@When("^User Enters property name with lower case in Custom Fields$")
	public void user_Enters_property_name_with_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property Name should be saved with lower case in Custom Fields$")
	public void property_Name_should_be_saved_with_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 9);
	    	bp.waitForElement();
	    	actual[25]=ccp.validatePropertyName(name); 
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

	@When("^User Enter property name with both upper case and lower case in Custom Fields$")
	public void user_Enter_property_name_with_both_upper_case_and_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name Should be saved with both upper case and lower case in Custom Fields$")
	public void property_name_Should_be_saved_with_both_upper_case_and_lower_case_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 13, 9);
	    	bp.waitForElement();
	    	actual[26]=ccp.validatePropertyName(name); 
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

	@When("^User Enters property name with numbers only in Custom Fields$")
	public void user_Enters_property_name_with_numbers_only_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should Be saved with numbers only in Custom Fields$")
	public void property_name_should_Be_saved_with_numbers_only_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"Excecution", 14, 9));
	    	bp.waitForElement();
	    	actual[27]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with alphanumeric characters in Custom Fields$")
	public void user_Enters_property_name_with_alphanumeric_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with alphanumeric characters in Custom Fields$")
	public void property_name_should_be_saved_with_alphanumeric_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 15, 9);
	    	bp.waitForElement();
	    	actual[28]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with special characters in Custom Fields$")
	public void user_Enters_property_name_with_special_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with special characters in Custom Fields$")
	public void property_name_should_be_saved_with_special_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 16, 9);
	    	bp.waitForElement();
	    	actual[29]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with international characters in Custom Fields$")
	public void user_Enters_property_name_with_international_characters_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with International Characters in Custom Fields$")
	public void property_name_should_be_saved_with_International_Characters_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 17, 9);
	    	bp.waitForElement();
	    	actual[30]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with leading Space in Custom Fields$")
	public void user_Enters_property_name_with_leading_Space_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with leading Space in Custom Fields$")
	public void property_name_should_be_saved_with_leading_Space_in_Custom_Fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 18, 9);
	    	bp.waitForElement();
	    	actual[31]=ccp.validatePropertyName(name); 
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

	@When("^user Enters property name with trailing Space in Custom Fields$")
	public void user_Enters_property_name_with_trailing_Space_in_Custom_Fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 11, 6);
			bp.waitForElement();
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

	@Then("^Property name should be saved with trailing space in Custom Fields$")
	public void property_name_should_be_saved_with_trailing_space_in_Custom_Fields() throws Throwable {
		try
		{
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 19, 9);
			bp.waitForElement();
			actual[32]=ccp.validatePropertyName(name); 
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
