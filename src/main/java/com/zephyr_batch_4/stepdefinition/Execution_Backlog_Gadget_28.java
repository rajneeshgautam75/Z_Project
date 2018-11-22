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
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_28 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage dp;
	String fileName="Execution_Backlog_Gadget_28";
	
	boolean[] actual=new boolean[21];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^as the lead,launch dashboard page$")
	public void as_the_lead_launch_dashboard_page() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
			bp=new BasePage();
			pp=new ProjectPage(driver);
			actual[0]=dp.clickOnManageDashboards();
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

	@When("^add the dashboard with the Available fields$")
	public void add_the_dashboard_with_the_Available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 9,39);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[1]=dp.clickOnAddDashBoardSymbol();
			actual[2]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[3]=dp.validateDashBoard(dashboardName);
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

	@When("^Add the execution backlog gadget by clicking on gadget plus symbol$")
	public void add_the_execution_backlog_gadget_by_clicking_on_gadget_plus_symbol() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 9,39);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[4]=dp.selectDashboard(dashboardName);
			actual[5]=dp.clickOnAddGadgetSymbol();
			actual[6]=dp.addGadget(gadgetName);
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

	@When("^configure the execution backlog gadget with custom field$")
	public void configure_the_execution_backlog_gadget_with_custom_field() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String[] value=new String[1];
			value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			actual[7]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
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

	@Then("^Should be able to modify gadget with any one custom field$")
	public void should_be_able_to_modify_gadget_with_any_one_custom_field() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,40);
			String[] value=new String[1];
			value[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,41);
			actual[8]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[9]=dp.saveGadget();
			actual[10]=dp.validateSavedGadget(projectName, release);
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

	@When("^edit the execution backlog gadget to delete any custom field$")
	public void edit_the_execution_backlog_gadget_to_delete_any_custom_field() throws Throwable {
		try
		   {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		       String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");   
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   dp=new DashBoardPage(driver);
			   pp.backToProjectPage();
			   pp.selectProject(projectName1);
			   pp.selectProject(projectName);
		       pp.selectRelease(releaseName);
			   bp.waitForElement();
			   actual[11]=rp.clickOnTestPlanning();
			   
			    tp=new TestPlanningPage(driver);
			    String[] cycleName=new String[2];
			    String[] cycleName1=new String[1];
			    int[] tcNo=new int[2];
			    tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards",5 ,15 );
			    tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards",6 ,15 );
			    cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",0 ,43); //2,28
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",100,100 ); //2,30
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",0 ,43 ); //2,28
				tp.doubleClickOnCycle(cycleName[0]);
				actual[12]=tp.navigateToCycle(cycleName);
				actual[13]=tp.assignPhase();
				tp.navigateToCycle(cycleName1);
				actual[14]=tp.selectSingleMultipleTestcase(tcNo);
				bp.waitForElement();
				actual[15]=tp.deleteAllSelectedTestCases();
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

	@Then("^Should be able to delete any one custom field$")
	public void should_be_able_to_delete_any_one_custom_field() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 9,39);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String filterName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,40);
			bp.waitForElement();
			actual[16]=dp.clickOnManageDashboards();
			actual[17]=dp.searchDashboard(dashboardName);
			actual[18]=dp.selectDashboard(dashboardName);
			actual[19]=dp.validateSavedGadget(projectName, releaseName);
			actual[20]=dp.viewMsg(filterName);
			bp.waitForElement();
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
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                         
	}
}
