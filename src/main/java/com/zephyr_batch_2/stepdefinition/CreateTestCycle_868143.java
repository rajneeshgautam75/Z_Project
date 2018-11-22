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

public class CreateTestCycle_868143 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[18];
	SoftAssert soft = new SoftAssert();

	 String fileName="CreateTestCycle_868143";
	 
	@Given("^User is in test repository page$")
	public void user_is_in_test_repository_page() throws Throwable {

		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[0] = pp.selectProject(projectName);
			bp.waitForElement();
			actual[1] = pp.selectRelease(releaseName);
			bp.waitForElement();

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

	@When("^User Add a phase with name and description$")
	public void user_Add_a_phase_with_name_and_description() throws Throwable {
		
		try
		{
		tr = new TestRepositoryPage(driver);
		String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
		tr.clickOnRelease(releaseName);
		String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 12);
		String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 12);

		actual[3] = tr.addNode(name, desc);

		bp.waitForElement();
		actual[4] = tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] phase = new String[1];
		phase[0] = name;
		actual[5] = tr.navigateToNode(releaseName, phase);
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Add a test case to the phase$")
	public void add_a_test_case_to_the_phase() throws Throwable {
		try
		{
		actual[6] = tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test case should be added to the phase$")
	public void test_case_should_be_added_to_the_phase() throws Throwable {
		try
		{
		actual[7] = tr.verifyPresentTestCase();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^edit the test case name from detail view$")
	public void edit_the_test_case_name_from_detail_view() throws Throwable {
		try
		{
		actual[8] = tr.clickDetailButton();
		ctc = new CreateTestCasePage(driver);

		String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 13);
		String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 13);
		actual[9] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		bp.waitForElement();
		//tr.clickOnList();
		//bp.waitForElement();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^clone the created test case$")
	public void clone_the_created_test_case() throws Throwable {

		try
		{
			ep=new ExportPage(driver);
			String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 3, 14));
			ep.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
		tr.clone_TestCaseInDetail.click();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

		// tr.cloneTestCase();
	}

	@Then("^test case should be cloned$")
	public void test_case_should_be_cloned() throws Throwable {
		try
		{
		actual[10] = tr.verifyPresentTestCase();
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user navigate to test planning page$")
	public void user_navigate_to_test_planning_page() throws Throwable {
		try
		{
		rp=new ReleasePage(driver);
		actual[11] = rp.clickOnTestPlanning();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^click on add test cycle option$")
	public void click_on_add_test_cycle_option() throws Throwable {
		try
		{
		tp = new TestPlanningPage(driver);
		actual[12] = tp.clickOnAddTestCycleSymbol();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^Add test cycle page should be displayed$")
	public void add_test_cycle_page_should_be_displayed() throws Throwable {
		try
		{
		actual[13] = tp.verifyAddTestCyclePage();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user enters the name,start date and end date and save it$")
	public void user_enters_the_name_start_date_and_end_date_and_save_it() throws Throwable {
		try
		{
		String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 2);
		String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 3);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 4);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 11);

		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 12, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 6);
		String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 12, 7));
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 12, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 9);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 12, 10));

		actual[14] = tp.CreateCycle(cycleName, build, environment, hide);
		actual[15] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth,
				endDateDay);
		actual[16] = tp.saveTestCycle();
		bp.waitForElement();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^new test cycle Should be created$")
	public void new_test_cycle_Should_be_created() throws Throwable {

		try {
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 12, 2);

			actual[17] = tp.navigateToCycle(cycle_name1);
			bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

			log.info("Test Cycle Successfully Created");

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}


	}
}
