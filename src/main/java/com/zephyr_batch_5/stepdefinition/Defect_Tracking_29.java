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

public class Defect_Tracking_29 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage dp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
    boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_29";
   
@Given("^user is in Defecttracking page$")
public void user_is_in_Defecttracking_page() throws Throwable {
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

@When("^user serach the subtask by JiraID in advance serach$")
public void user_serach_the_subtask_by_JiraID_in_advance_serach() throws Throwable {
	try
    {
    dt=new DefectTracking(driver);		
	String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
  	String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 34);  	
	actual[3]=dt.advancedSearch(selectSearch, name);
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


@Then("^Should be able to search by a specific Subtask number$")
public void should_be_able_to_search_by_a_specific_Subtask_number() throws Throwable {
	try
    {
    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 35); 
    actual[4]=dt.validateAdvancedSearch(defectValue);
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



@When("^user click on Textexecution and execute testcases and create defect and search it$")
public void user_click_on_Textexecution_and_execute_testcases_and_create_defect_and_search_it() throws Throwable {
	try
	   {
       tr=new TestRepositoryPage(driver);
       rp=new ReleasePage(driver);
       ep=new ExecutionPage(driver); 
	   String testcase=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26));
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
	   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
	   String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
	   String name1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 34);  	
	   String cyclename[]=new String[1];
	   cyclename[0]=cycle;
	   String phase1[]=new String[1];
	   phase1[0]=name;
	   String[] str=new String[2];
	   str[0]=cycle;
	   str[1]=phase;
	   actual[5]=rp.clickOnTestExecution();
	   bp.waitForElement();
	   actual[6]=tr.navigateToNode(releaseName, str);
	   bp.waitForElement();
	   actual[7]=ep.selectAndDeselectAllTestCase();
	   bp.waitForElement();
	   actual[8]=ep.changeMultiSelectedStatus(status);
	   bp.waitForElement();	
	   actual[9]=ep.clickOnDefectButton(testcase);
	   bp.waitForElement();
	   actual[10]=ep.advancedSearch2(selectSearch, name1);
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

@Then("^should be able to search by a specific subtask number$")
public void should_be_able_to_search_by_a_specific_subtask_number() throws Throwable {
	try
    {
    dt=new DefectTracking(driver);
    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 35); 
    actual[11]=dt.validateAdvancedSearch(defectValue);
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

