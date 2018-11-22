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

public class Defect_Tracking_28 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage dp;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
    boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_28";
	
	
	@Given("^user is in TestRepository page$")
	public void user_is_in_TestRepository_page() throws Throwable {
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
	

	@When("^user click on TextExecution and create testcases and execute with any status and create defect$")
	public void user_click_on_TextExecution_and_create_testcases_and_execute_with_any_status_and_create_defect() throws Throwable {
		try
		   {
	       tr=new TestRepositoryPage(driver);
	       rp=new ReleasePage(driver);
	       ep=new ExecutionPage(driver); 
	       dt=new DefectTracking(driver);
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	       String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	       String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
	       int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 8, 26);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String desc1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		   String cyclename[]=new String[1];
		   cyclename[0]=cycle;
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[3]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[4]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[5]=ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[6]=ep.changeMultiSelectedStatus(status);
		   bp.waitForElement();	
		   actual[7]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[8]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[9]=dt.fileNewDefect(summary_1, components, descType, desc1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[10]=dt.saveAndUpdateDefect();
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


//	@When("^user try to link the created defect with testcase and view the details of defect in currently inked defect grid$")
//	public void user_try_to_link_the_created_defect_with_testcase_and_view_the_details_of_defect_in_currently_inked_defect_grid() throws Throwable {
//		try
//	    {
//		ep=new ExecutionPage(driver);
//	    ep.linkDefect();
//	    }
//	  catch(Exception e)
//	    {
//	    lb=new LaunchBrowser();	 
//	    lb.getScreenShot(fileName);
//		e.printStackTrace();
//		driver.close();
//	    Relogin_TPE rl=new Relogin_TPE();
//	    rl.reLogin();
//	    throw e; 
//	    }
//	} 


	@Then("^should not be able to View the details of a defect$")
	public void should_not_be_able_to_View_the_details_of_a_defect() throws Throwable {
		try
	    {
		ep=new ExecutionPage(driver); 
	    actual[11]=ep.validateCurrentlylinkedDefect();
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

	@When("^user try to create subtask and link with testcase and view the details of subtask in currently linked defect grid$")
	public void user_try_to_create_subtask_and_link_with_testcase_and_view_the_details_of_subtask_in_currently_linked_defect_grid() throws Throwable {
		try
	    {
		String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);	
	    String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
        String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
   	    String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
   	    String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
    	String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
	    String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
	    String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
	    String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
	    String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
	    String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
	    String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
	    String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
	    String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
	    String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
	    actual[12]=ep.defectSearch(selectSearch, defectID);
	    bp.waitForElement();
	    actual[13]=ep.clickOnSubtask();
	    bp.waitForElement();
	    actual[14]=dt.createDefectSubtask(issuetype_1);
	    bp.waitForElement();
	    actual[15]=dt.fileNewDefect(summary_1, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		bp.waitForElement();
		actual[16]=dt.saveAndUpdateDefect();
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
	
	@Then("^sholud not be able to view the details of defect$")
	public void sholud_not_be_able_to_view_the_details_of_defect() throws Throwable {
		try
	    {
		ep=new ExecutionPage(driver); 
	    actual[17]=ep.validateCurrentlylinkedDefect();
	    bp.waitForElement();
	    ep.cancelDefect.click();
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

