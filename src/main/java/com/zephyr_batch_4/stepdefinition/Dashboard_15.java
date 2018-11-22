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

public class Dashboard_15 extends LaunchBrowser{

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
	String fileName="Dashboard_15";
	
	boolean[] actual=new boolean[18];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the dashbOard page$")
	public void user_is_in_the_dashbOard_page() throws Throwable {
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

	@When("^User create a dashbOard with the available fields$")
	public void user_create_a_dashbOard_with_the_available_fields() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^User add a Test Automation Status gadget with the project/release$")
	public void user_add_a_Test_Automation_Status_gadget_with_the_project_release() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,2);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[5]=dbp.selectDashboard(dashboardName);
		     actual[6]=dbp.clickOnAddGadgetSymbol();
		     actual[7]=dbp.addGadget(gadgetName);
			 actual[8]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 //String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
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

	@Then("^User is able to change the refresh rate to different intervals$")
	public void user_is_able_to_change_the_refresh_rate_to_different_intervals() throws Throwable {
	    try
	    {
	    	 String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13); 
	    	 dbp.gadgetOperation(gadgetValue);
	    	 String projectName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
			 String release=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100); 
			 String refreshRate2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,8); 
			 actual[10]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate2);
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[11]=dbp.validateGadget(gadgetName);
		     bp.waitForElement();
			 
		     dbp.gadgetOperation(gadgetValue);
			 String refreshRate3=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[12]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate3);
			 //String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[13]=dbp.validateGadget(gadgetName);
			 bp.waitForElement();
			 
			 dbp.gadgetOperation(gadgetValue);
			 String refreshRate4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,8); 
			 actual[14]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate4);
			 actual[15]=dbp.validateGadget(gadgetName);
			 bp.waitForElement();
			 
			 dbp.gadgetOperation(gadgetValue);
			 String refreshRate5=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,8); 
			 actual[16]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate5);
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

	@Then("^User should be navigated to the edited test automation status gadget page$")
	public void user_should_be_navigated_to_the_edited_test_automation_status_gadget_page() throws Throwable {
	   try
	   {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			actual[17]=dbp.validateGadget(gadgetName);
			bp.waitForElement();
			for(int k=0;k<=actual.length-1;k++)
			{
				////System.out.println("Actual["+k+"]="+actual[k]);
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
