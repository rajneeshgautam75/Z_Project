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

public class Defect_Tracking_JiraPermission_70 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_JiraPermission_70";
	
	boolean[] actual=new boolean[42];
	SoftAssert soft=new SoftAssert();
	String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	@Given("^As a manager,launch project page$")
	public void as_a_manager_launch_project_page() throws Throwable {
	try
    {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 ccfp=new CreateCustomFieldsPage(driver);
		 req=new RequirementsPage(driver);
		 tr=new TestRepositoryPage(driver);
		 exep=new ExecutionPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 rp=new ReleasePage(driver);
		 pp.clickOnLogout();
		 lp=new LoginPage(driver);
	 	 
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     actual[0]=lp.enterUname(manager_Uname);
	     actual[1]=lp.enterPass(manager_Pass);
	     actual[2]=lp.clickOnLogin();
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

	@When("^user in the administration page$")
	public void user_in_the_administration_page() throws Throwable {
	try
    {
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
	
	@When("^set the DTS to JIRA$")
	public void set_the_DTS_to_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_5");
		 actual[4]=pp.clickOnDefectTracking();
		 actual[5]=ccfp.editDTS(DTS,jira_Url,jiraUname,jiraPwd);
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

	@Then("^Should be able to Set the DTS$")
	public void should_be_able_to_Set_the_DTS() throws Throwable {
	try
	   {
		 actual[6]=pp.validateSetDTS();
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

	@When("^User is in the Defect tracking page$")
	public void user_is_in_the_Defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     actual[7]=lp.enterUname(lead_Uname);
	     actual[8]=lp.enterPass(lead_Pass);
	     actual[9]=lp.clickOnLogin();
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[10]=pp.clickOnDefectTracking();
		 driver.navigate().refresh();
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

	@Then("^Should be able to launch defect tracking page$")
	public void should_be_able_to_launch_defect_tracking_page() throws Throwable {
	try
	   {
		 actual[11]=dt.validateDefectTrackingPage();
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

	@When("^login as defect user and reset DTS$")
	public void login_as_defect_user_and_reset_DTS() throws Throwable {
	try
	   {
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_5");
		 actual[12]=req.dtsLoginDetail(jiraUname,jiraPwd,jiraPwd);
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

	@Then("^Should be able to login successfully$")
	public void should_be_able_to_login_successfully() throws Throwable {
	try
	   {
		 actual[13]=dt.validateDefectTrackingPage();
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

	@When("^User is in a external jira page$")
	public void user_is_in_a_external_jira_page() throws Throwable {
	try
	{
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_5");
	     bp.waitForElement();
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[14]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^User navigate to the user management page$")
	public void user_navigate_to_the_user_management_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,40);
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_5");
		 ejp.closeNotificationMsg();
		 ejp.closeNotificationMsg();
		 actual[15]=ejp.launchJiraAdministration(issueType);
		 ejp.closeNotificationMsg();
		 actual[16]=ejp.enterAdministratorAccessPassword(jiraPwd);
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

	@When("^edit the change the user name$")
	public void edit_the_change_the_user_name() throws Throwable {
	try
	   {
		 String newName=UNIQUE+Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
		 String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
		 String fullName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,66);
		 String emailId=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,65);
		 actual[17]=ejp.filterUser(uName);
		 actual[18]=ejp.editUser(newName,fullName, emailId);
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

	@Then("^Should be able to change the user name$")
	public void should_be_able_to_change_the_user_name() throws Throwable {
	try
	   {
		 String uName=UNIQUE+Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
		 ejp.closeNotificationMsg();
		 actual[19]=ejp.validateUsername(uName);
		 actual[20]=ejp.logOutFromExternal_JIRA();
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
	
	@When("^relogin to Zephyr page$")
	public void relogin_to_Zephyr_page() throws Throwable {
	try
	   {
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[21]=lp.enterUname(lead_Uname);
	     actual[22]=lp.enterPass(lead_Pass);
	     actual[23]=lp.clickOnLogin();
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

	@Then("^Should be able to re-login successfully$")
	public void should_be_able_to_re_login_successfully() throws Throwable {
	try
	   {
		 actual[24]=lp.verifyLoginTitle();
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

	@When("^launch defect Tracking page$")
	public void launch_defect_Tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 bp.waitForElement();
		 actual[25]=pp.selectProject(projectName);
		 actual[26]=pp.selectRelease(releaseName);
		 actual[27]=rp.clickOnDefectTracking();
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

	@Then("^should get message \"Authentication failed for defect user admin\\. Please refresh the page and try again\\.If your defect user credentials changed,use Reset User button to enter the new credentials\\.$")
	public void should_get_message_Authentication_failed_for_defect_user_admin_Please_refresh_the_page_and_try_again_If_your_defect_user_credentials_changed_use_Reset_User_button_to_enter_the_new_credentials() throws Throwable {
	try
	{
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5");  
		 String defectMsg1=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",3,42); 
		 String defectMsg2=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",4,42); 
		 String defectMsg=defectMsg1+jiraUname+defectMsg2;
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_5");
		 actual[28]=req.dtsLoginDetail(jiraUname,jiraPwd,jiraPwd);
		 actual[29]=dt.viewDefectIssueMsg(defectMsg);
		 driver.navigate().refresh();
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

	@When("^launch test execution page to execute testcase$")
	public void launch_test_execution_page_to_execute_testcase() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[30]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    bp.waitForElement();
			actual[31]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[32]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^click on D button of a testcase$")
	public void click_on_D_button_of_a_testcase() throws Throwable {
	try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		   actual[33]=exep.clickOnDefectButton(testcase1);
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

	@Then("^Should get message \"authentication failed for defect user admin\\.Please refresh the page and try again\\. If your defect user credentials changed,use Reset User button to enter the new credentials\\.$")
	public void should_get_message_authentication_failed_for_defect_user_admin_Please_refresh_the_page_and_try_again_If_your_defect_user_credentials_changed_use_Reset_User_button_to_enter_the_new_credentials() throws Throwable {
	try
	{
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5");  
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_5");
		 String defectMsg1=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",3,42); 
		 String defectMsg2=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",4,42); 
		 String defectMsg=defectMsg1+Uname+defectMsg2;
		 actual[34]=exep.dtsLoginDetail(Uname,Pwd,Pwd);
		 actual[35]=dt.viewDefectIssueMsg(defectMsg);
		 driver.navigate().refresh();
		 for(int i=0;i<=2;i++)
		 {
			 bp.waitForElement();
		 }
		 //pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String newUName=UNIQUE+Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
	     String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_5"); 
	     String fullName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,66);
		 String emailId=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,65);
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,40);
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[36]=ejp.loginToExternalJira(newUName,Pwd);
		 actual[37]=ejp.launchJiraAdministration(issueType);
		 actual[38]=ejp.enterAdministratorAccessPassword(Pwd);
		 actual[39]=ejp.filterUser(uName);
		 actual[40]=ejp.editUser(uName,fullName, emailId);
		 actual[41]=ejp.logOutFromExternal_JIRA();
		 driver.navigate().to(zephyr_Url);
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
