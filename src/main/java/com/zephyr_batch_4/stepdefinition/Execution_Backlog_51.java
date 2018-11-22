package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_51 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_51";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	
	boolean actual[]=new boolean[42];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 27, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	@Given("^User is in Normal project Page$")
	public void user_is_in_Normal_project_Page() throws Throwable {
		 try
		 {
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 bp=new BasePage();
			 pp.selectProject(project2);
			 actual[0]=pp.selectProject(project);
			 actual[1]=pp.selectRelease(release);
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

	@When("^launch Test Repository page, add one phase, one system and add testcases to each node$")
	public void launch_Test_Repository_page_add_one_phase_one_system_and_add_testcases_to_each_node() throws Throwable {
		try
		 {
			 tr=new TestRepositoryPage(driver);
			 actual[2]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[3]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 64, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[4]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[5]=tr.navigateToNode(release, navigation);
			 actual[6]=tr.addTestCase();
			 bp.waitForElement();	
			 actual[7]=tr.clickOnRelease(release);
			 actual[8]=tr.clickOnRelease(phase);
			 String system=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 65, 0);
			 actual[9]=tr.addNode(system, Desc);
			 bp.waitForElement();
			 String navigate[]=new String [2];
			 navigate[0]=phase;
			 navigate[1]=system;
			 actual[10]=tr.navigateToNode(release, navigate);
			 actual[11]=tr.addTestCase();
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

	@When("^launch Test planning, add a cycle, add a phase and assign to user$")
	public void launch_Test_planning_add_a_cycle_add_a_phase_and_assign_to_user() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 actual[12]=rp.clickOnTestPlanning();
			 actual[13]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 39, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[14]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[15]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[16]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 39, 0);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 64, 0);
			 actual[17]=tp.navigateToCycle(cycle1);
			 actual[18]=tp.addPhaseToCycle(phase);
			 actual[19]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[15]=tp.bulkAssignment(Bulk_type);
			 bp.waitForElement();
			 actual[20]=tp.goBackToCycle();
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

	@When("^launch Test Execution and execute some testcases$")
	public void launch_Test_Execution_and_execute_some_testcases() throws Throwable {
		try
		 {
			 ep=new ExecutionPage(driver);
			 actual[21]=rp.clickOnTestExecution();
			 actual[22]=bp.waitForElement();
			 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",39,0 );
			 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",64,0 );
			 actual[23]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[24]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[25]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 String[] system=new String[3];           
			 system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",39,0 );
			 system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",64,0 );
			 system[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",65,0 );
			 actual[26]=tr.navigateToNode(release, system);
			 bp.waitForElement();
			 actual[27]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 actual[28]=ep.changeMultiSelectedStatus(status);
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

	@Then("^test cases should be executed successfully$")
	public void test_cases_should_be_executed_successfully() throws Throwable {
		try
		 {
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 int testcase[]=new int[1];
			 testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			 actual[29]=ep.ValidateStatusOfTestCases(testcase, status);
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

	@When("^Launch Dashboards page and add new Dashboard$")
	public void launch_Dashboards_page_and_add_new_Dashboard() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[30]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  actual[31]=dp.clickOnAddDashBoardSymbol();
			  actual[32]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			  bp.waitForElement(); 
			  actual[33]=dp.validateDashBoard(dashBoardName);
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

	@When("^Add an Execution Backlog Gadget by selecting User$")
	public void add_an_Execution_Backlog_Gadget_by_selecting_User() throws Throwable {
		try
		 {
			  actual[34]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[35]=dp.clickOnAddGadgetSymbol();
			  actual[36]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[37]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[38]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			  String [] phase=new String [1];
			  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 64, 0);
			  actual[39]=dp.filterBy(filterBy, phase);
			  actual[40]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added successfully for particular user filterBy$")
	public void execution_Backlog_Gadget_should_be_added_successfully_for_particular_user_filterBy() throws Throwable {
		try
		 {
			actual[41]=dp.validateSavedGadget(project);
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
