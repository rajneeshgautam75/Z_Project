package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.WebElement;
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

public class Requirement_13 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[14];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "Requirement_13";

	@When("^user selct the global folder Node$")
	public void user_selct_the_global_folder_Node() throws Throwable {

		bp = new BasePage();
		req = new RequirementsPage(driver);
		tr = new TestRepositoryPage(driver);
		String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
		actual[0] = tr.doubleClickOnRelease(folderName);
	}

	@When("^add a node with requirements$")
	public void add_a_node_with_requirements() throws Throwable {

		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 20, 1);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 20, 2);

			actual[1] = req.addNode(name, desc);

			String[] node1 = new String[1];
			node1[0] = name;

			actual[2] = tr.navigateToNode(folderName, node1);

			for (int i = 1; i <= 5; i++) {
				actual[3] = req.addRequirement();
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

	@Then("^requirements should be added in the node$")
	public void requirements_should_be_added_in_the_node() throws Throwable {
		try {

			actual[4] = req.VerifyRequirementCount();

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

	@When("^user add another node with empty requirements in it$")
	public void user_add_another_node_with_empty_requirements_in_it() throws Throwable {
		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 21, 1);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 21, 2);

			actual[5] = tr.doubleClickOnRelease(folderName);
			actual[0] = req.addNode(name, desc);

			String[] node1 = new String[1];
			node1[0] = name;

			actual[6] = tr.navigateToNode(folderName, node1);
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

	@Then("^no requirement should be present in the node$")
	public void no_requirement_should_be_present_in_the_node() throws Throwable {
		try {

			actual[7] = req.VerifyRequirementCount();

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

	@When("^user selects multiple requirements from first node$")
	public void user_selects_multiple_requirements_from_first_node() throws Throwable {

		try {
			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 20, 1);

			actual[8] = tr.navigateToNode(folderName, node1);
			String[] requirements = new String[2];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));
			requirements[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 2, 6));
			actual[9] = req.selectMultipleRequirementFromGrids(requirements);
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

	@When("^copy the selected requirement to second node in global tree using ctrl\\+Dnd$")
	public void copy_the_selected_requirement_to_second_node_in_global_tree_using_ctrl_Dnd() throws Throwable {

		try {
			WebElement src = req.srcReq;
			String destNode = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 21, 1);
			actual[10] = tr.copyTestCase(src, destNode);

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

	@Then("^requirements should be copied to the second node in global tree$")
	public void requirements_should_be_copied_to_the_second_node_in_global_tree() throws Throwable {

		try {

			String folderName = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 7);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 21, 1);

			actual[11] = tr.navigateToNode(folderName, node1);
			actual[12] = req.VerifyRequirementCount();
			bp.waitForElement();
			actual[13] = req.minimizeFolderNode(folderName);
			bp.waitForElement();
			
			pp=new ProjectPage(driver);
			pp.clickOnLogout();
			pp.closeBrowser();
			//driver.navigate().refresh();
//			pp=new ProjectPage(driver);
//			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_1");
//			pp.selectProject(projectName);
			
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
