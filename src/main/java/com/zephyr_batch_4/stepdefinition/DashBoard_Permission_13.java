package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_13 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	RequirementsPage req;
	String fileName="DashBoard_Permission_13";
	
	boolean[] actual=new boolean[17];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As a Lead,Launch the DashBoard Page$")
	public void as_a_Lead_Launch_the_DashBoard_Page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
	    	pp=new ProjectPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
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

	@When("^Add the DashBoard with share type with private$")
	public void add_the_DashBoard_with_share_type_with_private() throws Throwable {
		try
		{
		actual[1]=dbp.clickOnAddDashBoardSymbol();
		
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1,5);
		actual[2]=dbp.enterDashBoardDetails(dashboardName1, desc, layout, shareType1);
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

	@When("^change the share type from private to Any Logged in User by clicking on edit dashboard$")
	public void change_the_share_type_from_private_to_Any_Logged_in_User_by_clicking_on_edit_dashboard() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18,2);
		actual[3]=dbp.clickOnEditDashBoardSymbol(dashboardName1);
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

	@Then("^Dashboard should be visible to all users$")
	public void dashboard_should_be_visible_to_all_users() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18,2);	
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3,5);
		actual[4]=dbp.enterDashBoardDetails(dashboardName1, desc, layout, shareType1);
		
		actual[5]=dbp.searchDashboard(dashboardName1);
		actual[6]=dbp.validateDashBoard(dashboardName1);
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

	@When("^Add the DashBoard with share type Any Logged in User$")
	public void add_the_DashBoard_with_share_type_Any_Logged_in_User() throws Throwable {
		try
		{
		actual[7]=dbp.clickOnAddDashBoardSymbol();
		
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3,5);
		actual[8]=dbp.enterDashBoardDetails(dashboardName1, desc, layout, shareType1);
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

	@Then("^Should be able to create dasboard$")
	public void should_be_able_to_create_dasboard() throws Throwable {
	  try
	  {
		 String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);
		 actual[9]=dbp.validateDashBoard(dashboardName1);
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

	@When("^Select the added DashBoard and Add test automation status gadget$")
	public void select_the_added_DashBoard_and_Add_test_automation_status_gadget() throws Throwable {
		try
		  {
			 String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);
			 dbp.selectDashboard(dashboardName1);
			 
			 dbp.clickOnAddGadgetSymbol();
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6);
			 actual[10]=dbp.addGadget(gadgetName);
			 bp.waitForElement();
			 pp.backToProjectPage();
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			 pp.selectProject(projectName);
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

	@When("^change the dashBoard share type to private and save by selecting the edit dashBoard$")
	public void change_the_dashBoard_share_type_to_private_and_save_by_selecting_the_edit_dashBoard() throws Throwable {
		try
		{
		dbp.clickOnManageDashboards();	
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);
		dbp.searchDashboard(dashboardName1);
		bp.waitForElement();
		actual[11]=dbp.clickOnEditDashBoardSymbol(dashboardName1);
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

	@Then("^Should be able to save the DashBoard$")
	public void should_be_able_to_save_the_DashBoard() throws Throwable {
		try
		{
		String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);	
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1,5);
		actual[12]=dbp.enterDashBoardDetails(dashboardName1, desc, layout, shareType1);
		dbp.searchDashboard(dashboardName1);
		actual[13]=dbp.validateDashBoard(dashboardName1);
		pp.clickOnLogout();
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

	@When("^login as other user and Launch DashBoard$")
	public void login_as_other_user_and_Launch_DashBoard() throws Throwable {
		try
		{
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_2");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_2");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
			
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[14]=dbp.clickOnManageDashboards();	
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

	@When("^attempt to view the DashBoard$")
	public void attempt_to_view_the_DashBoard() throws Throwable {
		try
		  {
			 String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);
			 actual[15]=dbp.searchDashboard(dashboardName1);
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

	@Then("^Should not show dashBoard as this dashboard sharing is changed to private$")
	public void should_not_show_dashBoard_as_this_dashboard_sharing_is_changed_to_private() throws Throwable {
		try
		  {
			 String dashboardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,2);
			 actual[16]=dbp.validateDashBoard(dashboardName1);
			 
			 for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					soft.assertEquals(actual[k], true);
				}
				soft.assertAll();
				
				pp.closeBrowser();
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
