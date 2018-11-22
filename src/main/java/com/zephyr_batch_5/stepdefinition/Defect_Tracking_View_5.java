package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Defect_Tracking_View_5 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	LoginPage lp;
	DefectTracking dt;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_View_5";
	
	boolean[] actual=new boolean[14];
	SoftAssert soft=new SoftAssert();
	
	String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
	String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
	String Hide=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,23));
	String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7,22);
	String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,21));
	String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,26));
	String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12,25);
	String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,24));
	String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
 	String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	
 	



 	
 	
//	@Given("^Login as manager role credential$")
//	public void login_as_manager_role_credential() throws Throwable {
//	try
//    {	 
//		 pp=new ProjectPage(driver);
//		 rp=new ReleasePage(driver);
//		 lp=new LoginPage(driver);
//		 ejp=new ExternalJiraPage(driver);
//		 bp=new BasePage();
//	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
//	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
//	     pp.clickOnLogout();
//	     lp.enterUname(manager_Uname);
//	     lp.enterPass(manager_Pass);
//	     bp.waitForElement();
//	     lp.clickOnLogin();
//    }
//	catch(Exception e)
//	{
//	   lb=new LaunchBrowser();
//	   lb.getScreenShot(fileName);
//	   e.printStackTrace();
//	   driver.close();
//      	Relogin_TPE rl=new Relogin_TPE();
//      	rl.reLogin();
//      	throw e;
//	}                  
//	}

	@When("^user navigate to project setup page$")
	public void user_navigate_to_project_setup_page() throws Throwable {
	try
    {	 
	     actual[0]=pp.launchAdministration();
		 actual[1]=pp.launchManageprojects();
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

	@When("^map the external defect project to zephyr project and save it$")
	public void map_the_external_defect_project_to_zephyr_project_and_save_it() throws Throwable {
	try
	   {
		 String jiraProjectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Project_1");
		 actual[2]=pp.selectProjectInProjectSetup(project1);
		 actual[3]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^external defect project should be mapped to zephyr project$")
	public void external_defect_project_should_be_mapped_to_zephyr_project() throws Throwable {
	try
	   {
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[4]=ejp.loginToExternalJira(jiraUname,jiraPwd);
	     ejp.closeNotificationMsg();
		 actual[5]=ejp.viewActivityStream();
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

	@When("^user launch release setup page$")
	public void user_launch_release_setup_page() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	bp.waitForElement();
    	driver.navigate().to(zephyr_Url);
    	pp.selectProject(project1);
    	actual[6]=rp.clickOnManageRelease();
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

	@When("^create a new release when zephyr project is mapped to jira project$")
	public void create_a_new_release_when_zephyr_project_is_mapped_to_jira_project() throws Throwable {
	try
    {
		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_13");
		boolean res1=rp.checkAvailableRelease(release);
		if(res1==false)
		{
    	rp.addNewRelease(release, Desc, Hide, MapexternalDefect);
		rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
		rp.clickOnAdd();
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

	@Then("^Should be able to view activity stream in posted in jira$")
	public void should_be_able_to_view_activity_stream_in_posted_in_jira() throws Throwable {
	try
	   {
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[7]=ejp.closeNotificationMsg();
		 actual[8]=ejp.viewActivityStream();
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

	@When("^Create a release when zephyr project is not mapped to jira project$")
	public void create_a_release_when_zephyr_project_is_not_mapped_to_jira_project() throws Throwable {
	try
	   {
		 driver.navigate().to(zephyr_Url);
		 bp.waitForElement();
		 actual[9]=pp.launchAdministration();
		 actual[10]=pp.launchManageprojects();
		 actual[11]=pp.selectProjectInProjectSetup(project2);
		 bp.waitForElement();
		 driver.findElement(By.xpath("((//label[@for='project-externalSystem'])/..//div)[2]")).click();
		 bp.waitForElement();
		 driver.findElement(By.xpath("((//label[@for='project-externalSystem'])/..//div)[2]")).click();
		 bp.waitForElement();
		 pp.backToProjectPage();
		 pp.selectProject(project2);
		 rp.clickOnManageRelease();
		 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_14");
			boolean res1=rp.checkAvailableRelease(release);
			if(res1==false)
			{
	    	rp.addNewRelease(release, Desc, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
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

	@Then("^Should not be able to view activity stream in posted in jira$")
	public void should_not_be_able_to_view_activity_stream_in_posted_in_jira() throws Throwable {
	try
	   {
//		     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//		     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     //actual[4]=ejp.loginToExternalJira(jiraUname,jiraPwd);
	     actual[12]=ejp.closeNotificationMsg();
		 actual[13]=ejp.viewActivityStream();
		 
		 driver.navigate().refresh();
		 ejp.logOutFromExternal_JIRA();
		 driver.navigate().to(zephyr_Url);
		// pp.clickOnLogout();
		 
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
