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

public class Defect_Tracking_JiraPermission_79 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_79";
	
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
	 public String defectID1;
	 public String defectID2;
	@Given("^User Is in the External Jira page$")
	public void user_Is_in_the_External_Jira_page() throws Throwable {
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
		 String Uname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
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

	@When("^navigate to the projects page$")
	public void navigate_to_the_projects_page() throws Throwable {
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

	@When("^Change permission to No Assign Issue$")
	public void change_permission_to_No_Assign_Issue() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,67);
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.selectProjectAdministration(projectName);
		 actual[3]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 //driver.navigate().refresh();
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

	@When("^As a Manager,Launch the Administration page$")
	public void as_a_Manager_Launch_the_Administration_page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[5]=lp.enterUname(Uname);
	     actual[6]=lp.enterPass(Pass);
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

	@When("^launch the Defect Tracking to set the DTS$")
	public void launch_the_Defect_Tracking_to_set_the_DTS() throws Throwable {
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

	@When("^Set a DTS To the JIRA$")
	public void set_a_DTS_To_the_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String Uname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);  
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
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

	@Then("^Should Be able to Set a DTS to JIRA$")
	public void should_Be_able_to_Set_a_DTS_to_JIRA() throws Throwable {
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

	@When("^As a Lead,Launch The Defect Tracking Page$")
	public void as_a_Lead_Launch_The_Defect_Tracking_Page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     //driver.navigate().to(zephyr_Url);
	     actual[15]=lp.enterUname(Uname);
	     actual[16]=lp.enterPass(Pass);
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

	@Then("^Should Be Able to Launch Defect Tracking page$")
	public void should_Be_Able_to_Launch_Defect_Tracking_page() throws Throwable {
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

	@When("^Set the Defect user who doesn't have assign issue permission$")
	public void set_the_Defect_user_who_doesn_t_have_assign_issue_permission() throws Throwable {
	try
	   {
		 String Username=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);  
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[22]=req.dtsLoginDetail(Username,Pwd,Pwd);
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

	@When("^Create a defect in defect tracking app$")
	public void create_a_defect_in_defect_tracking_app() throws Throwable {
	try
	   {
			actual[23]=dt.createDefect(project,defectIssueType);
			actual[24]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[25]=dt.saveDefect();
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

	@Then("^Should be able to create a Defect$")
	public void should_be_able_to_create_a_Defect() throws Throwable {
	try
	  {
		 defectID1=dt.retrieveDefectId();
		 actual[26]=dt.validateDefect(project,defectIssueType);
		 bp.waitForElement();
		 actual[27]=dt.updateDefect();
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

	@When("^Create a Subtask in defect Tracking app$")
	public void create_a_Subtask_in_defect_Tracking_app() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
		 actual[28]=dt.searchDefect(defectID1);
		 dt.selectAllDefects();
		 actual[29]=dt.defectsOperation(defectValue);
		 actual[30]=dt.createDefectSubtask(defectSubtaskIssueType);
		 actual[31]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		 actual[32]=dt.saveDefect();
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

	@Then("^Should be able to Create a defect subtask in DT$")
	public void should_be_able_to_Create_a_defect_subtask_in_DT() throws Throwable {
	try
	  {
		 actual[33]=dt.validateDefect(project,defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[34]=dt.updateDefect();
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

	@When("^Launch the TestExecution Page$")
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

	@When("^Create defect in Test execution app$")
	public void create_defect_in_Test_execution_app() throws Throwable {
	try
	   {
			actual[39]=dt.createDefect(project,defectIssueType);
			actual[40]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[41]=dt.saveDefect();
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

	@Then("^Should be Able to create a defect in Execution page$")
	public void should_be_Able_to_create_a_defect_in_Execution_page() throws Throwable {
	try
	  {
		 defectID2=exep.retrieveDefectId();
		 actual[42]=dt.validateDefect(project,defectIssueType);
		 bp.waitForElement();
		 actual[43]=dt.updateDefect();
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

	@When("^Create a Subtask in Test execution app$")
	public void create_a_Subtask_in_Test_execution_app() throws Throwable {
	try
	  {
		actual[44]=exep.searchDefect(defectID2);
		actual[45]=exep.clickOnSubtask();
		actual[46]=dt.createDefectSubtask(defectSubtaskIssueType);
		actual[47]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
	    actual[48]=dt.saveDefect();
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

	@Then("^should be able to create a defect subtask test in execution page$")
	public void should_be_able_to_create_a_defect_subtask_test_in_execution_page() throws Throwable {
	try
	  {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[49]=dt.validateDefect(project,defectSubtaskIssueType);
		 actual[50]=dt.updateDefect();
		 bp.waitForElement();
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
