package com.zephyr_batch_3.stepdefinition;

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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Attachment_26 extends LaunchBrowser {

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
	String fileName = "Attachment_26";

	boolean[] actual = new boolean[10];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in the Requirements page$")
	public void user_is_in_the_Requirements_page() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_REQ, "Normal_Project_1");
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

	@When("^User create a phase and add requirements to the phase$")
	public void user_create_a_phase_and_add_requirements_to_the_phase()
			throws Throwable {
		try {
			tr=new TestRepositoryPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			String p_Name1 = UNIQUE
					+ Excel_Lib.getData(INPUT_PATH_3, "Requirement", 8, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 8,
					15);

			req = new RequirementsPage(driver);
			actual[3] = tr.clickOnRelease(releaseName);

			actual[4] = req.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			String[] phase = new String[1];
			phase[0] = p_Name1;
			tr = new TestRepositoryPage(driver);
			// actual[4]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName, phase);

			for (int i = 1; i <= 2; i++) {
				actual[6] = req.addRequirement();
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

	@When("^User add attachment to the requirement$")
	public void user_add_attachment_to_the_requirement() throws Throwable {
		try {
			String[] testCaseNo1 = new String[1];
			testCaseNo1[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 1, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[7] = req.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 19);
			tr.clickDetailButton();
			actual[7] = ctc.uploadAttachement(a);
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

	@Then("^User delete the attached attachment$")
	public void user_delete_the_attached_attachment() throws Throwable {
		try {
			String[] testCaseNo1 = new String[1];
			testCaseNo1[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 1, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[7] = req.selectMultipleRequirementFromGrids(testCaseNo1);
			
			ctc = new CreateTestCasePage(driver);
			String[] attachement_file = new String[1];
			attachement_file[0] = Excel_Lib.getData(INPUT_PATH_3,
					"Requirement", 1, 20);
			ctc.attachements.click();
			actual[8] = ctc.deleteAttachement(attachement_file);
			bp.waitForElement();
			// ctc.verifyAttachementFile(fileName);
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

	@Then("^User re-attach the previously deleted attachment$")
	public void user_re_attach_the_previously_deleted_attachment()
			throws Throwable {
		try {
			String[] testCaseNo1 = new String[1];
			testCaseNo1[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 1, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[7] = req.selectMultipleRequirementFromGrids(testCaseNo1);
			
			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 19);
			ctc.attachements.click();
			actual[9] = ctc.uploadAttachement(a);
			bp.waitForElement();
			
			tr.clickOnList();
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
