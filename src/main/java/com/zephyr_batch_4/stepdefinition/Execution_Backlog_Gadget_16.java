package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_16 extends LaunchBrowser{

	LaunchBrowser lb;
	DashBoardPage dp;
	BasePage bp;
	ProjectPage pp;
	String fileName="Execution_Backlog_Gadget_16";
	
	boolean[] actual=new boolean[18];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Lead,Launch the DashBoard$")
	public void lead_Launch_the_DashBoard() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
			bp=new BasePage();
			pp=new ProjectPage(driver);
			actual[0]=dp.clickOnManageDashboards();
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

	@When("^Create the Dashboard with available fields$")
	public void create_the_Dashboard_with_available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,39);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[1]=dp.clickOnAddDashBoardSymbol();
			actual[2]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[3]=dp.validateDashBoard(dashboardName);
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

	@When("^Add the execution backlog by selecting the dashBoard$")
	public void add_the_execution_backlog_by_selecting_the_dashBoard() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,39);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[4]=dp.selectDashboard(dashboardName);
			actual[5]=dp.clickOnAddGadgetSymbol();
			actual[6]=dp.addGadget(gadgetName);
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

	@When("^Add the Execution backlog details for the gadget$")
	public void add_the_Execution_backlog_details_for_the_gadget() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] value=new String[1];
			value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[7]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
			actual[8]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[9]=dp.saveGadget();
			actual[10]=dp.validateSavedGadget(projectName, release);
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

	@When("^Edit the execution backlog and change the refresh interval$")
	public void edit_the_execution_backlog_and_change_the_refresh_interval() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,8);
			actual[11]=dp.gadgetOperation(gadgetValue);
			actual[12]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
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

	@Then("^Should an attempt to save the execution backlog gadget$")
	public void should_an_attempt_to_save_the_execution_backlog_gadget() throws Throwable {
		try
	    {
			actual[13]=dp.saveGadget();
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

	@When("^Add the execution backlog gadget without selecting any interval$")
	public void add_the_execution_backlog_gadget_without_selecting_any_interval() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
			actual[14]=dp.clickOnAddGadgetSymbol();
			actual[15]=dp.addGadget(gadgetName);
			actual[16]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
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
	
	@Then("^Should attempt to save execution backlog gadget without selecting any interval$")
	public void should_attempt_to_save_execution_backlog_gadget_without_selecting_any_interval() throws Throwable {
		try
	    {
			actual[17]=dp.saveGadget();
			pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
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
