package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_6 extends LaunchBrowser{

	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	ImportPage ip;
	CreateCustomFieldsPage ccp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[59];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();
	 String fileName="Requirement_6";

@When("^user click on import button and select excel option$")
public void user_click_on_import_button_and_select_excel_option() throws Throwable {
  
	try
	{
	bp=new BasePage();
	req=new RequirementsPage(driver);
	ip=new ImportPage(driver);
	tr=new TestRepositoryPage(driver);
	actual[0]=req.clickOnImport();
	
	 String importType =Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 12);
	 actual[1]=req.chooseImportType(importType);
	
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@When("^Create a mapping from excel sheet$")
public void create_a_mapping_from_excel_sheet() throws Throwable {
  
	try
	{
		actual[2]=ip.clickOnNextForMap();
	
	String mapname=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 0);
	int rownum=Excel_Lib.getNumberData(INPUT_PATH_2, "Create_Map", 3, 1);
	String descrimi=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 2);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 3);
	String name=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 4);
	String testSteps=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 5);
	String expResults=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 6);
	String extrID=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 3, 7);
	actual[3]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
	
	String ValMapname=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 3, 1);
	actual[4]=ip.validateMap(ValMapname);
	
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
	
	

}

@When("^Add job and run the job$")
public void add_job_and_run_the_job() throws Throwable {
	try
	{
		actual[5]=ip.clickOnNextForImport();
	String jobname=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 3, 0);
	String mapName=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 3, 1);
	String path=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 3, 2);
	actual[6]=ip.importTestCaseRequirment(jobname, mapName, path);
	ip.runJob();
	bp.waitForElement();
	actual[7]=ip.ClickOKonStatusReport();
	actual[8]=ip.closeImportPage();
	
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@Then("^import operation is successfully$")
public void import_operation_is_successfully() throws Throwable {
   try
   {
	   
	String ImportFolderName=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 10);
	String fileName=Excel_Lib.getData(INPUT_PATH_2,"Import_Job", 3, 3);
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	 req.minimizeFolderNode(releaseName);
	 actual[9]=ip.validateImportRequirment(fileName, ImportFolderName);
	 
   }
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
	
	
}

@When("^user move the imported folder to global node$")
public void user_move_the_imported_folder_to_global_node() throws Throwable {
	try
	{
	String ImportFolderName=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 10);
	tr.moveNode();
	actual[10]=req.minimizeFolderNode(ImportFolderName);
	String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
	actual[11]=tr.doubleClickOnRelease(folderName);
	actual[12]=tr.pasteNode();
	
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@Then("^node should be moved to global node$")
public void node_should_be_moved_to_global_node() throws Throwable {
	try
	{
	String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7); 
	String fileName=Excel_Lib.getData(INPUT_PATH_2,"Import_Job", 3, 3);
	
	actual[13]=ip.validateImportRequirment(fileName, folderName);
	actual[14]=req.minimizeFolderNode(folderName);
	 
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
	
	
}

@When("^user run another job$")
public void user_run_another_job() throws Throwable {
	
	try
	{
		actual[15]=req.clickOnImport();
	
	String importType =Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 12);
	actual[16]=req.chooseImportType(importType);
	actual[17]=ip.clickOnNextForMap();
	actual[18]=ip.clickOnNextForImport();
	
	String jobname=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 4, 0);
	String mapName=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 4, 1);
	String path=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 4, 2);
	actual[19]=ip.importTestCaseRequirment(jobname, mapName, path);
	actual[20]=ip.runJob();
	bp.waitForElement();
	actual[21]=ip.ClickOKonStatusReport();
	actual[22]=ip.closeImportPage();
	
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
	
}

@When("^copy the imported node to global node$")
public void copy_the_imported_node_to_global_node() throws Throwable {
	try
	{
	String ImportFolderName=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 10);
	
	 String fileName=Excel_Lib.getData(INPUT_PATH_2,"Import_Job", 4, 3);
	 actual[23]=ip.validateImportRequirment(fileName, ImportFolderName);
	 actual[24]=tr.copyNode();
	 actual[25]=req.minimizeFolderNode(ImportFolderName);
	 String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7); 
	 actual[26]=tr.doubleClickOnRelease(folderName);
	 
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@Then("^node should be pasted to the global node$")
public void node_should_be_pasted_to_the_global_node() throws Throwable {
	try
	{
	String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
	actual[27]=tr.pasteNode();
	actual[28]=req.minimizeFolderNode(folderName);
	
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@When("^user run another job and copy the imported node to current release$")
public void user_run_another_job_and_copy_the_imported_node_to_current_release() throws Throwable {
	try
	{
		actual[29]=req.clickOnImport();
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	 String importType =Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 12);
	 actual[30]=req.chooseImportType(importType);
	 actual[31]=ip.clickOnNextForMap();
	 actual[32]=ip.clickOnNextForImport();
	
	String jobname=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 5, 0);
	String mapName=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 5, 1);
	String path=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 5, 2);
	actual[33]=ip.importTestCaseRequirment(jobname, mapName, path);
	actual[34]=ip.runJob();
	bp.waitForElement();
	actual[35]=ip.ClickOKonStatusReport();
	actual[36]=ip.closeImportPage();
	
	
	 String ImportFolderName=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 10);
	
		
	 String fileName=Excel_Lib.getData(INPUT_PATH_2,"Import_Job", 5, 3);
	 actual[37]= ip.validateImportRequirment(fileName, ImportFolderName);
	 
	 actual[38]=tr.copyNode();
	 actual[39]=req.minimizeFolderNode(ImportFolderName);
	 actual[40]=tr.doubleClickOnRelease(releaseName);
	 actual[41]=tr.pasteNode();
	 
	
	 actual[42]=req.minimizeFolderNode(releaseName);
	 
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@Then("^imported node should be copied to the local release$")
public void imported_node_should_be_copied_to_the_local_release() throws Throwable {
	
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
//	 String[] node1=new String[1];
//	 node1[0]=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 3, 11);
//	
	 String fileName=Excel_Lib.getData(INPUT_PATH_2,"Import_Job", 5, 3);
	 actual[43]=ip.validateImportRequirment(fileName, releaseName);
	// actual[21]=tr.navigateToNode(releaseName, node1);
	 actual[44]= req.minimizeFolderNode(releaseName);
	 
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}

@When("^user run another job and move the imported node to current release$")
public void user_run_another_job_and_move_the_imported_node_to_current_release() throws Throwable {
	try
	{
		actual[0]=req.clickOnImport();
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	 String importType =Excel_Lib.getData(INPUT_PATH_2,"Create_Map",1, 12);
	 actual[45]=req.chooseImportType(importType);
	 actual[46]=ip.clickOnNextForMap();
	 actual[47]=ip.clickOnNextForImport();
	
	String jobname=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 6, 0);
	String mapName=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 6, 1);
	String path=Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 6, 2);
	actual[48]=ip.importTestCaseRequirment(jobname, mapName, path);
	actual[49]=ip.runJob();
	bp.waitForElement();
	actual[50]=ip.ClickOKonStatusReport();
	actual[51]=ip.closeImportPage();
	
	 String ImportFolderName=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 1, 10);
		
	 String fileName=Excel_Lib.getData(INPUT_PATH_2,"Import_Job", 6, 3);
	 actual[0]=ip.validateImportRequirment(fileName, ImportFolderName);

	 
	 actual[52]=tr.moveNode();
	 actual[53]=req.minimizeFolderNode(ImportFolderName);
	 actual[54]=tr.doubleClickOnRelease(releaseName);
	 actual[55]=tr.pasteNode();
	 actual[56]=req.minimizeFolderNode(releaseName);
	 
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
	
}

@Then("^node should be moved to the current release$")
public void node_should_be_moved_to_the_current_release() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");

	
	 String fileName=Excel_Lib.getData(INPUT_PATH_2,"Create_Map", 6, 3);
	 actual[57]=ip.validateImportRequirment(fileName, releaseName);
	 
	 
	 actual[58]=req.minimizeFolderNode(releaseName);
	 
	 for (int k = 0; k <= actual.length - 1; k++) {
			soft.assertEquals(actual[k], true);
			System.out.println(actual[k]);
		}
		soft.assertAll();
	   
	 
	}
	 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
}


}
