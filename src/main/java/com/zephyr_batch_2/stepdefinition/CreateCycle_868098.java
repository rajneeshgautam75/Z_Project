package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCycle_868098 extends LaunchBrowser {

	LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;

	TestPlanningPage tp;

	boolean[] actual = new boolean[21];
	SoftAssert soft = new SoftAssert();
	
	 String fileName="CreateCycle_868098";
	 

	@When("^user enters the values in all fields and save it$")
	public void user_enters_the_values_in_all_fields_and_save_it() throws Throwable {

		try {
			lb=new LaunchBrowser();
			tp = new TestPlanningPage(driver);
			bp = new BasePage();

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

			actual[0] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[1] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[2] = tp.saveTestCycle();
			bp.waitForElement();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^new test cycle should be created$")
	public void new_test_cycle_should_be_created() throws Throwable {
		try
		{
		String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 8, 2);

		String[] cycle_name1 = new String[1];
		cycle_name1[0] = cycle_name;
		actual[3] = tp.navigateToCycle(cycle_name1);
		}
	
	catch (Exception e) {
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}


	}

	@When("^user click on context menu across cycle and edit the cycle name and save it$")
	public void user_click_on_context_menu_across_cycle_and_edit_the_cycle_name_and_save_it() throws Throwable {
try
{
		String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 2);
		String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 3);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 11);
		actual[4] = tp.editCycle(cycleName, build, environment, hide);
		actual[5] = tp.saveTestCycle();
		bp.waitForElement();
	} catch (Exception e) {
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}

	}

	@When("^user click on context menu across cycle and edit the cycle build and save it$")
	public void user_click_on_context_menu_across_cycle_and_edit_the_cycle_build_and_save_it() throws Throwable {
		try
		{
		tp = new TestPlanningPage(driver);
		bp = new BasePage();

		String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 2);
		String[] cycle_name1 = new String[1];
		cycle_name1[0] = cycle_name;
		actual[6] = tp.navigateToCycle(cycle_name1);

		String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);

		String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 3);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 11);
		actual[7] = tp.editCycle(cycleName, build, environment, hide);
		actual[8] = tp.saveTestCycle();
		bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}


	}

	@When("^user click on context menu across cycle and edit the environment and save it$")
	public void user_click_on_context_menu_across_cycle_and_edit_the_environment_and_save_it() throws Throwable {

		try
		{
		String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 2);
		String[] cycle_name1 = new String[1];
		cycle_name1[0] = cycle_name;
		actual[9] = tp.navigateToCycle(cycle_name1);

		String cycleName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
		String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 4);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 11);
		actual[10] = tp.editCycle(cycleName, build, environment, hide);
		actual[11] = tp.saveTestCycle();
		bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^click on on context menu across cycle and edit the cycle start date and save it$")
	public void click_on_on_context_menu_across_cycle_and_edit_the_cycle_start_date_and_save_it() throws Throwable {

		try
		{
		String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 2);
		String[] cycle_name1 = new String[1];
		cycle_name1[0] = cycle_name;
		actual[12] = tp.navigateToCycle(cycle_name1);

		String cycleName = "";
		String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 3);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 11);

		actual[13] = tp.editCycle(cycleName, build, environment, hide);

		String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 9, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 6);
		String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 9, 7));
		System.out.println(startDateday);
		String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 100, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 9);
		String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 100, 10));

		actual[14] = tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth,
				endDateDay);
		actual[15] = tp.saveTestCycle();
		bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^click on on context menu across cycle and edit the cycle end date and save it$")
	public void click_on_on_context_menu_across_cycle_and_edit_the_cycle_end_date_and_save_it() throws Throwable {

		try
		{
		String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 2);
		String[] cycle_name1 = new String[1];
		cycle_name1[0] = cycle_name;
		actual[16] = tp.navigateToCycle(cycle_name1);

		String cycleName = "";
		String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 3);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 4);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 11);

		actual[17] = tp.editCycle(cycleName, build, environment, hide);

		String startDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 100, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 100, 6);
		String startDateday = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 100, 7));
		String endDateYear = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 9, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 9);
		String endDateDay = (Excel_Lib.getNumericValue(INPUT_PATH_2, "CreateTestCycle", 9, 10));

		actual[18] = tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth,
				endDateDay);
		actual[19] = tp.saveTestCycle();
		bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test cycle should be edited successfully$")
	public void test_cycle_should_be_edited_successfully() throws Throwable {
		
		try
		{
		String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 9, 2);

		String[] cycle_name1 = new String[1];
		cycle_name1[0] = cycle_name;
		actual[20] = tp.navigateToCycle(cycle_name1);
		
		
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
