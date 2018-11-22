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

public class Defect_Tracking_Search_197 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	LaunchBrowser lb;
    boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_197";
	
	@Given("^User is in textexecution page$")
	public void user_is_in_textexecution_page() throws Throwable {
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

	@When("^User launch Textexecution$")
	public void user_launch_Textexecution() throws Throwable {
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

	@Then("^Should be able to launch Textexecution$")
	public void should_be_able_to_launch_Textexecution() throws Throwable {
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

	@When("^User open linked defects modal dialog using D button on a Testcase$")
	public void user_open_linked_defects_modal_dialog_using_D_button_on_a_Testcase() throws Throwable {
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
	
	@Then("^Should be able to launch Link defect window$")
	public void should_be_able_to_launch_Link_defect_window() throws Throwable {
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

	@When("^User search a defect by ID which is having special chars in name$")
	public void user_search_a_defect_by_ID_which_is_having_special_chars_in_name() throws Throwable {
	   try
		 {	
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
	     String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",14 ,0); 	 
		 actual[9]=ep.defectSearch(selectSearch, defectID);
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

	@Then("^Should be able to search defect which is having special chars in name$")
	public void should_be_able_to_search_defect_which_is_having_special_chars_in_name() throws Throwable {
	   try
		 {	
		 String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",14,0 );  
		 actual[10]=ep.validateSearchedDefect(defectId);
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

	@When("^User click on Link button$")
	public void user_click_on_Link_button() throws Throwable {
	   try
		 {	
		 ep.linkDefects.click();
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

	@Then("^Should be able to link defect which is having special chars in name$")
	public void should_be_able_to_link_defect_which_is_having_special_chars_in_name() throws Throwable {
		 try
		 {
		 actual[11]=ep.validateCurrentlylinkedDefect();
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
