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

public class OverallDefectGadget_28 extends LaunchBrowser {
	
	LaunchBrowser lb;
    ProjectPage pp;
    LoginPage lp;
   ReleasePage rp;
   TestRepositoryPage tr;
   TestPlanningPage tp;
   ExecutionPage exe;
   DashBoardPage db;
   BasePage bp;
	
   boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
   String fileName="OverallDefectGadget_28";
   
	@When("^user add Dashboard by clicking on add symbol$")
	public void user_add_Dashboard_by_clicking_on_add_symbol() throws Throwable {
		   try
		   {
			   pp=new ProjectPage(driver);
			   db=new DashBoardPage(driver);
		   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
			String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 3);
			String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 4);
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

	@Then("^Dashboard should be added Successfully$")
	public void dashboard_should_be_added_Successfully() throws Throwable {
		 try
		 {
		   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
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

	@When("^user add first Overall Defects Gadget by clicking on add symbol button$")
	public void user_add_first_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
	   
		try
		{
		   String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[3]=db.selectDashboard(dashName);
		   
		   actual[4]=db.clickOnAddGadgetSymbol();
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

	@Then("^first overall defect Gadget added successfully$")
	public void first_overall_defect_Gadget_added_successfully() throws Throwable {
		 try
		  {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
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

	@When("^User select project,release and refresh rate , save it$")
	public void user_select_project_release_and_refresh_rate_save_it() throws Throwable {
		try
		   {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",21 , 6);
			  actual[7]= db.configureTestAutomationStatusGadget(project, release, refreshRate);
		   
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

	@Then("^should be able to save first Overall Defect Gadget$")
	public void should_be_able_to_save_first_Overall_Defect_Gadget() throws Throwable {
		 try
		 {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  // String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[8]=db.validateSavedGadget(projectName, releaseName);
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

	@When("^user add second Overall Defects Gadget by clicking on add symbol button$")
	public void user_add_second_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
		try
		{
		   //String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   //actual[6]=db.selectDashboard(dashName);
		   
		   actual[9]=db.clickOnAddGadgetSymbol();
		   actual[10]=db.addGadget(gadgetName);
		   
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

	@Then("^second overall defect Gadget added successfully$")
	public void second_overall_defect_Gadget_added_successfully() throws Throwable {
		 try
		  {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[11]=db.validateGadget(gadgetName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@Then("^should be able to save second Overall defect Gadget$")
	public void should_be_able_to_save_second_Overall_defect_Gadget() throws Throwable {
		 try
		  {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		   //String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[12]=db.validateSavedGadget(projectName, releaseName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@When("^user add third Overall Defects Gadget by clicking on add symbol button$")
	public void user_add_third_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
		try
		{
		   //String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   //actual[6]=db.selectDashboard(dashName);
		   
		   actual[13]=db.clickOnAddGadgetSymbol();
		   actual[14]=db.addGadget(gadgetName);
		   
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

	@Then("^third overall defect Gadget added successfully$")
	public void third_overall_defect_Gadget_added_successfully() throws Throwable {
		 try
		  {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[15]=db.validateGadget(gadgetName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@Then("^should be able to save third Overall defect Gadget$")
	public void should_be_able_to_save_third_Overall_defect_Gadget() throws Throwable {
		 try
		  {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		   //String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[16]=db.validateSavedGadget(projectName, releaseName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@When("^user add fourth Overall Defects Gadget by clicking on add symbol button$")
	public void user_add_fourth_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
		try
		{
			
		  // String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   //actual[6]=db.selectDashboard(dashName);
		   
		   actual[17]=db.clickOnAddGadgetSymbol();
		   actual[18]=db.addGadget(gadgetName);
		   
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

	@Then("^fourth overall defect Gadget added successfully$")
	public void fourth_overall_defect_Gadget_added_successfully() throws Throwable {
		 try
		  {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[19]=db.validateGadget(gadgetName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@Then("^should be able to save fourth Overall defect Gadget$")
	public void should_be_able_to_save_fourth_Overall_defect_Gadget() throws Throwable {
		 try
		  {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  // String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[20]=db.validateSavedGadget(projectName, releaseName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@When("^user add fifth Overall Defects Gadget by clicking on add symbol button$")
	public void user_add_fifth_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
		try
		{
		  // String dashName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   //actual[6]=db.selectDashboard(dashName);
		   
		   actual[21]=db.clickOnAddGadgetSymbol();
		   actual[22]=db.addGadget(gadgetName);
		   
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

	@Then("^fifth overall defect Gadget added successfully$")
	public void fifth_overall_defect_Gadget_added_successfully() throws Throwable {
		 try
		  {
			 
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
		   actual[23]=db.validateGadget(gadgetName);
		   
		   //db.totalGadgetCount(gadgetName)
		   
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

	@Then("^should be able to save fifth Overall defect Gadget$")
	public void should_be_able_to_save_fifth_Overall_defect_Gadget() throws Throwable {
		 try
		  {
		   
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 21, 5);
			  
		   actual[24]=db.validateSavedGadget(projectName, releaseName);
		   
		    int totalGadgetCount=db.totalGadgetCount(gadgetName);
		    if(totalGadgetCount==5)
		    {
		    	log.info("Successfully five Overall defect Gadget Saved");
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
