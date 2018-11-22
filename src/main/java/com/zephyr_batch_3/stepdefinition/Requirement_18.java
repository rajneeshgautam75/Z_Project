package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_18 extends LaunchBrowser {

	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	ImportPage ip;
	CreateCustomFieldsPage ccp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[9];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "Requirement_18";

	@When("^add a requirement node with name and description$")
	public void add_a_requirement_node_with_name_and_description() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			bp = new BasePage();
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String pName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 29, 1);
			String pDesc1 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 29, 2);

			actual[0] = req.addNode(pName1, pDesc1);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add a requirement to the node$")
	public void add_a_requirement_to_the_node() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 29, 1);
			actual[1] = tr.navigateToNode(releaseName, node1);

			actual[2] = req.addRequirement();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^enter the unique custom field value and save it$")
	public void enter_the_unique_custom_field_value_and_save_it() throws Throwable {
		try {
			tr.clickOnDetails();
			String text = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 18, 7);
			String longText = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 99, 8);
			String number = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 18, 9));
			// piclistValues[0]=Excel_Lib.getData(INPUT_PATH_2,"CustomField",
			// i+4, 3);
			String checkBox = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 99, 10);
			String pickupList = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 99, 11);
			String date = Excel_Lib.getNumericValue(INPUT_PATH_2, "ReqDetails", 99, 122);

			actual[3] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();
			//actual[4] = req.clickOnCustomFieldHeader();
		}

		catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Unique custom field value should be saved$")
	public void unique_custom_field_value_should_be_saved() throws Throwable {
		log.info("Unique Custom field Value saved successfully");
	}

	@When("^user add another requirement and enter same value for Unique custom field$")
	public void user_add_another_requirement_and_enter_same_value_for_Unique_custom_field() throws Throwable {
		try {
			actual[4] = req.addRequirement();

			String text = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 18, 7);
			String longText = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 99, 8);
			String number = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 18, 9));
			// piclistValues[0]=Excel_Lib.getData(INPUT_PATH_2,"CustomField",
			// i+4, 3);
			String checkBox = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 99, 10);
			String pickupList = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 99, 11);
			String date = Excel_Lib.getNumericValue(INPUT_PATH_2, "ReqDetails", 99, 12);

			actual[5] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();

		}

		catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^custom field should not allow to enter the same value for Unique custom field$")
	public void custom_field_should_not_allow_to_enter_the_same_value_for_Unique_custom_field() throws Throwable {

		try {
			String msg = req.customDuplicateOkMsg.getText();
			bp.waitForElement();
			String number = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 18, 9));
			System.out.println("Custom field Number value -" + number + msg);
			// *[@id="custom-field-error-modal"]/div/div
			// *[@id="custom-field-error-modal"]/div/div/div[3]/zui-modal-footer/button
			req.customDuplicateOkButton.click();
			bp.waitForElement();

		}

		catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user clone the requirement with unique custom field value$")
	public void user_clone_the_requirement_with_unique_custom_field_value() throws Throwable {

		try {
			String[] requirements = new String[1];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));

			actual[6] = req.selectMultipleRequirementFromGrids(requirements);

			actual[7] = req.cloneRequirement();

		}

		catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^requirement should be cloned successfully$")
	public void requirement_should_be_cloned_successfully() throws Throwable {
		try {
			
			tr.clickOnList();
			
				String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			actual[8] = req.VerifyRequirementCount();
			
			tr.clickOnRelease(releaseName);
		   String phaseName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 29, 1);
			tr.selectPhase(phaseName);
//			String[] node1 = new String[1];
//			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 29, 1);
//			actual[1] = tr.navigateToNode(releaseName, node1);
			
			String type= Excel_Lib.getData(INPUT_PATH_2, "Requirement", 29, 8);
			req.deleteOrDeallocateRequirementNode(type);
			bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
				System.out.println(actual[k]);
			}
			soft.assertAll();
		}

		catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

}
