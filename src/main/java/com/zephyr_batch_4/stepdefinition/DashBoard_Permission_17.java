package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_17 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DashBoards_Permission_17";
	
	BasePage bp;
	DashBoardPage dp;
	LoginPage lp;
	ProjectPage pp;
	
	boolean actual[]=new boolean[17];
	SoftAssert soft=new SoftAssert();
	
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 18, 0);
	
	@Given("^Create a Dashboard of Sharetype Project Team$")
	public void create_a_Dashboard_of_Sharetype_Project_Team() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		pp=new ProjectPage(driver);
		actual[0]=dp.clickOnManageDashboards();
		actual[1]=dp.validateDashboards();
		bp.waitForElement();
		actual[2]=dp.clickOnAddDashBoardSymbol();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[3]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		actual[4]=dp.validateDashBoard(dashBoardName);
		bp.waitForElement();
		actual[5]=pp.clickOnLogout();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	    
	}

	@When("^Login as Test manager and search for DashBoard, which is created for a project assigned$")
	public void login_as_Test_manager_and_search_for_DashBoard_which_is_created_for_a_project_assigned() throws Throwable {
		try
		{
		lp=new LoginPage(driver);
		String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		actual[6]=lp.enterUnameAndPassword(name, passWord);
		bp.waitForElement();
		actual[7]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[8]=dp.validateDashboards();
		bp.waitForElement();
		actual[9]=dp.searchDashboard(dashBoardName);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	    
	}

	@Then("^Should be able to search Dashboard for project assigned and logout$")
	public void should_be_able_to_search_Dashboard_for_project_assigned_and_logout() throws Throwable {
		try
		{
		actual[10]=dp.validateDashBoard(dashBoardName);
		bp.waitForElement();
		pp.clickOnLogout();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}     
	    
	}

	@When("^Login as Lead and search for DashBoard, which is created for a project assigned$")
	public void login_as_Lead_and_search_for_DashBoard_which_is_created_for_a_project_assigned() throws Throwable {
		try
		{
		String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		actual[11]=lp.enterUnameAndPassword(name, passWord);
		bp.waitForElement();
		actual[12]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[13]=dp.validateDashboards();
		bp.waitForElement();
		actual[14]=dp.searchDashboard(dashBoardName);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}     
	    
	}

	@Then("^Should be able to search Dashboard for project assigned$")
	public void should_be_able_to_search_Dashboard_for_project_assigned() throws Throwable {
		try
		{
		actual[15]=dp.validateDashBoard(dashBoardName);	
		actual[16]=pp.backToProjectPage();
		for(int k=0;k<=actual.length-1;k++)
		{
		System.out.println("Actual["+k+"]="+actual[k]);
		soft.assertEquals(actual[k], true);
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}     
	    
	}

}
