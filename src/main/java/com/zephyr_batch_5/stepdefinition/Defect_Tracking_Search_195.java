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

public class Defect_Tracking_Search_195 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	LaunchBrowser lb;
    boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_195";
	
	@Given("^user is in TestExecution page$")
	public void user_is_in_TestExecution_page() throws Throwable {
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

   @When("^user launch TestExection$")
   public void user_launch_TestExection() throws Throwable {
      try
	     {
		 ep=new ExecutionPage(driver);
		 tr=new TestRepositoryPage(driver);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 	     
		 String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
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

   @Then("^should be able To launch TestExecution$")
   public void should_be_able_To_launch_TestExecution() throws Throwable {
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

	@When("^user open linked defects modal dialog using D button on a testcase$")
	public void user_open_linked_defects_modal_dialog_using_D_button_on_a_testcase() throws Throwable {
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

	@Then("^should launch link defect window$")
	public void should_launch_link_defect_window() throws Throwable {
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

	@When("^user search for a defect by ID$")
	public void user_search_for_a_defect_by_ID() throws Throwable {
	   try
		 {	
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
	     String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 13, 0); 	 
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

	@Then("^should be able to search defects by ID$")
	public void should_be_able_to_search_defects_by_ID() throws Throwable {
	   try
		 {
		 String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 13, 0);   
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

	@When("^user add the defect to the testcase$")
	public void user_add_the_defect_to_the_testcase() throws Throwable {
		  try
			 {	
			 actual[11]=ep.linkDefect();
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

	@Then("^should be able to link defect to execution$")
	public void should_be_able_to_link_defect_to_execution() throws Throwable {
		  try
			 {
			 int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);   
			 String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 13, 0); 
			 actual[12]=ep.validateLinkedDefect(testcase, defectID);
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

	@When("^user search for the same defect again using the defect ID$")
	public void user_search_for_the_same_defect_again_using_the_defect_ID() throws Throwable {
		  try
			 {	
			 int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);  
			 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
		     String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 13, 0); 
			 actual[13]=ep.clickOnDefectButton(testcase);
			 bp.waitForElement();
			 actual[14]=ep.defectSearch(selectSearch, defectID);
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

	@Then("^should be able to search defect again$")
	public void should_be_able_to_search_defect_again() throws Throwable {
		  try
			 {
			 String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 13, 0); 
			 actual[15]=ep.validateSearchedDefect(defectId);
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

	@When("^user again try to link defect$")
	public void user_again_try_to_link_defect() throws Throwable {
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

	@Then("^should get message as defect is already linked$")
	public void should_get_message_as_defect_is_already_linked() throws Throwable {
		  try
			 {	
			 actual[16]=ep.viewDefectLinkMsg();
			 bp.waitForElement();
			 actual[17]=ep.clickOnCancelDefectWindow();
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
