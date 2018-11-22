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

public class Execution_Backlog_37 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_37";
	@Given("^DashBoard Window is opened by User$")
	public void dashboard_Window_is_opened_by_User() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
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

	@When("^Creates New DashBoard with Mandatory fields and selects$")
	public void creates_New_DashBoard_with_Mandatory_fields_and_selects() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 48, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   bp.waitForElement();
			   actual[2]=dp.clickOnAddDashBoardSymbol();
			   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   actual[4]=dp.selectDashboard(name);
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

	@When("^user Adds multiple one or three or seven Executions Backlog Gadget with same project or user but different refresh intervals$")
	public void user_Adds_multiple_one_or_three_or_seven_Executions_Backlog_Gadget_with_same_project_or_user_but_different_refresh_intervals() throws Throwable {
		try
		{
			for(int i=0;i<6;i++)
			{
			String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 2);
	    	String values[]=new String[1];
	    	values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
	    	String projectName_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    	String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	    	String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1+i, 7);
			bp.waitForElement();
			actual[5]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[6]=dp.addGadget(gadget);
			bp.waitForElement();
			actual[7]=dp.configureTraceabilityGadget(projectName_1, release_1, refreshrate);
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=dp.filterBy(filterByName, values);
			bp.waitForElement();
			dp.saveTraceabilityGadget();
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

	@Then("^Should be able to add one or three Executions Backlog Gadget with same project but different refresh intervals$")
	public void should_be_able_to_add_one_or_three_Executions_Backlog_Gadget_with_same_project_but_different_refresh_intervals() throws Throwable {
	   try
	   {
		   String projectName_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	       String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   actual[9]=dp.validateSavedGadget(projectName_1, release_1);
		   bp.waitForElement();
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
