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

public class TestExexution_878823 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;

	 String fileName="TestExexution_878823";
	boolean[] actual = new boolean[48];
	SoftAssert soft = new SoftAssert();

	@When("^User Creates a phase and adds two system in the phase$")
	public void user_Creates_a_phase_and_adds_two_system_in_the_phase() throws Throwable {
		try {
			lb=new LaunchBrowser();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);

			tr = new TestRepositoryPage(driver);
			bp = new BasePage();
			bp.waitForElement();
			actual[0] = tr.doubleClickOnRelease(releaseName);
			// bp.waitForElement();
			//bp.waitForElement();
			actual[1] = tr.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			String[] node = new String[1];
			node[0] = p_Name1;
			actual[2] = tr.navigateToNode(releaseName, node);

			String s_Name1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 3);
			String s_Desc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 3);
			actual[3] = tr.addNode(s_Name1, s_Desc1);

			tr.doubleClickOnRelease(releaseName);

			String nodes[] = new String[1];
			nodes[0] = p_Name1;

			actual[4] = tr.navigateToNode(releaseName, nodes);

			String p_Name2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 4);
			String p_Desc_2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 4);
			actual[5] = tr.addNode(p_Name2, p_Desc_2);

			actual[6] = tr.doubleClickOnRelease(releaseName);
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

	@When("^create ten testcase to all the node$")
	public void create_ten_testcase_to_all_the_node() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			String[] node = new String[2];
			node[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);
			node[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 3);
			actual[7] = tr.navigateToNode(releaseName, node);

			for (int i = 1; i <= 10; i++) {
				actual[8] = tr.addTestCase();
			}
			String p_Name1 = node[0];
			actual[9] = tr.selectPhase(p_Name1);
			for (int i = 1; i <= 10; i++) {
				actual[10] = tr.addTestCase();
			}
			String p_Name2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 4);
			actual[11] = tr.selectPhase(p_Name2);
			for (int i = 1; i <= 10; i++) {
				actual[12] = tr.addTestCase();
			}
		}

		catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Enters the step details to testcase$")
	public void enters_the_step_details_to_testcase() throws Throwable {
		try {
			ep = new ExportPage(driver);
			String[] testcase = new String[1];
			testcase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[13] = ep.selectMultipleTestCaseFromGrid(testcase);
			bp.waitForElement();
			actual[14] = tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetail = new String[3];
			int k = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				k++;
			}
			ctc = new CreateTestCasePage(driver);

			actual[15] = ctc.enterTestCaseStepDetail(stepDetail);

			bp.waitForElement();
			actual[16] = tr.clickOnList();
			bp.waitForElement();
			bp.waitForElement();

			String p_Name1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 3);
			tr.selectPhase(p_Name1);

			actual[17] = ep.selectMultipleTestCaseFromGrid(testcase);
			bp.waitForElement();
			actual[18] = tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails = new String[3];
			int l = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetails[l] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				l++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[19] = ctc.enterTestCaseStepDetail(stepDetails);

			bp.waitForElement();
			actual[20] = tr.clickOnList();
			bp.waitForElement();
			String p_Name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);
			actual[21] = tr.selectPhase(p_Name);

			actual[22] = ep.selectMultipleTestCaseFromGrid(testcase);
			bp.waitForElement();
			actual[23] = tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetail2 = new String[3];
			int m = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail2[m] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				m++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[24] = ctc.enterTestCaseStepDetail(stepDetail2);
			bp.waitForElement();
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on test planning module$")
	public void click_on_test_planning_module() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[25] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^creates a cycle and add phase to the cycle$")
	public void creates_a_cycle_and_add_phase_to_the_cycle() throws Throwable {
		try {
			
		
			
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 5);

			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 6);

			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 99);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "TestExecution", 5, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 9);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "TestExecution", 5, 10));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "TestExecution", 5, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 12);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "TestExecution", 5, 13));
			tp = new TestPlanningPage(driver);
			actual[26] = tp.clickOnAddTestCycleSymbol();
			actual[27] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[28] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[29] = tp.saveTestCycle();
			bp.waitForElement();

			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 5);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[30] = tp.navigateToCycle(cycle_name1);

			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);
			actual[31] = tp.addPhaseToCycle(p_Name1);
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^cancel the bulk assignment popup after adding phase to cycle$")
	public void cancel_the_bulk_assignment_popup_after_adding_phase_to_cycle() throws Throwable {
		try {
			actual[32] = tp.cancelBulkAssign();
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^assign all not executed test case to test manager by bulk assignement window$")
	public void assign_all_not_executed_test_case_to_test_manager_by_bulk_assignement_window() throws Throwable {

		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[33] = tp.navigateToCycle(cycle_name1);

			String check = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 26);
			actual[34] = tp.bulkAssignTestcasesSelectedFolder();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[35] = tp.assignAllNotexecuted(assignee, check);

		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test cases should be assigned to test manager$")
	public void test_cases_should_be_assigned_to_test_manager() throws Throwable {
		try {
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			int[] testcase = new int[4];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14);
			testcase[1] = Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 2, 14);
			testcase[2] = Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 3, 14);
			testcase[3] = Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 4, 14);
			actual[36] = tp.validateAllAssigned(testcase, assignee);
			pp = new ProjectPage(driver);
			pp.clickOnLogout();
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^login as manager$")
	public void login_as_manager() throws Throwable {
		try {
			lp = new LoginPage(driver);
			pp = new ProjectPage(driver);
			String uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Username_1");
			String password = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Password_1");

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			actual[37] = lp.enterUnameAndPassword(uname, password);
			actual[38] = pp.selectProject(projectName);
			actual[39] = pp.selectRelease(releaseName);
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on test execution module and navigate to phase$")
	public void click_on_test_execution_module_and_navigate_to_phase() throws Throwable {
		try {
			actual[40] = rp.clickOnTestExecution();
			bp.waitForElement();
			String[] nodes = new String[4];
			nodes[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			nodes[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 5);

			nodes[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 2);
			nodes[3] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 3);

			actual[41] = tp.navigateToCycle(nodes);
			actual[42] = tr.selectPhase(nodes[2]);
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^view the test case count of phase$")
	public void view_the_test_case_count_of_phase() throws Throwable {
		try {
			actual[43] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigates to the system$")
	public void user_navigates_to_the_system() throws Throwable {
		try {

			String sys1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 3);
			actual[44] = tr.selectPhase(sys1);
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^view the test case count of system$")
	public void view_the_test_case_count_of_system() throws Throwable {
		try {
			actual[45] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigates to the subsystem$")
	public void user_navigates_to_the_subsystem() throws Throwable {
		try {
			String sys2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 4);
			actual[46] = tr.selectPhase(sys2);
		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^view the test case count of subsystem$")
	public void view_the_test_case_count_of_subsystem() throws Throwable {
		try {
			actual[47] = tr.verifyPresentTestCase();
			
			String release=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			tp.doubleClickOnCycle(release);

			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		} catch (Exception e) {
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
