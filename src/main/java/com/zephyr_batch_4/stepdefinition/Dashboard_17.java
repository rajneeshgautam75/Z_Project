package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_17 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	String fileName="Dashboard_17";
	
	boolean[] actual=new boolean[17];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a DashbOard page$")
	public void user_is_in_a_DashbOard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
			actual[1]=dbp.validateDashboards();
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

	@When("^User Create a dashbOard with the Available fields$")
	public void user_Create_a_dashbOard_with_the_Available_fields() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^dashBoard should be created successfully$")
	public void dashboard_should_be_created_successfully() throws Throwable {
	   try
	   {
		   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
		   actual[4]=dbp.validateDashBoard(dashboardName);
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

	@When("^User Add a Test Automation Status gadget with the project/release with interval and save$")
	public void user_Add_a_Test_Automation_Status_gadget_with_the_project_release_with_interval_and_save() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			 actual[5]=dbp.selectDashboard(dashboardName);
		     actual[6]=dbp.clickOnAddGadgetSymbol();
		     actual[7]=dbp.addGadget(gadgetName);
			 actual[8]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget added successfully$")
	public void gadget_added_successfully() throws Throwable {
		 try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
//			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
//			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
		     actual[9]=dbp.validateGadget(gadgetName);
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

	@When("^User minimize/maximize the added Test Automation Status gadget$")
	public void user_minimize_maximize_the_added_Test_Automation_Status_gadget() throws Throwable {
	    try
	    {
	    	String minimize=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,13);
	    	String maximize=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,13); 
	    	actual[10]=dbp.minimizeOrMaximizeDashBoardGadget(minimize);
	    	actual[11]=dbp.minimizeOrMaximizeDashBoardGadget(maximize);
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

	@When("^User add a Test Automation Status gadget without entering project/release$")
	public void user_add_a_Test_Automation_Status_gadget_without_entering_project_release() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			actual[12]=dbp.clickOnAddGadgetSymbol();
			actual[13]=dbp.addGadget(gadgetName);
			 
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

	@Then("^gadget should be added successfully$")
	public void gadget_should_be_added_successfully() throws Throwable {
		 try
			{
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			     actual[14]=dbp.validateGadget(gadgetName);
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

	@When("^User minimize/maximize test automation status gadget$")
	public void user_minimize_maximize_test_automation_status_gadget() throws Throwable {
		try
	    {
	    	String minimize=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,13); 
	    	actual[15]=dbp.minimizeOrMaximizeDashBoardGadget(minimize);
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

	@Then("^User successfully maximize the gadget$")
	public void user_successfully_maximize_the_gadget() throws Throwable {
		try
	    {
	    	String maximize=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,13); 
	    	actual[16]=dbp.minimizeOrMaximizeDashBoardGadget(maximize);
	    	
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
