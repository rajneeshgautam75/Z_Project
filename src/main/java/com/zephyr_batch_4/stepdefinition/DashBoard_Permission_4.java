package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_4 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
    String fileName="DashBoard_Permission_4";
	@Given("^Test User is In A DashBoard Page$")
	public void test_User_is_In_A_DashBoard_Page() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		lp=new LoginPage(driver);
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
	
	@When("^Test user Create a Dashboard whose access type is type Private$")
	public void test_user_Create_a_Dashboard_whose_access_type_is_type_Private() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 2);
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

	@Then("^Should not show to Otheruser if dashboard is Private type$")
	public void should_not_show_to_Otheruser_if_dashboard_is_Private_type() throws Throwable {
		try
		  {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 2);
			actual[4]=dp.validateDashBoard(name);
			pp.clickOnLogout();
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_3");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_3");
			actual[5]=lp.enterUname(Uname);
			actual[6]=lp.enterPass(pass);
			actual[7]=lp.clickOnLogin();
			System.out.println(Uname);
			actual[8]=dp.clickOnManageDashboards();
			actual[9]=dp.searchDashboard(name);
			bp.waitForElement();
			actual[10]=dp.validateDashBoard(name);
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
