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
import com.zephyr.reusablemethods.TestRepositoryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_3 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	boolean[] actual=new boolean[20];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_3";
	@Given("^user is in a Dash Board Page$")
	public void user_is_in_a_Dash_Board_Page() throws Throwable {
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

	@When("^user creates a new Dash Board and selects the new Dash board$")
	public void user_creates_a_new_Dash_Board_and_selects_the_new_Dash_board() throws Throwable {
		 try
		   {
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 25, 1);
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

	@When("^user adds Traceability report gadget by clicking add symbol$")
	public void user_adds_Traceability_report_gadget_by_clicking_add_symbol() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
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

	@Then("^To be able to Add traceability Report Gadget$")
	public void to_be_able_to_Add_traceability_Report_Gadget() throws Throwable {
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

	@When("^user selects a project out of hundred or five hundred projects$")
	public void user_selects_a_project_out_of_hundred_or_five_hundred_projects() throws Throwable {
		try
		{
			String project_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String project_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String project_3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Isolated_Project_2");
			String project_4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Restricted_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[8]=dp.configureTraceabilityGadget(project_1, release, refreshRate);
			bp.waitForElement();
			actual[9]=dp.configureTraceabilityGadget(project_2, release, refreshRate);
			bp.waitForElement();
			actual[10]=dp.configureTraceabilityGadget(project_3, release, refreshRate);
			bp.waitForElement();
			actual[11]=dp.configureTraceabilityGadget(project_4, release, refreshRate);
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

	@When("^user selects release out of fifty or hundred releases$")
	public void user_selects_release_out_of_fifty_or_hundred_releases() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String release_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String release_3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_3");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[12]=dp.configureTraceabilityGadget(project, release_1, refreshRate);
			bp.waitForElement();
			actual[13]=dp.configureTraceabilityGadget(project, release_2, refreshRate);
			bp.waitForElement();
			actual[14]=dp.configureTraceabilityGadget(project, release_3, refreshRate);
			bp.waitForElement();
			actual[15]=dp.configureTraceabilityGadget(project, release_3, refreshRate);
			
		
			
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

	@When("^user selects a project which are in special characters$")
	public void user_selects_a_project_which_are_in_special_characters() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5");
			String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[16]=dp.configureTraceabilityGadget(project, release_1, refreshRate);
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

	@When("^user selects release which are in special characters$")
	public void user_selects_release_which_are_in_special_characters() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[17]=dp.configureTraceabilityGadget(project, release_1, refreshRate);
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

	@When("^user selects project which are in internaltional characters$")
	public void user_selects_project_which_are_in_internaltional_characters() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[18]=dp.configureTraceabilityGadget(project, release_1, refreshRate);
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

	@When("^user selects release which are in internaltional characters$")
	public void user_selects_release_which_are_in_internaltional_characters() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[19]=dp.configureTraceabilityGadget(project, release_1, refreshRate);
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
