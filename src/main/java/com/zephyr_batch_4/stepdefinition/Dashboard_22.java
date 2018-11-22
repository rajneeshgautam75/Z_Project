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
import com.zephyr.reusablemethods.UserDefinedException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_22 extends LaunchBrowser
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
	
	String fileName="Dashboard_22";
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	 double val;
	@Given("^user in project page and select the dashboard$")
	public void user_in_project_page_and_select_the_dashboard() throws Throwable 
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
			  tr.doubleClickOnRelease(release1);
			  ///////////automation testcases
			  String node=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 0);
			  String Desc=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 1);
			  tr.addNode(node, Desc);
			  String node1[]=new String[1];
			  node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 0);
			  tr.navigateToNode(release1, node1); 
			  tr.addTestCase();
			  for(int i=0;i<8;i++)
			  {
				  
				  tr.selectallTestCase();
				  tr.cloneTestCase();
				  bp.waitForElement();
			  }
			  ///////////manual testcases
			  tr.doubleClickOnRelease(release1);
			  String manualnode=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
			  String manualDesc=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 3);
			  tr.addNode(manualnode, manualDesc);
			  String mannode1[]=new String[1];
			  mannode1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
			  tr.navigateToNode(release1, mannode1);
			  tr.addTestCase();
			  for(int i=0;i<5;i++)
			  {
				  tr.selectallTestCase();
				  tr.cloneTestCase();
				  bp.waitForElement();
			  }
			  
			   db=new DashBoardPage(driver);
			  db.clickOnManageDashboards();
				
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

	@When("^create dashboard and add automation gadjet and save$")
	public void create_dashboard_and_add_automation_gadjet_and_save() throws Throwable
	{
		try
		   {
				db=new DashBoardPage(driver);
				bp=new BasePage();
				actual[3]=db.clickOnAddDashBoardSymbol();
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
				String desc=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,1);
				String layout=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,2);
				String shareType=Excel_Lib.getData(INPUT_PATH_4, "Dashboard",1,3);
				actual[4]=db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
				actual[5]=db.validateDashBoard(dashboardName);
				
				actual[6]=db.selectDashboard(dashboardName);
				actual[7]=db.clickOnAddGadgetSymbol();
				String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
				 actual[8]=db.addGadget(gadgetName);
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
				 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
				 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5); 
				 actual[9]=db.configureTestAutomationStatusGadget(projectName, release, refreshRate);
				///validation step 
				val= db.validateTestAutomationGadget();
				System.out.println("current value of AGS-"+val);
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

	@When("^Edit and change some testcases from manual to automated after saving Test Automation Status Gadget$")
	public void edit_and_change_some_testcases_from_manual_to_automated_after_saving_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
			pp.backToProjectPage();
			   pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			   pp.selectProject(projectName);
			   pp.selectRelease(release1);
			   rp.clickOnTestRep();
			   tr.doubleClickOnRelease(release1);
			   String node1[]=new String[1];
			   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
			   tr.navigateToNode(release1, node1);
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   tr.editTestCase();
			   bp.waitForElement();
			   ctc=new CreateTestCasePage(driver);
				//String check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
				String script_Name=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
				String script_Id=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "Assignee", 1, 2));
				String script_Path=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
//				actual[6]=ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
//				ctc.editMultipleTestCase(detailField, automationField);
				ctc.enterAutomationScriptField(script_Name, script_Id, script_Path);
				bp.waitForElement();
				db.clickOnManageDashboards();
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
				db.searchDashboard(dashboardName);
				db.selectDashboard(dashboardName);
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

	@Then("^Should be able to see updated gadget$")
	public void should_be_able_to_see_updated_gadget() throws Throwable 
	{
		try
		{
		    double val1=db.validateTestAutomationGadget();
		    System.out.println("current value of AGS-"+val);
		    System.out.println("after automation the value of AGS-"+val1);
		    if(val<val1)
		    {
		    	System.out.println("Automation status gadget updated");
		    }
		    else
		    {
		    	throw new UserDefinedException("Automation status gadget is not updated");
		    }
		    val=val1;
		    System.out.println("after changing to automation the value of AGS "+val);
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

	@When("^Edit and change some testcases from automated to manual after saving Test Automation Status Gadget$")
	public void edit_and_change_some_testcases_from_automated_to_manual_after_saving_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
			pp.backToProjectPage();
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
		   pp.selectProject(projectName);
		   pp.selectRelease(release1);
		   rp.clickOnTestRep();
		   tr.doubleClickOnRelease(release1);
		   String node1[]=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
		   tr.navigateToNode(release1, node1);
		   for(int i=0;i<10;i++)
		   {
			   tr.addTestCase();
		   }
		   db.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
			db.searchDashboard(dashboardName);
			db.selectDashboard(dashboardName);
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

	@Then("^Should be able to see updated Test Automation Status Gadget$")
	public void should_be_able_to_see_updated_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
		    double val1=db.validateTestAutomationGadget();
		    System.out.println("current value of AGS-"+val);
		    System.out.println("after manual the value of AGS-"+val1);
		    if(val>=val1)
		    {
		    	System.out.println("Automation status gadjet updated");
		    }
		    else
		    {
		    	throw new UserDefinedException("Automation status gadjet is not updated");
		    }
		    val=val1;
		    System.out.println("after changing to automation the value of AGS "+val);
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

	@When("^Add some new manual testcases after saving Test Automation Status Gadget$")
	public void add_some_new_manual_testcases_after_saving_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
			pp.backToProjectPage();
		 pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
		   pp.selectProject(projectName);
		   pp.selectRelease(release1);
		   rp.clickOnTestRep();
		   
		   tr.doubleClickOnRelease(release1);
			  String manualnode=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
			  String manualDesc=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 3);
			  tr.addNode(manualnode, manualDesc);
			  String mannode1[]=new String[1];
			  mannode1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
			  tr.navigateToNode(release1, mannode1);
			  tr.addTestCase();
			  bp.waitForElement();
			  for(int i=0;i<8;i++)
			  {
				  tr.selectallTestCase();
				  tr.cloneTestCase();
				  bp.waitForElement();
			  }
			  
			   db=new DashBoardPage(driver);
			  db.clickOnManageDashboards();
			  
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
				db.searchDashboard(dashboardName);
				db.selectDashboard(dashboardName);
				
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

	@Then("^Should be able to see updated gadget after adding manual testcases$")
	public void should_be_able_to_see_updated_gadget_after_adding_manual_testcases() throws Throwable 
	{

		try
		{
		    double val1=db.validateTestAutomationGadget();
		    System.out.println("current value of AGS-"+val);
		    System.out.println("after manual the value of AGS-"+val1);
		    if(val>val1)
		    {
		    	System.out.println("Automation status gadjet updated");
		    }
		    else
		    {
		    	throw new UserDefinedException("Automation status gadjet is not updated");
		    }
		    val=val1;
		    System.out.println("after changing to automation the value of AGS "+val);
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

	@When("^Add some new automated testcases after saving Test Automation Status Gadget$")
	public void add_some_new_automated_testcases_after_saving_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
			pp.backToProjectPage();
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
		   pp.selectProject(projectName);
		   pp.selectRelease(release1);
		   rp.clickOnTestRep();
		   tr.doubleClickOnRelease(release1);
		   String node1[]=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
		   tr.navigateToNode(release1, node1);
		   tr.addTestCase();
		   tr.clickOnDetails();
		   bp.waitForElement();
		   ctc=new CreateTestCasePage(driver);
			String check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
			String script_Name=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
			String script_Id=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "Assignee", 1, 2));
			String script_Path=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
			actual[6]=ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
			bp.waitForElement();
		   tr.clickOnList();
		   bp.waitForElement();
		   tr.addTestCase();
		   bp.waitForElement();
//		   String name1[]=new String[1];
//		    name1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0));
//		   tr.selectTestCase(name1);
//		   tr.clickOnDetails();
//		   actual[6]=ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
//		   tr.clickOnList();
		   
		   db.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
			db.searchDashboard(dashboardName);
			db.selectDashboard(dashboardName);
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

	@Then("^Should be able to see updated gadget after adding automated testcases$")
	public void should_be_able_to_see_updated_gadget_after_adding_automated_testcases() throws Throwable 
	{
		try
		{
		    double val1=db.validateTestAutomationGadget();
		    System.out.println("current value of AGS-"+val);
		    System.out.println("after manual the value of AGS-"+val1);
		    if(val>=val1)
		    {
		    	System.out.println("Automation status gadget updated");
		    }
		    else
		    {
		    	throw new UserDefinedException("Automation status gadget is not updated");
		    }
		    val=val1;
		    System.out.println("after changing to automation the value of AGS "+val);
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

	@When("^Delete some manual testcases after saving Test Automation Status Gadget$")
	public void delete_some_manual_testcases_after_saving_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
			pp.backToProjectPage();
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
		   pp.selectProject(projectName);
		   pp.selectRelease(release1);
		   rp.clickOnTestRep();
		   tr.doubleClickOnRelease(release1);
		   String node1[]=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 0);
		   tr.navigateToNode(release1, node1);
		   tr.selectallTestCase();
		   tr.deleteTestCase();
		   bp.waitForElement();
		   db.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
			db.searchDashboard(dashboardName);
			db.selectDashboard(dashboardName);
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

	@Then("^Should be able to see updated gadget after deleting manual testcases$")
	public void should_be_able_to_see_updated_gadget_after_deleting_manual_testcases() throws Throwable 
	{
		try
		{
		    double val1=db.validateTestAutomationGadget();
		    System.out.println("current value of AGS-"+val);
		    System.out.println("after manual the value of AGS-"+val1);
		    if(val<val1)
		    {
		    	System.out.println("Automation status gadjet updated");
		    }
		    else
		    {
		    	throw new UserDefinedException("Automation status gadjet is not updated");
		    }
		    val=val1;
		    System.out.println("after changing to automation the value of AGS "+val);
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

	@When("^Delete some automated testcases after saving Test Automation Status Gadget$")
	public void delete_some_automated_testcases_after_saving_Test_Automation_Status_Gadget() throws Throwable 
	{
		try
		{
			pp.backToProjectPage();
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
		   pp.selectProject(projectName);
		   pp.selectRelease(release1);
		   rp.clickOnTestRep();
		   tr.doubleClickOnRelease(release1);
		   String node1[]=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 68, 2);
		   tr.navigateToNode(release1, node1);
		   tr.selectallTestCase();
		   tr.deleteTestCase();
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

	@Then("^Should be able to see updated gadget after deleting automated testcases$")
	public void should_be_able_to_see_updated_gadget_after_deleting_automated_testcases() throws Throwable 
	{
		try
		{
			  bp.waitForElement();
			   db.clickOnManageDashboards();
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 14,0);
				db.searchDashboard(dashboardName);
				db.selectDashboard(dashboardName);
		    double val1=db.validateTestAutomationGadget();
		    System.out.println("current value of AGS-"+val);
		    System.out.println("after manual the value of AGS-"+val1);
		    if(val<=val1)
		    {
		    	System.out.println("Automation status gadjet updated");
		    }
		    else
		    {
		    	throw new UserDefinedException("Automation status gadjet is not updated");
		    }
		    val=val1;
		    System.out.println("after changing to automation the value of AGS "+val);
		    
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
