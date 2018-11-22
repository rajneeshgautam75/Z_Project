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

public class Import_35 extends LaunchBrowser
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
	String fileName="Import_35";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[21];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in requrement page to import the Requirements$")
	public void user_in_requrement_page_to_import_the_Requirements() throws Throwable 
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

	@When("^click on Import create map with By empty Row Import Requirement Special char filename and run the job$")
	public void click_on_Import_create_map_with_By_empty_Row_Import_Requirement_Special_char_filename_and_run_the_job() throws Throwable {
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",13,2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",13,5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
			actual[2]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 13, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 13, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 11);
			actual[3]=ip.importTestCaseRequirment(jobname, mapName, path);
			System.out.println(path);
			System.out.println(mapName);
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

	@Then("^should be able to Import the Special char filename$")
	public void should_be_able_to_Import_the_Special_char_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
			actual[4]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import create map with By Empty Row Import requirement International char filename and run the job$")
	public void click_on_import_create_map_with_By_Empty_Row_Import_requirement_International_char_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
//			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,2);
//			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
//			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
//			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,5);
//			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
//			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
//			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
//			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
//			ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 6, 11);
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

	@Then("^should be able to import the International char Filename$")
	public void should_be_able_to_import_the_International_char_Filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 6, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[6]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import create map with By Empty Row Import Requirement UPPERCASE char filename and run the job$")
	public void click_on_import_create_map_with_By_Empty_Row_Import_Requirement_UPPERCASE_char_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			actual[7]=ip.clickOnNextForMap();
			///creating map
//			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,2);
//			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
//			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
//			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,5);
//			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
//			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
//			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
//			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
//			ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 7, 11);
			actual[8]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@Then("^should be able to Import the  UPPERCASE Char filename$")
	public void should_be_able_to_Import_the_UPPERCASE_Char_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 7, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[9]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import and Import requirement number char filename and run the job$")
	public void click_on_import_and_Import_requirement_number_char_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
//			///creating map
//			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,2);
//			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
//			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
//			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,5);
//			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
//			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
//			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
//			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
//			ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 8, 11);
			actual[10]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@Then("^should be able to Import the  Number char filename$")
	public void should_be_able_to_Import_the_Number_char_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 8, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[11]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import and Import requirement lowercase char filename and run the job$")
	public void click_on_import_and_Import_requirement_lowercase_char_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
//			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,2);
//			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
//			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
//			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,5);
//			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
//			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
//			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
//			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
//			ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 9, 11);
			actual[12]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@Then("^should be able to Import the  Lowercase char filename$")
	public void should_be_able_to_Import_the_Lowercase_char_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 9, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[13]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import and Import requirement alphanumeric char filename and run the job$")
	public void click_on_import_and_Import_requirement_alphanumeric_char_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
//			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,2);
//			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
//			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
//			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",5,5);
//			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
//			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
//			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
//			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
//			ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			actual[14]=ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 10, 11);
			actual[15]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@Then("^should be able to Import the Alphanumeric char filename$")
	public void should_be_able_to_Import_the_Alphanumeric_char_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 10, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[16]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import and Import requirement Long filename and run the job$")
	public void click_on_import_and_Import_requirement_Long_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 13, 11);
			actual[17]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@Then("^should be able to Import the Long filename$")
	public void should_be_able_to_Import_the_Long_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 13, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[18]=ip.validateImportRequirment(fileName, releaseName);
			//ip.closeImportPage();
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

	@When("^click on import and Import requirement Short filename and run the job$")
	public void click_on_import_and_Import_requirement_Short_filename_and_run_the_job() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 14, 11);
			actual[19]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@Then("^should be able to Import the Short filename$")
	public void should_be_able_to_Import_the_Short_filename() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 14, 12);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 13);
			actual[20]=ip.validateImportRequirment(fileName, releaseName);
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
