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

public class Execution_Backlog_gadget3 extends LaunchBrowser{
	ProjectPage pp;
	DashBoardPage db;
	BasePage bp;
	LaunchBrowser lb;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	String fileName="Execution_Backlog_gadget3";

	@Given("^User Is In Dashboard Page$")
	public void user_Is_In_Dashboard_Page() throws Throwable {
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

	@When("^User Add a Dashboard by clicking on plus button$")
	public void user_Add_a_Dashboard_by_clicking_on_plus_button() throws Throwable {
		try
        {
        String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",4, 0);
        String desc=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",4, 1);
        String layout=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard", 4, 2);
        String shareType=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",4,3);
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

	@Then("^Should be Able to Add Dashboard$")
	public void should_be_Able_to_Add_Dashboard() throws Throwable {
		try
	       {
	       String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",4, 0);
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
	@When("^Click On Plus Button and Add Execution Backlog gadget$")
	public void click_On_Plus_Button_and_Add_Execution_Backlog_gadget() throws Throwable {
		try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",4,4); 
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

	@Then("^Should be Able to add Execution Backlog gadget successfully$")
	public void should_be_Able_to_add_Execution_Backlog_gadget_successfully() throws Throwable {
		try
	       {
	       String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",4,4);
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

	@When("^Configure the Gadget with Required data and click on save button$")
	public void configure_the_Gadget_with_Required_data_and_click_on_save_button() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   String projectName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   String release=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
		   bp.waitForElement();
		   actual[8]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   //actual[9]=db.filterBy(filterByName, values);
		   actual[9]= bp.waitForElement();
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

	@Then("^Should not be able to add Execution backlog gadget$")
	public void should_not_be_able_to_add_Execution_backlog_gadget() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",4,4);
		   actual[11]=db.validateGadget(gadgetname);
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
