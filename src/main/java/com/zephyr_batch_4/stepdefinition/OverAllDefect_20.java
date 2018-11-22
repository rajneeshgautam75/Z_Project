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

public class OverAllDefect_20 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="OverAllDefect_20";
	   
	LoginPage lp;
	BasePage bp;
    ProjectPage pp;
	ReleasePage rp;
	DashBoardPage dp;
	ExecutionPage ep;
	TestRepositoryPage tr;
    TestPlanningPage tp;
		
	boolean actual[]=new boolean[41];
	SoftAssert soft=new SoftAssert();
	    
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_3");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 8, 0);
	private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 53, 0);
	    
	@Given("^Test Manager is in Test repository page$")
	public void test_Manager_is_in_Test_repository_page() throws Throwable {
		try
		{
		lp=new LoginPage(driver);
		pp=new ProjectPage(driver);
		bp=new BasePage();
		rp=new ReleasePage(driver);
		actual[0]=pp.clickOnLogout();
		String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		actual[1]=lp.enterUnameAndPassword(name, passWord);;
		bp.waitForElement();  
	    actual[2]=pp.selectProject(project);
	    actual[3]=pp.selectRelease(release);
		bp.waitForElement();
		actual[4]=rp.clickOnTestRep();
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

	@When("^Create a phase, add testcase, launch test planning and assign phase to cycle$")
	public void create_a_phase_add_testcase_launch_test_planning_and_assign_phase_to_cycle() throws Throwable {
		try
		{
		tr=new TestRepositoryPage(driver);
		tp=new TestPlanningPage(driver);
		String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
		actual[5]=tr.clickOnRelease(release);
		actual[6]=tr.addNode(phase, Desc);
		String [] node=new String [1];
		node[0]=phase;
		actual[7]=tr.navigateToNode(release, node);
		actual[8]=tr.addTestCase();
		bp.waitForElement();
		actual[9]=rp.clickOnTestPlanning();
		actual[10]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 27, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		actual[11]=tp.CreateCycle(cycle, Build, Environment, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[12]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[13]=tp.saveTestCycle(); 
		bp.waitForElement(); 
		String [] cycle1 =new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 27, 0);
		actual[14]=tp.navigateToCycle(cycle1);
		actual[15]=tp.addPhaseToCycle(phase);
		actual[16]=bp.waitForElement();
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	 	actual[17]=tp.bulkAssignment(Bulk_type);
	    tp.goBackToCycle(); 
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

	@When("^Launch Test Execution page and navigate to particular phase$")
	public void launch_Test_Execution_page_and_navigate_to_particular_phase() throws Throwable {
		try
		{
		ep=new ExecutionPage(driver);
		actual[18]=rp.clickOnTestExecution();
		String [] cycle =new String[2];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 27, 0);
		cycle[1]=phase;
		actual[19]=tr.navigateToNode(release, cycle);
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

	@When("^Execute the testcase and link defects with status open, inprogress and done for single testcase$")
	public void execute_the_testcase_and_link_defects_with_status_open_inprogress_and_done_for_single_testcase() throws Throwable {
		try
		{
		actual[20]=ep.selectAndDeselectAllTestCase();
		bp.waitForElement();
		String status12=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		actual[21]=ep.changeMultiSelectedStatus(status12);
		bp.waitForElement();
		int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
		actual[22]=ep.clickOnDefectButton(testcase1);
		bp.waitForElement();
		for(int i=1;i<=3;i++)
		{
		String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", i, 10);
		ep.searchDefect(defectId);
		ep.linkDefects.click();
		bp.waitForElement();
		}
		ep.cancelDefect.click();
		actual[23]=bp.waitForElement();	
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

	@When("^launch Dashboards page window$")
	public void launch_Dashboards_page_window() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		actual[24]=dp.clickOnManageDashboards();	
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

	@Then("^dashboards page should be launched$")
	public void dashboards_page_should_be_launched() throws Throwable {
		try
		{
		actual[25]=dp.validateDashboards();
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

	@When("^Create a new dashboard by clicking on add button$")
	public void create_a_new_dashboard_by_clicking_on_add_button() throws Throwable {
		try
		{
		actual[26]=dp.clickOnAddDashBoardSymbol();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[27]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
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

	@Then("^Newly added dashboard should be created$")
	public void newly_added_dashboard_should_be_created() throws Throwable {
		try
		{
		actual[28]=dp.validateDashBoard(dashBoardName);	
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

	@When("^Search and select the dashboard created$")
	public void search_and_select_the_dashboard_created() throws Throwable {
		try
		{
		actual[29]=dp.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[30]=dp.selectDashboard(dashBoardName);
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

	@When("^Clicking on add button and add OverAll Defects Gadget$")
	public void clicking_on_add_button_and_add_OverAll_Defects_Gadget() throws Throwable {
		try
		{
		actual[31]=dp.clickOnAddGadgetSymbol();
		bp.waitForElement();
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[32]=dp.addGadget(gadgetName);
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

	@Then("^OverAll Defects Gadget should be added to dashboard$")
	public void overall_Defects_Gadget_should_be_added_to_dashboard() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[33]=dp.validateGadget(gadgetName);	
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

	@When("^Configure gadget with project, Release and refresh rate details and save it$")
	public void configure_gadget_with_project_Release_and_refresh_rate_details_and_save_it() throws Throwable {
		try
		{
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[34]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Should show total defect count and count by status$")
	public void should_show_total_defect_count_and_count_by_status() throws Throwable {
		try
		{
		int defectCount=dp.linkCountInGadgetPage();
		System.out.println(defectCount);
		actual[35]=pp.backToProjectPage();
		actual[36]=pp.selectProject(project);
		actual[37]=pp.selectRelease(release);
		actual[38]=rp.clickOnTestRep();
		bp.waitForElement();
		String [] node=new String [1];
		node[0]=phase;
		actual[39]=tr.navigateToNode(release, node);
		actual[40]=tr.deleteNode();
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
