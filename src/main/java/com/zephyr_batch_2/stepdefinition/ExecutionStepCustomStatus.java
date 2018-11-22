package com.zephyr_batch_2.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExecutionStepCustomStatus extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage exp;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	CreateCustomFieldsPage ccp;
	ExecutionPage exe;

	String fileName="ExecutionStepCustomStatus";
	
	@Given("^click on administartion and click on customization step status$")
	public void click_on_administartion_and_click_on_customization_step_status() throws Throwable {
		try
		{
			ccp=new CreateCustomFieldsPage(driver);
			   exe=new ExecutionPage(driver);
//			   exe.navigatingToCustomizationStatusTab();
			   
			   
			   ccp.clickOnStepExecutionStatusTab();
		   
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

	@And("^create step custom status <N/A>$")
	public void create_step_custom_status_N_A() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
		boolean status=ccp.checkAvailableCustomFields(value);
		
		if(status==false)
		{
			String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
			ccp.createCustomStaus(value, colour);
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

	@Then("^step status <N/A> should be created sucessfully$")
	public void step_status_N_A_should_be_created_sucessfully() throws Throwable {
		String value=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
		log.info("Execution Step Custom Status-"+value+" created successfully");
	}

	@When("^create step custom status <Future Scope>$")
	public void create_step_custom_status_Future_Scope() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2,"Files",2,2);
					boolean status=ccp.checkAvailableCustomFields(value);
					
					if(status==false)
					{
						String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",2,2);
						ccp.createCustomStaus(value, colour);
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

	@Then("^step status <Future Scope> should be created sucessfully$")
	public void step_status_Future_Scope_should_be_created_sucessfully() throws Throwable {
		String value=Excel_Lib.getData(INPUT_PATH_2,"Files",2,2);
		log.info("Execution Step Custom Status-"+value+" created successfully");
	}

	@When("^create step custom status <Custom Status>$")
	public void create_step_custom_status_Custom_Status() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2,"Files",6,2);
		boolean status=ccp.checkAvailableCustomFields(value);
		
		if(status==false)
		{
			String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
			ccp.createCustomStaus(value, colour);
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


	@Then("^step status <Custom Status> should be created sucessfully$")
	public void step_status_Custom_Status_should_be_created_sucessfully() throws Throwable {
		try
		{
			bp=new BasePage();
			exe=new ExecutionPage(driver);
		String value=Excel_Lib.getData(INPUT_PATH_2,"Files",6,2);
		log.info("Execution Step Custom Status-"+value+" created successfully");
		
		bp.waitForElement();
		ccp.closeExecutionStatusPage.click();
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
}
