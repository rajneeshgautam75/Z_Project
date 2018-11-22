package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.Alert;
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
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_25 extends LaunchBrowser{
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
	ExportPage ex;
	RequirementsPage req;
	DefectTracking dt;
	CreateTestCasePage ct;
	ExternalJiraPage ejp;
    boolean[] actual=new boolean[73];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_25";

	@Given("^User is in defecttracking page$")
	public void user_is_in_defecttracking_page() throws Throwable {
		try
	       {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   bp.waitForElement();
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

	@When("^User search the defect and attach the text format and try to view the attachment$")
	public void user_search_the_defect_and_attach_the_text_format_and_try_to_view_the_attachment() throws Throwable {
	     try
		   {
		   ep=new ExecutionPage(driver);
		   ejp=new ExternalJiraPage(driver);
		   dt=new DefectTracking(driver);
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 41);
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 36);
		   actual[3]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[4]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, sprint, assignee, labels, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[5]=dt.saveDefect();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[6]=ep.uploadAttachement(filePath);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[7]=ep.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[8]=ejp.loginToExternalJira(username, password);
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

	@Then("^Should be able to view the attachment of defect in text format$")
	public void should_be_able_to_view_the_attachment_of_defect_in_text_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 41);
   	    actual[9]=dt.validateDownloadAttachment(fileName);
	    bp.waitForElement();
	    driver.navigate().back();
	    bp.waitForElement();
	    driver.navigate().back();
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

	@When("^User search the defect and attach the excel format and try to view the attachment$")
	public void user_search_the_defect_and_attach_the_excel_format_and_try_to_view_the_attachment() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
//		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 41);
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 36);
		   actual[10]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[11]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[12]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, sprint, assignee, labels, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[13]=dt.saveDefect();
		   bp.waitForElement();
		   actual[14]=ep.uploadAttachement(filePath);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[15]=dt.downloadDefectAttachment(fileName);
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


	@Then("^Should be able to view the attachment of defect in excel format$")
	public void should_be_able_to_view_the_attachment_of_defect_in_excel_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 41); 
   	    actual[16]=dt.validateDownloadAttachment(fileName);
   	    bp.waitForElement();
   	    actual[17]=dt.updateDefect();
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

	@When("^User search the defect and attach the word format and try to view the attachment$")
	public void user_search_the_defect_and_attach_the_word_format_and_try_to_view_the_attachment() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
//		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 41);
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 36);
		   actual[18]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[19]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, sprint, assignee, labels, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[20]=dt.saveDefect();
		   bp.waitForElement();
		   actual[21]=ep.uploadAttachement(filePath);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[22]=dt.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
		//   actual[22]=ejp.loginToExternalJira(username, password);
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


	@Then("^Should be able to view the attachment of defect in word format$")
	public void should_be_able_to_view_the_attachment_of_defect_in_word_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 41);
   	    actual[23]=dt.validateDownloadAttachment(fileName);
        bp.waitForElement();
	    driver.navigate().back();
//	    bp.waitForElement();
//	    Alert alert = driver.switchTo().alert();
//	    alert.accept();
	    actual[24]=pp.clickOnDefectTracking();
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

	@When("^User search the defect and attach the image format and try to view the attachment$")
	public void user_search_the_defect_and_attach_the_image_format_and_try_to_view_the_attachment() throws Throwable {
		 try
		    {
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
//		    String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
		    int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);	 	
		    String[] filePath=new String[1];
		    filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 36);
		    actual[25]=dt.createDefect(project, issuetype);
		    bp.waitForElement();
		    actual[26]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, sprint, assignee, labels, env, epicLink, affectsVersion, linkedIssue);
		    bp.waitForElement();
		    actual[27]=dt.saveDefect();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[28]=ep.uploadAttachement(filePath);	
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[29]=dt.downloadDefectAttachment(fileName);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.switchWindowTab(switch_1);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
//		    actual[29]=ejp.loginToExternalJira(username, password);
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

	@Then("^Should be able to view the attachment of defect in image format$")
	public void should_be_able_to_view_the_attachment_of_defect_in_image_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
   	    int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 
   	    actual[30]=dt.validateDownloadAttachment(fileName);
	    bp.waitForElement();
	    driver.close();
	    bp.waitForElement();
	    bp.switchWindowTab(switch_0);
	    bp.waitForElement();
	    dt.closeDownload.click();
	    bp.waitForElement();
	    dt.closeUpdateDownload.click();
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
	@When("^User click on testexecution and execute testcases in any status and create defect$")
	public void user_click_on_testexecution_and_execute_testcases_in_any_status_and_create_defect() throws Throwable {
         try
		   {
           tr=new TestRepositoryPage(driver);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 26);
		   String cyclename[]=new String[1];
		   cyclename[0]=cycle;
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[31]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[32]=ep.verifyExecutionPage();
		   bp.waitForElement();
		   actual[33]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[34]=ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[35]=ep.changeMultiSelectedStatus(status);
		   bp.waitForElement();		  
		   actual[36]=ep.clickOnDefectButton(testcase);
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

	@When("^User create subtask and attach the text format and try to view the attachment$")
	public void user_create_subtask_and_attach_the_text_format_and_try_to_view_the_attachment() throws Throwable {
	 	try
		   {
	       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
//		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 41);
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 36);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
  	       actual[37]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[38]=ep.clickOnSubtask();
		   bp.waitForElement();
		   actual[39]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[40]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[41]=dt.saveDefect();
		   bp.waitForElement();
		   actual[42]=ep.uploadAttachement(filePath);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[43]=dt.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
//		   actual[44]=ejp.loginToExternalJira(username, password);
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

	@Then("^Should be able to view the attachment of subtask in text format$")
	public void should_be_able_to_view_the_attachment_of_subtask_in_text_format() throws Throwable {
	 	try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 41);
   	    actual[44]=dt.validateDownloadAttachment(fileName);
        bp.waitForElement();
        driver.navigate().back();
	    bp.waitForElement();
        driver.navigate().back();
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

	@When("^User create subtask and attach the excel format and try to view the attachment$")
	public void user_create_subtask_and_attach_the_excel_format_and_try_to_view_the_attachment() throws Throwable {
		try
		   {
	       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
//		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 41);
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 36);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 26);
		   actual[45]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[46]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[47]=ep.clickOnSubtask();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[48]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[49]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[50]=dt.saveDefect();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[51]=ep.uploadAttachement(filePath);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[52]=dt.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
//		   actual[54]=ejp.loginToExternalJira(username, password);
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

	@Then("^Should be able to view the attachment of subtask in excel format$")
	public void should_be_able_to_view_the_attachment_of_subtask_in_excel_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 41);
   	    actual[53]=dt.validateDownloadAttachment(fileName);
	    bp.waitForElement();
	    driver.navigate().back();
//	    bp.waitForElement();
//	    Alert alert = driver.switchTo().alert();
//	    alert.accept();
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

	@When("^User create subtask and attach the word format and try to view the attachment$")
	public void user_create_subtask_and_attach_the_word_format_and_try_to_view_the_attachment() throws Throwable {
		try
		   {
	       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
//		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 41);
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 36);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 26);
		   actual[54]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[55]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[56]=ep.clickOnSubTask();
		   bp.waitForElement();		 
		   bp.waitForElement();		 
		   actual[57]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[58]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[59]=dt.saveDefect();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[60]=ep.uploadAttachement(filePath);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[61]=dt.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
//		   actual[64]=ejp.loginToExternalJira(username, password);
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

	@Then("^Should be able to view the attachment of subtask in word format$")
	public void should_be_able_to_view_the_attachment_of_subtask_in_word_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 41);
   	    actual[62]=dt.validateDownloadAttachment(fileName);
   	    bp.waitForElement();
  	    driver.navigate().back();
        bp.waitForElement();
//	    Alert alert = driver.switchTo().alert();
//	    alert.accept();
//	    driver.navigate().refresh();
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

	@When("^User create subtask and attach the image format and try to view the attachment$")
	public void user_create_subtask_and_attach_the_image_format_and_try_to_view_the_attachment() throws Throwable {
		try
		   {
	       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String summary_1 =Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
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
		   String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1); 
		   String[] filePath=new String[1];
		   filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 36);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 26);
		   actual[63]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[64]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[65]=ep.clickOnSubTask();
		   bp.waitForElement();
		   actual[66]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[67]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[68]=dt.saveDefect();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[69]=ep.uploadAttachement(filePath);	
		   bp.waitForElement();
		   bp.waitForElement();
	       bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[70]=dt.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
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

	@Then("^Should be able to view the attachment of subtask in image format$")
	public void should_be_able_to_view_the_attachment_of_subtask_in_image_format() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
   	    int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0); 
   	    actual[71]=dt.validateDownloadAttachment(fileName);
	    driver.close();
	    bp.waitForElement();
	    bp.switchWindowTab(switch_0);
	    bp.waitForElement();
	    dt.closeDownload.click();
	    bp.waitForElement();
	    dt.updateCancelButton.click();
	    bp.waitForElement();
	    actual[72]=ep.clickOnCancelDefectWindow();
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
