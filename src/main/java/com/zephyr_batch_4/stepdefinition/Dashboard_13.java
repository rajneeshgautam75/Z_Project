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

public class Dashboard_13 extends LaunchBrowser{

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
	String fileName="Dashboard_13";
	
	boolean[] actual=new boolean[17];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the dashboard page$")
	public void user_is_in_the_dashboard_page() throws Throwable {
		try
		   {
			  bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10");
			 
			   bp.waitForElement();
			   pp.selectProject(projectName1);
			   bp.waitForElement();
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   
			   tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3, 2);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				
				bp=new BasePage();
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				
				bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				tr.clickOnDetails();
				ctc=new CreateTestCasePage(driver);
				String check=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
				String script_Name=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
				String script_Id=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
				String script_Path=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
				actual[6]=ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
				bp.waitForElement();
				tr.clickOnList();
				for(int i=0;i<=2;i++)
				{
				tr.selectallTestCase();
				tr.cloneTestCase();
				}
				bp.waitForElement();
				bp.waitForElement();
				
				String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 2);
				String[] phase2=new String[1];
				phase2[0]=p_Name2;
				bp.waitForElement();
				actual[7]=tr.navigateToNode(releaseName, phase2);
				tr.deleteNode();
				bp.waitForElement();
				
				dbp=new DashBoardPage(driver);
				bp=new BasePage();
				actual[8]=dbp.clickOnManageDashboards();
				//actual[8]=bp.waitForElement();
				//actual[8]=dbp.validateDashboards();
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

	@When("^User create a dashboard with the available fields$")
	public void user_create_a_dashboard_with_the_available_fields() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[9]=dbp.clickOnAddDashBoardSymbol();
		actual[10]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[11]=dbp.validateDashBoard(dashboardName);
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

	@When("^User add a Test Automation Status gadget with project/release contains only automated testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_only_automated_testcases() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,2);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8);
			 actual[12]=dbp.selectDashboard(dashboardName);
		     actual[13]=dbp.clickOnAddGadgetSymbol();
		     actual[14]=dbp.addGadget(gadgetName);
			 actual[15]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^User should be navigated to the test automation status gadget page contains automated testcase information$")
	public void user_should_be_navigated_to_the_test_automation_status_gadget_page_contains_automated_testcase_information() throws Throwable {
		try
		   {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
//			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
//			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			actual[16]=dbp.validateGadget(gadgetName);
			bp.waitForElement();
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
