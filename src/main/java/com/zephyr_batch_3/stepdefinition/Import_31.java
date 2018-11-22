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

public class Import_31 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestRepositoryPage tp;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ImportPage ip;
	String fileName="Import_31";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in requirement Page$")
	public void user_in_requirement_Page() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			    rp.clickOnRequirements();
			    bp.waitForElement();
		   }
		catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		} 
	}

	@Given("^click on import create map with By empty Row Import requirement and run the job$")
	public void click_on_import_create_map_with_By_empty_Row_Import_requirement_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType", 2, 3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 9);
			actual[2]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 11);
			actual[3]=ip.importTestCaseRequirment(jobname, mapName, path);
			ip.runJob1();
			bp.waitForElement();
			ip.closeImportPage();
		 }
				catch(Exception e)
				{
			    	lb=new LaunchBrowser();
					lb.getScreenShot(fileName);	
			    	e.printStackTrace();
					driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e;
				} 
	}

	@When("^create map with By ID Change Import requirement and run the job$")
	public void create_map_with_By_ID_Change_Import_requirement_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType", 2, 3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 9);
			actual[4]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 11);
			actual[5]=ip.importTestCaseRequirment(jobname, mapName, path);
			ip.runJob1();
			ip.closeImportPage();
		 }
				catch(Exception e)
				{
			    	lb=new LaunchBrowser();
					lb.getScreenShot(fileName);	
			    	e.printStackTrace();
					driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e;
				} 
	}

	@When("^create map with By Requirement Name Change Import requirement and run the job$")
	public void create_map_with_By_Requirement_Name_Change_Import_requirement_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType", 2, 3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 3, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 9);
			actual[6]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 4, 11);
			actual[7]=ip.importTestCaseRequirment(jobname, mapName, path);
			ip.runJob1();
			ip.closeImportPage();
		 }
				catch(Exception e)
				{
			    	lb=new LaunchBrowser();
					lb.getScreenShot(fileName);	
			    	e.printStackTrace();
					driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e;
				} 
	}

	@Then("^Should be able to save a map with all discriminators and import the requirements$")
	public void should_be_able_to_save_a_map_with_all_discriminators_and_import_the_requirements() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[8]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		    soft.assertAll();
		 }
				catch(Exception e)
				{
			    	lb=new LaunchBrowser();
					lb.getScreenShot(fileName);	
			    	e.printStackTrace();
					driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e;
				} 
	}

}
