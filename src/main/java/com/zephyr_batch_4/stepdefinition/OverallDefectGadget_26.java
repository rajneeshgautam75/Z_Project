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

public class OverallDefectGadget_26 extends LaunchBrowser {

	

	LaunchBrowser lb;
    ProjectPage pp;
    LoginPage lp;
   ReleasePage rp;
   TestRepositoryPage tr;
   TestPlanningPage tp;
   ExecutionPage exe;
   DashBoardPage db;
   BasePage bp;
   int gadgetCount1;
	
   
   boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
   String fileName="OverallDefectGadget_26";
   
	@When("^user add dashboard by clicking on add symbol$")
	public void user_add_dashboard_by_clicking_on_add_symbol() throws Throwable {
		try
		   {
			pp=new ProjectPage(driver);
			   db=new DashBoardPage(driver);
		     String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 1);
			String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 3);
			String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 4);
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

	@Then("^dashboard should be added Successfully$")
	public void dashboard_should_be_added_Successfully() throws Throwable {
		  try
			 {
			   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 1);
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

	@When("^user add Overall Defects Gadget by clicking on add symbol button$")
	public void user_add_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
		 try
			{
			   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 1);
			   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 5);
			   actual[3]=db.selectDashboard(dashName);
			   
			   actual[4]=db.clickOnAddGadgetSymbol();
			   actual[5]= db.addGadget(gadgetName);
			   
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

	@Then("^overall defect Gadget added successfully$")
	public void overall_defect_Gadget_added_successfully() throws Throwable {
		  try
		  {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 5);
		   actual[6]= db.validateGadget(gadgetName);
		   
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

	@When("^user select project,release and refresh rate , save it$")
	public void user_select_project_release_and_refresh_rate_save_it() throws Throwable {
		  try
		   {
		      String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",20 , 6);
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

	
	
	
	@Then("^should be able to Save Overall Defect Gadget$")
	public void should_be_able_to_Save_Overall_Defect_Gadget() throws Throwable {
		 try
			{
			  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 5);
			actual[8]=db.validateSavedGadget(projectName, releaseName);
			gadgetCount1=db.totalGadgetCount(gadgetName);
			   
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


	@When("^user delete the saved Overall Defect Gadget$")
	public void user_delete_the_saved_Overall_Defect_Gadget() throws Throwable {
		   try
			{
			String gadgetOption=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",20 , 12);
			actual[9]= db.gadgetOperation(gadgetOption);
//			 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");;
//			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_2");
//			 String refreshRate="";
//			 actual[10]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^should be able to delete the gadget$")
	public void should_be_able_to_delete_the_gadget() throws Throwable {
		try
		{
			bp=new BasePage();
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 20, 5);
		int gadgetCount2=db.totalGadgetCount(gadgetName);
		bp.waitForElement();
		
		if(gadgetCount2==gadgetCount1-1)
		{
			log.info("Gadget Successfully deleted");
		}
		
		
		pp.backToProjectPage();

		  for(int k=0;k<=actual.length-1;k++)
			{
				//System.out.println("Actual["+k+"]="+actual[k]);
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
