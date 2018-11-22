package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
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

public class Attachments_25 extends LaunchBrowser {

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
	ExecutionPage exep;
	String fileName = "Attachments_25";

	boolean[] actual = new boolean[26];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in the requirements page$")
	public void user_is_in_the_requirements_page() throws Throwable {
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

	@Given("^User create a phase and add requirements$")
	public void user_create_a_phase_and_add_requirements() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			String p_Name1 = UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 7, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 7,
					15);

			req = new RequirementsPage(driver);
			actual[3] = req.doubleClickOnRelease(releaseName);

			actual[4] = req.addNode(p_Name1, p_Desc1);
			bp.waitForElement();
			String[] phase = new String[1];
			phase[0] = p_Name1;
			tr = new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[5] = tr.navigateToNode(releaseName, phase);

			for (int i = 1; i <= 8; i++) {
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

	@Then("^User add attachment in text format to the requirement$")
	public void user_add_attachment_in_text_format_to_the_requirement()
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
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 4, 19);
			
			tr.clickDetailButton();
			actual[8] = ctc.uploadAttachement(a);
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

	@Then("^User add attachment in word doc format to the requirement$")
	public void user_add_attachment_in_word_doc_format_to_the_requirement()
			throws Throwable {
		try {
			String[] testCaseNo2 = new String[1];
			testCaseNo2[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 2, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[9] = req.selectMultipleRequirementFromGrids(testCaseNo2);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 5, 19);
			actual[10] = ctc.uploadAttachement(a);
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

	@Then("^User add attachment in excel format to the requirement$")
	public void user_add_attachment_in_excel_format_to_the_requirement()
			throws Throwable {
		try {
			String[] testCaseNo3 = new String[1];
			testCaseNo3[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 3, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[11] = req.selectMultipleRequirementFromGrids(testCaseNo3);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 19);
			actual[12] = ctc.uploadAttachement(a);
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

	@Then("^User add attachment in image format\\(\\.jpg/bmp/gif format\\) to the requirement$")
	public void user_add_attachment_in_image_format_jpg_bmp_gif_format_to_the_requirement()
			throws Throwable {
		try {
			String[] testCaseNo4 = new String[1];
			testCaseNo4[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 4, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[13] = req.selectMultipleRequirementFromGrids(testCaseNo4);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 19);
			actual[14] = ctc.uploadAttachement(a);
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

	@Then("^User add attachment in wave format\\(\\.wmv\\) to the requirement$")
	public void user_add_attachment_in_wave_format_wmv_to_the_requirement()
			throws Throwable {
		try {
			String[] testCaseNo5 = new String[1];
			testCaseNo5[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 5, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[15] = req.selectMultipleRequirementFromGrids(testCaseNo5);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 6, 19);
			actual[16] = ctc.uploadAttachement(a);
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

	@Then("^User add attachment in pdf format to the requirement$")
	public void user_add_attachment_in_pdf_format_to_the_requirement()
			throws Throwable {
		try {
			String[] testCaseNo6 = new String[1];
			testCaseNo6[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 6, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[17] = req.selectMultipleRequirementFromGrids(testCaseNo6);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 19);
			actual[18] = ctc.uploadAttachement(a);
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

	@Then("^User add attachment in mp(\\d+) format to the requirement$")
	public void user_add_attachment_in_mp_format_to_the_requirement(int arg1)
			throws Throwable {
		try {
			String[] testCaseNo7 = new String[1];
			testCaseNo7[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 7, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[19] = req.selectMultipleRequirementFromGrids(testCaseNo7);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 7, 19);
			actual[20] = ctc.uploadAttachement(a);
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

	@Then("^User add multiple attachments to the requirement$")
	public void user_add_multiple_attachments_to_the_requirement()
			throws Throwable {
		try {
			
			String[] testCaseNo8 = new String[1];
			testCaseNo8[0] = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestCases", 8, 4));
			bp.waitForElement();
			req = new RequirementsPage(driver);
			actual[21] = req.selectMultipleRequirementFromGrids(testCaseNo8);

			ctc = new CreateTestCasePage(driver);
			String[] a = new String[1];
			a[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 19);
			actual[22] = ctc.uploadAttachement(a);
			actual[23] =bp.waitForElement();
			
//			tr.clickOnList();
//			
//			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
//			req.minimizeFolderNode(releaseName);
//			String p_Name1 = UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 7, 14);
//			String[] phase = new String[1];
//			phase[0] = p_Name1;
//			tr.navigateToNode(releaseName, phase);
//			
//			req = new RequirementsPage(driver);
//			actual[23] = req.selectRequirementsFromGrids(testCaseNo8);

			//tr.clickDetailButton();
			ctc.attachements.click();
			ctc = new CreateTestCasePage(driver);
			String[] b = new String[1];
			b[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 19);
			actual[24] = ctc.uploadAttachement(b);
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

	@Then("^User preview the attachment in preview window$")
	public void user_preview_the_attachment_in_preview_window()
			throws Throwable {
		try {
			//ctc.attachements.click();
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

	@Then("^User download the attachment from preview window$")
	public void user_download_the_attachment_from_preview_window()
			throws Throwable {
		try {
			exep=new ExecutionPage(driver);
			String attachement_file=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 20);
			actual[25]=exep.downloadAttachement(attachement_file);
			
			
			tr.clickOnList();
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
