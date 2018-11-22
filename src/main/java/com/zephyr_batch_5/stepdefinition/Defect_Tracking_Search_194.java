package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_194 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	LaunchBrowser lb;
    boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_194";
	
@Given("^User is in Test Execution page$")
public void user_is_in_Test_Execution_page() throws Throwable {
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
    actual[2]=rp.clickOnTestExecution();
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

@When("^User launch Test Execution$")
public void user_launch_Test_Execution() throws Throwable {
   try
     {
	 ep=new ExecutionPage(driver);
	 tr=new TestRepositoryPage(driver);
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 	     
	 String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
	 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 19);
	 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 17);
	 String cyclename[]=new String[1];
	 cyclename[0]=cycle;
	 String[] str=new String[2];
	 str[0]=cycle;
     str[1]=phase;
	 actual[3]=tr.navigateToNode(releaseName, str);
     bp.waitForElement();
     actual[4]=ep.selectAndDeselectAllTestCase();
     bp.waitForElement();
     actual[5]=ep.changeMultiSelectedStatus(status);
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

@Then("^Should be able to launch Test Execution$")
public void should_be_able_to_launch_Test_Execution() throws Throwable {
  try
	 {	 
	 actual[6]=ep.verifyExecutionPage();
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

@When("^User open linked defects modal dialog using D button of first testcase$")
public void user_open_linked_defects_modal_dialog_using_D_button_of_first_testcase() throws Throwable {
  try
	 {
	 int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);  
	 actual[7]=ep.clickOnDefectButton(testcase);
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

@Then("^Should launch link Defect window$")
public void should_launch_link_Defect_window() throws Throwable {
   try
	 {	 
	 actual[8]=ep.validateLinkDefectWindow();
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

@When("^User Search defect with first priority by JQL$")
public void user_Search_defect_with_first_priority_by_JQL() throws Throwable {
  try
	 {
	 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
	 String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 10, 0); 
	 actual[9]=ep.defectSearch(selectSearch, value);
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

@Then("^Should be able to search defects by JQL$")
public void should_be_able_to_search_defects_by_JQL() throws Throwable {
   try
	 {	  
	 String defectType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 12, 0); 
	 String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 12, 2);  
	 actual[10]=ep.validateSearchedDefect(defectType, defectValue);
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

@When("^User link the searched defect$")
public void user_link_the_searched_defect() throws Throwable {
	try
	 {	 
     ep.linkDefects.click();
	 bp.waitForElement();
	 bp.waitForElement();
	 ep.searchJqlID.clear();
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

@When("^User Search defect with different priority by JQL$")
public void user_Search_defect_with_different_priority_by_JQL() throws Throwable {
	 try
	 {
	 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
	 String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",11, 0); 
	 actual[11]=ep.defectSearch(selectSearch, value);
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

@Then("^Should be able to Search defects by JQL$")
public void should_be_able_to_Search_defects_by_JQL() throws Throwable {
	 try
	 {	  
	 String defectType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 12, 0); 
	 String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 12, 3);  
	 actual[12]=ep.validateSearchedDefect(defectType, defectValue);
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
	 
@When("^User link defect with different priority$")
public void user_link_defect_with_different_priority() throws Throwable {
	 try
	 {	 
     ep.linkDefects.click();
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

@Then("^Should be able to link defect to execution with different priorities$")
public void should_be_able_to_link_defect_to_execution_with_different_priorities() throws Throwable {
	 try
	 {
	 actual[13]=ep.validateCurrentlylinkedDefect();
	 bp.waitForElement();
	 ep.clickOnCancelDefectWindow();
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

@When("^User open linked defects modal dialog using D button of second testcase$")
public void user_open_linked_defects_modal_dialog_using_D_button_of_second_testcase() throws Throwable {
	try
	 {
	 int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 2, 26);  
	 actual[14]=ep.clickOnDefectButton(testcase);
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

@Then("^Should launch Link defect window$")
public void should_launch_Link_defect_window() throws Throwable {
	 try
	 {	 
	 actual[15]=ep.validateLinkDefectWindow();
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

@When("^User Search defect with first status by JQL$")
public void user_Search_defect_with_first_status_by_JQL() throws Throwable {
	 try
	 {
	 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
	 String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 10, 1); 
	 actual[16]=ep.defectSearch(selectSearch, value);
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

@Then("^Should be able to Search Defects by JQL$")
public void should_be_able_to_Search_Defects_by_JQL() throws Throwable {
	 try
	 {	  
	 String defectType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 12, 1); 
	 String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 11, 2);  
	 actual[17]=ep.validateSearchedDefect(defectType, defectValue);
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

@When("^User Link searched defect$")
public void user_Link_searched_defect() throws Throwable {
	try
	 {	 
     ep.linkDefects.click();
	 bp.waitForElement();
	 bp.waitForElement();
	 ep.searchJqlID.clear();
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

@When("^User serach defect with different status by JQL$")
public void user_serach_defect_with_different_status_by_JQL() throws Throwable {
	 try
	 {
	 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
	 String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 11, 1); 
	 actual[18]=ep.defectSearch(selectSearch, value);
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

@Then("^Should be Able to Search defects by JQL$")
public void should_be_Able_to_Search_defects_by_JQL() throws Throwable {
	 try
	 {	  
	 String defectType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 12, 1); 
	 String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 11, 2);  
	 actual[19]=ep.validateSearchedDefect(defectType, defectValue);
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

@When("^User link defect with different status$")
public void user_link_defect_with_different_status() throws Throwable {
	 try
	 {	 
	 ep.linkDefects.click();
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

@Then("^Should be able to link defect to execution with different status$")
public void should_be_able_to_link_defect_to_execution_with_different_status() throws Throwable {
	 try
	 {
	 actual[20]=ep.validateCurrentlylinkedDefect();
	 bp.waitForElement();
	 ep.clickOnCancelDefectWindow();
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

@When("^User hover the cursor on defectid in execution grid$")
public void user_hover_the_cursor_on_defectid_in_execution_grid() throws Throwable {
    try
	  {
	  int testcase_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26); 
	  int testcase_2=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 2, 26);
	  actual[21]=ep.viewTooltip(testcase_1);
	  bp.waitForElement();
	  actual[22]=ep.viewTooltip(testcase_2);
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

@Then("^defect details should show properly for all linked defects$")
public void defect_details_should_show_properly_for_all_linked_defects() throws Throwable {
   try
	 {	
	   //actual[23]=pp.backToProjectPage();
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
