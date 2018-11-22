package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Requirement_5 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[17];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();;
	String fileName = "Requirement_5";

	@When("^user add a node and add multiple requirement to the node$")
	public void user_add_a_node_and_add_multiple_requirement_to_the_node() throws Throwable {

		try {
			bp = new BasePage();
			req = new RequirementsPage(driver);
			tr = new TestRepositoryPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 9, 1);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 9, 2);

			actual[0] = req.addNode(name, desc);

			String[] node1 = new String[1];
			node1[0] = name;

			actual[1] = tr.navigateToNode(releaseName, node1);

			for (int i = 1; i <= 5; i++) {
				actual[2] = req.addRequirement();
			}

			for (int i = 1; i <= 5; i++) {
				actual[3] = req.selectAllRequirements();
				actual[4] = req.cloneRequirement();
			}
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

	@Then("^check the requirement count$")
	public void check_the_requirement_count() throws Throwable {
		try {
			actual[5] = req.VerifyRequirementCount();
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

	@When("^user add another node with name and description$")
	public void user_add_another_node_with_name_and_description() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 10, 1);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 10, 2);
			actual[6] = req.addNode(name, desc);
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

	@When("^copy the single requirement from first node to second node using Ctrl\\+DND$")
	public void copy_the_single_requirement_from_first_node_to_second_node_using_Ctrl_DND() throws Throwable {
		try {
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 9, 1);
			actual[7] = tr.selectPhase(name);
			String[] requirements = new String[1];
			requirements[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 6));
			actual[8] = req.selectMultipleRequirementFromGrids(requirements);
			WebElement srcEle = req.srcReq;
			String destNode = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 10, 1);
			actual[9] = tr.copyTestCase(srcEle, destNode);
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();

			bp.waitForElement();
			bp.waitForElement();
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

	@Then("^requirement should not be copied to the second node$")
	public void requirement_should_not_be_copied_to_the_second_node() throws Throwable {
		try {
			String destNode = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 10, 1);
			actual[10] = tr.selectPhase(destNode);

			actual[11] = req.VerifyRequirementCount();
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

	@When("^user select multiple requirement more than hundered$")
	public void user_select_multiple_requirement_more_than_hundered() throws Throwable {

		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");

			tr.selectPhase(releaseName);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 9, 1);
			actual[12] = tr.navigateToNode(releaseName, node1);
			
		
			WebElement phase2=driver.findElement(By.xpath(tr.releasename1+node1[0]+tr.releasename2));
			Actions a1=new Actions(driver);
			a1.moveToElement(phase2).doubleClick().perform();
			//tr.doubleClickOnRelease(node1[0]);
			bp.waitForElement();
			actual[13] = req.selectAllRequirements();
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

	@When("^copy the selected requirement the second node$")
	public void copy_the_selected_requirement_the_second_node() throws Throwable {

		try {
			WebElement srcEle = req.srcReq;
			String destNode = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 10, 1);
			actual[14] = tr.copyTestCase(srcEle, destNode);
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();

			bp.waitForElement();

			bp.waitForElement();
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

	@Then("^single requirement should not be copied to the second node$")
	public void single_requirement_should_not_be_copied_to_the_second_node() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");

			String destNode = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 10, 1);
			actual[15] = tr.selectPhase(destNode);

			actual[16] = req.VerifyRequirementCount();
			
			req.minimizeFolderNode(releaseName);

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
