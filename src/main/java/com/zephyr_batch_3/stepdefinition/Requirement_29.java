package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_29 extends LaunchBrowser {
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[6];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();;
	String fileName = "Requirement_29";

	@When("^user create a requirement node and add requirements in it$")
	public void user_create_a_requirement_node_and_add_requirements_in_it() throws Throwable {

		try {
			req = new RequirementsPage(driver);
			tr = new TestRepositoryPage(driver);
			bp = new BasePage();
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			req = new RequirementsPage(driver);

			String pName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 31, 1);
			String pDesc1 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 31, 2);

			actual[0] = req.addNode(pName1, pDesc1);

			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 31, 1);
			actual[1] = tr.navigateToNode(releaseName, node1);

			for (int i = 1; i <= 5; i++) {
				actual[2] = req.addRequirement();
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

	@When("^enter the requirement detail like alt id,priority,custom fields etc$")
	public void enter_the_requirement_detail_like_alt_id_priority_custom_fields_etc() throws Throwable {

		try {
			tr.clickOnDetails();
			String[] reqDetails1 = new String[5];
			reqDetails1[0] = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 19, 1);
			reqDetails1[1] = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 19, 2);
			reqDetails1[2] = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 19, 3);
			reqDetails1[3] = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 19, 4);
			reqDetails1[4] = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 19, 5);

			actual[3] = req.enterRequirementDetails(reqDetails1[0], reqDetails1[1], reqDetails1[2], reqDetails1[3],
					reqDetails1[4]);

		} catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		// req.enterRequirementDetails(name, altID, link, priority, Description)
	}

	@Then("^view the requirement counts$")
	public void view_the_requirement_counts() throws Throwable {

		try {
			tr.clickOnList();
			actual[4] = req.VerifyRequirementCount();

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

	@When("^user select the first requirement and navigate to detail view using navigator$")
	public void user_select_the_first_requirement_and_navigate_to_detail_view_using_navigator() throws Throwable {

		try {
			String[] requirements = new String[1];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));
			actual[5] = req.selectMultipleRequirementFromGrids(requirements);
			bp.waitForElement();
			//req.detailIcon.click();
			tr.clickOnDetails();

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

	@Then("^able to navigate to detail view$")
	public void able_to_navigate_to_detail_view() throws Throwable {
		try {
			log.info("Successfully navigated to Detail view");

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

	@When("^user change the requirement using symbol\\(\\^\\)$")
	public void user_change_the_requirement_using_symbol() throws Throwable {
		try {
			bp.waitForElement();
			req.clickOnNextRequirements.click();

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

	@Then("^requirements should be changed$")
	public void requirements_should_be_changed() throws Throwable {
		try {
			log.info("Successfully clicked on next Requirements");
			tr.clickOnList();

			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
				System.out.println(actual[k]);
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
