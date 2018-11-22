package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverallDefectGadget_22 extends LaunchBrowser
{
	LaunchBrowser lb;
    ProjectPage pp;
    LoginPage lp;
   ReleasePage rp;
   TestRepositoryPage tr;
   TestPlanningPage tp;
   ExecutionPage exe;
   DashBoardPage db;
   BasePage bp;
	
   boolean[] actual=new boolean[14];
	SoftAssert soft=new SoftAssert();
   String fileName="OverallDefectGadget_22";
   
   @Given("^manager is in project page$")
   public void manager_is_in_project_page() throws Throwable {
     
	   try
	   {
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	   actual[0]=pp.selectProject(projectName);
	   
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

   @When("^user click on manage dashboard$")
   public void user_click_on_manage_dashboard() throws Throwable {
    try
    {
	   db=new DashBoardPage(driver);
actual[1]=db.clickOnManageDashboards();
     
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

   @Then("^dash_board page should be displayed$")
   public void dash_board_page_should_be_displayed() throws Throwable {
    try
    {
    	actual[2]=db.validateDashboards();
	   
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

   @When("^user add dashboard by clicking on add symbol button$")
   public void user_add_dashboard_by_clicking_on_add_symbol_button() throws Throwable {
     
	   try
	   {
	   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 4);
        actual[3]=db.clickOnAddDashBoardSymbol();
		actual[4]=db.enterDashBoardDetails(dashName, desc, layout, shareType);
		
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

   @Then("^dashboard should be added successfully$")
   public void dashboard_should_be_added_successfully() throws Throwable {
	 try
	 {
	   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 1);
	   actual[5]=db.validateDashBoard(dashName);
	   
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

   @When("^user add Overall Defects Gadget to the dashboard$")
   public void user_add_Overall_Defects_Gadget_to_the_dashboard() throws Throwable {
	try
	{
	   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 1);
	   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 5);
	   actual[6]=db.selectDashboard(dashName);
	   
	   actual[7]=db.clickOnAddGadgetSymbol();
	   actual[8]= db.addGadget(gadgetName);
	   
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

   @Then("^Overall defects gadget should be added successfully$")
   public void overall_defects_gadget_should_be_added_successfully() throws Throwable {
	  try
	  {
	   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 5);
	   actual[9]=db.validateGadget(gadgetName);
	   
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

   @When("^user select project,release and refresh rate as One hour,save it$")
   public void user_select_project_release_and_refresh_rate_as_One_hour_save_it() throws Throwable {
    
	   try
	   {
	   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",16 , 6);
		  actual[10]= db.configureTestAutomationStatusGadget(project, release, refreshRate);
	   
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

   @Then("^overall defect gadget should be saved$")
   public void overall_defect_gadget_should_be_saved() throws Throwable {
	 try
	 {
	   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 16, 5);
	   actual[11]= db.validateGadget(gadgetName);
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

   @When("^user edit the refresh rate from one hour to four hour$")
   public void user_edit_the_refresh_rate_from_one_hour_to_four_hour() throws Throwable {
    
	   try
	   {
	   String gadgetOption=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",16 , 12);
	   actual[12]=db.gadgetOperation(gadgetOption);
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

   @Then("^should be able to change the refresh rate$")
   public void should_be_able_to_change_the_refresh_rate() throws Throwable {
     
	   try
	   {
	   String project="";
		  String release="";
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",17 , 6);
		 actual[13]= db.configureTestAutomationStatusGadget(project, release, refreshRate);
		 
		 
		 pp.backToProjectPage();
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
	            lb.getScreenShot(fileName);
				   e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				
			}
   


   }
}
