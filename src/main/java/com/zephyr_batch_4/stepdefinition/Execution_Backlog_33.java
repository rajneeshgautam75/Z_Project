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

public class Execution_Backlog_33 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_33";
	@Given("^Test Lead Or Tester is in a DashBoard Window$")
	public void test_Lead_Or_Tester_is_in_a_DashBoard_Window() throws Throwable {
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

	@When("^Lead or Tester adds New Dashboard and selects It$")
	public void lead_or_Tester_adds_New_Dashboard_and_selects_It() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 2);
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

	@When("^execution backlog gadget should be added by lead or tester$")
	public void execution_backlog_gadget_should_be_added_by_lead_or_tester() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			bp.waitForElement();
			actual[6]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[7]=dp.addGadget(gadget);
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

	@Then("^execution backlog gadget should be added successfully$")
	public void execution_backlog_gadget_should_be_added_successfully() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			bp.waitForElement();
			actual[8]=dp.validateGadget(gadget);
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

	@When("^Lead adds another execution backlog gadget without saving existing gadget$")
	public void lead_adds_another_execution_backlog_gadget_without_saving_existing_gadget() throws Throwable {
		try
		{
			String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 2);
		    String values[]=new String[1];
		    values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
    		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
    		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
    		String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[10]=dp.addGadget(gadget);
			bp.waitForElement();
			dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
		    dp.filterBy(filterByName, values);
			bp.waitForElement();
			dp.saveTraceabilityGadget();
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

	@Then("^Should be able to Add another Executions Backlog Gadget without saving the existing Executions Backlog Gadget$")
	public void should_be_able_to_Add_another_Executions_Backlog_Gadget_without_saving_the_existing_Executions_Backlog_Gadget() throws Throwable {
	 
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
