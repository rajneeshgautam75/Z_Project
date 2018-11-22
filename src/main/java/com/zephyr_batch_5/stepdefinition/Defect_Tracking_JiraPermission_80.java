package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_JiraPermission_80 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	ExecutionPage exep;
	CreateCustomFieldsPage ccfp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_JiraPermission_80";
	
	boolean[] actual=new boolean[32];
	SoftAssert soft=new SoftAssert();
	
	private String[] fields=new String[12];
	{
	   for(int i=0;i<=11;i++)
	   {
	   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	}
	 int[] defectNo=new int[1];
	 {
	 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
	 }
	 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
	 String defectIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
     String defectSubtaskIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
	 String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	 String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	@Given("^User Is in the External Jira Page$")
	public void user_Is_in_the_External_Jira_Page() throws Throwable {
	try
    {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 ccfp=new CreateCustomFieldsPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 tp=new TestPlanningPage(driver);
		 req=new RequirementsPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 exep=new ExecutionPage(driver);
		 pp.clickOnLogout();
		 lp=new LoginPage(driver);
	 	 
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[0]=ejp.loginToExternalJira(jiraUname,jiraPwd);
	     actual[1]=ejp.closeNotificationMsg();
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

	@When("^navigate to the Projects page$")
	public void navigate_to_the_Projects_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 actual[2]=ejp.launchJiraAdministration(issueType);
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

	@When("^change permission to No Assign Issue$")
	public void change_permission_to_No_Assign_Issue() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,67);
		 ejp.closeNotificationMsg();
		 actual[3]=ejp.selectProjectAdministration(projectName);
		 actual[4]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 //driver.navigate().refresh();
		 ejp.closeNotificationMsg();
		 actual[5]=ejp.logOutFromExternal_JIRA();
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

	@When("^As a Manager,Launch the Administration Page$")
	public void as_a_Manager_Launch_the_Administration_Page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[6]=lp.enterUname(manager_Uname);
	     actual[7]=lp.enterPass(manager_Pass);
	     actual[8]=lp.clickOnLogin();
	     for(int i=0;i<=3;i++)
	     {
	     bp.waitForElement();
	     }
	     actual[9]=pp.launchAdministration();
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

	@When("^launch the DefectTracking to set the DTS$")
	public void launch_the_DefectTracking_to_set_the_DTS() throws Throwable {
	try
	   {
		 actual[10]=pp.clickOnDefectTracking();
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

	@When("^set a DTS To the JIRA$")
	public void set_a_DTS_To_the_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
		 actual[11]=pp.clickOnDefectTracking();
		 actual[12]=ccfp.editDTS(DTS,jira_Url,jiraUname,jiraPwd);
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

	@Then("^Should be able to Set a DTS to JIRA$")
	public void should_be_able_to_Set_a_DTS_to_JIRA() throws Throwable {
	try
	   {
		 actual[13]=pp.validateSetDTS();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[14]=pp.launchDefectAdmin();
		 actual[15]=pp.clearCache();
		 bp.waitForElement();
		 pp.clickOnLogout();
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

	@When("^As a Lead,Launch The DefectTracking Page$")
	public void as_a_Lead_Launch_The_DefectTracking_Page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     //driver.navigate().to(zephyr_Url);
	     actual[16]=lp.enterUname(lead_Uname);
	     actual[17]=lp.enterPass(lead_Pass);
	     actual[18]=lp.clickOnLogin();
		 actual[19]=pp.selectProject(projectName);
		 actual[20]=pp.selectRelease(releaseName);
		 actual[21]=rp.clickOnDefectTracking();
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

	@Then("^Should Be able to Launch Defect Tracking page$")
	public void should_Be_able_to_Launch_Defect_Tracking_page() throws Throwable {
	try
	   {
		 actual[22]=dt.validateDefectTrackingPage();
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

	@When("^set the Defect user who doesn't have assign issue permission$")
	public void set_the_Defect_user_who_doesn_t_have_assign_issue_permission() throws Throwable {
	try
	   {
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
		 actual[23]=req.dtsLoginDetail(jiraUname,jiraPwd,jiraPwd);
		 for(int i=0;i<=3;i++)
		 {
			 bp.waitForElement();
		 }
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

	@When("^search a defect in defect tracking app$")
	public void search_a_defect_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 actual[24]=dt.searchDefect(defectID);
		 actual[25]=dt.selectSingleOrMultipleDefects(defectNo);
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

	@When("^attempt to add comment in search defect view$")
	public void attempt_to_add_comment_in_search_defect_view() throws Throwable {
	try
	   {
		    String comment=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		    //actual[26]=dt.updateDefectDetailsInSearchView(fields[0],fields[1],fields[2],fields[3],fields[4],comment,fields[5],fields[6],fields[7],fields[8]);
		    actual[26]=dt.updateDefectCommentInSearchView(comment);
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

	@Then("^Should get message 'you do not have the permission to comment on this issue' for defect$")
	public void should_get_message_you_do_not_have_the_permission_to_comment_on_this_issue_for_defect() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,42);
		 actual[27]=dt.viewDefectPermissionMsg(permissionValue);
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

	@When("^search a Subtask in defect Tracking app$")
	public void search_a_Subtask_in_defect_Tracking_app() throws Throwable {
	try
	   {
		 String defectSubtaskID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,30);
		 actual[28]=dt.searchDefect(defectSubtaskID);
		 actual[29]=dt.selectSingleOrMultipleDefects(defectNo);
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
	
	@When("^attempt to add comment in search defect view for subtask$")
	public void attempt_to_add_comment_in_search_defect_view_for_subtask() throws Throwable {
	try
	   {
		String comment=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	    actual[30]=dt.updateDefectCommentInSearchView(comment);
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

	@Then("^Should get message 'you do not have the permission to comment on this issue' for the subtask$")
	public void should_get_message_you_do_not_have_the_permission_to_comment_on_this_issue_for_the_subtask() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,42);
		 actual[31]=dt.viewDefectPermissionMsg(permissionValue);
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
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
