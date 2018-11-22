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

public class Execution_Backlog_7 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_7";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	
	boolean actual[]=new boolean[110];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 31, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	 String[] cycleName=new String[2];      
	 {
	 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",42,0 );
	 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",68,0 );
	 }
	
	@Given("^launch Test Repository page, add phase and add testcase$")
	public void launch_Test_Repository_page_add_phase_and_add_testcase() throws Throwable {
		 try
		 {
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 bp=new BasePage();
			 pp.selectProject(project2);
			 actual[0]=pp.selectProject(project);
			 actual[1]=pp.selectRelease(release);
			 bp.waitForElement();	
			 actual[2]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[3]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 68, 0);
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

	@Given("^Launch Test planning,add a phase to cycle and launch Test Execution, execute the testcase to PASS$")
	public void launch_Test_planning_add_a_phase_to_cycle_and_launch_Test_Execution_execute_the_testcase_to_PASS() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 ep=new ExecutionPage(driver);
			 actual[7]=rp.clickOnTestPlanning();
			 actual[8]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 42, 0);
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
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 42, 0);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 68, 0);
			 actual[12]=tp.navigateToCycle(cycle1);
			 actual[13]=tp.addPhaseToCycle(phase);
			 actual[14]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[15]=tp.bulkAssignment(Bulk_type);
			 bp.waitForElement();
			 actual[16]=tp.goBackToCycle();
			 bp.waitForElement();  
			 actual[17]=rp.clickOnTestExecution();
			 actual[18]=bp.waitForElement();
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

	@Given("^Launch dashboards page and create new dashboard$")
	public void launch_dashboards_page_and_create_new_dashboard() throws Throwable {
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

	@When("^Add Execution Backlog Gadget and select By User checkbox if user has execution status as only PASS$")
	public void add_Execution_Backlog_Gadget_and_select_By_User_checkbox_if_user_has_execution_status_as_only_PASS() throws Throwable {
		try
		 {
			  actual[26]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[27]=dp.clickOnAddGadgetSymbol();
			  actual[28]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[29]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[30]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[31]=dp.filterBy(filterBy, user);
			  actual[32]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be add successfully with status pass$")
	public void execution_Backlog_Gadget_should_be_add_successfully_with_status_pass() throws Throwable {
		try
		 {
			actual[33]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[34]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
			pp.backToProjectPage();
			
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

	@When("^Launch test Execution page and Execute the testcase to Fail$")
	public void launch_test_Execution_page_and_Execute_the_testcase_to_Fail() throws Throwable {
		try
		 {  
			 ep=new ExecutionPage(driver);
			 actual[35]=pp.selectProject(project);
		     actual[36]=pp.selectRelease(release);
		     bp.waitForElement();	
			 actual[37]=rp.clickOnTestExecution();
			 actual[38]=bp.waitForElement();
			 actual[39]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[40]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
			 actual[41]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 actual[42]=dp.clickOnManageDashboards();
			 actual[43]=dp.validateDashboards();
			 actual[44]=dp.searchDashboard(dashBoardName);
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

	@When("^Add Execution Backlog Gadget and select By User checkbox if user has execution status as only Fail$")
	public void add_Execution_Backlog_Gadget_and_select_By_User_checkbox_if_user_has_execution_status_as_only_Fail() throws Throwable {
		try
		 {
			  actual[45]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[46]=dp.clickOnAddGadgetSymbol();
			  actual[47]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[48]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[49]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[50]=dp.filterBy(filterBy, user);
			  actual[51]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be add successfully with status fail$")
	public void execution_Backlog_Gadget_should_be_add_successfully_with_status_fail() throws Throwable {
		try
		 {
			actual[52]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[53]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
			pp.backToProjectPage();
			
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

	@When("^Launch test Execution page and Execute the testcase to WIP$")
	public void launch_test_Execution_page_and_Execute_the_testcase_to_WIP() throws Throwable {
		try
		 {  
			 ep=new ExecutionPage(driver);
			 actual[54]=pp.selectProject(project);
		     actual[55]=pp.selectRelease(release);
		     bp.waitForElement();	
			 actual[56]=rp.clickOnTestExecution();
			 actual[57]=bp.waitForElement();
			 actual[58]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[59]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
			 actual[60]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 actual[61]=dp.clickOnManageDashboards();
			 actual[62]=dp.validateDashboards();
			 actual[63]=dp.searchDashboard(dashBoardName);
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

	@When("^Add Execution Backlog Gadget and select By User checkbox if user has execution status as only WIP$")
	public void add_Execution_Backlog_Gadget_and_select_By_User_checkbox_if_user_has_execution_status_as_only_WIP() throws Throwable {
		try
		 {
			  actual[64]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[65]=dp.clickOnAddGadgetSymbol();
			  actual[66]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[67]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[68]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  dp.filterBy(filterBy, user);
			  actual[69]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be add successfully with status WIP$")
	public void execution_Backlog_Gadget_should_be_add_successfully_with_status_WIP() throws Throwable {
		try
		 {
			actual[70]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[71]=dp.viewMsg(filterBy);
			bp.waitForElement();
			pp.backToProjectPage();
			
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

	@When("^Launch test Execution page and Execute the testcase to Block$")
	public void launch_test_Execution_page_and_Execute_the_testcase_to_Block() throws Throwable {
		try
		 {  
			 ep=new ExecutionPage(driver);
			 actual[72]=pp.selectProject(project);
		     actual[73]=pp.selectRelease(release);
		     bp.waitForElement();	
			 actual[74]=rp.clickOnTestExecution();
			 actual[75]=bp.waitForElement();
			 actual[76]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[77]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
			 actual[78]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 actual[79]=dp.clickOnManageDashboards();
			 actual[80]=dp.validateDashboards();
			 actual[81]=dp.searchDashboard(dashBoardName);
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

	@When("^Add Execution Backlog Gadget and select By User checkbox if user has execution status as only Block$")
	public void add_Execution_Backlog_Gadget_and_select_By_User_checkbox_if_user_has_execution_status_as_only_Block() throws Throwable {
		try
		 {
			  actual[82]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[83]=dp.clickOnAddGadgetSymbol();
			  actual[84]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[85]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[86]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[87]=dp.filterBy(filterBy, user);
			  actual[88]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be add successfully with status Block$")
	public void execution_Backlog_Gadget_should_be_add_successfully_with_status_Block() throws Throwable {
		try
		 {
			actual[89]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[90]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
			pp.backToProjectPage();
			
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

	@When("^Launch test Execution page and Execute the testcase to custom status$")
	public void launch_test_Execution_page_and_Execute_the_testcase_to_custom_status() throws Throwable {
		try
		 {  
			 ep=new ExecutionPage(driver);
			 actual[91]=pp.selectProject(project);
		     actual[92]=pp.selectRelease(release);
		     bp.waitForElement();	
			 actual[93]=rp.clickOnTestExecution();
			 actual[94]=bp.waitForElement();
			 actual[95]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[96]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 5, 2);
			 actual[97]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 actual[98]=dp.clickOnManageDashboards();
			 bp.waitForElement();
			 bp.waitForElement();
			 actual[99]=dp.validateDashboards();
			 bp.waitForElement();
			 actual[100]=dp.searchDashboard(dashBoardName);
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

	@When("^Add Execution Backlog Gadget and select By User checkbox if user has execution status as only custom$")
	public void add_Execution_Backlog_Gadget_and_select_By_User_checkbox_if_user_has_execution_status_as_only_custom() throws Throwable {
		try
		 {
			  actual[101]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[102]=dp.clickOnAddGadgetSymbol();
			  actual[103]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[104]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[105]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[106]=dp.filterBy(filterBy, user);
			  actual[107]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be add successfully with status custom$")
	public void execution_Backlog_Gadget_should_be_add_successfully_with_status_custom() throws Throwable {
		try
		 {
			actual[108]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[109]=dp.viewMsg(filterBy);
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
