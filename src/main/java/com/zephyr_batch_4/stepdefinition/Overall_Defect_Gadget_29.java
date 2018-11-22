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

public class Overall_Defect_Gadget_29 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();
    String fileName="Overall_Defect_Gadget_29";
	@Given("^user logins as Manager credentials$")
	public void user_logins_as_Manager_credentials() throws Throwable {
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

	@When("^User Is In a DashBoard Page$")
	public void user_Is_In_a_DashBoard_Page() throws Throwable {
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

	@Then("^user should be launched the dashboard window$")
	public void user_should_be_launched_the_dashboard_window() throws Throwable {
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

	@When("^user adds a five new dashboards by clicking on plus button$")
	public void user_adds_a_five_new_dashboards_by_clicking_on_plus_button() throws Throwable {
		try
		   {
			for(int i=0;i<5;i++)
			{
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 13+i, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[5]=dp.clickOnAddDashBoardSymbol();
		   actual[6]=dp.enterDashBoardDetails(name, description, layout, shareType);
			}
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

	@Then("^dashboards should be created$")
	public void dashboards_should_be_created() throws Throwable {
		try
		{
			for(int i=0;i<5;i++)
			{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 13+i, 1);
			bp.waitForElement();
			actual[7]=dp.validateDashBoard(name);
			}
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

	@When("^user clicks on added new dashboard$")
	public void user_clicks_on_added_new_dashboard() throws Throwable {
		try
		{
			for(int i=0;i<5;i++)
			{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 13+i, 1);
			actual[8]=bp.waitForElement();
			pp.backToProjectPage();
			bp.waitForElement();
			actual[9]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[10]=dp.searchDashboard(name);
			bp.waitForElement();
			actual[11]=dp.selectDashboard(name);
			}
			
			
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


	@When("^user adds Overall Defects Gadget By clicking on plus button in all added dashboards$")
	public void user_adds_Overall_Defects_Gadget_By_clicking_on_plus_button_in_all_added_dashboards() throws Throwable {
		try
		{
			for(int i=0;i<5;i++)
			{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 13+i, 1);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			actual[12]=bp.waitForElement();
			pp.backToProjectPage();
			bp.waitForElement();
			actual[13]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[14]=dp.searchDashboard(name);
			bp.waitForElement();
			actual[15]=dp.selectDashboard(name);
			bp.waitForElement();
			actual[16]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[17]=dp.addGadget(gadgetName);
			bp.waitForElement();
			}
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

	@Then("^Should be able to Add Overall Defect Gadget$")
	public void should_be_able_to_Add_Overall_Defect_Gadget() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			int gadgetCount=dp.totalGadgetCount(gadgetName);
			bp.waitForElement();
			
			
			if(gadgetCount==1)
			{
				System.out.println("Overall Defects Gadget is Added");
			}
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
