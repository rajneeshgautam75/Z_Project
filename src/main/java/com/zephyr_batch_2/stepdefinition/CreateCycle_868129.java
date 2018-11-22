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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCycle_868129 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;

	boolean[] actual = new boolean[77];
	SoftAssert soft = new SoftAssert();
	
	String fileName="CreateCycle_868129";

	// @Given("^user is in project page$")
	// public void user_is_in_project_page() throws Throwable {
	// try
	// {
	// bp=new BasePage();
	// pp=new ProjectPage(driver);
	//
	// String
	// projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	//
	// actual[0]=pp.selectProject(projectName);
	// }
	// catch(Exception e)
	// {
	// driver.close();
	// Relogin rl=new Relogin();
	// rl.reLogin();
	// throw e;
	// }
	//
	// }

	@When("^User selects the release$")
	public void user_selects_the_release() throws Throwable {
		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);
			actual[0] = bp.waitForElement();
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

	@When("^launch test repository and add a phase with name and description$")
	public void launch_test_repository_and_add_a_phase_with_name_and_description() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			rp = new ReleasePage(driver);
			tr = new TestRepositoryPage(driver);
			actual[2] = rp.clickOnTestRep();

			actual[3] = tr.doubleClickOnRelease(releaseName);

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 12);
			bp.waitForElement();
			actual[4] = tr.addNode(name, desc);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to newly created phase and add a test case with name$")
	public void navigate_to_newly_created_phase_and_add_a_test_case_with_name() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 12);
			actual[5] = tr.navigateToNode(releaseName, phase);
			  bp.waitForElement();
			actual[6] = tr.addTestCase();
			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 13);

			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 13);
			ctc = new CreateTestCasePage(driver);
			tr.clickOnDetails();
			actual[7] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			
		tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be added$")
	public void test_case_should_be_added() throws Throwable {

		try {
			actual[8] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user selects the test case and clone it$")
	public void user_selects_the_test_case_and_clone_it() throws Throwable {
		try {
			ep = new ExportPage(driver);
			String[] testcase = new String[1];
			testcase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 14));
			actual[9] = ep.selectMultipleTestCaseFromGrid(testcase);

			actual[10] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be cloned Sucessfully$")
	public void test_case_should_be_cloned_Sucessfully() throws Throwable {

		try {
			actual[11] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user click on option across release and add a phase with name and description$")
	public void user_click_on_option_across_release_and_add_a_phase_with_name_and_description() throws Throwable {
		try {

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[12] = tr.clickOnRelease(releaseName);

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 12);
			bp.waitForElement();
			actual[13] = tr.addNode(name, desc);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user click on option across release and add another phase with name and description$")
	public void user_click_on_option_across_release_and_add_another_phase_with_name_and_description() throws Throwable {
		try {

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[14] = tr.clickOnRelease(releaseName);

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			bp.waitForElement();
			actual[15] = tr.addNode(name, desc);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on newly created phase and adds a test case with name$")
	public void click_on_newly_created_phase_and_adds_a_test_case_with_name() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			String[] node = new String[1];
			node[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			actual[16] = tr.navigateToNode(releaseName,node);

			actual[17] = tr.addTestCase();

			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 13);
			tr.clickOnDetails();
			  bp.waitForElement();
			actual[18] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^selects the test case and cloned it$")
	public void selects_the_test_case_and_cloned_it() throws Throwable {

		try {
			String[] testcase = new String[1];
			testcase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 14));
			actual[19] = ep.selectMultipleTestCaseFromGrid(testcase);

			actual[20] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be cloned sucessfully$")
	public void test_case_should_be_cloned_sucessfully() throws Throwable {

		try {
			actual[21] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user launch test planning module$")
	public void user_launch_test_planning_module() throws Throwable {

		try {
			actual[22] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^creates test cycle with all available fields and save it$")
	public void creates_test_cycle_with_all_available_fields_and_save_it() throws Throwable {

		try {
			tp = new TestPlanningPage(driver);
			actual[23] = tp.clickOnAddTestCycleSymbol();

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 11);
			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 10));

			actual[24] = tp.CreateCycle(name, build, environment, hide);

			actual[25] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[26] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to created cycle and add a phase by choosing existing phase and assign to anyone and save it$")
	public void navigate_to_created_cycle_and_add_a_phase_by_choosing_existing_phase_and_assign_to_anyone_and_save_it()
			throws Throwable {
		try {

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			actual[27] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			actual[28] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 15);
			actual[29] = tp.bulkAssignment(bulkType);

			bp.waitForElement();
//			actual[30] = rp.clickOnTestPlanning();
			actual[30]=tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^selects the test cycle and cloned it$")
	public void selects_the_test_cycle_and_cloned_it() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			actual[31] = tp.navigateToCycle(cycle);
			String cycle1 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String Build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);

			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			actual[32] = tp.cloneCycle(cycle1, Build, duration, environ, hide, testCaseAssignment);
			tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test cycle should be created with test case unassigned$")
	public void test_cycle_should_be_created_with_test_case_unassigned() throws Throwable {

		try {
			String cycle = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			actual[33] = tp.testCycleCount(cycle);

			//tp.doubleClickOnCycle(cycle);
			bp.waitForElement();
			tp.doubleClickOnClonedCycle(cycle, "2");
			bp.waitForElement();
			////////////////////////////
			String[] cycle2 = new String[1];
			cycle2[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			//cycle2[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			String no = "2";
			actual[34] = tp.navigateToClonedCycle(cycle2, no);
            String phaseName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
            actual[35] = tp.doubleClickOnCycle(phaseName);
			actual[36] = tp.assignPhase();

		// testcase should not be assigned and hence commenting the cancel bulkassign
			//bp.waitForElement();
			//actual[36]=bp.waitForElement();
			//bp.waitForElement();

		    //tp.cancelBulkAssign();
			//bp.waitForElement();
		    bp.waitForElement();
		
			// String
			// pname=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"CreateTestCycle",14,12);
			// actual[36]=tp.getPhaseCount(pname);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

		
	}

	@When("^navigate to test cycle and select clone option and check the testcase assignments over option$")
	public void navigate_to_test_cycle_and_select_clone_option_and_check_the_testcase_assignments_over_option()
			throws Throwable {
		try {
			tp.goBackToCycle();
			actual[37] = rp.clickOnTestPlanning();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			actual[38] = tp.navigateToCycle(cycle);

			String cycle1 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String Build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			actual[39] = tp.cloneCycle(cycle1, Build, duration, environ, hide, testCaseAssignment);

			actual[40] = tp.saveTestCycle();
			bp.waitForElement();
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

	@Then("^test cycle should be created with test case assigned$")
	public void test_cycle_should_be_created_with_test_case_assigned() throws Throwable {
		try {

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 13, 2);
			//cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			String no = "2";

			tp.doubleClickOnClonedCycle(cycle[0], "2");
			actual[41] = tp.navigateToClonedCycle(cycle, no);
			
			
			String phaseNmae= UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			tp.doubleClickOnCycle(phaseNmae);
			
			actual[42] = tp.assignPhase();
			
			
			
			
			// String
			// phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"CreateTestCycle",14,12);
			// tp.getPhaseCount(phaseName);

			String[] cycle3 = new String[1];
			cycle3[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			actual[43] = tp.navigateToCycle(cycle3);

			int[] testcase = new int[2];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 13, 14);
			testcase[1] = Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 14);

			///////////////////////////////////
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[44] = tp.validateAllAssigned(testcase, assignee);
			
			
		} catch (Exception e) {
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user launch test planning and create a test cycle with all fields$")
	public void user_launch_test_planning_and_create_a_test_cycle_with_all_fields() throws Throwable {
		try {
             tp.goBackToCycle();
			actual[45] = rp.clickOnTestPlanning();

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 11);
			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 10));
             bp.waitForElement();
			tp.clickOnAddTestCycleSymbol();
			actual[46] = tp.CreateCycle(name, build, environment, hide);
			actual[47] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[48] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user click on option across cycle and add phase by choosing existing phase$")
	public void user_click_on_option_across_cycle_and_add_phase_by_choosing_existing_phase() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 2);
			actual[49] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 12);
			actual[50] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 15);
			actual[51] = tp.bulkAssignment(bulkType);
			bp.waitForElement();
			tp.goBackToCycle();
			actual[52] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^click on created test cycle and clone it$")
	public void click_on_created_test_cycle_and_clone_it() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 2);
			actual[53] = tp.navigateToCycle(cycle);

			String cycle1 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String Build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			actual[54] = tp.cloneCycle(cycle1, Build, duration, environ, hide, testCaseAssignment);
			actual[55] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test cycle should be cloned with empty phase$")
	public void test_cycle_should_be_cloned_with_empty_phase() throws Throwable {
		try {

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 14, 2);
			actual[56] = tp.navigateToCycle(cycle);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user click on test planning and create a test cycle with all availabe fields$")
	public void user_click_on_test_planning_and_create_a_test_cycle_with_all_availabe_fields() throws Throwable {
		try {
			
			actual[57] = rp.clickOnTestPlanning();

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 11);
			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 15, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 15, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 15, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 15, 10));

			tp.clickOnAddTestCycleSymbol();
			actual[58] = tp.CreateCycle(name, build, environment, hide);
			actual[59] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[60] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on test cycle and add phase by choosing existing phase and assign to anyone$")
	public void click_on_test_cycle_and_add_phase_by_choosing_existing_phase_and_assign_to_anyone() throws Throwable {
		try {

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			actual[61] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
			actual[62] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 15);
			actual[63] = tp.bulkAssignment(bulkType);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		// tp.bulkAssignment(Bulk_type)
	}

	@When("^click on test cycle and add a phase by choosing existing phase and save it and cancel the popup$")
	public void click_on_test_cycle_and_add_a_phase_by_choosing_existing_phase_and_save_it_and_cancel_the_popup()
			throws Throwable {

		try {
			tp.goBackToCycle();
			actual[64] = rp.clickOnTestPlanning();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			actual[65] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 12);
		      bp.waitForElement(); 
			actual[66] = tp.addPhaseToCycle(phase);
              bp.waitForElement(); 
			actual[67] = tp.cancelBulkAssign();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^select the test cycle and clone it$")
	public void select_the_test_cycle_and_clone_it() throws Throwable {

		try {
			tp.goBackToCycle();
			actual[68] = rp.clickOnTestPlanning();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			actual[69] = tp.navigateToCycle(cycle);

			String cycle1 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String Build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);

			actual[70] = tp.cloneCycle(cycle1, Build, duration, environ, hide, testCaseAssignment);
			actual[71] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test cycle should be cloned with same name but test case unassigned$")
	public void test_cycle_should_be_cloned_with_same_name_but_test_case_unassigned() throws Throwable {
		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			actual[72] = tp.navigateToClonedCycle(cycle, "2");
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user selects the test cycle and clone it and select the copy testcase assignments over option$")
	public void user_selects_the_test_cycle_and_clone_it_and_select_the_copy_testcase_assignments_over_option()
			throws Throwable {
		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			actual[73] = tp.navigateToCycle(cycle);

			String cycle1 = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String Build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);
			String environ = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 18);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);

			actual[74] = tp.cloneCycle(cycle1, Build, duration, environ, hide, testCaseAssignment);
			actual[75] = tp.saveTestCycle();
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

	@Then("^new cycle created with same name as before but with testcases assigned in parent cycle$")
	public void new_cycle_created_with_same_name_as_before_but_with_testcases_assigned_in_parent_cycle()
			throws Throwable {
		try {

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 2);
			actual[76] = tp.navigateToClonedCycle(cycle, "2");
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
