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

public class Dashboard_2 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[20];
	 SoftAssert soft=new SoftAssert();
	 String fileName="Dashboard_2";
	
	@Given("^User is in a Dashboard page$")
	public void user_is_in_a_Dashboard_page() throws Throwable {
		
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

	@When("^User creates dashboard with long name one twenty eight char$")
	public void user_creates_dashboard_with_long_name_one_twenty_eight_char() throws Throwable {
	   
		 try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   actual[2]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
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

	@Then("^user should able to create successfully$")
	public void user_should_able_to_create_successfully() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 1);
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

	@When("^user Creates dashboard with long desc with two fifty six char$")
	public void user_Creates_dashboard_with_long_desc_with_two_fifty_six_char() throws Throwable {
		 try
		   {
		  
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
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

	@Then("^User Should able to Create successfully$")
	public void user_Should_able_to_Create_successfully() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 1);
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

	@When("^User creates dashboard with name containing only lowercase char$")
	public void user_creates_dashboard_with_name_containing_only_lowercase_char() throws Throwable {
		 try
		   {
		   
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 1);
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

	@Then("^user should  able to create Successfully$")
	public void user_should_able_to_create_Successfully() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 1);
			actual[10]=dp.validateDashBoard(name);
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

	@When("^User creates dashboard with name containing only UpperCase char$")
	public void user_creates_dashboard_with_name_containing_only_UpperCase_char() throws Throwable {
		try
		   {
		   
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[11]=dp.clickOnAddDashBoardSymbol();
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

	@Then("^user should able to Create successfully$")
	public void user_should_able_to_Create_successfully() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 1);
			actual[13]=dp.validateDashBoard(name);
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

	@When("^user creates dashboard with name containing only number$")
	public void user_creates_dashboard_with_name_containing_only_number() throws Throwable {
		try
		   {
		   
		   String name=UNIQUE+Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 7, 1));
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[14]=dp.clickOnAddDashBoardSymbol();
		   actual[15]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^user sholud able to create successfully$")
	public void user_sholud_able_to_create_successfully() throws Throwable {
		try
		  {
		    String name=UNIQUE+Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 7, 1));
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

	@When("^user creates a dashboard with name containing only international char$")
	public void user_creates_a_dashboard_with_name_containing_only_international_char() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[17]=dp.clickOnAddDashBoardSymbol();
		   actual[18]=dp.enterDashBoardDetails(name, description, layout, shareType);
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


@Then("^user Should able to Create Successfully$")
public void user_Should_able_to_Create_Successfully() throws Throwable {
	try
	  {
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 1);
		actual[19]=dp.validateDashBoard(name);
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
