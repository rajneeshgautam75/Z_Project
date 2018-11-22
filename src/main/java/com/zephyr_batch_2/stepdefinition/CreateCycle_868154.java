package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCycle_868154 extends LaunchBrowser {

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[10];
	SoftAssert soft = new SoftAssert();

	String fileName="CreateCycle_868154";
	
	@Given("^User select the project and release$")
	public void user_select_the_project_and_release() throws Throwable {

		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[0] = pp.selectProject(projectName);

			bp.waitForElement();
			actual[1] = pp.selectRelease(releaseName);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user launch test planning$")
	public void user_launch_test_planning() throws Throwable {

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

	@When("^create a test cycle with all available fields and check the hide option and save it$")
	public void create_a_test_cycle_with_all_available_fields_and_check_the_hide_option_and_save_it() throws Throwable {

		try {
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			actual[3] = tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 11);

			String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 8, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 6);
			String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 8, 7));
			String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 8, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 9);
			String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 8, 10));

			actual[4] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[5] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[6] = tp.saveTestCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^select the test cycle and uncheck the hide option$")
	public void select_the_test_cycle_and_uncheck_the_hide_option() throws Throwable {
		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 2);
			actual[7] = tp.navigateToCycle(nodeName);

			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 2);

			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 99, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 11);

			actual[8] = tp.editCycle(cycleName, build, environment, hide);
			tp.saveTestCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		// tp.navigateToCycle(cycleName)
	}

	@Then("^test cycle should be visible$")
	public void test_cycle_should_be_visible() throws Throwable {
		try {
			String nodeName[] = new String[1];
			nodeName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 2);
			actual[9] = tp.navigateToCycle(nodeName);

			for (int k = 0; k <= actual.length - 1; k++) {
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