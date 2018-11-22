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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_4 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
	String filename="Execution_Backlog_4";

	
	@Given("^User is in the Project Page$")
	public void user_is_in_the_Project_Page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			dp=new DashBoardPage(driver);
			bp=new BasePage();
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			bp.waitForElement();
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

	@When("^User creates a new Hidden Release by clicking on Manage Release button$")
	public void user_creates_a_new_Hidden_Release_by_clicking_on_Manage_Release_button() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			String ReleaseName=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 0);
			String Description=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 1);
			String Hide=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 2);
			String Map=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 3);
			String Syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8,"Release", 1, 4));
			String Smonth=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 5);
			String SDate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8,"Release", 1, 6));
			String Eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8,"Release", 1, 7));
			String Emonth=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 8);
			String Edate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8,"Release", 1, 9));
			bp.waitForElement();
			actual[1]=rp.clickOnManageRelease();
			bp.waitForElement();
			actual[2]=rp.addNewRelease(ReleaseName,Description,Hide,Map);
			bp.waitForElement();
			actual[3]=rp.enterStartDatAndEndDateForRelease(Syear,Smonth,SDate,Eyear,Emonth,Edate);
			bp.waitForElement();
			actual[4]=rp.clickOnAdd();
			
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

	@When("^User goes to dashboard page and adds new dashboard and selects created DashBoard$")
	public void user_goes_to_dashboard_page_and_adds_new_dashboard_and_selects_created_DashBoard() throws Throwable {
		
		try
		{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
	    	 bp.waitForElement();
	    	 actual[5]=dp.clickOnManageDashboards();
	    	 bp.waitForElement();
	    	 actual[6]=dp.clickOnAddDashBoardSymbol();
	    	 bp.waitForElement();
	    	 actual[7]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@When("^user adds Executions Backlog Gadget for selected Dashboard$")
	public void user_adds_Executions_Backlog_Gadget_for_selected_Dashboard() throws Throwable {
		try
		{
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
			 String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 1);
	    	 bp.waitForElement();
	    	 actual[8]=dp.validateDashBoard(dashboard);
	    	 bp.waitForElement();
	    	 actual[9]=dp.selectDashboard(dashboard);
	    	 bp.waitForElement();
	    	 actual[10]=dp.clickOnAddGadgetSymbol();
	    	 bp.waitForElement();
	    	 actual[11]=dp.addGadget(gadgetName);
	    	 bp.waitForElement();
	    	 actual[12]=dp.validateGadget(gadgetName);
	    		 
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

	@When("^User attempts to add the Hidden Release to a gadget$")
	public void user_attempts_to_add_the_Hidden_Release_to_a_gadget() throws Throwable {
		try
		{
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[13]=dp.checkProject(projectName);
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

	@Then("^Should not be able to add Executions Backlog Gadget for Project and hidden release$")
	public void should_not_be_able_to_add_Executions_Backlog_Gadget_for_Project_and_hidden_release() throws Throwable {
		
	   try
	   {
		   pp=new ProjectPage(driver);
		   String ReleaseName=Excel_Lib.getData(INPUT_PATH_8,"Release", 1, 0);
		   bp.waitForElement();
		   actual[14]=dp.checkRelease(ReleaseName);
		   System.out.println("Hidden Release Not Found");
		   actual[15]=pp.backToProjectPage();
		   
		   
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
