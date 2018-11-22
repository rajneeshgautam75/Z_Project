package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Overall_Defect_Gadget_35 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[15];
	SoftAssert soft=new SoftAssert();
    String fileName="Overall_Defect_Gadget_35";
	
    @Given("^user Logins as Tester$")
    public void user_Logins_as_Tester() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			lp=new LoginPage(driver);
			dp=new DashBoardPage(driver);
		    bp.waitForElement();
		    String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		    pp.clickOnLogout();
			bp.waitForElement();
			bp.waitForElement();
			actual[0]=lp.enterUname(uname);
			actual[1]=lp.enterPass(password);
			actual[2]=lp.clickOnLogin();
			
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

	@When("^user clicks on Dashboard$")
	public void user_clicks_on_Dashboard() throws Throwable {
		
		try
		{
			bp.waitForElement();
			actual[3]=dp.clickOnManageDashboards();
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

	@Then("^Should be launched dashboard window$")
	public void should_be_launched_dashboard_window() throws Throwable {
		try
		{
			actual[4]=dp.validateDashboards();
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

	@When("^user adds a new dashboard by clicking on \\+ button$")
	public void user_adds_a_new_dashboard_by_clicking_on_button() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
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

	@Then("^Dashboard should be added$")
	public void dashboard_should_be_added() throws Throwable {
		try
		{
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
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
	@When("^user selects the added DashBoard$")
	public void user_selects_the_added_DashBoard() throws Throwable {
		try
		{
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
			actual[8]=dp.selectDashboard(name);
			
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

	@Then("^DashBoard should be selected$")
	public void dashboard_should_be_selected() throws Throwable {
		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
			bp.waitForElement();
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

	@When("^user adds Multiple \"([^\"]*)\" By Clicking on '\\+' button$")
	public void user_adds_Multiple_By_Clicking_on_button(String arg1) throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			bp.waitForElement();
			actual[10]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[11]=dp.addGadget(gadgetName);
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

	@Then("^Overall defect gadget should be added$")
	public void overall_defect_gadget_should_be_added() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			bp.waitForElement();
			actual[12]=dp.validateGadget(gadgetName);
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

	@When("^User Changes the layout from (\\d+) to (\\d+)$")
	public void user_Changes_the_layout_from_to(int arg1, int arg2) throws Throwable {
		try
		{
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			bp.waitForElement();
			actual[13]=dp.layoutSelection(layout);
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

	@Then("^Should become (\\d+) column layout$")
	public void should_become_column_layout(int arg1) throws Throwable {
		try
		{
			
			bp.waitForElement();
			dp.validateLayoutType();
		    System.out.println("Should become two column layout");	
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

	@When("^user changes layout from (\\d+) to (\\d+)$")
	public void user_changes_layout_from_to(int arg1, int arg2) throws Throwable {
		try
		{
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 4);
			bp.waitForElement();
			actual[14]=dp.layoutSelection(layout);
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

	@Then("^should become (\\d+) column layout$")
	public void should_become_column_layout1(int arg1) throws Throwable {
		try
		{
			System.out.println("Should become one column layout");
			dp.validateLayoutType();
			bp.waitForElement();
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
