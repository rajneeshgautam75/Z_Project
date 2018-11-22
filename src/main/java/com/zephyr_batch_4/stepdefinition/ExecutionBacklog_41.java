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

public class ExecutionBacklog_41 extends LaunchBrowser {

	ProjectPage pp;
	LoginPage lp;
	DashBoardPage db;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exe;

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "ExecutionBacklog_41";

	boolean[] actual = new boolean[47];
	SoftAssert soft = new SoftAssert();

	
	@Given("^Login as lead credential Role$")
	public void login_as_lead_credential_Role() throws Throwable {
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

	@When("^User navigate to test Repository page$")
	public void user_navigate_to_test_Repository_page() throws Throwable {
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

	@When("^create a node with Name and description$")
	public void create_a_node_with_Name_and_description() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String nodeName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 9);
			String nodeDesc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 10);
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

	@Then("^phase should be successfully created$")
	public void phase_should_be_successfully_created() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");

			String[] nodeName = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 9);
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

	@When("^user Add multiple testcases to the phase$")
	public void user_Add_multiple_testcases_to_the_phase() throws Throwable {
		try {
			for (int i = 1; i <= 5; i++) {
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

	@Then("^testcases Should be added Successfully$")
	public void testcases_Should_be_added_Successfully() throws Throwable {
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

	@When("^User navigate to Test Planning Page$")
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

	@When("^create a new Cycle and add phase to cycle,assign it$")
	public void create_a_new_Cycle_and_add_phase_to_cycle_assign_it() throws Throwable {
		try {
			tp = new TestPlanningPage(driver);
			//actual[13] = rp.clickOnTestPlanning();
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 6);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);
			String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 42, 8));
			String smonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 9);
			String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 42, 10));
			String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 42, 11));

			String emonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 12);
			String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 42, 13));

			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 9);

			actual[13] = tp.clickOnAddTestCycleSymbol();
			actual[14] = tp.CreateCycle(cycleName, build, environ, hide);
			actual[15] = tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[16] = tp.saveTestCycle();
			
			actual[17] =bp.waitForElement();
			actual[18] = tp.doubleClickOnCycle(cycleName);
			actual[19] = tp.addPhaseToCycle(phaseName);

			actual[20] = tp.cancelBulkAssign();
			actual[21] = tp.doubleClickOnCycle(phaseName);

			// tp.selectSingleMultipleTestcase(tcNo);
			actual[22] = tp.selectallTestCase();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
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

	@Then("^testcases successfully assign to user$")
	public void testcases_successfully_assign_to_user() throws Throwable {

		try {
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
			int[] tcNo = new int[5];

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

	@When("^User navigate to Test execution Page$")
	public void user_navigate_to_Test_execution_Page() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			actual[25] = rp.clickOnTestExecution();
			String[] navigation = new String[2];
			navigation[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 5);
			navigation[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 9);

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

	@When("^execute all testcases to Status Pass$")
	public void execute_all_testcases_to_Status_Pass() throws Throwable {
		try {
			exe = new ExecutionPage(driver);
			int[] tcNo = new int[5];
			for (int i = 0; i <= 4; i++) {
				tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			actual[27] = exe.changeStatusOfTestCases(tcNo, status);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^testcases successfully executed to Pass Status$")
	public void testcases_successfully_executed_to_Pass_Status() throws Throwable {

		try {
			int[] tcNo = new int[5];
			for (int i = 0; i <= 4; i++) {
				tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);

			actual[28] = exe.ValidateStatusOfTestCases(tcNo, status);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigate to Manage dashboard page$")
	public void user_navigate_to_Manage_dashboard_page() throws Throwable {
		try {
			db = new DashBoardPage(driver);
			actual[29] = db.clickOnManageDashboards();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^dash_board Page Should be displayed$")
	public void dash_board_Page_Should_be_displayed() throws Throwable {
		try {
			actual[30] = db.validateDashboards();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User add a new dashboard with details$")
	public void user_add_a_new_dashboard_with_details() throws Throwable {

		try {
			String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 1);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 2);
			String layout = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 3);
			String shareType = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 4);

			actual[31] = db.clickOnAddDashBoardSymbol();
			actual[32] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^dashboard should_be created Successfully$")
	public void dashboard_should_be_created_Successfully() throws Throwable {
		try {
			String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 1);
			actual[33] = db.validateDashBoard(dashboardName);
			actual[34] = db.selectDashboard(dashboardName);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User add execution backlog gadget and save it$")
	public void user_add_execution_backlog_gadget_and_save_it() throws Throwable {
		try {
			String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 5);

			String project = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 6);
			String filterName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 13);
			String[] values = new String[1];
			values[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 9);
			actual[35] = db.clickOnAddGadgetSymbol();
			actual[36] = db.addGadget(gadgetName);
			actual[37] = db.configureTraceabilityGadget(project, release, refreshRate);

			actual[38] = db.filterBy(filterName, values);
			actual[39] = db.saveGadget();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^execution backlog gadget should be Added successfully$")
	public void execution_backlog_gadget_should_be_Added_successfully() throws Throwable {
		try {
			String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 5);
			actual[40] = db.validateGadget(gadgetName);
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

	@When("^user Navigate to Test Planning Page$")
	public void user_Navigate_to_Test_Planning_Page() throws Throwable {
		try {
			
			pp.backToProjectPage();
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			pp.selectProject(projectName);
			pp.selectRelease(releaseName);
			
			actual[41] = rp.clickOnTestPlanning();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Re-assign the executed testcases from one user to other$")
	public void re_assign_the_executed_testcases_from_one_user_to_other() throws Throwable {
		try {
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 62, 9);
			String assignee = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 16);
			actual[42] = tp.doubleClickOnCycle(phaseName);
			actual[43] = tp.assignPhase();
			tp.doubleClickOnCycle(phaseName);
			actual[44] = tp.selectallTestCase();
			actual[45] = tp.assignAllSelected(assignee);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^testcases should be Re-assign successfully$")
	public void testcases_should_be_Re_assign_successfully() throws Throwable {
		try {
			String assignee = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 42, 16);
			int[] tcNo = new int[5];

			for (int i = 0; i <= tcNo.length - 1; i++) {
				tcNo[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			actual[46] = tp.validateAllAssigned(tcNo, assignee);
			tp.goBackToCycle();
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
