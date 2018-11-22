package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExecutionBacklog_47 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exe;

	DashBoardPage db;
	BasePage bp;
	
	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "ExecutionBacklog_47";

	boolean[] actual = new boolean[46];
	SoftAssert soft = new SoftAssert();

	
	@Given("^user is in project Page$")
	public void user_is_in_project_Page() throws Throwable {
		try
		{
	    pp=new ProjectPage(driver);
	    bp=new BasePage();
		String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		actual[0]=pp.selectProject(projectName);
		actual[1]=pp.selectRelease(releaseName);
		} 
		catch (Exception e) 
		   {
            lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		   }
	}

	@When("^User navigate to test Repository module$")
	public void user_navigate_to_test_Repository_module() throws Throwable {
	    try
	    {
		rp=new ReleasePage(driver);
		actual[2]=rp.clickOnTestRep();
	    bp.waitForElement();
	    } 
	    catch (Exception e) 
	       {
        	lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@When("^Create a node With Name and description$")
	public void create_a_node_With_Name_and_description() throws Throwable {
	  try
	    {
		tr=new TestRepositoryPage(driver);
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
	    String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 9);
	    String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 10);
	    actual[3]=tr.clickOnRelease(releaseName);
	    bp.waitForElement();
	    actual[4]=tr.addNode(phaseName, phaseDesc);
	    bp.waitForElement();
	    } 
	    catch (Exception e) 
	        {
	    	lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^phase Should be created Successfully$")
	public void phase_Should_be_created_Successfully() throws Throwable {
	    try
	    {
	    	
	    	String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
	    	String[] navigation=new String[1];
	    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 9);
	    	actual[5]=tr.navigateToNode(releaseName, navigation);
	    	bp.waitForElement();
	    	
	    } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user add five test cases in the node$")
	public void user_add_five_test_cases_in_the_node() throws Throwable {
	   
		try
		{
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		 } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
		
		
	}

	@Then("^testcases should be added in the node$")
	public void testcases_should_be_added_in_the_node() throws Throwable {
	    try
	      {
		  bp.waitForElement();
		  actual[7]=tr.verifyPresentTestCase();
		  bp.waitForElement();
	      }
	     catch (Exception e)
	        {
            lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		    }
	}

	@When("^user clicks on test plannig page$")
	public void user_clicks_on_test_plannig_page() throws Throwable {
	     try
	       {
		   actual[8]=rp.clickOnTestPlanning();
		   bp.waitForElement();
	       }
	  catch(Exception e) 
	      {	
		  lb.getScreenShot(fileName);
		  e.printStackTrace();
		  driver.close();
		  Relogin_TPE rl = new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		}
	}

	@When("^create a cycle,add phase to cycle and assign it$")
	public void create_a_cycle_add_phase_to_cycle_and_assign_it() throws Throwable {
	   try
	   {
		tp=new TestPlanningPage(driver);
	    String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 44, 5);
		String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 44, 6);
		String environ = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 44, 7);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 99);
		String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 44, 8));
		String smonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 44, 9);
		String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 44, 10));
		String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 44, 11));
		String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
		String emonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 44, 12);
		String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 44, 13));
		String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 9);
        actual[9] = tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[10] = tp.CreateCycle(cycleName, build, environ, hide);
		bp.waitForElement();
		actual[11] = tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[12] = tp.saveTestCycle();
		bp.waitForElement();
		actual[13] = tp.doubleClickOnCycle(cycleName);
		bp.waitForElement();
		actual[14] = tp.addPhaseToCycle(phaseName);
		bp.waitForElement();
		actual[15] = tp.cancelBulkAssign();
		bp.waitForElement();
		actual[16] = tp.doubleClickOnCycle(phaseName);
		bp.waitForElement();
		// tp.selectSingleMultipleTestcase(tcNo);
		actual[17] = tp.selectallTestCase();
		actual[18] = tp.assignAllSelected(assignee);

	} catch (Exception e) {

		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl = new Relogin_TPE();
		rl.reLogin();
		throw e;
	
	}
}

	@Then("^testcases should be assign to the user$")
	public void testcases_should_be_assign_to_the_user() throws Throwable {
	    try
	    {
		int[] testcase=new int[5];
	    for(int i=0;i<=testcase.length-1;i++)
	    {
	    testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i+1, 27);
	    }
	    String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Lead_1");
	    actual[19]=tp.validateAllAssigned(testcase, assignee);
	    bp.waitForElement();
		tp.goBackToCycle();
	    } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	}

	@When("^user execute all testcases to Status Pass$")
	public void user_execute_all_testcases_to_Status_Pass() throws Throwable {
	  try
	  {
		exe=new ExecutionPage(driver);
    	String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
    	String[] navigation=new String[2];
    	navigation[0]= UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 44, 5);
    	navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 9);
    	actual[20]=rp.clickOnTestExecution();
    	bp.waitForElement();
    	actual[21]=tr.navigateToNode(releaseName, navigation);
		bp.waitForElement();
	  int[] testcase=new int[5];
	  for(int i=0;i<=testcase.length-1;i++)
	    {
	    testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i+1, 27);
	    }
	    String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
		
	    actual[22]=exe.changeStatusOfTestCases(testcase, status);
	    
	  } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	}

	@Then("^testcases executed to status Pass successfully$")
	public void testcases_executed_to_status_Pass_successfully() throws Throwable {
		try
		{
		int[] testcase=new int[5];
		  for(int i=0;i<=testcase.length-1;i++)
		    {
		    testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i+1, 27);
		    }
		    String status = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
			
		    actual[23]=exe.ValidateStatusOfTestCases(testcase, status);
		    
		 } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			
			}
	}

	@When("^user Navigate to manage dashboard page$")
	public void user_Navigate_to_manage_dashboard_page() throws Throwable {
	  try
	  {
		db=new DashBoardPage(driver);
		actual[24]=db.clickOnManageDashboards();
	   bp.waitForElement();
	  } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	   
	   
	   
	}

	@Then("^dashboard page should be displayed successfully$")
	public void dashboard_page_should_be_displayed_successfully() throws Throwable {
	   try
	      {
		   actual[25]=db.validateDashboards();
		   bp.waitForElement();
	   } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	    
	}

	@When("^user create a new dashboard with details$")
	public void user_create_a_new_dashboard_with_details() throws Throwable {
		
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 1);
		String desc = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 2);
		String layout = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 3);
		String shareType = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 4);

		actual[26] = db.clickOnAddDashBoardSymbol();
		bp.waitForElement();
		actual[27] = db.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		bp.waitForElement();
		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Dashboard should be Created Successfully$")
	public void dashboard_should_be_Created_Successfully() throws Throwable {
	   try
	   {
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 1);
		actual[28]=db.validateDashBoard(dashBoardName);
		bp.waitForElement();
		
	   } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	}

	@When("^user add Execution backlog Gadget to the dashboard$")
	public void user_add_Execution_backlog_Gadget_to_the_dashboard() throws Throwable {
		try
		  {
			String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 1);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 5);
		   String project = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 6);
			
			String filterName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 13);
			String[] values=new String[1];
			values[0]= UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 9);
			actual[29]=db.selectDashboard(dashBoardName);
			bp.waitForElement();
			actual[30]=db.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[31]=db.addGadget(gadgetName);
			bp.waitForElement();
			actual[32]=db.configureTraceabilityGadget(project, release, refreshRate);
			bp.waitForElement();
			actual[33]=db.filterBy(filterName, values);
			bp.waitForElement();
			actual[34]=db.saveGadget();
			bp.waitForElement();
		  } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			
			}

	}
	
	

	@Then("^Gadget should be added successfully$")
	public void gadget_should_be_added_successfully() throws Throwable {
		try
		{
		String project = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
		actual[35]=db.validateSavedGadget(project);
		bp.waitForElement();
		 } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			
			}
	}

	@When("^user navigate to test planning module$")
	public void user_navigate_to_test_planning_module() throws Throwable {
	 try
	 {
		    pp.backToProjectPage();
		    String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			actual[36]=pp.selectProject(projectName);
			actual[37]=pp.selectRelease(releaseName);
			bp.waitForElement();
			actual[38]=rp.clickOnTestPlanning();
		
	 } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	  
	}

	@When("^delete the added phase to the cycle$")
	public void delete_the_added_phase_to_the_cycle() throws Throwable {
		try
		{
		String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 9);
		actual[39]=tp.doubleClickOnCycle(phaseName);
		bp.waitForElement();
		actual[40]=tp.deleteNode();
//		tp.goBackToCycle();
		bp.waitForElement();
		 } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			
			}
	}

	@When("^clicks on dashboard page$")
	public void clicks_on_dashboard_page() throws Throwable {
	   try
	   {
		   actual[41]=db.clickOnManageDashboards();
		   bp.waitForElement();
		
	   } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	}

	@Then("^dash_board page should be Displayed$")
	public void dash_board_page_should_be_Displayed() throws Throwable {
	  try
	  {
		  actual[42]=db.validateDashboards();
		  bp.waitForElement();
		
	  } catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		
		}
	}

	@When("^user navigate to the created dashboard page$")
	public void user_navigate_to_the_created_dashboard_page() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 64, 1);
		actual[43]=db.searchDashboard(dashBoardName);
		bp.waitForElement();
		actual[44]=db.selectDashboard(dashBoardName);
		bp.waitForElement();
		 } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			
			}
	    
	}

	@When("^check the added gadget in dashboard$")
	public void check_the_added_gadget_in_dashboard() throws Throwable {
	    
		try
		{
			String project = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			actual[45]=db.validateSavedGadget(project);
			bp.waitForElement();
			pp.backToProjectPage();
			
			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println("Actual[" + k + "]=" + actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();

		
		 } catch (Exception e) {

				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl = new Relogin_TPE();
				rl.reLogin();
				throw e;
			
			}
	}
}
