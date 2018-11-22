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

public class Defect_Tracking_Search_207 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[42];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Search_207";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^Test repository page launched by User$")
	public void test_repository_page_launched_by_User() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			//rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			req=new RequirementsPage(driver);
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
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

	@When("^user creates a new phase and adds testcase$")
	public void user_creates_a_new_phase_and_adds_testcase() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 3);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			actual[3]=tr.clickOnRelease(release);
			actual[4]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[5]=tr.navigateToNode(release, navigation);
			actual[6]=tr.addTestCase();	
			
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

	@Then("^should be Added Testcase$")
	public void should_be_Added_Testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[7]=tr.verifyPresentTestCase();
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

	@When("^user launch test planning page, creates new cycle and assign phase to cycle$")
	public void user_launch_test_planning_page_creates_new_cycle_and_assign_phase_to_cycle() throws Throwable {
		try
		{
			
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 9, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 11, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16,2);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
			String phase_1[]=new String[1];
	    	phase_1[0]=phase;
			bp.waitForElement();
			actual[8]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[9]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[10]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[11]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[12]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[13]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[14]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[15]=tp.bulkAssignment(bulk_type);
			
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

	@When("^launch Test execution page,Executes Testcase with any status$")
	public void launch_Test_execution_page_Executes_Testcase_with_any_status() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			actual[16]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[17]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[18]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[19]=ep.changeMultiSelectedStatus(status);
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

	@When("^click on D ICON$")
	public void click_on_D_ICON() throws Throwable {
		try
		{
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[20]=ep.clickOnDefectButton(testcase1);
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

	@Then("^window of link defect to be launched$")
	public void window_of_link_defect_to_be_launched() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[21]=ep.validateLinkDefectWindow();
			
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

	@When("^Search defects using JQL by Issue Type Bug in test execution$")
	public void search_defects_using_JQL_by_Issue_Type_Bug_in_test_execution() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 2);
		    actual[22]=ep.defectSearch(jql, value);
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

	@Then("^should be able to Search defects$")
	public void should_be_able_to_Search_defects() throws Throwable {
		try
		{
			String defectType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String defectValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 6);
			bp.waitForElement();
			actual[23]=ep.validateSearchedDefect(defectType, defectValue);
			bp.waitForElement();
			actual[24]=ep.closeLinkedDefectWindow();
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

	@When("^search defect using JQL in defect tracking page$")
	public void search_defect_using_JQL_in_defect_tracking_page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 2);
			actual[25]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[26]=dt.advancedSearch(jql, value);
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

	@Then("^should be able to search defects$")
	public void should_be_able_to_search_defects() throws Throwable {
		try
		{
			String defectType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String defectValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 6);
			bp.waitForElement();
			actual[27]=dt.validateSearchedDefect(defectType, defectValue);
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
	@When("^user searches the defects using JQL by Issue Type Bug in requirements page$")
	public void user_searches_the_defects_using_JQL_by_Issue_Type_Bug_in_requirements_page() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Search",1,4);
	    	String desc=Excel_Lib.getData(INPUT_PATH_7,"Search",1,5);
	    	String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Search",1,4);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 2);
			String importType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 3);
			String accessType=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 6);
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 5);
			actual[28]=rp.clickOnRequirements();
			bp.waitForElement();
			actual[29]=tr.clickOnRelease(release);
			bp.waitForElement();
			actual[30]=req.addNode(name, desc);
			bp.waitForElement();
			actual[31]=tr.navigateToNode(release, navigation);
			bp.waitForElement();
			actual[32]=req.addRequirement();
			bp.waitForElement();
			actual[33]=req.clickOnImport();
			bp.waitForElement();
			actual[34]=req.chooseImportType(importType);
			bp.waitForElement();
			bp.waitForElement();
			actual[35]=req.selectQuerry(jql, value);
			bp.waitForElement();
			actual[36]=req.selectAccessTypeAndFolderName(accessType, folderName);
			bp.waitForElement();
			actual[37]=req.searchJiraRequirements();
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

	@Then("^The defects using JQL by Issue Type Bug should search$")
	public void the_defects_using_JQL_by_Issue_Type_Bug_should_search() throws Throwable {
		try
		{
			String imported=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 0);
			String imported_Navigation[]=new String[2];
			imported_Navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 5);
			imported_Navigation[1]=Excel_Lib.getData(INPUT_PATH_7, "Search", 2, 6);
			String testCaseNo[]=new String[2];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Search", 0, 0));
			testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Search", 1, 0));
			bp.waitForElement();
			actual[38]=req.verifySearchRequirementCount();
			bp.waitForElement();
			actual[39]=req.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			req.clickOnImportSelected.click();
			bp.waitForElement();
			actual[40]=tr.clickOnRelease(imported);
			bp.waitForElement();
			actual[41]=tr.navigateToNode(imported, imported_Navigation);
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
