package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_28 extends LaunchBrowser {
	
	ProjectPage pp;
	DashBoardPage db;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Dashboard_28";
	
	boolean[] actual=new boolean[24];
	 SoftAssert soft=new SoftAssert();
	
	@When("^user click on Add dashboard symbol and create a dashboard$")
	public void user_click_on_Add_dashboard_symbol_and_create_a_dashboard() throws Throwable {
	  try
	  {
		  pp=new ProjectPage(driver);
		db=new DashBoardPage(driver);
	    
		
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 1);
	    String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 2);
	    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 3);
	    String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 4);
	    
	    
	    actual[0]=db.clickOnAddDashBoardSymbol();
	   actual[1]=db.enterDashBoardDetails(name, desc, layout, shareType);
	  }
	  catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	   
	   
	}

	@Then("^dash_board created successfully$")
	public void dash_board_created_successfully() throws Throwable {
		try
		{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 1);
		actual[2]= db.validateDashBoard(dashBoard);
		   
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}

	@When("^user Add Test Automation Status Gadget with Refresh interval as one hour$")
	public void user_Add_Test_Automation_Status_Gadget_with_Refresh_interval_as_one_hour() throws Throwable {
	    
		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 6);
		  
		  actual[3]=db.selectDashboard(dashBoard);
		  actual[4]=db.clickOnAddGadgetSymbol();
		  actual[5]=db.addGadget(gadgetName);
		  actual[6]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
		}
			catch(Exception e)
			{

			lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}  
		
	}

	@Then("^Test Automation Status Gadget with Refresh interval as one hour created successfully$")
	public void test_Automation_Status_Gadget_with_Refresh_interval_as_one_hour_created_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		actual[7]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^user Add Test Automation Status Gadget with Refresh interval as four hour$")
	public void user_Add_Test_Automation_Status_Gadget_with_Refresh_interval_as_four_hour() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 11, 6);
		  
		 // db.selectDashboard(dashBoard);
		  actual[8]=db.clickOnAddGadgetSymbol();
		  actual[9]=db.addGadget(gadgetName);
		  actual[10]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
		}
			catch(Exception e)
			{

			lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}  
		
	}

	@Then("^Test Automation Status Gadget with Refresh interval as four hour created successfully$")
	public void test_Automation_Status_Gadget_with_Refresh_interval_as_four_hour_created_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		actual[11]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^user Add Test Automation Status Gadget with Refresh interval as eight hour$")
	public void user_Add_Test_Automation_Status_Gadget_with_Refresh_interval_as_eight_hour() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 12, 6);
		  
		 // db.selectDashboard(dashBoard);
		  actual[12]=db.clickOnAddGadgetSymbol();
		  actual[13]=db.addGadget(gadgetName);
		  actual[14]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
		}
		
			catch(Exception e)
			{

			lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}  
		
	}
	@Then("^Test Automation Status Gadget with Refresh interval as eight hour created successfully$")
	public void test_Automation_Status_Gadget_with_Refresh_interval_as_eight_hour_created_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		actual[15]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^user Add Test Automation Status Gadget with Refresh interval as one day$")
	public void user_Add_Test_Automation_Status_Gadget_with_Refresh_interval_as_one_day() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 13, 6);
		  
		 // db.selectDashboard(dashBoard);
		  actual[16]=db.clickOnAddGadgetSymbol();
		  actual[17]=db.addGadget(gadgetName);
		  actual[18]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
		}
			catch(Exception e)
			{

			lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}  
		
	}

	@Then("^Test Automation Status Gadget with Refresh interval as one day created successfully$")
	public void test_Automation_Status_Gadget_with_Refresh_interval_as_one_day_created_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		actual[19]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^user Add Test Automation Status Gadget with Refresh interval as one week$")
	public void user_Add_Test_Automation_Status_Gadget_with_Refresh_interval_as_one_week() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 14, 6);
		  
		 // db.selectDashboard(dashBoard);
		  actual[20]=db.clickOnAddGadgetSymbol();
		  actual[21]=db.addGadget(gadgetName);
		  actual[22]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
		}
			catch(Exception e)
			{

			lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}  
		
	}

	@Then("^Test Automation Status Gadget with Refresh interval as one week created successfully$")
	public void test_Automation_Status_Gadget_with_Refresh_interval_as_one_week_created_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 10, 5);
		actual[23]=db.validateGadget(gadgetName);
		
		pp.backToProjectPage();
		
		for(int k=0;k<=actual.length-1;k++)
		{
			//System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();	
	
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}
}
