package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTestCycle_868095 extends LaunchBrowser {

	LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestPlanningPage tp;

	boolean[] actual = new boolean[9];
	SoftAssert soft = new SoftAssert();

	 String fileName="CreateTestCycle_868095";
	 
	@Given("^User is in test planning page$")
	public void user_is_in_test_planning_page() throws Throwable {
		try {

			lb=new LaunchBrowser();
			pp = new ProjectPage(driver);
			bp = new BasePage();

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[0] = pp.selectProject(projectName);

			bp.waitForElement();
			actual[1] = pp.selectRelease(releaseName);

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

	@When("^user click on add test cycle symbol$")
	public void user_click_on_add_test_cycle_symbol() throws Throwable {
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

	@Then("^test cycle page should displayed$")
	public void test_cycle_page_should_displayed() throws Throwable {
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

	@When("^user enter data in all fields and click on save$")
	public void user_enter_data_in_all_fields_and_click_on_save() throws Throwable {
		try {
			tp = new TestPlanningPage(driver);
			String[] cycleData = new String[4];
			int k = 0;
			for (int i = 2; i <= 4; i++) {

				cycleData[k] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, i);
				k++;
			}
			cycleData[3] = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 11);

			// int
			// startDate=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",
			// 1, 5);
			// int
			// endDate=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",
			// 1, 6);
			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 1, 10));

			actual[5] = tp.CreateCycle(cycleData[0], cycleData[1], cycleData[2], cycleData[3]);
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

	@Then("^test cycle should be created successfully$")
	public void test_cycle_should_be_created_successfully() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			actual[8] = tp.navigateToCycle(cycle_name1);

			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

			log.info("Test Cycle Successfully Created");

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
