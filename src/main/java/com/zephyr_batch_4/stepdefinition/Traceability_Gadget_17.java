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

public class Traceability_Gadget_17 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="Traceability_Gadget_17";
	
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	LoginPage lp;
	ExportPage ex;
	RequirementsPage req;
	
	boolean actual[]=new boolean[57];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 10, 0);
	private String req_phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 2, 1);
	private String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 55, 0); 
	private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 55, 0);
	private String req_name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 2, 2);
	private String testCaseNo=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Requirements", 1, 0));	
	private String [] cycle_node =new String[2];
	{
	cycle_node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 29, 0);
	cycle_node[1]=phase;
	}
	
	
	@Given("^As a lead map a requirement to testcase  and execute a testcases$")
	public void as_a_lead_map_a_requirement_to_testcase_and_execute_a_testcases() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		rp=new ReleasePage(driver);
		bp=new BasePage();
		ctc=new CreateTestCasePage(driver);
		tp=new TestPlanningPage(driver);
		ep=new ExecutionPage(driver);
		dp=new DashBoardPage(driver);
		ex=new ExportPage(driver);
		req=new RequirementsPage(driver);
		tr=new TestRepositoryPage(driver);
		pp.selectProject(project2);
		actual[0]=pp.selectProject(project);
		actual[1]=pp.selectRelease(release);
		actual[2]=rp.clickOnRequirements();
		bp.waitForElement();
		actual[3]=tr.clickOnRelease(release);
		actual[4]=req.addNode(req_phase, Desc);
		bp.waitForElement();
		String req_node[]=new String [1];
		req_node[0]=req_phase;
		actual[5]=tr.navigateToNode(release, req_node);
		actual[6]=req.addRequirement();
		bp.waitForElement();
	    tr.clickOnDetails();
	    bp.waitForElement();
		String req_Desc=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100, 0);
		actual[7]=req.enterRequirementDetails(req_name, req_Desc, req_Desc, req_Desc, req_Desc);
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement(); 
		actual[8]=rp.clickOnTestRep();
		actual[9]=tr.clickOnRelease(release);
		actual[10]=tr.addNode(phase, Desc); 
		String node[]=new String [1];
		node[0]=phase;
		actual[11]=tr.navigateToNode(release, node);
		actual[12]=tr.addTestCase();
		actual[13]=bp.waitForElement();
	    tr.clickOnDetails();
	    bp.waitForElement();
		actual[14]=req.MapRequirements();
		bp.waitForElement();
		actual[15]=req.ExpandRelease(release);
		String [] req_Node=new String[1];
		req_Node[0]=req_phase;
		actual[16]=tr.navigateNode(req_Node);
		bp.waitForElement();
		String testcase1[]=new String[1];
		testcase1[0]=testCaseNo;
		System.out.println("requirement" + testcase1);
		actual[17]=tr.selectRequirementFromGrids(testcase1);
		bp.explicitWait(req.clickOnSavejirareq);
		req.clickOnSavejirareq.click();
		bp.waitForElement();
	    tr.clickOnList();
	    bp.waitForElement();
		actual[18]=rp.clickOnTestPlanning();
		actual[19]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 29, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		actual[20]=tp.CreateCycle(cycle, Build, Environment, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[21]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[22]=tp.saveTestCycle(); 
		bp.waitForElement(); 
		String [] cycle1=new String [1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 29, 0);
		actual[23]=tp.navigateToCycle(cycle1);
		actual[24]=tp.addPhaseToCycle(phase);
		actual[25]=bp.waitForElement();
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	 	actual[26]=tp.bulkAssignment(Bulk_type);
	 	tp.goBackToCycle();
	    bp.waitForElement();
	    actual[27]=rp.clickOnTestExecution();
	    bp.waitForElement();
		actual[28]=tr.navigateToNode(release, cycle_node);
		actual[29]=bp.waitForElement();
		actual[30]=ep.selectAndDeselectAllTestCase();
		bp.waitForElement();
		int testcase[]=new int[1];
		testcase[0]=Integer.parseInt(testCaseNo);
		String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		actual[31]=ep.changeStatusOfTestCases(testcase, status);
		bp.waitForElement();
		actual[32]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[33]=dp.clickOnAddDashBoardSymbol();
		String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		actual[34]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		bp.waitForElement();
		actual[35]=dp.validateDashBoard(dashBoardName);
		actual[36]=dp.selectDashboard(dashBoardName);
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

	@Given("^Add a Traceability gadget$")
	public void add_a_Traceability_gadget() throws Throwable {
		try
		{
		actual[37]=dp.clickOnAddGadgetSymbol();
		String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 4);
		actual[38]=dp.addGadget(gadget);
		bp.waitForElement();
		String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		actual[39]=dp.configureTraceabilityGadget(project, release, refreshRate);
		bp.waitForElement();
		actual[40]=dp.manageTraceability();
		bp.waitForElement();
		actual[41]=dp.traceabilityQuickSearch(req_name);
		bp.waitForElement();
		actual[42]=req.selectAllRequirements();
		actual[43]=dp.closeTraceabilityTable();
		actual[44]=dp.saveTraceabilityGadget();
		bp.waitForElement();
		actual[45]=dp.reqTraceabilityTable();
		bp.waitForElement();
		pp.backToProjectPage();
		pp.selectProject(project2);
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

	@When("^Reassign executed testcases that is mapped to selected requirement in saved Traceability Report gadget$")
	public void reassign_executed_testcases_that_is_mapped_to_selected_requirement_in_saved_Traceability_Report_gadget() throws Throwable {
		try
		{
		actual[46]=pp.selectProject(project);
		actual[47]=pp.selectRelease(release);
		actual[48]=rp.clickOnTestPlanning();
		String [] phase_Name=new String [1];
		phase_Name[0]=phase;
		actual[49]=tp.navigateToCycle(phase_Name);
		tp.assignPhase();
		bp.waitForElement();
		actual[49]=tp.navigateToCycle(phase_Name);
		int [] tcNo=new int[1];
		tcNo[0]=Integer.parseInt(testCaseNo);
		actual[50]=tp.selectSingleMultipleTestcase(tcNo);
		String assignee=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 1, 1);
		actual[51]=tp.assignAllSelected(assignee);
		bp.waitForElement();
		tp.goBackToCycle();
		actual[52]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[53]=dp.searchDashboard(dashBoardName);
		actual[54]=dp.selectDashboard(dashBoardName);
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

	@Then("^Should be able to view the saved gadget without any error$")
	public void should_be_able_to_view_the_saved_gadget_without_any_error() throws Throwable {
		try
		{
		actual[55]=dp.reqTraceabilityTable();
		bp.waitForElement();
		actual[56]=pp.backToProjectPage();
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
