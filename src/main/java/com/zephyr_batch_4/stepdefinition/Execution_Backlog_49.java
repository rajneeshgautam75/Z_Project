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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_49 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_49";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	
	boolean actual[]=new boolean[33];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 26, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	@Given("^Login as Lead into Zephyr Application$")
	public void login_as_Lead_into_Zephyr_Application() throws Throwable {
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

	@When("^Navigate to Test repository and Create phase and Add a test cases to phase$")
	public void navigate_to_Test_repository_and_Create_phase_and_Add_a_test_cases_to_phase() throws Throwable {
		try
		 {
			 tr=new TestRepositoryPage(driver);
			 actual[2]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[3]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 63, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[4]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[5]=tr.navigateToNode(release, navigation);
			 actual[6]=tr.addTestCase();
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

	@When("^Navigate to test planning, create three cycles and add phase to created cycles$")
	public void navigate_to_test_planning_create_three_cycles_and_add_phase_to_created_cycles() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 for(int i=0;i<=2;i++)
			 {
			 actual[7]=rp.clickOnTestPlanning();
			 actual[8]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 36+i, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[9]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[11]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 36+i, 0);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 63, 0);
			 actual[12]=tp.navigateToCycle(cycle1);
			 actual[13]=tp.addPhaseToCycle(phase);
			 actual[14]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[15]=tp.bulkAssignment(Bulk_type);
			 actual[16]=bp.waitForElement();
			 actual[17]=tp.goBackToCycle();
			 actual[18]=bp.waitForElement();
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

	@When("^launch DashBoard Page and create new Dashboard$")
	public void launch_DashBoard_Page_and_create_new_Dashboard() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[19]=dp.clickOnManageDashboards();
			  actual[20]=dp.validateDashboards();
			  actual[21]=dp.clickOnAddDashBoardSymbol();
			  actual[22]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
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

	@Then("^Dashboard should be created successfully for particular User$")
	public void dashboard_should_be_created_successfully_for_particular_User() throws Throwable {
		try
		 {
			 actual[23]=dp.validateDashBoard(dashBoardName); 
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

	@When("^Add a Execution Backlog Gadget to created DashBoard$")
	public void add_a_Execution_Backlog_Gadget_to_created_DashBoard() throws Throwable {
		try
		 {
			  actual[24]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[25]=dp.clickOnAddGadgetSymbol();
			  actual[26]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[27]=dp.validateGadget(gadget); 
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

	@When("^Configure Execution Backlog Gadget with  details and In search field enter cycle name and click on search$")
	public void configure_Execution_Backlog_Gadget_with_details_and_In_search_field_enter_cycle_name_and_click_on_search() throws Throwable {
		try
		 {
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[28]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			  String [] cycleName=new String [3];
			  for(int i=0;i<=cycleName.length-1;i++)
			  {
			  cycleName[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 36+i, 0);
			  }
			  actual[29]=dp.filterBy(filterBy, cycleName);
			  actual[30]=dp.saveGadget();
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

	@Then("^Execution Backlog gadget should be added successfully$")
	public void execution_Backlog_gadget_should_be_added_successfully() throws Throwable {
		try
		 {
			actual[31]=dp.validateSavedGadget(project);	
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			actual[32]=dp.viewMsg(filterBy);
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
