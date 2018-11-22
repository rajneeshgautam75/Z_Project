package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878819 extends LaunchBrowser {

	LaunchBrowser lb;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LoginPage lp;

	 String fileName="TestExecution_878819";
	 
	boolean[] actual = new boolean[35];
	SoftAssert soft = new SoftAssert();

	@When("^User add a phase and add two system to phase$")
	public void user_add_a_phase_and_add_two_system_to_phase() throws Throwable {
		try {

			lb=new LaunchBrowser();
			bp = new BasePage();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			tr = new TestRepositoryPage(driver);
			actual[0] = tr.doubleClickOnRelease(releaseName);
			actual[1] = tr.addNode(name, desc);
			bp.waitForElement();

			String[] node=new String[1];
			node[0]=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			actual[2] = tr.navigateToNode(releaseName, node);

			String sysName1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 3);
			String sysDesc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 3);
			actual[3] = tr.addNode(sysName1, sysDesc1);

			bp.waitForElement();
			actual[4] = tr.navigateToNode(releaseName, node);
			String sysName2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 4);
			String sysDesc2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 4);
			actual[5] = tr.addNode(sysName2, sysDesc2);
			bp.waitForElement();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add testcases with teststeps and some testcases without teststeps to phase$")
	public void add_testcases_with_teststeps_and_some_testcases_without_teststeps_to_phase() throws Throwable {
		try {
			String[] node=new String[1];
			node[0]=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			actual[6] =  tr.navigateToNode(releaseName, node);

			actual[7] = tr.addTestCase();
			actual[8] = tr.clickDetailButton();
			bp.waitForElement();
			ctc = new CreateTestCasePage(driver);
			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 14);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 15);
			actual[9] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);

			String[] stepdetail = new String[3];
			int l = 0;
			for (int i = 19; i <= 21; i++) {
				stepdetail[l] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				l++;
			}

			actual[10] = ctc.enterTestCaseStepDetail(stepdetail);
			bp.waitForElement();

			actual[11] = tr.clickOnList();
			bp.waitForElement();
			
			String[] testcase=new String[1];
			testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			ep=new ExportPage(driver);
			actual[12]=ep.selectMultipleTestCaseFromGrid(testcase);

			actual[12] = tr.selectallTestCase();
			bp.waitForElement();
			actual[13] = tr.cloneTestCase();

			for (int i = 1; i <= 3; i++) {
				actual[14] = tr.addTestCase();
			}

			actual[15] = tr.verifyPresentTestCase();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a new cycle and add phase to cycle and assign testcases to lead$")
	public void create_a_new_cycle_and_add_phase_to_cycle_and_assign_testcases_to_lead() throws Throwable {
		try {

			tp = new TestPlanningPage(driver);

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 21, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 21, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 21, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 21, 13));

			actual[16] = tp.clickOnAddTestCycleSymbol();

			actual[17] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[18] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[19] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 5);
			actual[20] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			actual[21] = tp.addPhaseToCycle(phase);

			actual[22] = tp.cancelBulkAssign();

			String[] cyclePhase = new String[1];
			cyclePhase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			actual[23] = tp.navigateToCycle(cyclePhase);

			actual[24] = tp.selectallTestCase();
			
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[25] = tp.assignAllSelected(assignee);
			
			rp=new ReleasePage(driver);
			//rp.clickOnTestPlanning();
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

	@When("^Lauch test case execution page and enable the version in TCE page$")
	public void lauch_test_case_execution_page_and_enable_the_version_in_TCE_page() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			actual[26] = rp.clickOnTestExecution();
            bp.waitForElement();
			String[] cycle = new String[2];
			String release = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 5);
			cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 2);
			actual[27] = tr.navigateToNode(release, cycle);
            bp.waitForElement();
			exp = new ExecutionPage(driver);
			String[] sortName = new String[1];
			sortName[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 29);
			actual[28] = exp.sort(sortName);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^execute the testcase without the teststeps and check the version in TCE and Check the Version$")
	public void execute_the_testcase_without_the_teststeps_and_check_the_version_in_TCE_and_Check_the_Version()
			throws Throwable {
		try {

			String status1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			String status2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
			int[] testcase = new int[2];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 3, 27);
			testcase[1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 4, 27);
			actual[29] = exp.executeStatus(testcase[0], status1);
			actual[30] = exp.executeStatus(testcase[1], status2);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^version will not show for testcases without test steps$")
	public void version_will_not_show_for_testcases_without_test_steps() throws Throwable {
		try {

			String version = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 29);
			int[] testcase = new int[2];

			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 3, 27);
			testcase[1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 4, 27);
			actual[31] = exp.checkVersionInList(testcase, version);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^execute the testcase with teststeps and check the version in TCE and Check the Version$")
	public void execute_the_testcase_with_teststeps_and_check_the_version_in_TCE_and_Check_the_Version()
			throws Throwable {
		try {

			String status1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			String status2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
			int[] testcase = new int[2];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			testcase[1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 2, 27);
			actual[32] = exp.executeStatus(testcase[0], status1);
			actual[33] = exp.executeStatus(testcase[1], status2);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^version will reflect for testcase with test steps$")
	public void version_will_reflect_for_testcase_with_test_steps() throws Throwable {
		try {

			String version = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 21, 29);
			int[] testcase = new int[2];

			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			testcase[1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 2, 27);
			actual[34] = exp.checkVersionInList(testcase, version);
			
			String release= Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			tp.doubleClickOnCycle(release);

			for (int k = 0; k <= actual.length - 1; k++) {
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
