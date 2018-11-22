package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_202 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Search_202";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^Test execution page is Launched by user$")
	public void test_execution_page_is_Launched_by_user() throws Throwable {
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

	@When("^user Searches defects using valid JQL written in Uppercase$")
	public void user_Searches_defects_using_valid_JQL_written_in_Uppercase() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 11, 2);
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

	@Then("^defects should search in test execution$")
	public void defects_should_search_in_test_execution() throws Throwable {
		try
		{
			String defectType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String defectValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 7, 6);
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

	@When("^In defect tracking,user searches the defects using valid JQL written in Uppercase$")
	public void in_defect_tracking_user_searches_the_defects_using_valid_JQL_written_in_Uppercase() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 11, 2);
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

	@Then("^In defect tracking,defects should search$")
	public void in_defect_tracking_defects_should_search() throws Throwable {
		try
		{
		String defectType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
		String defectValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 7, 6);
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

	@When("^user searches the defects using valid JQL written in Uppercase in requirements$")
	public void user_searches_the_defects_using_valid_JQL_written_in_Uppercase_in_requirements() throws Throwable {
		try
		{
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Search",1,4);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 11, 2);
			String importType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 3);
			String accessType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Search", 11, 5);
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

	@Then("^In requirements,defects should search$")
	public void in_requirements_defects_should_search() throws Throwable {
		try
		{
			String imported=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 0);
			String imported_Navigation[]=new String[2];
			imported_Navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Search", 11, 5);
			imported_Navigation[1]=Excel_Lib.getData(INPUT_PATH_7, "Search", 7, 6);
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
