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

public class ExecutionBacklog_23 extends LaunchBrowser
{

	ProjectPage pp;
	LoginPage lp;
	DashBoardPage db;
	BasePage bp;
	String dashboardName;
	String userName;
	String passWord;
	
	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "ExecutionBacklog_23";

	boolean[] actual = new boolean[14];
	SoftAssert soft = new SoftAssert();
	
	@Given("^Login as different user credential \"([^\"]*)\"$")
	public void login_as_different_user_credential(String users) throws Throwable {
		try
		{	
		pp=new ProjectPage(driver);
		lp=new LoginPage(driver);
		bp=new BasePage();
		
		
		if(users.equals("Manager"))
		{
		userName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH,"Manager_Username_1");
		 passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH,"Manager_Password_1");
		}
		else if(users.equals("Lead"))
		{
		 userName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Username_1");
		 passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Password_1");
		}
		
		else if(users.equals("Tester"))
		{
		 userName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Tester_Username_1");
		 passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Tester_Password_1");
		}
		else if(users.equals("CustomRole"))
		{
		 userName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Username_2");
		 passWord = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_Password_2");
		}
		
		System.out.println(userName);
		actual[0]=pp.clickOnLogout();
		actual[1]=lp.enterUname(userName);
		actual[2]=lp.enterPass(passWord);
		actual[3]=lp.clickOnLogin();
		
	} 
		catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
	}

	@When("^user click on manage Dashboard$")
	public void user_click_on_manage_Dashboard() throws Throwable {
		 try
		    {
			db=new DashBoardPage(driver);
			actual[4]=db.clickOnManageDashboards();
		    
		    } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			}

	}

	@Then("^Manage dashboard page should be visible$")
	public void manage_dashboard_page_should_be_visible() throws Throwable {
		try
		{
		actual[5]=db.validateDashboards();
		
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user \"([^\"]*)\" add new dashboards with Fields$")
	public void user_add_new_dashboards_with_Fields(String users) throws Throwable {

		try
		{
			
		if(users.equals("Manager"))
		{
		 	dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 1);
		 	
		}
		if(users.equals("Lead"))
		{
		 dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 57, 1);
		
		}
		if(users.equals("Tester"))
		{
		 	dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 58, 1);
		 	
		}
		if(users.equals("CustomRole"))
		{
		 	dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 59, 1);
		 	
		}
		
		String desc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 2);
		String layout = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 3);
		String shareType = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 4);

		actual[6] = db.clickOnAddDashBoardSymbol();
		actual[7] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^dashboard \"([^\"]*)\" should be created successfuly$")
	public void dashboard_should_be_created_successfuly(String users) throws Throwable {
		try {
			
			if(users.equals("Manager"))
			{
			 	dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 1);
			}
			if(users.equals("Lead"))
			{
			 dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 57, 1);
			}
			if(users.equals("Tester"))
			{
			 	dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 58, 1);
			}
			if(users.equals("CustomRole"))
			{
			 	dashboardName=UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 59, 1);
			}
			
		
			actual[8] = db.validateDashBoard(dashboardName);
			actual[9] =db.selectDashboard(dashboardName);
			
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
	

@When("^user Add Execution backolg gadget and minimize it$")
public void user_Add_Execution_backolg_gadget_and_minimize_it() throws Throwable {
	try
	{
	String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 5);
	actual[10] = db.clickOnAddGadgetSymbol();
	actual[11] = db.addGadget(gadgetName);
	
	String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 12);
	db.gadgetOperation(value);
	
	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
}


	

	@Then("^Execution backlog gadget should be addded successfully$")
	public void execution_backlog_gadget_should_be_addded_successfully() throws Throwable {
		try
		{
		String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 5);
		actual[12] =db.validateGadget(gadgetName);
		//db.totalGadgetCount(gadgetName);
		
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user delete the minimized Added gadget$")
	public void user_delete_the_minimized_Added_gadget() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 57, 12);
		actual[13] =db.gadgetOperation(value);
		
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		   
	}

	@Then("^Gadget should be successfully deleted$")
	public void gadget_should_be_successfully_deleted() throws Throwable {
		try
		{
		String gadgetName = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 56, 5);
		int gadgetCount=db.totalGadgetCount(gadgetName);
		
		if(gadgetCount==0)
		{
			System.out.println("Minimized Gadget successfully deleted");
		}
		
		bp.waitForElement();
		pp.backToProjectPage();
		for (int k = 0; k <= actual.length - 1; k++) {
			System.out.println("Actual[" + k + "]=" + actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		
	}

}
