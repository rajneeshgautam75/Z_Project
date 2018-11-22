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

public class Defect_Tracking_279 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	boolean[] actual=new boolean[22];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_279";

	@Given("^user Is in defectTracking Page$")
	public void user_Is_in_defectTracking_Page() throws Throwable {
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

	@When("^user create defect with multiple type of customfields$")
	public void user_create_defect_with_multiple_type_of_customfields() throws Throwable {
		try
		   {
		   dt=new DefectTracking(driver); 	
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	 	   String ze_Multiple_Select_Field[]=new String[2];
		   ze_Multiple_Select_Field[0]=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 20,0);
		   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 20,1);
		   String zeRadioField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 19,0);
		   String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1 ,42);
		   String ze_Multi_User_Picker[]=new String[2];
		   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1,42);
		   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2,42);
		   String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,2);
		   String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,3);
		   String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,4);
		   String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,5);
		   String ze_Multi_Version_field[]=new String[2];
		   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 18,0);
		   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 18,1);
		   String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,6);
		   String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,7);
           String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[3]=dt.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[4]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	       actual[5]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, field, ze_Multi_User_Picker, ze_Text_Field);
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

	@Then("^should be able to create Defect with multiple type of customfields$")
	public void should_be_able_to_create_Defect_with_multiple_type_of_customfields() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[7]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[8]=dt.updateDefect();
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

	@When("^user create defect with multiple type of customfields in testexecution$")
	public void user_create_defect_with_multiple_type_of_customfields_in_testexecution() throws Throwable {
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
	    String ze_Multiple_Select_Field[]=new String[2];
	    ze_Multiple_Select_Field[0]=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 20,0);
	    ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 20,1);
	    String zeRadioField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 19,0);
 	    String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1 ,42);
	    String ze_Multi_User_Picker[]=new String[2];
	    ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1,42);
	    ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2,42);
	    String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,2);
	    String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,3);
	    String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,4);
	    String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,5);
	    String ze_Multi_Version_field[]=new String[2];
	    ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 18,0);
	    ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 18,1);
	    String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,6);
	    String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 21,7);
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
	    actual[17]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, field, ze_Multi_User_Picker, ze_Text_Field);
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

	@Then("^should be able to create Defect with multiple type of customfields in testexecution$")
	public void should_be_able_to_create_Defect_with_multiple_type_of_customfields_in_testexecution() throws Throwable {
		 try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[19]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[20]=dt.updateDefect();
		   bp.waitForElement();
		   actual[21]=ep.clickOnCancelDefectWindow();
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
