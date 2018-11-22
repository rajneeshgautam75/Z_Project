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

public class Defect_Tracking_Admin_305 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	DefectTracking dt;
	boolean[] actual=new boolean[15];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_305";
	@Given("^user logged in to zephyr as Manager$")
	public void user_logged_in_to_zephyr_as_Manager() throws Throwable {
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

	@When("^user navigates to Administration$")
	public void user_navigates_to_Administration() throws Throwable {
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

	@When("^further navigates on Defect admin and Preferences$")
	public void further_navigates_on_Defect_admin_and_Preferences() throws Throwable {
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

	@When("^user Adds few property$")
	public void user_Adds_few_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			bp.waitForElement();
			for(int i=0;i<=5;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 5);
		    String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 6);
		    boolean res=ccp.checkAvailableCategories(category, name, value);
		    if(res==false)
		    {
			actual[6]=ccp.addNewProperty(category, name, value);	
		    }
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

	@Then("^few property should be added$")
	public void few_property_should_be_added() throws Throwable {
		try
		{
			for(int i=0;i<=5;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 5);
		    String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 6);	
		    actual[7]=bp.waitForElement();
			actual[8]=ccp.validateCategories(name, value);
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

	@When("^user Deletes one property$")
	public void user_Deletes_one_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 5);
			bp.waitForElement();
			actual[9]=ccp.deleteProperty(category, name);
			
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

	@Then("^should delete one property$")
	public void should_delete_one_property() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12, 5);
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12, 6);
			bp.waitForElement();
			actual[10]=ccp.checkAvailableCategories(category, name, value);	
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

	@When("^user Deletes two property$")
	public void user_Deletes_two_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			for(int i=1;i<=2;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 5);
			bp.waitForElement();
			actual[11]=ccp.deleteProperty(category, name);
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

	@Then("^should be able To delete two property$")
	public void should_be_able_To_delete_two_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			for(int i=1;i<=2;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 5);
			bp.waitForElement();
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12+i, 6);
			actual[12]=ccp.checkAvailableCategories(category, name, value);
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

	@When("^user Deletes all property$")
	public void user_Deletes_all_property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			for(int i=3;i<=5;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 5);
			bp.waitForElement();
			actual[13]=ccp.deleteProperty(category, name);
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

	@Then("^Should delete all the Property$")
	public void should_delete_all_the_Property() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			for(int i=3;i<=5;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 12+i, 5);
			bp.waitForElement();
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 12+i, 6);
			actual[14]=ccp.checkAvailableCategories(category, name, value);
			}
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
