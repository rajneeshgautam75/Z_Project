package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_8 extends LaunchBrowser {

	LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	LoginPage lp;
	DashBoardPage db;
	
	String fileName="DashBoard_Permission_8";
	 boolean[] actual=new boolean[19];
		SoftAssert soft=new SoftAssert();
	
	@Given("^Login as lead credential$")
	public void login_as_lead_credential() throws Throwable {
		
		try
		{
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");	
		
		pp=new ProjectPage(driver);
		lp=new LoginPage(driver);
		actual[0]=pp.clickOnLogout();
		actual[1]=lp.enterUnameAndPassword(uName, passWord);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
   
	}

	@When("^lead clicks on Manage_dashboard$")
	public void lead_clicks_on_Manage_dashboard() throws Throwable {
		 try
		   {
			db=new DashBoardPage(driver);
		    actual[2]=db.clickOnManageDashboards();
		    
		   }
			catch(Exception e)
		    {
		     lb=new LaunchBrowser();
		     e.printStackTrace();
		     lb.getScreenShot(fileName);
		     driver.close();
		     Relogin_TPE rl=new Relogin_TPE();
		     rl.reLogin();
		     throw e;
		   }   
	   
	}

	@Then("^Manage_dashboard page should be displayed$")
	public void manage_dashboard_page_should_be_displayed() throws Throwable {
		try
		{
		actual[3]=db.validateDashboards();
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^lead add one Dashboard with share Type any logged in user$")
	public void lead_add_one_Dashboard_with_share_Type_any_logged_in_user() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 48, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 48, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 48, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 48, 4);
		actual[4]=db.clickOnAddDashBoardSymbol();
		
		actual[5]=db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^First dashboard Should be created successfully$")
	public void first_dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 48, 1);
		actual[6]=db.validateDashBoard(dashBoardName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^lead add second Dashboard with share Type any logged in user$")
	public void lead_add_second_Dashboard_with_share_Type_any_logged_in_user() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 49, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 49, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 49, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 49, 4);
		actual[7]=db.clickOnAddDashBoardSymbol();
		
		actual[8]=db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^second Dashboard Should be created successfully$")
	public void second_Dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 49, 1);
		actual[9]=db.validateDashBoard(dashBoardName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^lead add third Dashboard with share Type any logged in user$")
	public void lead_add_third_Dashboard_with_share_Type_any_logged_in_user() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 50, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 50, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 50, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 50, 4);
		actual[10]=db.clickOnAddDashBoardSymbol();
		
		actual[11]=db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^third Dashboard Should be created successfully$")
	public void third_Dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 50, 1);
		actual[12]=db.validateDashBoard(dashBoardName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^login as other lead credential$")
	public void login_as_other_lead_credential() throws Throwable {
		try
		{
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_2");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_2");	
		
		
		actual[13]=pp.clickOnLogout();
		actual[14]=lp.enterUnameAndPassword(uName, passWord);
		
		actual[15]=db.clickOnManageDashboards();
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^try to edit the dashboard$")
	public void try_to_edit_the_dashboard() throws Throwable {
		try
		{
			for(int i=1;i<=3;i++)
			{
			String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 47+i, 1);	
		    actual[15+i]=db.searchDashboard(dashBoardName);
	        db.clickOnEditDashBoardSymbol(dashBoardName);
			}
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^should not allow to edit the dashboard$")
	public void should_not_allow_to_edit_the_dashboard() throws Throwable {
	   
		try
		{
			System.out.println("Not allowed to edit the dashboard");
			
			
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
		
		
	}
}
