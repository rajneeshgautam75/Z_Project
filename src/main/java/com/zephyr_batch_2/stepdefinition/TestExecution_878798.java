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

public class TestExecution_878798 extends LaunchBrowser {
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878798";
	boolean[] actual = new boolean[25];
	SoftAssert soft = new SoftAssert();

	// @Given("^Login as manager role$")
	// public void login_as_manager_role() throws Throwable {
	// lp= new LoginPage(driver);
	// String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,
	// "Manager_Username_1");
	// String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,
	// "Manager_Password_1");
	//
	// lp.enterUnameAndPassword(Uname, pwd);
	// pp=new ProjectPage(driver);
	//
	// }
	//
	// @When("^User click on customizations and create three custom status$")
	// public void user_click_on_customizations_and_create_three_custom_status()
	// throws Throwable {
	// exp=new ExecutionPage(driver);
	// exp.navigatingToCustomizationStatusTab();
	// String value1=Excel_Lib.getData(INPUT_PATH_2, "Files", 3, 3);
	// String colour1=Excel_Lib.getData(INPUT_PATH_2, "Files", 3, 4);
	// exp.createCustomStaus(value1, colour1);
	//
	// String value2=Excel_Lib.getData(INPUT_PATH_2, "Files", 4, 3);
	// String colour2=Excel_Lib.getData(INPUT_PATH_2, "Files", 4, 4);
	// exp.createCustomStaus(value2, colour2);
	//
	// String value3=Excel_Lib.getData(INPUT_PATH_2, "Files", 5, 3);
	// String colour3=Excel_Lib.getData(INPUT_PATH_2, "Files", 5, 4);
	// exp.createCustomStaus(value3, colour3);
	//
	//
	// }
	//
	// @When("^logout from the application$")
	// public void logout_from_the_application() throws Throwable {
	// pp.clickOnLogout();
	// }

	// @When("^login as lead role$")
	// public void login_as_lead_role() throws Throwable {
	//
	// try
	// {
	//
	// String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,
	// "Lead_Username_1");
	//
	// String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,
	// "Lead_Password_1");
	// pp=new ProjectPage(driver);
	// lp=new LoginPage(driver);
	// actual[0]=pp.clickOnLogout();
	// actual[1]=lp.enterUnameAndPassword(Uname, pwd);
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// driver.close();
	// Relogin_TPE rl=new Relogin_TPE();
	// rl.reLogin();
	// throw e;
	// }
	//
	//
	// }

	@Given("^Login as Lead role credential$")
	public void login_as_Lead_role_credential() throws Throwable {
		try {

			bp=new BasePage();
			String Uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Username_1");

			String pwd = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Password_1");
			pp = new ProjectPage(driver);
			lp = new LoginPage(driver);
			actual[0] = pp.clickOnLogout();
			actual[1] = lp.enterUnameAndPassword(Uname, pwd);
		} catch (Exception e) {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^navigate to the test repository page$")
	public void navigate_to_the_test_repository_page() throws Throwable {
		try {

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			pp = new ProjectPage(driver);
			//bp = new BasePage();
			actual[2] = pp.selectProject(projectName);
			actual[3] = pp.selectRelease(releaseName);
			rp = new ReleasePage(driver);
			actual[4] = rp.clickOnTestRep();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a phase and add test case with test step details$")
	public void create_a_phase_and_add_test_case_with_test_step_details() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 2);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 2);
			actual[5] = tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[6] = tr.addNode(name, desc);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=name;
			 bp.waitForElement();
			actual[7]=tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			actual[8] = tr.addTestCase();
			actual[9] = tr.clickDetailButton();
			bp.waitForElement();
			ctc = new CreateTestCasePage(driver);

			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 14);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 15);
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

	@When("^Launch the test planning module$")
	public void launch_the_test_planning_module() throws Throwable {

		try {
			rp=new ReleasePage(driver);
			actual[12] = rp.clickOnTestPlanning();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a new cycle and add phase to the cycle and assign to lead$")
	public void create_a_new_cycle_and_add_phase_to_the_cycle_and_assign_to_lead() throws Throwable {
		try {
			tp = new TestPlanningPage(driver);
			// tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 13, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 13, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 13, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 13, 13));

			actual[13] = tp.clickOnAddTestCycleSymbol();

			actual[14] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[15] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[16] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 5);
			actual[17] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 2);
			actual[18] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 22);
			actual[19] = tp.bulkAssignment(bulkType);
			
			 tp.goBackToCycle();
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the phase in test Execution module$")
	public void navigate_to_the_phase_in_test_Execution_module() throws Throwable {

		try {
			rp=new ReleasePage(driver);
			rp.clickOnTestExecution();
			bp.waitForElement();
			String[] cycle = new String[2];
			String release= Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 5);
			cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 2);
			actual[20] =tr.navigateToNode(release,cycle);
			bp.waitForElement();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Change the execution status to N/A$")
	public void change_the_execution_status_to_N_A() throws Throwable {
		try {
			exp = new ExecutionPage(driver);
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 17);
			actual[21] = exp.changeStatusOfTestCases(testcase, status);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Execution status should be change to N/A$")
	public void execution_status_should_be_change_to_N_A() throws Throwable {
		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 12, 17);
			actual[22] = exp.ValidateStatusOfTestCases(testcase, status);
		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^change execution status to Future Release$")
	public void change_execution_status_to_Future_Release() throws Throwable {
		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 17);
			actual[23] = exp.changeStatusOfTestCases(testcase, status);

		} catch (Exception e) {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^execution status should be change to Future Release$")
	public void execution_status_should_be_change_to_Future_Release() throws Throwable {
		try {
			int[] testcase = new int[1];
			testcase[0] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 17);
			actual[24] = exp.ValidateStatusOfTestCases(testcase, status);

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
