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

public class DashBoard_Permission_5 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
    String fileName="DashBoard_Permission_5";
	@Given("^customer is in DashBoard$")
	public void customer_is_in_DashBoard() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		lp=new LoginPage(driver);
		pp.clickOnLogout();
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		actual[0]=lp.enterUname(Uname);
		System.out.println(" User name is " + Uname +"name");
		actual[1]=lp.enterPass(pass);
		System.out.println("Password is " + pass + "passsowrd");
		actual[2]=lp.clickOnLogin();
		System.out.println(Uname);
		actual[3]=bp.waitForElement();
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

	@When("^customer Attempts to Create dashboard without selecting Mandatory fields$")
	public void customer_Attempts_to_Create_dashboard_without_selecting_Mandatory_fields() throws Throwable {
		try
		   {
		   String name=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100,100);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
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

	@Then("^should not Allow to create without Selecting mandatory fileds$")
	public void should_not_Allow_to_create_without_Selecting_mandatory_fileds() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			actual[7]=dp.validateDashBoard(name);
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
