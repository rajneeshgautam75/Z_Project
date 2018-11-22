package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirements_Search_48 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	String[] a = new String[3];
	String fileName = "Requirements_Search_48";

	boolean[] actual = new boolean[46];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in a Requirements page$")
	public void user_is_in_a_Requirements_page() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_2");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			actual[0] = pp.selectProject(projectName);
			bp.waitForElement();
			actual[1] = pp.selectRelease(releaseName);
			bp.waitForElement();

			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnRequirements();
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

	@When("^User create the phase$")
	public void user_create_the_phase() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 13, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 13, 15);

			req = new RequirementsPage(driver);
			tr=new TestRepositoryPage(driver);
			actual[3] = tr.clickOnRelease(releaseName);

			actual[4] = req.addNode(p_Name1, p_Desc1);
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

	@When("^User add requirements to the node$")
	public void user_add_requirements_to_the_node() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 13, 14);
			String[] phase = new String[1];
			phase[0] = p_Name1;
			tr = new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName, phase);

			for (int i = 1; i <= 3; i++) {
				actual[6] = req.addRequirement();
			}
			int k = 0;
			for (int i = 1; i <= 3; i++) {

				a[k] = driver.findElement(By.xpath(req.requirementID1 + i + req.requirementID2)).getText();
				System.out.println(a[k]);
				k++;
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

	@When("^User enter the requirements details along with given custom fields$")
	public void user_enter_the_requirements_details_along_with_given_custom_fields() throws Throwable {
		try {
			String[] testCaseNo1 = new String[1];
			testCaseNo1[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[7] = req.selectMultipleRequirementFromGrids(testCaseNo1);
			 tr.clickOnDetails();

			String text = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 25);
			String longText = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 25);
			String number = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 100, 100);
			String checkBox = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 25);
			String pickupList = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 100, 100);
			String date = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 100, 100);
			actual[8] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
          
			String name = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 22);
			String altID =Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 22);
			String link = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 4, 22);
			String priority = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 8);
			String Description = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 22);
			actual[9] = req.enterRequirementDetails(name, altID, link, priority, Description);

			String[] testCaseNo2 = new String[1];
			testCaseNo2[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[10] = req.selectMultipleRequirementFromGrids(testCaseNo2);

			actual[11]=req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
			
			String name2 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 5, 22);
			actual[12] = req.enterRequirementDetails(name2, altID, link, priority, Description);

			String[] testCaseNo3 = new String[1];
			testCaseNo3[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 3, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[13] = req.selectMultipleRequirementFromGrids(testCaseNo3);

			actual[14]=req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);

			String name3 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 6, 22);
			actual[15] = req.enterRequirementDetails(name3, altID, link, priority, Description);
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

	@When("^User search requirements with different zql operators$")
	public void user_search_requirements_with_different_zql_operators() throws Throwable {
		try {
			bp = new BasePage();
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			actual[16] = tr.clickOnSearch();
			
			actual[17] = req.advancedSearch1();
			bp.pageLoad();
            bp.waitForElement();
            bp.waitForElement();
			String name1 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 17, 0);
			String operator1 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 9, 1);
			String value1 = a[0];
			actual[18] = tp.ZQLSearch1(name1, operator1, value1);
			bp.pageLoad();

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

	@Then("^User should retrieve matching rows$")
	public void user_should_retrieve_matching_rows() throws Throwable {
		try {
			actual[19] = req.VerifyRequirementCount();
			
			req.advancedSearch1();

			String name2 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 19, 0);
			String operator2 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 19, 1);
			String value2 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 23);
			bp.waitForElement();
	        bp.waitForElement();
			actual[20] = tp.ZQLSearch1(name2, operator2, value2);
			bp.pageLoad();
			actual[21] = req.VerifyRequirementCount();
			actual[22] = req.advancedSearch1();
			bp.pageLoad();

			String name3 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 10, 0);
			String operator3 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 19, 1);
			String value3 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 23);
			bp.waitForElement();
	        bp.waitForElement();
			actual[23] = tp.ZQLSearch1(name3, operator3, value3);
			bp.pageLoad();
			actual[24] = req.VerifyRequirementCount();
			actual[25] = req.advancedSearch1();
			bp.pageLoad();

			String name4 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 13, 0);
			String operator4 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 19, 1);
			String value4 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 23);
			bp.waitForElement();
	        bp.waitForElement();
			actual[26] = tp.ZQLSearch1(name4, operator4, value4);
			bp.pageLoad();
			actual[27] = req.VerifyRequirementCount();
			actual[28] = req.advancedSearch1();
			bp.pageLoad();
			
			String name5 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 14, 0);
			String operator5 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 14, 1);
			String value5 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 1, 1);
			bp.waitForElement();
	        bp.waitForElement();
			actual[29] = tp.ZQLSearch1(name5, operator5, value5);
			bp.pageLoad();
			actual[30] = req.VerifyRequirementCount();
			actual[31] = req.advancedSearch1();
			bp.pageLoad();
			String name6 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 26);
			String operator6 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 27);
			String value6 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 5, 25);
			bp.waitForElement();
	        bp.waitForElement();
			actual[32] = tp.ZQLSearch1(name6, operator6, value6);
			bp.pageLoad();
			actual[33] = req.VerifyRequirementCount();
			actual[34] = req.advancedSearch1();
			bp.pageLoad();
			
			String name7 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 26);
			String operator7 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 27);
			String value7 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 7, 25);
			bp.waitForElement();
	        bp.waitForElement();
			actual[35] = tp.ZQLSearch1(name7, operator7, value7);
			bp.pageLoad();
			actual[36] = req.VerifyRequirementCount();
			actual[37] = req.advancedSearch1();

			bp.pageLoad();
			String name8 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 20, 0);
			String operator8 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 9, 1);
			String value8 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 5, 23);
			bp.waitForElement();
	        bp.waitForElement();
			actual[38] = tp.ZQLSearch1(name8, operator8, value8);
			bp.pageLoad();
			actual[39] = req.VerifyRequirementCount();
			actual[40] = req.advancedSearch1();
			bp.pageLoad();
			String name9 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 10, 0);
			String operator9 = Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 19, 1);
			String value9 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 6, 23);
			bp.waitForElement();
	        bp.waitForElement();
			actual[41] = tp.ZQLSearch1(name9, operator9, value9);
			bp.pageLoad();
			actual[42] = req.VerifyRequirementCount();
			actual[43] = req.advancedSearch1();
			bp.pageLoad();
			String name10 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 26);
			String operator10 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 27);
			String value10 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 6, 25);
			bp.waitForElement();
	        bp.waitForElement();
			actual[44] = tp.ZQLSearch1(name10, operator10, value10);
			bp.pageLoad();
			actual[45] = req.VerifyRequirementCount();
			
			tr.clickedOnFolder();
			bp.waitForElement();
			tr.clickOnList();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
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

}
