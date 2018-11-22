package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Jira_Requirements_52 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName = "Import_Jira_Requirements_52";

	boolean[] actual = new boolean[10];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in a Requirements App$")
	public void user_is_in_a_Requirements_App() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_1");
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

	@When("^User click on the Import button and User select Jira Option$")
	public void user_click_on_the_Import_button_and_User_select_Jira_Option() throws Throwable {
		try {
			req = new RequirementsPage(driver);
			actual[3] = req.clickOnImport();
			String importType = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 5);
			actual[4] = req.chooseImportType(importType);
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

	@When("^User search requirement by filter operation and select single/multiple defect requirements$")
	public void user_search_requirement_by_filter_operation_and_select_single_multiple_defect_requirements()
			throws Throwable {
		try {
			req = new RequirementsPage(driver);
			String selectQuerry = Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 8);
			String selectFilter = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 11);
			actual[5] = req.selectFilterQuerry(selectQuerry, selectFilter);

			String accessType = Excel_Lib.getData(INPUT_PATH_3, "Import",9,7);
			String folderName = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Import", 5, 9);
			actual[6] = req.selectAccessTypeAndFolderName(accessType, folderName);
			req.clickjiraSearchButton.click();

			String[] testCaseNo = new String[2];
			testCaseNo[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 4));
			testCaseNo[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 4));
			// testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,
			// "TestCases",3 ,4 ));
			actual[7] = req.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			req.clickOnImportSelected.click();
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

	@Then("^should be able to import the selected requirement$")
	public void should_be_able_to_import_the_selected_requirement() throws Throwable {
		try {
			String fileName = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Import", 5, 9);
			String ImportedName = Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 2);
			tr = new TestRepositoryPage(driver);
			bp.waitForElement();
			String[] fields = new String[1];
			fields[0] = fileName;
			actual[8] = tr.navigateToNode(ImportedName, fields);

			actual[9] = req.VerifyRequirementCount();
			bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
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
