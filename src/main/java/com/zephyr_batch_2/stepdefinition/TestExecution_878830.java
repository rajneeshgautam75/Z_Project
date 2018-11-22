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

public class TestExecution_878830 extends LaunchBrowser {

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

	boolean[] actual = new boolean[55];
	SoftAssert soft = new SoftAssert();
        LaunchBrowser lb=new LaunchBrowser();
        String fileName="TestExecution_878830";
        
        

@Given("^User is in test repository pages$")
public void user_is_in_test_repository_pages() throws Throwable {
	try {
		lb=new LaunchBrowser();
		bp = new BasePage();
		pp = new ProjectPage(driver);
        pp.clickOnLogout();
        
        lp=new LoginPage(driver);
        String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
        String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");

        lp.enterUname(userName);
        lp.enterPass(passWord);
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
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}


}


        
	
	@When("^User add a phase with name and description$")
	public void user_add_a_phase_with_name_and_description() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			bp = new BasePage();
			tr = new TestRepositoryPage(driver);
			actual[0] = tr.doubleClickOnRelease(releaseName);
			actual[1] = tr.addNode(phaseName, phaseDesc);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^add ten testcases with stepdetails and priority$")
	public void add_ten_testcases_with_stepdetails_and_priority() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 14);
			String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 15);
			
			String[] phase=new String[1];
		 	  phase[0]=phaseName;
		 	  
		 	  actual[2]=tr.navigateToNode(releaseName, phase);
			
			///actual[2] = tr.selectPhase(phaseName);
			actual[3] = tr.addTestCase();
			bp.waitForElement();
			actual[4] = tr.clickDetailButton();
			ctc = new CreateTestCasePage(driver);
			actual[5] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);

			String[] stepDetail = new String[3];
			int k = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				k++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[6] = ctc.enterTestCaseStepDetail(stepDetail);

			String[] details = new String[3];
			details[0] = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 3);
			details[1] = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 99);
			details[2] = Excel_Lib.getData(INPUT_PATH_2, "Defects", 99, 99);

			actual[7] = ctc.enterTestCaseDetails(details[0], details[1], details[2]);
			bp.waitForElement();

			String[] customField = new String[6];
			for (int m = 0; m <= 5; m++) {
				customField[m] = Excel_Lib.getData(INPUT_PATH_2, "Defects", m + 1, 6);
			}
			actual[8] = ctc.enterCustomFields(customField[0], customField[1], customField[2], customField[3],
					customField[4], customField[5]);
			bp.waitForElement();
			actual[9] = tr.clickOnList();
			bp.waitForElement();
			for (int i = 1; i <= 2; i++) {
				actual[10] = tr.selectallTestCase();
				actual[11] = tr.cloneTestCase();
			}
			for (int i = 1; i <= 3; i++) {
				actual[12] = tr.cloneTestCase();
			}

			ep = new ExportPage(driver);
			String[] testcase = new String[2];
			testcase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			testcase[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 2, 27));
			actual[13] = ep.selectMultipleTestCaseFromGrid(testcase);

			for (int i = 1; i <= 4; i++) {

				String[] testcase1 = new String[1];
				testcase1[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i +1, 27));
				actual[14] = ep.selectMultipleTestCaseFromGrid(testcase1);
				bp.waitForElement();
				actual[15] = tr.clickDetailButton();
				bp.waitForElement();
				String[] details1 = new String[3];
				details1[0] = Excel_Lib.getData(INPUT_PATH_2, "Export", i, 3);
				details1[1] = Excel_Lib.getData(INPUT_PATH_2, "Export", i, 99);
				details1[2] = Excel_Lib.getData(INPUT_PATH_2, "Export", i, 99);

				actual[16] = ctc.enterTestCaseDetails(details1[0], details1[1], details1[2]);
				bp.waitForElement();
				bp.waitForElement();
				actual[17] = tr.clickOnList();
				bp.waitForElement();

			}
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add two system to phase$")
	public void add_two_system_to_phase() throws Throwable {
		try {
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			String[] sysName = new String[2];
			String[] sysDesc = new String[2];
			for (int i = 0; i <= 1; i++)
			{
				sysName[i] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, i + 3);
				sysDesc[i] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, i + 3);
				actual[18] = tr.selectPhase(phaseName);

				actual[19] = tr.addNode(sysName[i], sysDesc[i]);
				bp.waitForElement();
				bp.waitForElement();
			}
			
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add testcases with all details$")
	public void add_testcases_with_all_details() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			
			String[] nodes = new String[2];
			nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			nodes[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 3);
			//nodes[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 4);
			
			String[] nodes1 = new String[3];
			nodes1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			nodes1[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 3);
			nodes1[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 4);
			actual[20] = tr.navigateToNode(releaseName, nodes);
			for (int i = 1; i <= 2; i++) {

				actual[21] = tr.selectPhase(nodes1[i]);
				actual[22] = tr.addTestCase();

				bp.waitForElement();
				actual[23] = tr.clickDetailButton();
				bp.waitForElement();
				ctc = new CreateTestCasePage(driver);
				String testCaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", i + 29, 14);
				String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", i + 29, 15);
				actual[24] = ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);

				String[] stepDetail = new String[3];
				int k = 0;
				for (int j = 19; j <= 21; j++) {
					stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, j);
					k++;
				}
				ctc = new CreateTestCasePage(driver);
				actual[25] = ctc.enterTestCaseStepDetail(stepDetail);

				String[] details = new String[3];
				details[0] = Excel_Lib.getData(INPUT_PATH_2, "Export", i+1, 3);
				details[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);
				details[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);

				actual[26] = ctc.enterTestCaseDetails(details[0], details[1], details[2]);

				String day =Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 23));
				String hr = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 24));
				String mn = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 25));
				actual[27] = ctc.enterEstimatedTime(day, hr, mn);
				bp.waitForElement();
				actual[28] = tr.clickOnList();
				bp.waitForElement();
				for (int l = 1; l <= 4; l++) {
					actual[29] = tr.selectallTestCase();
					actual[30] = tr.cloneTestCase();
				}
				
				bp.waitForElement();
			}
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^create a new cycle and add phase to cycle and assign to tester$")
	public void create_a_new_cycle_and_add_phase_to_cycle_and_assign_to_tester() throws Throwable {

		try {
			tp = new TestPlanningPage(driver);

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 28, 13));

			actual[31] = tp.clickOnAddTestCycleSymbol();

			actual[32] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[33] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,endDateMonth, endDateDay);
			actual[34] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 5);
			actual[35] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			actual[36] = tp.addPhaseToCycle(phase);

			actual[37] = tp.cancelBulkAssign();

			String[] nodes = new String[1];
			nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			actual[38] = tp.navigateToCycle(nodes);
			actual[39] = tp.selectallTestCase();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[40] = tp.assignAllSelected(assignee);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^test cases should be assing to tester$")
	public void test_cases_should_be_assing_to_tester() throws Throwable {
		try {
			int[] testcase = new int[10];
			for (int i = 0; i <= 9; i++) {
				testcase[i] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i + 1, 27);
			}
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[41] = tp.validateAllAssigned(testcase, assignee);
			tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Login as tester role$")
	public void user_Login_as_tester_role() throws Throwable {

		try {
			bp=new BasePage();
			
			lp=new LoginPage(driver);
			pp=new ProjectPage(driver);
			String Uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Tester_Username_1");
			String password = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Tester_Password_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			
			pp.clickOnLogout();
			bp.waitForElement();
			actual[42] = lp.enterUname(Uname);
			actual[43] = lp.enterPass(password);
			actual[44] = lp.clickOnLogin();
			//pp = new ProjectPage(driver);
			actual[45] = pp.selectProject(projectName);
			actual[46] = pp.selectRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Launch test execution module and navigate to node$")
	public void launch_test_execution_module_and_navigate_to_node() throws Throwable {
		try {
			
			exp=new ExecutionPage(driver);
			
			
			rp = new ReleasePage(driver);
			rp.clickOnTestExecution();

			String[] cycle = new String[3];
			cycle[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 5);
			cycle[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 28, 2);
			actual[47] = tp.navigateToCycle(cycle);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^execute testcases to custom status$")
	public void execute_testcases_to_custom_status() throws Throwable {

		try {
			exp = new ExecutionPage(driver);

			actual[48] = exp.selectAndDeselectAllTestCase();
			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			actual[49] = exp.changeMultiSelectedStatus(status);

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on Defect button,search and link a defect$")
	public void click_on_Defect_button_search_and_link_a_defect() throws Throwable {

		try {
			int testcase = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			actual[50] = exp.clickOnDefectButton(testcase);
			String defectId = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
			actual[51] = exp.linkDefect(defectId);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^defect should be linked with testcase$")
	public void defect_should_be_linked_with_testcase() throws Throwable {
		try {
			int testcase = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			String defectId = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
			actual[52] = exp.validateLinkedDefect(testcase, defectId);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user sort the testcase grid\\(ID/Priority/Summary/Custom Field\\)$")
	public void user_sort_the_testcase_grid_ID_Priority_Summary_Custom_Field() throws Throwable {
		try {
			String[] sortName = new String[3];
			sortName[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 29);
			sortName[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 29);
			//sortName[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 29);
			//sortName[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 29);
			sortName[2] = "CustomText";
			
			actual[53] = exp.sort(sortName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Sort column should visible in test case grid$")
	public void sort_column_should_visible_in_test_case_grid() throws Throwable {

		try {
			String[] sortName = new String[3];
//			sortName[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 29);
			sortName[0] = "Test Case ID";
			sortName[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 29);
			//sortName[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 9, 29);
			//sortName[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 8, 29);
			sortName[2] = "CustomText";
			actual[54] = exp.validateSort(sortName);
			bp.waitForElement();

//			pp = new ProjectPage(driver);
//			pp.clickOnLogout();
//			driver.close();
			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

			
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
