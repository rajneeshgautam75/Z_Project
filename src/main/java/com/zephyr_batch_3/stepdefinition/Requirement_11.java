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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_11 extends LaunchBrowser {

	BasePage bp;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	String fileName = "Requirement_11";

	boolean[] actual = new boolean[15];
	SoftAssert soft = new SoftAssert();

	@Given("^As manager, Launch Requirement app$")
	public void as_manager_Launch_Requirement_app() throws Throwable {
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

	@When("^user select Global tree node add a Top level nodes with description$")
	public void user_select_Global_tree_node_add_a_Top_level_nodes_with_description() throws Throwable {
		try {
			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			req = new RequirementsPage(driver);
			tr = new TestRepositoryPage(driver);
			actual[3] = tr.selectPhase(nodeName);
			for (int i = 1; i < 3; i++) {
				String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 0);
				String desc = Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 1);

				actual[4] = req.addNode(name, desc);
				bp.waitForElement();
				actual[5] = tr.selectPhase(nodeName);
			}
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

	@Then("^top level nodes added successfully$")
	public void top_level_nodes_added_successfully() throws Throwable {
		try {
			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String[] str = new String[1];
			str[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			actual[6] = tr.navigateToNode(nodeName, str);
			String[] st = new String[1];
			st[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			actual[7] = tr.navigateToNode(nodeName, st);
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

	@When("^user will add three sub nodes under each node with desciption for only two sub nodes$")
	public void user_will_add_three_sub_nodes_under_each_node_with_desciption_for_only_two_sub_nodes()
			throws Throwable {
		try {
			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);

			String[] str = new String[1];
			str[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			actual[8] = tr.navigateToNode(nodeName, str);
			for (int i = 3; i < 6; i++) {
				String phase1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
				String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 0);
				String desc = Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 1);
				tr.selectPhase(phase1);
				actual[9] = req.addNode(name, desc);
				bp.waitForElement();

			}

			String[] str1 = new String[1];
			str1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			actual[10] = tr.navigateToNode(nodeName, str1);
			bp.waitForElement();
			for (int i = 1; i < 4; i++) {
				String ph2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
				String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 2);
				String desc = Excel_Lib.getData(INPUT_PATH_9, "Creating_level", i, 3);
				actual[11] = tr.selectPhase(ph2);
				bp.waitForElement();
				actual[12] = req.addNode(name, desc);
			}

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

	@Then("^subnodes added successfully$")
	public void subnodes_added_successfully() throws Throwable {
		try {
			String nodeName = Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
			String[] ph1 = new String[2];
			ph1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 0);
			ph1[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 3, 0);
			actual[13] = tr.navigateToNode(nodeName, ph1);

			String sys2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 4, 0);
			String sys3 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 5, 0);
			tr.selectPhase(sys2);
			tr.selectPhase(sys3);

			String[] ph2 = new String[2];
			ph2[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 0);
			ph2[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 1, 2);
			actual[14] = tr.navigateToNode(nodeName, ph2);

			String sys21 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 2, 2);

			String sys31 = UNIQUE + Excel_Lib.getData(INPUT_PATH_9, "Creating_level", 3, 2);
			tr.selectPhase(sys21);
			tr.selectPhase(sys31);
			bp.waitForElement();


			for (int i = 0; i <= actual.length - 1; i++) {
				System.out.println(actual[i]);
				soft.assertEquals(actual[i], true);
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
