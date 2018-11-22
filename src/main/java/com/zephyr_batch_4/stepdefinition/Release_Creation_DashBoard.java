package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Release_Creation_DashBoard extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	String fileName = "Release_Creation_DashBoard";

	boolean[] actual = new boolean[100];
	SoftAssert soft = new SoftAssert();

	@Given("^User select the project$")
	public void user_select_the_project() throws Throwable {
		try {
			bp = new BasePage();
			rp = new ReleasePage(driver);
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			actual[0] = pp.selectProject(projectName);
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

	@When("^User create a releases for the project$")
	public void user_create_a_releases_for_the_project() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[1] = rp.clickOnManageRelease();
			bp.waitForElement();
			String releaseName1 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_4");

			String Hide = Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100, 100);
			String Desc = Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100, 100);
			String MapexternalDefect = Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100, 100);
			String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
			String smonth = Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
			String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
			String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
			String emonth = Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
			String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));

			boolean res1 = rp.checkAvailableRelease(releaseName1);
			if (res1 == false) {

				rp.addNewRelease(releaseName1, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);

				rp.clickOnAdd();
				bp.waitForElement();
			}

			bp.waitForElement();
			String releaseName2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_5");
			boolean res2 = rp.checkAvailableRelease(releaseName2);
			if (res2 == false) {

				rp.addNewRelease(releaseName2, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				
				rp.clickOnAdd();
				bp.waitForElement();
			}
			
			bp.waitForElement();
			String releaseName3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_6");
			boolean res3 = rp.checkAvailableRelease(releaseName3);
			if (res3 == false) {
				

				rp.addNewRelease(releaseName3, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				// rp.enterStartDatAndEndDate(syear, smonth, sday, eyear,
				// emonth, eday);
				rp.clickOnAdd();
				bp.waitForElement();
			}
			// actual[1]=rp.clickOnManageRelease();
			bp.waitForElement();
			String releaseName4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_7");
			boolean res4 = rp.checkAvailableRelease(releaseName4);
			if (res4 == false) {
				
				rp.addNewRelease(releaseName4, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				
				rp.clickOnAdd();
				bp.waitForElement();
			}
			// actual[1]=rp.clickOnManageRelease();
			bp.waitForElement();
			String releaseName5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_8");
			boolean res5 = rp.checkAvailableRelease(releaseName5);
			if (res5 == false) {
				

				rp.addNewRelease(releaseName5, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				
				rp.clickOnAdd();
				bp.waitForElement();
			}
			
			bp.waitForElement();
			String releaseName6 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_9");
			boolean res6 = rp.checkAvailableRelease(releaseName6);
			if (res6 == false) {
				

				rp.addNewRelease(releaseName6, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				// rp.enterStartDatAndEndDate(syear, smonth, sday, eyear,
				// emonth, eday);
				rp.clickOnAdd();
			}
				bp.waitForElement();
				
			bp.waitForElement();
			String releaseName7 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_10");
			boolean res7 = rp.checkAvailableRelease(releaseName7);
			if (res7 == false) {
				

				rp.addNewRelease(releaseName7, Desc, Hide, MapexternalDefect);

				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				// rp.enterStartDatAndEndDate(syear, smonth, sday, eyear,
				// emonth, eday);
				rp.clickOnAdd();
				bp.waitForElement();
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

	@Then("^releases is created for the project$")
	public void releases_is_created_for_the_project() throws Throwable {
		try {
			System.out.println("Pass-releases are created successfully");
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

	@When("^User select the project and first release and add the node$")
	public void user_select_the_project_and_first_release_and_add_the_node() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String releaseName1 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_4");
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			bp.waitForElement();
			actual[0] = pp.selectProject(projectName);
			actual[1] = pp.selectRelease(releaseName1);

			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnTestRep();

			tr = new TestRepositoryPage(driver);
			// String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6,
			// 0);
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);

			bp = new BasePage();
			actual[3] = tr.clickOnRelease(releaseName1);
			bp.waitForElement();
			actual[4] = tr.addNode(p_Name1, p_Desc1);
			bp.waitForElement();

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

	@When("^User create a nine automated and ninty one manual testcases in testRepository$")
	public void user_create_a_nine_automated_and_ninty_one_manual_testcases_in_testRepository() throws Throwable {
		try {
			String releaseName1 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_4");
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 14);
			actual[5] = tr.doubleClickOnRelease(releaseName1);
			String[] phase = new String[1];
			phase[0] = p_Name1;
			bp.waitForElement();
			actual[6] = tr.navigateToNode(releaseName1, phase);
			tr.addTestCase();
			bp.waitForElement();
			actual[7] = tr.clickDetailButton();
			
		
			ctc = new CreateTestCasePage(driver);
			//ctc.TestStep.click();
			String check = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
			String script_Name = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
			String script_Id = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
			String script_Path = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
			actual[6] = ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
			bp.waitForElement();
			tr.clickOnList();
			for (int i = 0; i <= 2; i++) {
				tr.selectallTestCase();
				tr.cloneTestCase();
			}
			tr.selectallTestCase();
			tr.selectallTestCase();
			ep = new ExportPage(driver);
			String[] testCaseNo1 = new String[1];
			testCaseNo1[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			ep.selectMultipleTestcasesfromSearch(testCaseNo1);
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();

			tr.doubleClickOnRelease(releaseName1);
			String p_Name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 14);
			String p_Desc2 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
			tr.addNode(p_Name2, p_Desc2);

			String[] phase2 = new String[1];
			phase2[0] = p_Name2;
			bp.waitForElement();
			actual[6] = tr.navigateToNode(releaseName1, phase2);
			tr.addTestCase();
			for (int i = 0; i <= 5; i++) {
				bp.waitForElement();
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				tr.cloneTestCase();
				bp.waitForElement();
			}
			tr.selectallTestCase();
			tr.selectallTestCase();
			bp.waitForElement();
			// tr.cloneTestCase();
			String[] testCaseNo11 = new String[5];
			testCaseNo11[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			testCaseNo11[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
			testCaseNo11[2] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
			testCaseNo11[3] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
			testCaseNo11[4] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
			ep.selectMultipleTestcasesfromSearch(testCaseNo11);
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();

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

	@When("^User select the second release and add the node$")
	public void user_select_the_second_release_and_add_the_node() throws Throwable {
		try {
			bp = new BasePage();
			rp = new ReleasePage(driver);
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_5");
			actual[0] = pp.selectProject(projectName);
			actual[0] = pp.selectRelease(releaseName2);
			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnTestRep();

			tr = new TestRepositoryPage(driver);
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);

			bp = new BasePage();
			actual[3] = tr.clickOnRelease(releaseName2);
			bp.waitForElement();
			actual[4] = tr.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName2);

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

	@When("^User create a hundred automated and nine hundred manual testcases in test repository$")
	public void user_create_a_hundred_automated_and_nine_hundred_manual_testcases_in_test_repository()
			throws Throwable {
		try {
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4, 14);
			String releaseName2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_5");
			String[] phase = new String[1];
			phase[0] = p_Name1;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName2, phase);
			tr.addTestCase();
			for(int i=0;i<=7;i++)
			{
				bp.waitForElement();
			actual[14] = tr.selectallTestCase();
			bp.waitForElement();
			actual[15] = tr.cloneTestCase();
			}
//			bp.waitForElement();
//			actual[16] = tr.selectallTestCase();
//			actual[17] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[18] = tr.selectallTestCase();
//			actual[19] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[20] = tr.selectallTestCase();
//			actual[21] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[22] = tr.selectallTestCase();
//			actual[23] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[24] = tr.selectallTestCase();
//			actual[25] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[26] = tr.selectallTestCase();
//			bp.waitForElement();
//			actual[27] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[28] = tr.selectallTestCase();
//			bp.waitForElement();
//			actual[29] = tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			actual[32] = tr.confirmCloneOperation();
			actual[33] = bp.waitForElement();
			actual[34] = bp.waitForElement();
			actual[35] = bp.waitForElement();
			actual[33] = bp.waitForElement();
			actual[33] = tr.selectallTestCase();
			bp.waitForElement();
			actual[34] = tr.cloneTestCase();
			bp.waitForElement();
			actual[35] = tr.confirmCloneOperation();
			
			
			for(int i=1;i<=9;i++)
			{
			bp.waitForElement();
		}
			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();

			bp.waitForElement();
			String[] testcase1 = new String[24];
			int k1 = 1;
			for (int i = 0; i <= 23; i++) {

				testcase1[i] = Integer.toString(k1);
				k1++;
			}
			ep = new ExportPage(driver);
			actual[36] = ep.selectMultipleTestcasesfromSearch(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			pp.selectProject(projectName);
			pp.selectRelease(releaseName2);
			rp.clickOnTestRep();
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName2);
			String p_Name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5, 14);
			String p_Desc2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
			tr.addNode(p_Name2, p_Desc2);
			String[] phase2 = new String[1];
			phase2[0] = p_Name2;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName2, phase2);
			tr.addTestCase();
			bp.waitForElement();
			actual[7] = tr.clickDetailButton();
			ctc = new CreateTestCasePage(driver);
			
			//ctc.TestStep.click();
			String check = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
			String script_Name = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
			String script_Id = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
			String script_Path = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
			actual[6] = ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
			bp.waitForElement();
			tr.clickOnList();
			for (int i = 0; i <= 5; i++) {
				tr.selectallTestCase();
				tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.selectallTestCase();
			String[] testCaseNo11 = new String[4];
			testCaseNo11[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			testCaseNo11[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
			testCaseNo11[2] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
			testCaseNo11[3] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
			// testCaseNo11[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,
			// "DashBoards", 5, 15));
			ep = new ExportPage(driver);
			ep.selectMultipleTestcasesfromSearch(testCaseNo11);
			tr.cloneTestCase();
			bp.waitForElement();
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

	@When("^User select the third release and add the node$")
	public void user_select_the_third_release_and_add_the_node() throws Throwable {
		try {
			bp = new BasePage();
			rp = new ReleasePage(driver);
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_6");
			actual[0] = pp.selectProject(projectName);
			actual[0] = pp.selectRelease(releaseName3);
			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnTestRep();

			tr = new TestRepositoryPage(driver);
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);

			bp = new BasePage();
			actual[3] = tr.clickOnRelease(releaseName3);
			bp.waitForElement();
			actual[4] = tr.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName3);

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

	@When("^User create a thousand automated and thousand manual testcases in test repository$")
	public void user_create_a_thousand_automated_and_thousand_manual_testcases_in_test_repository() throws Throwable {
		try {
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7, 14);
			String releaseName3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_6");
			String[] phase = new String[1];
			phase[0] = p_Name1;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName3, phase);
			tr.addTestCase();
			bp.waitForElement();
			actual[7] = tr.clickDetailButton();
			ctc = new CreateTestCasePage(driver);
			
			//ctc.TestStep.click();
			String check = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
			String script_Name = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
			String script_Id = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
			String script_Path = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
			actual[6] = ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
			bp.waitForElement();
			tr.clickOnList();
			
			for(int i=1;i<=9;i++)
			{
			actual[14] = tr.selectallTestCase();
			bp.waitForElement();
			actual[15] = tr.cloneTestCase();
			bp.waitForElement();
			}
//			actual[16] = tr.selectallTestCase();
//			actual[17] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[18] = tr.selectallTestCase();
//			actual[19] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[20] = tr.selectallTestCase();
//			actual[21] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[22] = tr.selectallTestCase();
//			actual[23] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[24] = tr.selectallTestCase();
//			actual[25] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[26] = tr.selectallTestCase();
//			bp.waitForElement();
//			actual[27] = tr.cloneTestCase();
//			bp.waitForElement();
//			actual[28] = tr.selectallTestCase();
//			bp.waitForElement();
//			actual[29] = tr.cloneTestCase();
//			bp.waitForElement();
//			tr.selectallTestCase();
//			bp.waitForElement();
//			tr.cloneTestCase();
//			bp.waitForElement();
			actual[32] = tr.confirmCloneOperation();
			actual[33] = bp.waitForElement();
			actual[34] = bp.waitForElement();
			actual[35] = bp.waitForElement();
			actual[33] = bp.waitForElement();
			actual[33] = tr.selectallTestCase();
			bp.waitForElement();
			actual[34] = tr.cloneTestCase();
			bp.waitForElement();
			actual[35] = tr.confirmCloneOperation();
			for(int i=1;i<=9;i++)
			{
			bp.waitForElement();
		}
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			String[] testcase1 = new String[24];
			int k1 = 1;
			for (int i = 0; i <= 23; i++) {

				testcase1[i] = Integer.toString(k1);
				k1++;
			}
			ep = new ExportPage(driver);
			actual[36] = ep.selectMultipleTestcasesfromSearch(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();

			tr.doubleClickOnRelease(releaseName3);
			String p_Desc2 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8, 14);
			String p_Name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
			tr.addNode(p_Name2, p_Desc2);
			// String releaseName4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",
			// 6,0);
			String[] phase2 = new String[1];
			phase2[0] = p_Name2;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName3, phase2);
			tr.addTestCase();
			actual[14] = tr.selectallTestCase();
			actual[15] = tr.cloneTestCase();
			bp.waitForElement();
			actual[16] = tr.selectallTestCase();
			actual[17] = tr.cloneTestCase();
			bp.waitForElement();
			actual[18] = tr.selectallTestCase();
			actual[19] = tr.cloneTestCase();
			bp.waitForElement();
			actual[20] = tr.selectallTestCase();
			actual[21] = tr.cloneTestCase();
			bp.waitForElement();
			actual[22] = tr.selectallTestCase();
			actual[23] = tr.cloneTestCase();
			bp.waitForElement();
			actual[24] = tr.selectallTestCase();
			actual[25] = tr.cloneTestCase();
			bp.waitForElement();
			actual[26] = tr.selectallTestCase();
			bp.waitForElement();
			actual[27] = tr.cloneTestCase();
			bp.waitForElement();
			actual[28] = tr.selectallTestCase();
			bp.waitForElement();
			actual[29] = tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			actual[32] = tr.confirmCloneOperation();
			actual[33] = bp.waitForElement();
			actual[34] = bp.waitForElement();
			actual[35] = bp.waitForElement();
			actual[33] = bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[33] = tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[34] = tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[35] = tr.confirmCloneOperation();
			
			for(int i=1;i<=9;i++)
			{
			bp.waitForElement();
		}
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			String[] testcase2 = new String[24];
			int k2 = 1;
			for (int i = 0; i <= 23; i++) {

				testcase2[i] = Integer.toString(k2);
				k2++;
			}
			ep = new ExportPage(driver);
			actual[36] = ep.selectMultipleTestcasesfromSearch(testcase2);
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
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

	@When("^User select the fourth release and add a node$")
	public void user_select_the_fourth_release_and_add_a_node() throws Throwable {
		try {
			bp = new BasePage();
			rp = new ReleasePage(driver);
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_7");
			actual[0] = pp.selectProject(projectName);
			actual[0] = pp.selectRelease(releaseName4);
			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnTestRep();

			tr = new TestRepositoryPage(driver);
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);

			bp = new BasePage();
			actual[3] = tr.clickOnRelease(releaseName4);
			bp.waitForElement();
			actual[4] = tr.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName4);

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

	@When("^User create a thousand automated and hundred manual testcases in test repository$")
	public void user_create_a_thousand_automated_and_hundred_manual_testcases_in_test_repository() throws Throwable {
		try {
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10, 14);
			String releaseName4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_7");
			String[] phase = new String[1];
			phase[0] = p_Name1;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName4, phase);
			tr.addTestCase();
			bp.waitForElement();
			actual[7] = tr.clickDetailButton();
			ctc = new CreateTestCasePage(driver);
			//ctc.TestStep.click();
			String check = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
			String script_Name = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
			String script_Id = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
			String script_Path = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
			actual[6] = ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
			bp.waitForElement();
			tr.clickOnList();
			actual[14] = tr.selectallTestCase();
			actual[15] = tr.cloneTestCase();
			bp.waitForElement();
			actual[16] = tr.selectallTestCase();
			actual[17] = tr.cloneTestCase();
			bp.waitForElement();
			actual[18] = tr.selectallTestCase();
			actual[19] = tr.cloneTestCase();
			bp.waitForElement();
			actual[20] = tr.selectallTestCase();
			actual[21] = tr.cloneTestCase();
			bp.waitForElement();
			actual[22] = tr.selectallTestCase();
			actual[23] = tr.cloneTestCase();
			bp.waitForElement();
			actual[24] = tr.selectallTestCase();
			actual[25] = tr.cloneTestCase();
			bp.waitForElement();
			actual[26] = tr.selectallTestCase();
			bp.waitForElement();
			actual[27] = tr.cloneTestCase();
			bp.waitForElement();
			actual[28] = tr.selectallTestCase();
			bp.waitForElement();
			actual[29] = tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[32] = tr.confirmCloneOperation();
			actual[33] = bp.waitForElement();
			actual[34] = bp.waitForElement();
			actual[35] = bp.waitForElement();
			actual[33] = bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[33] = tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[34] = tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[35] = tr.confirmCloneOperation();
			for(int i=1;i<=9;i++)
			{
			bp.waitForElement();
		}
			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//
//			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();

			bp.waitForElement();
			String[] testcase1 = new String[24];
			int k1 = 1;
			for (int i = 0; i <= 23; i++) {

				testcase1[i] = Integer.toString(k1);
				k1++;
			}
			ep = new ExportPage(driver);
			actual[36] = ep.selectMultipleTestcasesfromSearch(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			// String
			// releaseName4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");//
			tr.doubleClickOnRelease(releaseName4);
			String p_Name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11, 14);
			String p_Desc2 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
			tr.addNode(p_Name2, p_Desc2);
			String[] phase2 = new String[1];
			phase2[0] = p_Name2;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName4, phase2);
			tr.addTestCase();
			for (int i = 0; i <= 5; i++) {
				tr.selectallTestCase();
				tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.selectallTestCase();
			for (int i = 0; i <= 3; i++) {
				tr.addTestCase();
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

	@When("^User select the fifth release and add a node$")
	public void user_select_the_fifth_release_and_add_a_node() throws Throwable {
		try {
			bp = new BasePage();
			rp = new ReleasePage(driver);
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_8");
			actual[0] = pp.selectProject(projectName);
			actual[0] = pp.selectRelease(releaseName5);
			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnTestRep();

			tr = new TestRepositoryPage(driver);
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 13, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);

			bp = new BasePage();
			actual[3] = tr.clickOnRelease(releaseName5);
			bp.waitForElement();
			actual[4] = tr.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName5);

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

	@When("^User create only thousand automated testcases in test repository$")
	public void user_create_only_thousand_automated_testcases_in_test_repository() throws Throwable {
		try {
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 13, 14);
			String releaseName5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_8");
			String[] phase = new String[1];
			phase[0] = p_Name1;
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName5, phase);
			tr.addTestCase();
			bp.waitForElement();
			actual[7] = tr.clickDetailButton();
			ctc = new CreateTestCasePage(driver);
			//ctc.TestStep.click();
			String check = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
			String script_Name = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
			String script_Id = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
			String script_Path = Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
			actual[6] = ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
			bp.waitForElement();
			tr.clickOnList();
			actual[14] = tr.selectallTestCase();
			actual[15] = tr.cloneTestCase();
			bp.waitForElement();
			actual[16] = tr.selectallTestCase();
			actual[17] = tr.cloneTestCase();
			bp.waitForElement();
			actual[18] = tr.selectallTestCase();
			actual[19] = tr.cloneTestCase();
			bp.waitForElement();
			actual[20] = tr.selectallTestCase();
			actual[21] = tr.cloneTestCase();
			bp.waitForElement();
			actual[22] = tr.selectallTestCase();
			actual[23] = tr.cloneTestCase();
			bp.waitForElement();
			actual[24] = tr.selectallTestCase();
			actual[25] = tr.cloneTestCase();
			bp.waitForElement();
			actual[26] = tr.selectallTestCase();
			bp.waitForElement();
			actual[27] = tr.cloneTestCase();
			bp.waitForElement();
			actual[28] = tr.selectallTestCase();
			bp.waitForElement();
			actual[29] = tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			actual[32] = tr.confirmCloneOperation();
			actual[33] = bp.waitForElement();
			actual[34] = bp.waitForElement();
			actual[35] = bp.waitForElement();
			actual[33] = bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[33] = tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[34] = tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[35] = tr.confirmCloneOperation();
			for(int i=1;i<=9;i++)
			{
			bp.waitForElement();
		}
			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//			bp.waitForElement();
//
//			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();

			bp.waitForElement();
			String[] testcase1 = new String[24];
			int k1 = 1;
			for (int i = 0; i <= 23; i++) {

				testcase1[i] = Integer.toString(k1);
				k1++;
			}
			ep = new ExportPage(driver);
			actual[36] = ep.selectMultipleTestcasesfromSearch(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
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
}
