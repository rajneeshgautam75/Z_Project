package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
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

public class Defect_Tracking_54  extends LaunchBrowser {
	
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	ExecutionPage epp;
	DashBoardPage dp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[22];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_54";
	
	@Given("^User is in the home page$")
	public void user_is_in_the_home_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[1]=pp.selectRelease(releaseName);
			bp.waitForElement();
			
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}  
	   
	}

	@When("^user will goes to textexeution page and navigate to the node$")
	public void user_will_goes_to_textexeution_page_and_navigate_to_the_node() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String cyclename1[]=new String[3];
			cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
		    cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[2]=rp.clickOnTestExecution();
			bp.waitForElement(); 
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[3]=tr.navigateToNode(releaseName,cyclename1);
			bp.waitForElement();  
			bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
		
	   
	}

	@When("^user changes the Status of the TestCase$")
	public void user_will_change_the_Status_of_the_Testcase() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 3, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^status changed sucessfully$")
	public void status_changed_sucessfully() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 3, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[5]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@When("^user will click on D button and search the defect and link it$")
	public void user_will_click_on_D_button_and_search_the_defect_and_link_it() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 3, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[6]=epp.clickOnDefectButton(tcno);
		    bp.waitForElement(); 
		    bp.waitForElement(); 
			actual[7]=epp.searchDefect(defectId);
		    bp.waitForElement();
	    	actual[8]=epp.validateSearchedDefect(defectId);
		    bp.waitForElement();
			actual[9]=epp.linkDefect();
		    bp.waitForElement();
		    bp.waitForElement(); 
		    bp.waitForElement(); 
		    
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}    
	   
	}

	@Then("^should be able to link defect to execution Successfully$")
	public void should_be_able_to_link_defect_to_execution_Successfully() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 3, 0);
			actual[10]=epp.validateLinkedDefect(tcno, defectId);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	  
	}

	@When("^user will go to defect tracking page and search the defect and click on it$")
	public void user_will_go_to_defect_tracking_page_and_search_the_defect_and_click_on_it() throws Throwable {
		try
		{
			dp=new DashBoardPage(driver);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[11]=pp.clickOnDefectTracking();
			bp.waitForElement();
			actual[12]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[13]=dt.validateDefect(defectId);
			bp.waitForElement();
			dp.selectDefect.click();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	   
	}

	@Then("^a new JIRA page will appear$")
	public void a_new_JIRA_page_will_appear() throws Throwable {
		try
		{
			ejp=new ExternalJiraPage(driver);
			int switchtcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 2, 5);
			String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			bp.switchWindowTab(switchtcNo);
			bp.waitForElement();
			actual[14]=ejp.loginToExternalJira(username, password);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^user change the summary of the issue$")
	public void user_change_the_summary_of_the_issue() throws Throwable {
		try
		{
			String summary=Excel_Lib.getData(INPUT_PATH_8, "Jira", 1, 3);
			String[] labels1= new String[1];
			labels1[0]=Excel_Lib.getData(INPUT_PATH_8, "Jira", 100, 1);
			String priority=Excel_Lib.getData(INPUT_PATH_8, "Jira", 100, 1);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_8, "Jira", 100, 1);
			String linkedIssuesArea=Excel_Lib.getData(INPUT_PATH_8, "Jira", 100, 1);
			String jiraAssignee=Excel_Lib.getData(INPUT_PATH_8, "Jira", 100, 1);
			String editJiraContent=Excel_Lib.getData(INPUT_PATH_8, "Jira", 100, 1);
			actual[15]=ejp.editJiraSummaryDetails(summary, labels1, priority, linkedIssue, linkedIssuesArea, jiraAssignee, editJiraContent);
		    for (int j=0;j<15;j++)
	        	{
			       bp.waitForElement();
		        }
		    actual[16]=ejp.logOutFromExternal_JIRA();
		    driver.close();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	  
	}

	@When("^user will switch back to the application page$")
	public void user_will_switch_back_to_the_application_page() throws Throwable {
		try
		{
			int switchbacktcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 5);
			bp.switchWindowTab(switchbacktcNo);
			bp.waitForElement();
			actual[17]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^user will goes to testexecution page and apply notification$")
	public void user_will_goes_to_testexecution_page_and_apply_notification() throws Throwable {
		try
		{
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			actual[18]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[19]=tr.navigateToNode(releaseName,cyclename1);
			bp.waitForElement();
			actual[20]=epp.applyNotification();
			bp.waitForElement();	
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
		
	    
	}

	@Then("^user will View the updated Summary in execution grid\\.$")
	public void user_will_View_the_updated_Summary_in_execution_grid() throws Throwable {
		try
		{
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 3, 0);
			actual[21]=epp.viewTooltip(tcNo);		
			bp.waitForElement();	
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
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	   
	}


}
