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

public class TestExecution_878836 extends LaunchBrowser {

	LaunchBrowser lb;
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

	boolean[] actual = new boolean[38];
	SoftAssert soft = new SoftAssert();

	 String fileName="TestExecution_878836";
	 
	@When("^User add a phase and add two system under phase$")
	public void user_add_a_phase_and_add_two_system_under_phase() throws Throwable {
		try {
			lb=new LaunchBrowser();
			tr = new TestRepositoryPage(driver);
			bp = new BasePage();

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 2);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 2);
			actual[0]=tr.doubleClickOnRelease(releaseName);
			actual[1]=tr.addNode(phaseName, phaseDesc);

			bp.waitForElement();

			  
		  	String[] phase=new String[1];
		 	  phase[0]=phaseName;
		 	  
		 	  actual[2]=tr.navigateToNode(releaseName, phase);
			
			//actual[2]=tr.selectPhase(phaseName);
			String sysName1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 3);
			String sysDesc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 3);
			actual[3]=tr.addNode(sysName1, sysDesc1);

			bp.waitForElement();
			//actual[4]=tr.selectPhase(phaseName);
			 actual[4]=tr.navigateToNode(releaseName, phase);
			String sysName2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 4);
			String sysDesc2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 4);
			actual[5]=tr.addNode(sysName2, sysDesc2);

			actual[6]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add ten testcases with test steps detail to each node$")
	public void add_ten_testcases_with_test_steps_detail_to_each_node() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String[] nodes = new String[2];
			nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 2);
			nodes[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 3);
			//nodes[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 4);
			
			String[] nodes1 = new String[3];
			nodes1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 2);
			nodes1[1] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 3);
			nodes1[2] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 4);
			actual[7]=tr.navigateToNode(releaseName, nodes);
			bp.waitForElement();
			ctc = new CreateTestCasePage(driver);
			for (int j = 0; j <= 2; j++) {
				bp.waitForElement();
				actual[8]=tr.selectPhase(nodes1[j]);
				actual[9]=tr.addTestCase();
				bp.waitForElement();
				actual[10]=tr.clickDetailButton();
				bp.waitForElement();
				String testCaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", j + 31, 14);
				String testCaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", j + 31, 15);
				ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);

				String[] stepDetail = new String[3];
				int k = 0;
				for (int i = 19; i <= 21; i++) {
					stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
					k++;
				}
				ctc = new CreateTestCasePage(driver);
				actual[11] = ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
				bp.waitForElement();
				
				ep=new ExportPage(driver);
				String[] testcase=new String[1];
				 testcase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
				ep.selectMultipleTestCaseFromGrid(testcase);
				actual[12]=tr.cloneTestCase();
				bp.waitForElement();
				for (int l = 1; l <= 1; l++) {
					tr.selectallTestCase();
					tr.cloneTestCase();
				}
				for (int m = 1; m <= 3; m++) {
					tr.cloneTestCase();
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

	@When("^add a cycle, add phase to cycle and assign to tester$")
	public void add_a_cycle_add_phase_to_cycle_and_assign_to_tester() throws Throwable {
		try {
			bp=new BasePage();
			tp = new TestPlanningPage(driver);
			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 31, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 31, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 31, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 31, 13));
			tp = new TestPlanningPage(driver);
			actual[13] = tp.clickOnAddTestCycleSymbol();

			actual[14] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[15] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[16] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 5);
			actual[17] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 2);
			actual[18] = tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[19] = tp.cancelBulkAssign();
			bp.waitForElement();

			String[] phase1 = new String[1];
			phase1[0] = phase;
			actual[20] = tp.navigateToCycle(phase1);

			int[] testcase = new int[10];
			for (int i = 1; i <= 10; i++) {
				testcase[i - 1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i, 27);
			}
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[21] = tp.individualAssinTo(testcase, assignee);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be assing to tester$")
	public void test_case_should_be_assing_to_tester() throws Throwable {
		try {
			int[] testcase = new int[10];
			for (int i = 1; i <= 10; i++) {
				testcase[i - 1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i, 27);
			}
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[22]=tp.validateAllAssigned(testcase, assignee);
			
			rp=new ReleasePage(driver);
			//rp.clickOnTestPlanning();
			pp = new ProjectPage(driver);
			actual[23]=pp.clickOnLogout();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user login as tester role$")
	public void user_login_as_tester_role() throws Throwable {
		try {
			
			pp=new ProjectPage(driver);
			//pp.clickOnLogout();
			
			
			
			String Uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Tester_Username_1");
			String password = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Tester_Password_1");

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);

			lp = new LoginPage(driver);
			actual[24]=lp.enterUname(Uname);
			actual[25]=lp.enterPass(password);
			actual[26]=lp.clickOnLogin();
			actual[27]=pp.selectProject(projectName);
			actual[28]=pp.selectRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^launch test execution and navigate to phase$")
	public void launch_test_execution_and_navigate_to_phase() throws Throwable {
		try
		{
			
		
			
			rp = new ReleasePage(driver);
			rp.clickOnTestExecution();
			String[] cycle = new String[3];
			cycle[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 5);
			cycle[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 31, 2);
			actual[29] = tp.navigateToCycle(cycle);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^select a testcase and execute it to Pass/Fail$")
	public void select_a_testcase_and_execute_it_to_Pass_Fail() throws Throwable {
		try {
			exp = new ExecutionPage(driver);
			int testcase = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			actual[30]=exp.executeStatus(testcase, status);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on D button,search a defect and link it$")
	public void click_on_D_button_search_a_defect_and_link_it() throws Throwable {
		try {
			int testcase = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
			actual[31]=exp.clickOnDefectButton(testcase);
			String defectId = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
			actual[32]=exp.linkDefect(defectId);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^testcase should be link with defect$")
	public void testcase_should_be_link_with_defect() throws Throwable {
		try {
			int testcase = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);

			String defectId = Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
			actual[33]=exp.validateLinkedDefect(testcase, defectId);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user add attachement in differen formats\\(png,jpg,jpeg,bmp,gif\\)$")
	public void user_add_attachement_in_differen_formats_png_jpg_jpeg_bmp_gif() throws Throwable {
		try {
			
			tr.clickDetailButton();
			bp.waitForElement();
			String[] testcase=new String[1];
			 testcase[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			exp.selectMultipleTestCaseFromExecutionGrid(testcase);
			bp.waitForElement();
			
			String[] filePath = new String[5];
			for (int i = 0; i <= 4; i++) {
				filePath[i] = Excel_Lib.getData(INPUT_PATH_2, "Files", i + 7, 1);
			}
			actual[34]=exp.uploadAttachement(filePath);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^attachement should be attached to tescase$")
	public void attachement_should_be_attached_to_tescase() throws Throwable {
		try {
			// String
			// filePath=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			for (int i = 0; i <= 4; i++) {
				String fileName = Excel_Lib.getData(INPUT_PATH_2, "Files", i + 7, 0);
				actual[35]=exp.validateAttachement(fileName);
			}
			bp.waitForElement();
			
			
			lp = new LoginPage(driver);
			pp = new ProjectPage(driver);
			actual[36]=pp.clickOnLogout();
			
			String uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Username_1");
			String password = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Lead_Password_1");
			actual[37]=lp.enterUnameAndPassword(uname, password);
            
            
            for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
            
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

}
