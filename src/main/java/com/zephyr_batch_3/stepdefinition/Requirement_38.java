package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_38 extends LaunchBrowser {

	
	
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestRepositoryPage tp;
	
	RequirementsPage req;
	BasePage bp;
	ImportPage ip;
	String fileName = "Requirement_38";
	
	LaunchBrowser lb=new LaunchBrowser();
	boolean[] actual = new boolean[14];
	SoftAssert soft = new SoftAssert();

	
	@Given("^User is in requirement page of normal Project$")
	public void user_is_in_requirement_page_of_normal_Project() throws Throwable {
		try {

			
		
			pp = new ProjectPage(driver);
			rp = new ReleasePage(driver);
			bp = new BasePage();
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_2");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Release_1");
			actual[0] = pp.selectProject(projectName);

			actual[1] = pp.selectRelease(releaseName);

			actual[2] = rp.clickOnRequirements();

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

	@When("^User click on import and choose excel option$")
	public void user_click_on_import_and_choose_excel_option() throws Throwable {
		try
		{
		req=new RequirementsPage(driver);
		actual[3] =req.clickOnImport();

		String importType = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 1, 12);
		actual[4] =req.chooseImportType(importType);
		
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

	@When("^create a map with custom fields rows$")
	public void create_a_map_with_custom_fields_rows() throws Throwable {
		try
		{
			ip=new ImportPage(driver);
			actual[5] =ip.clickOnNextForMap();

		String mapname = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 0);
		int rownum = Excel_Lib.getNumberData(INPUT_PATH_2, "Create_Map", 4, 1);
		String descrimi = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 2);
		String desc = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 3);
		String name = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 4);
		String testSteps = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 5);
		String expResults = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 6);
		String extrID = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 7);
		String[] customFields= new String[6];
		for(int i=0;i<=5;i++)
		{
		customFields[i]=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, i+13);
		}
		actual[6] =ip.createMapForRequirementWithCustomField(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID, customFields);

		
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

	@Then("^map should be created sucessfully$")
	public void map_should_be_created_sucessfully() throws Throwable {
		try
		{
		String ValMapname = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 7, 1);
		actual[7] =ip.validateMap(ValMapname); 
		
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

	@When("^user add a job and run it$")
	public void user_add_a_job_and_run_it() throws Throwable {
		try
		{
			actual[8] =ip.clickOnNextForImport();
		String jobname = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 7, 0);
		String mapName = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 7, 1);
		String path = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 7, 2);
		actual[9] =ip.importTestCaseRequirment(jobname, mapName, path);
		actual[10] =ip.runJob();
		bp.waitForElement();
		actual[11] =ip.ClickOKonStatusReport();
		actual[12] =ip.closeImportPage();
		
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

	@Then("^should be able to import with unique custom field value$")
	public void should_be_able_to_import_with_unique_custom_field_value() throws Throwable {
		try
		{
		String ImportFolderName = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 1, 10);
		String fileName = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 4, 11);

		actual[13] = ip.validateImportRequirment(fileName, ImportFolderName);
		
		 tr=new TestRepositoryPage(driver);
		 tr.clickOnDetails();
		//actual[14] =req.clickOnCustomFieldHeader();
	
		String customNumberValue=req.customReqNumber.getText();
		if(customNumberValue!="")
		{
			log.info("Custom Number Value-"+customNumberValue);
		    log.info("Successsfully added custom field value in import");
		
		}
		tr.clickOnList();
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
