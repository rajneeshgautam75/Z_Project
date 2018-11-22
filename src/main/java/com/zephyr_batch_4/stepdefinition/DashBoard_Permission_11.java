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

public class DashBoard_Permission_11 extends LaunchBrowser{

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
	String fileName="DashBoard_Permission_11";
	
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Lead is in the DashBoard page$")
	public void lead_is_in_the_DashBoard_page() throws Throwable {
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

	@When("^Add a DashBoard by click on the DashBoard plus symbol$")
	public void add_a_DashBoard_by_click_on_the_DashBoard_plus_symbol() throws Throwable {
		try
		{
		actual[1]=dbp.clickOnAddDashBoardSymbol();
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

	@When("^Add a DashBoards with different share types$")
	public void add_a_DashBoards_with_different_share_types() throws Throwable {
		try
		{

		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.enterDashBoardDetails(dashboardName1, desc, layout, shareType1);
		
		dbp.clickOnAddDashBoardSymbol();
		String dashboardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,2);
		String shareType2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3,5);
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

	@When("^DashBoard is added added$")
	public void dashboard_is_added_added() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,2);
		String dashboardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,2);
		actual[4]=dbp.validateDashBoard(dashboardName1);
		actual[5]=dbp.validateDashBoard(dashboardName2);
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

	@When("^select the added DashBoard$")
	public void select_the_added_DashBoard() throws Throwable {
		try
		{
		String dashboardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,2);
		actual[6]=dbp.searchDashboard(dashboardName2);
		
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

	@Then("^should be able to delete the DashBoard$")
	public void should_be_able_to_delete_the_DashBoard() throws Throwable {
		try
		{
		String dashboardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,2);
		actual[7]=dbp.deleteDashBoard(dashboardName2);
		
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

	@When("^As a Manager,Launch DashBoard page$")
	public void as_a_Manager_Launch_DashBoard_page() throws Throwable {
		try
		{
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
			
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[8]=dbp.clickOnManageDashboards();	
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
	
	@When("^select the Added DashBoard$")
	public void select_the_Added_DashBoard() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,2);
		actual[9]=dbp.searchDashboard(dashboardName1);
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


	@Then("^Should be able to delete the Dashboard$")
	public void should_be_able_to_delete_the_Dashboard() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,2);
		actual[10]=dbp.deleteDashBoard(dashboardName1);
		
		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		
		//pp.clickOnLogout();
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
