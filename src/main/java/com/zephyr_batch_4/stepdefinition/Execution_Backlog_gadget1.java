package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Execution_Backlog_gadget1 extends LaunchBrowser{
	  ProjectPage pp;
	  DashBoardPage db;
	  BasePage bp;
	  LaunchBrowser lb;
	  boolean[] actual=new boolean[18];
	  SoftAssert soft=new SoftAssert();
	  String fileName="Execution_Backlog_gadget1";
	 
	  @Given("^User Is In DashBoard Page$")
	  public void user_Is_In_DashBoard_Page() throws Throwable {
		  try{
	    	db=new DashBoardPage(driver);
	        bp=new BasePage();
	    	actual[0]=db.clickOnManageDashboards();	
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

	  @When("^User Add Empty Dashboard by Clicking on Plus Button$")
	  public void user_Add_Empty_Dashboard_by_Clicking_on_Plus_Button() throws Throwable {
		  try
         {
        String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",2, 0);
        String desc = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",2, 1);
        String layout = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard", 2, 2);
        String shareType = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",2,3);
        bp.waitForElement();
        actual[1]=db.clickOnAddDashBoardSymbol();
       actual[2]=db.enterDashBoardDetails(name, desc, layout, shareType);
	  actual[3]=db.selectDashboard(name);         
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

	  @Then("^Should be Able to Add New Dashboard$")
	  public void should_be_Able_to_Add_New_Dashboard() throws Throwable {
		  try
        {
        String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",2, 0);
        actual[4]=db.validateDashBoard(name);
        }
    catch(Exception e)
        {
   	 lb=new LaunchBrowser();
   	 lb.getScreenShot(fileName);
   	 e.printStackTrace();
   	 Relogin_TPE rl=new Relogin_TPE();
   	 rl.reLogin();
   	 throw e;
        }
	}

	  @When("^Click on Add Gadget Button and Add the Execution Backlog Gadget$")
	  public void click_on_Add_Gadget_Button_and_Add_the_Execution_Backlog_Gadget() throws Throwable {
		  try
          {
		 String gadgetName = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",2,4);
			 bp.waitForElement();
			 db.addNewGadget.click();
			 bp.waitForElement();
			 actual[5]=db.addGadget(gadgetName);
		     }
		 catch(Exception e)
		     {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;
	     }
	  }

	  @Then("^Execution backlog Gadget should be Added Successfully$")
	  public void execution_backlog_Gadget_should_be_Added_Successfully() throws Throwable {
		  try
		    {
			 String gadgetname=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",2,4);
			 actual[6]=db.validateGadget(gadgetname); 
		    }
		catch(Exception e)
		    {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		    }
		}
	  

	  @When("^Select Project and Release and Filter by and Refresh Rate Click on Save button$")
	  public void select_Project_and_Release_and_Filter_by_and_Refresh_Rate_Click_on_Save_button() throws Throwable {
		  try
		   {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",0,5);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
	       bp.waitForElement();
		   actual[7]=db.configureTraceabilityGadget(projectName,release, refreshRate);
	       String[] values=new String[1];
	       values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
	       actual[8]=db.filterBy(filterByName, values);
	       bp.waitForElement();
	       actual[9]=db.saveGadget();
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


	  @Then("^Execution backlog gadget should be saved Successfully$")
	  public void execution_backlog_gadget_should_be_saved_Successfully() throws Throwable {
		  try
		   {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[10]=db.validateSavedGadget(projectName);
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

	  @When("^Click on plus Button and add the Execution Backlog gadget$")
	  public void click_on_plus_Button_and_add_the_Execution_Backlog_gadget() throws Throwable {
		  try
		    {
		    //String name =UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "NewDashboard", 2,0);
		    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",2,4); 
			//actual[11]=db.selectDashboard(name);
		    //bp.waitForElement();
		    actual[11]=db.clickOnAddGadgetSymbol();
		    bp.waitForElement();
		    actual[12]=db.addGadget(gadgetname);
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

	 

	  @Then("^should be able to add Execution Backlog gadget successfully$")
	  public void should_be_able_to_add_Execution_Backlog_gadget_successfully() throws Throwable {
		   try
	       {
	       String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",2,4);
	       actual[13]=db.validateGadget(gadgetname);
	       }
	    catch(Exception e)
	       {
	       lb=new LaunchBrowser();
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e;
	       }
	}

	  @When("^Configure the Gadget with required data and click on save Button$")
	  public void configure_the_Gadget_with_required_data_and_click_on_save_Button() throws Throwable {
		  try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",0,5);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
    	   bp.waitForElement();
		   actual[14]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   actual[15]=db.filterBy(filterByName, values);
		   bp.waitForElement();
		   actual[16]=db.saveGadget();
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
	  

	  @Then("^Should be able to Save Execution Backlog Gadget successfully$")
	  public void should_be_able_to_Save_Execution_Backlog_Gadget_successfully() throws Throwable {
		  try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",2,4);
		   actual[17]=db.validateGadget(gadgetname);
		   
		   pp=new ProjectPage(driver);
		   pp.backToProjectPage();
		   for(int k=0;k<=actual.length-1;k++)
	       {
		   System.out.println("Actual["+k+"]="+actual[k]);
		   soft.assertEquals(actual[k], true);
	       }
		   }
	   catch(Exception e)
		   {
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		   }
	  }
	  }


