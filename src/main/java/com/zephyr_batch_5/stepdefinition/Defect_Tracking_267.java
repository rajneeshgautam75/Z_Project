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

public class Defect_Tracking_267 extends LaunchBrowser{
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
	boolean[] actual=new boolean[27];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_267";
	
	@Given("^User is in defectTraccking Page$")
	public void user_is_in_defectTraccking_Page() throws Throwable {
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

	@When("^User create defect with customfield of type multiselect if option value in number$")
	public void user_create_defect_with_customfield_of_type_multiselect_if_option_value_in_number() throws Throwable {
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
		   String ze_Multiple_Select_Field[]=new String[1];
		   ze_Multiple_Select_Field[0]=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 20,0);
		   actual[3]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[4]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[5]=dt.enterDefectCustomFields(field,field, field, field, ze_Multiple_Select_Field, field,field_1, field, field,field, field_1, field);
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

	@Then("^Should be able to create defect if option value in number$")
	public void should_be_able_to_create_defect_if_option_value_in_number() throws Throwable {
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

	@When("^User search the created defect and remove the multiselect customfield value and save it$")
	public void user_search_the_created_defect_and_remove_the_multiselect_customfield_value_and_save_it() throws Throwable {
		try
		   {
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[9]=dt.searchDefect(defectId);
		   bp.waitForElement();
		   actual[10]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   dt.Edit.click();
		   bp.waitForElement();
		   for(int i=0;i<=dt.clearZE_Multiple_Select_Field.size()-1;i++)
		   {
		   dt.clearZE_Multiple_Select_Field.get(i).click();
		   }
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

	@Then("^Should be able to save the defect after modification in Defecttracking$")
	public void should_be_able_to_save_the_defect_after_modification_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[11]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[12]=dt.updateDefect();
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

	@When("^User create defect with customfield of type multiselect in Testexecution$")
	public void user_create_defect_with_customfield_of_type_multiselect_in_Testexecution() throws Throwable {
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
		    String ze_Multiple_Select_Field[]=new String[1];
		    ze_Multiple_Select_Field[0]=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 20,0);		    
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
		    actual[13]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[14]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[15]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[16]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[17]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[18]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[19]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[20]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		    bp.waitForElement();
		    actual[21]=dt.enterDefectCustomFields(field,field, field, field, ze_Multiple_Select_Field, field,field_1, field, field,field, field_1, field);
			bp.waitForElement();
		    actual[22]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type multiselect in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_multiselect_in_Testexecution() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[23]=dt.validateDefect(project, issuetype); 
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

	@When("^User remove the option value save the defect$")
	public void user_remove_the_option_value_save_the_defect() throws Throwable {
		try
		   {
			 for(int i=0;i<=dt.clearZE_Multiple_Select_Field.size()-1;i++)
			   {
			   dt.clearZE_Multiple_Select_Field.get(i).click();
			   }
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

	@Then("^Should be able to remove the option value in testexecution$")
	public void should_be_able_to_remove_the_option_value_in_testexecution() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[24]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[25]=dt.updateDefect();
	       bp.waitForElement();
	       actual[26]=ep.clickOnCancelDefectWindow();
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
