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
import com.zephyr.reusablemethods.RequirementsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_25 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	RequirementsPage req;
	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_25";
	@Given("^User is In DashBoard Page and Adds New Dashboard$")
	public void user_is_In_DashBoard_Page_and_Adds_New_Dashboard() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
	    String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
		bp.waitForElement();
	    actual[2]=dp.clickOnAddDashBoardSymbol();
	    actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@When("^user selects added new dashboard$")
	public void user_selects_added_new_dashboard() throws Throwable {
		 try
		    {
		    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
				actual[4]=dp.selectDashboard(name);
				
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

	@When("^Adds multiple (\\d+)/(\\d+)/(\\d+)/(\\d+)/(\\d+) Traceability Report Gadget and change the Dashboard layouts from (\\d+) to (\\d+)$")
	public void adds_multiple_Traceability_Report_Gadget_and_change_the_Dashboard_layouts_from_to(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
	    try
	    {
	    	String layout1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 4);
	    	for(int i=0;i<2;i++)
	    	{
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
	    	bp.waitForElement();
			actual[5]=dp.clickOnAddGadgetSymbol();
	    	bp.waitForElement();
			actual[6]=dp.addGadget(gadget);
	    	}
	    	actual[7]=dp.layoutSelection(layout1);
	    	
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

	@Then("^To be able to change dashboard layout from one layout to two layout$")
	public void to_be_able_to_change_dashboard_layout_from_one_layout_to_two_layout() throws Throwable {
		try
		{
			String layout2=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			bp.waitForElement();
	    	actual[8]=dp.layoutSelection(layout2);
			
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

	@When("^user Adds multiple (\\d+)/(\\d+)/(\\d+)/(\\d+)/(\\d+) Traceability Report Gadget and change the Dashboard layouts from Two to One$")
	public void user_Adds_multiple_Traceability_Report_Gadget_and_change_the_Dashboard_layouts_from_Two_to_One(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
	    try
	    {
	    	
	    	String layout2=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
	    	for(int i=0;i<2;i++)
	    	{
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
	    	bp.waitForElement();
			actual[9]=dp.clickOnAddGadgetSymbol();
	    	bp.waitForElement();
			actual[10]=dp.addGadget(gadget);
	    	}
	    	actual[11]=dp.layoutSelection(layout2);
	    	
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

	@Then("^should able to change dashboard layout from two layout to one layout$")
	public void should_able_to_change_dashboard_layout_from_two_layout_to_one_layout() throws Throwable {
		try
		{
			String layout1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 4);
			bp.waitForElement();
	    	actual[12]=dp.layoutSelection(layout1);
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

	@When("^user Adds multiple (\\d+)/(\\d+)/(\\d+)/(\\d+)/(\\d+) Traceability Report Gadget with same projects but different releases in same dashabord$")
	public void user_Adds_multiple_Traceability_Report_Gadget_with_same_projects_but_different_releases_in_same_dashabord(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
	    try
	    {
	    	
	        String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	        String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	        String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 7);
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
	    	bp.waitForElement();
			actual[13]=dp.clickOnAddGadgetSymbol();
	    	bp.waitForElement();
			actual[14]=dp.addGadget(gadget);
	    	bp.waitForElement();
	    	actual[15]=dp.configureTraceabilityGadget(projectName, release_1, refreshrate);
	    	
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

	@Then("^user Should be able to add traceability gadget with different release$")
	public void user_Should_be_able_to_add_traceability_gadget_with_different_release() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
	        String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 7);
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
	    	bp.waitForElement();
	    	actual[16]=dp.clickOnAddGadgetSymbol();
	    	bp.waitForElement();
			actual[17]=dp.addGadget(gadget);
	    	bp.waitForElement();
	    	actual[18]=dp.configureTraceabilityGadget(projectName, release_2, refreshrate);
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

	@When("^user Adds multiple (\\d+)/(\\d+)/(\\d+)/(\\d+)/(\\d+) 'Traceability Report' Gadget' with same project/release but different refresh intervals$")
	public void user_Adds_multiple_Traceability_Report_Gadget_with_same_project_release_but_different_refresh_intervals(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
	   
		   try
		    {
		    	
		        String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
		        String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		        String refreshrate_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 7);
		    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
		    	bp.waitForElement();
				actual[19]=dp.clickOnAddGadgetSymbol();
		    	bp.waitForElement();
				actual[20]=dp.addGadget(gadget);
		    	bp.waitForElement();
		    	actual[21]=dp.configureTraceabilityGadget(projectName, release_1, refreshrate_1);
		    	
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

	@Then("^user Should be able to add traceability gadget with different time interval$")
	public void user_Should_be_able_to_add_traceability_gadget_with_different_time_interval() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
        String release_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
        String refreshrate_2=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
    	bp.waitForElement();
		actual[22]=dp.clickOnAddGadgetSymbol();
    	bp.waitForElement();
		actual[23]=dp.addGadget(gadget);
    	bp.waitForElement();
    	actual[24]=dp.configureTraceabilityGadget(projectName, release_1, refreshrate_2);
    	bp.waitForElement();
    	pp.backToProjectPage();
    	 for(int k=0;k<=actual.length-1;k++)
	     {
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
	
