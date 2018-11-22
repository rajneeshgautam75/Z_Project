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

public class Dahboard_11 extends LaunchBrowser{

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
	String fileName="Dahboard_11";
	
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	@Given("^User add a release with no testcases$")
	public void user_add_a_release_with_no_testcases() throws Throwable {
	   try
	   {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=rp.clickOnManageRelease();
		   bp.waitForElement();
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10");
			boolean res=rp.checkAvailableRelease(releaseName);
			if(res==false)
			{
	    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 2,0);
			String Hide=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	    	String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	    	rp.addNewRelease(releaseName, Desc, Hide, MapexternalDefect);
	    	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			//rp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			bp.waitForElement();
			}
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

	@When("^User create a dashboard$")
	public void user_create_a_dashboard() throws Throwable {
		try
		   {
			 dbp=new DashBoardPage(driver);
			bp=new BasePage();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,2);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[2]=dbp.clickOnManageDashboards();
			actual[3]=dbp.clickOnAddDashBoardSymbol();
			actual[4]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[5]=dbp.validateDashBoard(dashboardName);
			bp.waitForElement();
			actual[6]=dbp.selectDashboard(dashboardName);
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

	@When("^User add a Test Automation Status gadget with project/release$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release() throws Throwable {
		try
		   {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8);
			 actual[7]=dbp.clickOnAddGadgetSymbol();
			 actual[8]=dbp.addGadget(gadgetName);
			 actual[9]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^User sucessfully navigated to the test automation gadget page$")
	public void user_sucessfully_navigated_to_the_test_automation_gadget_page() throws Throwable {
		try
		   {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
//			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
//			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			actual[10]=dbp.validateGadget(gadgetName);
			bp.waitForElement();
			pp.backToProjectPage();
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
