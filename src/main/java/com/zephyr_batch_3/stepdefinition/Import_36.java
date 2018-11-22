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

public class Import_36 extends LaunchBrowser
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
	String fileName="Import_36";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[6];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in the requirement page to oimport the file and copy$")
	public void user_in_the_requirement_page_to_oimport_the_file_and_copy() throws Throwable 
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

	@When("^select import select excel and create map import the file$")
	public void select_import_select_excel_and_create_map_import_the_file() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 14);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",15,5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
			actual[2]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 11);
			actual[3]=ip.importTestCaseRequirment(jobname, mapName, path);
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

	@When("^copy the import file to local area and verify$")
	public void copy_the_import_file_to_local_area_and_verify() throws Throwable 
	{
		try
		{
			req.minimizeFolderNode(releaseName);
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,12);
			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
			actual[4]=ip.validateImportRequirment(fileName, Impported);
			bp.waitForElement();
			req.copyNode();
			tr=new TestRepositoryPage(driver);
			tr.doubleClickOnRelease(releaseName);
			//actual[4]=ip.validateImportRequirment(fileName, releaseName);
			req.pasteNode();
			
			req.minimizeFolderNode(releaseName);
			
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

	@When("^copy the imported file to global area and verify$")
	public void copy_the_imported_file_to_global_area_and_verify() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,12);
			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
			
            ip.validateImportRequirment(fileName, Impported);
		    
			
			req.copyNode();
			
			String fileName1=Excel_Lib.getData(INPUT_PATH_4, "ImportType",3,13);
			tr.doubleClickOnRelease(fileName1);
			req.pasteNode();
			
//			bp.waitForElement();
//			req.copyNode();
//			tr=new TestRepositoryPage(driver);
//			String global=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
//			tr.doubleClickOnRelease(global);
//			//actual[4]=ip.validateImportRequirment(fileName, global);
//			req.pasteNode();
//			bp.waitForElement();
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

	@Then("^should able to display file in the global area$")
	public void should_able_to_display_file_in_the_global_area() throws Throwable 
	{
		try
		{
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,12);
			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",3,13);
			actual[5]=ip.validateImportRequirment(fileName, Impported);
			bp=new BasePage();
//			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
//			actual[4]=ip.validateImportRequirment(fileName, Impported);
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
