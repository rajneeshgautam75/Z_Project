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

public class Defect_Tracking_38 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[134];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_38";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User Launches Defect Tracking app and clicks on a create defect$")
	public void user_Launches_Defect_Tracking_app_and_clicks_on_a_create_defect() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			dt=new DefectTracking(driver);
			bp=new BasePage();
			ep=new ExecutionPage(driver);
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
		    actual[2]=pp.clickOnDefectTracking();
		    bp.waitForElement();
		    actual[3]=dt.createDefect(projectType, issueType);
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

	@When("^user Creates a defect or subtask with custom field of type Date Picker as current date$")
	public void user_Creates_a_defect_or_subtask_with_custom_field_of_type_Date_Picker_as_current_date() throws Throwable {
	   try
	   {
		    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			bp.waitForElement();
			actual[4]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	        bp.waitForElement();
	        actual[5]=dt.customDatePicker(syear, smonth, sday);
	        bp.waitForElement();
	        actual[6]=dt.saveDefect();
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

	@Then("^should be able to create a defect with custom field of type Date Picker as current date$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Date_Picker_as_current_date() throws Throwable {
		try
		{
		String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
		bp.waitForElement();
		actual[7]=dt.validateDefect(projectType, issueType);
		bp.waitForElement();
		actual[8]=dt.updateDefect();
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

	@When("^user creates a defect with custom field of type Date Picker as date in the past$")
	public void user_creates_a_defect_with_custom_field_of_type_Date_Picker_as_date_in_the_past() throws Throwable {
	   try
	   {
		    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 12, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 3, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 3, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 5));
	        pp.clickOnDefectTracking();
			bp.waitForElement();
			actual[9]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[10]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	        bp.waitForElement();
	        actual[11]=dt.customDatePicker(syear, smonth, sday);
	        bp.waitForElement();
			actual[12]=dt.saveDefect();
		   
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

	@Then("^should be able to create a defect with custom field of type Date Picker as date in the past$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Date_Picker_as_date_in_the_past() throws Throwable {
	    try
	    {
	    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[13]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[14]=dt.updateDefect();
			
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

	@When("^user Creates a defect with custom field of type Date Picker as date in the future$")
	public void user_Creates_a_defect_with_custom_field_of_type_Date_Picker_as_date_in_the_future() throws Throwable {
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
			    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
				String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 0);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 13, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 6));
				bp.waitForElement();
				actual[15]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[16]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[17]=dt.customDatePicker(syear, smonth, sday);
		        bp.waitForElement();
				actual[18]=dt.saveDefect();
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

	@Then("^should be able to create defect with custom field of type Date Picker as date in the future$")
	public void should_be_able_to_create_defect_with_custom_field_of_type_Date_Picker_as_date_in_the_future() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
				bp.waitForElement();
				actual[19]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[20]=dt.updateDefect();
	
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

	@When("^user Launches defect tracking,Search defect and Select it and Clicks on Create Sub-task$")
	public void user_Launches_defect_tracking_Search_defect_and_Select_it_and_Clicks_on_Create_Sub_task() throws Throwable {
	    try
	    {  
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 6);
				actual[21]=dt.searchDefect(defectId);
				bp.waitForElement();
				dt.selectAllDefects();
				actual[22]=dt.clickOnCreateSubTask();
		
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

	@When("^Create a subtask with custom field of type Date Picker as current date$")
	public void create_a_subtask_with_custom_field_of_type_Date_Picker_as_current_date() throws Throwable {
		try
		{
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
				String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			    actual[23]=dt.createDefectSubtask(issueType);
			    bp.waitForElement();
			    actual[24]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	            bp.waitForElement();
	            actual[25]=dt.customDatePicker(syear, smonth, sday);
			    bp.waitForElement();
			    actual[26]=dt.saveDefect();
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

	@Then("^should be able to create a subtask with custom field of type Date Picker as current date$")
	public void should_be_able_to_create_a_subtask_with_custom_field_of_type_Date_Picker_as_current_date() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[27]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			dt.updateDefect();
		
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

	@When("^user Creates subtask with custom field of type Date Picker as date in the past$")
	public void user_Creates_subtask_with_custom_field_of_type_Date_Picker_as_date_in_the_past() throws Throwable {
	   try
	   {
		    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 4, 6));
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 6);
			actual[28]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[29]=dt.selectAllDefects();
			actual[30]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[31]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[32]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[33]=dt.customDatePicker(syear, smonth, sday);
			bp.waitForElement();
		    dt.saveDefect();
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

	@Then("^should be able to create a subtask with custom field of type Date Picker as date in the past$")
	public void should_be_able_to_create_a_subtask_with_custom_field_of_type_Date_Picker_as_date_in_the_past() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[34]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[35]=dt.updateDefect();
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

	@When("^user Create a subtask with custom field of type Date Picker as date in the future$")
	public void user_Create_a_subtask_with_custom_field_of_type_Date_Picker_as_date_in_the_future() throws Throwable {
	   try
	   {
		    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 13, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 6));
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 6);
			actual[36]=dt.searchDefect(defectId);
			actual[37]=dt.selectAllDefects();
			actual[38]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[39]=dt.createDefectSubtask(issueType);
			actual[40]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[41]=dt.customDatePicker(syear, smonth, sday);
			bp.waitForElement();
			dt.saveDefect();
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

	@Then("^should be able create subtask with custom field of type Date Picker as date in the future$")
	public void should_be_able_create_subtask_with_custom_field_of_type_Date_Picker_as_date_in_the_future() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[42]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[43]=dt.updateDefect();
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

	@When("^user is in a test repository page,creates a phase P(\\d+) and adds Few TestCases$")
	public void user_is_in_a_test_repository_page_creates_a_phase_P_and_adds_Few_TestCases(int arg1) throws Throwable {
	   try
	   {
		   
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 5);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 6);
			String [] navigation=new String [1];
			navigation[0]=name;
			bp.waitForElement();
			actual[44]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[45]=tr.clickOnRelease(release);
			actual[46]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[47]=tr.navigateToNode(release, navigation);
			for(int i=0;i<=2;i++)
			{
			tr.addTestCase();	
			}
			
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

	@When("^user goes to Test Planning Creates a cycle C(\\d+) and adds Phase P(\\d+) and assign testcases to anyone$")
	public void user_goes_to_Test_Planning_Creates_a_cycle_C_and_adds_Phase_P_and_assign_testcases_to_anyone(int arg1, int arg2) throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 2,5);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[48]=rp.clickOnTestPlanning();
			actual[49]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[50]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[51]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[52]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[53]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[54]=tp.addPhaseToCycle(phase);
		
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

	@Then("^testcases should be assigned to anyone$")
	public void testcases_should_be_assigned_to_anyone() throws Throwable {
		try
		{
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			bp.waitForElement();
			actual[55]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			tp.goBackToCycle();
		    
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

	@When("^user is in a test execution,select testcase and execute with any status$")
	public void user_is_in_a_test_execution_select_testcase_and_execute_with_any_status() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",5,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",2,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			actual[56]=rp.clickOnTestExecution();
			actual[57]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[58]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[59]=ep.changeMultiSelectedStatus(status);
			
			
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

	@When("^user clicks on D button and Clicks on Create defect$")
	public void user_clicks_on_D_button_and_Clicks_on_Create_defect() throws Throwable {
		try
		{
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[60]=ep.clickOnDefectButton(testcase1);
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

	@When("^Creates a defect of custom field type Date Picker as current date$")
	public void creates_a_defect_of_custom_field_type_Date_Picker_as_current_date() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			actual[61]=dt.createDefect(projectType, issueType);
			actual[62]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[63]=bp.waitForElement();
	        actual[64]=dt.customDatePicker(syear, smonth, sday);
	        actual[65]=bp.waitForElement();
			actual[66]=dt.saveDefect();
			
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

	@Then("^should be create defect of custom field DatePicker$")
	public void should_be_create_defect_of_custom_field_DatePicker() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			actual[67]=bp.waitForElement();
			actual[68]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[69]=dt.updateDefect();
			bp.waitForElement();
			actual[70]=ep.clickOnCancelDefectWindow();
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

	@When("^user creates a defect with custom Field type Date Picker as date in past date$")
	public void user_creates_a_defect_with_custom_Field_type_Date_Picker_as_date_in_past_date() throws Throwable {
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
				String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 5));
				String[] cycleName=new String[2];          
				cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",5,4 );
				cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",2,5);
				bp.waitForElement();
				actual[71]=rp.clickOnTestExecution();
				actual[72]=tr.navigateToNode(release, cycleName);
				bp.waitForElement();
				int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
				bp.waitForElement();
				actual[73]=ep.clickOnDefectButton(testcase1);
				bp.waitForElement();
				bp.waitForElement();
				actual[74]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[75]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[76]=dt.customDatePicker(syear, smonth, sday);
		        bp.waitForElement();
				actual[77]=dt.saveDefect();
			   
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

	@Then("^successfully should create a defect$")
	public void successfully_should_create_a_defect() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[78]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[79]=dt.updateDefect();
			bp.waitForElement();
			actual[80]=ep.clickOnCancelDefectWindow();
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

	@When("^create a defect with custom fields of DatePicker as type as in the future date$")
	public void create_a_defect_with_custom_fields_of_DatePicker_as_type_as_in_the_future_date() throws Throwable {
	   
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
				String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 5));
				bp.waitForElement();
				String[] cycleName=new String[2];          
				cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",5,4 );
				cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",2,5);
				bp.waitForElement();
				actual[81]=rp.clickOnTestExecution();
				actual[82]=tr.navigateToNode(release, cycleName);
				bp.waitForElement();
				int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
				bp.waitForElement();
				actual[83]=ep.clickOnDefectButton(testcase1);
				bp.waitForElement();
				actual[84]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[85]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[86]=dt.customDatePicker(syear, smonth, sday);
		        bp.waitForElement();
				actual[87]=dt.saveDefect();
			   
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

	@Then("^successfully should create a defect of Date Picker Type$")
	public void successfully_should_create_a_defect_of_Date_Picker_Type() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[88]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[89]=dt.updateDefect();
			bp.waitForElement();
			actual[90]=ep.clickOnCancelDefectWindow();
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

	@When("^user launches test repository, creates a phase P(\\d+) and adds few TestCases$")
	public void user_launches_test_repository_creates_a_phase_P_and_adds_few_TestCases(int arg1) throws Throwable {
		 try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 3, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 3, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[91]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[92]=tr.clickOnRelease(release);
				actual[93]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[94]=tr.navigateToNode(release, navigation);
				for(int i=0;i<=2;i++)
				{
				tr.addTestCase();	
				}
				
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

	@When("^user is in a TestPlanning, Creates a Cycle C(\\d+) and adds Phase P(\\d+),assigns TestCase to anyone$")
	public void user_is_in_a_TestPlanning_Creates_a_Cycle_C_and_adds_Phase_P_assigns_TestCase_to_anyone(int arg1, int arg2) throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 3,5);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[95]=rp.clickOnTestPlanning();
			actual[96]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[97]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[98]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[99]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[100]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[101]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[102]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			tp.goBackToCycle();
		
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

	@When("^user goes to TestExecution,executes testcase with any status and clicks on D button$")
	public void user_goes_to_TestExecution_executes_testcase_with_any_status_and_clicks_on_D_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",6,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",3,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[103]=rp.clickOnTestExecution();
			actual[104]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[105]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[106]=ep.changeMultiSelectedStatus(status);
			actual[107]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Defect window should be launched$")
	public void defect_window_should_be_launched() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[108]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on Create Defect,and search for a defect and create a subTask$")
	public void user_clicks_on_Create_Defect_and_search_for_a_defect_and_create_a_subTask() throws Throwable {
		try
		{
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 8, 6);
			bp.waitForElement();
			actual[109]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[110]=ep.clickOnSubTask();
			actual[111]=dt.createDefectSubtask(issueType);
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

	@When("^creates subtask Date Picker as current date$")
	public void creates_subtask_Date_Picker_as_current_date() throws Throwable {
		try
		{
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			bp.waitForElement();
			actual[112]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	        bp.waitForElement();
	        actual[113]=dt.customDatePicker(syear, smonth, sday);
	        bp.waitForElement();
	        actual[114]=dt.saveDefect();
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

	@Then("^subtask of Date Picker should be created$")
	public void subtask_of_Date_Picker_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[115]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[116]=dt.updateDefect();	
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

	@When("^creates subtask type Date Picker past date$")
	public void creates_subtask_type_Date_Picker_past_date() throws Throwable {
		try
		{
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 9, 6);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			bp.waitForElement();
			bp.waitForElement();
			actual[117]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[118]=ep.clickOnSubTask();
			actual[119]=dt.createDefectSubtask(issueType);
			actual[120]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	        bp.waitForElement();
	        actual[121]=dt.customDatePicker(syear, smonth, sday);
	        bp.waitForElement();
	        actual[122]=dt.saveDefect();
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

	@Then("^past date should be created and Updated$")
	public void past_date_should_be_created_and_Updated() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[123]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[124]=dt.updateDefect();	
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

	@When("^creates subtask type Date Picker future Date$")
	public void creates_subtask_type_Date_Picker_future_Date() throws Throwable {
		try
		{
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 6);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 13, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 4, 6));
			bp.waitForElement();
			bp.waitForElement();
			actual[125]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[126]=ep.clickOnSubTask();
			actual[127]=dt.createDefectSubtask(issueType);
			actual[128]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	        bp.waitForElement();
	        actual[129]=dt.customDatePicker(syear, smonth, sday);
	        bp.waitForElement();
	        actual[130]=dt.saveDefect();
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

	@Then("^successfully should create a defect of Date Picker as in the future Date$")
	public void successfully_should_create_a_defect_of_Date_Picker_as_in_the_future_Date() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[131]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[132]=dt.updateDefect();
			bp.waitForElement();
			actual[133]=ep.clickOnCancelDefectWindow();
			bp.waitForElement();
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
