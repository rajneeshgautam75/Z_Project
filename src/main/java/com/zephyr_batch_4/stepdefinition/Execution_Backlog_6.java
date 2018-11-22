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

public class Execution_Backlog_6 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_6";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	
	boolean actual[]=new boolean[62];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 30, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 67, 0);
	
	
	@Given("^Lead is dashBoards page and creates new dashboard$")
	public void lead_is_dashBoards_page_and_creates_new_dashboard() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  bp=new BasePage();
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[0]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  actual[1]=dp.clickOnAddDashBoardSymbol();
			  actual[2]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			  bp.waitForElement(); 
			  actual[3]=dp.validateDashBoard(dashBoardName);
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

	@When("^Add Execution Backlog Gadget by selecting filterBy User checkbox$")
	public void add_Execution_Backlog_Gadget_by_selecting_filterBy_User_checkbox() throws Throwable {
		try
		 {
			  actual[4]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[5]=dp.clickOnAddGadgetSymbol();
			  actual[6]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[7]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[8]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[9]=dp.filterBy(filterBy, user);
			  actual[10]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added sucessfully$")
	public void execution_Backlog_Gadget_should_be_added_sucessfully() throws Throwable {
		try
		 {
			pp=new ProjectPage(driver);
			actual[11]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[12]=dp.viewMsg(filterBy);
			bp.waitForElement();
			pp.backToProjectPage();
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

	@When("^Creates new phase and add testcases in Test Repository Page$")
	public void creates_new_phase_and_add_testcases_in_Test_Repository_Page() throws Throwable {
		try
		 {
			 tr=new TestRepositoryPage(driver);
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 bp=new BasePage();
//			 pp.selectProject(project2);
			 actual[13]=pp.selectProject(project);
			 actual[14]=pp.selectRelease(release);
			 bp.waitForElement();
			 actual[15]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[16]=tr.clickOnRelease(release);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[17]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[18]=tr.navigateToNode(release, navigation);
			 actual[19]=tr.addTestCase();
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

	@When("^launch Test planning, add phase to cycle, Launch dashBoards page and navigate to created Dashbord$")
	public void launch_Test_planning_add_phase_to_cycle_Launch_dashBoards_page_and_navigate_to_created_Dashbord() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 actual[20]=rp.clickOnTestPlanning();
			 actual[21]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 41, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[22]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[23]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[24]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 41, 0);
			 actual[25]=tp.navigateToCycle(cycle1);
			 actual[26]=tp.addPhaseToCycle(phase);
			 actual[27]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[28]=tp.bulkAssignment(Bulk_type);
			 bp.waitForElement();
			 actual[29]=tp.goBackToCycle();
			 bp.waitForElement(); 
			 actual[30]=dp.clickOnManageDashboards();
			 actual[31]=dp.validateDashboards();
			 actual[32]=dp.searchDashboard(dashBoardName);
			 bp.waitForElement();
			 actual[33]=dp.selectDashboard(dashBoardName);
			 actual[34]=bp.waitForElement();	 
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
	
	@When("^Add Execution Backlog Gadget by selecting filterBy user checkbox$")
	public void add_Execution_Backlog_Gadget_by_selecting_filterBy_user_checkbox() throws Throwable {
	      try
	       {
		     actual[35]=dp.clickOnAddGadgetSymbol();
		     actual[36]=dp.addGadget(gadget);
			 bp.waitForElement();
			 actual[37]=dp.validateGadget(gadget); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			 actual[38]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			 String [] user=new String [1];
			 user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			 actual[39]=dp.filterBy(filterBy, user);
			 actual[40]=dp.saveGadget();
			 actual[41]=bp.waitForElement(); 
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
	
	@Then("^Execution Backlog gadget should be added sucessfully$")
	public void execution_Backlog_gadget_should_be_added_sucessfully() throws Throwable {
	 try
	 {
		 actual[42]=dp.validateSavedGadget(project);
		 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
		 actual[43]=dp.viewMsg(filterBy);
		 bp.waitForElement();
		 pp.backToProjectPage();
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



	@When("^Execute testcases in Test Execution page, Launch dashBoards page and create new dashboard$")
	public void execute_testcases_in_Test_Execution_page_Launch_dashBoards_page_and_create_new_dashboard() throws Throwable {
		try
		 {  
			 ep=new ExecutionPage(driver);
//			 pp.selectProject(project2);
			 actual[44]=pp.selectProject(project);
		     actual[45]=pp.selectRelease(release);
		     bp.waitForElement();	
			 actual[46]=rp.clickOnTestExecution();
			 actual[47]=bp.waitForElement();
			 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",41,0 );
			 cycleName[1]=phase;
			 actual[48]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[49]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[50]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 actual[51]=dp.clickOnManageDashboards();
			 actual[52]=dp.validateDashboards();
			 actual[53]=dp.searchDashboard(dashBoardName);
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

	@When("^Add Execution Backlog Gadget by selecting FilterBy User checkbox$")
	public void add_Execution_Backlog_Gadget_by_selecting_FilterBy_User_checkbox() throws Throwable {
		try
		 {
			  actual[54]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[55]=dp.clickOnAddGadgetSymbol();
			  actual[56]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[57]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[38]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[58]=dp.filterBy(filterBy, user);
			  actual[59]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added sucessfully in Dashboard$")
	public void execution_Backlog_Gadget_should_be_added_sucessfully_in_Dashboard() throws Throwable {
		try
		 {
			actual[60]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[61]=dp.viewMsg(filterBy);
			bp.waitForElement();
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
