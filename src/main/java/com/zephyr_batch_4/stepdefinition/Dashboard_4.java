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

public class Dashboard_4 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[18];
	 SoftAssert soft=new SoftAssert();
	 String fileName="Dashboard_4";

	@Given("^User is In a Dashboard page$")
	public void user_is_In_a_Dashboard_page() throws Throwable {
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

	@When("^user Clicks on any page to change , next , prev when page size set to Ten$")
	public void user_Clicks_on_any_page_to_change_next_prev_when_page_size_set_to_Ten() throws Throwable {
		try{
	
			String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5));
			bp.waitForElement();
			actual[2]=dp.selectDashBoardPageSize(page);
			actual[3]=dp.navigateToNextPages();
	        bp.waitForElement();
	        actual[4]=dp.navigateToPrevPages();
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

	@Then("^Should be able to change the pagination as selected$")
	public void should_be_able_to_change_the_pagination_as_selected() throws Throwable {
		try
		{
		int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5);
		actual[5]=dp.validatePageSize(page);
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

	@When("^User clicks on any page to change , next , prev when page size set to Twenty five$")
	public void user_clicks_on_any_page_to_change_next_prev_when_page_size_set_to_Twenty_five() throws Throwable {
		
		try{
			
			String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 2, 5));
			bp.waitForElement();
			actual[6]=dp.selectDashBoardPageSize(page);
			actual[7]=dp.navigateToNextPages();
	        bp.waitForElement();
	        actual[8]=dp.navigateToPrevPages();
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

	@Then("^should be able to change pagination as selected$")
	public void should_be_able_to_change_pagination_as_selected() throws Throwable {
		try
		{
		int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 2, 5);
		actual[9]=dp.validatePageSize(page);
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

	@When("^User clicks On any page to change , next , prev when page size set to Fifty$")
	public void user_clicks_On_any_page_to_change_next_prev_when_page_size_set_to_Fifty() throws Throwable {

		try{
			bp=new BasePage();	
			String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 5));
			actual[10]=dp.selectDashBoardPageSize(page);
			actual[11]=dp.navigateToNextPages();
	        bp.waitForElement();
	        actual[12]=dp.navigateToPrevPages();
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

	@Then("^Should be able to Change Pagination as Selected$")
	public void should_be_able_to_Change_Pagination_as_Selected() throws Throwable {
		try
		{
			int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 5);
			actual[13]=dp.validatePageSize(page);
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

	@When("^User clicks On any page to change , next , prev when page size set to Hundred$")
	public void user_clicks_On_any_page_to_change_next_prev_when_page_size_set_to_Hundred() throws Throwable {

		try{
			bp=new BasePage();	
			String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 5));
			actual[14]=dp.selectDashBoardPageSize(page);
			actual[15]=dp.navigateToNextPages();
	        bp.waitForElement();
	        actual[16]=dp.navigateToPrevPages();
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

	@Then("^should be Able to Change pagination as selected$")
	public void should_be_Able_to_Change_pagination_as_selected() throws Throwable {
		try
		{
			int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 5);
			actual[17]=dp.validatePageSize(page);
			
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
