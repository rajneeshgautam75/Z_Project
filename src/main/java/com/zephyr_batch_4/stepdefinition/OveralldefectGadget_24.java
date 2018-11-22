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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OveralldefectGadget_24 extends LaunchBrowser 
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
	
   boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
   String fileName="OverallDefectGadget_24";
   

   
   @When("^user Add Dashboard by clicking on add symbol button$")
   public void user_Add_Dashboard_by_clicking_on_add_symbol_button() throws Throwable {
       
	   try
	   {
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   db=new DashBoardPage(driver);
	     String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 4);
		actual[0]=db.clickOnAddDashBoardSymbol();
		actual[1]=db.enterDashBoardDetails(dashName, desc, layout, shareType);
		
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

   @Then("^dashboard should be Added successfully$")
   public void dashboard_should_be_Added_successfully() throws Throwable {
	   try
		 {
		   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 1);
		   actual[2]=db.validateDashBoard(dashName);
		   
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

   @When("^user add Overall Defects gadget to the dashboard$")
   public void user_add_Overall_Defects_gadget_to_the_dashboard() throws Throwable {
	   try
		{
		   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 5);
		   actual[3]=db.selectDashboard(dashName);
		   bp.waitForElement();
		   actual[4]= db.clickOnAddGadgetSymbol();
		   actual[5]=db.addGadget(gadgetName);
		   
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

   @Then("^Overall Defects gadget should be added successfully$")
   public void overall_Defects_gadget_should_be_added_successfully() throws Throwable {
	   try
		  {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 19, 5);
		   actual[6]=db.validateGadget(gadgetName);
		   
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

   @When("^user select project,release and refresh rate ,save it$")
   public void user_select_project_release_and_refresh_rate_save_it() throws Throwable {
	   try
	   {
	      String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",19 , 6);
actual[7]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
	   
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
   
   @Then("^Overall defect gadget should be saved successfully$")
   public void overall_defect_gadget_should_be_saved_successfully() throws Throwable {
	   try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 18, 5);
		  actual[8]= db.validateGadget(gadgetName);
		   
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

   @When("^user edit the gadget and select other project and release, save it$")
   public void user_edit_the_gadget_and_select_other_project_and_release_save_it() throws Throwable {
	   try
		{
		String gadgetOption=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",18 , 12);
		
		 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");;
		 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String refreshRate="";
		 actual[9]=db.gadgetOperation(gadgetOption);
	actual[10]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
	bp.waitForElement();
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

   @Then("^Should reflect defect count for latest saved project release$")
   public void should_reflect_defect_count_for_latest_saved_project_release() throws Throwable {
    try
    {
	   db.linkCountInGadgetPage();
	   
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
