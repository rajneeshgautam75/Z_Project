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

public class Execution_Backlog_10  extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[37];
	SoftAssert soft=new SoftAssert();
	String filename="Execution_Backlog_10";
	
	@Given("^User is in the DashBoard Page of the selected project$")
	public void user_is_in_the_DashBoard_Page_of_the_selected_project() throws Throwable {
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

	@When("^User adds a DashBoard with necessary details$")
	public void user_adds_a_DashBoard_with_necessary_details() throws Throwable {
		 try {
		    	
	    	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 3, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
	    	 bp.waitForElement();
	    	 actual[2]=dp.clickOnAddDashBoardSymbol();
	    	 bp.waitForElement();
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

	@When("^User selects the DashBoard which he has created$")
	public void user_selects_the_DashBoard_which_he_has_created() throws Throwable {
		try 
	    {
	    	
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 3, 1);
	    	bp.waitForElement();
	    	 actual[4]=dp.validateDashBoard(name);
	    	 bp.waitForElement();
	    	 actual[5]=dp.selectDashboard(name); 	 
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

	@When("^User clicks on plus button to add Executions Backlog Gadget$")
	public void user_clicks_on_plus_button_to_add_Executions_Backlog_Gadget() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
		bp.waitForElement();
		actual[6]=dp.clickOnAddGadgetSymbol();
		bp.waitForElement();
		actual[7]=dp.addGadget(gadgetName);
		actual[8]=dp.validateGadget(gadgetName);
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


	@When("^User selects project,Release and Refresh interval by one hour$")
	public void user_selects_project_Release_and_Refresh_interval_by_one_hour() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 1, 0);
			String filterByName=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values=new String[1];
			values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=dp.configureTraceabilityGadget(project,release,refreshRate);
			bp.waitForElement();
			actual[9]=dp.filterBy(filterByName,values);
			bp.waitForElement();
			bp.waitForElement();
			actual[10]=dp.saveTraceabilityGadget();	
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

	@When("^User selects project,Release and Refresh interval by four hour$")
	public void user_selects_project_Release_and_Refresh_interval_by_four_hour() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
			String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate1=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 2, 0);
			String filterByName1=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values1=new String[1];
			values1[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			bp.waitForElement();
			actual[11]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[12]=dp.addGadget(gadgetName);
			bp.waitForElement();
			actual[13]=dp.validateGadget(gadgetName);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[14]=dp.configureTraceabilityGadget(project1,release1,refreshRate1);
			bp.waitForElement();			
			actual[15]=dp.filterBy(filterByName1,values1);
			bp.waitForElement();
			actual[16]=dp.saveTraceabilityGadget();
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

	@When("^User selects project,Release and Refresh interval by eight hour$")
	public void user_selects_project_Release_and_Refresh_interval_by_eight_hour() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
			String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate2=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 3, 0);
			String filterByName2=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values2=new String[1];
			values2[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			bp.waitForElement();
			actual[17]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[18]=dp.addGadget(gadgetName);
			bp.waitForElement();	
			actual[19]=dp.validateGadget(gadgetName);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[20]=dp.configureTraceabilityGadget(project2,release2,refreshRate2);
			bp.waitForElement();
			actual[21]=dp.filterBy(filterByName2,values2);
			bp.waitForElement();
			actual[22]=dp.saveTraceabilityGadget();
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

	@When("^User selects project,Release and Refresh interval by one day$")
	public void user_selects_project_Release_and_Refresh_interval_by_one_day() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
			String project3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate3=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 4, 0);
			String filterByName3=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values3=new String[1];
			values3[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			bp.waitForElement();
			actual[23]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[24]=dp.addGadget(gadgetName);
			bp.waitForElement();
			actual[25]=dp.validateGadget(gadgetName);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[26]=dp.configureTraceabilityGadget(project3,release3,refreshRate3);
			bp.waitForElement();
			actual[27]=dp.filterBy(filterByName3,values3);
			bp.waitForElement();
			bp.waitForElement();
			actual[28]=dp.saveTraceabilityGadget();
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

	@When("^User selects project,Release and Refresh interval by one week$")
	public void user_selects_project_Release_and_Refresh_interval_by_one_week() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 2, 5);
			String project4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String release4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			String refreshRate4=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 5, 0);
			String filterByName4=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 0, 1);
			String[] values4=new String[1];
			values4[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			bp.waitForElement();
			actual[29]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[30]=dp.addGadget(gadgetName);
			bp.waitForElement();
			actual[31]=dp.validateGadget(gadgetName);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[32]=dp.configureTraceabilityGadget(project4,release4,refreshRate4);
			bp.waitForElement();
			actual[33]=dp.filterBy(filterByName4,values4);
			bp.waitForElement();
			bp.waitForElement();
			actual[34]=dp.saveTraceabilityGadget();
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

	@Then("^User should be able to add Executions Backlog Gadget with Refresh interval as one hr,four hr,eight hr,one day,one week$")
	public void user_should_be_able_to_add_Executions_Backlog_Gadget_with_Refresh_interval_as_one_hr_four_hr_eight_hr_one_day_one_week() throws Throwable {
	   try
	   {
		   pp=new ProjectPage(driver);
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
		   bp.waitForElement();  
		   actual[35]=dp.validateSavedGadget(project, release);
		   actual[36]=pp.backToProjectPage();
		   
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
