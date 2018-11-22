package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_26 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage db;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	String fileName="Dashboard_26";
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in the repository page to addphases$")
	public void user_in_the_repository_page_to_addphases() throws Throwable 
	{
		 try
		   {
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			   pp.selectProject(projectName);
			   pp.selectRelease(release1);
			   rp.clickOnTestRep();
			   tr=new TestRepositoryPage(driver);
			   String nodename[]=new String[100];
			   String desc[]=new String[100];
			   for(int i=0;i<100;i++)
			   {
					  tr.doubleClickOnRelease(release1);
					  ///////////automation testcases
					   nodename[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 69+i, 0);
					  desc[i]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 69+i, 0);
					  tr.addNode(nodename[i], desc[i]);
					  tr.doubleClickOnRelease(release1);
					  tr.selectPhase(nodename[i]);
					  tr.addTestCase();
					  tr.addTestCase();
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

	@When("^launch dashboard Add Test Automation Distribution  Gadget by selecting Ten Phase out of fifty$")
	public void launch_dashboard_Add_Test_Automation_Distribution_Gadget_by_selecting_Ten_Phase_out_of_fifty() throws Throwable 
	{
		 try
		   {
		   db=new DashBoardPage(driver);
			  db.clickOnManageDashboards();
			 
					db=new DashBoardPage(driver);
					bp=new BasePage();
					actual[3]=db.clickOnAddDashBoardSymbol();
					String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 15,0);
					String desc=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 15,1);
					String layout=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,2);
					String shareType=Excel_Lib.getData(INPUT_PATH_4, "Dashboard",1,3);
					actual[4]=db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
					actual[5]=db.validateDashBoard(dashboardName);
					
					actual[6]=db.selectDashboard(dashboardName);
					actual[7]=db.clickOnAddGadgetSymbol();
					String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,4); 
					 actual[8]=db.addGadget(gadgetName);
					 
					 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
					 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
					 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5);
					 String typeName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,7); 
					 String value[]=new String[10];
					 for(int i=0;i<10;i++)
					 {
					 value[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 69+i, 0);
					 }
					 db.configureTestAutomationDistributionGadget(projectName, release, refreshRate, typeName, value);
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

	@When("^Add Test Automation Distribution  Gadget by selecting twenty five Phase out of fifty$")
	public void add_Test_Automation_Distribution_Gadget_by_selecting_twenty_five_Phase_out_of_fifty() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,4); 
			 actual[8]=db.addGadget(gadgetName);
			 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5);
			 String typeName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,7); 
			 String value[]=new String[25];
			 for(int i=0;i<25;i++)
			 {
			 value[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 69+i, 0);
			 }
			 db.configureTestAutomationDistributionGadget(projectName, release, refreshRate, typeName, value);
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

	@When("^Add Test Automation Distribution  Gadget by selecting fifty Phase out of fifty$")
	public void add_Test_Automation_Distribution_Gadget_by_selecting_fifty_Phase_out_of_fifty() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,4); 
			 actual[8]=db.addGadget(gadgetName);
			 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5);
			 String typeName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,7); 
			 String value[]=new String[50];
			 for(int i=0;i<50;i++)
			 {
			 value[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 69+i, 0);
			 }
			 db.configureTestAutomationDistributionGadget(projectName, release, refreshRate, typeName, value);
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

	@Then("^Add Test Automation Distribution  Gadget by selecting hundred Phases$")
	public void add_Test_Automation_Distribution_Gadget_by_selecting_hundred_Phases() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,4); 
			 actual[8]=db.addGadget(gadgetName);
			 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5);
			 String typeName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,7); 
			 String value[]=new String[100];
			 for(int i=0;i<100;i++)
			 {
			 value[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 69+i, 0);
			 }
			 db.configureTestAutomationDistributionGadget(projectName, release, refreshRate, typeName, value);
			 
			 
			 pp.backToProjectPage();
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
