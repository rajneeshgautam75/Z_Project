package com.zephyr_batch_4.stepdefinition;

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
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_17 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	RequirementsPage req;
	String fileName="Project_Status_Gadget_17";
	
	boolean[] actual=new boolean[13];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Manager is in DashBoard page$")
	public void manager_is_in_DashBoard_page() throws Throwable {
		try
	    {
			bp=new BasePage();
			pp=new ProjectPage(driver);
			pp.clickOnLogout();
			
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
			
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
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

	@When("^Add a DashBoard with details$")
	public void add_a_DashBoard_with_details() throws Throwable {
		try
		{
		actual[1]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,37);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^Add a project status gadgets by clicking on add gadget plus symbol$")
	public void add_a_project_status_gadgets_by_clicking_on_add_gadget_plus_symbol() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,37);
	    	actual[3]=dbp.selectDashboard(dashboardName);
	    	actual[4]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6); 
			actual[5]=dbp.addGadget(gadgetName); 
			actual[6]=dbp.validateGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			actual[7]=dbp.configureProjectStatusGadget(projectName);
			dbp.saveGadget();
			
			bp.waitForElement();
			actual[8]=dbp.clickOnAddGadgetSymbol();
			actual[9]=dbp.addGadget(gadgetName);
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

	@Then("^should be able to delete project status gadget$")
	public void should_be_able_to_delete_project_status_gadget() throws Throwable {
		try
	    {
			String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13);
			actual[10]=dbp.gadgetOperation(value);
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

	@When("^Manager is not assigned to any project$")
	public void manager_is_not_assigned_to_any_project() throws Throwable {
		try
	    {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		 String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_8");
		 bp.waitForElement();
		 pp.backToProjectPage();
		 //pp.selectProject(projectName1);
		 pp.selectProject(projectName);	
		 actual[11]=pp.launchAdministration();
		 bp.waitForElement();
		 pp.launchManageprojects();
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

	@Then("^should be able to delete the project status gadget$")
	public void should_be_able_to_delete_the_project_status_gadget() throws Throwable {
		try
	    {
			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,37);
			dbp.searchDashboard(dashboardName);
	    	dbp.selectDashboard(dashboardName);
			
			String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13);
			actual[12]=dbp.gadgetOperation(value);
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
			//pp.clickOnLogout();
			driver.close();//27/03/18
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
