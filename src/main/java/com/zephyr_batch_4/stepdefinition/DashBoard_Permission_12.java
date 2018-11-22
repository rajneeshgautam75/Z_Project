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
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_12 extends LaunchBrowser{

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
	RequirementsPage req;
	String fileName="DashBoard_Permission_12";
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Lead Launch DashBoard page$")
	public void lead_Launch_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
	    	pp=new ProjectPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
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

	@When("^Add a DashBoards with different share types by clicking add dashboard plus symbol$")
	public void add_a_DashBoards_with_different_share_types_by_clicking_add_dashboard_plus_symbol() throws Throwable {
		try
		{
		actual[1]=dbp.clickOnAddDashBoardSymbol();
		
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3,5);
		actual[2]=dbp.enterDashBoardDetails(dashboardName1, desc, layout, shareType1);
		
		dbp.clickOnAddDashBoardSymbol();
		String dashboardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,2);
		String shareType2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[3]=dbp.enterDashBoardDetails(dashboardName2, desc, layout, shareType2);
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

	@When("^DashBoards is created successfully$")
	public void dashboards_is_created_successfully() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16,2);
		String dashboardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,2);
		actual[4]=dbp.validateDashBoard(dashboardName1);
		actual[5]=dbp.validateDashBoard(dashboardName2);
		
		pp.clickOnLogout();
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

	@When("^As a another Lead,Launch DashBoard page$")
	public void as_a_another_Lead_Launch_DashBoard_page() throws Throwable {
		try
		{
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_2");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_2");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     actual[6]=lp.clickOnLogin();
			
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[7]=dbp.clickOnManageDashboards();	
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

	@Then("^Attempt to Delete dashboard's of share type Any logged in User other then creator and 'TestManager'$")
	public void attempt_to_Delete_dashboard_s_of_share_type_Any_logged_in_User_other_then_creator_and_TestManager() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16,2);
		actual[8]=dbp.searchDashboard(dashboardName1);
		actual[9]=dbp.deleteDashBoard(dashboardName1);
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

	@When("^select the dashBoard's of share type 'project team' and attempt to delete the dashboard$")
	public void select_the_dashBoard_s_of_share_type_project_team_and_attempt_to_delete_the_dashboard() throws Throwable {
		try
		{
		dbp.clickOnManageDashboards();
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,2);
		actual[10]=dbp.searchDashboard(dashboardName1);
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

	@Then("^Should not allow to Delete dashboard's of share type Project other then creator and 'TestManager'$")
	public void should_not_allow_to_Delete_dashboard_s_of_share_type_Project_other_then_creator_and_TestManager() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,2);
//		dbp.validateDashBoard(dashboardName1);
		actual[11]=dbp.deleteDashBoard(dashboardName1);
		
		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
			driver.close();
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
