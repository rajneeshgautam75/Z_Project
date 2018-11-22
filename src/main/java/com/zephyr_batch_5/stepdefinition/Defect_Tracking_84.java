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

public class Defect_Tracking_84 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_84";
	
	boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();
	public String defectID;
	String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
	String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
 	String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	
	@Given("^user is in the project page$")
	public void user_is_in_the_project_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 ejp=new ExternalJiraPage(driver);
		 dt=new DefectTracking(driver);
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

	@When("^user is in the DefectTracking page$")
	public void user_is_in_the_DefectTracking_page() throws Throwable {
	try
	   {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnDefectTracking();
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

	@When("^user create a defect with minimum required fields$")
	public void user_create_a_defect_with_minimum_required_fields() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[3]=dt.createDefect(project, issuetype);
			actual[4]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[5]=dt.saveDefect();
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

	@Then("^Should be able to create the defect$")
	public void should_be_able_to_create_the_defect() throws Throwable {
	try
	  {
		 defectID=dt.retrieveDefectId();
		 actual[6]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[7]=dt.updateDefect();
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

	@When("^user navigate to the external jira page$")
	public void user_navigate_to_the_external_jira_page() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[8]=ejp.loginToExternalJira(Uname,Pwd); 
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

	@Then("^Should be able to view activity stream$")
	public void should_be_able_to_view_activity_stream() throws Throwable {
	try
	   {
		 actual[9]=ejp.viewActivityStream();  
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

	@When("^create a subtask in defect tracking page$")
	public void create_a_subtask_in_defect_tracking_page() throws Throwable {
	try
	  {
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
		 String subtask_IssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		// driver.navigate().to(zephyr_Url);
		 driver.navigate().back();
		 for(int i=0;i<=3;i++)
		 {
		 bp.waitForElement();
		 }
		 rp.clickOnDefectTracking();
		 actual[10]=dt.searchDefect(defectID);
		 actual[11]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[12]=dt.defectsOperation(defectValue);
		 dt.createDefectSubtask(subtask_IssueType);
		 String[] fields=new String[11];
         for(int i=0;i<=10;i++)
         {
         	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
         }
		 actual[13]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		 actual[14]=dt.saveDefect();
		 actual[15]=dt.updateDefect();
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

	@When("^navigate to the external jira page$")
	public void navigate_to_the_external_jira_page() throws Throwable {
	try
	   {
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     //actual[4]=ejp.loginToExternalJira(Uname,Pwd);
		
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
	
	@Then("^Should be able to view the activity stream$")
	public void should_be_able_to_view_the_activity_stream() throws Throwable {
	try
	   {
		 actual[16]=ejp.viewActivityStream();
		 driver.navigate().refresh();
		 actual[17]=ejp.logOutFromExternal_JIRA();
		 driver.navigate().to(zephyr_Url);
		 pp.clickOnLogout();
		 
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
