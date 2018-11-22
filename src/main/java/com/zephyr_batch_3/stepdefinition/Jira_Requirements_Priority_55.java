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

public class Jira_Requirements_Priority_55 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName = "Jira_Requirements_Priority_55";

	boolean[] actual = new boolean[11];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in the Requirements App page$")
	public void user_is_in_the_Requirements_App_page() throws Throwable {
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

	@When("^User click on the Import button and choose import type as an Jira$")
	public void user_click_on_the_Import_button_and_choose_import_type_as_an_Jira() throws Throwable {
		try {
			req = new RequirementsPage(driver);
			actual[3] = req.clickOnImport();
			bp.waitForElement();
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


	@When("^User search requirement by JQL operation and select sub-folder as priority$")
	public void user_search_requirement_by_JQL_operation_and_select_sub_folder_as_priority() throws Throwable {
		try {
			req = new RequirementsPage(driver);
			String selectQuerry = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 8);
			String enterQuerry = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 6);
			actual[5] = req.selectQuerry(selectQuerry, enterQuerry);

			String accessType = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 7);
			String folderName = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
			actual[6] = req.selectAccessTypeAndFolderName(accessType, folderName);
			req.clickjiraSearchButton.click();

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

	@When("^User select the all searched requirements and perform import all operation$")
	public void user_select_the_all_searched_requirements_and_perform_import_all_operation() throws Throwable {
		try {
			bp.waitForElement();
			actual[7] = req.importAllJiraRequirements();
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

	@Then("^Should be able to view the orderly arranged priority subfolder requirement$")
	public void should_be_able_to_view_the_orderly_arranged_priority_subfolder_requirement() throws Throwable {
		try {
			String fileName = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
			String ImportedName = Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 2);
			tr = new TestRepositoryPage(driver);
			bp.waitForElement();
			String[] fields = new String[1];
			fields[0] = fileName;
			actual[8] = tr.navigateToNode(ImportedName, fields);

			String[] node = new String[3];
			node[0] = Excel_Lib.getData(INPUT_PATH_3, "Import", 3, 14);
			node[1] = Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 14);
			node[2] = Excel_Lib.getData(INPUT_PATH_3, "Import", 6, 14);
//			node[3] = Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 14);
//			node[4] = Excel_Lib.getData(INPUT_PATH_3, "Import", 5, 14);
//			node[5] = Excel_Lib.getData(INPUT_PATH_3, "Import", 6, 14);
			// node[6]=Excel_Lib.getData(INPUT_PATH_3,"Import",7,14);
			// node[7]=Excel_Lib.getData(INPUT_PATH_3,"Import",8,14);
			actual[9] = tr.navigateNode(node);
			// actual[9]=req.verifyPresentRequirement();
			bp.waitForElement();

			bp.waitForElement();
			actual[10] = tr.doubleClickOnRelease(ImportedName);
			
			pp.clickOnLogout();

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
