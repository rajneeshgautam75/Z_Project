package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_164 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExecutionPage exep;
	String fileName="Defect_Tracking_Search_164";
	
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();

	@Given("^User logged in as manager$")
	public void user_logged_in_as_manager() throws Throwable {
	try
    {
		bp=new BasePage();
		lp=new LoginPage(driver);
		rp=new ReleasePage(driver);
		tr=new TestRepositoryPage(driver);
		dt=new DefectTracking(driver);
		pp=new ProjectPage(driver);
		bp.waitForElement();
		pp.clickOnLogout();
	 	 
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
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

	@When("^Manager is in Administration page$")
	public void manager_is_in_Administration_page() throws Throwable {
	try
    {
	  actual[0]=pp.launchAdministration();
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

	@When("^set the DTS to Jira$")
	public void set_the_DTS_to_Jira() throws Throwable {
	try
    {
	  String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	  String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	  String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	
	  actual[1]=pp.clickOnDefectTracking();
	  actual[2]=pp.setDTS(DTS, jira_Url, Uname, Pwd);
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

	@Then("^Should be able to set DTS$")
	public void should_be_able_to_set_DTS() throws Throwable {
	try
    {
	  actual[3]=pp.validateSetDTS();
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

	@When("^User is in the Defect Tracking Page$")
	public void user_is_in_the_Defect_Tracking_Page() throws Throwable {
	try
    {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[4]=rp.clickOnDefectTracking();
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

	@Then("^should be able to launch defect tracking$")
	public void should_be_able_to_launch_defect_tracking() throws Throwable {
	try
    {
	  actual[5]=dt.validateDefectTrackingPage();
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

	@When("^User search the defects by selecting the project$")
	public void user_search_the_defects_by_selecting_the_project() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
		 String[] fields=new String[6];
		 for(int i=0;i<=5;i++)
		 {
		 fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 }
		 actual[6]=dt.defectSearch(projectName,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);
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

	@Then("^Should search more than five hunderd defects$")
	public void should_search_more_than_five_hunderd_defects() throws Throwable {
	try
	   {
		 actual[7]=tr.verifyPresentTestCase();
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

	@When("^select all the searched defects$")
	public void select_all_the_searched_defects() throws Throwable {
	try
	   {
		 actual[8]=dt.selectAllDefects();
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

	@Then("^Should select more than five hunderd defects$")
	public void should_select_more_than_five_hunderd_defects() throws Throwable {
	try
	   {
		 actual[9]=tr.verifyPresentTestCase();
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

	@When("^click on export button$")
	public void click_on_export_button() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,14);
		 actual[10]=dt.defectsOperation(defectValue);
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

	@Then("^Should get proper message$")
	public void should_get_proper_message() throws Throwable {
	try
	   {
		actual[11]=dt.downloadExportFile();
		 
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
