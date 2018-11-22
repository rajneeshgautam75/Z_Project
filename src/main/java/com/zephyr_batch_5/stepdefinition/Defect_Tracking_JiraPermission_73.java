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

public class Defect_Tracking_JiraPermission_73 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_73";
	
	boolean[] actual=new boolean[35];
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
	@Given("^As a manager,Launch administration$")
	public void as_a_manager_Launch_administration() throws Throwable {
	try
    {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 ccfp=new CreateCustomFieldsPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 tp=new TestPlanningPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 req=new RequirementsPage(driver);
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

	@When("^launch defect tracking system$")
	public void launch_defect_tracking_system() throws Throwable {
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

	@When("^Set the DTS to JIRA$")
	public void set_the_DTS_to_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
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

	@Then("^Should be able to set DTS to JIRA$")
	public void should_be_able_to_set_DTS_to_JIRA() throws Throwable {
	try
	   {
		 actual[7]=pp.validateSetDTS();
		 for(int i=1;i<=3;i++)
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

	@When("^As a Lead,Launch defect tracking page$")
	public void as_a_Lead_Launch_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     //driver.navigate().to(zephyr_Url);
	     actual[8]=lp.enterUname(Uname);
	     actual[9]=lp.enterPass(Pass);
	     actual[10]=lp.clickOnLogin();
		 actual[11]=pp.selectProject(projectName);
		 actual[12]=pp.selectRelease(releaseName);
		 actual[13]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to launch Defect Tracking page$")
	public void should_be_able_to_launch_Defect_Tracking_page() throws Throwable {
	try
	   {
		 actual[14]=dt.validateDefectTrackingPage();
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

	@When("^set the defect user who doesn't have create defect permission$")
	public void set_the_defect_user_who_doesn_t_have_create_defect_permission() throws Throwable {
	try
	   {
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
		 actual[15]=req.dtsLoginDetail(jiraUname,jiraPwd,jiraPwd);
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

	@When("^attempt to create defect in defect tracking app$")
	public void attempt_to_create_defect_in_defect_tracking_app() throws Throwable {
	try
	   {
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    actual[16]=dt.createDefect(project, issuetype);
//			actual[17]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
//		    actual[18]=dt.saveDefect();
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

	@Then("^Should get proper message 'user doesn't have permission to create defect'$")
	public void should_get_proper_message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 actual[17]=dt.validateErrorMsg();
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

	@When("^create a subtask in defect tracking app$")
	public void create_a_subtask_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
		 actual[18]=dt.searchDefect(defectID);
		 actual[19]=dt.selectAllDefects();
		 actual[20]=dt.defectsOperation(defectValue);
		 actual[21]=dt.createDefectSubtask(issuetype);
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

	@Then("^should get the proper Message 'user doesn't have permission to create defect'$")
	public void should_get_the_proper_Message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,42);
		 actual[22]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^launch the Test Execution page$")
	public void launch_the_Test_Execution_page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[23]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    bp.waitForElement();
			actual[24]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[25]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[26]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^attempt to create defect in test execution app$")
	public void attempt_to_create_defect_in_test_execution_app() throws Throwable {
	try
	   {
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   bp.waitForElement();
		    actual[27]=dt.createDefect(project, issuetype);
//			actual[30]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
//			actual[31]=dt.saveDefect();
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

	@Then("^should get the proper message 'user doesn't have permission to create defect'$")
	public void should_get_the_proper_message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,42);
		 actual[28]=dt.validateErrorMsg();
		 //actual[33]=dt.clickOnCancelFileNewDefectButton();
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

	@When("^create a subtask in test execution app$")
	public void create_a_subtask_in_test_execution_app() throws Throwable {
	try
	   {
		 int testCase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 ); 
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 actual[29]=exep.clickOnDefectButton(testCase1);
		 actual[30]=exep.defectSearch(selectSearch,defectID);
		 actual[31]=exep.clickOnSubtask();
		 actual[32]=dt.createDefectSubtask(issuetype);
//		 actual[37]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
//		 actual[38]=dt.saveDefect();
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

	@Then("^should get proper Message 'user doesn't have permission to create defect'$")
	public void should_get_proper_Message_user_doesn_t_have_permission_to_create_defect() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[33]=dt.validateErrorMsg();
		 //actual[36]=dt.clickOnCancelFileNewDefectButton();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
		 //actual[41]=exep.clickOnCancelDefectWindow();
		 bp.waitForElement();
		 actual[34]=tp.doubleClickOnCycle(releaseName);
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
