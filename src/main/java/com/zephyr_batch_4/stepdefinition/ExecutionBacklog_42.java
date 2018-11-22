package com.zephyr_batch_4.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class ExecutionBacklog_42 extends LaunchBrowser{

	ProjectPage pp;
	LoginPage lp;
	DashBoardPage db;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exe;

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "ExecutionBacklog_42";

	boolean[] actual = new boolean[53];
	SoftAssert soft = new SoftAssert();

	

@Given("^Login as Manager credential$")
public void login_as_Manager_credential() throws Throwable {
	try {
		pp = new ProjectPage(driver);
		lp = new LoginPage(driver);
		bp = new BasePage();

		String userName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Manager_Username_1");
		String passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Manager_Password_1");

		actual[0] = pp.clickOnLogout();
		actual[1] = lp.enterUname(userName);
		actual[2] = lp.enterPass(passWord);
		actual[3] = lp.clickOnLogin();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^User navigate to test Repository Page$")
public void user_navigate_to_test_Repository_Page() throws Throwable {
	try {
		rp = new ReleasePage(driver);
		String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		actual[4] = pp.selectProject(projectName);
		actual[5] = pp.selectRelease(releaseName);

		actual[6] = rp.clickOnTestRep();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^Create a node with Name and description$")
public void create_a_node_with_Name_and_description() throws Throwable {
	try {
		tr = new TestRepositoryPage(driver);
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		String nodeName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 9);
		String nodeDesc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 10);
		actual[7] = tr.clickOnRelease(releaseName);

		actual[8] = tr.addNode(nodeName, nodeDesc);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^Phase Should be created Successfully$")
public void phase_Should_be_created_Successfully() throws Throwable {
	try {
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");

		String[] nodeName = new String[1];
		nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 9);
		actual[9] = tr.navigateToNode(releaseName, nodeName);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^user add twelve testcases to the node$")
public void user_add_twelve_testcases_to_the_node() throws Throwable {
	try {
		for (int i = 1; i <= 12; i++) {
			actual[10] = tr.addTestCase();
		}

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^testcases successfully added to the node$")
public void testcases_successfully_added_to_the_node() throws Throwable {
	try {
		actual[11] = tr.verifyPresentTestCase();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^user navigate to Test_Planning Page$")
public void user_navigate_to_Test_Planning_Page() throws Throwable {
	try {
		actual[12] = rp.clickOnTestPlanning();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^create a new cycle and add phase to cycle,assign to manager$")
public void create_a_new_cycle_and_add_phase_to_cycle_assign_to_manager() throws Throwable {
	try {
		tp = new TestPlanningPage(driver);
		
		String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 5);
		String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 6);
		String environ = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 7);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);
		String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 43, 8));
		String smonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 9);
		String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 43, 10));
		String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 43, 11));

		String emonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 12);
		String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 43, 13));

		String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 9);

		actual[13] = tp.clickOnAddTestCycleSymbol();
		actual[14] = tp.CreateCycle(cycleName, build, environ, hide);
		actual[15] = tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[16] = tp.saveTestCycle();
		actual[17] = bp.waitForElement();

		actual[18] = tp.doubleClickOnCycle(cycleName);
		actual[19] = tp.addPhaseToCycle(phaseName);

		actual[20] = tp.cancelBulkAssign();
		actual[21] = tp.doubleClickOnCycle(phaseName);

		// tp.selectSingleMultipleTestcase(tcNo);
		actual[22] = tp.selectallTestCase();
		String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Manager_1");
		actual[23] = tp.assignAllSelected(assignee);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^testcases should be assign to manager$")
public void testcases_should_be_assign_to_manager() throws Throwable {
	try {
		String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Manager_1");
		int[] tcNo = new int[12];

		for (int i = 0; i <= tcNo.length - 1; i++) {
			tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
		}
		actual[24] = tp.validateAllAssigned(tcNo, assignee);
		tp.goBackToCycle();
	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^user navigate to Test Execution Page$")
public void user_navigate_to_Test_Execution_Page() throws Throwable {
	try {
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		actual[25] = rp.clickOnTestExecution();
		String[] navigation = new String[2];
		navigation[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 5);
		navigation[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 9);

		actual[26] = tr.navigateToNode(releaseName, navigation);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^execute testcases to Pass,Fail,Blocked and WIP status$")
public void execute_testcases_to_Pass_Fail_Blocked_and_WIP_status() throws Throwable {
	try {
		exe = new ExecutionPage(driver);
		int[] tcNo1 = new int[3];
		for (int i = 0; i <= 2; i++) {
			tcNo1[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
		}

		String status1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
		actual[27] = exe.changeStatusOfTestCases(tcNo1, status1);
		
		int[] tcNo2 = new int[3];
		for (int i = 0; i <= 2; i++) {
			tcNo2[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 4, 27);
		}
		
		String status2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
		actual[28] = exe.changeStatusOfTestCases(tcNo2, status2);
		

		int[] tcNo3 = new int[3];
		for (int i = 0; i <= 2; i++) {
			tcNo3[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 7, 27);
		}
		
		String status3 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 7, 17);
		actual[29] = exe.changeStatusOfTestCases(tcNo3, status3);
		

		int[] tcNo4 = new int[3];
		for (int i = 0; i <= 2; i++) {
			tcNo4[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 10, 27);
		}
		
		String status4 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 17);
		actual[30] = exe.changeStatusOfTestCases(tcNo4, status4);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^testcases should be executed to Pass,Fail,Blocked and WIP$")
public void testcases_should_be_executed_to_Pass_Fail_Blocked_and_WIP() throws Throwable {
    
	try
	{
	int[] tcNo1 = new int[3];
	for (int i = 0; i <= 2; i++) {
		tcNo1[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
	}

	String status1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
	actual[31] =  exe.ValidateStatusOfTestCases(tcNo1, status1);
	
	int[] tcNo2 = new int[3];
	for (int i = 0; i <= 2; i++) {
		tcNo2[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 4, 27);
	}
	
	String status2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
	actual[32] = exe.ValidateStatusOfTestCases(tcNo2, status2);
	

	int[] tcNo3 = new int[3];
	for (int i = 0; i <= 2; i++) {
		tcNo3[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 7, 27);
	}
	
	String status3 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 7, 17);
	actual[33] = exe.ValidateStatusOfTestCases(tcNo3, status3);
	

	int[] tcNo4 = new int[3];
	for (int i = 0; i <= 2; i++) {
		tcNo4[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 10, 27);
	}
	
	String status4 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 17);
	actual[34] = exe.ValidateStatusOfTestCases(tcNo4, status4);
	

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^user navigate to Dashboard page$")
public void user_navigate_to_Dashboard_page() throws Throwable {
	try {
		db = new DashBoardPage(driver);
		actual[35] = db.clickOnManageDashboards();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^Dash_Board page should be displayed$")
public void dash_board_page_should_be_displayed() throws Throwable {
	try {
		actual[36] = db.validateDashboards();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^user create a new dashboard with fields$")
public void user_create_a_new_dashboard_with_fields() throws Throwable {
	try {
		String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 1);
		String desc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 2);
		String layout = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 3);
		String shareType = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 4);

		actual[37] = db.clickOnAddDashBoardSymbol();
		actual[38] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^dashborad should be created Successfully$")
public void dashborad_should_be_created_Successfully() throws Throwable {
	try {
		String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 1);
		actual[39] = db.validateDashBoard(dashboardName);
		actual[40] = db.selectDashboard(dashboardName);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@When("^user add execution backlog gadget,configure and save it$")
public void user_add_execution_backlog_gadget_configure_and_save_it() throws Throwable {
	try {
		String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 5);

		String project = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
		String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		String refreshRate = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 6);
		String filterName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 13);
		String[] values = new String[1];
		values[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 9);
		actual[41] = db.clickOnAddGadgetSymbol();
		actual[42] = db.addGadget(gadgetName);
		actual[43] = db.configureTraceabilityGadget(project, release, refreshRate);

		actual[44] = db.filterBy(filterName, values);
		actual[45] = db.saveGadget();

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^execution backlog gadget should be saved successfully$")
public void execution_backlog_gadget_should_be_saved_successfully() throws Throwable {
	try {
		String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 5);
		actual[46] = db.validateGadget(gadgetName);
		// db.totalGadgetCount(gadgetName);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^user view the space between the execution status bullets displayed$")
public void user_view_the_space_between_the_execution_status_bullets_displayed() throws Throwable {

	try
	{
	List <WebElement> allelements=driver.findElements(By.xpath(db.cell));
	int size_1=allelements.size();
	System.out.println(size_1);
	int[] length=new int[size_1];
	for(int i=0;i<=size_1-1;i++)
	{
		 length[i]=Integer.parseInt((allelements.get(i).getAttribute("x")));
		 System.out.println(length[i]);
		
		
	}
	for(int i=0;i<=size_1-2;i++)
	{
	int space=length[i+1]-length[i];
	System.out.println("Space between the Execution Status bullets-"+space);
	}
	
	 
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
}


@When("^User navigate to Test Execution Page$")
public void user_navigate_to_Test_Execution_Page1() throws Throwable {
	try
	{
		pp.backToProjectPage();
	String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
	String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
	actual[47] = pp.selectProject(projectName);
	actual[48] = pp.selectRelease(releaseName);
	actual[49] = rp.clickOnTestExecution();
    
	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}


@When("^change the execution from WIP status to Custom status$")
public void change_the_execution_from_WIP_status_to_Custom_status() throws Throwable {
	try
	{
//	String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
	String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
//	pp.selectProject(projectName);
//    pp.selectRelease(releaseName);
	//rp.clickOnTestExecution();
	String[] navigation = new String[2];
	navigation[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 43, 5);
	navigation[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 63, 9);
	
	actual[50] = tr.navigateToNode(releaseName, navigation);
	
	int[] tcNo4 = new int[3];
	for (int i = 0; i <= 2; i++) {
		tcNo4[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 10, 27);
	}
	
	String status4 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 17);
	actual[51] = exe.changeStatusOfTestCases(tcNo4, status4);
	

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}

@Then("^execution status should be changed successfully$")
public void execution_status_should_be_changed_successfully() throws Throwable {
    try
    {
    	
    	int[] tcNo4 = new int[3];
    	for (int i = 0; i <= 2; i++) {
    		tcNo4[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 10, 27);
    	}
    	
    	String status4 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 17);
    	actual[52] = exe.ValidateStatusOfTestCases(tcNo4, status4);
    	

		for (int k = 0; k <= actual.length - 1; k++) {
			System.out.println("Actual[" + k + "]=" + actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();

		

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}
}
