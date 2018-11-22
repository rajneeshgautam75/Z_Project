package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_18 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage db;
	String fileName="Dashboard_18";
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in the project page and launch dashboard$")
	public void user_in_the_project_page_and_launch_dashboard() throws Throwable 
	{
		  try
		   {
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   db=new DashBoardPage(driver);
			   actual[1]= db.clickOnManageDashboards();
				
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

	@When("^create dasboard$")
	public void create_dasboard() throws Throwable 
	{
		try
		   {
				db=new DashBoardPage(driver);
				bp=new BasePage();
				actual[3]=db.clickOnAddDashBoardSymbol();
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,0);
				String desc=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,1);
				String layout=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,2);
				String shareType=Excel_Lib.getData(INPUT_PATH_4, "Dashboard",1,3);
				actual[4]=db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
				actual[5]=db.validateDashBoard(dashboardName);
				
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

	@When("^select dashboard and add Test Automation Status Gadget$")
	public void select_dashboard_and_add_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		   {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,0);
			actual[6]=db.selectDashboard(dashboardName);
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
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

	@When("^save and delete the Test Automation Status Gadget$")
	public void save_and_delete_the_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
		 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
		 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5); 
		 actual[9]=db.configureTestAutomationStatusGadget(projectName, release, refreshRate);
		 String delete=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,6);
		 db.gadgetOperation(delete);
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

	@When("^add Test Automation Status Gadget and delete$")
	public void add_Test_Automation_Status_Gadget_and_delete() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			 String delete=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,6);
			 db.gadgetOperation(delete);
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

	@Then("^add Test Automation Status Gadget and minimize then delete$")
	public void add_Test_Automation_Status_Gadget_and_minimize_then_delete() throws Throwable 
	{
		try
		{
			
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5); 
			 actual[9]=db.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 String minimize=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,6);
			 db.gadgetOperation(minimize);
			 String delete=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,6);
			 db.gadgetOperation(delete);
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

	@Then("^add Test Automation Status Gadget and delete maximized gadget$")
	public void add_Test_Automation_Status_Gadget_and_delete_maximized_gadget() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			 String delete=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,6);
			 db.gadgetOperation(delete);
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
	
	@Then("^add Test Automation Status Gadget and click on delete and cancel the confirmation$")
	public void add_Test_Automation_Status_Gadget_and_click_on_delete_and_cancel_the_confirmation() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			 bp.waitForElement();
			 db.gadgetOption.click();
			 String value=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,6); 
			// db.gadgetOperation(value)
			 WebElement ele=driver.findElement(By.xpath(db.gadgetVal1+value+db.gadgetVal2));
			 
			 bp.moveToElementAndClick(ele);
//			driver.findElement(By.xpath("//a[text()='Delete']")).click();
			bp.waitForElement();
			 bp.moveToElementAndClick(db.gadgetCancel);
			
//			driver.findElement(By.xpath("(//button[text()='Cancel'])[2]")).click();
			bp.waitForElement();
			
			
			pp.backToProjectPage();
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

}
