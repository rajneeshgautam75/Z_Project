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

public class Defect_Tracking_Search_215 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[22];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_215";
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^TESTExecution page is launched by User$")
	public void testexecution_page_is_launched_by_User() throws Throwable {
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

	@When("^Search defects by issue type ID using JQL$")
	public void search_defects_by_issue_type_ID_using_JQL() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 17, 2);
			bp.waitForElement();
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

	@Then("^should be able to search defect by ID$")
	public void should_be_able_to_search_defect_by_ID() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[8]=ep.verifySearchedDefectCount();
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

	@When("^user searches defects by issuetype ID using Jql in Defect Tracking$")
	public void user_searches_defects_by_issuetype_ID_using_Jql_in_Defect_Tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 17, 2);
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

	@Then("^should be Able to search Defects by issuetype ID in defect tracking$")
	public void should_be_Able_to_search_Defects_by_issuetype_ID_in_defect_tracking() throws Throwable {
		try
		{
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 17, 3);
			bp.waitForElement();
			actual[12]=dt.validateDefect(value);
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

	@When("^In requirements,user searches the defects by issue Type ID using JQL$")
	public void in_requirements_user_searches_the_defects_by_issue_Type_ID_using_JQL() throws Throwable {
		try
		{
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Search",1,4);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 17, 2);
			String importType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 3);
			actual[13]=rp.clickOnRequirements();
			bp.waitForElement();
			actual[14]=tr.clickOnRelease(release);
			bp.waitForElement();
			actual[15]=tr.navigateToNode(release, navigation);
			bp.waitForElement();
			actual[16]=req.clickOnImport();
			bp.waitForElement();
			actual[17]=req.chooseImportType(importType);
			bp.waitForElement();
			actual[18]=req.selectQuerry(jql, value);
			bp.waitForElement();
			bp.waitForElement();
			actual[19]=req.searchJiraRequirements();
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

	@Then("^should search the defects by issue Type ID using JQL$")
	public void should_search_the_defects_by_issue_Type_ID_using_JQL() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[20]=req.verifySearchRequirementCount();
			bp.waitForElement();
			bp.waitForElement();
			actual[21]=req.clickOnCancelJiraSearchWindow();
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
