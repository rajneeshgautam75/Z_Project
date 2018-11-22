package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_282 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	boolean[] actual=new boolean[20];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_282";
	
	@Given("^user Is in DefectTracking Page$")
	public void user_Is_in_DefectTracking_Page() throws Throwable {
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

	@When("^user create defect with issue type Improvement$")
	public void user_create_defect_with_issue_type_Improvement() throws Throwable {
		try
		   {
		   dt=new DefectTracking(driver); 	
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[3]=dt.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[4]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	       bp.waitForElement();
	       actual[5]=dt.saveDefect();
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

	@Then("^should be able to create defect with issue type Improvement$")
	public void should_be_able_to_create_defect_with_issue_type_Improvement() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,1);	
	       actual[6]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[7]=dt.updateDefect();
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

	@When("^user create defect with issue type Improvement in testexecution$")
	public void user_create_defect_with_issue_type_Improvement_in_testexecution() throws Throwable {
		try
	    {	
		ep=new ExecutionPage(driver);
	    tr=new TestRepositoryPage(driver);
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
	    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,1);
	    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		String field_1[]=new String[1];
	    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
	    String cyclename[]=new String[1];
	    cyclename[0]=cycle;
	    String phase1[]=new String[1];
	    phase1[0]=name;
	    String[] str=new String[2];
	    str[0]=cycle;
	    str[1]=phase;
	    actual[8]=rp.clickOnTestExecution();
	    bp.waitForElement();
	    actual[9]=ep.verifyExecutionPage();
	    bp.waitForElement();
	    actual[10]=tr.navigateToNode(releaseName, str);
	    bp.waitForElement();
	    actual[11]=ep.selectAndDeselectAllTestCase();
	    bp.waitForElement();
	    actual[12]=ep.changeMultiSelectedStatus(status);
	    bp.waitForElement();	
	    actual[13]=ep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    actual[14]=ep.createDefect(project, issuetype);
  	    bp.waitForElement();
  	    actual[15]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	    bp.waitForElement();
	    actual[16]=dt.saveDefect();
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

	@Then("^should be abble to create defect with issue type Improvement in testexecution$")
	public void should_be_abble_to_create_defect_with_issue_type_Improvement_in_testexecution() throws Throwable {
		 try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,1);	
	       actual[17]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[18]=dt.updateDefect();
		   bp.waitForElement();
		   actual[19]=ep.clickOnCancelDefectWindow();
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
