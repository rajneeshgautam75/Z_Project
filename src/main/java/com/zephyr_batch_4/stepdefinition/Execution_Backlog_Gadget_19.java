package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_19 extends LaunchBrowser{

	LaunchBrowser lb;
	DashBoardPage dp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	String fileName="Execution_Backlog_Gadget_19";
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As Lead,Launches Dashboard$")
	public void as_Lead_Launches_Dashboard() throws Throwable {
		try
	    {
	    	pp=new ProjectPage(driver);
	        rp=new ReleasePage(driver);
	        String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_3"); 
			
			String Hide=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,9);
	    	String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));
			
			dp=new DashBoardPage(driver);
			bp=new BasePage();
			//pp.backToProjectPage();
			pp.selectProject(projectName);
			rp.clickOnManageRelease();
			boolean res3=rp.checkAvailableRelease(release);
			if(res3==false)
			{
	    	rp.addNewRelease(release, Desc, Hide, MapexternalDefect);
	    	
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			bp.waitForElement();
			}
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

	@When("^Create the DashBoard with available fields$")
	public void create_the_DashBoard_with_available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,39);
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

	@When("^Add execution backlog gadget by selecting the dashboard$")
	public void add_execution_backlog_gadget_by_selecting_the_dashboard() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,39);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[4]=dp.selectDashboard(dashboardName);
			bp.waitForElement();
			actual[5]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
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

	@When("^Add the execution backlog details for the gadget and save$")
	public void add_the_execution_backlog_details_for_the_gadget_and_save() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] value=new String[1];
			value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[7]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
			actual[8]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[9]=dp.saveGadget();
			actual[10]=dp.validateGadget(gadgetName);
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

	@When("^Edit the Execution Backlog by selecting the hidden release$")
	public void edit_the_Execution_Backlog_by_selecting_the_hidden_release() throws Throwable {
		try
	    {
			String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13);
//			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5"); 
//			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_3"); 
//			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
//			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] value=new String[1];
			value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1"); 
			actual[11]=dp.gadgetOperation(gadgetValue);
//			actual[13]=dp.filterBy(filterByName, value);
//			dp.saveGadget();
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

	@Then("^should not be able to Edit 'Executions Backlog Gadget' and select the hidden release in same project$")
	public void should_not_be_able_to_Edit_Executions_Backlog_Gadget_and_select_the_hidden_release_in_same_project() throws Throwable {
		try
	    {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5"); 
		 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_3");
		 bp.waitForElement();
		 //dp.selectProject.click();
		 Actions act=new Actions(driver);
		 act.moveToElement(dp.selectProject).pause(1800).sendKeys(projectName).sendKeys(Keys.ENTER);
		 bp.waitForElement();
		 act.moveToElement(dp.selectRelease).pause(1800).sendKeys(release).sendKeys(Keys.ENTER);
//		 dp.selectRelease.click();
//		 dp.selectProject.sendKeys(release);
		 bp.waitForElement();
		 //actual[12]=pp.deleteRelease(projectName, release);
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
