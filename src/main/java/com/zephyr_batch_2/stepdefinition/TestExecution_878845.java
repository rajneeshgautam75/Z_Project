package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878845 extends LaunchBrowser {
	LaunchBrowser lb;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;

	boolean[] actual = new boolean[17];
	SoftAssert soft = new SoftAssert();

	 String fileName="TestExecution_878845";
	 
	@When("^user add a phase and add a testcase to the phase$")
	public void user_add_a_phase_and_add_a_testcase_to_the_phase() throws Throwable {
		try {


           lb=new LaunchBrowser();
			bp = new BasePage();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			tr = new TestRepositoryPage(driver);
			actual[0] = tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 2);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 2);
			actual[1] = tr.addNode(name, desc);

			String[] phase = new String[1];
			phase[0] = name;
			actual[2] = tr.navigateToNode(releaseName,phase);

			actual[3] = tr.addTestCase();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a new test cycle and add created phase to the cycle and assign to the creator$")
	public void create_a_new_test_cycle_and_add_created_phase_to_the_cycle_and_assign_to_the_creator()
			throws Throwable {
		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 9, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 9, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 9, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 9, 13));
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			actual[4] = tp.clickOnAddTestCycleSymbol();

			actual[5] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[6] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[7] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 5);
			actual[8] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 2);
			actual[9] = tp.addPhaseToCycle(phase);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 22);
			actual[10] = tp.bulkAssignment(bulkType);
			rp=new ReleasePage(driver);
		     //rp.clickOnTestPlanning(); 
			tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the cycle and view the cycle name$")
	public void navigate_to_the_cycle_and_view_the_cycle_name() throws Throwable {
		try
		{
		String[] cycle = new String[2];
		cycle[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 5);
		actual[11] = tp.navigateToCycle(cycle);
		
		tp.doubleClickOnCycle(cycle[0]);
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^edit the cycle name and save it$")
	public void edit_the_cycle_name_and_save_it() throws Throwable {

		try {

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 5);
			actual[12] = tp.navigateToCycle(cycle);

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 10, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 210, 28);

			actual[13] = tp.editCycle(cycleName, build, environment, hide);
			actual[14] = tp.saveTestCycle();
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

	@When("^click on test execution page and navigate to cycle$")
	public void click_on_test_execution_page_and_navigate_to_cycle() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[15] = rp.clickOnTestExecution();
			String[] cycle = new String[2];
			cycle[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 10, 5);
			actual[16] = tp.navigateToCycle(cycle);
			
			tp.doubleClickOnCycle(cycle[0]);
		}

		catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^cycle name should reflect in test execution page$")
	public void cycle_name_should_reflect_in_test_execution_page() throws Throwable {
		try {
			if (actual[16] = true) {
				log.info("Cycle name reflected in test execution page");
//				pp=new ProjectPage(driver);
//				pp.closeBrowser();
			}
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
