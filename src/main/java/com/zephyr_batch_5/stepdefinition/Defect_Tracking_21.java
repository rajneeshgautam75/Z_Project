package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_21 extends LaunchBrowser {
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
    boolean[] actual=new boolean[87];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_21";

	@Given("^User In Defect Tracking Page$")
	public void user_In_Defect_Tracking_Page() throws Throwable {
	 	try
	       {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
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
	

	@When("^User try to create a defect with summary of (\\d+) characters$")
	public void user_try_to_create_a_defect_with_summary_of_characters(int arg1) throws Throwable {
		 try
		   {
		   dt=new DefectTracking(driver); 
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 2);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 100);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   actual[3]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[4]=dt.fileNewDefect(summary, components, descType, desc_1, fixVersion, priority, sprint, assignee, labels, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[5]=dt.saveAndCancel();
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

	@Then("^Should not be able to create a Defect$")
	public void should_not_be_able_to_create_a_Defect() throws Throwable {
		 try
		   {
		   actual[6]=dt.validateDefectCreationMsg();
		   bp.waitForElement();
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
	

	@When("^User try to create a defect with Description of (\\d+) characters$")
	public void user_try_to_create_a_defect_with_Description_of_characters(int arg1) throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 5);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   actual[7]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[8]=dt.fileNewDefect(summary_1, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[9]=dt.defectSaveAndUpdateDefect();
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
	

	@Then("^Should not be Able to Create a Defect$")
	public void should_not_be_Able_to_Create_a_Defect() throws Throwable {
		try
		   {	
    	   actual[10]=dt.validateDefectCreationMsg();   
    	   bp.waitForElement();
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
	
	@When("^user Search a defect and select it and try to create a subtask Without Summary and With Description$")
	public void user_Search_a_defect_and_select_it_and_try_to_create_a_subtask_Without_Summary_and_With_Description() throws Throwable {
		try
		   {
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 2);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 31);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[11]=dt.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[12]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   actual[13]=dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[14]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[15]=dt.fileNewDefect(summary, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   dt.createCancelButton.click();
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
	

	@Then("^Should not be able To Create a Subtask Without Summary$")
	public void should_not_be_able_To_Create_a_Subtask_Without_Summary() throws Throwable {
		try
		   {
		   actual[16]=dt.validateDefectCreationMsg();
		   bp.waitForElement();
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
	

	@When("^User Search a defect and select it and Try to create a subtask With Summary and Without Description$")
	public void user_Search_a_defect_and_select_it_and_Try_to_create_a_subtask_With_Summary_and_Without_Description() throws Throwable {
		try
		   {
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 5);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 31);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[17]=dt.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[18]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   actual[19]=dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[20]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[21]=dt.fileNewDefect(summary_1, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   dt.createCancelButton.click();
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

	@Then("^Should not be able to Create a subtask without Description$")
	public void should_not_be_able_to_Create_a_subtask_without_Description() throws Throwable {
		    try
		       {
			   actual[22]=dt.validateDefectCreationMsg();
			   bp.waitForElement();
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
	

	@When("^User Search a defect and Select it and try to create a Subtask with Summary of (\\d+) characters$")
	public void user_Search_a_defect_and_Select_it_and_try_to_create_a_Subtask_with_Summary_of_characters(int arg1) throws Throwable {
		try
		   {
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 2);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 31);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[23]=dt.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[24]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   actual[25]=dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[26]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[27]=dt.fileNewDefect(summary, components, descType,desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[28]=dt.saveAndCancel();
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

	@Then("^should not be able To Create Subtask with Summary of (\\d+) characters$")
	public void should_not_be_able_To_Create_Subtask_with_Summary_of_characters(int arg1) throws Throwable {
		try
		   {
			   actual[29]=dt.validateDefectCreationMsg();
			   bp.waitForElement();
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

	@When("^user Search a defect and Select It and Try to create Subtask with Description of (\\d+) characters$")
	public void user_Search_a_defect_and_Select_It_and_Try_to_create_Subtask_with_Description_of_characters(int arg1) throws Throwable {
		try
		   {
			dt=new DefectTracking(driver); 
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 5);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 31);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[30]=dt.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[31]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   actual[32]=dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[33]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[34]=dt.fileNewDefect(summary_1, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[35]=dt.subtaskSaveAndUpdateDefect();
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
	
	@Then("^Should Not Be Able To Create Subtask with Description of (\\d+) characters$")
	public void should_Not_Be_Able_To_Create_Subtask_with_Description_of_characters(int arg1) throws Throwable {
	     	try
		      {
			   actual[36]=dt.validateDefectCreationMsg();
			   bp.waitForElement();
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
	
	@When("^user click on TCC Create phase and Add testcase then go to Test planning and Create cycle then Add phase and execute testcase with any status$")
	public void user_click_on_TCC_Create_phase_and_Add_testcase_then_go_to_Test_planning_and_Create_cycle_then_Add_phase_and_execute_testcase_with_any_status() throws Throwable {
		try
		   {
	       tr=new TestRepositoryPage(driver);
	       rp=new ReleasePage(driver);
	       tp=new TestPlanningPage(driver);
	       ep=new ExecutionPage(driver); 
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String build=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 20);
		   String environ=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 21);
		   String hide=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 22);
		   String bulk_type_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 23);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		   String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
		   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
		   String sdate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
		   String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
		   String emonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
		   String edate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));  
		   String cyclename[]=new String[1];
		   cyclename[0]=cycle;
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[37]=rp.clickOnTestRep();
		   bp.waitForElement();
		   actual[38]=tr.clickOnRelease(releaseName);
		   bp.waitForElement();
		   actual[39]=tr.addNode(name, desc);
		   bp.waitForElement();
		   actual[40]=tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		   actual[41]=tr.navigateToNode(releaseName,phase1);
		   bp.waitForElement();
		   for(int i=1;i<=9;i++)
		   {
		   actual[42]=tr.addTestCase();
		   }
		   actual[43]=bp.waitForElement();
		   actual[44]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   actual[45]=tp.clickOnAddTestCycleSymbol();
		   bp.waitForElement();
		   actual[46]=tp.CreateCycle(cycle, build, environ, hide);
		   bp.waitForElement();
		   actual[47]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
		   bp.waitForElement();
		   actual[48]=tp.saveTestCycle();
		   bp.waitForElement();
		   actual[49]=tp.navigateToCycle(cyclename);
		   bp.waitForElement();
		   actual[50]=tp.addPhaseToCycle(name);
		   bp.waitForElement();
		   actual[51]=tp.bulkAssignment(bulk_type_1);
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[52]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[53]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[54]=ep.changeMultiSelectedStatus(status);
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

	@When("^user click on Test Execution and Click on D and Try to create defect with summary of (\\d+) chars$")
	public void user_click_on_Test_Execution_and_Click_on_D_and_Try_to_create_defect_with_summary_of_chars(int arg1) throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
    	   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 2);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		   actual[55]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[56]=ep.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[57]=ep.fileNewDefect(summary, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[58]=ep.saveAndCancel();
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

	@Then("^Should not be able To Create Defect with summary of (\\d+) chars$")
	public void should_not_be_able_To_Create_Defect_with_summary_of_chars(int arg1) throws Throwable {
		try
		  {	
	      actual[59]=dt.validateDefectCreationMsg();
	      bp.waitForElement();
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

	@When("^user Try to create a defect With Description of (\\d+) chars$")
	public void user_Try_to_create_a_defect_With_Description_of_chars(int arg1) throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	       String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 5);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);      
		   actual[60]=ep.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[61]=ep.fileNewDefect(summary_1, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[62]=dt.defectSaveAndUpdateDefect();   
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

	@Then("^Should not be able to Create Defect With Description of (\\d+) chars$")
	public void should_not_be_able_to_Create_Defect_With_Description_of_chars(int arg1) throws Throwable {
		try
		   {
		   actual[63]=dt.validateDefectCreationMsg();
		   bp.waitForElement();
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
	@When("^user  Click ON D and Select It and Try to create a subtask Without Summary and With Description$")
	public void user_Click_ON_D_and_Select_It_and_Try_to_create_a_subtask_Without_Summary_and_With_Description() throws Throwable {
         try
		   {
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 2);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[64]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[65]=ep.clickOnSubTask();
		   bp.waitForElement();
		   actual[66]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[67]=dt.fileNewDefect(summary, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   ep.updateCancelButton.click();
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

	@Then("^Should NOT be able to Create SubTask Without Summary$")
	public void should_NOT_be_able_to_Create_SubTask_Without_Summary() throws Throwable {
		try
		   {
		   actual[68]=dt.validateDefectCreationMsg();
		   bp.waitForElement();
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
	

	@When("^user click D AND Search defect AnDselect it and Try to create subtask With Summary and Without Description$")
	public void user_click_D_AND_Search_defect_AnDselect_it_and_Try_to_create_subtask_With_Summary_and_Without_Description() throws Throwable {
		try
		   {
	       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 5);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[69]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[70]=ep.clickOnSubtask();
		   bp.waitForElement();
		   actual[71]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[72]=dt.fileNewDefect(summary_1, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   ep.updateCancelButton.click();
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

	@Then("^ShoUld not Be Able to creatE subTask Without Description$")
	public void should_not_Be_Able_to_creatE_subTask_Without_Description() throws Throwable {
		try
		   {
		   actual[73]=dt.validateDefectCreationMsg();
		   bp.waitForElement();
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
	
	@When("^User Click on D and Search a Defect and select it and try to create Subtask with Summary of (\\d+) chars$")
	public void user_Click_on_D_and_Search_a_Defect_and_select_it_and_try_to_create_Subtask_with_Summary_of_chars(int arg1) throws Throwable {
		   try
		      {
		       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
			   String summary=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 2);
			   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
			   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
			   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1,28);
			   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
			   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
			   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
			   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
			   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
			   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
			   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
			   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
			   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
			   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
			   int[] defectNo=new int[1];
			   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
			   actual[74]=ep.searchDefect(defectID);	
			   bp.waitForElement();
			   actual[75]=ep.clickOnSubTask();
			   bp.waitForElement();
			   actual[76]=dt.createDefectSubtask(issuetype_1);
			   bp.waitForElement();
			   actual[77]=dt.fileNewDefect(summary, components, descType,desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			   bp.waitForElement();
			   actual[78]=ep.saveAndCancel();
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


	@Then("^Should not Be Able to create SubTask$")
	public void should_not_Be_Able_to_create_SubTask() throws Throwable {
		try
		   {
		   actual[79]=dt.validateDefectCreationMsg();
		   bp.waitForElement();
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
	@When("^user click on D and Search defect and select it And Try to create Subtask with Description of (\\d+) chars$")
	public void user_click_on_D_and_Search_defect_and_select_it_And_Try_to_create_Subtask_with_Description_of_chars(int arg1) throws Throwable {
		try
		   {
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1,29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1,5);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[80]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[81]=ep.clickOnSubtask();
		   bp.waitForElement();
		   actual[82]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[83]=dt.fileNewDefect(summary_1, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[84]=dt.saveAndUpdateDefect();
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

	@Then("^should not be Able To Create Subtask$")
	public void should_not_be_Able_To_Create_Subtask() throws Throwable {
		    try
		       {
			   actual[85]=dt.validateDefectCreationMsg();
			   bp.waitForElement();
			   bp.waitForElement();
			   actual[86]=ep.closeLinkedDefectWindow();
			   for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
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


