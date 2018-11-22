package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverAllDefect_3 extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="OverAllDefect_3";
	
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	LoginPage lp;
	
	boolean actual[]=new boolean[14];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 0);
	
	@Given("^Test Manager is in Dashboards Page$")
	public void test_Manager_is_in_Dashboards_Page() throws Throwable {
		try
		{
		lp=new LoginPage(driver);
		bp=new BasePage();
		dp=new DashBoardPage(driver);
		pp=new ProjectPage(driver);
		actual[0]=pp.clickOnLogout();
		String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		actual[1]=lp.enterUnameAndPassword(name, passWord);
		bp.waitForElement();
		actual[2]=dp.clickOnManageDashboards();
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

	@When("^Click on add button and create new Dashboard$")
	public void click_on_add_button_and_create_new_Dashboard() throws Throwable {
		try
		{
		actual[3]=dp.clickOnAddDashBoardSymbol();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[4]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);	
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

	@Then("^Dashboard should be created$")
	public void dashboard_should_be_created() throws Throwable {
		try
		{
		actual[5]=dp.validateDashBoard(dashBoardName);
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

	@When("^Click on add symbol button and Add OverAll Defects Gadget$")
	public void click_on_add_symbol_button_and_Add_OverAll_Defects_Gadget() throws Throwable {
		try
		{
		actual[6]=dp.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[7]=dp.selectDashboard(dashBoardName);
		bp.waitForElement();
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[8]=dp.clickOnAddGadgetSymbol();
		actual[9]=dp.addGadget(gadgetName);
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

	@Then("^OverAll Defect Gadget should be added$")
	public void overall_Defect_Gadget_should_be_added() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[10]=dp.validateGadget(gadgetName);
		
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

	@When("^Select one project out of created projects$")
	public void select_one_project_out_of_created_projects() throws Throwable {
		try
		{
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[11]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Should be able to select one project out of created projects$")
	public void should_be_able_to_select_one_project_out_of_created_projects() throws Throwable {
		try
		{
		actual[12]=dp.validateSavedGadget(project, release);
		actual[13]=pp.backToProjectPage();
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
