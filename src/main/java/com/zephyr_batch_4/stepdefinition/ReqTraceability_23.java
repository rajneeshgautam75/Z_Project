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
import com.zephyr.reusablemethods.RequirementsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_23 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	RequirementsPage req;
	boolean[] actual=new boolean[19];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_23";
	@Given("^user is in a dashboard page and adds new dashboard$")
	public void user_is_in_a_dashboard_page_and_adds_new_dashboard() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 18, 1);
	    String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
		bp.waitForElement();
	    actual[2]=dp.clickOnAddDashBoardSymbol();
	    actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@When("^user selects added Daashboard and adds traceability report gadget by clicking addition symbol$")
	public void user_selects_added_Daashboard_and_adds_traceability_report_gadget_by_clicking_addition_symbol() throws Throwable {
	    try
	    {
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 18, 1);
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[4]=dp.selectDashboard(name);
			bp.waitForElement();
			actual[5]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[6]=dp.addGadget(gadget);
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

	@Then("^Traceability Report Gadget should be added by user$")
	public void traceability_Report_Gadget_should_be_added_by_user() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[7]=dp.validateGadget(gadget);
			
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

	@When("^user Edits Traceability Report Gadget and change the refresh interval from one hour to four hour$")
	public void user_Edits_Traceability_Report_Gadget_and_change_the_refresh_interval_from_one_hour_to_four_hour() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 7);
			actual[8]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
			actual[9]=dp.configureTraceabilityGadget(projectName, release, refreshrate_1);
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

	@Then("^Should be able to change the time interval successfully$")
	public void should_be_able_to_change_the_time_interval_successfully() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 7);
			bp.waitForElement();
			actual[10]=dp.configureTraceabilityGadget(projectName, release, refreshrate_1);
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

	@When("^user edits Traceability Report Gadget and change the refresh interval from four hour to eight hour$")
	public void user_edits_Traceability_Report_Gadget_and_change_the_refresh_interval_from_four_hour_to_eight_hour() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 7);
			String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 7);
			actual[11]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
			actual[12]=dp.configureTraceabilityGadget(projectName, release, refreshrate_1);
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

	@Then("^To be able to change time interval  successfully$")
	public void to_be_able_to_change_time_interval_successfully() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 7);
		bp.waitForElement();
		actual[13]=dp.configureTraceabilityGadget(projectName, release, refreshrate_1);
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

	@When("^user edits Traceability Report Gadget and change the refresh interval from eight hour to one day$")
	public void user_edits_Traceability_Report_Gadget_and_change_the_refresh_interval_from_eight_hour_to_one_day() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 7);
			String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 7);
			actual[14]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
			actual[15]=dp.configureTraceabilityGadget(projectName, release, refreshrate_1);
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

	@Then("^Should Able to change time interval successfully$")
	public void should_Able_to_change_time_interval_successfully() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 7);
			actual[16]=dp.configureTraceabilityGadget(projectName, release, refreshrate_1);
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

	@When("^user Edits Traceability Report Gadget refresh interval and attempt to save without selecting any interval$")
	public void user_Edits_Traceability_Report_Gadget_refresh_interval_and_attempt_to_save_without_selecting_any_interval() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		bp.waitForElement();
		actual[17]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
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

	@Then("^Should not be allowed to save without time interval$")
	public void should_not_be_allowed_to_save_without_time_interval() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[18]=dp.validateGadget(gadget);
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
