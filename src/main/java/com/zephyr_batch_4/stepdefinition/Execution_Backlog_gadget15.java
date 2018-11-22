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

public class Execution_Backlog_gadget15 extends LaunchBrowser{
	ProjectPage pp;
	DashBoardPage db;
	BasePage bp;
	LaunchBrowser lb;
	boolean[] actual=new boolean[33];
	SoftAssert soft=new SoftAssert();
	String fileName="Execution_Backlog_gadget15";

	@Given("^user Is In Dashboard Page$")
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

	@When("^user Add the Dashboard by clicking on Plus Button$")
	public void user_Add_the_Dashboard_by_clicking_on_Plus_Button() throws Throwable {
		try
        {
        String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5, 0);
        String desc=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5, 1);
        String layout=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard", 5, 2);
        String shareType=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5,3);
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

	@Then("^should be Able to Add the Dashboard$")
	public void should_be_Able_to_Add_the_Dashboard() throws Throwable {
	 try
	   {
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5, 0);
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

	@When("^Click On Plus button and Add Execution Backlog Gadget$")
	public void click_On_Plus_button_and_Add_Execution_Backlog_Gadget() throws Throwable {
		try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5,4); 
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

	@Then("^Should be Able to add the Execution Backlog Gadget Successfully$")
	public void should_be_Able_to_add_the_Execution_Backlog_Gadget_Successfully() throws Throwable {
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

	@When("^User try to save Executions Backlog Gadget without selecting any Project$")
	public void user_try_to_save_Executions_Backlog_Gadget_without_selecting_any_Project() throws Throwable {
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

	@Then("^Should not be Able to Save Executions Backlog Gadget without selecting any project$")
	public void should_not_be_Able_to_Save_Executions_Backlog_Gadget_without_selecting_any_project() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
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
	@When("^click On Plus Button and Add Execution Backlog Gadget$")
	public void click_On_Plus_Button_and_Add_Execution_Backlog_Gadget() throws Throwable {
		try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5,4); 
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

	@Then("^should be Able to Add the Execution Backlog Gadget Successfully$")
	public void should_be_Able_to_Add_the_Execution_Backlog_Gadget_Successfully() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
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


	@When("^User try to save Executions Backlog Gadget without selecting any Release$")
	public void user_try_to_save_Executions_Backlog_Gadget_without_selecting_any_Release() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   String release=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
		   bp.waitForElement();
		   actual[15]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   //db.filterBy(filterByName, values);
		   actual[16]=bp.waitForElement();
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

	@Then("^Should not be Able to Save Executions Backlog Gadget without selecting any Release$")
	public void should_not_be_Able_to_Save_Executions_Backlog_Gadget_without_selecting_any_Release() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
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

   @When("^Click On Plus button and Add execution Backlog gadget$")
   public void click_On_Plus_button_and_Add_execution_Backlog_gadget() throws Throwable {
	   try
	    {
	    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5,4); 
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

   @Then("^Should be Able to Add the Execution Backlog Gadget$")
   public void should_be_Able_to_Add_the_Execution_Backlog_Gadget() throws Throwable {
	   try
	   {
	   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
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


	@When("^User try to save Executions Backlog Gadget without selecting any FilterBy Option$")
	public void user_try_to_save_Executions_Backlog_Gadget_without_selecting_any_FilterBy_Option() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,10);
		   bp.waitForElement();
		   actual[22]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   //db.filterBy(filterByName, values);
		   actual[23]=bp.waitForElement();
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

	@Then("^Should not be Able to save Executions Backlog Gadget without selecting any FilterBy Option$")
	public void should_not_be_Able_to_save_Executions_Backlog_Gadget_without_selecting_any_FilterBy_Option() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
		   actual[25]=db.validateGadget(gadgetname);
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
	@When("^Click on plus Button and Add execution Backlog Gadget$")
	public void click_on_plus_Button_and_Add_execution_Backlog_Gadget() throws Throwable {
		 try
		    {
		    String gadgetname = Excel_Lib.getData(INPUT_PATH_6,"NewDashboard",5,4); 
		    actual[26]=db.clickOnAddGadgetSymbol();
		    bp.waitForElement();
		    actual[27]=db.addGadget(gadgetname);
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

	@Then("^should be Able to Add the Execution Backlog Gadget successfully$")
	public void should_be_Able_to_Add_the_Execution_Backlog_Gadget_successfully() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
		   actual[28]=db.validateGadget(gadgetname);
		   bp.waitForElement();
		   driver.navigate().refresh();
		   bp.waitForElement();
		   bp.waitForElement();
		  
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

	@When("^User try to save Executions Backlog Gadget without selecting Refresh interval$")
	public void user_try_to_save_Executions_Backlog_Gadget_without_selecting_Refresh_interval() throws Throwable {
		try
	       {
		   String filterByName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",0,5);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",100,100);
		   bp.waitForElement();
		   actual[29]=db.configureTraceabilityGadget(projectName,release, refreshRate);
		   String[] values=new String[1];
		   values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		   //db.filterBy(filterByName, values);
		   actual[30]= bp.waitForElement();
		   actual[31]=db.saveGadget();
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

	@Then("^Should not be able to save Executions Backlog Gadget without selecting Refresh interval$")
	public void should_not_be_able_to_save_Executions_Backlog_Gadget_without_selecting_Refresh_interval() throws Throwable {
		try
		   {
		   String gadgetname = Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",5,4);
		   actual[32]=db.validateGadget(gadgetname);
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
