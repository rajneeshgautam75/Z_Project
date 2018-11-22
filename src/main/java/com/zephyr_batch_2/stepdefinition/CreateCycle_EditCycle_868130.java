package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;
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

public class CreateCycle_EditCycle_868130 extends LaunchBrowser {

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[106];
	SoftAssert soft = new SoftAssert();

	String fileName="CreateCycle_EditCycle_868130";
	
	@Given("^User selects the normal project and release$")
	public void user_selects_the_normal_project_and_release() throws Throwable {
		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[0] = pp.selectProject(projectName);
			actual[1] = pp.selectRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^User click on test repository page$")
	public void user_click_on_test_repository_page() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[2] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across release and creates a phase with Name and description$")
	public void click_on_context_menu_across_release_and_creates_a_phase_with_Name_and_description() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			tr = new TestRepositoryPage(driver);
			tr.doubleClickOnRelease(releaseName);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			actual[3] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add a test case with name to the created first node and clone it$")
	public void add_a_test_case_with_name_to_the_created_first_node_and_clone_it() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[4] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			actual[5] = tr.navigateToNode(releaseName, phase);

			actual[6] = tr.addTestCase();
			tr.clickOnDetails();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 13);
			String testCaseDesc = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 13);
			actual[7] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
tr.clickOnList();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[8] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[9] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be cloned to the node$")
	public void test_case_should_be_cloned_to_the_node() throws Throwable {

		try {
			actual[10] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created phase and create a another node with Name and description$")
	public void click_on_context_menu_across_created_phase_and_create_a_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[11] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			actual[12] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			actual[13] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Add a test case with name to the created second node and clone it$")
	public void add_a_test_case_with_name_to_the_created_second_node_and_clone_it() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[14] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[2];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			actual[15] = tr.navigateToNode(releaseName, phase);

			actual[16] = tr.addTestCase();
			tr.clickOnDetails();
			
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 13);
			actual[17] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
tr.clickOnList();
bp.waitForElement();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[18] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[19] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be cloned to the second node$")
	public void test_case_should_be_cloned_to_the_second_node() throws Throwable {
		try {
			actual[20] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created Second node and create another node with Name and description$")
	public void click_on_context_menu_across_created_Second_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[21] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[2];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);

			actual[22] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			actual[23] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add a test case with name to the created third node and clone it$")
	public void add_a_test_case_with_name_to_the_created_third_node_and_clone_it() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[24] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[3];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);

			actual[25] = tr.navigateToNode(releaseName, phase);

			actual[26] = tr.addTestCase();
			tr.clickOnDetails();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 13);
			actual[27] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
   tr.clickOnList();
   bp.waitForElement();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[28] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[29] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be cloned to the third node$")
	public void test_case_should_be_cloned_to_the_third_node() throws Throwable {
		try {
			actual[30] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created Third node and create another node with Name and description$")
	public void click_on_context_menu_across_created_Third_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[31] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[3];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);

			actual[32] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			actual[33] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add a test case with name to the created fourth node and clone it$")
	public void add_a_test_case_with_name_to_the_created_fourth_node_and_clone_it() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[34] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[4];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);

			actual[35] = tr.navigateToNode(releaseName, phase);

			actual[36] = tr.addTestCase();
			tr.clickOnDetails();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 13);
			actual[37] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
           tr.clickOnList();
           bp.waitForElement();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[38] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[39] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be cloned to the fourth node$")
	public void test_case_should_be_cloned_to_the_fourth_node() throws Throwable {
		try {
			actual[40] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^click on context menu across created Fourth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_Fourth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[41] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[4];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);

			actual[42] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			actual[43] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add a test case with name to the created fifth node and clone it$")
	public void add_a_test_case_with_name_to_the_created_fifth_node_and_clone_it() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[44] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[5];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			actual[45] = tr.navigateToNode(releaseName, phase);

			actual[46] = tr.addTestCase();
			bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 13);
			actual[47] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
             tr.clickOnList();
              bp.waitForElement();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[48] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[49] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be cloned to the fifth node$")
	public void test_case_should_be_cloned_to_the_fifth_node() throws Throwable {
		try {
			actual[50] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created Fifth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_Fifth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[51] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[5];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			actual[52] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			actual[53] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Add a test case with name to the created sixth node and clone it$")
	public void add_a_test_case_with_name_to_the_created_sixth_node_and_clone_it() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[54] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[6];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			actual[55] = tr.navigateToNode(releaseName, phase);

			actual[56] = tr.addTestCase();
			tr.clickOnDetails();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 13);
			actual[57] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
tr.clickOnList();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[58] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[59] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be cloned to the sixth node$")
	public void test_case_should_be_cloned_to_the_sixth_node() throws Throwable {

		try {
			actual[60] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created Sixth node and create another node with Name and description$")
	public void click_on_context_menu_across_created_Sixth_node_and_create_another_node_with_Name_and_description()
			throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[61] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[6];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			actual[62] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 12);
			actual[63] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add a test case with name to the created seventh node and clone it$")
	public void add_a_test_case_with_name_to_the_created_seventh_node_and_clone_it() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[64] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[7];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 12);
			actual[65] = tr.navigateToNode(releaseName, phase);

			actual[66] = tr.addTestCase();
			tr.clickOnDetails();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 13);
			actual[67] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
           tr.clickOnList();
 ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[68] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[69] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be cloned to the seventh node$")
	public void test_case_should_be_cloned_to_the_seventh_node() throws Throwable {

		try {
			actual[70] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across created Seventh node and create another node with Name and description$")
	public void click_on_context_menu_across_created_Seventh_node_and_create_another_node_with_Name_and_description()
			throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[71] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[7];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 12);
			// phase[3]=Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39,
			// 12);

			actual[72] = tr.navigateToNode(releaseName, phase);

			String phaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 43, 12);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 43, 12);
			actual[73] = tr.addNode(phaseName, phaseDesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Add a test case with name to the created eighth node and clone it$")
	public void add_a_test_case_with_name_to_the_created_eighth_node_and_clone_it() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[74] = tr.doubleClickOnRelease(releaseName);
			String[] phase = new String[8];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			phase[1] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 12);
			phase[2] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 12);
			phase[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 12);
			phase[4] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 12);
			phase[5] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 12);
			phase[6] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 42, 12);
			phase[7] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 43, 12);
			actual[75] = tr.navigateToNode(releaseName, phase);

			actual[76] = tr.addTestCase();
			ctc = new CreateTestCasePage(driver);
			tr.clickOnDetails();

			String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 43, 13);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 43, 13);
			actual[77] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
  tr.clickOnList();
			ep = new ExportPage(driver);
			String[] testCase = new String[1];
			testCase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 14));
			actual[78] = ep.selectMultipleTestCaseFromGrid(testCase);
			actual[79] = tr.cloneTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		;
	}

	@Then("^test case should be cloned to the eighth node$")
	public void test_case_should_be_cloned_to_the_eighth_node() throws Throwable {

		try {
			actual[80] = tr.verifyPresentTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User clicks on test planning module$")
	public void user_clicks_on_test_planning_module() throws Throwable {

		try {
			actual[81] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^creates a new Cycle\\(C(\\d+)\\) with all available fields and save it$")
	public void creates_a_new_Cycle_C_with_all_available_fields_and_save_it(int arg1) throws Throwable {

		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 36, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 36, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 36, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 36, 10));
			tp = new TestPlanningPage(driver);
			actual[82] = tp.clickOnAddTestCycleSymbol();
			actual[83] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[84] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[85] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to created cycle and add a phase by choosing existing phase and asssign to anyone$")
	public void navigate_to_created_cycle_and_add_a_phase_by_choosing_existing_phase_and_asssign_to_anyone()
			throws Throwable {
		try {
			
			

			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);
			actual[86] = tp.navigateToCycle(nodeName);

			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			actual[87] = tp.addPhaseToCycle(phaseName);

			String bulkAssign = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 15, 15);
			actual[88] = tp.bulkAssignment(bulkAssign);
			
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the phase and selects all test case and set the flag$")
	public void navigate_to_the_phase_and_selects_all_test_case_and_set_the_flag() throws Throwable {
		try {

			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 12);
			actual[89] = tp.navigateToCycle(nodeName);

			actual[90] = tp.selectallTestCase();
			bp.waitForElement();
			actual[91] = tp.setFlags();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^clicks on test planning module and selects the created cycle$")
	public void clicks_on_test_planning_module_and_selects_the_created_cycle() throws Throwable {

		try {
			tp.goBackToCycle();
			actual[92] = rp.clickOnTestPlanning();
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);
			actual[93] = tp.navigateToCycle(nodeName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^clone it and edit the name,build,environment and check the keep duration fixed option$")
	public void clone_it_and_edit_the_name_build_environment_and_check_the_keep_duration_fixed_option()
			throws Throwable {

		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 17);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 17);

			actual[94] = tp.cloneCycle(cycleName, build, duration, environment, hide, testCaseAssignment);
			tp.saveTestCycle();
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

	@Then("^test cycle should be Cloned Successfully$")
	public void test_cycle_should_be_Cloned_Successfully() throws Throwable {
		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 37, 2);
			actual[95] = tp.navigateToCycle(nodeName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigates to Cycle\\(C(\\d+)\\) and clone it and edit the start date to one week ahead with duration fixed and save it$")
	public void user_navigates_to_Cycle_C_and_clone_it_and_edit_the_start_date_to_one_week_ahead_with_duration_fixed_and_save_it(
			int arg1) throws Throwable {

		try {
			
			
			
			tp=new TestPlanningPage(driver);
			bp=new BasePage();
			
			bp.waitForElement();
			rp.clickOnTestPlanning();
			
			

			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);
			actual[96] = tp.navigateToCycle(nodeName);

			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 17);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 17);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 38, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 38, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 38, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 99, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 99, 10));

			actual[97] = tp.cloneCycle(cycleName, build, duration, environment, hide, testCaseAssignment);
			actual[98] = tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
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

	@When("^user navigates to Cycle\\(C(\\d+)\\) and clone it and edit the start date to one week back with duration fixed and save it$")
	public void user_navigates_to_Cycle_C_and_clone_it_and_edit_the_start_date_to_one_week_back_with_duration_fixed_and_save_it(
			int arg1) throws Throwable {

		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);
			actual[99] = tp.navigateToCycle(nodeName);

			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 39, 17);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 17);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 41, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 41, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 41, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 99, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 99, 10));
			// tp.editCycle(cycleName, build, environment, hide);

			actual[100] = tp.cloneCycle(cycleName, build, duration, environment, hide, testCaseAssignment);
			actual[101] = tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
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

	@When("^user navigates to Cycle\\(C(\\d+)\\) and clone it and edit the start date and end date within few days and save it$")
	public void user_navigates_to_Cycle_C_and_clone_it_and_edit_the_start_date_and_end_date_within_few_days_and_save_it(
			int arg1) throws Throwable {

		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);
			actual[102] = tp.navigateToCycle(nodeName);

			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 11);
			String duration = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 99);
			String testCaseAssignment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 17);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 40, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 40, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 40, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 99, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 40, 10));
			actual[103] = tp.cloneCycle(cycleName, build, duration, environment, hide, testCaseAssignment);
			actual[104] = tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
		 
			  bp.waitForElement();
			// tp.endDateOption.click();
			  bp.waitForElement();

			 // driver.findElement(By.xpath(tp.day_1+endDateDay+tp.day_2)).click();
			  bp.waitForElement();
			tp.saveTestCycle();
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

	@Then("^Test Cycle Should be Cloned Successfully$")
	public void test_Cycle_Should_be_Cloned_Successfully() throws Throwable {

		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 36, 2);
			actual[105] = tp.navigateToClonedCycle(nodeName, "2");
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		}

		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}
}
