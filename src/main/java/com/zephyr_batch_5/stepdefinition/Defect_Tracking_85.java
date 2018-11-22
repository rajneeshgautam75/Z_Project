package com.zephyr_batch_5.stepdefinition;

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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_85 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_85";
	
	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
	public String defectID;
	String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
	String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
 	String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	@Given("^User in TestExecution page$")
	public void user_in_TestExecution_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 dt=new DefectTracking(driver);
		 rp=new ReleasePage(driver);
		 lp=new LoginPage(driver);
		 tr=new TestRepositoryPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     actual[8]=lp.enterPass(Pass);
	     actual[9]=lp.clickOnLogin();
		 actual[0]=pp.selectProject(projectName);
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnTestExecution();
		 String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[3]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[4]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^User click on D button to create a defect$")
	public void user_click_on_D_button_to_create_a_defect() throws Throwable {
	try
	   {
        int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
        actual[5]=exep.clickOnDefectButton(tcNo1[0]);
		actual[6]=dt.createDefect(project, issuetype);
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

	@When("^Create a defect With minimum required fields$")
	public void create_a_defect_With_minimum_required_fields() throws Throwable {
	try
	   {
		String[] fields=new String[11];
        for(int i=0;i<=10;i++)
        {
        	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
        }
		actual[7]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		actual[8]=dt.saveDefect();
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

	@Then("^Should be able to create a defect in test execution$")
	public void should_be_able_to_create_a_defect_in_test_execution() throws Throwable {
	try
	   {
            defectID=exep.retrieveDefectId();     
		    actual[9]=dt.validateDefect(project, issuetype);
		    actual[10]=dt.updateDefect();
		    actual[11]=exep.clickOnCancelDefectWindow();
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

	@When("^User navigate to the ExternalJira page$")
	public void user_navigate_to_the_ExternalJira_page() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[12]=ejp.loginToExternalJira(Uname,Pwd); 
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

	@Then("^Should be able to view activity stream in JIRA$")
	public void should_be_able_to_view_activity_stream_in_JIRA() throws Throwable {
	try
	   {
		 actual[13]=ejp.viewActivityStream();  
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

	@When("^User navigate to the execution page to create a subtask in test execution$")
	public void user_navigate_to_the_execution_page_to_create_a_subtask_in_test_execution() throws Throwable {
	try
	  {
		    driver.navigate().to(zephyr_Url);
		    actual[14]=rp.clickOnTestExecution();
		    String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    
		    bp.waitForElement();
			actual[15]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[16]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[17]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^search the created defect and create a subtask$")
	public void search_the_created_defect_and_create_a_subtask() throws Throwable {
	try
	  {
		 String subtask_IssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		// driver.navigate().to(zephyr_Url);
		 //driver.navigate().back();
		 bp.waitForElement();
		 actual[18]=exep.defectSearch(selectSearch,defectID);
		 
		 actual[19]=exep.clickOnSubtask();
		 dt.createDefectSubtask(subtask_IssueType);
		 String[] fields=new String[11];
         for(int i=0;i<=10;i++)
         {
         	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
         }
		 actual[20]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		 actual[21]=dt.saveDefect();
		 actual[22]=dt.updateDefect();
		 exep.clickOnCancelDefectWindow();
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

	@When("^navigate to the external_jira page$")
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

	@Then("^Should be able to view a activity stream  in JIRA$")
	public void should_be_able_to_view_a_activity_stream_in_JIRA() throws Throwable {
	try
	   {
		 actual[23]=ejp.viewActivityStream();
		 driver.navigate().refresh();
		 actual[24]=ejp.logOutFromExternal_JIRA();
		 driver.navigate().to(zephyr_Url);
		 //pp.clickOnLogout();
		 
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
