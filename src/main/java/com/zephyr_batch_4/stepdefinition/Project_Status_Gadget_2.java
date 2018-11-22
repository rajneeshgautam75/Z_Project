package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_2 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
	String filename="Project_Status_Gadget_2";
	
//	@Given("^user is in dashboard page$")
//	public void user_is_in_dashboard_page() throws Throwable {
//		try
//		{
//			pp=new ProjectPage(driver);
//			dp=new DashBoardPage(driver);
//			bp=new BasePage();
//			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
//			actual[0]=pp.selectProject(projectName);
//			bp.waitForElement();
//			actual[1]=dp.clickOnManageDashboards();
//		}
//		   catch(Exception e)
//			{
//			   lb=new LaunchBrowser();
//			   lb.getScreenShot(filename);
//				e.printStackTrace();
//			   driver.close();
//		      	Relogin_TPE rl=new Relogin_TPE();
//		      	rl.reLogin();
//		      	throw e;
//		   	 
//			}
//	}
	
	@Given("^user is in the Dashboard page$")
	public void user_is_in_the_Dashboard_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			dp=new DashBoardPage(driver);
			bp=new BasePage();
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			bp.waitForElement();
			actual[1]=dp.clickOnManageDashboards();
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
		   	 
			} 
	}

	@When("^user adds a new dashboard by clicking on the layout$")
	public void user_adds_a_new_dashboard_by_clicking_on_the_layout() throws Throwable {
	    try {
	    	
	    	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
	    	 bp.waitForElement();
	    	 actual[2]=dp.clickOnAddDashBoardSymbol();
	    	 actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
	    }
	    catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	    
	}

	@When("^user selects the created dashboard$")
	public void user_selects_the_created_dashboard() throws Throwable {
	    try 
	    {
	    	
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 1);
			actual[4]=dp.validateDashBoard(name);
	    	 
	    	 
	    }
	    catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^user adds a project Status gadget by clicking on the gadget plus button$")
	public void user_adds_a_project_Status_gadget_by_clicking_on_the_gadget_plus_button() throws Throwable {
		try {
	    	 String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 1, 5);
	    	 String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 1);
	    	 bp.waitForElement();
	    	 actual[5]=dp.selectDashboard(dashboard);
	    	 bp.waitForElement();
	    	 actual[6]=dp.clickOnAddGadgetSymbol();
	    	 actual[7]=dp.addGadget(gadgetName);
			
		}
		 catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^project Status gadget should be added$")
	public void project_Status_gadget_should_be_added() throws Throwable {
	    try 
	    {
	    	 pp=new ProjectPage(driver);
	    	 String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 1, 5);
	    	 actual[8]=dp.validateGadget(gadgetName);
	    	 actual[9]=pp.backToProjectPage();
	    	 
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
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}


}
