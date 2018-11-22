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

public class DashBoard_Permission_15 extends LaunchBrowser{

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
	String fileName="DashBoard_Permission_15";
	
	boolean[] actual=new boolean[24];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As Lead,Launch Test Repository to create testcases$")
	public void as_Lead_Launch_Test_Repository_to_create_testcases() throws Throwable {
	  try
	  {
	     pp=new ProjectPage(driver);
	     bp=new BasePage();
	     rp=new ReleasePage(driver);
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
		 actual[0]=pp.selectProject(projectName);
	     actual[1]=pp.selectRelease(releaseName);
	     bp.waitForElement();
	     actual[2]=rp.clickOnTestRep();
			 
		    tr=new TestRepositoryPage(driver);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
			String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
			
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			actual[5]=tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName, phase);
			tr.addTestCase();
			for(int i=0;i<=2;i++)
			{
			tr.selectallTestCase();
			tr.cloneTestCase();
			}
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

	@When("^launch the DashBoard Page$")
	public void launch_the_DashBoard_Page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			actual[7]=dbp.clickOnManageDashboards();
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

	@When("^Add DashBoard by clicking on plus symbol$")
	public void add_DashBoard_by_clicking_on_plus_symbol() throws Throwable {
		try
		{
		actual[8]=dbp.clickOnAddDashBoardSymbol();
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

	@When("^Add the DashBoard with shareType Any Logged in user$")
	public void add_the_DashBoard_with_shareType_Any_Logged_in_user() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3,5);
		actual[9]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType1);
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

	@Then("^Should be able to add DashBoard$")
	public void should_be_able_to_add_DashBoard() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
		actual[10]=dbp.validateDashBoard(dashboardName);
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

	@When("^Select the added DashBoard$")
	public void select_the_added_DashBoard() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
		actual[11]=dbp.selectDashboard(dashboardName);
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

	@When("^add project status gadget by clicking on gadget plus symbol$")
	public void add_project_status_gadget_by_clicking_on_gadget_plus_symbol() throws Throwable {
		try
	    {
	    	actual[12]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6); 
			actual[13]=dbp.addGadget(gadgetName);
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

	@Then("^Should be able to Save the gadget$")
	public void should_be_able_to_Save_the_gadget() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			dbp.configureProjectStatusGadget(projectName);
			actual[14]=dbp.saveGadget();
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

	@When("^Change shareType from any logged in user to project team by clicking edit dashboard symbol$")
	public void change_shareType_from_any_logged_in_user_to_project_team_by_clicking_edit_dashboard_symbol() throws Throwable {
		try
		{
		dbp.clickOnManageDashboards();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
		actual[15]=dbp.searchDashboard(dashboardName);
		actual[16]=dbp.clickOnEditDashBoardSymbol(dashboardName);
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

	@Then("^Able to change from any logged in user to project team$")
	public void able_to_change_from_any_logged_in_user_to_project_team() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);	
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[17]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType1);
		
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

	@When("^Login as second lead,Launch DashBoard$")
	public void login_as_second_lead_Launch_DashBoard() throws Throwable {
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
			actual[18]=dbp.clickOnManageDashboards();	
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

	@When("^search the edited dashboard$")
	public void search_the_edited_dashboard() throws Throwable {
		try
		  {
			 String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
			 actual[19]=dbp.searchDashboard(dashboardName);
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

	@Then("^Should not allow to view dashboard$")
	public void should_not_allow_to_view_dashboard() throws Throwable {
		try
		  {
			 String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
			 actual[20]=dbp.validateDashBoard(dashboardName);
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

	@When("^Login as manager,Launch DashBoard$")
	public void login_as_manager_Launch_DashBoard() throws Throwable {
		try
		{
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
			
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[21]=dbp.clickOnManageDashboards();	
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

	@When("^search the dashboard$")
	public void search_the_dashboard() throws Throwable {
		try
		  {
			 String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
			 actual[22]=dbp.searchDashboard(dashboardName);
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

	@Then("^Should be able to view as managers$")
	public void should_be_able_to_view_as_managers() throws Throwable {
		try
		  {
			 String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,2);
			 actual[23]=dbp.validateDashBoard(dashboardName);
			 
			 for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					soft.assertEquals(actual[k], true);
				}
				soft.assertAll();
				driver.close();
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
