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

public class Jira_Requirements_Component_56 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName = "Jira_Requirements_Component_56";

	boolean[] actual = new boolean[11];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in an Requirements App page$")
	public void user_is_in_an_Requirements_App_page() throws Throwable {
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

	@When("^User click on the Import option button and chooses the import type as Jira$")
	public void user_click_on_the_Import_option_button_and_chooses_the_import_type_as_Jira() throws Throwable {
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
	
	@When("^User search requirement by JQL operation and select sub-folder as component$")
	public void user_search_requirement_by_JQL_operation_and_select_sub_folder_as_component() throws Throwable {
		try {
			req = new RequirementsPage(driver);
			String selectQuerry = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 8);
			String enterQuerry = Excel_Lib.getData(INPUT_PATH_3, "Import", 3, 6);
			actual[5] = req.selectQuerry(selectQuerry, enterQuerry);

			String accessType = Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 7);
			String folderName = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 9);
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

	@When("^User select the all searched requirements and perform the import all operation$")
	public void user_select_the_all_searched_requirements_and_perform_the_import_all_operation() throws Throwable {
		try {
			
			bp.waitForElement();
			bp.waitForElement();
			actual[7] = req.importAllJiraRequirements();
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

	@Then("^Should be able to view the orderly arranged component subfolder folder requirement$")
	public void should_be_able_to_view_the_orderly_arranged_component_subfolder_folder_requirement() throws Throwable {
		try {
			String fileName = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 9);
			String ImportedName = Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 2);
			tr = new TestRepositoryPage(driver);
			bp.waitForElement();
			tr.doubleClickOnRelease(ImportedName);
			String[] fields = new String[1];
			fields[0] = fileName;
			bp.waitForElement();
			actual[8] = tr.navigateToNode(ImportedName, fields);

			String[] node = new String[3];
			node[0] = Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 20);
			node[1] = Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 20);
			node[2] = Excel_Lib.getData(INPUT_PATH_3, "Import", 3, 20);
			/*node[3] = Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 15);
			node[4] = Excel_Lib.getData(INPUT_PATH_3, "Import", 5, 15);
			node[5] = Excel_Lib.getData(INPUT_PATH_3, "Import", 6, 15);
			node[6] = Excel_Lib.getData(INPUT_PATH_3, "Import", 7, 15);
			node[7] = Excel_Lib.getData(INPUT_PATH_3, "Import", 8, 15);
			node[8] = Excel_Lib.getData(INPUT_PATH_3, "Import", 9, 15);
			node[9] = Excel_Lib.getData(INPUT_PATH_3, "Import", 10, 15);
			node[10] = Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 15);
			node[11] = Excel_Lib.getData(INPUT_PATH_3, "Import", 12, 15);
			node[12] = Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 15);
			node[13] = Excel_Lib.getData(INPUT_PATH_3, "Import", 14, 15);*/
			actual[9] = tr.navigateNode(node);

			bp.waitForElement();
			actual[10] = req.doubleClickOnRelease(ImportedName);

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
