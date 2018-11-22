package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_31 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[15];
	SoftAssert soft=new SoftAssert();
	String filename="Execution_Backlog_31";

	@Given("^User in the Dashboard page of the Related project$")
	public void user_in_the_Dashboard_page_of_the_Related_project() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			dp=new DashBoardPage(driver);
			bp=new BasePage();
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			bp.waitForElement();
			actual[1]=dp.clickOnManageDashboards();
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User clicks on the add dahboard button to add a new dashboard$")
	public void user_clicks_on_the_add_dahboard_button_to_add_a_new_dashboard() throws Throwable {
		try {
			
	    	 actual[2]=dp.clickOnAddDashBoardSymbol();
	    	 bp.waitForElement();
	    	
	    }
	    catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User will select layout dashboard as two cloumn and fill other details to add a new dashboard$")
	public void user_will_select_layout_dashboard_as_two_cloumn_and_fill_other_details_to_add_a_new_dashboard() throws Throwable {
		try {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 4, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
	    	 bp.waitForElement();
	    	 actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
	    	 bp.waitForElement();
	    	 actual[4]=dp.validateDashBoard(name);
	    	 bp.waitForElement();
	    	 actual[5]=dp.selectDashboard(name);
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User clicks on the add gadget button to add a new gadget$")
	public void user_clicks_on_the_add_gadget_button_to_add_a_new_gadget() throws Throwable {
		try {
			bp.waitForElement();
			actual[6]=dp.clickOnAddGadgetSymbol();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User adds Executions Backlog gadget$")
	public void user_adds_Executions_Backlog_gadget() throws Throwable {
		try {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5); 
			bp.waitForElement();
			actual[7]=dp.addGadget(gadgetName);
			 actual[8]=dp.validateGadget(gadgetName);
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User fills the details to save the Executions Backlog gadget$")
	public void user_fills_the_details_to_save_the_Executions_Backlog_gadget() throws Throwable {
		try {
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 1, 0);
			String filterByName=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values=new String[1];
			values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			bp.waitForElement();
			actual[9]=dp.configureTraceabilityGadget(project,release,refreshRate);
			bp.waitForElement();
			actual[10]=dp.filterBy(filterByName, values);
			bp.waitForElement();
			actual[11]=dp.saveTraceabilityGadget();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User clicks on the one column layout to change the dashboard$")
	public void user_clicks_on_the_one_column_layout_to_change_the_dashboard() throws Throwable {
		try 
		{
			String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
			bp.waitForElement();
			actual[12]=dp.layoutSelection(layout);
			bp.waitForElement();
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 
		}
	  
	}

	@Then("^Should be able to Change the dashboard layout from two to one after saving a Executions Backlog Gadget$")
	public void should_be_able_to_Change_the_dashboard_layout_from_two_to_one_after_saving_a_Executions_Backlog_Gadget() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			   bp.waitForElement();  
			   actual[13]=dp.validateSavedGadget(project, release);
			   actual[14]=pp.backToProjectPage();
			  
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
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}	 
			
	  
	}

	
	
}
