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

public class Defect_Tracking_287 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	boolean[] actual=new boolean[42];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_287";
	
	@Given("^user is in defectTracking Page$")
	public void user_is_in_defectTracking_Page() throws Throwable {
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

	@When("^User create a defect with customfield of type Date Picker as date in the past in DT$")
	public void user_create_a_defect_with_customfield_of_type_Date_Picker_as_date_in_the_past_in_DT() throws Throwable {
		 try
		   {
		   dt=new DefectTracking(driver); 
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
		   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
		   String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
		   actual[3]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[4]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[5]=dt.customDatePicker(syear, smonth, sday);
		   bp.waitForElement();
		   actual[6]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with date in the past in defecttracking$")
	public void should_be_able_to_create_a_defect_with_date_in_the_past_in_defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[7]=dt.validateDefect(project, issuetype); 
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

	@When("^User create a defect with customfield of type date picker as date in the past in testexecution$")
	public void user_create_a_defect_with_customfield_of_type_date_picker_as_date_in_the_past_in_testexecution() throws Throwable {
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
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
		    String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
		    String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[9]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[10]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[11]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[12]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[13]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[14]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[15]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[16]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[17]=dt.customDatePicker(syear, smonth, sday);
			bp.waitForElement();
		    actual[18]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with date in the past in testexecution$")
	public void should_be_able_to_create_a_defect_with_date_in_the_past_in_testexecution() throws Throwable {
		 try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[19]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[20]=dt.updateDefect();
		   bp.waitForElement();
		   actual[21]=ep.clickOnCancelDefectWindow();
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

	@When("^User create a defect with customfield of type Date Picker as date in the future in DT$")
	public void user_create_a_defect_with_customfield_of_type_Date_Picker_as_date_in_the_future_in_DT() throws Throwable {
		 try
		   {
		   dt=new DefectTracking(driver); 
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
		   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
		   String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));
		   actual[22]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[23]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[24]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[25]=dt.customDatePicker(syear, smonth, sday);
		   bp.waitForElement();
		   actual[26]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with date in the future in defecttracking$")
	public void should_be_able_to_create_a_defect_with_date_in_the_future_in_defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[27]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[28]=dt.updateDefect();
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

	@When("^User create a defect with customfield of type date picker as date in the future in testexecution$")
	public void user_create_a_defect_with_customfield_of_type_date_picker_as_date_in_the_future_in_testexecution() throws Throwable {
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
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
		    String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
		    String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[29]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[30]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[31]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[32]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[33]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[34]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[35]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[36]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[37]=dt.customDatePicker(syear, smonth, sday);
			bp.waitForElement();
		    actual[38]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with date in the future in testexecution$")
	public void should_be_able_to_create_a_defect_with_date_in_the_future_in_testexecution() throws Throwable {
		 try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[39]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[40]=dt.updateDefect();
		   bp.waitForElement();
		   actual[41]=ep.clickOnCancelDefectWindow();
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
