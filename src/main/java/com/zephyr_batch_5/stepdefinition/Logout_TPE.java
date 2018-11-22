package com.zephyr_batch_5.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Logout_TPE extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;

	String filename="Logout_TPE";
	@Given("^User is in the Zephyr ProjectPage_TPE$")
	public void user_is_in_the_Zephyr_ProjectPage_TPE() throws Throwable
	{
		try
		{
		pp=new ProjectPage(driver);
		//String projectName="Sample Project";
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		//String projectName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,0);
	    //pp.selectProject(projectName);
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

	@When("^User Clicks on logout Icon_TPE$")
	public void user_Clicks_on_logout_Icon_TPE() throws Throwable 
	{
		try
		{
		  bp=new BasePage();
		    bp.waitForElement();
			pp.user_option.click();
			bp.waitForElement();
			log.info("Pass - clicked on Logout user Option");
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

	@When("^User clicks on Logout Option_TPE$")
	public void user_clicks_on_Logout_Option_TPE() throws Throwable 
	{
		try
		{
	    bp=new BasePage();
	    pp.logout.click();
	    bp.waitForElement();
	    log.info("Pass - clicked on Logout Successfully");
	    pp.closeBrowser();
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

	@Then("^User should be logged out from Zephyr Application Successfully_TPE$")
	public void user_should_be_logged_out_from_Zephyr_Application_Successfully_TPE() throws Throwable 
	{
		 log.info("Pass - User should be logged out from Zephyr Application Successfully");
	}

}
