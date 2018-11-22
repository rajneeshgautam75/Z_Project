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

public class Requirement_15 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[33];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "Requirement_15";

	@When("^add two node in global tree$")
	public void add_two_node_in_global_tree() throws Throwable {
		try {
			req = new RequirementsPage(driver);
			tr = new TestRepositoryPage(driver);
			bp = new BasePage();
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 24, 1);
			String desc1 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 24, 2);

			actual[0] = req.addNode(name1, desc1);

			actual[1] = tr.doubleClickOnRelease(folderName);

			String name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 1);
			String desc2 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 2);

			actual[2] = req.addNode(name2, desc2);

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

	@When("^add multiple requirements to both the nodes$")
	public void add_multiple_requirements_to_both_the_nodes() throws Throwable {

		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 24, 1);
			bp.waitForElement();
			actual[3] = tr.navigateToNode(folderName, node1);
			for (int i = 1; i <= 5; i++) {
				actual[4] = req.addRequirement();
			}
			String phaseName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 1);
			actual[5] = tr.selectPhase(phaseName2);

			for (int i = 1; i <= 5; i++) {
				actual[6] = req.addRequirement();
			}

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

	@Then("^requirements should be added in both the nodes$")
	public void requirements_should_be_added_in_both_the_nodes() throws Throwable {
		try {
			String phaseName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 24, 1);
			String phaseName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 1);
			actual[7] = tr.selectPhase(phaseName1);

			actual[8] = req.VerifyRequirementCount();

			actual[9] = tr.selectPhase(phaseName2);

			actual[10] = req.VerifyRequirementCount();

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

	@When("^user selects the multiple requirements from first node$")
	public void user_selects_the_multiple_requirements_from_first_node() throws Throwable {

		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 24, 1);

			actual[11] = tr.navigateToNode(folderName, node1);

			String[] requirements = new String[2];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));
			requirements[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 2, 6));
			actual[12] = req.selectMultipleRequirementFromGrids(requirements);

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

	@When("^click on allocate option button$")
	public void click_on_allocate_option_button() throws Throwable {
		try {

			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);

			actual[13] = req.allocateRequirements();

			actual[14] = req.minimizeFolderNode(folderName);
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

	@Then("^selected requirements with folder structure should be allocated to the current release$")
	public void selected_requirements_with_folder_structure_should_be_allocated_to_the_current_release()
			throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 24, 1);
			actual[15] = tr.navigateToNode(releaseName, node1);

			actual[16] = req.VerifyRequirementCount();

			actual[17] = req.minimizeFolderNode(releaseName);

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

	@When("^user selects second node from global tree$")
	public void user_selects_second_node_from_global_tree() throws Throwable {
		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 1);
			actual[18] = tr.navigateToNode(folderName, node1);

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

	@When("^choose allocate option from context menu$")
	public void choose_allocate_option_from_context_menu() throws Throwable {
		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			actual[18] = req.allocateRequirementNode();
			actual[19] = req.minimizeFolderNode(folderName);

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

	@Then("^global node should be allocated to current release with requirements in it$")
	public void global_node_should_be_allocated_to_current_release_with_requirements_in_it() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 1);
			actual[20] = tr.navigateToNode(releaseName, node1);

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

	@When("^user add a node in local release tree$")
	public void user_add_a_node_in_local_release_tree() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 26, 1);
			String desc1 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 26, 2);

			actual[21] = tr.doubleClickOnRelease(releaseName);
			actual[0] = req.addNode(name1, desc1);

			actual[22] = req.minimizeFolderNode(releaseName);

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

	@When("^navigate to the same node in global tree and add multiple requirement in it$")
	public void navigate_to_the_same_node_in_global_tree_and_add_multiple_requirement_in_it() throws Throwable {
		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 26, 1);
			actual[23] = tr.navigateToNode(folderName, node1);

			for (int i = 1; i <= 3; i++) {
				actual[24] = req.addRequirement();
			}

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

	@When("^allocate the node from global tree$")
	public void allocate_the_node_from_global_tree() throws Throwable {
		try {
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 26, 1);
			actual[25] = tr.selectPhase(phaseName);
			actual[26] = req.allocateRequirementNode();
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			actual[27] = req.minimizeFolderNode(folderName);

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

	@Then("^newly added requirement in global tree should show in current release$")
	public void newly_added_requirement_in_global_tree_should_show_in_current_release() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 26, 1);
			actual[28] = tr.navigateToNode(releaseName, node1);
			actual[29] = req.minimizeFolderNode(releaseName);

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

	@When("^user allocate a second node which is already in local relase with all requirements$")
	public void user_allocate_a_second_node_which_is_already_in_local_relase_with_all_requirements() throws Throwable {
		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 25, 1);
			actual[30] = tr.navigateToNode(folderName, node1);

			actual[31] = req.allocateRequirementNode();
			actual[32] = req.minimizeFolderNode(folderName);
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

	@Then("^allocated successfully message should show up$")
	public void allocated_successfully_message_should_show_up() throws Throwable {

		try {
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
