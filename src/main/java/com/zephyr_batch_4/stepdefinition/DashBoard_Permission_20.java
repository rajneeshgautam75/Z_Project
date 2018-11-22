package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_20 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DashBoards_Permission_20";
	
	BasePage bp;
	DashBoardPage dp;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	
	boolean actual[]=new boolean[29];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_11");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 21, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
	
	
	@Given("^Create a release as a lead and add new dashboard, gadget for that release$")
	public void create_a_release_as_a_lead_and_add_new_dashboard_gadget_for_that_release() throws Throwable {
	   try
	   {
		pp=new ProjectPage(driver);
		rp=new ReleasePage(driver);
		bp=new BasePage();
		dp=new DashBoardPage(driver);
		actual[0]=pp.selectProject(project);
		actual[1]=pp.clickOnManageRelease();
		boolean check=rp.checkAvailableRelease(release);
		System.out.println(check);
		if(check==false)
		{
		String Desc=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100,100);
		String Hide=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100,100);
		String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100,100);
		rp.addNewRelease(release, Desc, Hide, MapexternalDefect);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
		rp.clickOnAdd();
		}
		bp.waitForElement();
		actual[2]=dp.clickOnManageDashboards();
		actual[3]=dp.validateDashboards();
		bp.waitForElement();
		actual[4]=dp.clickOnAddDashBoardSymbol();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[5]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		bp.waitForElement();
		actual[6]=dp.validateDashBoard(dashBoardName);
		actual[7]=dp.selectDashboard(dashBoardName);
		bp.waitForElement();
		actual[8]=dp.clickOnAddGadgetSymbol();
		actual[9]=dp.addGadget(gadget);
		bp.waitForElement();
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[10]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
		bp.waitForElement();
		actual[11]=dp.validateSavedGadget(project);
		pp.backToProjectPage();
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

	@When("^Hide the release and check to gadget added for particular release$")
	public void hide_the_release_and_check_to_gadget_added_for_particular_release() throws Throwable {
	   try
	   {
		pp.selectProject(project2);
		actual[12]=pp.selectProject(project);
		actual[13]=pp.clickOnManageRelease(); 
		actual[14]=rp.selectReleaseInManageRelease(release);
		bp.waitForElement();
		rp.releaseHide.click();
		bp.waitForElement();
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

	@Then("^Should show that Configured release is hidden$")
	public void should_show_that_Configured_release_is_hidden() throws Throwable {
		try
		{
		actual[15]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[16]=dp.validateDashboards();
		actual[17]=dp.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[18]=dp.selectDashboard(dashBoardName);
		bp.waitForElement();
		actual[19]=dp.validateSavedGadget(project);
		pp.backToProjectPage();
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

	@When("^Delete that Release and check for gadget added$")
	public void delete_that_Release_and_check_for_gadget_added() throws Throwable {
		try
		{
		pp.selectProject(project2);
		actual[20]=pp.selectProject(project);
		actual[21]=pp.clickOnManageRelease();
		bp.waitForElement();
		actual[22]=pp.deleteRelease(release);
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

	@Then("^Should display message The Configured release is either deleted or you dnt have permission$")
	public void should_display_message_The_Configured_release_is_either_deleted_or_you_dnt_have_permission() throws Throwable {
		try
		{
		actual[23]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[24]=dp.validateDashboards();
		actual[25]=dp.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[26]=dp.selectDashboard(dashBoardName);
		bp.waitForElement();
		actual[27]=dp.validateOverAllDefectGadget();
		bp.waitForElement();
		actual[28]=pp.backToProjectPage();
		bp.waitForElement();
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
