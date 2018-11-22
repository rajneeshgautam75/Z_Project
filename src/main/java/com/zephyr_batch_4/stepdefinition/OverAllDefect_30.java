package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
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

public class OverAllDefect_30 extends LaunchBrowser{
	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="OverAllDefect_30";
	
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	LoginPage lp;
	
	boolean actual[]=new boolean[40];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_3");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 7, 0);
	private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 52, 0);
	
	@Given("^Test Manager is in Test Repository page$")
	public void test_Manager_is_in_Test_Repository_page() throws Throwable {
		try
		{
		lp=new LoginPage(driver);
		bp=new BasePage();
		pp=new ProjectPage(driver);
		rp=new ReleasePage(driver);
		bp.waitForElement();
	    actual[0]=pp.clickOnLogout();
	    
	    driver.navigate().refresh();
	   for(int i=1;i<=5;i++)
	   {
	    bp.waitForElement();
	   }
	    
	    String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
	    actual[1]=lp.enterUnameAndPassword(name, passWord);
	    bp.waitForElement();  
	    actual[2]=pp.selectProject(project);
	    pp.clickOnManageRelease();
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
		pp.selectProject(project);
	    actual[3]=pp.selectRelease(release);
	    actual[4]=rp.clickOnTestRep();
	    bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}
	}

	@When("^Create new phase, add a testcase and assign phase to cycle in Test Planning page$")
	public void create_new_phase_add_a_testcase_and_assign_phase_to_cycle_in_Test_Planning_page() throws Throwable {
		try
		{
		tr=new TestRepositoryPage(driver);
		tp=new TestPlanningPage(driver);
		actual[5]=tr.clickOnRelease(release);
		String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
		actual[6]=tr.addNode(phase, Desc);
		String [] node=new String [1];
		node[0]=phase;
		actual[7]=tr.navigateToNode(release, node);
		actual[8]=tr.addTestCase();
		bp.waitForElement();
		actual[9]=rp.clickOnTestPlanning();
		actual[10]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 26, 0);
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
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 26, 0);
		actual[14]=tp.navigateToCycle(cycle1);
		actual[15]=tp.addPhaseToCycle(phase);
		actual[16]=bp.waitForElement();
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	 	actual[17]=tp.bulkAssignment(Bulk_type);
	    bp.waitForElement();
	    tp.goBackToCycle();
	    bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@When("^Launch Test Execution page, execute a testcase and link two hundred defects to testcase$")
	public void launch_Test_Execution_page_execute_a_testcase_and_link_two_hundred_defects_to_testcase() throws Throwable {
		try
		{
		ep=new ExecutionPage(driver);
		actual[18]=rp.clickOnTestExecution();
		String [] cycle =new String[2];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 26, 0);
		cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 52,0);
		actual[19]=tr.navigateToNode(release, cycle);
		bp.waitForElement();
		actual[20]=ep.selectAndDeselectAllTestCase();
		bp.waitForElement();
		String status12=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		actual[21]=ep.changeMultiSelectedStatus(status12);
		bp.waitForElement();
		int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
		actual[22]=ep.clickOnDefectButton(testcase1);
		bp.waitForElement();
		for(int i=1;i<=50;i++)
		{
		String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", i, 6);
		actual[23]=ep.searchDefect(defectId);
		ep.linkDefects.click();
		bp.waitForElement();
		}
	    JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",ep.cancelDefect );
		  bp.waitForElement();
		ep.cancelDefect.click();
		bp.waitForElement();
		bp.waitForElement();
		driver.navigate().refresh();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}    
	}

	@When("^Launch dashBoards window page$")
	public void launch_dashBoards_window_page() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		actual[24]=dp.clickOnManageDashboards();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@Then("^Dashboards window page should be launched$")
	public void dashboards_window_page_should_be_launched() throws Throwable {
		try
		{
		actual[25]=dp.validateDashboards();
		bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@When("^Click on add button and create new DashBoard$")
	public void click_on_add_button_and_create_new_DashBoard() throws Throwable {
		try
		{
		actual[26]=dp.clickOnAddDashBoardSymbol();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[27]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@Then("^new Dashboard should be created$")
	public void new_Dashboard_should_be_created() throws Throwable {
		try
		{
		actual[28]=dp.validateDashBoard(dashBoardName);
		actual[29]=dp.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[30]=dp.selectDashboard(dashBoardName);
		bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@When("^Click on add symbol and add OverAll Defects Gadget$")
	public void click_on_add_symbol_and_add_OverAll_Defects_Gadget() throws Throwable {
		try
		{
		actual[31]=dp.clickOnAddGadgetSymbol();
		bp.waitForElement();
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[32]=dp.addGadget(gadgetName);
		bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@Then("^OverAll Defects gadget should be added$")
	public void overall_Defects_gadget_should_be_added() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[33]=dp.validateGadget(gadgetName);
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@When("^Configure Gadget with project, release and refresh rate details$")
	public void configure_Gadget_with_project_release_and_refresh_rate_details() throws Throwable {
		try
		{
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[34]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
		bp.waitForElement();
		}
		catch(Exception e )
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}    
	}

	@Then("^Gadget should show total proper defect count$")
	public void gadget_should_show_total_proper_defect_count() throws Throwable {
		try
		{
		int defectCount=dp.linkCountInGadgetPage();
		pp.backToProjectPage();
		bp.waitForElement();
		pp.selectProject(project2);
		System.out.println(defectCount);
		actual[35]=pp.selectProject(project);
		actual[36]=pp.selectRelease(release);
		actual[37]=rp.clickOnTestRep();
		bp.waitForElement();
		String [] node=new String [1];
		node[0]=phase;
		actual[38]=tr.navigateToNode(release, node);
		actual[39]=tr.deleteNode();
		bp.waitForElement();
		for(int k=0;k<=actual.length-1;k++)
		{
		System.out.println("Actual["+k+"]="+actual[k]);
		soft.assertEquals(actual[k], true);
		}
		}
		catch(Exception e )
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
