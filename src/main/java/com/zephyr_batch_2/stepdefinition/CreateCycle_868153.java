package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
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

public class CreateCycle_868153 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[27];
	SoftAssert soft = new SoftAssert();

	 String fileName="CreateCycle_868153";

	@When("^user click on create new cycle symbol s$")
	public void user_click_on_create_new_cycle_symbol_s() throws Throwable {
		try {
			lb=new LaunchBrowser();
			tp = new TestPlanningPage(driver);
			actual[0]=tp.clickOnAddTestCycleSymbol();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}


	
	
	

	@Then("^Add new cycle page should be displayed$")
	public void add_new_cycle_page_should_be_displayed() throws Throwable {
		try {
			actual[1]=tp.verifyAddTestCyclePage();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user Creates a new Cycle with all available fields,check the hide option and save it$")
	public void user_Creates_a_new_Cycle_with_all_available_fields_check_the_hide_option_and_save_it()
			throws Throwable {
		try {
			bp = new BasePage();
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

			actual[2] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[3] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[4] = tp.saveTestCycle();
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

	@Then("^should be able to create the hidden cycle$")
	public void should_be_able_to_create_the_hidden_cycle() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[5] = tp.navigateToCycle(cycle_name1);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user creates second Cycle with a difference of two/three days between start date and end date and check the hide option and save it$")
	public void user_creates_second_Cycle_with_a_difference_of_two_three_days_between_start_date_and_end_date_and_check_the_hide_option_and_save_it()
			throws Throwable {

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
			tp.clickOnAddTestCycleSymbol();
			actual[6] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[7] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[8] = tp.saveTestCycle();
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

	@Then("^second cycle should be created successfully$")
	public void second_cycle_should_be_created_successfully() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;

			actual[9] = tp.navigateToCycle(cycle_name1);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user creates third cycle with a diff of two week between start date and end date,check the hide option and save it$")
	public void user_creates_third_cycle_with_a_diff_of_two_week_between_start_date_and_end_date_check_the_hide_option_and_save_it()
			throws Throwable {
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
			tp.clickOnAddTestCycleSymbol();
			actual[10] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[11] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[12] = tp.saveTestCycle();
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

	@Then("^third cycle should be created successfully$")
	public void third_cycle_should_be_created_successfully() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[13] = tp.navigateToCycle(cycle_name1);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user creates fourth cycle with a diff of six month between start date and end date,check the hide option and save it$")
	public void user_creates_fourth_cycle_with_a_diff_of_six_month_between_start_date_and_end_date_check_the_hide_option_and_save_it()
			throws Throwable {
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
			tp.clickOnAddTestCycleSymbol();
			actual[14] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[15] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[16] = tp.saveTestCycle();
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

	@Then("^fourth cycle should be created successfully$")
	public void fourth_cycle_should_be_created_successfully() throws Throwable {

		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[17] = tp.navigateToCycle(cycle_name1);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user creates fifth cycle  with a diff of two years between start date and end date, check the hide option  and save it$")
	public void user_creates_fifth_cycle_with_a_diff_of_two_years_between_start_date_and_end_date_check_the_hide_option_and_save_it()
			throws Throwable {

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
			tp.clickOnAddTestCycleSymbol();
			actual[18] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[19] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[20] = tp.saveTestCycle();
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

	@Then("^fifth cycle should be created successfully$")
	public void fifth_cycle_should_be_created_successfully() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[21] = tp.navigateToCycle(cycle_name1);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user navigates to the  first cycle and modify the name/build/environment/start date and end date and save it$")
	public void user_navigates_to_the_first_cycle_and_modify_the_name_build_environment_start_date_and_end_date_and_save_it()
			throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[22] = tp.navigateToCycle(cycle_name1);

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
			// tp.clickOnAddTestCycleSymbol();
			actual[23] = tp.editCycle(cycleName, build, environment, hide);
			actual[24] = tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[25] = tp.saveTestCycle();
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

	@Then("^first cycle should be modified successfully$")
	public void first_cycle_should_be_modified_successfully() throws Throwable {
		try {
			String cycle_name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 24, 2);
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = cycle_name;
			// actual[6]=tp.navigateToCycle(cycle_name1);
			actual[26] = tp.navigateToCycle(cycle_name1);
			bp.waitForElement();
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
		     {
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
