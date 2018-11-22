package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTestCycle_868096 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;

	TestPlanningPage tp;

	boolean[] actual = new boolean[3];
	SoftAssert soft = new SoftAssert();

	 String fileName="CreateTestCycle_868096";
	 
	@When("^user clicks on add test cycle symbol$")
	public void user_clicks_on_add_test_cycle_symbol() throws Throwable {
		try {
			bp=new BasePage();
			lb=new LaunchBrowser();
			tp = new TestPlanningPage(driver);
			 bp.waitForElement();
			actual[0] = tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
		} catch (Exception e) {

lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test cycle page should be displayed$")
	public void test_cycle_page_should_be_displayed() throws Throwable {
		try {
			actual[1] = tp.verifyAddTestCyclePage();
		} catch (Exception e) {

lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user enter test cycle name \"([^\"]*)\" with different data	and save it$")
	public void user_enter_test_cycle_name_with_different_data_and_save_it(String cycleName) throws Throwable {
		try {
			bp = new BasePage();
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 2, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 2, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 2, 11);
			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 2, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 2, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 2, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 2, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 2, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 2, 10));

			tp.CreateCycle(cycleName, build, environment, hide);
			tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth,
					endDateDay);
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

	@Then("^test cycle \"([^\"]*)\" should be created with all supported character$")
	public void test_cycle_should_be_created_with_all_supported_character(String arg1) throws Throwable {
		try {

			String[] cycle_name1 = new String[1];
			cycle_name1[0] = arg1;

			actual[2] = tp.navigateToCycle(cycle_name1);

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
