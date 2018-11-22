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

public class Execution_Backlog_34 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_34";
    @Given("^DashBoard page is opened by the User$")
    public void dashboard_page_is_opened_by_the_User() throws Throwable {
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

	@When("^User Creates a new Dash Board and Selects a Created new DashBoard$")
	public void user_Creates_a_new_Dash_Board_and_Selects_a_Created_new_DashBoard() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 2);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   actual[2]=bp.waitForElement();
			   actual[3]=dp.clickOnAddDashBoardSymbol();
			   actual[4]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   actual[5]=dp.selectDashboard(name);
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
	@When("^User will Add multiple two or more Executions Backlog Gadget and will change the Dashboard layouts from one to two and Two to three$")
	public void user_will_Add_multiple_two_or_more_Executions_Backlog_Gadget_and_will_change_the_Dashboard_layouts_from_one_to_two_and_Two_to_three() throws Throwable {
	    
	    	try
			{
	    		String layout_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 4);
	    		String layout_2=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
	    		for(int i=0;i<2;i++)
	    		{
	    		String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 2);
			    String values[]=new String[1];
			    values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
	    		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	    		String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
				String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
				bp.waitForElement();
				actual[6]=dp.clickOnAddGadgetSymbol();
				bp.waitForElement();
				actual[7]=dp.addGadget(gadget);
				bp.waitForElement();
				dp.configureTraceabilityGadget(projectName, release, refreshrate);
				bp.waitForElement();
				dp.filterBy(filterByName, values);
				dp.saveTraceabilityGadget();
	    		}
	    		bp.waitForElement();
	    		actual[8]=dp.layoutSelection(layout_1);
	    		bp.waitForElement();
	    		actual[9]=dp.layoutSelection(layout_2);
	    		
	    		bp.waitForElement();
	    		actual[10]=dp.layoutSelection(layout_1);
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

	@Then("^User should be able to Add multiple Executions Backlog Gadget and Should be able to change the Dashboard layouts$")
	public void user_should_be_able_to_Add_multiple_Executions_Backlog_Gadget_and_Should_be_able_to_change_the_Dashboard_layouts() throws Throwable {
	    try
	    {
	    	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
    		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			bp.waitForElement();
			actual[11]=dp.validateSavedGadget(projectName, release);
			bp.waitForElement();
			pp.backToProjectPage();
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
