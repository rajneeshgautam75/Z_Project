package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_14 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[22];
	SoftAssert soft=new SoftAssert();
    String fileName="DashBoard_Permission_14";
	@Given("^test user is In a Dashboard page$")
	public void test_user_is_In_a_Dashboard_page() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		lp=new LoginPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		//actual[0]=pp.selectProject(projectName);
		bp.waitForElement();
		actual[0]=dp.clickOnManageDashboards();
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

	@When("^test user Creates some data and add a dashboard of Share type Private with (\\d+)/(\\d+) gadget$")
	public void test_user_Creates_some_data_and_add_a_dashboard_of_Share_type_Private_with_gadget(int arg1, int arg2) throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 20, 2);
		   String description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 3);
		   String layout=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 5);
		   String gadget=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 4, 6);
		   bp.waitForElement();
		   actual[1]=dp.clickOnAddDashBoardSymbol();
		   actual[2]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   actual[3]=dp.validateDashBoard(name);
		   actual[4]=dp.selectDashboard(name);
		   bp.waitForElement();
		   actual[5]=dp.clickOnAddGadgetSymbol();
		   bp.waitForElement();
		   actual[6]=dp.addGadget(gadget);
		   bp.waitForElement();
		   pp.backToProjectPage();
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

	@Then("^test user Able to Change from Private to Project$")
	public void test_user_Able_to_Change_from_Private_to_Project() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 20, 2);
		   String description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 3);
		   String layout=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 2, 5);
		   bp.waitForElement();
		   actual[7]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   actual[8]=dp.searchDashboard(name);
		   bp.waitForElement();
		   actual[9]=dp.clickOnEditDashBoardSymbol(name);
		   bp.waitForElement();
		   actual[10]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@When("^test user Changes the dashboard Share type to project$")
	public void test_user_Changes_the_dashboard_Share_type_to_project() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 20, 2);
		   String description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 3);
		   String layout=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 2, 5);
		   bp.waitForElement();
		   actual[11]=dp.clickOnEditDashBoardSymbol(name);
		   bp.waitForElement();
		   actual[12]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^test user Able to change From Private to Project$")
	public void test_user_Able_to_change_From_Private_to_Project() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 20, 2);
		   String description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 3);
		   String layout=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 5);
		   String shareType_1=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 2, 5);
		   bp.waitForElement();
		   actual[13]=dp.clickOnEditDashBoardSymbol(name);
		   bp.waitForElement();
		   actual[14]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   bp.waitForElement();
		   actual[15]=dp.clickOnEditDashBoardSymbol(name);
		   bp.waitForElement();
		   actual[16]=dp.enterDashBoardDetails(name, description, layout, shareType_1);
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

	@When("^Change the Share type of Dashboard from Private to Project Team and Other users should able to view dashboard$")
	public void change_the_Share_type_of_Dashboard_from_Private_to_Project_Team_and_Other_users_should_able_to_view_dashboard() throws Throwable {
	    
	    	try
			   {
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 20,2);
			   String description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 3);
			   String layout=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 1, 5);
			   String shareType_1=Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 2, 5);
			   bp.waitForElement();
			   actual[17]=dp.clickOnEditDashBoardSymbol(name);
			   bp.waitForElement();
			   actual[18]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   bp.waitForElement();
			   actual[19]=dp.clickOnEditDashBoardSymbol(name);
			   actual[20]=dp.enterDashBoardDetails(name, description, layout, shareType_1);
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
	   

	@Then("^user Able to view dashboard if all the projects referenced in the gadgets of the dashboard are accessible to the user$")
	public void user_Able_to_view_dashboard_if_all_the_projects_referenced_in_the_gadgets_of_the_dashboard_are_accessible_to_the_user() throws Throwable {
	    try
	    {
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards", 20, 2);
	    	actual[21]=dp.validateDashBoard(name);
	    	
	    	pp.backToProjectPage();
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
