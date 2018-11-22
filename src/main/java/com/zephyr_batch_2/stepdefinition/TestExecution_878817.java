package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
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

public class TestExecution_878817 extends LaunchBrowser {

	LaunchBrowser lb;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
   String fileName="TestExecution_878817";
	
	boolean[] actual = new boolean[21];
	SoftAssert soft = new SoftAssert();

	@When("^User add a phase and add two system in the phase$")
	public void user_add_a_phase_and_add_two_system_in_the_phase() throws Throwable {

		try {
			lb=new LaunchBrowser();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String name =UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			tr = new TestRepositoryPage(driver);
			bp = new BasePage();
			actual[0] = tr.doubleClickOnRelease(releaseName);
			actual[1] = tr.addNode(name, desc);

			bp.waitForElement();
			
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			actual[2]=tr.navigateToNode(releaseName, phase);
			//actual[2] = tr.selectPhase(name);

			String sname1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 3);
			String sdesc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 3);
			actual[2] = tr.addNode(sname1, sdesc1);
			bp.waitForElement();
			//actual[3] = tr.selectPhase(name);
			
			actual[3]=tr.navigateToNode(releaseName, phase);
			String sname2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 4);
			String sdesc2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 4);
			actual[4] = tr.addNode(sname2, sdesc2);
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

	@When("^add testcases with test step in the phase$")
	public void add_testcases_with_test_step_in_the_phase() throws Throwable {
		try {
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			//actual[5] = tr.selectPhase(name);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			actual[5]=tr.navigateToNode(releaseName, phase);
			
			actual[6] = tr.addTestCase();
			bp.waitForElement();
            tr.clickDetailButton();
            bp.waitForElement();
			String[] stepDetail = new String[3];
			int k = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				k++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[7] = ctc.enterTestCaseStepDetail(stepDetail);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
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

	@When("^create a new cycle and add created phase to the cycle and assign to the lead$")
	public void create_a_new_cycle_and_add_created_phase_to_the_cycle_and_assign_to_the_lead() throws Throwable {
		try {
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 8, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 8, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 8, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 8, 13));
			tp = new TestPlanningPage(driver);
			actual[8] = tp.clickOnAddTestCycleSymbol();

			actual[9] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[10] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[11] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 5);
			actual[12] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			actual[13] = tp.addPhaseToCycle(phase);

			actual[14] = tp.cancelBulkAssign();

			String[] phase1 = new String[1];
			phase1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 2);
			actual[15] = tp.navigateToCycle(phase1);
			bp.waitForElement();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			actual[16] = tp.individualAssinTo(testcase, assignee);
			
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

	@When("^after assigning hide the cycle$")
	public void after_assigning_hide_the_cycle() throws Throwable {
		try {
			String cycleName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 28);
			rp = new ReleasePage(driver);
			actual[17] = rp.clickOnTestPlanning();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 5);
			actual[18] = tp.navigateToCycle(cycle);
			actual[19] = tp.editCycle(cycleName, build, environment, hide);
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

	@When("^check for assigned cycle$")
	public void check_for_assigned_cycle() throws Throwable {
		try {
			bp.waitForElement();
			String[] cycle = new String[1];
			cycle[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 5);
			actual[20] = tp.navigateToCycle(cycle);
			
			tp.validateDeletedCycle(cycleName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^able to view the assigned hidden cycle$")
	public void able_to_view_the_assigned_hidden_cycle() throws Throwable {
		try {
			log.info("Cycle name successfully changed");

			String release = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			tp.doubleClickOnCycle(release);
			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
			log.info("Cycle name successfully changed");

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