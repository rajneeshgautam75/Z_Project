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

public class Defect_Tracking_JiraPermission_75 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_75";
	
	boolean[] actual=new boolean[34];
	SoftAssert soft=new SoftAssert();
	
	String[] fields=new String[11];
	{
    for(int i=0;i<=10;i++)
    {
    	fields[i]=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",100,100);
    }
	}
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	@Given("^As a manager,Launch the administration$")
	public void as_a_manager_Launch_the_administration() throws Throwable {
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
	 	 
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     actual[0]=lp.enterUname(Uname);
	     actual[1]=lp.enterPass(Pass);
	     actual[2]=lp.clickOnLogin();
	     actual[3]=pp.launchAdministration();
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

	@When("^Launch the Defect tracking to set DTS$")
	public void launch_the_Defect_tracking_to_set_DTS() throws Throwable {
	try
	   {
		 actual[4]=pp.clickOnDefectTracking();
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

	@When("^Set DTS to the JIRA$")
	public void set_DTS_to_the_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
		 actual[5]=pp.clickOnDefectTracking();
		 actual[6]=ccfp.editDTS(DTS,jira_Url,jiraUname,jiraPwd);
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

	@Then("^Should be able to Set DTS to JIRA$")
	public void should_be_able_to_Set_DTS_to_JIRA() throws Throwable {
	try
	   {
		 actual[7]=pp.validateSetDTS();
		 for(int i=0;i<=2;i++)
		 {
		 bp.waitForElement();
		 }
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

	@When("^launch the External jira page$")
	public void launch_the_External_jira_page() throws Throwable {
	try
	   {
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[8]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^Change permission to project permission$")
	public void change_permission_to_project_permission() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,67);
		 bp.waitForElement();
		 //actual[9]=ejp.defectProjectSettings(projectName);
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 ejp.launchJiraAdministration(issueType);
		 actual[9]=ejp.selectProjectAdministration(projectName);
		 actual[10]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 //driver.navigate().refresh();
		 ejp.closeNotificationMsg();
		 actual[11]=ejp.logOutFromExternal_JIRA();
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

	@When("^As a Lead,Launch the Defect tracking page$")
	public void as_a_Lead_Launch_the_Defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     actual[12]=lp.enterUname(Uname);
	     actual[13]=lp.enterPass(Pass);
	     actual[14]=lp.clickOnLogin();
		 actual[15]=pp.selectProject(projectName);
		 actual[16]=pp.selectRelease(releaseName);
		 actual[17]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to Launch Defect Tracking page$")
	public void should_be_able_to_Launch_Defect_Tracking_page() throws Throwable {
	try
	   {
		 actual[18]=dt.validateDefectTrackingPage();
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

	@When("^Set the defect user who doesn't have create defect permission$")
	public void set_the_defect_user_who_doesn_t_have_create_defect_permission() throws Throwable {
	try
	   {
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
		 actual[19]=req.dtsLoginDetail(jiraUname,jiraPwd,jiraPwd);
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

	@When("^Attempt to create defect in defect tracking app$")
	public void attempt_to_create_defect_in_defect_tracking_app() throws Throwable {
	try
	   {
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		    actual[20]=dt.createDefect(project, issuetype);
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

	@Then("^Should get a proper message 'user doesn't have permission to create defect'$")
	public void should_get_a_proper_message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 actual[21]=dt.validateErrorMsg();
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

	@When("^Create a subtask in defect tracking app$")
	public void create_a_subtask_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
		 actual[22]=dt.searchDefect(defectID);
//		 actual[23]=dt.selectAllDefects();
//		 actual[24]=dt.defectsOperation(defectValue);
//		 actual[25]=dt.createDefectSubtask(issuetype);
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

	@Then("^Should get a proper Message 'user doesn't have permission to create defect'$")
	public void should_get_a_proper_Message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 actual[23]=dt.validateErrorMsg();
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

	@When("^Launch the Test Execution page$")
	public void launch_the_Test_Execution_page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[24]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    bp.waitForElement();
			actual[25]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[26]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[27]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^attempt to Create defect in test execution app$")
	public void attempt_to_Create_defect_in_test_execution_app() throws Throwable {
	try
	   {
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   bp.waitForElement();
		   actual[28]=dt.createDefect(project, issuetype);
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

	@Then("^Should get the proper message 'user doesn't have permission to create defect'$")
	public void should_get_the_proper_message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
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

	@When("^create a Subtask in test execution app$")
	public void create_a_Subtask_in_test_execution_app() throws Throwable {
	try
	   {
		 int testCase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 ); 
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 actual[30]=exep.clickOnDefectButton(testCase1);
		 actual[31]=exep.defectSearch(selectSearch,defectID);
//		 actual[35]=exep.clickOnSubtask();
//		 actual[36]=dt.createDefectSubtask(issuetype);
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

	@Then("^should get a proper message that'user doesn't have permission to create defect'$")
	public void should_get_a_proper_message_that_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[32]=dt.validateErrorMsg();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[33]=tp.doubleClickOnCycle(releaseName);
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
