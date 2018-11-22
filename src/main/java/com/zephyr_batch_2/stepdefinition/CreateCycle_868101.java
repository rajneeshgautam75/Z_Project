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

public class CreateCycle_868101 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[72];
	SoftAssert soft = new SoftAssert();
	
	String fileName="CreateCycle_868101";

	@Given("^user is in project page$")
	public void user_is_in_project_page() throws Throwable {
		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");

			actual[0] = pp.selectProject(projectName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across release and create a phase with Name and description$")
	public void click_on_context_menu_across_release_and_create_a_phase_with_Name_and_description() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			rp = new ReleasePage(driver);
			// actual[2]=rp.clickOnTestRep();
			tr = new TestRepositoryPage(driver);
			actual[1] = tr.doubleClickOnRelease(releaseName);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			actual[2] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created first node$")
	public void add_a_test_case_with_name_to_the_created_first_node() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[3] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			actual[4] = tr.navigateToNode(releaseName, phase);

			actual[5] = tr.addTestCase();
			tr.clickOnDetails();
			ctc = new CreateTestCasePage(driver);
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 13);

			actual[6] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be added to the node$")
	public void test_case_should_be_added_to_the_node() throws Throwable {
		try {
			actual[7] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created phase and create a node with Name and description$")
	public void click_on_context_menu_across_created_phase_and_create_a_node_with_Name_and_description()
			throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[8] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			actual[9] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			actual[10] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created second node$")
	public void add_a_test_case_with_name_to_the_created_second_node() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[11] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[2];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			actual[12] = tr.navigateToNode(releaseName, phase);

			actual[13] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 13);
			actual[14] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created second node and create another node with Name and description$")
	public void click_on_context_menu_across_created_second_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[15] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[2];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			actual[16] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			actual[17] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created third node$")
	public void add_a_test_case_with_name_to_the_created_third_node() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[18] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[3];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			actual[19] = tr.navigateToNode(releaseName, phase);

			actual[20] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 13);
			actual[21] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^click on context menu across created third node and create another node with Name and description$")
	public void click_on_context_menu_across_created_third_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[22] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[3];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			actual[23] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			actual[24] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created fourth node$")
	public void add_a_test_case_with_name_to_the_created_fourth_node() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[25] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[4];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			actual[26] = tr.navigateToNode(releaseName, phase);

			actual[27] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 13);
			actual[28] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^click on context menu across created fourth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_fourth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[29] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[4];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			actual[30] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			actual[31] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created fifth node$")
	public void add_a_test_case_with_name_to_the_created_fifth_node() throws Throwable {
		try {

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[32] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[5];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			actual[33] = tr.navigateToNode(releaseName, phase);

			actual[34] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 13);
			actual[35] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^click on context menu across created fifth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_fifth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[36] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[5];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			actual[37] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			actual[38] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created sixth node$")
	public void add_a_test_case_with_name_to_the_created_sixth_node() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[39] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[6];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			actual[40] = tr.navigateToNode(releaseName, phase);

			actual[41] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 13);
			actual[42] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^click on context menu across created sixth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_sixth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[43] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[6];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			actual[44] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			actual[45] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created seventh node$")
	public void add_a_test_case_with_name_to_the_created_seventh_node() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[46] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[7];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			actual[47] = tr.navigateToNode(releaseName, phase);

			actual[48] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 13);
			actual[49] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			bp.waitForElement();
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

	@When("^click on context menu across created seventh node and create another node with Name and description$")
	public void click_on_context_menu_across_created_seventh_node_and_create_another_node_with_Name_and_description()
			throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[50] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[7];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			actual[51] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 12);
			actual[52] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created eighth node$")
	public void add_a_test_case_with_name_to_the_created_eighth_node() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[53] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[8];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			phase[7] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 12);
			actual[54] = tr.navigateToNode(releaseName, phase);

			actual[55] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 13);
			actual[56] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^click on context menu across created eighth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_eighth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[57] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[8];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			phase[7] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 12);
			actual[58] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 32, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 32, 12);
			actual[59] = tr.addNode(phaseName, desc);
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

	@When("^Add a test case with name to the created ninth node$")
	public void add_a_test_case_with_name_to_the_created_ninth_node() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[60] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[9];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			phase[7] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 12);
			phase[8] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 32, 12);
			actual[61] = tr.navigateToNode(releaseName, phase);

			actual[62] = tr.addTestCase();
			tr.clickOnDetails();
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 32, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 32, 13);
			actual[63] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^user Launch test planning$")
	public void user_Launch_test_planning() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[64] = rp.clickOnTestPlanning();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a new test cycle with all available fields$")
	public void create_a_new_test_cycle_with_all_available_fields() throws Throwable {

		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 24, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 24, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 24, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 24, 10));
			tp = new TestPlanningPage(driver);
			tp.clickOnAddTestCycleSymbol();
			actual[65] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[66] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[67] = tp.saveTestCycle();
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

	@When("^click on context menu across created cycle and add a created nested phase by choosing existing phase and save it$")
	public void click_on_context_menu_across_created_cycle_and_add_a_created_nested_phase_by_choosing_existing_phase_and_save_it()
			throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[68] = tp.navigateToCycle(cycle_name1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			actual[69] = tp.addPhaseToCycle(phaseName);

			String bulkAssign = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 15);
			actual[70] = tp.bulkAssignment(bulkAssign);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^nested phase should be added to the test cycle$")
	public void nested_phase_should_be_added_to_the_test_cycle() throws Throwable {

		try {
			String[] phase = new String[9];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 25, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 26, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 27, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 28, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 29, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 30, 12);
			phase[7] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 31, 12);
			phase[8] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 32, 12);

			actual[71] = tp.navigateToCycle(phase);
			bp.waitForElement();
			
			tp.goBackToCycle();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
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

}
