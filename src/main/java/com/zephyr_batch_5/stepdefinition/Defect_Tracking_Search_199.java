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

public class Defect_Tracking_Search_199 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	LaunchBrowser lb;
    boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_199";
	
	@Given("^user in Textexecution Page$")
	public void user_in_Textexecution_Page() throws Throwable {
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

	@When("^User launch textexecution$")
	public void user_launch_textexecution() throws Throwable {
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

	@Then("^Should be able to Launch textexecution$")
	public void should_be_able_to_Launch_textexecution() throws Throwable {
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

	@When("^User Open linked defects modal dialog using D button on a testcase$")
	public void user_Open_linked_defects_modal_dialog_using_D_button_on_a_testcase() throws Throwable {
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

	@Then("^Should be able to launch Link Defect Window$")
	public void should_be_able_to_launch_Link_Defect_Window() throws Throwable {
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
	@When("^User search for first defect by ID which is having long name of (\\d+) chars$")
	public void user_search_for_first_defect_by_ID_which_is_having_long_name_of_chars(int arg1) throws Throwable {
		try
		 {	
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
	     String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",16,0); 	 
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

	@Then("^Should be able to search first defect with long name$")
	public void should_be_able_to_search_first_defect_with_long_name() throws Throwable {
		 try
		 {	
		 String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",16,0 );  
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

	@When("^User Click on Link button on first defect$")
	public void user_Click_on_Link_button_on_first_defect() throws Throwable {
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

	@Then("^Should be able to link first defect with long name$")
	public void should_be_able_to_link_first_defect_with_long_name() throws Throwable {
		try
		 {	
		 int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26); 		
		 actual[11]=ep.validateCurrentlylinkedDefect();
		 bp.waitForElement();
		 ep.cancelDefect.click();	
		 bp.waitForElement();
		 actual[12]=ep.clickOnDefectButton(testcase);
	     bp.waitForElement();
	     actual[13]=ep.validateLinkDefectWindow();
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

	@When("^User search for second defect by ID which is having long name of (\\d+) chars$")
	public void user_search_for_second_defect_by_ID_which_is_having_long_name_of_chars(int arg1) throws Throwable {
		try
		 {	
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
	     String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",17,0); 	 
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

	@Then("^Should be able to search second defect with long name$")
	public void should_be_able_to_search_second_defect_with_long_name() throws Throwable {
		 try
		 {	
		 String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",17,0 );  
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

	@When("^User Click on Link button on second defect$")
	public void user_Click_on_Link_button_on_second_defect() throws Throwable {
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

	@Then("^Should be able to link second defect with long name$")
	public void should_be_able_to_link_second_defect_with_long_name() throws Throwable {
		 try
		 {
		 actual[16]=ep.validateCurrentlylinkedDefect();
		 bp.waitForElement();
		 ep.clickOnCancelDefectWindow();
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
