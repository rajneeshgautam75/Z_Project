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

public class Overall_Defect_Gadget_8 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
    String fileName="Overall_Defect_Gadget_7";
	@Given("^User logins as manager credentials$")
	public void user_logins_as_manager_credentials() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			lp=new LoginPage(driver);
			dp=new DashBoardPage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		    bp.waitForElement();
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

	@Then("^Should be able to Login Successfully$")
	public void should_be_able_to_Login_Successfully() throws Throwable {
		try
	    {
	    	actual[3]=lp.verifyLoginTitle();
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

	@When("^User is in DashBoardPage$")
	public void user_is_in_DashBoardPage() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[4]=dp.clickOnManageDashboards();
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

	@Then("^should be able to launch dashboard window$")
	public void should_be_able_to_launch_dashboard_window() throws Throwable {
		try
		{
			actual[5]=dp.validateDashboards();
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

	@When("^user adds a new dashboard by clicking On Plus Button$")
	public void user_adds_a_new_dashboard_by_clicking_On_Plus_Button() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 11, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[6]=dp.clickOnAddDashBoardSymbol();
		   actual[7]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^DashBoard to be able to Create$")
	public void dashboard_to_be_able_to_Create() throws Throwable {
		try
		{
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 11, 1);
			actual[8]=dp.validateDashBoard(name);
			
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

	@When("^user selects an added DashBoard$")
	public void user_selects_an_added_DashBoard() throws Throwable {
		try
		{
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 11, 1);
			actual[9]=dp.selectDashboard(name);
			
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

	@Then("^should select added dashboard$")
	public void should_select_added_dashboard() throws Throwable {
		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 11, 1);
			bp.waitForElement();
			actual[10]=dp.validateDashBoard(dashBoard);
			
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

	@When("^User Adds overall defects gadget by clicking on plus button$")
	public void user_Adds_overall_defects_gadget_by_clicking_on_plus_button() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			bp.waitForElement();
			actual[11]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[12]=dp.addGadget(gadgetName);
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

	@Then("^overall defect gadget should be able to add$")
	public void overall_defect_gadget_should_be_able_to_add() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			bp.waitForElement();
			actual[13]=dp.validateGadget(gadgetName);
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

	@When("^user selects project,release and refresh rate as one day,save it$")
	public void user_selects_project_release_and_refresh_rate_as_one_day_save_it() throws Throwable {
		
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 7);
			actual[14]=dp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^overall defect gadget should be able to save$")
	public void overall_defect_gadget_should_be_able_to_save() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			actual[15]=dp.validateSavedGadget(projectName, release);
			bp.waitForElement();
			pp.navigateToProjectPage();
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
