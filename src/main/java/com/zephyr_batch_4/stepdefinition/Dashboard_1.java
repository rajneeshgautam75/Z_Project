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

public class Dashboard_1 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
    String fileName="Dashboard_1";
	@Given("^user is in Dashboard Page$")
	public void user_is_in_Dashboard_Page() throws Throwable {
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

	@When("^user adds new Dashboard with name,description,(\\d+) Gadget layout and private type$")
	public void user_adds_new_Dashboard_with_name_description_Gadget_layout_and_private_type(int arg1) throws Throwable {
	   try
	   {
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
	   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
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

	@Then("^user is able to create dashboard$")
	public void user_is_able_to_create_dashboard() throws Throwable {
	  try
	  {
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
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

	@When("^User adds new dashboard with name,description,(\\d+) Gadget layout and project team$")
	public void user_adds_new_dashboard_with_name_description_Gadget_layout_and_project_team(int arg1) throws Throwable {
		  try{
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 3);
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

	@Then("^User is able to create new dashboard with all possible fields$")
	public void user_is_able_to_create_new_dashboard_with_all_possible_fields() throws Throwable {
		
		try{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 1);
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

	@When("^user adds New dashboard with name ,description,(\\d+) Gadget layout and any logged in$")
	public void user_adds_New_dashboard_with_name_description_Gadget_layout_and_any_logged_in(int arg1) throws Throwable {
		   try{
		   
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 3);
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

	@Then("^user is able to create dashboard with all possible fields$")
	public void user_is_able_to_create_dashboard_with_all_possible_fields() throws Throwable {
		try{
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 1);
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
