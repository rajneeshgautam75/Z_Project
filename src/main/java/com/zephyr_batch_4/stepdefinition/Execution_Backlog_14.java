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

public class Execution_Backlog_14 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_14";
	@Given("^Tester,Manager or Lead is In a DashBoard$")
	public void tester_Manager_or_Lead_is_In_a_DashBoard() throws Throwable {
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

	@When("^Tester or Lead Adds Executions Backlog Gadget in empty Dashboard by clicking on plus ICON$")
	public void tester_or_Lead_Adds_Executions_Backlog_Gadget_in_empty_Dashboard_by_clicking_on_plus_ICON() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 46, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
		   bp.waitForElement();
		   actual[2]=dp.clickOnAddDashBoardSymbol();
		   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^Executions Backlog Gadget should be added by Tester or Lead$")
	public void executions_Backlog_Gadget_should_be_added_by_Tester_or_Lead() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			bp.waitForElement();
			dp.validateGadget(gadget);
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

	@When("^Lead or Tester Attempts to select multiple projects or releases in Executions Backlog Gadget$")
	public void lead_or_Tester_Attempts_to_select_multiple_projects_or_releases_in_Executions_Backlog_Gadget() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			bp.waitForElement();
			actual[7]=dp.checkProject(projectName);
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=dp.checkProject(project);
			
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

	@Then("^Lead or Tester,Should not be able to select multiple projects or releases in Executions Backlog Gadget$")
	public void lead_or_Tester_Should_not_be_able_to_select_multiple_projects_or_releases_in_Executions_Backlog_Gadget() throws Throwable {
	   
	   try
	   {
		   bp.waitForElement();
		   dp.selectProject.click();
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
