package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878815 extends LaunchBrowser {

	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LoginPage lp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878815";
	boolean[] actual = new boolean[37];
	SoftAssert soft = new SoftAssert();
	
	
	String Release = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

	@When("^User add a phase and add two systems to phase$")
	public void user_add_a_phase_and_add_two_systems_to_phase() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			bp = new BasePage();

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 2);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 2);
			actual[0]=tr.doubleClickOnRelease(releaseName);
			actual[1]=tr.addNode(phaseName, phaseDesc);

			 bp.waitForElement();
			    String[] phase=new String[1];
				phase[0]=phaseName;
				bp.waitForElement();
			    tr.navigateToNode(releaseName, phase);
				bp.waitForElement();

			actual[2]=tr.selectPhase(phaseName);
			String sysName1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 3);
			String sysDesc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 3);
			actual[3]=tr.addNode(sysName1, sysDesc1);

			bp.waitForElement();
			actual[4]=tr.selectPhase(phaseName);
			String sysName2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 4);
			String sysDesc2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 4);
			actual[5]=tr.addNode(sysName2, sysDesc2);

			bp.waitForElement();

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^add testcases with test steps to phase$")
	public void add_testcases_with_test_steps_to_phase() throws Throwable {
		try {
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 2);
			actual[6]=tr.selectPhase(phaseName);
			actual[7]=tr.addTestCase();
            bp.waitForElement();
            actual[8]=tr.clickDetailButton();
            bp.waitForElement();
			String[] stepDetail = new String[3];
			int k = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				k++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[9] = ctc.enterTestCaseStepDetail(stepDetail);

			bp.waitForElement();
			actual[10]=tr.clickOnList();
			bp.waitForElement();
			for (int i = 1; i <= 2; i++) {
				actual[11]=tr.selectallTestCase();
				actual[12]=tr.cloneTestCase();
			}
			bp.waitForElement();

			actual[13]=tr.verifyPresentTestCase();
			
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a new cycle and add phase to cycle$")
	public void create_a_new_cycle_and_add_phase_to_cycle() throws Throwable {
		try {

			tp = new TestPlanningPage(driver);
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 35, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 35, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 35, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 35, 13));
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			actual[14] = tp.clickOnAddTestCycleSymbol();

			actual[15] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[16] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[17] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 5);
			actual[18] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 2);
			actual[19] = tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[20] = tp.cancelBulkAssign();
			bp.waitForElement();

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^assign testcases to lead by individual assignments$")
	public void assign_testcases_to_lead_by_individual_assignments() throws Throwable {
		try {
			String[] phase1 = new String[1];
			phase1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 2);
			actual[21] = tp.navigateToCycle(phase1);
              bp.waitForElement();
			int[] testcase = new int[4];
			for (int i = 1; i <= testcase.length; i++) {
				testcase[i - 1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i, 27);
			}
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[22] = tp.individualAssinTo(testcase, assignee);

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test cases should be assign to Lead$")
	public void test_cases_should_be_assign_to_Lead() throws Throwable {
		try
		{
		int[] testcase = new int[4];
		for (int i = 1; i <= testcase.length; i++) {
			testcase[i - 1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i, 27);
		}
		String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
		actual[23]=tp.validateAllAssigned(testcase, assignee);
		
		tp.goBackToCycle();
		rp=new ReleasePage(driver);
		bp=new BasePage();
		bp.waitForElement();
		
		
		}
		catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User launch test execution module$")
	public void user_launch_test_execution_module() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			rp.clickOnTestExecution();
            bp.waitForElement();
			String[] phase1 = new String[3];
			phase1[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			phase1[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 5);
			phase1[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 2);
			actual[24] = tp.navigateToCycle(phase1);

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^execute test step and testcase, change to custom status$")
	public void execute_test_step_and_testcase_change_to_custom_status() throws Throwable {
		try {
			exp = new ExecutionPage(driver);
			
		    bp.waitForElement();
		    String[] testCase=new String[1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			exp.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			int[] stepNo = new int[1];
			stepNo[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			String[] status = new String[1];
			status[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 17);
			//exp.stepDetailButton.click();
			actual[25]=exp.changeStepDetailStatus(stepNo, status);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^status should be change to custom status$")
	public void status_should_be_change_to_custom_status() throws Throwable {
		try {

			int[] stepNo = new int[1];
			stepNo[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String[] status = new String[1];
			status[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 17);
			actual[26]=exp.ValidateStatusOfTestCases(stepNo, status[0]);
			bp.waitForElement();
			

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user link a defect to testcase and change status to Fail$")
	public void user_link_a_defect_to_testcase_and_change_status_to_Fail() throws Throwable {
		try {
			int[] stepNo = new int[1];
			stepNo[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			actual[27]=exp.clickOnDefectButton(stepNo[0]);
			String defectId = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
			actual[28]=exp.linkDefect(defectId);
			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
			actual[29]=exp.changeStatusOfTestCases(stepNo, status);

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^defect should be linked with testcase and status change to Fail$")
	public void defect_should_be_linked_with_testcase_and_status_change_to_Fail() throws Throwable {
		try {
			int[] stepNo = new int[1];
			stepNo[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String defectId = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
			actual[30]=exp.validateLinkedDefect(stepNo[0], defectId);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
			actual[31]=exp.ValidateStatusOfTestCases(stepNo, status);
			
			bp.waitForElement();
			rp.clickOnTestPlanning();
			bp.waitForElement();

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User launch test planning module and navigate to cycle$")
	public void user_launch_test_planning_module_and_navigate_to_cycle() throws Throwable {
		try {

			actual[32]=rp.clickOnTestPlanning();

			String[] phase1 = new String[1];
			phase1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 5);
			actual[33] = tp.navigateToCycle(phase1);

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^delete the cycle and launch test execution$")
	public void delete_the_cycle_and_launch_test_execution() throws Throwable {
		try {

			actual[34]=tp.deleteNode();
			bp.waitForElement();
			actual[35]=rp.clickOnTestExecution();

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^check for executions in test execution page$")
	public void check_for_executions_in_test_execution_page() throws Throwable {
		try {
			String nodes[] = new String[2];
			nodes[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			nodes[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 35, 5);
			actual[36]=exp.validateExecutions(nodes);
			
			 bp.waitForElement();
				tp=new TestPlanningPage(driver);
				String [] Release=new String[1];
				Release[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
				tp.navigateToCycle(Release);
				bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		} catch (Exception e) {lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
