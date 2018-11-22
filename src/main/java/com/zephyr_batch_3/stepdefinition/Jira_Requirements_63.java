package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Jira_Requirements_63 extends LaunchBrowser {
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String screen="Jira_Requirements_63";
	LaunchBrowser lb=new LaunchBrowser();
	
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();

@Given("^user is in the page of requirements$")
public void user_is_in_the_page_of_requirements() throws Throwable {
    try
    {
    	bp=new BasePage();
    	pp=new ProjectPage(driver);
    	rp=new ReleasePage(driver);
    	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
    	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
    	actual[0]=pp.selectProject(projectName);
    	actual[1]=pp.selectRelease(releaseName);
    	bp.waitForElement(); 
		actual[2]=rp.clickOnRequirements();
		bp.waitForElement();
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    	lb.getScreenShot(screen);
    	driver.close();
    	Relogin_TPE rl=new Relogin_TPE();
    	rl.reLogin();
    	throw e;
    	
    }
}

@When("^user chooses import type as Jira$")
public void user_chooses_import_type_as_Jira() throws Throwable {
	try
    {
		req=new RequirementsPage(driver);
		actual[3]=req.clickOnImport();
		bp.waitForElement();
		String importType=Excel_Lib.getData(INPUT_PATH_7, "Import",1 , 5 );
		actual[4]=req.chooseImportType(importType);
        bp.waitForElement();
    }
    catch(Exception e)
	{
		e.printStackTrace();
		lb.getScreenShot(screen);
    	driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^user perform jql operation$")
public void user_perform_jql_operation() throws Throwable {
	try
	{
	String selectQuerry=Excel_Lib.getData(INPUT_PATH_7, "Import",1,8);
	String enterQuerry=Excel_Lib.getData(INPUT_PATH_7, "Import",1 ,6);
	actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
    String accessType=Excel_Lib.getData(INPUT_PATH_7, "Import",7 ,7);
    bp.waitForElement();
    String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Releases",2 ,6);
    actual[6]=req.selectAccessTypeAndFolderName(accessType, folderName);
    req.clickjiraSearchButton.click(); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb.getScreenShot(screen);
    	driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^import jira requirements$")
public void import_jira_requirements() throws Throwable {
	try
	{
		bp.waitForElement();
		req=new RequirementsPage(driver);
		String[] testCaseNo=new String[3];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "TestCases",2 ,4 ));
	    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "TestCases",3 ,4 ));
	    actual[7]=req.selectMultipleTestCaseFromGrid(testCaseNo);
	    bp.waitForElement();
		req.clickOnImportSelected.click();
		bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb.getScreenShot(screen);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
	
    
}

@Then("^Should be able to copy and paste imported Jira requirement folder to local tree$")
public void should_be_able_to_copy_and_paste_imported_Jira_requirement_folder_to_local_tree() throws Throwable {
	try
    {
	  
	    tr=new TestRepositoryPage(driver);
	    String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Releases",2,6);
	    String importedName=Excel_Lib.getData(INPUT_PATH_7,"Releases",1,2);
	    bp.waitForElement();
    	actual[8]=tr.doubleClickOnRelease(importedName);
    	String[] fields=new String[1];
	 	fields[0]=fileName;
	 	bp.waitForElement();
	 	actual[9]=tr.navigateToNode(importedName, fields);
	 	bp.waitForElement();
   		actual[10]=tr.copyNode();
   		bp.waitForElement();
		String releaseName1=Excel_Lib.getData(INPUT_PATH_7,"Releases",1,0);
	 	actual[11]= tr.clickOnRelease(releaseName1);
	 	bp.waitForElement();
	 	actual[12]=tr.pasteNode();
	 	bp.waitForElement();
	 	
	 	bp.waitForElement();
	 	pp.clickOnLogout();
	 	for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println(actual[k]);
			soft.assertEquals(actual[k],true);
		}
       soft.assertAll();
	 	
    }
    catch(Exception e)
	{
		lb=new LaunchBrowser();
		lb.getScreenShot(screen);
    	e.printStackTrace();
    	driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
   	 
	}
   
}

}
