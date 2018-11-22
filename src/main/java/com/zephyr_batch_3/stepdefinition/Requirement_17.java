package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

public class Requirement_17 extends LaunchBrowser {

	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	ImportPage ip;
	CreateCustomFieldsPage ccp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[13];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "Requirement_17";

	@Given("^User is in requirement module page of normal Project$")
	public void user_is_in_requirement_module_page_of_normal_Project() throws Throwable {

		try {
			pp = new ProjectPage(driver);
			rp = new ReleasePage(driver);
			bp = new BasePage();
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_2");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			actual[0] = pp.selectProject(projectName);

			actual[1] = pp.selectRelease(releaseName);

			actual[2] = rp.clickOnRequirements();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^add a requirement node$")
	public void add_a_requirement_node() throws Throwable {

		try {

			bp = new BasePage();
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String pName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 28, 1);
			String pDesc1 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 28, 2);

			actual[3] = tr.clickOnRelease(releaseName);
			actual[4] = req.addNode(pName1, pDesc1);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^add requirement and enter all custom fields value, save it$")
	public void add_requirement_and_enter_all_custom_fields_value_save_it() throws Throwable {

		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 28, 1);
			actual[5] = tr.navigateToNode(releaseName, node1);

			actual[6] = req.addRequirement();
		     
			tr.clickOnDetails();
			

			String text = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 15, 7);
			String longText = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 15, 8);
			String number = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 15, 9));
			// piclistValues[0]=Excel_Lib.getData(INPUT_PATH_2,"CustomField",
			// i+4, 3);
			String checkBox = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 15, 10);
			String pickupList = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 15, 11);
			String date = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 15, 12));

			actual[7] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);

			//actual[8] = req.clickOnCustomFieldHeader();
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

	@Then("^requirement should be added with custom fields value$")
	public void requirement_should_be_added_with_custom_fields_value() throws Throwable {

		try {
			actual[8] = req.VerifyRequirementCount();
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user select the requirement and update custom fields value ,save it$")
	public void user_select_the_requirement_and_update_custom_fields_value_save_it() throws Throwable {

		try {
			String[] requirements = new String[1];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));

			actual[9] = req.selectMultipleRequirementFromGrids(requirements);
			String text = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 16, 7);
			String longText = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 16, 8);
			String number = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 16, 9));
			// piclistValues[0]=Excel_Lib.getData(INPUT_PATH_2,"CustomField",
			// i+4, 3);
			String checkBox = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 16, 10);
			String pickupList = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 16, 11);
			String date = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 16, 12));

			actual[10] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();
			//actual[12] = req.clickOnCustomFieldHeader();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^custom fields value should be updated successfully$")
	public void custom_fields_value_should_be_updated_successfully() throws Throwable {

		try {
			actual[11] = req.VerifyRequirementCount();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user select the requirement and update custom fields value and cancel the changes$")
	public void user_select_the_requirement_and_update_custom_fields_value_and_cancel_the_changes() throws Throwable {

		try {
			
			String[] requirements = new String[1];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));

			actual[12] = req.selectMultipleRequirementFromGrids(requirements);

			String text = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 17, 7);
			//req.customFieldHeading.click();
			bp.waitForElement();

			bp.eraseText(req.customReqText);
			Actions a1 = new Actions(driver);
			a1.sendKeys(text).sendKeys(Keys.TAB).perform();
			bp.waitForElement();
			//req.customFieldHeading.click();
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^custom fields value should not be updated$")
	public void custom_fields_value_should_not_be_updated() throws Throwable {
		try {
			
			tr.clickOnList();
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			log.info("Custom field value Not Updated");
			
			tr.clickOnRelease(releaseName);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 28, 1);
			
			tr.selectPhase(node1[0]);
			//actual[5] = tr.navigateToNode(releaseName, node1);
			String type= Excel_Lib.getData(INPUT_PATH_2, "Requirement", 28, 8);
	         req.deleteOrDeallocateRequirementNode(type);
	         bp.waitForElement();
	         bp.waitForElement();
	         //req.minimizeFolderNode(releaseName);
	         
			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
				System.out.println(actual[k]);
			}
			soft.assertAll();
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
