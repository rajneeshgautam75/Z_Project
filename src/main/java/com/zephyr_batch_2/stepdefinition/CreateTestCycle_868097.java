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

public class CreateTestCycle_868097 extends LaunchBrowser {

    LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;

	TestPlanningPage tp;
	boolean[] actual = new boolean[8];
	SoftAssert soft = new SoftAssert();
	
	 String fileName="CreateTestCycle_868097";
	 
	@When("^user enter data in all fields$")
	public void user_enter_data_in_all_fields() throws Throwable {
		try {

              lb=new LaunchBrowser();
			
			tp = new TestPlanningPage(driver);
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 11);

			// int startDate=Excel_Lib.getNumberData(INPUT_PATH_2,
			// "CreateTestCycle", 2, 5);
			// int endDate=Excel_Lib.getNumberData(INPUT_PATH_2,
			// "CreateTestCycle", 2, 6);

			actual[0]=tp.CreateCycle(cycleName, build, environment, hide);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^enters the start date and end date within release test planning date range$")
	public void enters_the_start_date_and_end_date_within_release_test_planning_date_range() throws Throwable {

		try
		{
		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 3, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 6);
		String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 3, 7));
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 3, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 9);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 3, 10));

		actual[1]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);

		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on save$")
	public void click_on_save() throws Throwable {
		try
		{
		bp = new BasePage();
		actual[2]=tp.saveTestCycle();
		bp.waitForElement();
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

	@Then("^test cycle should be created$")
	public void test_cycle_should_be_created() throws Throwable {
		try
		{
		String[] cycleName = new String[1];
		cycleName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 3, 2);

		actual[3]=tp.navigateToCycle(cycleName);
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^enters the start date and end date within project date range$")
	public void enters_the_start_date_and_end_date_within_project_date_range() throws Throwable {

		try
		{
		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 4, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 4, 6);
		String startDateday = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 4, 7);

		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 4, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 4, 9);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 4, 10));

		actual[4]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		}
				catch (Exception e) {
					lb.getScreenShot(fileName);
					driver.close();
					Relogin_TPE rl = new Relogin_TPE();
					rl.reLogin();
					throw e;
				}
	}

	@When("^enters the same start date and end date$")
	public void enters_the_same_start_date_and_end_date() throws Throwable {

		try
		{
		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 5, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 5, 6);
		String startDateday = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 5, 7);
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 5, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 5, 9);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 5, 10));

		actual[5]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^enters the same start date and end date with multiple month span$")
	public void enters_the_same_start_date_and_end_date_with_multiple_month_span() throws Throwable {
		try
		{
		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 6, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 6, 6);
		String startDateday = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 6, 7);
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 6, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 6, 9);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 6, 10));

		actual[6]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		}
				catch (Exception e) {
					lb.getScreenShot(fileName);
					driver.close();
					Relogin_TPE rl = new Relogin_TPE();
					rl.reLogin();
					throw e;
				}
	}

	@When("^enters the same start date and end date with a difference of few days$")
	public void enters_the_same_start_date_and_end_date_with_a_difference_of_few_days() throws Throwable {

		try
		{
		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 7, 5));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 7, 6);
		String startDateday = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 7, 7);
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 7, 8));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 7, 9);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 7, 10));

		actual[7]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		
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
