package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_View_72 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
    BasePage bp;
	DashBoardPage dp;
	ProjectPage pp;
	DefectTracking dt;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_View_72";
	
	@Given("^Manager will be in projectSetUp Page$")
	public void manager_will_be_in_projectSetUp_Page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lp=new LoginPage(driver);
			rp= new ReleasePage(driver);
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		     actual[0]=pp.clickOnLogout();
		     bp.waitForElement();
		     actual[1]=lp.enterUnameAndPassword(name, passWord);
		     bp.waitForElement();
		     actual[2]=pp.launchAdministration();
		     bp.waitForElement(); 
		     actual[3]=pp.launchManageprojects();
		     bp.waitForElement(); 
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}  
	
	 
	}

	@When("^Manager map the jira project to ZE application$")
	public void manager_map_the_jira_project_to_ZE_application() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[4]=pp.selectProjectInProjectSetup(projectName);
			bp.waitForElement();
			String mapDefectProject=Excel_Lib.getData(INPUT_PATH_8, "Jira", 1, 6);
			Select sel2=new Select(pp.defectProject);
			   sel2.selectByVisibleText(mapDefectProject);
			   bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	    
	}

	@When("^manager will logout from manager credentials$")
	public void manager_will_logout_from_manager_credentials() throws Throwable {
		try
		{
			  actual[5]=pp.clickOnLogout();
			  bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	     
	}

	@When("^User will enter ZE application with lead credentails$")
	public void user_will_enter_ZE_application_with_lead_credentails() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[5]=lp.enterUnameAndPassword(Uname, pass);
			bp.waitForElement();
			bp.waitForElement();
			actual[6]=pp.selectProject(projectName);
			  bp.waitForElement();
			actual[7]=pp.selectRelease(releaseName);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^user clicks on the DefectTracking button$")
	public void user_clicks_on_the_DefectTracking_button() throws Throwable {
		try
		{
			actual[8]=pp.clickOnDefectTracking();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	     
	}

	
	@Then("^user must come to defect Tracking page successfully$")
	public void user_must_come_to_defect_Tracking_page_successfully() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			actual[9]=dt.validateDefectTrackingPage();
			  bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	}


	@When("^user clicks on the CreateDefect button$")
	public void user_clicks_on_the_CreateDefect_button() throws Throwable {
		try
		{
			dt.createDefectButton.click();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	    
	}
	
	

	@Then("^user must view mapped project selected by default in create defect window$")
	public void user_must_view_mapped_project_selected_by_default_in_create_defect_window() throws Throwable {
		try
		{
			String project=Excel_Lib.getData(INPUT_PATH_8, "Jira", 1, 6);
			
			actual[10]=dt.validateDefectProject(project);
			bp.waitForElement();
			dt.CancelButton.click();
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
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	    
	}



}
