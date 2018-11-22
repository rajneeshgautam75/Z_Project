package com.zephyr_batch_5.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class User_Assignment extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	
	String fileName="User_Assignment";
	
	@Given("^Login as manager$")
	public void login_as_manager() throws Throwable {
	  try
	  {
		bp=new BasePage(); 
	    bp.waitForElement();
//		pp=new ProjectPage(driver);
//		pp.clickOnLogout();
//		lp=new LoginPage(driver);
//		lp.enterUname("test.manager");
//		lp.enterPass("test.manager");
//		lp.clickOnLogin();
	
	  
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

	@When("^User click on admin and manage user$")
	public void user_click_on_admin_and_manage_user() throws Throwable 
	{
		try
		{
	    pp=new ProjectPage(driver);
	    pp.launchAdministration();
	    pp.launchManageUsers();
	    
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

	@When("^select the first lead user and assign the projects$")
	public void select_the_first_lead_user_and_assign_the_projects() throws Throwable {
	   
		try
		{
		String lead_User_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
		pp.selectUser(lead_User_1);
		
//	    bp.checkSelectedProjectCount();
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
//		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
//		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
//		projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_3");
//		projects[6]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
//		projects[7]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_5");
//		projects[8]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_6");
//		projects[9]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_7");
//		projects[10]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_8");
//		//projects[11]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_9");
		
		
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the second lead user and assign the projects$")
	public void select_the_second_lead_user_and_assign_the_projects() throws Throwable {
		try
		{
		String lead_User_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_2");
		pp.selectUser(lead_User_2);
		String[] projects=new String[6];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");////
		pp.assignProject(projects);
		
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

	@When("^select the third lead user and assign the projects$")
	public void select_the_third_lead_user_and_assign_the_projects() throws Throwable {
		try
		{
		String lead_User_3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_3");
		pp.selectUser(lead_User_3);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the fourth lead user and assign the projects$")
	public void select_the_fourth_lead_user_and_assign_the_projects() throws Throwable {
		try
		{
		String lead_User_4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_4");
		pp.selectUser(lead_User_4);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the fifth lead user and assign the projects$")
	public void select_the_fifth_lead_user_and_assign_the_projects() throws Throwable {
		try
		{
		String lead_User_5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_5");
		pp.selectUser(lead_User_5);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		//projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the sixth lead user and assign the projects$")
	public void select_the_sixth_lead_user_and_assign_the_projects() throws Throwable {
		try
		{
		String lead_User_6=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_6");
		pp.selectUser(lead_User_6);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the first tester user and assign the projects$")
	public void select_the_first_tester_user_and_assign_the_projects() throws Throwable {
		try
		{
		String tester_User_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Tester_1");
		pp.selectUser(tester_User_1);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the second tester user and assign the projects$")
	public void select_the_second_tester_user_and_assign_the_projects() throws Throwable {
		try
		{
		String tester_User_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Tester_2");
		pp.selectUser(tester_User_2);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the third tester user and assign the projects$")
	public void select_the_third_tester_user_and_assign_the_projects() throws Throwable {
		try
		{
		String tester_User_3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Tester_3");
		pp.selectUser(tester_User_3);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@When("^select the fourth tester user and assign the projects$")
	public void select_the_fourth_tester_user_and_assign_the_projects() throws Throwable {
		try
		{
		String tester_User_4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Tester_4");
		pp.selectUser(tester_User_4);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Isolated_Project_2");
		pp.assignProject(projects);
		
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

	@Then("^projects successfully assigned to the users$")
	public void projects_successfully_assigned_to_the_users() throws Throwable {
	  try
	  {
		  pp.backToProjectPage();
		System.out.println("Projects successfully assigned to the users");
		
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
