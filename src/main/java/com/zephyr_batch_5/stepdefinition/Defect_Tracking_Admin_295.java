package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Admin_295 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	CreateCustomFieldsPage ccp;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_295";
    public boolean result;
	@Given("^User Logins to Zephyr as Manager$")
	public void user_Logins_to_Zephyr_as_Manager() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			ccp=new CreateCustomFieldsPage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			bp.waitForElement();
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);       
			actual[3]=lp.clickOnLogin();  
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

	@When("^User Goes to administration and clicks on Customization$")
	public void user_Goes_to_administration_and_clicks_on_Customization() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[4]=ccp.navigatingToCustomizationStatusTab(); 
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

	@When("^adds role with defect admin permission$")
	public void adds_role_with_defect_admin_permission() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 9, 2);
			String description=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			String administrationApps=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 9, 3);
			String projectApps=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 100, 100);
			bp.waitForElement();
			ccp.clickonRole.click();
			boolean res=ccp.checkAvailableCustomRole(name);
			if(res==true)
			{
				bp.waitForElement();
				ccp.closeCustomizationTab.click();
			}
			else
			{
				bp.waitForElement();
				ccp.addCustomRole(name, description, administrationApps, projectApps);
				bp.waitForElement();
				ccp.closeCustomizationTab.click();
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

	@When("^user goes to User setup and adds a user with above created role$")
	public void user_goes_to_User_setup_and_adds_a_user_with_above_created_role() throws Throwable {
		try
		{
			//String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Custom_Username_1");
			String type=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 12, 2);
			String role=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 9, 2);
			String email=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 10, 2);
			String title=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 11, 3);
			String location=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 11, 2);
			actual[5]=ccp.moveToCreateCustomUser();
			
			String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Custom_Username_1");
			String value[]=userName.split("\\.");
			String firstName=value[0];
			String lasTName=value[1];
			boolean result=pp.checkAvailableUser(firstName+" "+lasTName);
			String projectName[]=new String[1];
			projectName[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			if(result==false)
			{
			bp.waitForElement();
			//actual[6]=ccp.moveToCreateCustomUser();
			ccp.createUser(firstName, lasTName, type, role, email, title, location);
			 //String lead_1=firstName+" "+lasTName;
			//System.out.println(firstName+" "+lasTName);
			pp.selectUser(firstName+" "+lasTName);
			pp.assignProject(projectName);
			}
			
				actual[6]=pp.clickOnLogout();
			
			
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

	@Then("^should be able to add created role to user$")
	public void should_be_able_to_add_created_role_to_user() throws Throwable {
		try
		{
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Custom_Username");
			actual[11]=bp.waitForElement();
			//ccp.checkAvailableCustomRole(name);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Custom_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Custom_Password_1");
			bp.waitForElement();
			bp.waitForElement();
			actual[7]=lp.enterUname(uname);
			actual[8]=lp.enterPass(password);
			
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

	@When("^user logins as as custom user to Zephyr$")
	public void user_logins_as_as_custom_user_to_Zephyr() throws Throwable {
		try
		{       
			actual[9]=lp.clickOnLogin(); 
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

	@When("^goes to administration and views Defect Admin$")
	public void goes_to_administration_and_views_Defect_Admin() throws Throwable {
		try
		{
			actual[10]=pp.launchAdministration();
			bp.waitForElement();
			ccp.closeExternalIcon.click();	
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

	@Then("^Should be able to launch Defects Admin app$")
	public void should_be_able_to_launch_Defects_Admin_app() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[11]=pp.launchDefectAdmin();
			bp.waitForElement();
			for(int k=0;k<=actual.length-1;k++)
			{
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
