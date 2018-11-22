package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_46 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_46";
    @Given("^User Is IN A DefectTracking App$")
    public void user_Is_IN_A_DefectTracking_App() throws Throwable {
    	try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			dt=new DefectTracking(driver);
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			
			pp.selectProject(projectName);
			pp.selectRelease(releaseName);
		    actual[0]=pp.clickOnDefectTracking();
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

@When("^user Searches defect by any attribute Project,issueType,Pripority,status,assignee$")
public void user_Searches_defect_by_any_attribute_Project_issueType_Pripority_status_assignee() throws Throwable {
	 try
	   {
		   String project=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		   String status=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String filedBy=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String version=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String priority=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   String assignee=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
		   bp.waitForElement();
		   actual[1]=dt.defectSearch(project, issueType, status, filedBy, version, priority, assignee);
		   
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

@When("^after search result,select a defect,sub-task in grid,Enter the  comment  Cancel the X button$")
public void after_search_result_select_a_defect_sub_task_in_grid_Enter_the_comment_Cancel_the_X_button() throws Throwable {
	try
	   {
		  int defectNo[]=new int[1];
		  defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 2, 0);
		  String comment=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 5);
		  bp.waitForElement();
		  actual[2]=dt.selectSingleOrMultipleDefects(defectNo);  
		  bp.waitForElement();
		  bp.waitForElement(); 
		  actual[3]=dt.updateDefectDetailsInSearchViewComment(comment);	
		  bp.waitForElement();
		  bp.waitForElement();
		  dt.cancelComment.click();
		  
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

@Then("^Should be able to  Update the Defect,subtask with comment  and cancel$")
public void should_be_able_to_Update_the_Defect_subtask_with_comment_and_cancel() throws Throwable {
	try
	{
		 String comment=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
		 bp.waitForElement();
		 actual[4]=dt.validateComment(comment);
		  
		  for(int k=0;k<=actual.length-1;k++)
			{
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
