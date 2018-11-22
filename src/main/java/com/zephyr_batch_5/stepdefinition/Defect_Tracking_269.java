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

public class Defect_Tracking_269 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	public String defectId;
	boolean[] actual=new boolean[29];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_269";
	
	@Given("^User is in DefectTrcking page$")
	public void user_is_in_DefectTrcking_page() throws Throwable {
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

	@When("^User create a defect with custom field of type radio button$")
	public void user_create_a_defect_with_custom_field_of_type_radio_button() throws Throwable {
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
		   String zeRadioField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 19,0);
		   actual[3]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[4]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[5]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[6]=dt.saveDefect();
		   bp.waitForElement();
		   defectId=dt.retrieveDefectId();
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

	@Then("^Should be able to create defect with custom field of type radio button$")
	public void should_be_able_to_create_defect_with_custom_field_of_type_radio_button() throws Throwable {
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

	@When("^User search the created defect and click on edit and change the value and save it$")
	public void user_search_the_created_defect_and_click_on_edit_and_change_the_value_and_save_it() throws Throwable {
		try
		   {
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);	
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,1);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[9]=dt.searchDefect(defectId);
		   bp.waitForElement();
		   actual[10]=dt.selectSingleOrMultipleDefects(defectNo);
		   dt.Edit.click();
		   bp.waitForElement();
		   actual[11]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
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

	@Then("^Should be able to save the defect after modification$")
	public void should_be_able_to_save_the_defect_after_modification() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[12]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[13]=dt.updateDefect();
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

	@When("^User create a defect with custom field of radio button in testexecution$")
	public void user_create_a_defect_with_custom_field_of_radio_button_in_testexecution() throws Throwable {
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
		    String zeRadioField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 19,0);		    
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    for(int i=0;i<=5;i++)
		    {
		    bp.waitForElement();
		    }
		    actual[14]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[15]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[16]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[17]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[18]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[19]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[20]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[21]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		    bp.waitForElement();
		    actual[22]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
			bp.waitForElement();
		    actual[23]=dt.saveDefect();
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

	@Then("^Should be able to create defect in testexecution$")
	public void should_be_able_to_create_defect_in_testexecution() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[24]=dt.validateDefect(project, issuetype); 
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

	@When("^User search the created defect and select click on edit and change the value and save it$")
	public void user_search_the_created_defect_and_select_click_on_edit_and_change_the_value_and_save_it() throws Throwable {
		try
		   {
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);	
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,1);
		   actual[25]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
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

	@Then("^Should be able to save the defect after Modification$")
	public void should_be_able_to_save_the_defect_after_Modification() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[26]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[27]=dt.updateDefect();
	       bp.waitForElement();
	       actual[28]=ep.clickOnCancelDefectWindow();
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
