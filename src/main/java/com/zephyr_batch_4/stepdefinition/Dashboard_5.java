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

public class Dashboard_5 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[16];
	 SoftAssert soft=new SoftAssert();
	 String fileName="Dashboard_5";
	 
	 @Given("^User is In the Dashboard page$")
	 public void user_is_In_the_Dashboard_page() throws Throwable {
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

	 @When("^user Adds the new DashBoard$")
	 public void user_Adds_the_new_DashBoard() throws Throwable {
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
	
	


        @When("^user edits the Existing Dashboard name and save$")
        public void user_edits_the_Existing_Dashboard_name_and_save() throws Throwable {
		try
		{
			   String editName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   actual[4]=dp.clickOnEditDashBoardSymbol(editName);
			   actual[5]=dp.enterDashBoardDetails(name, description, layout, shareType);
			
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

	@Then("^Should be able to edit the dashboard name$")
	public void should_be_able_to_edit_the_dashboard_name() throws Throwable {
	   try
	   {
		   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
		   actual[6]=dp.validateDashBoard(dashBoard);
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

	@When("^User Edits the existing dashboard Description and Save$")
	public void user_Edits_the_existing_dashboard_Description_and_Save() throws Throwable {
		try
		{
			   String editName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   actual[7]=dp.clickOnEditDashBoardSymbol(editName);
			   actual[8]=dp.enterDashBoardDetails(name, description, layout, shareType);
			
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

	@Then("^Should be able to edit the dashboard description$")
	public void should_be_able_to_edit_the_dashboard_description() throws Throwable {
	   try
	   {
		   String dashBoard=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 2);
		   actual[9]=dp.validateDashBoard(dashBoard);
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

	@When("^user edits the existing dashboard Type and Save$")
	public void user_edits_the_existing_dashboard_Type_and_Save() throws Throwable {
		try
		{
			   String editName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 3);
			   actual[10]=dp.clickOnEditDashBoardSymbol(editName);
			   actual[11]=dp.enterDashBoardDetails(name, description, layout, shareType);
			
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

	@Then("^should be able to edit dashboard type$")
	public void should_be_able_to_edit_dashboard_type() throws Throwable {
		try
		{
			 String dashBoard=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 3);
			 actual[12]=dp.validateDashBoard(dashBoard);
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

	@When("^user Edits the existing dashboard layout and save$")
	public void user_Edits_the_existing_dashboard_layout_and_save() throws Throwable {
		try
		{
			   String editName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 30);
			   actual[13]=dp.clickOnEditDashBoardSymbol(editName);
			   actual[14]=dp.enterDashBoardDetails(name, description, layout, shareType);
			
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

	@Then("^should be able to edit dashboard layout$")
	public void should_be_able_to_edit_dashboard_layout() throws Throwable {
		try
		{
			 String dashBoard=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			 actual[15]=dp.validateDashBoard(dashBoard);
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
