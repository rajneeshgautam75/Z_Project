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

public class DashBoard_Permission_16 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DashBoards_Permission_16";
	
	BasePage bp;
	DashBoardPage dp;
	ProjectPage pp;
	
	boolean actual[]=new boolean[10];
	SoftAssert soft=new SoftAssert();
	
	private String dashBoardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 16, 0);
	private String dashBoardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 17, 0);
	

	@Given("^Login as a lead, create dashborads of different sharetypes$")
	public void login_as_a_lead_create_dashborads_of_different_sharetypes() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[0]=dp.clickOnManageDashboards();
		actual[1]=dp.validateDashboards();
		bp.waitForElement();
		for(int i=0;i<=1;i++)
		{
		actual[2]=dp.clickOnAddDashBoardSymbol();
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", i+16, 0);
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", i+3, 3);
		actual[3]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		actual[4]=dp.validateDashBoard(dashBoardName);	
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

	@When("^Search for a DashBoard of sharetype 'Private'$")
	public void search_for_a_DashBoard_of_sharetype_Private() throws Throwable {
		try
		{
		actual[5]=dp.searchDashboard(dashBoardName1);
		bp.waitForElement();
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

	@Then("^Should be able to search dashboard of sharetype 'Private'$")
	public void should_be_able_to_search_dashboard_of_sharetype_Private() throws Throwable {
		try
		{
		actual[6]=dp.validateDashBoard(dashBoardName1);	
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

	@When("^Search for a DashBoard of sharetype 'Any Logged in User'$")
	public void search_for_a_DashBoard_of_sharetype_Any_Logged_in_User() throws Throwable {
		try
		{
		actual[7]=dp.searchDashboard(dashBoardName2);
		bp.waitForElement();	
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

	@Then("^Should be able to search dashboard of sharetype 'Any Logged in User'$")
	public void should_be_able_to_search_dashboard_of_sharetype_Any_Logged_in_User() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		actual[8]=dp.validateDashBoard(dashBoardName2);
		actual[9]=pp.backToProjectPage();
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
