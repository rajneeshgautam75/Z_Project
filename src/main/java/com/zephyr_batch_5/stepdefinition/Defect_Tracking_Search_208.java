package com.zephyr_batch_5.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_208 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_208";
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^user is in a Page of execution$")
	public void user_is_in_a_Page_of_execution() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			req=new RequirementsPage(driver);
			dt=new DefectTracking(driver);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
			actual[2]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[3]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[4]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[5]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[6]=ep.clickOnDefectButton(testcase1);
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

	@When("^user search the defects using jql by Issue Type Epic$")
	public void user_search_the_defects_using_jql_by_Issue_Type_Epic() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 2);
		    actual[7]=ep.defectSearch(jql, value);
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

	@Then("^should able to search defects$")
	public void should_able_to_search_defects() throws Throwable {
		try
		{
			String defectType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String defectValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 3, 6);
			actual[8]=ep.validateSearchedDefect(defectType, defectValue);
			bp.waitForElement();
			actual[9]=ep.closeLinkedDefectWindow();
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

	@When("^user Searches defects using JQL by Issue Type Epic in Defect Tracking$")
	public void user_Searches_defects_using_JQL_by_Issue_Type_Epic_in_Defect_Tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 2);
			actual[10]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[11]=dt.advancedSearch(jql, value);
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

	@Then("^In Defect Tracking,should be able to search defects$")
	public void in_Defect_Tracking_should_be_able_to_search_defects() throws Throwable {
		try
		{
		String defectType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
		String defectValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 3, 6);
		bp.waitForElement();
		actual[12]=dt.validateSearchedDefect(defectType, defectValue);
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
	@When("^user search the defects using JQL by Issue Type Epic In requirements$")
	public void user_search_the_defects_using_JQL_by_Issue_Type_Epic_In_requirements() throws Throwable {
		try
		{
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Search",1,4);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 2);
			String importType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 3);
			String accessType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Search", 3, 5);
			actual[13]=rp.clickOnRequirements();
			bp.waitForElement();
			actual[14]=tr.clickOnRelease(release);
			actual[15]=tr.navigateToNode(release, navigation);
			bp.waitForElement();
			actual[16]=req.clickOnImport();
			bp.waitForElement();
			actual[17]=req.chooseImportType(importType);
			bp.waitForElement();
			bp.waitForElement();
			actual[18]=req.selectQuerry(jql, value);
			bp.waitForElement();
			actual[19]=req.selectAccessTypeAndFolderName(accessType, folderName);
			bp.waitForElement();
			actual[20]=req.searchJiraRequirements();
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

	@Then("^should search the defects in requirements$")
	public void should_search_the_defects_in_requirements() throws Throwable {
		try
		{
			String imported=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 0);
			String imported_Navigation[]=new String[2];
			imported_Navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Search", 3, 5);
			imported_Navigation[1]=Excel_Lib.getData(INPUT_PATH_7, "Search", 3, 6);
			String testCaseNo[]=new String[2];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Search", 0, 0));
			testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Search", 1, 0));
			bp.waitForElement();
			actual[21]=req.verifySearchRequirementCount();
			bp.waitForElement();
			actual[22]=req.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			req.clickOnImportSelected.click();
			bp.waitForElement();
			actual[23]=tr.clickOnRelease(imported);
			bp.waitForElement();
			actual[24]=tr.navigateToNode(imported, imported_Navigation);
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
