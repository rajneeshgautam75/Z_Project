package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddRequirement_12 extends LaunchBrowser {

	BasePage bp;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	String fileName = "AddRequirement_12";

	boolean[] actual = new boolean[33];
	SoftAssert soft = new SoftAssert();

	@Given("^user login as manager,launch Requirement app$")
	public void user_login_as_manager_launch_Requirement_app() throws Throwable {
		try {
			pp = new ProjectPage(driver);
			rp = new ReleasePage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_1");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			actual[0] = pp.selectProject(projectName);
			actual[1] = pp.selectRelease(releaseName);
			bp = new BasePage();
			bp.waitForElement();
			actual[2] = rp.clickOnRequirements();
			bp.waitForElement();
		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@When("^user navigate to the top level node under Global tree node$")
	public void user_navigate_to_the_top_level_node_under_Global_tree_node() throws Throwable {
		try {
			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String[] ph = new String[1];
			ph[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			tr = new TestRepositoryPage(driver);
			actual[3] = tr.navigateToNode(nodeName, ph);

		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;

		}
	}

	@And("^user Add requirement to node with detail like atlid,Prioroty,Link$")
	public void user_Add_requirement_to_node_with_detail_like_atlid_Prioroty_Link() throws Throwable {
		try {
			String phaseName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			for (int j = 1; j < 3; j++) {
				bp.waitForElement();
				req = new RequirementsPage(driver);
				actual[4] = req.addRequirement();
				tr.clickOnDetails();
				String name = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 0);
				String altID = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 1);
				String link = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 2);
				String priority = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 3);
				String Description = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 4);
				actual[5] = req.enterRequirementDetails(name, altID, link, priority, Description);
				bp.waitForElement();
				tr.clickOnList();
			}
			actual[6] = req.minimizeFolderNode(phaseName1);

			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String[] ph = new String[1];
			ph[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			actual[7] = tr.navigateToNode(nodeName, ph);
			String phaseName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			for (int j = 1; j < 3; j++) {
				bp.waitForElement();
				actual[8] = req.addRequirement();
				tr.clickOnDetails();
				String name = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 0);
				String altID = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 1);
				String link = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 2);
				String priority = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 3);
				String Description = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 4);
				actual[9] = req.enterRequirementDetails(name, altID, link, priority, Description);
				bp.waitForElement();
				tr.clickOnList();
			}
			actual[10] = req.minimizeFolderNode(phaseName2);
		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@Then("^user added requirements in top level node with detail$")
	public void user_added_requirements_in_top_level_node_with_detail() throws Throwable {
		try {

			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);

			String phName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			actual[11] = tr.selectPhase(phName1);
			bp.waitForElement();
			actual[12] = req.VerifyRequirementCount();

			String phName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			actual[13] = tr.selectPhase(phName2);
			bp.waitForElement();
			actual[14] = req.VerifyRequirementCount();
		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@When("^User navigate to Sub nodes in global tree node under$")
	public void user_navigate_to_Sub_nodes_in_global_tree_node_under() throws Throwable {
		try {

			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String[] ph = new String[2];
			ph[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			ph[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 3, 0);
			actual[15] = tr.navigateToNode(nodeName, ph);

			String phase_sub1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 3, 0);
			actual[16] = tr.selectPhase(phase_sub1);

			bp.waitForElement();

			String[] ph2 = new String[2];
			ph2[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			ph2[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 2);
			actual[17] = tr.navigateToNode(nodeName, ph2);
			String phase2_sub = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 2);
			actual[18] = tr.selectPhase(phase2_sub);
			String phaseName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			actual[19] = req.minimizeFolderNode(phaseName2);

		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@And("^user add Requirements to sub node with detail like atlid,Prioroty,Link\\.$")
	public void user_add_Requirements_to_sub_node_with_detail_like_atlid_Prioroty_Link() throws Throwable {
		try {
			req = new RequirementsPage(driver);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			for (int i = 3; i < 6; i++) {
				String ph1_sub = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 0);
				actual[20] = tr.selectPhase(ph1_sub);

				for (int j = 1; j < 3; j++) {
					bp.waitForElement();

					actual[21] = req.addRequirement();
					tr.clickOnDetails();
					String name = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 0);
					String altID = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 1);
					String link = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 2);
					String priority = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 3);
					String Description = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 4);
					actual[22] = req.enterRequirementDetails(name, altID, link, priority, Description);
					bp.waitForElement();
					tr.clickOnList();
				}

			}
			actual[23] = req.minimizeFolderNode(phaseName);

			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String phaseName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			String[] ph = new String[2];
			ph[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			ph[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 2);
			actual[24] = tr.navigateToNode(nodeName, ph);
			for (int i = 1; i < 4; i++) {
				String ph2_sub = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 2);
				actual[25] = tr.selectPhase(ph2_sub);

				for (int j = 1; j < 3; j++) {
					bp.waitForElement();
					actual[26] = req.addRequirement();
					tr.clickOnDetails();
					String name = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 0);
					String altID = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 1);
					String link = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 2);
					String priority = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 3);
					String Description = Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", j, 4);
					actual[27] = req.enterRequirementDetails(name, altID, link, priority, Description);
					bp.waitForElement();
					tr.clickOnList();
				}
			}
			actual[28] = req.minimizeFolderNode(phaseName2);

		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@Then("^requirment added sucessfully to subnodes$")
	public void requirment_added_sucessfully_to_subnodes() throws Throwable {
		try {
			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String[] ph = new String[1];
			ph[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			actual[29] = tr.navigateToNode(nodeName, ph);
			for (int i = 3; i < 6; i++) {

				String ph1_sub = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 0);
				actual[30] = tr.selectPhase(ph1_sub);
				req.VerifyRequirementCount();
			}

			String[] ph2 = new String[1];
			ph2[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			actual[31] = tr.navigateToNode(nodeName, ph2);
			for (int i = 1; i < 3; i++) {

				String ph2_sub = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 2);
				actual[32] = tr.selectPhase(ph2_sub);
				req.VerifyRequirementCount();
			}
			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re = new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}
}