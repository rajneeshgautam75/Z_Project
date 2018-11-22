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
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_26 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage dp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	public String  defectValue2;
	boolean[] actual=new boolean[24];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_26";
	
	
	@Given("^User is in DefectTracking Page$")
	public void user_is_in_DefectTracking_Page() throws Throwable {
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

	@When("^User serach the defect and attach any format file and save it then view and download the attachment$")
	public void user_serach_the_defect_and_attach_any_format_file_and_save_it_then_view_and_download_the_attachment() throws Throwable {
		 try
		    {
			dt=new DefectTracking(driver);
			ep=new ExecutionPage(driver);
			ejp=new ExternalJiraPage(driver);
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
		    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
		    int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);	 	
		    String[] filePath=new String[1];
		    filePath[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 36);
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
		    actual[7]=dt.downloadDefectAttachment(fileName);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.switchWindowTab(switch_1);
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


	@Then("^Should be able to Download attachment$")
	public void should_be_able_to_Download_attachment() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
   	    int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 
   	    actual[9]=dt.validateDownloadAttachment(fileName);
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
	@When("^User click on TestExecution and execute testcases with any status and create defect$")
	public void user_click_on_TestExecution_and_execute_testcases_with_any_status_and_create_defect() throws Throwable {
		try
		   {
	       tr=new TestRepositoryPage(driver);
	       ep=new ExecutionPage(driver); 
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[10]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[11]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[12]=ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[13]=ep.changeMultiSelectedStatus(status);
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


	@When("^User search thd defect and create subtask and attach any format file and save it and view it then download the attachment$")
	public void user_search_thd_defect_and_create_subtask_and_attach_any_format_file_and_save_it_and_view_it_then_download_the_attachment() throws Throwable {
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
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 6, 26);
		   actual[14]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[15]=ep.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[16]=ep.clickOnSubTask();
		   bp.waitForElement();
		   actual[17]=dt.createDefectSubtask(issuetype_1);
		   bp.waitForElement();
		   actual[18]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[19]=dt.saveDefect();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[20]=ep.uploadAttachement(filePath);	
		   bp.waitForElement();
		   bp.waitForElement();
	       bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[21]=dt.downloadDefectAttachment(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
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

	@Then("^should be able to download attachment$")
	public void should_be_able_to_download_attachment() throws Throwable {
		try
	    {
   	    String fileName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 41);
   	    int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0); 
   	    actual[22]=dt.validateDownloadAttachment(fileName);
	    driver.close();
	    bp.waitForElement();
	    bp.switchWindowTab(switch_0);
	    bp.waitForElement();
	    dt.closeDownload.click();
	    bp.waitForElement();
	    dt.updateCancelButton.click();
	    bp.waitForElement();
	    actual[23]=ep.clickOnCancelDefectWindow();
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
