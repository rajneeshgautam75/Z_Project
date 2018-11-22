package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_30 extends LaunchBrowser{

	LaunchBrowser lb;
	DashBoardPage dp;
	BasePage bp;
	ProjectPage pp;
	String fileName="Execution_Backlog_Gadget_30";
	
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	
	
	@Given("^As the Lead,Launch dashBoard page$")
	public void as_the_Lead_Launch_dashBoard_page() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
	    	pp=new ProjectPage(driver);
			bp=new BasePage();
			actual[0]=dp.clickOnManageDashboards();
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

	@When("^Add the dashBoard with required fields$")
	public void add_the_dashBoard_with_required_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,39);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			bp.waitForElement();
			actual[1]=dp.clickOnAddDashBoardSymbol();
			actual[2]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[3]=dp.validateDashBoard(dashboardName);	
			actual[4]=dp.selectDashboard(dashboardName);
		
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

	@When("^Add the Execution Backlog gadget by selecting the dashboard$")
	public void add_the_Execution_Backlog_gadget_by_selecting_the_dashboard() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
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

	@When("^execution backlog gadget is added$")
	public void execution_backlog_gadget_is_added() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[7]=dp.validateGadget(gadgetName);
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

	@When("^delete the added Execution backlog$")
	public void delete_the_added_Execution_backlog() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13);
			dp.gadgetOption.click();
			bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(dp.gadgetVal1+gadgetValue+dp.gadgetVal2));
			Actions a1=new Actions(driver);
			a1.pause(1200).moveToElement(ele).click().perform();
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

	@Then("^Should be able to click on Cancel button in confirmation popup while deleting 'Executions Backlog Gadget'$")
	public void should_be_able_to_click_on_Cancel_button_in_confirmation_popup_while_deleting_Executions_Backlog_Gadget() throws Throwable {
		try
	    {
		  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
		  dp.gadgetCancel.click();
		  bp.waitForElement();
		  actual[8]=dp.validateGadget(gadgetName);
		  bp.waitForElement();
		  pp.backToProjectPage();
		  bp.waitForElement();
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
