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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_View_11 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	String fileName="Defect_Tracking_View_11";
	
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in Administration page$")
	public void user_is_in_Administration_page() throws Throwable {
		try
	    {
			bp=new BasePage();
			pp=new ProjectPage(driver);
			pp.clickOnLogout();
			lp=new LoginPage(driver);
		 	 
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		     actual[0]=lp.enterUname(Uname);
		     actual[1]=lp.enterPass(Pass);
		     actual[2]=lp.clickOnLogin();
			 bp.waitForElement();
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

	@When("^User set the DTS$")
	public void user_set_the_DTS() throws Throwable {
		try
		   {
		     pp=new ProjectPage(driver);
		     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
			 String url=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 26);
			 String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 24);
			 String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 25);
			 actual[4]=pp.clickOnDefectTracking();
			 actual[5]=pp.setDTS(DTS, url, username, password); 
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

	@When("^User refresh the page$")
	public void user_refresh_the_page() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   driver.navigate().refresh();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
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

	@When("^User select the project and release and launch defect tracking and enter valid login credential and save it$")
	public void user_select_the_project_and_release_and_launch_defect_tracking_and_enter_valid_login_credential_and_save_it() throws Throwable {
	  try
	  {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	     pp.backToProjectPage();
		 pp.selectProject(projectName);
	     pp.selectRelease(releaseName);
	     String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 24);
	     String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 25);
	     
	     bp.waitForElement();
	     actual[6]=pp.clickOnDefectTracking();
	     exep=new ExecutionPage(driver);
	     
	     dt=new DefectTracking(driver);
	     actual[7]=dt.loginToDTS(username, password);
	     
	     
	     
	     
	    //exep.loginToDTS(username, password);
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

	@Then("^Should be able to launch defect admin when DTS is set$")
	public void should_be_able_to_launch_defect_admin_when_DTS_is_set() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[8]=pp.launchAdministration();
			   bp.waitForElement();
			   actual[9]=pp.launchDefectAdmin();
			   
			   pp.backToProjectPage();
			   //actual[10]=pp.clickOnLogout();
			   
			   for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					//soft.assertEquals(actual[k], true);
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
