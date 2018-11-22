package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_9 extends LaunchBrowser {
	LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exe;
	DashBoardPage db;

	String fileName = "DashBoard_Permission_9";

	boolean[] actual = new boolean[40];
	SoftAssert soft = new SoftAssert();

	@Given("^Login as lead Credential$")
	public void login_as_lead_Credential() throws Throwable {
		try {
			String uName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Username_1");
			String passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Password_1");

			pp = new ProjectPage(driver);
			lp = new LoginPage(driver);
			bp = new BasePage();
			actual[0] = pp.clickOnLogout();
			actual[1] = lp.enterUnameAndPassword(uName, passWord);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^lead navigate to test repository page$")
	public void lead_navigate_to_test_repository_page() throws Throwable {
		try {
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_3");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");

			rp = new ReleasePage(driver);
			actual[2] = pp.selectProject(projectName);

			actual[3] = pp.selectRelease(releaseName);
			actual[4] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Add a node with name and description$")
	public void add_a_node_with_name_and_description() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");

			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 9);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 10);
			actual[5] = tr.clickOnRelease(releaseName);
			actual[6] = tr.addNode(phaseName, phaseDesc);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^node sucessfully created$")
	public void node_sucessfully_created() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");

			String[] phaseName = new String[1];
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 9);
			actual[7] = tr.navigateToNode(releaseName, phaseName);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user add multiple\\(five\\) testcases in node$")
	public void user_add_multiple_five_testcases_in_node() throws Throwable {
		try {
			for (int i = 0; i <= 4; i++) {
				actual[8] = tr.addTestCase();
			}
		} catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;

		}
	}

	@Then("^testcases successfully added in node$")
	public void testcases_successfully_added_in_node() throws Throwable {
		try {
			actual[9] = tr.verifyPresentTestCase();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^lead navigate to test planning page$")
	public void lead_navigate_to_test_planning_page() throws Throwable {
		try {
			actual[10] = rp.clickOnTestPlanning();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a cycle and add phase to cycle and assign to lead$")
	public void create_a_cycle_and_add_phase_to_cycle_and_assign_to_lead() throws Throwable {

		try {
			tp = new TestPlanningPage(driver);
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 39, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 39, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 39, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 39, 13));

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 5);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 2);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 22);

			actual[11] = tp.clickOnAddTestCycleSymbol();

			actual[12] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[13] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[14] = tp.saveTestCycle();
			bp.waitForElement();

			actual[15] = tp.navigateToCycle(cycle);

			actual[16] = tp.addPhaseToCycle(phase);

			actual[17] = tp.bulkAssignment(bulkType);
			bp.waitForElement();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^testcases successfully assign to lead$")
	public void testcases_successfully_assign_to_lead() throws Throwable {
		try {
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 9);
			actual[18] = tp.doubleClickOnCycle(cycle[0]);

			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
			int[] testcase = new int[5];

			for (int i = 0; i <= testcase.length - 1; i++) {
				testcase[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}

			actual[19] = tp.validateAllAssigned(testcase, assignee);
			
			tp.goBackToCycle();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^lead navigate to test exexution page$")
	public void lead_navigate_to_test_exexution_page() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");

			String[] phaseName = new String[2];
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 39, 5);
			phaseName[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 9);
			actual[20] = rp.clickOnTestExecution();
			actual[21] = tr.navigateToNode(releaseName, phaseName);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^execute all testcases to Pass$")
	public void execute_all_testcases_to_Pass() throws Throwable {
		try {
			exe = new ExecutionPage(driver);
			int[] testcase = new int[5];
			for (int i = 0; i <= 4; i++) 
			{
				
				testcase[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
				String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
				actual[22] = exe.changeStatusOfTestCases(testcase, status);
		
				
		
		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^testcases successfully executed to Pass$")
	public void testcases_successfully_executed_to_Pass() throws Throwable {
		try {
			int[] testcase = new int[5];
			for (int i = 0; i <= 4; i++) {

				testcase[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}

			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			actual[23] = exe.ValidateStatusOfTestCases(testcase, status);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^lead navigate to dashboard page$")
	public void lead_navigate_to_dashboard_page() throws Throwable {
		try {
			db = new DashBoardPage(driver);
			actual[24] = db.clickOnManageDashboards();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^manage Dashboard page should be displayed$")
	public void manage_Dashboard_page_should_be_displayed() throws Throwable {
		try {
			actual[25] = db.validateDashboards();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^lead create a dashboard with share type as Project Team$")
	public void lead_create_a_dashboard_with_share_type_as_Project_Team() throws Throwable {
		try {
			String dashBoardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 1);
			String dashBoardDesc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 2);
			String layout = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 3);
			String shareType = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 4);
			actual[26] = db.clickOnAddDashBoardSymbol();

			actual[27] = db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^dashboard should be successfully created$")
	public void dashboard_should_be_successfully_created() throws Throwable {
		try {
			String dashBoardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 1);
			actual[28] = db.validateDashBoard(dashBoardName);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^lead add a gadget and save it$")
	public void lead_add_a_gadget_and_save_it() throws Throwable {
		try {
			String dashBoard = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 1);

			String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 5);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_3");
			actual[29] = db.selectDashboard(dashBoard);
			actual[30] = db.clickOnAddGadgetSymbol();
			actual[31] = db.addGadget(gadgetName);
			actual[32] = db.configureProjectStatusGadget(projectName);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^gadget should be successfully saved$")
	public void gadget_should_be_successfully_saved() throws Throwable {
		try {
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_3");
			actual[33] = db.validateSavedGadget(projectName);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^login as other lead Credential$")
	public void login_as_other_lead_Credential() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			lp = new LoginPage(driver);

			String uName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Username_2");
			String passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Password_2");

			actual[34] = pp.clickOnLogout();
			actual[35] = lp.enterUnameAndPassword(uName, passWord);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to dashboard page$")
	public void navigate_to_dashboard_page() throws Throwable {
		try {
			db = new DashBoardPage(driver);
			actual[36] = db.clickOnManageDashboards();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^dashboard page should be_displayed$")
	public void dashboard_page_should_be_displayed() throws Throwable {
		try {
			actual[37] = db.validateDashboards();
		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^second user attempt to view the dashboard if user dont have acess to project$")
	public void second_user_attempt_to_view_the_dashboard_if_user_dont_have_acess_to_project() throws Throwable {
		try {
			String dashBoardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 1);
			actual[38] = db.searchDashboard(dashBoardName);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^should not show the dashboard$")
	public void should_not_show_the_dashboard() throws Throwable {
		try {
			String dashBoardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 51, 1);
			actual[39] = db.validateDashBoard(dashBoardName);

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println("Actual[" + k + "]=" + actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

}
