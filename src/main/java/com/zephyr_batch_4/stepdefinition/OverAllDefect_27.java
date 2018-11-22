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

public class OverAllDefect_27 extends LaunchBrowser {

	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="OverAllDefect_27";
	
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	LoginPage lp;
	
	boolean actual[]=new boolean[36];
	SoftAssert soft=new SoftAssert();
	
	private String project=Excel_Lib.getData(INPUT_PATH_5, "Projects", 5, 0);
	private String release=Excel_Lib.getData(INPUT_PATH_5, "Projects", 1, 1);
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 5, 0);
	
	@Given("^Test Manager is in Manage Projects page$")
	public void test_Manager_is_in_Manage_Projects_page() throws Throwable {
		try
		{
		lp=new LoginPage(driver);
		pp=new ProjectPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		actual[0]=pp.clickOnLogout();
		bp.waitForElement();
		String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		actual[1]=lp.enterUnameAndPassword(name, passWord);
		bp.waitForElement();
		actual[2]=pp.launchAdministration();
		bp.waitForElement();
		actual[3]=pp.launchManageprojects();
		actual[4]=bp.waitForElement();
		
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

	@When("^Create a new project and assign project to test manager$")
	public void create_a_new_project_and_assign_project_to_test_manager() throws Throwable {
		try
		{
		String description=Excel_Lib.getData(INPUT_PATH_5, "Projects", 0, 1);
		String lead=Excel_Lib.getData(INPUT_PATH_5, "Projects", 1, 8);
		String mapDefectProject=Excel_Lib.getData(INPUT_PATH_5, "Projects", 100, 100);
		String [] startDate = new String[3];
		startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 2));
		startDate[1]=Excel_Lib.getData(INPUT_PATH_5,"Projects", 1,3);
		startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1,4));
		String [] endDate = new String[3];
		endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 5));
		endDate[1]=Excel_Lib.getData(INPUT_PATH_5, "Projects", 1, 6);
		endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 7));		
		String shareCheckbox=Excel_Lib.getData(INPUT_PATH_5, "Projects", 100, 100);	
		String typeName=Excel_Lib.getData(INPUT_PATH_5, "Projects", 1, 9);
		boolean check=pp.validateProject(project);
		if(check==false)
		{
		pp.createProject(project, description, typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		}
		actual[5]=bp.waitForElement();
		actual[6]=pp.launchManageUsers();
		bp.waitForElement();
		String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
		actual[7]=pp.selectUser(name);
		actual[8]=pp.assignProject(project);
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

	@Then("^New project should be created$")
	public void new_project_should_be_created() throws Throwable {
		try
		{
		actual[9]=pp.launchManageprojects();
		bp.waitForElement();
		actual[10]=pp.validateProject(project);
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

	@When("^Create new release in new project$")
	public void create_new_release_in_new_project() throws Throwable {
		try
		{
		rp=new ReleasePage(driver);
		pp.backToProjectPage();
		actual[11]=pp.selectProject(project);
		actual[12]=pp.clickOnManageRelease();
		boolean check=rp.checkAvailableRelease(release);
		System.out.println(check);
		if(check==false)
		{
		String Desc=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100,100);
		String Hide=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100,100);
		String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100,100);
		actual[13]=rp.addNewRelease(release, Desc, Hide, MapexternalDefect);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[14]=rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
		actual[15]=rp.clickOnAdd();
		}
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

	@When("^Go to Dashboards page$")
	public void go_to_Dashboards_page() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		actual[16]=dp.clickOnManageDashboards();
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

	@Then("^Should be able to launch dashboards window$")
	public void should_be_able_to_launch_dashboards_window() throws Throwable {
		try
		{
		actual[17]=dp.validateDashboards();
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

	@When("^Click on add button and create new dashboard$")
	public void click_on_add_button_and_create_new_dashboard() throws Throwable {
		try
		{
		actual[18]=dp.clickOnAddDashBoardSymbol();
		bp.waitForElement();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[19]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
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

	@Then("^Should be able to add new Dashboard$")
	public void should_be_able_to_add_new_Dashboard() throws Throwable {
		try
		{
		actual[20]=dp.validateDashBoard(dashBoardName);
		bp.waitForElement();
		actual[21]=dp.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[22]=dp.selectDashboard(dashBoardName);
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

	@When("^Add Overall Defects Gadget by clicking on \\+ button$")
	public void add_Overall_Defects_Gadget_by_clicking_on_button() throws Throwable {
		try
		{
		actual[23]=dp.clickOnAddGadgetSymbol();
		bp.waitForElement();
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[24]=dp.addGadget(gadgetName);
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

	@Then("^Should be able to add Overall Defect Gadget to dashboard$")
	public void should_be_able_to_add_Overall_Defect_Gadget_to_dashboard() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[25]=dp.validateGadget(gadgetName);
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

	@When("^Configure gadget with project, release, refresh rate details and save it$")
	public void configure_gadget_with_project_release_refresh_rate_details_and_save_it() throws Throwable {
		try
		{
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[26]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Gadget should be added$")
	public void gadget_should_be_added() throws Throwable {
		try
		{
		int defectCount=dp.linkCountInGadgetPage();
		System.out.println(defectCount);
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

	@When("^Go to project setup and delete that dashbaord added project$")
	public void go_to_project_setup_and_delete_that_dashbaord_added_project() throws Throwable {
		try
		{
		actual[27]=pp.launchAdministration();
		bp.waitForElement();
		actual[28]=pp.launchManageprojects();
		bp.waitForElement();
		bp.waitForElement();
		actual[29]=pp.deleteProject(project);
		
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

	@Then("^Project should be deleted$")
	public void project_should_be_deleted() throws Throwable {
		try
		{
		pp.validateProject(project);
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

	@When("^View added gadget$")
	public void view_added_gadget() throws Throwable {
		try
		{
		actual[30]=dp.clickOnManageDashboards();
		actual[31]=dp.searchDashboard(dashBoardName);
		actual[32]=bp.waitForElement();
		actual[33]=dp.selectDashboard(dashBoardName);
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

	@Then("^Should not show any data and proper message should display$")
	public void should_not_show_any_data_and_proper_message_should_display() throws Throwable {
		try
		{
		actual[34]=dp.validateOverAllDefectGadget();
		actual[35]=pp.backToProjectPage();
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
