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

public class Execution_Backlog_gadget2 extends LaunchBrowser {
	  ProjectPage pp;
	  DashBoardPage db;
	  BasePage bp;
	  LaunchBrowser lb;
	  boolean[] actual=new boolean[26];
	  SoftAssert soft=new SoftAssert();
	  String fileName="Execution_Backlog_gadget2";

	@Given("^User currently in Dashboard page$")
	public void user_currently_in_Dashboard_page() throws Throwable {
		try
    	{ 
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
	@When("^User add a dashboard by clicking on plus button$")
	public void user_add_a_dashboard_by_clicking_on_plus_button() throws Throwable {
		try
        {
        String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",3, 0);
        String desc = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",3, 1);
        String layout = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard", 3, 2);
        String shareType = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",3,3);
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

	@Then("^Should be Able to Add a Dashboard$")
	public void should_be_Able_to_Add_a_Dashboard() throws Throwable {
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
	@When("^Click on Plus Button and add Execution backlog gadget$")
	public void click_on_Plus_Button_and_add_Execution_backlog_gadget() throws Throwable {
		try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",3,4); 
	    actual[5]=db.clickOnAddGadgetSymbol();
	    bp.waitForElement();
	    actual[6]=db.addGadget(gadgetname);
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
	@Then("^Should be able to add the Execution backlog gadget$")
	public void should_be_able_to_add_the_Execution_backlog_gadget() throws Throwable {
		try
	       {
	       String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",3,4);
	       actual[7]=db.validateGadget(gadgetname);
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
	@When("^Select Normal project and Release and FilterBy and Refresh rate and click on save button$")
	public void select_Normal_project_and_Release_and_FilterBy_and_Refresh_rate_and_click_on_save_button() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",0,5);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
		   bp.waitForElement();
		   actual[8]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   actual[9]=db.filterBy(filterByName, values);
		   bp.waitForElement();
		   actual[10]=db.saveGadget();
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

	@Then("^Should be able to add Execution backlog gadget for Normal project$")
	public void should_be_able_to_add_Execution_backlog_gadget_for_Normal_project() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",3,4);
		   actual[11]=db.validateGadget(gadgetname);
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
	@When("^click on Plus Button to add Execution backlog Gadget$")
	public void click_on_Plus_Button_to_add_Execution_backlog_Gadget() throws Throwable {
		try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",3,4); 
	    actual[12]=db.clickOnAddGadgetSymbol();
	    bp.waitForElement();
	    actual[13]=db.addGadget(gadgetname);
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
	@Then("^should be able to Add Execution backlog Gadget$")
	public void should_be_able_to_Add_Execution_backlog_Gadget() throws Throwable {
		try
	       {
	       String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",3,4);
	       actual[14]=db.validateGadget(gadgetname);
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
	@When("^Select Isolated project and Release and FilterBy and Refresh rate and click on save button$")
	public void select_Isolated_project_and_Release_and_FilterBy_and_Refresh_rate_and_click_on_save_button() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",0,5);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Isolated_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
		   bp.waitForElement();
		   actual[15]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   actual[16]=db.filterBy(filterByName, values);
		   bp.waitForElement();
		   actual[17]=db.saveGadget();
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
	@Then("^Should be able to Add Execution Backlog Gadget for Isolated project$")
	public void should_be_able_to_Add_Execution_Backlog_Gadget_for_Isolated_project() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",3,4);
		   actual[18]=db.validateGadget(gadgetname);
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

	@When("^Click on Plus Button And Add Execution Backlog Gadget$")
	public void click_on_Plus_Button_And_Add_Execution_Backlog_Gadget() throws Throwable {
		try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",3,4); 
	    actual[19]=db.clickOnAddGadgetSymbol();
	    bp.waitForElement();
	    actual[20]=db.addGadget(gadgetname);
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
	
	@Then("^Should be Able to Add Execution Backlog Gadget$")
	public void should_be_Able_to_Add_Execution_Backlog_Gadget() throws Throwable {
		try
	       {
	       String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",3,4);
	       actual[21]=db.validateGadget(gadgetname);
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
	@When("^Select Restricted project and Release and FilterBy and Refresh rate and click on save button$")
	public void select_Restricted_project_and_Release_and_FilterBy_and_Refresh_rate_and_click_on_save_button() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",0,5);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
		   bp.waitForElement();
		   actual[22]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   actual[23]=db.filterBy(filterByName, values);
		   bp.waitForElement();
		   actual[24]=db.saveGadget();
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

	@Then("^Should be able to Add Execution Backlog Gadget for Restricted project$")
	public void should_be_able_to_Add_Execution_Backlog_Gadget_for_Restricted_project() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",3,4);
		   actual[25]=db.validateGadget(gadgetname);
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