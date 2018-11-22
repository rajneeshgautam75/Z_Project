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

public class Project_Status_Gadget_13 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	DashBoardPage db;
	
	String fileName="Project_Status_Gadget_13";
	 boolean[] actual=new boolean[50];
		SoftAssert soft=new SoftAssert();
	

@Given("^Login as manager role$")
public void login_as_manager_role() throws Throwable {
	try
	{
	   pp=new ProjectPage(driver);
	   lp=new LoginPage(driver);
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
	   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
	   
	   actual[0]=pp.clickOnLogout();
	   actual[1]=lp.enterUname(userName);
	   actual[2]=lp.enterPass(passWord);
	   actual[3]=lp.clickOnLogin();
	   
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^manager click on dashboard$")
public void manager_click_on_dashboard() throws Throwable {
	try
	{
	db=new DashBoardPage(driver);
	actual[4]=db.clickOnManageDashboards();
	   
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^dashboard Page Should be displayed$")
public void dashboard_Page_Should_be_displayed() throws Throwable {
	try
	{
		actual[5]=db.validateDashboards();
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^manager creates a new dashboard$")
public void manager_creates_a_new_dashboard() throws Throwable {

	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 4);
	   actual[6]=db.clickOnAddDashBoardSymbol();
	   actual[7]=db.enterDashBoardDetails(name, description, layout, shareType);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
	
}

@Then("^dashboard successfully created$")
public void dashboard_successfully_created() throws Throwable {
	try
	{
	String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 1);
	actual[8]=db.validateDashBoard(dashBoard);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^manager add Project Status Gadget$")
public void manager_add_Project_Status_Gadget() throws Throwable {
   try
   {
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 1);
		  String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 5);
		  actual[9]=db.selectDashboard(dashBoard);
		  actual[10]=db.clickOnAddGadgetSymbol();
 
   
		  actual[11]=db.addGadget(gadgetName);
   
   }
	catch(Exception e)
   {
    lb=new LaunchBrowser();
    e.printStackTrace();
    lb.getScreenShot(fileName);
    driver.close();
    Relogin_TPE rl=new Relogin_TPE();
    rl.reLogin();
    throw e;
  }   
}

@When("^attempt to select unassigned project$")
public void attempt_to_select_unassigned_project() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
	actual[12]=db.configureProjectStatusGadget(projectName);
   
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^should not be able to add unassigned project to Project Status Gadget$")
public void should_not_be_able_to_add_unassigned_project_to_Project_Status_Gadget() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
	actual[13]=db.ValidateAddedProjectInGadget(projectName);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^lead navigates to dashboard page$")
public void lead_navigates_to_dashboard_page() throws Throwable {
  try
  {
	  actual[14]=pp.clickOnLogout();
   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_1");
   actual[15]=lp.enterUnameAndPassword(userName, passWord);
   
   actual[16]=db.clickOnManageDashboards();
   
  }
	catch(Exception e)
  {
   lb=new LaunchBrowser();
   e.printStackTrace();
   lb.getScreenShot(fileName);
   driver.close();
   Relogin_TPE rl=new Relogin_TPE();
   rl.reLogin();
   throw e;
 }   
}

@Then("^dashboard Page should be displayed$")
public void dashboard_Page_should_be_displayed1() throws Throwable {
    try
    {
    	actual[17]=db.validateDashboards();
	
    }
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^lead creates a new Dashboard$")
public void lead_creates_a_new_Dashboard() throws Throwable {

	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 29, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 29, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 29, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 29, 4);
	   actual[18]=db.clickOnAddDashBoardSymbol();
	   actual[19]=db.enterDashBoardDetails(name, description, layout, shareType);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^dashboard should be added succesfully$")
public void dashboard_should_be_added_succesfully() throws Throwable {
 
	try
	{
	 String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 29, 1);
	 actual[20]=db.validateDashBoard(dashBoard);
		
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^lead add Project Status Gadget$")
public void lead_add_Project_Status_Gadget() throws Throwable {

	try
	{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 29, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 5);
		actual[21]=db.selectDashboard(dashBoard);
		actual[22]=db.clickOnAddGadgetSymbol();
		actual[23]=db.addGadget(gadgetName);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^attempt to select unassigned project to Project Status Gadget$")
public void attempt_to_select_unassigned_project_to_Project_Status_Gadget() throws Throwable {
   try
   {
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
	   actual[24]=db.configureProjectStatusGadget(projectName);
	
   }
	catch(Exception e)
   {
    lb=new LaunchBrowser();
    e.printStackTrace();
    lb.getScreenShot(fileName);
    driver.close();
    Relogin_TPE rl=new Relogin_TPE();
    rl.reLogin();
    throw e;
  }   
}

@Then("^Should not be able to add unassigned project to Project Status Gadget$")
public void should_not_be_able_to_add_unassigned_project_to_Project_Status_Gadget1() throws Throwable {
 try
 {
	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
	 actual[25]=db.ValidateAddedProjectInGadget(projectName);
	
 }
	catch(Exception e)
 {
  lb=new LaunchBrowser();
  e.printStackTrace();
  lb.getScreenShot(fileName);
  driver.close();
  Relogin_TPE rl=new Relogin_TPE();
  rl.reLogin();
  throw e;
}   
}

@When("^tester navigates to dashboard page$")
public void tester_navigates_to_dashboard_page() throws Throwable {
	try
	{
		actual[26]=pp.clickOnLogout();
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Username_1");
	   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Password_1");
	   actual[27]=lp.enterUnameAndPassword(userName, passWord);
	   
	   actual[28]=db.clickOnManageDashboards();
	   
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^Dashboard Page should be displayed$")
public void dashboard_Page_should_be_displayed() throws Throwable {
    try
    {
    	actual[29]=db.validateDashboards();
	
    }
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^tester creates a new dashboard$")
public void tester_creates_a_new_dashboard() throws Throwable {

	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 30, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 30, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 30, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 30, 4);
	   actual[30]=db.clickOnAddDashBoardSymbol();
	   actual[31]=db.enterDashBoardDetails(name, description, layout, shareType);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^dashborad created successfully$")
public void dashborad_created_successfully() throws Throwable {
	try
	{
	String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 30, 1);
	actual[32]=db.validateDashBoard(dashBoard);
		
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^tester add Project Status Gadget$")
public void tester_add_Project_Status_Gadget() throws Throwable {

	try
	{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 30, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 5);
		actual[33]=db.selectDashboard(dashBoard);
		actual[34]=db.clickOnAddGadgetSymbol();
		actual[35]=db.addGadget(gadgetName);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^attempt to add unassigned project to Project Status Gadget$")
public void attempt_to_add_unassigned_project_to_Project_Status_Gadget() throws Throwable {
	try
	{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[36]=db.configureProjectStatusGadget(projectName);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^should not be able to Add unassigned project to Project Status Gadget$")
public void should_not_be_able_to_Add_unassigned_project_to_Project_Status_Gadget() throws Throwable {
	try
	{
		
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[37]=db.ValidateAddedProjectInGadget(projectName);
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@When("^custom user navigates to dashboard page$")
public void custom_user_navigates_to_dashboard_page() throws Throwable {
	try
	{
		actual[38]=pp.clickOnLogout();
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_2");
	   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_2");
	   actual[39]=lp.enterUnameAndPassword(userName, passWord);
	   
	   actual[40]=db.clickOnManageDashboards();
	   
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
}

@Then("^dashboard Page Should be Displayed$")
public void dashboard_Page_Should_be_Displayed() throws Throwable {
try
{
	actual[41]=db.validateDashboards();	
		
}
catch(Exception e)
{
 lb=new LaunchBrowser();
 e.printStackTrace();
 lb.getScreenShot(fileName);
 driver.close();
 Relogin_TPE rl=new Relogin_TPE();
 rl.reLogin();
 throw e;
}   
}

@When("^custom user add new dashboard$")
public void custom_user_add_new_dashboard() throws Throwable {

	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 31, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 31, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 31, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 31, 4);
	   actual[42]=db.clickOnAddDashBoardSymbol();
	   actual[43]=db.enterDashBoardDetails(name, description, layout, shareType);
	}
	catch(Exception e)
	{
	 lb=new LaunchBrowser();
	 e.printStackTrace();
	 lb.getScreenShot(fileName);
	 driver.close();
	 Relogin_TPE rl=new Relogin_TPE();
	 rl.reLogin();
	 throw e;
	}   
	
}

@Then("^new dashboard should be added succesfully$")
public void new_dashboard_should_be_added_succesfully() throws Throwable {
	try
	{
	String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 31, 1);
	actual[44]=db.validateDashBoard(dashBoard);
	}
	catch(Exception e)
	{
	 lb=new LaunchBrowser();
	 e.printStackTrace();
	 lb.getScreenShot(fileName);
	 driver.close();
	 Relogin_TPE rl=new Relogin_TPE();
	 rl.reLogin();
	 throw e;
	}   
}

@When("^custom user add Project Status Gadget$")
public void custom_user_add_Project_Status_Gadget() throws Throwable {

	try
	{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 31, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 28, 5);
		actual[45]=db.selectDashboard(dashBoard);
		actual[46]=db.clickOnAddGadgetSymbol();
		actual[47]=db.addGadget(gadgetName);
	
	}
	catch(Exception e)
	{
	 lb=new LaunchBrowser();
	 e.printStackTrace();
	 lb.getScreenShot(fileName);
	 driver.close();
	 Relogin_TPE rl=new Relogin_TPE();
	 rl.reLogin();
	 throw e;
	}   
}

@When("^attempt to Select unassigned project to Project Status Gadget$")
public void attempt_to_Select_unassigned_project_to_Project_Status_Gadget() throws Throwable {
	   
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
	actual[48]=db.configureProjectStatusGadget(projectName);
	
	}
	catch(Exception e)
	{
	 lb=new LaunchBrowser();
	 e.printStackTrace();
	 lb.getScreenShot(fileName);
	 driver.close();
	 Relogin_TPE rl=new Relogin_TPE();
	 rl.reLogin();
	 throw e;
	}   
}

@Then("^should not be able to add unassigned project to Project Status gadget$")
public void should_not_be_able_to_add_unassigned_project_to_Project_Status_gadget() throws Throwable {
	
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
	actual[49]=db.ValidateAddedProjectInGadget(projectName);
	
	pp.backToProjectPage();
	
	 for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
	}
	catch(Exception e)
	{
	 lb=new LaunchBrowser();
	 e.printStackTrace();
	 lb.getScreenShot(fileName);
	 driver.close();
	 Relogin_TPE rl=new Relogin_TPE();
	 rl.reLogin();
	 throw e;
	}   
	 
}
	
	

}