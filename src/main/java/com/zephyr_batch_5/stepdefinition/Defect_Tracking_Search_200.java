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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_200 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Search_200";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^Testexecution app is launched by user$")
	public void testexecution_app_is_launched_by_user() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
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

	@When("^user Attempts to search defects using invalid JQL$")
	public void user_Attempts_to_search_defects_using_invalid_JQL() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 13, 2);
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

	@Then("^should get a proper message$")
	public void should_get_a_proper_message() throws Throwable {
		try
		{
			String filterValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 14, 2);
			//System.out.println("Excel-"+filterValue);
			actual[8]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^user attempts to search defects using invalid JQL in defect tracking page$")
	public void user_attempts_to_search_defects_using_invalid_JQL_in_defect_tracking_page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 13, 2);
			actual[10]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[11]=dt.advancedSearch(jql, value);
		    dt.Search.click();
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
		@Then("^should get the proper message$")
		public void should_get_the_proper_message() throws Throwable {
			try
			{
				String filterValue=Excel_Lib.getData(INPUT_PATH_7, "Search", 14, 2);
				actual[12]=dt.viewDefectIssueMsg(filterValue);
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
