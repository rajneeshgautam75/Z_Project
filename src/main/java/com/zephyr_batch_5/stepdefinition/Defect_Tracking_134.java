package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_134 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_134";
	
	boolean[] actual=new boolean[24];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the project_page$")
	public void user_is_in_the_project_page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 lp=new LoginPage(driver);
		 dt=new DefectTracking(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
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

	@When("^User navigate to an External Jira page$")
	public void user_navigate_to_an_External_Jira_page() throws Throwable {
	try
	{
		 ejp=new ExternalJiraPage(driver);
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[1]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^User navigate to the priority page$")
	public void user_navigate_to_the_priority_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 String oldValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,6);
		 String optionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,52);
		 String newValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,6);
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.launchJiraAdministration(issueType);
		 actual[3]=ejp.enterAdministratorAccessPassword(jiraPwd);
		 actual[4]=ejp.editPriorityValue(oldValue, optionValue, newValue);
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

	@Then("^Should be able to edit the priority value$")
	public void should_be_able_to_edit_the_priority_value() throws Throwable {
	try
	   {
		 String defectValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,6);
		 actual[5]=ejp.validateEditedCustomFieldValue(defectValue);
		 actual[6]=ejp.logOutFromExternal_JIRA();
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

	@When("^Manager launch the Defect Admin page$")
	public void manager_launch_the_Defect_Admin_page() throws Throwable {
	try
    {	 
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     actual[7]=lp.enterUname(Uname);
	     actual[8]=lp.enterPass(Pass);
	     actual[9]=lp.clickOnLogin();
		 bp.waitForElement();
		 actual[10]=pp.launchAdministration();
		 actual[11]=pp.launchDefectAdmin();
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

	@Then("^Should be able to launch Defect Admin$")
	public void should_be_able_to_launch_Defect_Admin() throws Throwable {
	try
	   {
		 actual[12]=pp.validateDefectAdmin();
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

	@When("^clear the cache of a online project$")
	public void clear_the_cache_of_a_online_project() throws Throwable {
	try
	   {
		 actual[13]=pp.clearCache();
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

	@Then("^Should clear the cache$")
	public void should_clear_the_cache() throws Throwable {
	try
	   {
		 actual[14]=dt.validateSuccessMsg();
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

	@When("^launch DefectTracking page$")
	public void launch_DefectTracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
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

	@Then("^Should be able to launch DT page$")
	public void should_be_able_to_launch_DT_page() throws Throwable {
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

	@When("^create a defect with edited priority value$")
	public void create_a_defect_with_edited_priority_value() throws Throwable {
	try
	   {
            String[] fields=new String[10];
            for(int i=0;i<=9;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String priority=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,6);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[19]=dt.createDefect(project, issuetype);
			actual[20]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],priority,fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
		    actual[21]=dt.saveDefect();
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

	@Then("^Should be able to create defect with edited priority value$")
	public void should_be_able_to_create_defect_with_edited_priority_value() throws Throwable {
	try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[22]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[23]=dt.updateDefect();
		 bp.waitForElement();
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
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;  
		}     
	}
}
