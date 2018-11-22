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

public class Execution_Backlog_13 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_13";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	boolean actual[]=new boolean[77];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	 String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 37, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	@Given("^Launch Test Repository, add phase and add testcases with priorities to all testcases$")
	public void launch_Test_Repository_add_phase_and_add_testcases_with_priorities_to_all_testcases() throws Throwable {
		 try
		 {
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 ctc=new CreateTestCasePage(driver);
			 bp=new BasePage();
			 pp.selectProject(project2);
			 actual[0]=pp.selectProject(project);
			 actual[1]=pp.selectRelease(release);
			 bp.waitForElement();	
			 actual[2]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[3]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 70, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[4]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[5]=tr.navigateToNode(release, navigation);
			 for(int i=0;i<=4;i++)
			 {
			 actual[6]=tr.addTestCase();
			 bp.waitForElement();	
			 tr.clickOnDetails();
			 bp.waitForElement();
			 String priority[]=new String [1];
			 priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1+i, 9);
			 actual[8]=ctc.enterPriority(priority);
			 bp.waitForElement();
			 tr.clickOnList();
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

	@Given("^Launch Test Planning, add cycle to phase and execute testcases in Test Execution page$")
	public void launch_Test_Planning_add_cycle_to_phase_and_execute_testcases_in_Test_Execution_page() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 ep=new ExecutionPage(driver);
			 actual[9]=rp.clickOnTestPlanning();
			 actual[10]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 47, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[11]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[12]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[13]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 47, 0);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 70, 0);
			 actual[14]=tp.navigateToCycle(cycle1);
			 actual[15]=tp.addPhaseToCycle(phase);
			 actual[16]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[17]=tp.bulkAssignment(Bulk_type);
			 bp.waitForElement();
			 actual[16]=tp.goBackToCycle();
			 bp.waitForElement();  
			 actual[17]=rp.clickOnTestExecution();
			 actual[18]=bp.waitForElement();
			 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",47,0 );
			 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",70,0 );
			 actual[19]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[20]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[21]=ep.changeMultiSelectedStatus(status);
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

	@Given("^Launch Manage Dashboard and create new Dashboard$")
	public void launch_Manage_Dashboard_and_create_new_Dashboard() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[22]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  actual[23]=dp.clickOnAddDashBoardSymbol();
			  actual[24]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			  bp.waitForElement(); 
			  actual[25]=dp.validateDashBoard(dashBoardName);
			  actual[26]=dp.selectDashboard(dashBoardName);
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

	@When("^Add Executions Backlog Gadget and select a project, release and priority if there is only priority P one added in testcases$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_priority_if_there_is_only_priority_P_one_added_in_testcases() throws Throwable {
		try
		 {
		  actual[27]=dp.clickOnAddGadgetSymbol();
		  actual[28]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[29]=dp.validateGadget(gadget); 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[30]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
		  String [] priority =new String [1];
		  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 9);
		  actual[31]=dp.filterBy(filterBy, priority);
		  actual[32]=dp.saveGadget();
		  bp.waitForElement();
		  actual[33]=dp.validateSavedGadget(project);
		  actual[34]=dp.viewMsg(filterBy);
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

	@Then("^Execution backlog Gadget should be created for priority P one$")
	public void execution_backlog_Gadget_should_be_created_for_priority_P_one() throws Throwable {
		try
		 {
			actual[35]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[36]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget and select a project, release and priority if there is only priority P two added in testcases$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_priority_if_there_is_only_priority_P_two_added_in_testcases() throws Throwable {
		try
		 {
		  actual[37]=dp.clickOnAddGadgetSymbol();
		  actual[38]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[39]=dp.validateGadget(gadget); 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[40]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
		  String [] priority =new String [1];
		  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 9);
		  actual[41]=dp.filterBy(filterBy, priority);
		  actual[42]=dp.saveGadget();
		  bp.waitForElement();
		  actual[43]=dp.validateSavedGadget(project);
		  actual[44]=dp.viewMsg(filterBy);
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

	@Then("^Execution backlog Gadget should be created for priority P two$")
	public void execution_backlog_Gadget_should_be_created_for_priority_P_two() throws Throwable {
		try
		 {
			actual[45]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[46]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget and select a project, release and priority if there is only priority P three added in testcases$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_priority_if_there_is_only_priority_P_three_added_in_testcases() throws Throwable {
		try
		 {
		  actual[47]=dp.clickOnAddGadgetSymbol();
		  actual[48]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[49]=dp.validateGadget(gadget); 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[50]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
		  String [] priority =new String [1];
		  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 9);
		  actual[51]=dp.filterBy(filterBy, priority);
		  actual[52]=dp.saveGadget();
		  bp.waitForElement();
		  actual[53]=dp.validateSavedGadget(project);
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

	@Then("^Execution backlog Gadget should be created for priority P three$")
	public void execution_backlog_Gadget_should_be_created_for_priority_P_three() throws Throwable {
		try
		 {
			actual[55]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[56]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget and select a project, release and priority if there is only priority P four added in testcases$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_priority_if_there_is_only_priority_P_four_added_in_testcases() throws Throwable {
		try
		 {
		  actual[57]=dp.clickOnAddGadgetSymbol();
		  actual[58]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[59]=dp.validateGadget(gadget); 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[60]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
		  String [] priority =new String [1];
		  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 9);
		  actual[61]=dp.filterBy(filterBy, priority);
		  actual[62]=dp.saveGadget();
		  bp.waitForElement();
		  actual[63]=dp.validateSavedGadget(project);
		  actual[64]=dp.viewMsg(filterBy);
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

	@Then("^Execution backlog Gadget should be created for priority P four$")
	public void execution_backlog_Gadget_should_be_created_for_priority_P_four() throws Throwable {
		try
		 {
			actual[65]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[66]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget and select a project, release and priority if there is only priority P five added in testcases$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_priority_if_there_is_only_priority_P_five_added_in_testcases() throws Throwable {
		try
		 {
		  actual[67]=dp.clickOnAddGadgetSymbol();
		  actual[68]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[69]=dp.validateGadget(gadget); 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[70]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
		  String [] priority =new String [1];
		  priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 9);
		  actual[71]=dp.filterBy(filterBy, priority);
		  actual[72]=dp.saveGadget();
		  bp.waitForElement();
		  actual[73]=dp.validateSavedGadget(project);
		  actual[74]=dp.viewMsg(filterBy);
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

	@Then("^Execution backlog Gadget should be created for priority P five$")
	public void execution_backlog_Gadget_should_be_created_for_priority_P_five() throws Throwable {
		try
		 {
			actual[75]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[76]=dp.viewMsg(filterBy);
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
