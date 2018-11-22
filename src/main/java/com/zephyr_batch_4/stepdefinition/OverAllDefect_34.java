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

public class OverAllDefect_34 extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="OverAllDefect_34";
	   
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	DashBoardPage dp;
	ExecutionPage ep;
	TestRepositoryPage tr;
    TestPlanningPage tp;
		
	boolean actual[]=new boolean[52];
	SoftAssert soft=new SoftAssert();
	    
	String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	    
	private int defectCount;
	@Given("^Lead is in Test Repository page$")
	public void lead_is_in_Test_Repository_page() throws Throwable {
		 try
         {
         lp=new LoginPage(driver);
	     bp=new BasePage();
	     pp=new ProjectPage(driver);
	     ep=new ExecutionPage(driver);
	     rp=new ReleasePage(driver); 
		 actual[0]=pp.selectProject(project);
		 actual[1]=pp.selectRelease(release);
		 actual[2]=bp.waitForElement();
		 actual[3]=rp.clickOnTestRep();
    	 actual[4]=bp.waitForElement(); 
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

	@When("^Create phase, add testcases, launch Test Planning and assign phase to cycle$")
	public void create_phase_add_testcases_launch_Test_Planning_and_assign_phase_to_cycle() throws Throwable {
		 try
	     {
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 actual[5]=tr.clickOnRelease(release);
	  	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 51, 0);
	  	 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
	  	 actual[6]=tr.addNode(name, Desc);
	  	 bp.waitForElement();
	  	 String [] navigation=new String [1];
	  	 navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 51, 0);
	   	 actual[7]=tr.navigateToNode(release, navigation);
	  	 actual[8]=tr.addTestCase();
	  	 actual[9]=bp.waitForElement();   
	  	 actual[10]=rp.clickOnTestPlanning();
		 actual[11]=tp.clickOnAddTestCycleSymbol();
		 bp.waitForElement();
		 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 25, 0);
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
		 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 25, 0);
		 actual[15]=tp.navigateToCycle(cycle1);
		 String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 51,0);
		 actual[16]=tp.addPhaseToCycle(Phase);
		 actual[17]=bp.waitForElement();
		 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
		 actual[18]=tp.bulkAssignment(Bulk_type);
		 bp.waitForElement();
		 tp.goBackToCycle(); 
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

	@When("^Launch Test Execution, execute testcase and Link defect with any status$")
	public void launch_Test_Execution_execute_testcase_and_Link_defect_with_any_status() throws Throwable {
		try
		{
		 ep=new ExecutionPage(driver);
		 actual[19]=rp.clickOnTestExecution();
		 actual[20]=bp.waitForElement();
		 String[] cycleName=new String[2];           
		 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",25,0 );
		 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",51,0);
		 actual[21]=tr.navigateToNode(release, cycleName);
		 bp.waitForElement();
		 actual[22]=ep.selectAndDeselectAllTestCase();
		 bp.waitForElement();
	     String status12=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		 actual[23]=ep.changeMultiSelectedStatus(status12);
	     bp.waitForElement();
		 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
		 actual[24]=ep.clickOnDefectButton(testcase1);
		 bp.waitForElement();
		 String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
		 actual[25]=ep.linkDefect(defectId);
		 bp.waitForElement();
		 bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}         
	}

	@Then("^Defect should be linked with testcases$")
	public void defect_should_be_linked_with_testcases() throws Throwable {
		try
		{
	    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
		String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
		actual[26]=ep.validateLinkedDefect(testcase1, defectId);
		bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@When("^Launch Dashboards Page$")
	public void launch_Dashboards_Page() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		actual[27]=dp.clickOnManageDashboards();
		bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@Then("^Dashboards page should be launched$")
	public void dashboards_page_should_be_launched() throws Throwable {
		try
		{
	    actual[28]=dp.validateDashboards();		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@When("^Add Dashboard by clicking on add button$")
	public void add_Dashboard_by_clicking_on_add_button() throws Throwable {
		try
		{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 0);
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[29]=dp.clickOnAddDashBoardSymbol();
		bp.waitForElement();
		actual[30]=dp.enterDashBoardDetails(name, desc, layout, shareType);
		bp.waitForElement();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@Then("^New dashboard should be added$")
	public void new_dashboard_should_be_added() throws Throwable {
		try
		{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 0);
		actual[31]=dp.validateDashBoard(name);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}            
	}

	@When("^Click on newly added dashboard$")
	public void click_on_newly_added_dashboard() throws Throwable {
		try
		{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 0);
		actual[32]=dp.searchDashboard(name);
	    bp.waitForElement();
		actual[33]=dp.selectDashboard(name);
		bp.waitForElement();		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@When("^Add Overall Defects Gadget by clicking on add button symbol$")
	public void add_Overall_Defects_Gadget_by_clicking_on_add_button_symbol() throws Throwable {
		try
		{
		actual[34]=dp.clickOnAddGadgetSymbol();
		bp.waitForElement();
		String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[35]=dp.addGadget(gadgetName);
		bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@Then("^Overall Defect Gadget should be added$")
	public void overall_Defect_Gadget_should_be_added() throws Throwable {
		try
		{
		String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
		actual[36]=dp.validateGadget(gadget);
		bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@When("^Select  project,Release,refresh rate and save it$")
	public void select_project_Release_refresh_rate_and_save_it() throws Throwable {
		try
		{
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[37]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
		bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@Then("^Should show proper defect count$")
	public void should_show_proper_defect_count() throws Throwable {
		try
		{
		defectCount=dp.linkCountInGadgetPage();	
		bp.waitForElement();
		pp.backToProjectPage();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}          
	}

	@When("^Go to test planning and unassign the texecution having defect$")
	public void go_to_test_planning_and_unassign_the_texecution_having_defect() throws Throwable {
		try
		{
		actual[38]=pp.selectProject(project);
	  	actual[39]=pp.selectRelease(release);
	  	bp.waitForElement();
	  	actual[40]=rp.clickOnTestPlanning();
	  	bp.waitForElement();
	  	String[] cycleName=new String[1];           
		cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",51,0 );	
		actual[41]=tp.navigateToCycle(cycleName);
		actual[42]=tp.assignPhase();
		bp.waitForElement();
		String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",51,0 );	
		actual[43]=tr.selectPhase(phase);
		tp.selectallTestCase();
		bp.waitForElement();
		String assignee=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 2, 1);
		actual[44]=tp.assignAllSelected(assignee);
		bp.waitForElement();
		actual[45]= tp.goBackToCycle(); 
		bp.waitForElement();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@When("^View Overall Defects gadget now after unassigning the executions$")
	public void view_Overall_Defects_gadget_now_after_unassigning_the_executions() throws Throwable {
		try
		{
		dp=new DashBoardPage(driver);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 0);
		actual[46]=dp.clickOnManageDashboards();
		actual[47]=bp.waitForElement();
		actual[48]=dp.validateDashboards();
		actual[49]=dp.searchDashboard(name);
		bp.waitForElement();
		actual[50]=dp.selectDashboard(name);
		bp.waitForElement();	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}           
	}

	@Then("^Should show defect count decremented by one after removing executions$")
	public void should_show_defect_count_decremented_by_one_after_removing_executions() throws Throwable {
		try
		{
		int finalCount=dp.linkCountInGadgetPage();
		if(defectCount>finalCount)
		{
		System.out.println("Validated- total defect-count reduced by one");	 
		 }
		actual[51]=pp.backToProjectPage();
		for(int k=0;k<=actual.length-1;k++)
		{
		System.out.println("Actual["+k+"]=" + actual[k]);
		soft.assertEquals(actual[k], true);
		}	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}            
	}
	

}
