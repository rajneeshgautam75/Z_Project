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

public class Defect_Tracking_JiraPermission_81 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_81";
	
	boolean[] actual=new boolean[53];
	SoftAssert soft=new SoftAssert();
	
	private String[] fields=new String[12];
	{
	   for(int i=0;i<=11;i++)
	   {
	   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	}
	 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
	 String defectIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
     String defectSubtaskIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
	 String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	 String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,30);
	 String[] filePath=new String[1];
	 {
	 filePath[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,37);
	 }
	@Given("^User Is in the External_Jira Page$")
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
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[0]=ejp.loginToExternalJira(Uname,Pwd);
	     ejp.closeNotificationMsg();
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

	@When("^User navigate to the projects page$")
	public void user_navigate_to_the_projects_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 actual[1]=ejp.launchJiraAdministration(issueType);
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

	@When("^change the permission to No Attachment permission$")
	public void change_the_permission_to_No_Attachment_permission() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,67);
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.selectProjectAdministration(projectName);
		 actual[3]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 ejp.closeNotificationMsg();
		 actual[4]=ejp.logOutFromExternal_JIRA();
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

	@When("^As a manager,launch the Administration page$")
	public void as_a_manager_launch_the_Administration_page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[5]=lp.enterUname(manager_Uname);
	     actual[6]=lp.enterPass(manager_Pass);
	     actual[7]=lp.clickOnLogin();
	     actual[8]=pp.launchAdministration();
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

	@When("^launch Defect Tracking to set the DTS$")
	public void launch_Defect_Tracking_to_set_the_DTS() throws Throwable {
	try
	   {
		 actual[9]=pp.clickOnDefectTracking();
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

	@When("^Set DTS To the JIRA$")
	public void set_DTS_To_the_JIRA() throws Throwable {
	try
	   {
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
		 actual[10]=pp.clickOnDefectTracking();
		 actual[11]=ccfp.editDTS(DTS,jira_Url,Uname,Pwd);
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

	@Then("^Should be able to set a DTS to JIRA$")
	public void should_be_able_to_set_a_DTS_to_JIRA() throws Throwable {
	try
	   {
		 actual[12]=pp.validateSetDTS();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[13]=pp.launchDefectAdmin();
		 actual[14]=pp.clearCache();
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

	@When("^As the Lead,Launch the Defect Tracking Page$")
	public void as_the_Lead_Launch_the_Defect_Tracking_Page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     actual[15]=lp.enterUname(lead_Uname);
	     actual[16]=lp.enterPass(lead_Pass);
	     actual[17]=lp.clickOnLogin();
		 actual[18]=pp.selectProject(projectName);
		 actual[19]=pp.selectRelease(releaseName);
		 actual[20]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to launch defect Tracking page$")
	public void should_be_able_to_launch_defect_Tracking_page() throws Throwable {
	try
	   {
		 actual[21]=dt.validateDefectTrackingPage();
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

	@When("^Set the Defect user who doesn't have no attachment permission$")
	public void set_the_Defect_user_who_doesn_t_have_no_attachment_permission() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
		 actual[22]=req.dtsLoginDetail(Uname,Pwd,Pwd);
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

	@When("^aatempt to add attachment to the defect in defect tracking$")
	public void aatempt_to_add_attachment_to_the_defect_in_defect_tracking() throws Throwable {
	try
	   {
			actual[23]=dt.createDefect(project,defectIssueType);
			actual[24]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[25]=dt.saveDefect();
			actual[26]=exep.uploadAttachement(filePath);
			dt.updateDefect();
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

	@Then("^Should get message 'Don't have permission to add attachment' to the defect$")
	public void should_get_message_Don_t_have_permission_to_add_attachment_to_the_defect() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,42);
		 actual[27]=dt.viewDefectPermissionMsg(permissionValue);
		 driver.navigate().refresh();
		 for(int i=0;i<=2;i++)
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

	@When("^attempt to add attachment to a subtask in defect Tracking app$")
	public void attempt_to_add_attachment_to_a_subtask_in_defect_Tracking_app() throws Throwable {
	try
	   {
			String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
			actual[28]=dt.searchDefect(defectID);
			dt.selectAllDefects();
			actual[29]=dt.defectsOperation(defectValue);
			actual[30]=dt.createDefectSubtask(defectSubtaskIssueType);
			actual[31]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[32]=dt.saveDefect();
			actual[33]=exep.uploadAttachement(filePath);
			dt.updateDefect();
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

	@Then("^Should get message 'Don't have permission to add attachment' to the subtask$")
	public void should_get_message_Don_t_have_permission_to_add_attachment_to_the_subtask() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,42);
		 actual[34]=dt.viewDefectPermissionMsg(permissionValue);
		 driver.navigate().refresh();
		 for(int i=0;i<=2;i++)
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

	@When("^launch the TestExecution Page$")
	public void launch_the_TestExecution_Page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[35]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    
		    bp.waitForElement();
			actual[36]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[37]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[38]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^attempt to add attachment to the defect in test execution$")
	public void attempt_to_add_attachment_to_the_defect_in_test_execution() throws Throwable {
	try
	   {
		    actual[39]=dt.createDefect(project,defectIssueType);
			actual[40]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[41]=dt.saveDefect();
			actual[42]=exep.uploadAttachement(filePath);
			dt.updateDefect();
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

	@Then("^Should get message 'Don't have permission to add attachment' to the defect in test execution$")
	public void should_get_message_Don_t_have_permission_to_add_attachment_to_the_defect_in_test_execution() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,42);
		 actual[43]=dt.viewDefectPermissionMsg(permissionValue);
		 driver.navigate().refresh();
		 for(int i=0;i<=2;i++)
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

	@When("^attempt to add attachment to the subtask in test execution$")
	public void attempt_to_add_attachment_to_the_subtask_in_test_execution() throws Throwable {
	try
	  {
		actual[44]=exep.searchDefect(defectID);
		actual[45]=exep.clickOnSubtask();
		actual[46]=dt.createDefectSubtask(defectSubtaskIssueType);
		actual[47]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		actual[48]=dt.saveDefect();
		actual[49]=exep.uploadAttachement(filePath);
		dt.updateDefect();
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

	@Then("^Should get message 'Don't have permission to add attachment' to the subtask in test execution$")
	public void should_get_message_Don_t_have_permission_to_add_attachment_to_the_subtask_in_test_execution() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,42);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[50]=dt.viewDefectPermissionMsg(permissionValue);
		 driver.navigate().refresh();
		 for(int i=0;i<=2;i++)
		 {
		 bp.waitForElement();
		 }
		 actual[51]=exep.clickOnCancelDefectWindow();
		 actual[52]=tp.doubleClickOnCycle(releaseName);
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
