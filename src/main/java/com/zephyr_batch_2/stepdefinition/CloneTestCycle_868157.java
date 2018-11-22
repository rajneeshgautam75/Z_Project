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

public class CloneTestCycle_868157 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	boolean[] actual = new boolean[19];
	SoftAssert soft = new SoftAssert();
	String fileName="CloneTestCycle_868157";

	@When("^User click on create test cycle and enters all available fields and check hide option$")
	public void user_click_on_create_test_cycle_and_enters_all_available_fields_and_check_hide_option()
			throws Throwable {

		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			actual[0] = tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 11);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 22, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 22, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 22, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 22, 10));

			actual[1] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[2] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[3] = tp.saveTestCycle();
			bp.waitForElement();
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

	@When("^click on test cycle option and clone it and save$")
	public void click_on_test_cycle_option_and_clone_it_and_save() throws Throwable {
		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 2);
			tp.navigateToCycle(cycle);
			String cycle1 = "";
			String Build = "";
			String duration = "";
			String environ = "";
			String hide = "";
			String testCaseAssignment = "";

			actual[4] = tp.cloneCycle(cycle1, Build, duration, environ, hide, testCaseAssignment);
			tp.saveTestCycle();
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

	@When("^click on create test cycle symbol and enters all available fields and save it$")
	public void click_on_create_test_cycle_symbol_and_enters_all_available_fields_and_save_it() throws Throwable {
		try {
			// tp=new TestPlanningPage(driver);
			actual[5] = tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 11);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 23, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 23, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 23, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 23, 10));

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

	@When("^click on test cycle and a phase to the test cycle and choose option assign individually and save it$")
	public void click_on_test_cycle_and_a_phase_to_the_test_cycle_and_choose_option_assign_individually_and_save_it()
			throws Throwable {

		try {
			rp = new ReleasePage(driver);
			actual[9] = rp.clickOnTestRep();
			tr = new TestRepositoryPage(driver);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[10] = tr.doubleClickOnRelease(releaseName);

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 12);
			actual[11] = tr.addNode(name, desc);
			bp.waitForElement();

			actual[12] = rp.clickOnTestPlanning();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 2);
			actual[13] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 12);
			actual[14] = tp.addPhaseToCycle(phase);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;

		}
	}

	@When("^click on context menu across cycle and choose clone option and save it$")
	public void click_on_context_menu_across_cycle_and_choose_clone_option_and_save_it() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 12);
			actual[15] = tp.navigateToCycle(cycle);
			
			tp.goBackToCycle();

			rp.clickOnTestPlanning();
			bp.waitForElement();
			String[] cycle1 = new String[1];
			cycle1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 2);
			tp.navigateToCycle(cycle1);

			String cycle2 = "";
			String Build = "";
			String duration = "";
			String environ = "";
			String hide = "";
			String testCaseAssignment = "";

			actual[16] = tp.cloneCycle(cycle2, Build, duration, environ, hide, testCaseAssignment);
			tp.saveTestCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;

		}
		// tp.navigateToCycle(cycleName)
	}

	@When("^click on context menu across cloned test cycle and check hide option and save it$")
	public void click_on_context_menu_across_cloned_test_cycle_and_check_hide_option_and_save_it() throws Throwable {

		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 2);
			String no = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 14, 14));
			actual[17] = tp.navigateToClonedCycle(cycle, no);
			bp.waitForElement();
 			String cycle2 = "";
			String Build = "";
			String duration = "";
			String environ = "";

			String testCaseAssignment = "";

			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 22, 11);
			tp.cloneCycle(cycle2, Build, duration, environ, hide, testCaseAssignment);
			tp.saveTestCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;

		}
	}

	@Then("^should be able to hide a cloned cycle$")
	public void should_be_able_to_hide_a_cloned_cycle() throws Throwable {
		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 23, 2);
			String no = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 15, 14));
			actual[18] = tp.navigateToClonedCycle(cycle, no);

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
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
