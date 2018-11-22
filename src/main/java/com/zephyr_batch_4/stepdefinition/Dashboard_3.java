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

public class Dashboard_3 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
	String fileName="Dashboard_3";

	@Given("^User is In DashBoard Page$")
	public void user_is_In_DashBoard_Page() throws Throwable {
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

	@When("^user have more than hundred dashboards and change pagination from ten to twenty five$")
	public void user_have_more_than_hundred_dashboards_and_change_pagination_from_ten_to_twenty_five() throws Throwable {
		try{
			for(int i=0;i<=50;i++)
			{  
			   bp.waitForElement();
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1+i, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   bp.waitForElement();
			   actual[2]=dp.clickOnAddDashBoardSymbol();
			   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
			}
		String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5));
		String pageNumber=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 2, 5));
		actual[4]=dp.selectDashBoardPageSize(page);
		bp.waitForElement();
		actual[5]=dp.selectDashBoardPageSize(pageNumber);
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

	@Then("^user able to view the selected page size$")
	public void user_able_to_view_the_selected_page_size() throws Throwable {
		try
		{
			int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5);
			actual[6]=dp.validatePageSize(page);
		    
			
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

	@When("^user have more than hundred dashboard and changes pagination to fifty$")
	public void user_have_more_than_hundred_dashboard_and_changes_pagination_to_fifty() throws Throwable {
		try{
		String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 5));
		bp.waitForElement();
		actual[7]=dp.selectDashBoardPageSize(page);
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

	@Then("^User Able to view the selected page size$")
	public void user_Able_to_view_the_selected_page_size() throws Throwable {
	   try
	   {
		   int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 5);
		   actual[8]=dp.validatePageSize(page);
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

	@When("^user have more than hundred dashboards and changes pagination to hundred$")
	public void user_have_more_than_hundred_dashboards_and_changes_pagination_to_hundred() throws Throwable {
		try{
			
		String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 5));
		bp.waitForElement();
		actual[9]=dp.selectDashBoardPageSize(page);
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

	@Then("^user Able to view the Selected page size$")
	public void user_Able_to_view_the_Selected_page_size() throws Throwable {
		try
		   {
			int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 5);
			actual[10]=dp.validatePageSize(page);
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

	@When("^user have more than hundred DashBoard and Changes pagination to from hundred/fifty/twentyfive to ten$")
	public void user_have_more_than_hundred_DashBoard_and_Changes_pagination_to_from_hundred_fifty_twentyfive_to_ten() throws Throwable {
	    
		try{
			bp.waitForElement();
			String page=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 5));
			String pageNumber=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 5));
			String pageNumber_1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 2, 5));
			String pageNumber_2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5));
			actual[11]=dp.selectDashBoardPageSize(page);
			bp.waitForElement();
			actual[12]=dp.selectDashBoardPageSize(pageNumber);
			bp.waitForElement();
			actual[13]=dp.selectDashBoardPageSize(pageNumber_1);
			bp.waitForElement();
			actual[14]=dp.selectDashBoardPageSize(pageNumber_2);
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

	@Then("^User able to see the selected page size$")
	public void user_able_to_see_the_selected_page_size() throws Throwable {
		try
		   {
			int page=Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 1, 5);
			actual[15]=dp.validatePageSize(page);
			
			
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
