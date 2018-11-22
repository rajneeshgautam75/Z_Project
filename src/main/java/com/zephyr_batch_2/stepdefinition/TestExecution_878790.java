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

public class TestExecution_878790 extends LaunchBrowser {
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
	String filename="TestExecution_878790";
	boolean[] actual = new boolean[29];
	SoftAssert soft = new SoftAssert();

	// @Given("^Login as manager credential$")
	// public void login_as_manager_credential() throws Throwable {
	// try
	// {
	//
	//
	// pp=new ProjectPage(driver);
	// bp=new BasePage();
	// lp=new LoginPage(driver);
	// String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,
	// "Manager_Username_1");
	// String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,
	// "Manager_Password_1");
	// pp.clickOnLogout();
	// lp.enterUnameAndPassword(Uname, Pwd);
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// driver.close();
	// Relogin_TPE rl=new Relogin_TPE();
	// rl.reLogin();
	// throw e;
	// }
	// }
	//
	// @When("^user click on customization and create Execution status\\(N/A\\)
	// and save it$")
	// public void
	// user_click_on_customization_and_create_Execution_status_N_A_and_save_it()
	// throws Throwable {
	// try
	// {
	// exp=new ExecutionPage(driver);
	// exp.navigatingToCustomizationStatusTab();
	// String value=Excel_Lib.getData(INPUT_PATH_2,"Files", 1, 2);
	// String colour=Excel_Lib.getData(INPUT_PATH_2,"Files", 1, 3);
	// exp.createCustomStaus(value, colour);
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// driver.close();
	// Relogin_TPE rl=new Relogin_TPE();
	// rl.reLogin();
	// throw e;
	// }
	// }
	//
	// @When("^create another execution status \\(Future Scope\\) and save it$")
	// public void create_another_execution_status_Future_Scope_and_save_it()
	// throws Throwable {
	// try
	// {
	// String value=Excel_Lib.getData(INPUT_PATH_2,"Files", 2, 2);
	// String colour=Excel_Lib.getData(INPUT_PATH_2,"Files", 2, 3);
	// exp.createCustomStaus(value, colour);
	//
	// exp.closeExecutionStatusPage.click();
	// bp.waitForElement();
	// pp.clickOnLogout();
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// driver.close();
	// Relogin_TPE rl=new Relogin_TPE();
	// rl.reLogin();
	// throw e;
	// }

	// }

	@Given("^Login as Lead role$")
	public void login_as_Lead_role() throws Throwable {
		try {

			pp = new ProjectPage(driver);
			bp = new BasePage();
			lp = new LoginPage(driver);
			String Uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Username_1");
			String pwd = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Password_1");
			lp = new LoginPage(driver);
			actual[0] = pp.clickOnLogout();

			actual[1] = lp.enterUnameAndPassword(Uname, pwd);
            bp.waitForElement();
			exp = new ExecutionPage(driver);
		} catch (Exception e) {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	// @When("^login as Lead role$")
	// public void login_as_Lead_role() throws Throwable {
	//
	//
	// }

	@When("^navigate to test repository page$")
	public void navigate_to_test_repository_page() throws Throwable {
		try {
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			pp = new ProjectPage(driver);
			bp = new BasePage();

			actual[2] = pp.selectProject(projectName);
			actual[3] = pp.selectRelease(releaseName);
			pp = new ProjectPage(driver);

			rp = new ReleasePage(driver);
			actual[4] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a phase and add a testcase with test step details$")
	public void create_a_phase_and_add_a_testcase_with_test_step_details() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			actual[5] = tr.clickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 2);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 2);
			actual[6] = tr.addNode(name, desc);
			bp.waitForElement();
			String [] Phase =new String[1];
			Phase[0]=name;
			tr.navigateToNode(releaseName, Phase);
			bp.waitForElement();
			actual[7] = tr.selectPhase(name);
			actual[8] = tr.addTestCase();
			actual[9] = tr.clickDetailButton();
			bp.waitForElement();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 14);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 15);
			actual[10] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);

			bp.waitForElement();
			
			String[] stepdetail = new String[3];
			int l = 0;
			for (int i = 19; i <= 21; i++) {
				stepdetail[l] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				l++;
			}

			actual[11] = ctc.enterTestCaseStepDetail(stepdetail);
			bp.waitForElement();
			
			tr.clickOnList();
			bp.waitForElement();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^launch test planning module and create a new cycle$")
	public void launch_test_planning_module_and_create_a_new_cycle() throws Throwable {

		try {
			actual[12] = rp.clickOnTestPlanning();
			tp = new TestPlanningPage(driver);

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 12, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 12, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 12, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 12, 13));

			actual[13] = tp.clickOnAddTestCycleSymbol();

			actual[14] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[15] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[16] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 5);
			actual[17] = tp.navigateToCycle(cycle);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add a created phase to the cycle and assign to the lead$")
	public void add_a_created_phase_to_the_cycle_and_assign_to_the_lead() throws Throwable {
		try {
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 2);
			actual[18] = tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[19] = tp.cancelBulkAssign();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 2);
			actual[20] = tp.navigateToCycle(cycle);
			bp.waitForElement();

			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			actual[21] = tp.individualAssinTo(testcase, assignee);
			
			tp.goBackToCycle();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^launch test execution page$")
	public void launch_test_execution_page() throws Throwable {
		try {
			actual[22] = rp.clickOnTestExecution();

		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^view the execution assigned by lead$")
	public void view_the_execution_assigned_by_lead() throws Throwable {
		try {
			String[] cycleName = new String[3];
			cycleName[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			cycleName[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 5);
			cycleName[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 2);
			actual[23] = tp.navigateToCycle(cycleName);
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User2");
			exp = new ExecutionPage(driver);

			actual[24] = exp.validateAssignedTestCase(testcase, assignee);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^change the execution status to N/A$")
	public void change_the_execution_status_to_N_A() throws Throwable {

		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 17);
			actual[25] = exp.changeStatusOfTestCases(testcase, status);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^execution status should be change to N/A$")
	public void execution_status_should_be_change_to_N_A() throws Throwable {
		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 17);
			actual[26] = exp.ValidateStatusOfTestCases(testcase, status);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user change the execution status to Future Scope status$")
	public void user_change_the_execution_status_to_Future_Scope_status() throws Throwable {
		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 17);
			actual[27] = exp.changeStatusOfTestCases(testcase, status);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^execution status should be change to Future Scope$")
	public void execution_status_should_be_change_to_Future_Scope() throws Throwable {
		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 17);
			actual[28] = exp.ValidateStatusOfTestCases(testcase, status);
            bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
