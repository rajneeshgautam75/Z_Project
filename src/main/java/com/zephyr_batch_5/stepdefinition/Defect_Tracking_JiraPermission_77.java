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

public class Defect_Tracking_JiraPermission_77 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_77";
	
	boolean[] actual=new boolean[42];
	SoftAssert soft=new SoftAssert();
	private String[] fields=new String[12];
	{
	   for(int i=0;i<=11;i++)
	   {
	   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	}
	 String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	 String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
	@Given("^User in External jira page$")
	public void user_in_External_jira_page() throws Throwable {
	try
	   {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 ccfp=new CreateCustomFieldsPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 tp=new TestPlanningPage(driver);
		 rp=new ReleasePage(driver);
		 req=new RequirementsPage(driver);
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 exep=new ExecutionPage(driver);
		 pp.clickOnLogout();
		 lp=new LoginPage(driver);
		
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[0]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^Change administrator permission to defect permission$")
	public void change_administrator_permission_to_defect_permission() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,67);
		 ejp.closeNotificationMsg();
		 actual[1]=ejp.launchJiraAdministration(issueType);
		 actual[2]=ejp.selectProjectAdministration(projectName);
		 actual[3]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 actual[4]=ejp.closeNotificationMsg();
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

	@When("^As a manager,Launch the Administration page$")
	public void as_a_manager_Launch_the_Administration_page() throws Throwable {
	try
    {
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     actual[6]=lp.enterUname(manager_Uname);
	     actual[7]=lp.enterPass(manager_Pass);
	     actual[8]=lp.clickOnLogin();
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

	@When("^Launch the Defect Tracking to set DTS$")
	public void launch_the_Defect_Tracking_to_set_DTS() throws Throwable {
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

	@When("^Set an DTS to the JIRA$")
	public void set_an_DTS_to_the_JIRA() throws Throwable {
	try
	   {
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

	@Then("^Should be able to Set an DTS to JIRA$")
	public void should_be_able_to_Set_an_DTS_to_JIRA() throws Throwable {
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

	@When("^As a Lead,Launch the Defect Tracking page$")
	public void as_a_Lead_Launch_the_Defect_Tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
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

	@Then("^Should be able to launch the Defect Tracking Page$")
	public void should_be_able_to_launch_the_Defect_Tracking_Page() throws Throwable {
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

	@When("^Set the defect user who Don't have permission to editing defect$")
	public void set_the_defect_user_who_Don_t_have_permission_to_editing_defect() throws Throwable {
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

	@When("^Attempt to edit defect in defect tracking app$")
	public void attempt_to_edit_defect_in_defect_tracking_app() throws Throwable {
	try
	   {
		 actual[24]=dt.searchDefect(defectID);
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
		 actual[25]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[26]=dt.clickOnEditDefectButton();
		 actual[27]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
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

	@Then("^Should get a proper message 'Don't have permission to editing defect'$")
	public void should_get_a_proper_message_Don_t_have_permission_to_editing_defect() throws Throwable {
	try
	   {
		 actual[28]=dt.updateDefectEditWindow();
		 actual[29]=dt.validateErrorMsg();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to edit a subtask in defect tracking app$")
	public void attempt_to_edit_a_subtask_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String subtaskID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,30);
		 actual[30]=dt.searchDefect(subtaskID);
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[31]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[32]=dt.clickOnEditDefectButton();
		 actual[33]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
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

	@Then("^Should get a proper Message 'user Don't have permission to editing defect'$")
	public void should_get_a_proper_Message_user_Don_t_have_permission_to_editing_defect() throws Throwable {
	try
	   {
		 actual[34]=dt.updateDefectEditWindow();
		 actual[35]=dt.validateErrorMsg();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^Launch the Test Execution Page$")
	public void launch_the_Test_Execution_Page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[36]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    bp.waitForElement();
			actual[37]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[38]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[39]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^attempt to edit defect in test execution app$")
	public void attempt_to_edit_defect_in_test_execution_app() throws Throwable {
	    
	}

	@Then("^Should get the proper message 'user Don't have permission to editing defect'$")
	public void should_get_the_proper_message_user_Don_t_have_permission_to_editing_defect() throws Throwable {
	try
	   {
		 actual[40]=dt.validateErrorMsg();
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

	@When("^attempt to edit a Subtask in test execution app$")
	public void attempt_to_edit_a_Subtask_in_test_execution_app() throws Throwable {
	    
	}

	@Then("^should get a proper message that'user Don't have permission to editing defect'$")
	public void should_get_a_proper_message_that_user_Don_t_have_permission_to_editing_defect() throws Throwable {
	try
	   {
		 actual[41]=dt.validateErrorMsg();
		 
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
