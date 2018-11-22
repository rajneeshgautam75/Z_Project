package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_21 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
    String fileName="Project_Status_Gadget_21";
	@Given("^Custom role user is Dash Board$")
	public void custom_role_user_is_Dash_Board() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		lp=new LoginPage(driver);
		pp.clickOnLogout();
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		actual[0]=lp.enterUname(Uname);
		System.out.println(" User name is " + Uname +"name");
		actual[1]=lp.enterPass(pass);
		System.out.println("Password is " + pass + "passsowrd");
		actual[2]=lp.clickOnLogin();
		System.out.println(Uname);
		actual[3]=pp.selectProject(projectName);
		actual[4]=dp.clickOnManageDashboards();
	
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

	@When("^Custom role user adds the New dashboard and Selects Added Dashboard$")
	public void custom_role_user_adds_the_New_dashboard_and_Selects_Added_Dashboard() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 39, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[5]=dp.clickOnAddDashBoardSymbol();
		   actual[6]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   actual[7]=dp.selectDashboard(name);
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

	@When("^Project Status Gadget Should be added by custom role user$")
	public void project_Status_Gadget_Should_be_added_by_custom_role_user() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			bp.waitForElement();
			actual[8]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[9]=dp.addGadget(gadget);
			
			
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

	@Then("^project Status gadget should be Validated$")
	public void project_Status_gadget_should_be_Validated() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			bp.waitForElement();
			actual[10]=dp.validateGadget(gadget);
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

	@When("^custom user Attempts to delete Project Status Gadget when user does not have delete permission and is assigned any project$")
	public void custom_user_Attempts_to_delete_Project_Status_Gadget_when_user_does_not_have_delete_permission_and_is_assigned_any_project() throws Throwable {
	   try
	   {
		
		    String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_3");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_3");
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 39, 1);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			dp.configureProjectStatusGadget(projectName);
			dp.saveGadget();
			bp.waitForElement();
		    pp.clickOnLogout();
		    bp.waitForElement();
			actual[11]=lp.enterUname(Uname);
			System.out.println(" User name is " + Uname +"name");
			actual[12]=lp.enterPass(pass);
			System.out.println("Password is " + pass + "passsowrd");
			actual[13]=lp.clickOnLogin();
			System.out.println(Uname);
			actual[14]=dp.clickOnManageDashboards();
			actual[15]=dp.searchDashboard(name);
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

	@Then("^project status gadget should not be able to delete$")
	public void project_status_gadget_should_not_be_able_to_delete() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 39, 1);
			bp.waitForElement();
			actual[16]=dp.validateDashBoard(name);
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

	@When("^custom user try to delete Project Status Gadget when user does not have delete permission and is not assigned to any project$")
	public void custom_user_try_to_delete_Project_Status_Gadget_when_user_does_not_have_delete_permission_and_is_not_assigned_to_any_project() throws Throwable {
	   try
	   {
		   
		    String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_3");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_3");
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 39, 1);
			bp.waitForElement();
			pp.clickOnLogout();
			bp.waitForElement();
			actual[17]=lp.enterUname(Uname);
			System.out.println(" User name is " + Uname +"name");
			actual[18]=lp.enterPass(pass);
			System.out.println("Password is " + pass + "passsowrd");
			actual[19]=lp.clickOnLogin();
			System.out.println(Uname);
			actual[20]=dp.clickOnManageDashboards();
			actual[21]=dp.searchDashboard(name);
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

	@Then("^Project status gadget should not delete$")
	public void project_status_gadget_should_not_delete() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 39, 1);
			bp.waitForElement();
			actual[22]=dp.validateDashBoard(name);
			bp.waitForElement();
			pp.navigateToProjectPage();
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
