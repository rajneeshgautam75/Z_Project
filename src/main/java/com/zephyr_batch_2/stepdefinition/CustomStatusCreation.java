package com.zephyr_batch_2.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomStatusCreation extends LaunchBrowser{
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

	String fileName="CustomStatusCreation";
/*@Given("^User Login as manager credential$")
public void user_Login_as_manager_credential() throws Throwable {
	try
	{
		bp=new BasePage();
	   pp=new ProjectPage(driver);
	   pp.clickOnLogout();
	   lp=new LoginPage(driver);
	String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
	String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
	   lp.enterUname(uname);
	   lp.enterPass(password);
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
	   
}*/

@Given("^click on administartion and click on customization status$")
public void click_on_administartion_and_click_on_customization_status() throws Throwable {
  try
  {
   exe=new ExecutionPage(driver);  
   ccp=new CreateCustomFieldsPage(driver);
   ccp.clickOnExecutionStatusTab();
  
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

@When("^create custom status <N/A>$")
public void create_custom_status_N_A() throws Throwable {

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

@Then("^status should be created sucessfully$")
public void status_should_be_created_sucessfully() throws Throwable {
 
	try
	{
	log.info("Status created successfully");
	
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

@When("^create custom status <Custom Status>$")
public void create_custom_status_Custom_Status() throws Throwable {
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

@When("^create custom status <Executed>$")
public void create_custom_status_Executed() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",7,2);
			boolean status=ccp.checkAvailableCustomFields(value);
			
			if(status==false)
			{
				String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",7,2);
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

@When("^create custom status <Not Executed>$")
public void create_custom_status_Not_Executed() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",8,2);
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

@When("^create custom status <Future Scope>$")
public void create_custom_status_Future_Scope() throws Throwable {
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

@When("^create custom status <Future Release>$")
public void create_custom_status_Future_Release() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",3,2);
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

@When("^create custom status <Duplicate>$")
public void create_custom_status_Duplicate() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",4,2);
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

@When("^create custom status <Not Reproducable>$")
public void create_custom_status_Not_Reproducable() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
				boolean status=ccp.checkAvailableCustomFields(value);
				
				if(status==false)
				{
					String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",5,2);
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

@When("^create custom status <FutureScopeforjava>$")
public void create_custom_status_FutureScopeforjava() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",9,2);
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

@When("^create custom status <Execution>$")
public void create_custom_status_Execution() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",10,2);
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



@When("^create custom status with international character$")
public void create_custom_status_with_international_character() throws Throwable {
	try
	{
	String value=Excel_Lib.getData(INPUT_PATH_2,"Files",11,2);
		boolean status=ccp.checkAvailableCustomFields(value);
		
		if(status==false)
		{
			String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
			ccp.createCustomStaus(value, colour);
		}
		
		String value1=Excel_Lib.getData(INPUT_PATH_2,"Files",12,2);
		boolean status1=ccp.checkAvailableCustomFields(value1);
		
		if(status1==false)
		{
			String colour=Excel_Lib.getData(INPUT_PATH_2,"Files",1,2);
			ccp.createCustomStaus(value1, colour);
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


@Then("^status should be created Sucessfully$")
public void status_should_be_created_Sucessfully() throws Throwable {

try

{
	bp=new BasePage();
	exe=new ExecutionPage(driver);
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
