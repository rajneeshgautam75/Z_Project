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

public class Project_Status_Gadget_14 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	DashBoardPage db;
	
	String fileName="Project_Status_Gadget_14";
	

	 boolean[] actual=new boolean[54];
		SoftAssert soft=new SoftAssert();


@Given("^Login as Manager role$")
public void login_as_Manager_role() throws Throwable {
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

@When("^Manager click on dashboard$")
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

@Then("^Dashboard Page Should be displayed$")
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

@When("^Manager creates a new dashboard$")
public void manager_creates_a_new_dashboard() throws Throwable {

	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 4);
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

@Then("^dashboard Should be created successfully$")
public void dashboard_Should_be_created_successfully() throws Throwable {
	try
	{
	String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 1);
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

@When("^Manager add Project Status Gadget$")
public void manager_add_Project_Status_Gadget() throws Throwable {
	 try
	   {
		 String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 1);
		 actual[9]=db.selectDashboard(dashBoard);
		 actual[10]=db.clickOnAddGadgetSymbol();
	   String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 32, 5);
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

@When("^attempt to select assigned project$")
public void attempt_to_select_assigned_project() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	actual[12]=db.configureProjectStatusGadget(projectName);
	actual[13]=db.saveGadget();
   
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

@Then("^should be able to add Assigned project to Project Status Gadget$")
public void should_be_able_to_add_Assigned_project_to_Project_Status_Gadget() throws Throwable {
    
	try
	{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		actual[14]=db.validateSavedGadget(projectName);
	
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


@When("^Lead navigates to dashboard page$")
public void lead_navigates_to_dashboard_page() throws Throwable {
	 try
	  {
		 actual[15]=pp.clickOnLogout();
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
	   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_1");
	   actual[16]=lp.enterUnameAndPassword(userName, passWord);
	   
	   actual[17]=db.clickOnManageDashboards();
	   
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

@Then("^Dashboard Page should be Displayed$")
public void dashboard_Page_should_be_Displayed() throws Throwable {
	 try
	    {
		 actual[18]=db.validateDashboards();
		
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

@When("^Lead creates a new Dashboard$")
public void lead_creates_a_new_Dashboard() throws Throwable {
	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 4);
	   actual[19]=db.clickOnAddDashBoardSymbol();
	   actual[20]=db.enterDashBoardDetails(name, description, layout, shareType);
	
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

@Then("^dashboard should be Added succesfully$")
public void dashboard_should_be_Added_succesfully() throws Throwable {

	try
	{
	 String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 1);
	 actual[21]=db.validateDashBoard(dashBoard);
		
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

@When("^Lead add Project Status Gadget$")
public void lead_add_Project_Status_Gadget() throws Throwable {
	try
	{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 33, 5);
		actual[22]=db.selectDashboard(dashBoard);
		actual[23]=db.clickOnAddGadgetSymbol();
		actual[24]=db.addGadget(gadgetName);
	
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

@When("^attempt to select assigned project to Project Status Gadget$")
public void attempt_to_select_assigned_project_to_Project_Status_Gadget() throws Throwable {
	 try
	   {
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		   actual[25]=db.configureProjectStatusGadget(projectName);
		   actual[26]=db.saveGadget();
		
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

@Then("^Should be able to add assigned project to Project Status Gadget$")
public void should_be_able_to_add_assigned_project_to_Project_Status_Gadget() throws Throwable {
	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	 actual[27]=db.validateSavedGadget(projectName);
}

@When("^Tester navigates to dashboard page$")
public void tester_navigates_to_dashboard_page() throws Throwable {
	try
	{
		actual[28]=pp.clickOnLogout();
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Username_1");
	   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Password_1");
	   actual[29]=lp.enterUnameAndPassword(userName, passWord);
	   
	   actual[30]= db.clickOnManageDashboards();
	   
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

@Then("^dashboard page Should be Displayed$")
public void dashboard_page_Should_be_Displayed() throws Throwable {
	 try
	    {
		 actual[31]=db.validateDashboards();
		
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

@When("^Tester creates a new dashboard$")
public void tester_creates_a_new_dashboard() throws Throwable {
	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 4);
	   actual[32]=db.clickOnAddDashBoardSymbol();
	   actual[33]=db.enterDashBoardDetails(name, description, layout, shareType);
	
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

@Then("^dashborad should be created successfully$")
public void dashborad_should_be_created_successfully() throws Throwable {
	try
	{
	String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 1);
	actual[34]=db.validateDashBoard(dashBoard);
		
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

@When("^Tester add Project Status Gadget$")
public void tester_add_Project_Status_Gadget() throws Throwable {

	try
	{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 34, 5);
		actual[35]=db.selectDashboard(dashBoard);
		actual[36]=db.clickOnAddGadgetSymbol();
		actual[37]=db.addGadget(gadgetName);
	
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


@When("^attempt to add assigned project to Project Status Gadget$")
public void attempt_to_add_assigned_project_to_Project_Status_Gadget() throws Throwable {
	try
	{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		actual[38]=db.configureProjectStatusGadget(projectName);
		actual[39]=db.saveGadget();
	
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

@Then("^should be able to Add assigned project to Project Status Gadget$")
public void should_be_able_to_Add_assigned_project_to_Project_Status_Gadget() throws Throwable {
	try
	{
		
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	//db.ValidateAddedProjectInGadget(projectName);
		actual[40]=db.validateSavedGadget(projectName);
	
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

@When("^Custom user navigates to dashboard page$")
public void custom_user_navigates_to_dashboard_page() throws Throwable {
	try
	{
		actual[41]=pp.clickOnLogout();
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_2");
	   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_2");
	   actual[42]= lp.enterUnameAndPassword(userName, passWord);
	   
	   actual[43]=db.clickOnManageDashboards();
	   
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


@Then("^dashboard page Should be_displayed$")
public void dashboard_page_Should_be_displayed() throws Throwable {
	try
	{
		actual[44]=db.validateDashboards();	
			
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

@When("^custom user Add new dashboard$")
public void custom_user_Add_new_dashboard() throws Throwable {

	try
	{
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 1);
	   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 4);
	   actual[45]=db.clickOnAddDashBoardSymbol();
	   actual[46]=db.enterDashBoardDetails(name, description, layout, shareType);
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

@Then("^new dashboard should be added Succesfully$")
public void new_dashboard_should_be_added_Succesfully() throws Throwable {
	try
	{
	String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 1);
	actual[47]=db.validateDashBoard(dashBoard);
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

@When("^custom user Add Project Status Gadget$")
public void custom_user_Add_Project_Status_Gadget() throws Throwable {
	try
	{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 1);
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 35, 5);
		actual[48]=db.selectDashboard(dashBoard);
		actual[49]=db.clickOnAddGadgetSymbol();
		actual[50]=db.addGadget(gadgetName);
	
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

@When("^attempt to Select assigned project to Project Status Gadget$")
public void attempt_to_Select_assigned_project_to_Project_Status_Gadget() throws Throwable {
	   
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		actual[51]=db.configureProjectStatusGadget(projectName);
		actual[52]=db.saveGadget();
		
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







@Then("^should be able to add assigned project to Project Status gadget$")
public void should_be_able_to_add_assigned_project_to_Project_Status_gadget() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	actual[53]=db.validateSavedGadget(projectName);
	
	pp.backToProjectPage();
	//db.ValidateAddedProjectInGadget(projectName);
	
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

