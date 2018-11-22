package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_24 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage dp;
	String fileName="Execution_Backlog_Gadget_24";
	
	boolean[] actual=new boolean[13];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As a Lead,launch DashBoard page$")
	public void as_a_Lead_launch_DashBoard_page() throws Throwable {
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

	@When("^Create the dashBoard with available fields$")
	public void create_the_dashBoard_with_available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,39);
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

	@When("^Add Executon backlog gadget with detail$")
	public void add_Executon_backlog_gadget_with_detail() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,39);
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

	@When("^unassign any one user from project after saving gadget$")
	public void unassign_any_one_user_from_project_after_saving_gadget() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] user=new String[2];
			user[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,41);
			user[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1"); 
			bp.waitForElement();
			actual[7]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
			actual[8]=dp.filterBy(filterByName, user);
			actual[9]=dp.saveGadget();
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

	@Then("^Should be able to unassign any one user from project$")
	public void should_be_able_to_unassign_any_one_user_from_project() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] value=new String[1];
			value[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,41);
			actual[10]=dp.gadgetOperation(gadgetValue);
			actual[11]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[12]=dp.saveGadget();
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
