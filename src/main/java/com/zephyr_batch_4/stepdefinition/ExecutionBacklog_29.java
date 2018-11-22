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

public class ExecutionBacklog_29 extends LaunchBrowser {

	ProjectPage pp;
	LoginPage lp;
	DashBoardPage db;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exe;

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "ExecutionBacklog_29";

	boolean[] actual = new boolean[45];
	SoftAssert soft = new SoftAssert();

	@Given("^Login as Lead credential$")
	public void login_as_Lead_credential() throws Throwable {
		try {
			pp = new ProjectPage(driver);
			lp = new LoginPage(driver);
			bp = new BasePage();

			String userName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Username_1");
			String passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Password_1");

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

	@When("^user navigate to release setup page$")
	public void user_navigate_to_release_setup_page() throws Throwable {
		try {
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			// String
			// releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,
			// "Release_12");

			pp.selectProject(projectName);
			rp = new ReleasePage(driver);
			actual[4] = pp.clickOnManageRelease();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a new release$")
	public void create_a_new_release() throws Throwable {

		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			boolean res = rp.checkAvailableRelease(releaseName);
			if (res == false) {
				// String releaseName=Excel_Lib.getData(INPUT_PATH_2,
				// "Releases", 2,0);
				String Hide = Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 100, 100);
				String Desc = Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 100, 100);
				String MapexternalDefect = Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 100, 100);
				rp.addNewRelease(releaseName, Desc, Hide, MapexternalDefect);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 11));
				String smonth = Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 12);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 13));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 14));
				String emonth = Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 15);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 16));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				// rp.enterStartDatAndEndDate(syear, smonth, sday, eyear,
				// emonth, eday);
				rp.clickOnAdd();

				rp.addNewRelease(releaseName, Desc, Hide, MapexternalDefect);

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

	@When("^navigate to test repository Page$")
	public void navigate_to_test_repository_Page() throws Throwable {

		try {
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			pp.selectProject(projectName);
			pp.selectRelease(releaseName);

			actual[5] = rp.clickOnTestRep();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a node with name and desc$")
	public void create_a_node_with_name_and_desc() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			String nodeName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 9);
			String nodeDesc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 10);
			actual[6] = tr.clickOnRelease(releaseName);

			actual[7] = tr.addNode(nodeName, nodeDesc);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^node should be successfully created$")
	public void node_should_be_successfully_created() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");

			String[] nodeName = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 9);
			actual[8] = tr.navigateToNode(releaseName, nodeName);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user add a testcase to the node$")
	public void user_add_a_testcase_to_the_node() throws Throwable {
		try {
			for (int i = 1; i <= 5; i++) {
				actual[9] = tr.addTestCase();
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

	@Then("^testcase should be added successfully$")
	public void testcase_should_be_added_successfully() throws Throwable {
		try {
			actual[10] = tr.verifyPresentTestCase();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user navigate to test Planning page$")
	public void user_navigate_to_test_Planning_page() throws Throwable {
		try {
			actual[11] = rp.clickOnTestPlanning();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a new cycle and add phase to cycle and assign testcases to user$")
	public void create_a_new_cycle_and_add_phase_to_cycle_and_assign_testcases_to_user() throws Throwable {
		try {
			tp = new TestPlanningPage(driver);
			actual[12] = rp.clickOnTestPlanning();
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 40, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 40, 6);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 40, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);
			String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 40, 8));
			String smonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 40, 9);
			String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 40, 10));
			String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 40, 11));

			String emonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 40, 12);
			String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 40, 13));

			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 9);

			actual[13] = tp.clickOnAddTestCycleSymbol();
			actual[14] = tp.CreateCycle(cycleName, build, environ, hide);
			actual[15] = tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[16] = tp.saveTestCycle();

			actual[17] = tp.doubleClickOnCycle(cycleName);
			actual[18] = tp.addPhaseToCycle(phaseName);

			actual[19] = tp.cancelBulkAssign();
			actual[20] = tp.doubleClickOnCycle(phaseName);

			// tp.selectSingleMultipleTestcase(tcNo);
			actual[21] = tp.selectallTestCase();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
			actual[22] = tp.assignAllSelected(assignee);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^testcases successfully assigned to user$")
	public void testcases_successfully_assigned_to_user() throws Throwable {

		try {
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
			int[] tcNo = new int[5];

			for (int i = 0; i <= tcNo.length - 1; i++) {
				tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			actual[23] = tp.validateAllAssigned(tcNo, assignee);
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

	@When("^user navigate to test execution Page$")
	public void user_navigate_to_test_execution_Page() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			actual[24] = rp.clickOnTestExecution();
			String[] navigation = new String[2];
			navigation[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 40, 5);
			navigation[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 9);

			actual[25] = tr.navigateToNode(releaseName, navigation);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^execute the testcase to Pass$")
	public void execute_the_testcase_to_Pass() throws Throwable {
		try {
			exe = new ExecutionPage(driver);
			int[] tcNo = new int[5];
			for (int i = 0; i <= 4; i++) {
				tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			actual[26] = exe.changeStatusOfTestCases(tcNo, status);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^testacase executed to Pass status$")
	public void testacase_executed_to_Pass_status() throws Throwable {

		try {
			int[] tcNo = new int[5];
			for (int i = 0; i <= 4; i++) {
				tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);

			actual[27] = exe.ValidateStatusOfTestCases(tcNo, status);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user click on dashboard page$")
	public void user_click_on_dashboard_page() throws Throwable {
		try {
			db = new DashBoardPage(driver);
			actual[28] = db.clickOnManageDashboards();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Dashboard page should be visible$")
	public void dashboard_page_should_be_visible() throws Throwable {
		try {
			actual[29] = db.validateDashboards();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user add a new Dashboard with details$")
	public void user_add_a_new_Dashboard_with_details() throws Throwable {

		try {
			String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 1);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 2);
			String layout = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 3);
			String shareType = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 4);

			actual[30] = db.clickOnAddDashBoardSymbol();
			actual[31] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		} catch (Exception e) 
		
		{
           lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^dashboad should be created successfully$")
	public void dashboad_should_be_created_successfully() throws Throwable {

		String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 1);
		actual[32] = db.validateDashBoard(dashboardName);
		actual[33] = db.selectDashboard(dashboardName);
	}

	@When("^user add Executions Backlog Gadget and save it$")
	public void user_add_Executions_Backlog_Gadget_and_save_it() throws Throwable {

		try {
			String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 5);

			String project = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 6);
			String filterName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 13);
			String[] values = new String[1];
			values[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 9);
			actual[34] = db.clickOnAddGadgetSymbol();
			actual[35] = db.addGadget(gadgetName);
			actual[36] = db.configureTraceabilityGadget(project, release, refreshRate);

			actual[37] = db.filterBy(filterName, values);
			actual[38] = db.saveGadget();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^Executions Backlog Gadget should be added successfully$")
	public void executions_Backlog_Gadget_should_be_added_successfully() throws Throwable {
		try {
			String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 60, 5);
			actual[39] = db.validateGadget(gadgetName);
			
			pp.backToProjectPage();
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

	@When("^user navigate to release Setup page$")
	public void user_navigate_to_release_Setup_page() throws Throwable {
		try {	
			String projectName2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_2");
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			// String
			// releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,
			// "Release_12");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			pp.selectProject(projectName);
			pp.selectRelease(releaseName);
			actual[40] = pp.selectProject(projectName2);
			actual[41] = pp.selectProject(projectName);
			pp.selectRelease(releaseName);
			pp.selectProject(projectName);
			actual[42] = pp.clickOnManageRelease();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^delete the current release$")
	public void delete_the_current_release() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			actual[43] = pp.deleteRelease(releaseName);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^should be able to delete the release$")
	public void should_be_able_to_delete_the_release() throws Throwable {

		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_12");
			actual[44] = rp.checkAvailableRelease(releaseName);

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println("Actual[" + k + "]=" + actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
			
			pp=new ProjectPage(driver);
			pp.backToProjectPage();

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
