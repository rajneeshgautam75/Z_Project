package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_16 extends LaunchBrowser {

	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[15];
	SoftAssert soft = new SoftAssert();

	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "Requirement_16";

	@Given("^Login as manager$")
	public void login_as_manager() throws Throwable {

		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			bp.waitForElement();
			actual[0] = pp.clickOnLogout();
			lp = new LoginPage(driver);
			bp = new BasePage();
			String managerUname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Manager_Username_1");
			String managerPass = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Manager_Password_1");
			actual[1] = lp.enterUnameAndPassword(managerUname, managerPass);
			ccp = new CreateCustomFieldsPage(driver);

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

	@When("^user click on administration and select custom fields of type requirement$")
	public void user_click_on_administration_and_select_custom_fields_of_type_requirement() throws Throwable {
		try {
			actual[2] = ccp.moveToCustomFieldsOfRequirement();

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

	@When("^create all type of custom fields for all projects with one mandatory fields$")
	public void create_all_type_of_custom_fields_for_all_projects_with_one_mandatory_fields() throws Throwable {

		try {
			String[] piclistValues = new String[2];
			for (int i = 1; i <= 6; i++) {

				if (i == 6) {
					piclistValues[0] = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 10, 3);
					piclistValues[1] = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 11, 3);
				}
				String customfieldName = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 0);
				String customfieldDescription = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 1);
				String dataType = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 2);
				// piclistValues[0]=Excel_Lib.getData(INPUT_PATH_2,"CustomField",
				// i+4, 3);
				String allProject = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 4);
				String projectName = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 5);
				String searchableCheck = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 6);
				String unique = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 7);
				String mandatory = Excel_Lib.getData(INPUT_PATH_2, "CustomField", i + 4, 8);
				
				boolean available=ccp.checkAvailableCustomFields(customfieldName);
				if(available==false)
				{
					
					//actual[3] = 
				ccp.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues,
						allProject, projectName, searchableCheck, unique, mandatory);
				
				log.info(
						"Pass - Custom Fields with Text,LongText,Picklist,Checkbox,Number,Date Should be created Successfully");

				}
			}

			bp.waitForElement();
			ccp.closeCustomFieldWindow.click();
			actual[3] = bp.waitForElement();

			
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

	@When("^logout from the application$")
	public void logout_from_the_application() throws Throwable {

		try {
			actual[4] = pp.clickOnLogout();

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

	@When("^user navigate to requirement module page$")
	public void user_navigate_to_requirement_module_page() throws Throwable {
		try {

			String leadUname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Lead_Username_1");
			String leadPass = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Lead_Password_1");
			actual[5] = lp.enterUnameAndPassword(leadUname, leadPass);
			rp = new ReleasePage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_2");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			actual[6] = pp.selectProject(projectName);
			bp.waitForElement();
			actual[7] = pp.selectRelease(releaseName);

			actual[8] = rp.clickOnRequirements();

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

	@When("^create a node and add requirement in it$")
	public void create_a_node_and_add_requirement_in_it() throws Throwable {

		try {
			
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String pName1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 27, 1);
			String pDesc1 = Excel_Lib.getData(INPUT_PATH_2, "Requirement", 27, 2);
            tr=new TestRepositoryPage(driver);
			actual[9]=tr.clickOnRelease(releaseName);
			req=new RequirementsPage(driver);
			actual[10] = req.addNode(pName1, pDesc1);
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 27, 1);
			actual[11] = tr.navigateToNode(releaseName, node1);

			actual[12] = req.addRequirement();
			tr.clickOnDetails();

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

	@When("^enter the value for all custom fields$")
	public void enter_the_value_for_all_custom_fields() throws Throwable {

		try {
			String text = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 1, 7);
			String longText = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 1, 8);
			String number = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 9));
			// piclistValues[0]=Excel_Lib.getData(INPUT_PATH_2,"CustomField",
			// i+4, 3);
			String checkBox = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 1, 10);
			String pickupList = Excel_Lib.getData(INPUT_PATH_2, "ReqDetails", 1, 11);
			String date = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqDetails", 1, 12));

			actual[13] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);

			//actual[14] = req.clickOnCustomFieldHeader();
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

	@When("^add one more requirement and update the requirement name without entering mandatory custom field$")
	public void add_one_more_requirement_and_update_the_requirement_name_without_entering_mandatory_custom_field()
			throws Throwable {

		try {
			req.addRequirement();
			bp.waitForElement();
			String name = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 2, 0);
			String altID = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 99, 8);

			String Description = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 99, 8);

			String link = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 99, 10);
			String priority = Excel_Lib.getData(INPUT_PATH_2, "CustomField", 99, 11);
			
			boolean res = req.enterRequirementDetails(name, altID, link, priority, Description);
			
			if(res==false)
			{
				log.info("Requirement name is not updated");
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

	@Then("^requirement name should not be save$")
	public void requirement_name_should_not_be_save() throws Throwable {

		try {
			
			tr.clickOnList();
			
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "Requirement", 27, 1);
			actual[14] = tr.navigateToNode(releaseName, node1);
			String type=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 27, 8);
			req.deleteOrDeallocateRequirementNode(type);
			bp.waitForElement();

			for (int k = 0; k <= actual.length - 1; k++) {
				soft.assertEquals(actual[k], true);
				System.out.println(actual[k]);
			}
			soft.assertAll();
			log.info("Requirement name not updated");

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
