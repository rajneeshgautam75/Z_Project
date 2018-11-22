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

public class Import_37 extends LaunchBrowser
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
	String fileName="Import_37";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[6];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in the requirement page to Import and Move the file$")
	public void user_in_the_requirement_page_to_Import_and_Move_the_file() throws Throwable 
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


@When("^click on Import Select excel and Create map import the file to the folder$")
public void click_on_Import_Select_excel_and_Create_map_import_the_file_to_the_folder() throws Throwable {
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			///creating map
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "ImportType",16,2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType",2,3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType",1,4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType",16,5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType",4,9);
			actual[2]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			///////import
			ip.clickOnNextForImport();
			String jobname=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 16, 10);
			String mapName=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 16, 14);
			String path=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 5, 11);
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

	@When("^Move the import file to local area to copy the imported node$")
	public void move_the_import_file_to_local_area_to_copy_the_imported_node() throws Throwable {
		try
		{
			req.minimizeFolderNode(releaseName);
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",16,12);
			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
			actual[4]=ip.validateImportRequirment(fileName, Impported);
			
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

	@When("^Move the imported file to global area$")
	public void move_the_imported_file_to_global_area() throws Throwable 
	{
		try
		{
			
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",16,12);
			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
			
            ip.validateImportRequirment(fileName, Impported);
		    
			
			req.copyNode();
			
			String fileName1=Excel_Lib.getData(INPUT_PATH_4, "ImportType",3,13);
			tr.doubleClickOnRelease(fileName1);
			req.pasteNode();
//			
//			req.copyNode();
//			tr=new TestRepositoryPage(driver);
//			String global=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
//			tr.doubleClickOnRelease(global);
//			//actual[4]=ip.validateImportRequirment(fileName, global);
//			req.pasteNode();
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

	@Then("^Should able to Display in the Global area$")
	public void should_able_to_Display_in_the_Global_area() throws Throwable 
	{
		try
		{	
			String fileName=Excel_Lib.getData(INPUT_PATH_4, "ImportType",16,12);
			String Impported=Excel_Lib.getData(INPUT_PATH_4, "ImportType",2,13);
			actual[5]=ip.validateImportRequirment(fileName, Impported);
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
