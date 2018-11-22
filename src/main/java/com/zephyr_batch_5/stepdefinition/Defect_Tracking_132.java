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

public class Defect_Tracking_132 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_132";
	
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Project page$")
	public void user_is_in_the_Project_page() throws Throwable {
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

	@When("^User navigate to the external jira page$")
	public void user_navigate_to_the_external_jira_page() throws Throwable {
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

	@When("^navigate to the project page and edit the project Name$")
	public void navigate_to_the_project_page_and_edit_the_project_Name() throws Throwable {
	try
	   {
		    String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,15);
		    String projectVariable=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,15);
		    String newProjectName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,15);
		    actual[2]=ejp.selectExternalJiraProject(projectVariable);
		    actual[3]=ejp.searchExternalJiraProject(projectName);
		    actual[4]=ejp.editProjectDetails(newProjectName);
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

	@Then("^Should be able to edit the existing projectName$")
	public void should_be_able_to_edit_the_existing_projectName() throws Throwable {
	try
	   {
		 String projectValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,15);
		 actual[5]=ejp.validateEditedProjectValue(projectValue);
		 ejp.logOutFromExternal_JIRA();
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

	@When("^As a Manager,Launch defect admin page$")
	public void as_a_Manager_Launch_defect_admin_page() throws Throwable {
	try
    {	 
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     actual[6]=lp.enterUname(manager_Uname);
	     actual[7]=lp.enterPass(manager_Pass);
	     actual[8]=lp.clickOnLogin();
		 bp.waitForElement();
		 actual[9]=pp.launchAdministration();
		 actual[10]=pp.launchDefectAdmin();
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

	@Then("^Should be able to launch defect admin$")
	public void should_be_able_to_launch_defect_admin() throws Throwable {
	try
	   {
		 actual[11]=pp.validateDefectAdmin();
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

	@When("^clear the cache of an online project$")
	public void clear_the_cache_of_an_online_project() throws Throwable {
	try
	   {
		 actual[12]=pp.clearCache();
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

	@Then("^Should be able to clear the Cache$")
	public void should_be_able_to_clear_the_Cache() throws Throwable {
	try
	   {
		 actual[13]=dt.validateSuccessMsg();
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

	@When("^launch the defect tracking page$")
	public void launch_the_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(lead_Uname);
	     lp.enterPass(lead_Pass);
	     lp.clickOnLogin();
		 actual[14]=pp.selectProject(projectName);
		 actual[15]=pp.selectRelease(releaseName);
		 actual[16]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to Launch Defect tracking page$")
	public void should_be_able_to_Launch_Defect_tracking_page() throws Throwable {
	try
	   {
		 actual[17]=dt.validateDefectTrackingPage();
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

	@When("^create a defect with edited projectName$")
	public void create_a_defect_with_edited_projectName() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
            String project=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,15);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[18]=dt.createDefect(project, issuetype);
			actual[19]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[20]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with edited projectName$")
	public void should_be_able_to_create_a_defect_with_edited_projectName() throws Throwable {
	try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[21]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[22]=dt.updateDefect();
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
