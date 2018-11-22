package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCycle_868158 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[64];
	SoftAssert soft = new SoftAssert();
	
	 String fileName="CreateCycle_868158";

	@Given("^User selects the project and release$")
	public void user_selects_the_project_and_release() throws Throwable {
		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");

			actual[0] = pp.selectProject(projectName);

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[1] = pp.selectRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User navigates to test planning module$")
	public void user_navigates_to_test_planning_module() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[2] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on create new test cycle symbol$")
	public void click_on_create_new_test_cycle_symbol() throws Throwable {
		try {
			tp = new TestPlanningPage(driver);
			actual[3] = tp.clickOnAddTestCycleSymbol();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^create test cycle page should be displayed$")
	public void create_test_cycle_page_should_be_displayed() throws Throwable {
		try {
			actual[4] = tp.verifyAddTestCyclePage();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user enters the data for all fields and check hide option and save it$")
	public void user_enters_the_data_for_all_fields_and_check_hide_option_and_save_it() throws Throwable {
		try {

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 33, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 33, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 33, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 33, 10));

			actual[5] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[6] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[7] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to created cycle and uncheck the hide option and save it$")
	public void navigate_to_created_cycle_and_uncheck_the_hide_option_and_save_it() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 2);
			actual[8] = tp.navigateToCycle(cycle);

			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 111, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 11);
			actual[9] = tp.editCycle(cycleName, build, environment, hide);
			actual[10] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to modified cycle and delete it$")
	public void navigate_to_modified_cycle_and_delete_it() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 2);
			actual[11] = tp.navigateToCycle(cycle);

			tp.deleteNode();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test cycle should be deleted successfully$")
	public void test_cycle_should_be_deleted_successfully() throws Throwable {
		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 2);
			actual[12] = tp.validateDeletedCycle(cycleName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user launch test repository$")
	public void user_launch_test_repository() throws Throwable {

		try {
			actual[13] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^add a phase to the release and add test case to the phase$")
	public void add_a_phase_to_the_release_and_add_test_case_to_the_phase() throws Throwable {
		try {

			tr = new TestRepositoryPage(driver);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 12);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			tr.doubleClickOnRelease(releaseName);
			actual[14] = tr.addNode(phaseName, desc);
			bp.waitForElement();

			actual[15] = tr.addTestCase();
			actual[16] = tr.addTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be added successfully$")
	public void test_case_should_be_added_successfully() throws Throwable {

		try {
			actual[17] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigates to the test planning page$")
	public void user_navigates_to_the_test_planning_page() throws Throwable {

		try {
			actual[18] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^creates a new cycle and add created phase to the cycle and choose option assign to anyone and save it$")
	public void creates_a_new_cycle_and_add_created_phase_to_the_cycle_and_choose_option_assign_to_anyone_and_save_it()
			throws Throwable {

		try {
			actual[19] = tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 34, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 34, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 34, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 34, 10));

			System.out.println(endDateDay);
			actual[20] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[21] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			bp.waitForElement();
			actual[22] = tp.saveTestCycle();
			bp.waitForElement();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 2);
			tp.navigateToCycle(cycle);

			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 12);
			actual[23] = tp.addPhaseToCycle(phaseName);
			String bulkAssign = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 15);
			actual[24] = tp.bulkAssignment(bulkAssign);

			bp.waitForElement();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on created cycle and check the hide option,save it and delete it$")
	public void click_on_created_cycle_and_check_the_hide_option_save_it_and_delete_it() throws Throwable {
		try {
			tp.goBackToCycle();
			actual[25] = rp.clickOnTestPlanning();

			String[] cycle1 = new String[1];
			cycle1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 2);
			tp.navigateToCycle(cycle1);

			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 11);

			actual[26] = tp.editCycle(cycleName, build, environment, hide);
			actual[27] = tp.saveTestCycle();
           bp.waitForElement();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 2);
			actual[28] = tp.navigateToCycle(cycle);

			actual[29] = tp.deleteNode();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^hidden cycle should be deleted successfully$")
	public void hidden_cycle_should_be_deleted_successfully() throws Throwable {
		try {

			String cycle = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 2);
			actual[30] = tp.validateDeletedCycle(cycle);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigates to the test repository page$")
	public void user_navigates_to_the_test_repository_page() throws Throwable {

		try {
			actual[31] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^creates a multiple phase to the release and add test case to each phase$")
	public void creates_a_multiple_phase_to_the_release_and_add_test_case_to_each_phase() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[32] = tr.doubleClickOnRelease(releaseName);
			String nodeName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 12);
			String desc1 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 12);
			actual[33] = tr.addNode(nodeName1, desc1);

			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 12);
			actual[34] = tr.navigateToNode(releaseName, node1);

			actual[35] = tr.addTestCase();
			actual[36] = tr.addTestCase();

			actual[37] = tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[38] = tr.doubleClickOnRelease(releaseName);
			String nodeName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 12);
			String desc2 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 12);
			actual[39] = tr.addNode(nodeName2, desc2);
			bp.waitForElement();

			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();

			String[] node2 = new String[1];
			node2[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 12);
			actual[40] = tr.navigateToNode(releaseName, node2);

			actual[41] = tr.addTestCase();
			actual[42] = tr.addTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^launch test planing page$")
	public void launch_test_planing_page() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[43] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^creates a new cycle by entering all fields and save it$")
	public void creates_a_new_cycle_by_entering_all_fields_and_save_it() throws Throwable {
		try {
			actual[44] = tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 35, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 35, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 35, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 35, 10));

			actual[45] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[46] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[47] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add multiple phase to to the cycle and assign the few testcase$")
	public void add_multiple_phase_to_to_the_cycle_and_assign_the_few_testcase() throws Throwable {

		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 2);
			tp.navigateToCycle(nodeName);

			String phaseName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 12);
			actual[48] = tp.addPhaseToCycle(phaseName1);
			String bulkAssign = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 33, 15);
			actual[49] = tp.bulkAssignment(bulkAssign);

			bp.waitForElement();
			bp.waitForElement();

			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 34, 12);
			// phase[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 35, 12);
			actual[50] = tp.navigateToCycle(phase);

			int[] testCase = new int[2];
			testCase[0] = (Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 14));
			testCase[1] = (Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 14));

			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[51] = tp.individualAssinTo(testCase, assignee);

			tp.goBackToCycle();
			actual[52] = rp.clickOnTestPlanning();
			

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 2);
			actual[53] = tp.navigateToCycle(cycle);

			String phaseName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 12);
			actual[54] = tp.addPhaseToCycle(phaseName2);

			actual[55] = tp.bulkAssignment(bulkAssign);

			bp.waitForElement();
			String[] phase2 = new String[1];
			phase2[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 12);
			actual[56] = tp.navigateToCycle(phase2);

			actual[57] = tp.individualAssinTo(testCase, assignee);
			bp.waitForElement();
			tp.goBackToCycle();
			//rp.clickOnTestPlanning();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^navigates to the test planning page and selects the created cycle$")
	public void navigates_to_the_test_planning_page_and_selects_the_created_cycle() throws Throwable {
		try {
			actual[58] = rp.clickOnTestPlanning();
			
			

			String cycleName[] = new String[1];
			cycleName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 2);

			actual[59] = tp.navigateToCycle(cycleName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^check the hide option and delete the test cycle$")
	public void check_the_hide_option_and_delete_the_test_cycle() throws Throwable {

		try {
			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 11);

			actual[60] = tp.editCycle(cycleName, build, environment, hide);

			tp.saveTestCycle();

			String cycleName1[] = new String[1];
			cycleName1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 2);

			actual[61] = tp.navigateToCycle(cycleName1);

			actual[62] = tp.deleteNode();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^hidden Test cycle should be deleted successfully$")
	public void hidden_Test_cycle_should_be_deleted_successfully() throws Throwable {
		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 35, 2);

			actual[63] = tp.validateDeletedCycle(cycleName);
			bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}
}
