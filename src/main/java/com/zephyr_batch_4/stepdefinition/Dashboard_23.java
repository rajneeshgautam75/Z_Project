package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_23 extends LaunchBrowser {

	ProjectPage pp;
	DashBoardPage db;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Dashboard_23";
	
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	 
	@When("^user click on add dashboard symbol and create a Dashboard$")
	public void user_click_on_add_dashboard_symbol_and_create_a_Dashboard() throws Throwable {
		 try
		  {
			 pp=new ProjectPage(driver);
			 db=new DashBoardPage(driver);
			
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 1);
		    String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 2);
		    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 3);
		    String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 4);
		    
		    
		    actual[0]=db.clickOnAddDashBoardSymbol();
		    actual[1]=db.enterDashBoardDetails(name, desc, layout, shareType);
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}

	@Then("^Dashboard created successfully$")
	public void dashboard_created_successfully() throws Throwable {
		try
		{
		String dashBoard=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 1);
		   actual[2]= db.validateDashBoard(dashBoard);
		   
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}

	@When("^user add first Test Automation Distribution gadget by clicking \\+ symbol$")
	public void user_add_first_Test_Automation_Distribution_gadget_by_clicking_symbol() throws Throwable {
		try
		{
	    String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 5);
	//  String project=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	//  String release=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	//  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	  
	    actual[3]=db.selectDashboard(dashBoard);
	    actual[4]= db.clickOnAddGadgetSymbol();
	    actual[5]=db.addGadget(gadgetName);
	    
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
		
		
		//db.configureTestAutomationStatusGadget(project, release, refreshRate);
	
	}

	@Then("^first Test Automation Distribution gadget added successfully$")
	public void first_Test_Automation_Distribution_gadget_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 5);
		actual[6]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
		
	}

	@When("^user add second Test Automation Distribution gadget by clicking add symbol$")
	public void user_add_second_Test_Automation_Distribution_gadget_by_clicking_add_symbol() throws Throwable {
		try
		{
	   // String dashBoard=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 5);
	//  String project=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	//  String release=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	//  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	  
	   // actual[7]=db.selectDashboard(dashBoard);
	    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 3);

		db.layoutSelection(layout);
	    actual[7]= db.clickOnAddGadgetSymbol();
	    actual[8]=db.addGadget(gadgetName);
	    
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
		
		
	}

	@Then("^second Test Automation Distribution gadget added successfully$")
	public void second_Test_Automation_Distribution_gadget_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 2, 5);
		actual[9]=db.validateGadget(gadgetName);
		
		pp.backToProjectPage();
		
		 for(int k=0;k<=actual.length-1;k++)
			{
				//System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();	
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}
}
