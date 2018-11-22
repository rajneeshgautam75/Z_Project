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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878796 extends LaunchBrowser {

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
	String filename="Execution_878796";
	boolean[] actual = new boolean[39];
	SoftAssert soft = new SoftAssert();
    
	String Release = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
	
	@Given("^User is in Test Repository Page$")
	public void user_is_in_Test_Repository_Page() throws Throwable {

		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);
		    pp.clickOnLogout();
		    bp.waitForElement();
		lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		 lp.enterUname(Uname);
		 lp.enterPass(Pass);
		 lp.clickOnLogin();
		 bp.waitForElement();
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[0] = pp.selectProject(projectName);
			bp.waitForElement();
			actual[1] = pp.selectRelease(releaseName);
			bp.waitForElement();

			rp = new ReleasePage(driver);
			actual[2] = rp.clickOnTestRep();
			
		} catch (Exception e) {
			lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	
	@When("^User add a phase and add testcases with test step details$")
	public void user_add_a_phase_and_add_testcases_with_test_step_details() throws Throwable {
		try {
			bp = new BasePage();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			tr = new TestRepositoryPage(driver);
			actual[0] = tr.doubleClickOnRelease(releaseName);

			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 2);
			actual[1] = tr.addNode(name, name);
			bp.waitForElement();
			 String [] Phase =new String[1];
			 Phase[0]=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 2);
			 actual[2]=tr.navigateToNode(releaseName, Phase);
			 bp.waitForElement();

			actual[3] = tr.addTestCase();

			actual[4] = tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetail = new String[3];
			int k = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				k++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[5] = ctc.enterTestCaseStepDetail(stepDetail);
			bp.waitForElement();

			actual[6] = tr.clickOnList();
			for (int i = 1; i <= 2; i++) {
				actual[7] = tr.selectallTestCase();
				actual[8] = tr.cloneTestCase();
			}

			bp.waitForElement();
			
			
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			
		} catch (Exception e) {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a new cycle ,add phase to cycle and assign to lead$")
	public void create_a_new_cycle_add_phase_to_cycle_and_assign_to_lead() throws Throwable {
		try {
			rp = new ReleasePage(driver);

			tp = new TestPlanningPage(driver);

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 34, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 34, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 34, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 34, 13));

			actual[9] = tp.clickOnAddTestCycleSymbol();

			actual[10] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[11] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[12] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 5);
			actual[13] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 2);
			actual[14] = tp.addPhaseToCycle(phase);

			actual[15] = tp.cancelBulkAssign();

			String[] nodes = new String[1];
			nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 2);
			actual[16] = tp.navigateToCycle(nodes);
			actual[17] = tr.verifyPresentTestCase();
			actual[18] = tp.selectallTestCase();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[19] = tp.assignAllSelected(assignee);
		}

		catch (Exception e) {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test cases should be assign to lead$")
	public void test_cases_should_be_assign_to_lead() throws Throwable {

		try {
			actual[20] = tr.verifyPresentTestCase();
			int[] testcase = new int[4];
			for (int i = 0; i <= 3; i++) {
				testcase[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User4");
			actual[21] = tp.validateAllAssigned(testcase, assignee);
			bp.waitForElement();
			 tp.goBackToCycle();
			pp = new ProjectPage(driver);
			actual[22] = pp.clickOnLogout();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user login as other credential and launch test execution$")
	public void user_login_as_other_credential_and_launch_test_execution() throws Throwable {
		try {
			String Uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Username_2");
			String password = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Password_2");

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			lp = new LoginPage(driver);
			actual[23] = lp.enterUname(Uname);
			actual[24] = lp.enterPass(password);
			actual[25] = lp.clickOnLogin();
			bp.waitForElement();
			actual[26] = pp.selectProject(projectName);
			actual[27] = pp.selectRelease(releaseName);

			actual[28] = rp.clickOnTestExecution();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^view executions assigned to lead$")
	public void view_executions_assigned_to_lead() throws Throwable {

		try {
			exp = new ExecutionPage(driver);
			String[] nodes = new String[2];
			nodes[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			nodes[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 5);
			actual[29] = exp.validateExecutions(nodes);
			bp.waitForElement();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User launch test planning module$")
	public void user_launch_test_planning_module() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[30] = rp.clickOnTestPlanning();
			bp.waitForElement();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^assign same phase to tester$")
	public void assign_same_phase_to_tester() throws Throwable {
		try {

			String[] nodes = new String[2];
			nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 5);
			nodes[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 2);
			actual[31] = tp.doubleClickOnCycle(nodes[0]);
			bp.waitForElement();
			actual[32] = tp.navigateToCycle(nodes);

			actual[33] = tp.assignPhase();
			bp.waitForElement();
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 34, 2);

			actual[34] = tp.navigateToCycle(phase);
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[35] = tp.selectallTestCase();
			actual[36] = tp.assignAllSelected(assignee);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^check for assignments in test planning$")
	public void check_for_assignments_in_test_planning() throws Throwable {
		try {
			int[] testcase = new int[4];
			for (int i = 0; i <= 3; i++) {
				testcase[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[37] = tp.validateAllAssigned(testcase, assignee);
			bp.waitForElement();
			 tp.goBackToCycle();
			bp.waitForElement();
			pp = new ProjectPage(driver);
			actual[38] = pp.clickOnLogout();
			pp.closeBrowser();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		}

		catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
