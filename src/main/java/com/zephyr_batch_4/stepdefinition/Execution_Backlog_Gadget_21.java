package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_21 extends LaunchBrowser{

	LaunchBrowser lb;
	DashBoardPage dp;
	BasePage bp;
	ProjectPage pp;
	String fileName="Execution_Backlog_Gadget_21";
	
	boolean[] actual=new boolean[19];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Lead,Launch the DashBoard page$")
	public void lead_Launch_the_DashBoard_page() throws Throwable {
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

	@When("^Add the DashBoard with available fields$")
	public void add_the_DashBoard_with_available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,39);
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

	@When("^Add the Execution Backlog by selecting the dashBoard$")
	public void add_the_Execution_Backlog_by_selecting_the_dashBoard() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,39);
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

	@When("^Add the Execution Backlog details for the gadget and save$")
	public void add_the_Execution_Backlog_details_for_the_gadget_and_save() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] value=new String[1];
			value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			actual[7]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
			actual[8]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[9]=dp.saveGadget();
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

	@When("^minimize the saved execution backlog gadget$")
	public void minimize_the_saved_execution_backlog_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[10]=dp.validateGadget(gadget);
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

	@Then("^Backlog gadget should be minimized$")
	public void backlog_gadget_should_be_minimized() throws Throwable {
		try
		{
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,13); 
			actual[11]=dp.gadgetOperation(gadgetValue);
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

	@When("^maximize the saved execution backlog gadget$")
	public void maximize_the_saved_execution_backlog_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[12]=dp.validateGadget(gadget);
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

	@Then("^Backlog gadget should be maximized$")
	public void backlog_gadget_should_be_maximized() throws Throwable {
		try
		{
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,13); 
			actual[13]=dp.gadgetOperation(gadgetValue);
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

	@When("^Add the Execution gadget and minimize$")
	public void add_the_Execution_gadget_and_minimize() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[14]=dp.clickOnAddGadgetSymbol();
			actual[15]=dp.addGadget(gadgetName);
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

	@Then("^Backlog Gadget should be minimized$")
	public void backlog_Gadget_should_be_minimized() throws Throwable {
		try
		{
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,13); 
			actual[16]=dp.gadgetOperation(gadgetValue);
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

	@When("^maximize the unsaved execution backlog$")
	public void maximize_the_unsaved_execution_backlog() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[17]=dp.validateGadget(gadget);
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

	@Then("^Should be able to maximize the gadget$")
	public void should_be_able_to_maximize_the_gadget() throws Throwable {
		try
		{
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,13); 
			actual[18]=dp.gadgetOperation(gadgetValue);
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
