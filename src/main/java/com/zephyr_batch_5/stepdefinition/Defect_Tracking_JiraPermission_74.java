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

public class Defect_Tracking_JiraPermission_74 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_74";
	
	boolean[] actual=new boolean[41];
	SoftAssert soft=new SoftAssert();
	
	@Given("^As a manager,Launch Administration page$")
	public void as_a_manager_Launch_Administration_page() throws Throwable {
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
		 tp=new TestPlanningPage(driver);
		 exep=new ExecutionPage(driver);
		 pp.clickOnLogout();
		 lp=new LoginPage(driver);
	 	 
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     actual[0]=lp.enterUname(manager_Uname);
	     actual[1]=lp.enterPass(manager_Pass);
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

	@When("^launch the Defect tracking system$")
	public void launch_the_Defect_tracking_system() throws Throwable {
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

	@When("^Set the DTS tO JIRA$")
	public void set_the_DTS_tO_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
		 actual[5]=pp.clickOnDefectTracking();
		 actual[6]=ccfp.editDTS(DTS,jira_Url,Uname,Pwd);
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

	@Then("^Should be able to set the DTS To JIRA$")
	public void should_be_able_to_set_the_DTS_To_JIRA() throws Throwable {
	try
	   {
		 actual[7]=pp.validateSetDTS();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[8]=pp.launchDefectAdmin();
		 actual[9]=pp.clearCache();
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

	@When("^launch the external jira page$")
	public void launch_the_external_jira_page() throws Throwable {
	try
	   {
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[10]=ejp.loginToExternalJira(Uname,Pwd);
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

	@When("^change permission to project permission$")
	public void change_permission_to_project_permission() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,67);
		 //actual[11]=ejp.defectProjectSettings(projectName);
		 actual[11]=ejp.launchJiraAdministration(issueType);
		 actual[12]=ejp.selectProjectAdministration(projectName);
		 actual[13]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 driver.navigate().refresh();
		 ejp.closeNotificationMsg();
		 actual[14]=ejp.logOutFromExternal_JIRA();
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

	@When("^As a Lead,Launch Defect tracking page$")
	public void as_a_Lead_Launch_Defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
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

	@Then("^Should be able to launch Defect Tracking Page$")
	public void should_be_able_to_launch_Defect_Tracking_Page() throws Throwable {
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

	@When("^reset the external DTS login detail$")
	public void reset_the_external_DTS_login_detail() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
	     req=new RequirementsPage(driver);
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

	@When("^search a defect by ID Defect tracking app$")
	public void search_a_defect_by_ID_Defect_tracking_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 bp.waitForElement();
		 actual[23]=dt.searchDefect(defectID);
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

	@Then("^Should get proper message 'user doesn't have browser permission for this project' using ID$")
	public void should_get_proper_message_user_doesn_t_have_browser_permission_for_this_project_using_ID() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,42);
		 actual[24]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^search a defect by JQL in DT App$")
	public void search_a_defect_by_JQL_in_DT_App() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,10);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 actual[25]=dt.clickOnDefectAdvancedSearchButton();
		 for(int i=0;i<=5;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[23]=dt.defectAdvancedSearch(selectSearch,defectID);
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

	@Then("^Should get proper message 'user doesn't have browser permission for this project' using JQL$")
	public void should_get_proper_message_user_doesn_t_have_browser_permission_for_this_project_using_JQL() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,42);
		 actual[26]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^search a defect by filter in DT App$")
	public void search_a_defect_by_filter_in_DT_App() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,38);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 bp.waitForElement();
		 actual[27]=dt.defectAdvancedSearch(selectSearch,defectID);
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

	@Then("^Should get proper message 'user doesn't have browser permission for this project' using MyFilter$")
	public void should_get_proper_message_user_doesn_t_have_browser_permission_for_this_project_using_MyFilter() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,42);
		 actual[28]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^launch the test_execution page$")
	public void launch_the_test_execution_page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[29]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    bp.waitForElement();
			actual[30]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
		 int[] tcNo1=new int[1];
		 tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
	     String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	     bp.waitForElement();
	     exep=new ExecutionPage(driver);
	     actual[31]=exep.executeStatus(tcNo1[0], statusType1);
	     actual[32]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^search a defect by ID using test execution app$")
	public void search_a_defect_by_ID_using_test_execution_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 bp.waitForElement();
		 actual[33]=exep.defectSearch(selectSearch,defectID);
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

	@Then("^Should get proper message 'user doesn't have browser permission for this project' using ID in test execution$")
	public void should_get_proper_message_user_doesn_t_have_browser_permission_for_this_project_using_ID_in_test_execution() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,42);
		 actual[34]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^search a defect by JQL in test execution App$")
	public void search_a_defect_by_JQL_in_test_execution_App() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,10);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 bp.waitForElement();
		 actual[35]=exep.defectSearch(selectSearch,defectID);
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

	@Then("^Should get proper message 'user doesn't have browser permission for this project' using JQL in test execution$")
	public void should_get_proper_message_user_doesn_t_have_browser_permission_for_this_project_using_JQL_in_test_execution() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,42);
		 actual[36]=dt.viewDefectIssueMsg(filterValue);
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

	@When("^search a defect by filter in test execution App$")
	public void search_a_defect_by_filter_in_test_execution_App() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,38);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 bp.waitForElement();
		 actual[37]=exep.defectSearch(selectSearch,defectID);
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

	@Then("^Should get proper message 'user doesn't have browser permission for this project' using MyFilter in test execution$")
	public void should_get_proper_message_user_doesn_t_have_browser_permission_for_this_project_using_MyFilter_in_test_execution() throws Throwable {
	try
	   {
//		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
//		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,42);
		 actual[38]=dt.viewDefectIssueMsg(filterValue);
//		 actual[34]=exep.validateSearchedDefect(defectType, defectValue);
		 actual[39]=exep.clickOnCancelDefectWindow();
		 actual[40]=tp.doubleClickOnCycle(releaseName);
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
