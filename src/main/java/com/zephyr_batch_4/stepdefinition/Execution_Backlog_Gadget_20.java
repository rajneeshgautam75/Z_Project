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

public class Execution_Backlog_Gadget_20 extends LaunchBrowser{

	LaunchBrowser lb;
	DashBoardPage dp;
	BasePage bp;
	ProjectPage pp;
	String fileName="Execution_Backlog_Gadget_20";
	
	boolean[] actual=new boolean[29];
	SoftAssert soft=new SoftAssert();
	
	@Given("^As the Lead,Launch DashBoard page$")
	public void as_the_Lead_Launch_DashBoard_page() throws Throwable {
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

	@When("^Create the DashBoard with the available fields$")
	public void create_the_DashBoard_with_the_available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,39);
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

	@When("^Add the Execution Backlog gadget$")
	public void add_the_Execution_Backlog_gadget() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,39);
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

	@When("^enter the execution Backlog detail by choosing the User option$")
	public void enter_the_execution_Backlog_detail_by_choosing_the_User_option() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
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

	@Then("^Should be able to edit execution backlog gadget and add one more user from selected list$")
	public void should_be_able_to_edit_execution_backlog_gadget_and_add_one_more_user_from_selected_list() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] user=new String[2];
			user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			user[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,41);
			actual[8]=dp.filterBy(filterByName, user);
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

	@When("^edit and remove one user from execution backlog gadget$")
	public void edit_and_remove_one_user_from_execution_backlog_gadget() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			actual[10]=dp.gadgetOperation(gadgetValue);
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

	@Then("^Should be able to remove one user from execution backlog gadget user list$")
	public void should_be_able_to_remove_one_user_from_execution_backlog_gadget_user_list() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] user=new String[1];
			user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			actual[11]=dp.filterBy(filterByName, user);
			bp.waitForElement();
			actual[12]=dp.saveGadget();
			actual[13]=dp.viewMsg(filterByName);
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

	@When("^edit execution backlog gadget by entering the tag$")
	public void edit_execution_backlog_gadget_by_entering_the_tag() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			actual[14]=dp.gadgetOperation(gadgetValue);
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

	@Then("^Should be able to add one more tag from selected tag list$")
	public void should_be_able_to_add_one_more_tag_from_selected_tag_list() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 0,44);
			String[] tag=new String[2];
			tag[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,44);
			tag[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,44);
			bp.waitForElement();
			actual[15]=dp.filterBy(filterByName, tag);
			bp.waitForElement();
			actual[16]=dp.saveGadget();
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

	@When("^edit and remove one tag from execution backlog gadget$")
	public void edit_and_remove_one_tag_from_execution_backlog_gadget() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			actual[17]=dp.gadgetOperation(gadgetValue);
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

	@Then("^Should be able to remove one tag from execution backlog gadget tag list$")
	public void should_be_able_to_remove_one_tag_from_execution_backlog_gadget_tag_list() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 0,44);
			String[] tag=new String[1];
			tag[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,44);
			actual[18]=dp.filterBy(filterByName, tag);
			bp.waitForElement();
			actual[19]=dp.saveGadget();
			actual[20]=dp.viewMsg(filterByName);
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

	@When("^edit execution backlog gadget to enter the priority$")
	public void edit_execution_backlog_gadget_to_enter_the_priority() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			actual[21]=dp.gadgetOperation(gadgetValue);
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

	@Then("^Should be able to add one more priority from selected priority list$")
	public void should_be_able_to_add_one_more_priority_from_selected_priority_list() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,40);
			String[] priority=new String[2];
			priority[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,41);
			priority[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,42);
			actual[22]=dp.filterBy(filterByName, priority);
			bp.waitForElement();
			actual[23]=dp.saveGadget();
			actual[24]=dp.viewMsg(filterByName);
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

	@When("^edit and remove one priority from execution gadget$")
	public void edit_and_remove_one_priority_from_execution_gadget() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
			actual[25]=dp.gadgetOperation(gadgetValue);
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

	@Then("^Should be able to remove one priority from selected priority list$")
	public void should_be_able_to_remove_one_priority_from_selected_priority_list() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,40);
			String[] value=new String[1];
			value[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,42);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,40);
			actual[26]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[27]=dp.saveGadget();
			actual[28]=dp.viewMsg(priority);
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
