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

public class Execution_Backlog_32  extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	String filename="Execution_Backlog_32";
	
	@Given("^User is in the DashBoard Page with selected Project$")
	public void user_is_in_the_DashBoard_Page_with_selected_Project() throws Throwable {
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


	@When("^User will create new dashboard by clicking on the add dashBoard button$")
	public void user_will_create_new_dashboard_by_clicking_on_the_add_dashBoard_button() throws Throwable {
		try {
			bp.waitForElement();
	    	 actual[2]=dp.clickOnAddDashBoardSymbol();	    	
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

	@When("^User adds the DashBoard with all necessary Details$")
	public void user_adds_the_DashBoard_with_all_necessary_Details() throws Throwable {
		try {
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 5, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
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

	@When("^User will clicks on plus button and add Executions Backlog Gadget$")
	public void user_will_clicks_on_plus_button_and_add_Executions_Backlog_Gadget() throws Throwable {
		try 
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5); 
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 1, 0);
			String filterByName=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values=new String[1];
			values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			bp.waitForElement();
			actual[6]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[7]=dp.addGadget(gadgetName);
			bp.waitForElement();
			actual[8]=dp.configureTraceabilityGadget(project,release,refreshRate);
			bp.waitForElement();
			actual[9]=dp.filterBy(filterByName, values);  
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

	@When("^User will change the dashboard layout without saving$")
	public void user_will_change_the_dashboard_layout_without_saving() throws Throwable {
		try 
		{
			String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 4);
			bp.waitForElement();
			actual[10]=dp.layoutSelection(layout);
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

	@Then("^Should be able to Change the dashboard layout with unsaved Executions Backlog Gadget$")
	public void should_be_able_to_Change_the_dashboard_layout_with_unsaved_Executions_Backlog_Gadget() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
			   bp.waitForElement();
			   actual[11]=dp.validateGadget(gadgetName);
			   actual[12]=pp.backToProjectPage();
			  
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
