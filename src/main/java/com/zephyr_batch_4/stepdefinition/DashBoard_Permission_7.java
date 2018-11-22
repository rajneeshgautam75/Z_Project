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

public class DashBoard_Permission_7 extends LaunchBrowser {

	LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	LoginPage lp;
	DashBoardPage db;
	
	String fileName="DashBoard_Permission_7";
	 boolean[] actual=new boolean[27];
		SoftAssert soft=new SoftAssert();
	
	@Given("^Login as manager_Credential$")
	public void login_as_manager_Credential() throws Throwable {
		try
		{
		bp=new BasePage();
		pp=new ProjectPage(driver);
		lp=new LoginPage(driver);
		
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");	
		
		
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

	@When("^manager clicks on Manage dashboard$")
	public void manager_clicks_on_Manage_dashboard() throws Throwable {
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

	@Then("^Manage dashboard page should be displayed$")
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

	@When("^manager add a new Dashboard with share type any logged in user$")
	public void manager_add_a_new_Dashboard_with_share_type_any_logged_in_user() throws Throwable {
		 
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 45, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 45, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 45, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 45, 4);
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

	@Then("^first dashboard Should be created successfully$")
	public void first_dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 45, 1);
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

	@When("^login as lead user$")
	public void login_as_lead_user() throws Throwable {
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");	
		
		
		actual[7]=pp.clickOnLogout();
		actual[8]=lp.enterUnameAndPassword(uName, passWord);
	}

	@When("^lead clicks on Manage dashboard$")
	public void lead_clicks_on_Manage_dashboard() throws Throwable {
		try
		   {
			db=new DashBoardPage(driver);
		    actual[9]=db.clickOnManageDashboards();
		    
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

	@Then("^manage dashboard page should be Displayed$")
	public void manage_dashboard_page_should_be_Displayed() throws Throwable {
		try
		{
		actual[10]=db.validateDashboards();
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

	@When("^lead add a new Dashboard with share type any logged in user$")
	public void lead_add_a_new_Dashboard_with_share_type_any_logged_in_user() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 46, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 46, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 46, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 46, 4);
		actual[11]=db.clickOnAddDashBoardSymbol();
		
		actual[12]=db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);
		
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

	@Then("^second dashboard Should be created successfully$")
	public void second_dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 46, 1);
		actual[13]=db.validateDashBoard(dashBoardName);
		
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

	@When("^login as tester user$")
	public void login_as_tester_user() throws Throwable {
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Tester_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Tester_Password_1");	
		
		
		actual[14]=pp.clickOnLogout();
		actual[15]=lp.enterUnameAndPassword(uName, passWord);
	}

	@When("^tester clicks on Manage dashboard$")
	public void tester_clicks_on_Manage_dashboard() throws Throwable {
		try
		   {
			db=new DashBoardPage(driver);
		    actual[16]=db.clickOnManageDashboards();
		    
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

	@Then("^manage dashboard Page should be Displayed$")
	public void manage_dashboard_Page_should_be_Displayed() throws Throwable {
		try
		{
		actual[17]=db.validateDashboards();
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

	@When("^Tester add a new Dashboard with share type any logged in user$")
	public void tester_add_a_new_Dashboard_with_share_type_any_logged_in_user() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 47, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 47, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 47, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 47, 4);
		actual[18]=db.clickOnAddDashBoardSymbol();
		
		actual[19]=db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);
		
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

	@Then("^third dashboard Should be created successfully$")
	public void third_dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 47, 1);
		actual[20]=db.validateDashBoard(dashBoardName);
		
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

	@When("^login as another lead credential$")
	public void login_as_another_lead_credential() throws Throwable {
		try
		{
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_2");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_2");	
		
		
		actual[21]=pp.clickOnLogout();
		actual[22]=lp.enterUnameAndPassword(uName, passWord);
		
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

	@When("^naviagte to dashboard page$")
	public void naviagte_to_dashboard_page() throws Throwable {
		try
		   {
			db=new DashBoardPage(driver);
		    actual[23]=db.clickOnManageDashboards();
		    
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

	@When("^search and view all dashboard created by different users$")
	public void search_and_view_all_dashboard_created_by_different_users() throws Throwable {
	   try
	   {
		for(int i=1;i<=3;i++)
	    {
	    	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44+i, 1);
		   actual[23+i]=db.searchDashboard(dashBoardName);
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

	@Then("^able to view the all dashboards created by different users$")
	public void able_to_view_the_all_dashboards_created_by_different_users() throws Throwable {
	  try
	  {
		log.info("Dashboard viewed in Dashborad Page");
	   
	   for(int k=0;k<=actual.length-1;k++)
		{
			//System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
		
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
