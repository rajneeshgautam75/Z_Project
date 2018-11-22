package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_3 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
    String fileName="DashBoard_Permission_3";
	@Given("^custom user launches DashBoard Window$")
	public void custom_user_launches_DashBoard_Window() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
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

	@When("^custom user creates new DashBoard of  Access type Project Team$")
	public void custom_user_creates_new_DashBoard_of_Access_type_Project_Team() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 41, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 3);
			   bp.waitForElement();
			   actual[2]=dp.clickOnAddDashBoardSymbol();
			   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   
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

	@Then("^custom user Should able to add a Dahsboard Access type Project Team$")
	public void custom_user_Should_able_to_add_a_Dahsboard_Access_type_Project_Team() throws Throwable {
		
		try
		  {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 41, 1);
			actual[4]=dp.validateDashBoard(name);
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

	@When("^custom user adds a Dahsboard Access type Any Logged in User$")
	public void custom_user_adds_a_Dahsboard_Access_type_Any_Logged_in_User() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 42, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 3);
			   bp.waitForElement();
			   actual[5]=dp.clickOnAddDashBoardSymbol();
			   actual[6]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   
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

	@Then("^custom user to able to add a Dahsboard Access type Any Logged in User$")
	public void custom_user_to_able_to_add_a_Dahsboard_Access_type_Any_Logged_in_User() throws Throwable {
		try
		  {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 42, 1);
			actual[7]=dp.validateDashBoard(name);
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

	@When("^custom user creates a dashboard with access type Private$")
	public void custom_user_creates_a_dashboard_with_access_type_Private() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 44, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   bp.waitForElement();
			   actual[8]=dp.clickOnAddDashBoardSymbol();
			   actual[9]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   
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

	@Then("^should be able to create a dashboard with access type Private$")
	public void should_be_able_to_create_a_dashboard_with_access_type_Private() throws Throwable {
		try
		  {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 44, 1);
			actual[10]=dp.validateDashBoard(name);
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
