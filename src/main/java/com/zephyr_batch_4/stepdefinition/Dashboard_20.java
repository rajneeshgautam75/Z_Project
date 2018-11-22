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

public class Dashboard_20 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage db;
	String fileName="Dashboard_20";
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in the project page and launch the dashboard$")
	public void user_in_the_project_page_and_launch_the_dashboard() throws Throwable 
	{
		  try
		   {
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   db=new DashBoardPage(driver);
			  db.clickOnManageDashboards();
				
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

	@When("^create a dashboard$")
	public void create_a_dashboard() throws Throwable 
	{
		try
		   {
				db=new DashBoardPage(driver);
				bp=new BasePage();
				actual[3]=db.clickOnAddDashBoardSymbol();
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3,0);
				String desc=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3,1);
				String layout=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,2);
				String shareType=Excel_Lib.getData(INPUT_PATH_4, "Dashboard",1,3);
				actual[4]=db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
				actual[5]=db.validateDashBoard(dashboardName);
				
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

	@When("^select a created dashboard and add test automation status gadjet$")
	public void select_a_created_dashboard_and_add_test_automation_status_gadjet() throws Throwable 
	{
		try
		   {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3,0);
			actual[6]=db.selectDashboard(dashboardName);
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5); 
			 actual[9]=db.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@When("^change the layout from one to two and two to one$")
	public void change_the_layout_from_one_to_two_and_two_to_one() throws Throwable 
	{
		try
		{
			String layout1=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,2);
		   db.layoutSelection(layout1);
		   String layout2=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,2);
		   db.layoutSelection(layout2);
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

	@Then("^add test automation gadjet and change the layout without saving the gadjet$")
	public void add_test_automation_gadjet_and_change_the_layout_without_saving_the_gadjet() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			 String layout1=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,2);
			   db.layoutSelection(layout1);
			   
			   
			   pp.backToProjectPage();
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
