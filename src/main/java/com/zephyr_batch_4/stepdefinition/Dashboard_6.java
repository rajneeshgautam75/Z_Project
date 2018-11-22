package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_6 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	DashBoardPage dp;
	RequirementsPage req;
	boolean[] actual=new boolean[21];
	SoftAssert soft=new SoftAssert();
	String fileName="Dashboard_6";
	@Given("^User is in a dashboard Page$")
	public void user_is_in_a_dashboard_Page() throws Throwable {
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

	@When("^User Search a dashboard with name in page one$")
	public void user_Search_a_dashboard_with_name_in_page_one() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   bp.waitForElement();
			   actual[2]=dp.clickOnAddDashBoardSymbol();
			   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5));
			   bp.waitForElement();
			   pp.navigateToProjectPage();
			   bp.waitForElement();
			   dp.clickOnManageDashboards();
			   bp.waitForElement();
			   actual[4]=dp.selectDashBoardPageSize(page);
			   actual[5]=dp.searchDashboard(name);
		 
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

	@Then("^Should be able to Search dashboard sucessfully$")
	public void should_be_able_to_Search_dashboard_sucessfully() throws Throwable {
		try
		{  
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			bp.waitForElement();
			actual[6]=dp.validateSearchResults(name);
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

	@When("^user Search a dashboard which is on any page$")
	public void user_Search_a_dashboard_which_is_on_any_page() throws Throwable {
		try
		{	
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   bp.waitForElement();
			   actual[7]=dp.clickOnAddDashBoardSymbol();
			   actual[8]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   bp.waitForElement();
			   pp.navigateToProjectPage();
			   actual[9]=bp.waitForElement();
			   actual[10]=dp.clickOnManageDashboards();
			   String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 2, 5));
			   actual[11]=dp.selectDashBoardPageSize(page);
			   actual[12]=dp.searchDashboard(name);
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

	@Then("^Should be able to Search Dashboard sucessfully$")
	public void should_be_able_to_Search_Dashboard_sucessfully() throws Throwable {
		try
		{
			bp.waitForElement();
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			actual[13]=dp.validateSearchResults(name);
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

	@When("^user Search the dashboard name containing special character$")
	public void user_Search_the_dashboard_name_containing_special_character() throws Throwable {
	   try
	   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[14]=dp.clickOnAddDashBoardSymbol();
		   actual[15]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   bp.waitForElement();
		   pp.navigateToProjectPage();
		   actual[16]=bp.waitForElement();
		   actual[17]=dp.clickOnManageDashboards();
		   String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 2, 5));
		   actual[18]=dp.selectDashBoardPageSize(page);
		   actual[19]=dp.searchDashboard(name);
		  
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

	@Then("^should be able to search dashboard sucessfully$")
	public void should_be_able_to_search_dashboard_sucessfully() throws Throwable {
		try
		{
			bp.waitForElement();
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 1);
			actual[20]=dp.validateSearchResults(name);
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
