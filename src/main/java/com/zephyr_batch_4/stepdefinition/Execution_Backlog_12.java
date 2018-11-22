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

public class Execution_Backlog_12 extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_12";
	
	BasePage bp;
	DashBoardPage dp;
	ProjectPage pp;
	
	boolean actual[]=new boolean[13];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 28, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	@Given("^Lead is in Manage DashBoards page$")
	public void lead_is_in_Manage_DashBoards_page() throws Throwable {
		try
		 {
			 dp=new DashBoardPage(driver);
			 bp=new BasePage();
		 	 actual[0]=dp.clickOnManageDashboards();
			 actual[1]=dp.validateDashboards();
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }  
	   
	}

	@When("^Create new dashBoard$")
	public void create_new_dashBoard() throws Throwable {
		try
		 {
		    String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		    String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		    String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		    actual[2]=dp.clickOnAddDashBoardSymbol();
		    actual[3]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		    bp.waitForElement(); 
	    }
	
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  lb.getScreenShot(fileName);
	  driver.close();
	  Relogin_TPE rl=new Relogin_TPE();
	  rl.reLogin();
	  throw e;
	 }     
	   
	}

	@Then("^New Dashboard should be created successfully$")
	public void new_Dashboard_should_be_created_successfully() throws Throwable {
		try
		 {
		     actual[4]=dp.validateDashBoard(dashBoardName);
	     }
	
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  lb.getScreenShot(fileName);
	  driver.close();
	  Relogin_TPE rl=new Relogin_TPE();
	  rl.reLogin();
	  throw e;
	 }      
	   
	}

	@When("^Add Execution Backlog Gadget and configure gadget with priority$")
	public void add_Execution_Backlog_Gadget_and_configure_gadget_with_priority() throws Throwable {
		try
		 {
			  actual[5]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[6]=dp.clickOnAddGadgetSymbol();
			  actual[7]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[8]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[9]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			  String [] priority=new String [1];
			  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 8);
			  actual[10]=dp.filterBy(filterBy, priority);
			  actual[11]=dp.saveGadget();
			  bp.waitForElement();	 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }          
	   
	}

	@Then("^execution Backlog Gadget should be added successfully$")
	public void execution_Backlog_Gadget_should_be_added_successfully() throws Throwable {
		try
		 {
			pp=new ProjectPage(driver);
			actual[12]=dp.validateSavedGadget(project);
			pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
			{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
			} 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }          
	   
	}

	
	

}
