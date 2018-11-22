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

public class ReqTraceability_1 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[22];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_1";
	
	@Given("^user is in a dashboardpage$")
	public void user_is_in_a_dashboardpage() throws Throwable {
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

	@When("^user creates a new dashboard$")
	public void user_creates_a_new_dashboard() throws Throwable {
		 try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
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

	@Then("^new dashboard should be created$")
	public void new_dashboard_should_be_created() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 1);
			actual[4]=dp.validateDashBoard(name);
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

	@When("^user selects added dashboard and adds Traceability Report Gadget by clicking plus button$")
	public void user_selects_added_dashboard_and_adds_Traceability_Report_Gadget_by_clicking_plus_button() throws Throwable {
		
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 1);
		    String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[5]=dp.selectDashboard(name);
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

	@Then("^user to be able to add gadget$")
	public void user_to_be_able_to_add_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
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

	@When("^user adds Traceability Report Gadget in other Dashboard by clicking on addition symbol$")
	public void user_adds_Traceability_Report_Gadget_in_other_Dashboard_by_clicking_on_addition_symbol() throws Throwable {
		try
		{
			  
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 13, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			   actual[9]=dp.clickOnManageDashboards();
			   bp.waitForElement();
			   actual[10]=dp.clickOnAddDashBoardSymbol();
			   actual[11]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   bp.waitForElement();
			   actual[12]=dp.selectDashboard(name);
			   actual[13]=dp.clickOnAddGadgetSymbol();
			   bp.waitForElement();
			   actual[14]=dp.addGadget(gadget);
			
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

	@Then("^user should be able to add traceability report gadget$")
	public void user_should_be_able_to_add_traceability_report_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[15]=dp.validateGadget(gadget);
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

	@When("^user adds Traceability Report Gadget for Normal Project$")
	public void user_adds_Traceability_Report_Gadget_for_Normal_Project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			actual[16]=dp.configureTraceabilityGadget(project, release, refreshRate);
			
			
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

	@Then("^should be able to add for Normal Project$")
	public void should_be_able_to_add_for_Normal_Project() throws Throwable {
		try
		{
			 String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			 actual[17]=dp.validateGadget(gadget);
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

	@When("^user adds Traceability Report Gadget for Isolated Project$")
	public void user_adds_Traceability_Report_Gadget_for_Isolated_Project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Isolated_Project_2");
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			actual[18]=dp.configureTraceabilityGadget(project, release, refreshRate);
			
			
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

	@Then("^Should be able to add for isolated project$")
	public void should_be_able_to_add_for_isolated_project() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[19]=dp.validateGadget(gadget);
			
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

	@When("^user adds traceability report gadget for Restricted Project$")
	public void user_adds_traceability_report_gadget_for_Restricted_Project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Restricted_Project_1");
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			actual[20]=dp.configureTraceabilityGadget(project, release, refreshRate);
			
			
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

	@Then("^To be able to add for Restricted Project$")
	public void to_be_able_to_add_for_Restricted_Project() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[21]=dp.validateGadget(gadget);
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
