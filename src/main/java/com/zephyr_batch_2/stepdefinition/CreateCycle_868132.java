package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCycle_868132 extends LaunchBrowser {
	LaunchBrowser lb;

	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;

	TestPlanningPage tp;
	ExportPage ep;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[45];
	SoftAssert soft = new SoftAssert();
	
	 String fileName="CreateCycle_868132";

	@Given("^User is in the test repository page of normal project$")
	public void user_is_in_the_test_repository_page_of_normal_project() throws Throwable {

		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[0] = pp.selectProject(projectName);

			actual[1] = pp.selectRelease(releaseName);

			rp = new ReleasePage(driver);
			actual[2] = rp.clickOnTestRep();
		}

		catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user Add a first phase with name and description$")
	public void user_Add_a_first_phase_with_name_and_description() throws Throwable {

		try {
			tr = new TestRepositoryPage(driver);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[3] = tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 12);

			actual[4] = tr.addNode(name, desc);
			actual[5] = tr.doubleClickOnRelease(releaseName);
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

	@When("^navigates to the created first node and add a test case with name$")
	public void navigates_to_the_created_first_node_and_add_a_test_case_with_name() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 12);
			actual[6] = tr.navigateToNode(releaseName, node1);

			actual[7] = tr.addTestCase();
			
			tr.clickDetailButton();
			
			ctc = new CreateTestCasePage(driver);
			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 13);
			actual[8] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^selects the test case and clone it$")
	public void selects_the_test_case_and_clone_it() throws Throwable {

		try {
			ep = new ExportPage(driver);

			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 44, 14));
			actual[9] = ep.selectMultipleTestCaseFromGrid(testCase);

			actual[10] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be cloned successfully$")
	public void test_case_should_be_cloned_successfully() throws Throwable {

		try {
			actual[11] = tr.verifyPresentTestCase();
			
			tr.clickOnList();
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

	@When("^user creates second node with name and description$")
	public void user_creates_second_node_with_name_and_description() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[12] = tr.clickOnRelease(releaseName);

			String name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 12);
			String desc2 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 12);
			actual[13] = tr.addNode(name2, desc2);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
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

	@When("^navigates to the created second node and add a test case with name$")
	public void navigates_to_the_created_second_node_and_add_a_test_case_with_name() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 12);
			actual[14] = tr.navigateToNode(releaseName, node1);

			actual[15] = tr.addTestCase();
			
			tr.clickDetailButton();
			ctc = new CreateTestCasePage(driver);
			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 13);
			actual[16] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^Test Case Should be cloned Sucessfully$")
	public void test_Case_Should_be_cloned_Sucessfully() throws Throwable {

		try {
			actual[17] = tr.verifyPresentTestCase();
			
			tr.clickOnList();
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

	@When("^user launch test planning module and create a new cycle with all available fields and save it$")
	public void user_launch_test_planning_module_and_create_a_new_cycle_with_all_available_fields_and_save_it()
			throws Throwable {
		try {
			actual[18] = rp.clickOnTestPlanning();
			tp = new TestPlanningPage(driver);
			// tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 44, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 44, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 44, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 44, 10));
			// tp=new TestPlanningPage(driver);
			actual[19] = tp.clickOnAddTestCycleSymbol();
			actual[20] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[21] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[22] = tp.saveTestCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the created cycle and add first phase and choose assign to anyone and save it$")
	public void navigate_to_the_created_cycle_and_add_first_phase_and_choose_assign_to_anyone_and_save_it()
			throws Throwable {

		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[23] = tp.navigateToCycle(cycle_name1);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 12);
			actual[24] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 15);
			actual[25] = tp.bulkAssignment(bulkType);
			bp.waitForElement();
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

	@When("^navigate to the created cycle and delete it$")
	public void navigate_to_the_created_cycle_and_delete_it() throws Throwable {
		try {
            tp.goBackToCycle();
			actual[26] = rp.clickOnTestPlanning();
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[27] = tp.navigateToCycle(cycle_name1);
			actual[28] = tp.deleteNode();
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

	@Then("^test cycle should be deleted sucessfully$")
	public void test_cycle_should_be_deleted_sucessfully() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 2);
			actual[29] = tp.validateDeletedCycle(cycle_name);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user launch test planning and creates a second test cycle with all available fields and save it$")
	public void user_launch_test_planning_and_creates_a_second_test_cycle_with_all_available_fields_and_save_it()
			throws Throwable {
		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 45, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 45, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 45, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 45, 10));
			// tp=new TestPlanningPage(driver);
			actual[30] = tp.clickOnAddTestCycleSymbol();
			actual[31] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[32] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[33] = tp.saveTestCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the created second cycle and add first phase and choose assign to anyone and save it$")
	public void navigate_to_the_created_second_cycle_and_add_first_phase_and_choose_assign_to_anyone_and_save_it()
			throws Throwable {

		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[34] = tp.navigateToCycle(cycle_name1);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 12);
			actual[35] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 15);
			actual[36] = tp.bulkAssignment(bulkType);
			
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

	@When("^navigate to the created second cycle and add second phase and choose assign to anyone and save it$")
	public void navigate_to_the_created_second_cycle_and_add_second_phase_and_choose_assign_to_anyone_and_save_it()
			throws Throwable {
		try {
			tp.goBackToCycle();
			rp.clickOnTestPlanning();
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[37] = tp.navigateToCycle(cycle_name1);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 12);
			actual[38] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 15);
			actual[39] = tp.bulkAssignment(bulkType);
			bp.waitForElement();
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

	@When("^navigate to the created second cycle and add first phase and cancel the assign popup window$")
	public void navigate_to_the_created_second_cycle_and_add_first_phase_and_cancel_the_assign_popup_window()
			throws Throwable {
		try {
			rp.clickOnTestPlanning();
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[40] = tp.navigateToCycle(cycle_name1);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 44, 12);
			actual[41] = tp.addPhaseToCycle(phase);
			tp.cancelBulkAssign();
			bp.waitForElement();
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

	@When("^navigate to the second cycle and delete it$")
	public void navigate_to_the_second_cycle_and_delete_it() throws Throwable {
		try {
			rp.clickOnTestPlanning();
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[42] = tp.navigateToCycle(cycle_name1);

			actual[43] = tp.deleteNode();
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

	@Then("^test cycle should be deleted with multiple phases$")
	public void test_cycle_should_be_deleted_with_multiple_phases() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 45, 2);

			actual[44] = tp.validateDeletedCycle(cycle_name);
			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
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
