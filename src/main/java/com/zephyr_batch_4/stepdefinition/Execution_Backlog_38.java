package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Execution_Backlog_38 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_38";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	boolean actual[]=new boolean[98];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	@Given("^Launch Test Repository page, add testcase to a node$")
	public void launch_Test_Repository_page_add_testcase_to_a_node() throws Throwable {
		 try
		 {
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 ctc=new CreateTestCasePage(driver);
			 bp=new BasePage();
//			 pp.selectProject(project2);
			 actual[0]=pp.selectProject(project);
			 actual[1]=pp.selectRelease(release);
			 bp.waitForElement();	
			 actual[2]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[3]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 69, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[4]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[5]=tr.navigateToNode(release, navigation);
			 actual[6]=tr.addTestCase();
			 bp.waitForElement();
			 tr.clickOnDetails();
			 bp.waitForElement();
			 String tag[]=new String [1];
			 tag[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 10);
			 actual[7]=ctc.enterMultipleTags(tag);
			 bp.waitForElement();	
			 String priority[]=new String [1];
			 priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 9);
			 actual[8]=ctc.enterPriority(priority);
			 bp.waitForElement();
			 String pickupList=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 11);
			 String text=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String longText=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String number=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String checkBox=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String date=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 actual[9]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
			 bp.waitForElement();
			 tr.clickOnList();
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

	@Given("^launch Test planning, add a cycle, add phase and launch Test Execution and execute the testcase$")
	public void launch_Test_planning_add_a_cycle_add_phase_and_launch_Test_Execution_and_execute_the_testcase() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 ep=new ExecutionPage(driver);
			 for(int i=0;i<=4;i++)
			 {
			 actual[10]=rp.clickOnTestPlanning();
			 actual[11]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 42+i, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[12]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[14]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 42+i, 0);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 69, 0);
			 actual[15]=tp.navigateToCycle(cycle1);
			 bp.waitForElement();
			 actual[16]=tp.addPhaseToCycle(phase);
			 actual[17]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[18]=tp.bulkAssignment(Bulk_type);
			 bp.waitForElement();
			 actual[19]=tp.goBackToCycle();
			 bp.waitForElement();  
			 actual[20]=rp.clickOnTestExecution();
			 actual[21]=bp.waitForElement();
			 bp.waitForElement();
			 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",42+i,0 );
			 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",69,0 );
			 actual[22]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[23]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[24]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();  
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

	@When("^Add Executions Backlog Gadget in multiple Dashboards with same project/release/cycles$")
	public void add_Executions_Backlog_Gadget_in_multiple_Dashboards_with_same_project_release_cycles() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  for(int i=0;i<=4;i++)
			  {
			  driver.navigate().refresh();
			  bp.waitForElement();
			  bp.waitForElement();
			  bp.waitForElement();
			  actual[25]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  bp.waitForElement();
			  actual[26]=dp.clickOnAddDashBoardSymbol();
			  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 32+i, 0);
			  actual[27]=dp.enterDashBoardDetails(dashBoard, desc, layout, shareType);
			  actual[28]=bp.waitForElement(); 
			  actual[29]=dp.validateDashBoard(dashBoard);
			  actual[30]=dp.selectDashboard(dashBoard);
			  bp.waitForElement();
			  actual[31]=dp.clickOnAddGadgetSymbol();
			  bp.waitForElement();
			  actual[32]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[33]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[34]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			  String [] cycle=new String [1];
			  cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",42,0 );
			  actual[35]=dp.filterBy(filterBy, cycle);
			  actual[36]=dp.saveGadget();
			  bp.waitForElement();
			  actual[37]=dp.validateSavedGadget(project);
			  actual[38]=dp.viewMsg(filterBy);
			  bp.waitForElement();
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

	@Then("^Execution Backlog Gadgets should be added successfully$")
	public void execution_Backlog_Gadgets_should_be_added_successfully() throws Throwable {
		try
		 {
			actual[39]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			actual[40]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget in multiple Dashboards with same project/release and filter By Priority$")
	public void add_Executions_Backlog_Gadget_in_multiple_Dashboards_with_same_project_release_and_filter_By_Priority() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  for(int i=0;i<=4;i++)
			  {
			  actual[41]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  bp.waitForElement();
			  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 32+i, 0);
			  actual[42]=dp.searchDashboard(dashBoard);
			  bp.waitForElement();
			  actual[43]=dp.selectDashboard(dashBoard);
			  bp.waitForElement(); 
			  actual[44]=dp.validateDashBoard(dashBoard);
			  actual[45]=dp.clickOnAddGadgetSymbol();
			  bp.waitForElement();
			  actual[46]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[47]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[48]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			  String [] priority=new String [1];
			  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 9);
			  actual[49]=dp.filterBy(filterBy, priority);
			  actual[50]=dp.saveGadget();
			  bp.waitForElement();
			  actual[51]=dp.validateSavedGadget(project);
			  actual[52]=dp.viewMsg(filterBy);
			  bp.waitForElement();
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

	@Then("^Execution Backlog Gadgets should be added Successfully$")
	public void execution_Backlog_Gadgets_should_be_added_Successfully() throws Throwable {
		try
		 {
			actual[53]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[54]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget in multiple Dashboards with same project/release and filter By Tag$")
	public void add_Executions_Backlog_Gadget_in_multiple_Dashboards_with_same_project_release_and_filter_By_Tag() throws Throwable {
	   
		try
		 {
			  for(int i=0;i<=4;i++)
			  {
			  actual[55]=dp.clickOnManageDashboards();
			  actual[56]=dp.validateDashboards();
			  bp.waitForElement();
			  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 32+i, 0);
			  actual[57]=dp.searchDashboard(dashBoard);
			  bp.waitForElement();
			  actual[58]=dp.selectDashboard(dashBoard);
			  bp.waitForElement(); 
			  actual[59]=dp.validateDashBoard(dashBoard);
			  actual[60]=dp.clickOnAddGadgetSymbol();
			  bp.waitForElement();
			  actual[61]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[62]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[63]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			  String [] tag=new String [1];
			  tag[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 2, 10);
			  actual[64]=dp.filterBy(filterBy, tag);
			  actual[65]=dp.saveGadget();
			  bp.waitForElement();
			  actual[66]=dp.validateSavedGadget(project);
			  actual[67]=dp.viewMsg(filterBy);
			  bp.waitForElement();
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

	@Then("^Execution Backlog gadgets should be added Successfully$")
	public void execution_Backlog_gadgets_should_be_added_Successfully() throws Throwable {
		try
		 {
			actual[68]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[69]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget in multiple Dashboards with same project/release and filter By Custom Feild$")
	public void add_Executions_Backlog_Gadget_in_multiple_Dashboards_with_same_project_release_and_filter_By_Custom_Feild() throws Throwable {
		try
		 {
			  for(int i=0;i<=4;i++)
			  {
			  actual[70]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  bp.waitForElement();
			  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 32+i, 0);
			  actual[71]=dp.searchDashboard(dashBoard);
			  bp.waitForElement();
			  actual[72]=dp.selectDashboard(dashBoard);
			  bp.waitForElement(); 
			  actual[73]=dp.validateDashBoard(dashBoard);
			  actual[74]=dp.clickOnAddGadgetSymbol();
			  bp.waitForElement();
			  actual[75]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[76]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[77]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] custom=new String [1];
			  bp.waitForElement();
			  custom[0]=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 9);
			  actual[78]=dp.filterBy(filterBy, custom);
			  actual[79]=dp.saveGadget();
			  bp.waitForElement();
			  actual[80]=dp.validateSavedGadget(project);
			  actual[81]=dp.viewMsg(filterBy);
			  bp.waitForElement();
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
	
	@Then("^Execution Backlog gadgets should be Added Successfully$")
	public void execution_Backlog_gadgets_should_be_Added_Successfully() throws Throwable {
		try
		 {
			actual[82]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[83]=dp.viewMsg(filterBy);
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


	@When("^Add Executions Backlog Gadget in multiple Dashboards with different project/release/cyles$")
	public void add_Executions_Backlog_Gadget_in_multiple_Dashboards_with_different_project_release_cyles() throws Throwable {
		try
		 {
			  for(int i=0;i<=4;i++)
			  {
			  actual[84]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  bp.waitForElement();
			  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 32+i, 0);
			  actual[85]=dp.searchDashboard(dashBoard);
			  bp.waitForElement();
			  actual[86]=dp.selectDashboard(dashBoard);
			  bp.waitForElement(); 
			  actual[87]=dp.validateDashBoard(dashBoard);
			  actual[88]=dp.clickOnAddGadgetSymbol();
			  bp.waitForElement();
			  actual[89]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[90]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[91]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			  String [] cycle=new String [1];
			  cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 42+i, 0);
			  actual[92]=dp.filterBy(filterBy, cycle);
			  actual[93]=dp.saveGadget();
			  bp.waitForElement();
			  actual[94]=dp.validateSavedGadget(project);
			  actual[95]=dp.viewMsg(filterBy);
			  bp.waitForElement();
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

	@Then("^Execution backlog gadgets should be added Successfully$")
	public void execution_backlog_gadgets_should_be_added_Successfully() throws Throwable {
		try
		 {
			actual[96]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			actual[97]=dp.viewMsg(filterBy);
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
