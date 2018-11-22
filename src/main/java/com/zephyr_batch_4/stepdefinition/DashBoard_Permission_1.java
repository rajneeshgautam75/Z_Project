package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_1 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
    String fileName="DashBoard_Permission_1";
	@Given("^user opens the DashBoard$")
	public void user_opens_the_DashBoard() throws Throwable {
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

	@Then("^user Able to Launch Dashboard page$")
	public void user_Able_to_Launch_Dashboard_page() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[2]=dp.validateDashboards();
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

	@When("^user clicks on plus button$")
	public void user_clicks_on_plus_button() throws Throwable {
		try
		{
			actual[3]=dp.clickOnAddDashBoardSymbol();
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

	@Then("^able to view Components like Name,Description,Layout and Access Type in DashBoard$")
	public void able_to_view_Components_like_Name_Description_Layout_and_Access_Type_in_DashBoard() throws Throwable {
		try
		{
			actual[4]=dp.validateDashboards();
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
