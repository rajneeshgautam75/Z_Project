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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_45 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[6];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_45";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User Launches Defect Tracking App$")
	public void user_Launches_Defect_Tracking_App() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			dt=new DefectTracking(driver);
			bp=new BasePage();
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
		    actual[2]=pp.clickOnDefectTracking();
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

	@When("^user Searches defect by any attribute Project,Issue type,Priority,Status,Assignee,ID,Advance_JQL$")
	public void user_Searches_defect_by_any_attribute_Project_Issue_type_Priority_Status_Assignee_ID_Advance_JQL() throws Throwable {
	   try
	   {
		   String project=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		   String status=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String filedBy=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String version=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String priority=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String assignee=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   bp.waitForElement();
		   actual[3]=dt.defectSearch(project, issueType, status, filedBy, version, priority, assignee);
		   
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

	@When("^After search result,Select a defect,sub-task in  grid -> Update the defect/subtask with comment$")
	public void after_search_result_Select_a_defect_sub_task_in_grid_Update_the_defect_subtask_with_comment() throws Throwable {
	   try
	   {
		  int defectNo[]=new int[1];
		  defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		  bp.waitForElement();
		  actual[4]=dt.selectSingleOrMultipleDefects(defectNo);  
		  
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

	@Then("^Should be able to Update the Defect,Subtask with comment$")
	public void should_be_able_to_Update_the_Defect_Subtask_with_comment() throws Throwable {
		try
		{
			  String summary=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String component=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String priority=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String version=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String fixversion=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String comment=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 5);
			  String assignedTo=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String environment=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  String resolution=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			  bp.waitForElement();
			  bp.waitForElement();
			  actual[5]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);	
			  bp.waitForElement();
			  
			  for(int k=0;k<=actual.length-1;k++)
				{
					
					soft.assertEquals(actual[k], true);
					System.out.println(actual[k]);
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
