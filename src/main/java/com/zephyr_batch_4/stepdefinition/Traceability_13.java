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

public class Traceability_13 extends LaunchBrowser {
	
	
	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="Traceability_Gadget_13";
	
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
	
	boolean actual[]=new boolean[73];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 11, 0);
	private String req_phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 3, 1);
	private String req_phase2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 4, 1);
	private String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 56, 0); 
	private String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 56, 0);
	private String phase2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 57, 0);
	private String req_name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 3, 2);
	private String req_name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 4, 2);
	private String testCaseNo=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Requirements", 1, 0));	
	
	@Given("^Login as a lead, add requirement, create multiple testcases and map the requirement$")
	public void login_as_a_lead_add_requirement_create_multiple_testcases_and_map_the_requirement() throws Throwable {
	 try
	 {
	 pp=new ProjectPage(driver);
	 rp=new ReleasePage(driver);
	 bp=new BasePage();
	 req=new RequirementsPage(driver);
	 tr=new TestRepositoryPage(driver);
	 ex=new ExportPage(driver);
	 ctc=new CreateTestCasePage(driver);
	 pp.selectProject(project2);
	 actual[0]=pp.selectProject(project);
	 actual[1]=pp.selectRelease(release);
	 bp.waitForElement();
	 actual[2]=rp.clickOnRequirements();
	 bp.waitForElement();
	 actual[3]=req.clickOnRelease(release);
	 actual[4]=req.addNode(req_phase1, Desc);
	 bp.waitForElement();
	 String req_node1[]=new String [1];
	 req_node1[0]=req_phase1;
	 actual[5]=tr.navigateToNode(release, req_node1);
	 actual[6]=req.addRequirement();
	 bp.waitForElement();
     tr.clickOnDetails();
     bp.waitForElement();
	 String req_Desc=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100, 0);
	 actual[7]=req.enterRequirementDetails(req_name1, req_Desc, req_Desc, req_Desc, req_Desc);
	 bp.waitForElement();
	 tr.clickOnList();
	 bp.waitForElement();
	 actual[8]=req.clickOnRelease(release);
	 actual[9]=req.addNode(req_phase2, Desc);
	 bp.waitForElement();
	 String req_node2[]=new String [1];
	 req_node2[0]=req_phase2;
	 actual[10]=tr.navigateToNode(release, req_node2);
	 actual[11]=req.addRequirement();
	 bp.waitForElement();
     tr.clickOnDetails();
     bp.waitForElement();
	 String req_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 100, 0);
	 actual[12]=req.enterRequirementDetails(req_name2, req_Desc1, req_Desc1, req_Desc1, req_Desc1);
	 bp.waitForElement();
	 tr.clickOnList();
	 bp.waitForElement();  
	 actual[13]=rp.clickOnTestRep();
	 bp.waitForElement();
	 actual[14]=tr.clickOnRelease(release);
	 actual[15]=tr.addNode(phase1, Desc); 
	 String node1[]=new String [1];
	 node1[0]=phase1;
	 actual[16]=tr.navigateToNode(release, node1);
	 for(int i=0;i<=4;i++)
	 {
	 String testcaseNo[]=new String[1];
	 actual[17]=tr.addTestCase();
	 actual[18]=bp.waitForElement();
	 tr.clickOnDetails();
	 bp.waitForElement();
	 testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", i+1, 0));
	 actual[19]=ex.selectMultipleTestCaseFromGrid(testcaseNo); 
	 bp.waitForElement();
	 actual[20]=req.MapRequirements();
	 bp.waitForElement();
	 actual[21]=req.ExpandRelease(release);
	 bp.waitForElement();
	 String [] req_Node=new String[1];
	 req_Node[0]=req_phase1;
	 actual[22]=tr.navigateNode(req_Node);
	 bp.waitForElement();
	 String testcase1[]=new String[1];
	 testcase1[0]=testCaseNo;
	 actual[23]=tr.selectRequirementFromGrids(testcase1);
	 bp.waitForElement(); 
	 bp.explicitWait(req.clickOnSavejirareq);
	 req.clickOnSavejirareq.click();
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

	@Given("^Add a testcase and map requirements to testcase and link a single defect with status Open$")
	public void add_a_testcase_and_map_requirements_to_testcase_and_link_a_single_defect_with_status_Open() throws Throwable {
	try
	 {
	 tp=new TestPlanningPage(driver);
	 ep=new ExecutionPage(driver);
	 actual[24]=tr.clickOnRelease(release);
	 tr.applyNotification();
	 actual[25]=tr.addNode(phase2, Desc); 
	 String node[]=new String [1];
	 node[0]=phase2;
	 actual[26]=tr.navigateToNode(release, node);
	 actual[27]=tr.addTestCase();
	 actual[28]=bp.waitForElement();
	 tr.clickOnDetails();
	 bp.waitForElement();
	 actual[29]=req.MapRequirements();
	 bp.waitForElement();
	 actual[30]=req.ExpandRelease(release);
	 String [] req_Node=new String[1];
	 req_Node[0]=req_phase2;
	 actual[31]=tr.navigateNode(req_Node);
	 bp.waitForElement();
	 String testcase1[]=new String[1];
	 testcase1[0]=testCaseNo;
	 actual[32]=tr.selectRequirementFromGrids(testcase1);
	 bp.waitForElement();
	 bp.explicitWait(req.clickOnSavejirareq);
	 req.clickOnSavejirareq.click();
	 bp.waitForElement();
	 tr.clickOnList();
	 bp.waitForElement();
	 actual[33]=rp.clickOnTestPlanning();
	 actual[34]=tp.clickOnAddTestCycleSymbol();
	 bp.waitForElement();
	 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 30, 0);
	 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
	 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
	 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
	 actual[35]=tp.CreateCycle(cycle, Build, Environment, hide);
	 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
	 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
	 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
	 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
	 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
	 actual[36]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	 actual[37]=tp.saveTestCycle(); 
	 bp.waitForElement(); 
	 String [] cycle1=new String [1];
	 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 30, 0);
	 actual[38]=tp.navigateToCycle(cycle1);
	 actual[39]=tp.addPhaseToCycle(phase2);
	 actual[40]=bp.waitForElement();
	 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	 actual[41]=tp.bulkAssignment(Bulk_type);
	 tp.goBackToCycle();
	 bp.waitForElement();
	 actual[42]=rp.clickOnTestExecution();
	 bp.waitForElement();
	 String [] cycle_node =new String[2];
	 cycle_node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 30, 0);
	 cycle_node[1]=phase2;
     actual[43]=tr.navigateToNode(release, cycle_node);
	 actual[44]=bp.waitForElement();
	 actual[45]=ep.selectAndDeselectAllTestCase();
	 bp.waitForElement();
	 int testcase[]=new int[1];
	 testcase[0]=Integer.parseInt(testCaseNo);
	 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
	 actual[46]=ep.changeStatusOfTestCases(testcase, status);
	 bp.waitForElement();
	 int testcase11=Integer.parseInt(testCaseNo);
	 actual[47]=ep.clickOnDefectButton(testcase11);
	 bp.waitForElement();
	 String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 10);
	 ep.searchDefect(defectId);
	 ep.linkDefects.click();
	 bp.waitForElement();
	 ep.cancelDefect.click();
	 actual[48]=bp.waitForElement();
	 bp.waitForElement();
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

	@When("^Add Traceability Gadget for a Release having requirements mapped to multiple testcases$")
	public void add_Traceability_Gadget_for_a_Release_having_requirements_mapped_to_multiple_testcases() throws Throwable { 
	try
	 {
	 dp=new DashBoardPage(driver);
	 actual[49]=dp.clickOnManageDashboards();
	 bp.waitForElement();
	 actual[50]=dp.clickOnAddDashBoardSymbol();
	 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
	 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
	 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
	 actual[51]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
	 bp.waitForElement();
	 actual[52]=dp.validateDashBoard(dashBoardName);
	 actual[53]=dp.selectDashboard(dashBoardName);
	 bp.waitForElement();
	 actual[54]=dp.clickOnAddGadgetSymbol();
	 String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 4);
	 actual[55]=dp.addGadget(gadget);
	 bp.waitForElement();
	 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
	 actual[56]=dp.configureTraceabilityGadget(project, release, refreshRate);
	 bp.waitForElement();
	 actual[57]=dp.manageTraceability();
	 bp.waitForElement();
	 actual[58]=dp.traceabilityQuickSearch(req_name1);
	 bp.waitForElement();
	 actual[59]=req.selectAllRequirements();
	 bp.waitForElement();
	 actual[60]=dp.closeTraceabilityTable();
	 actual[61]=dp.saveTraceabilityGadget();
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

	@Then("^Should be able to add the gadget and view the total count successfully$")
	public void should_be_able_to_add_the_gadget_and_view_the_total_count_successfully() throws Throwable {
	try
	 {
	 actual[62]=dp.reqTraceabilityTable();
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

	@When("^Add Traceability Gadget for Release with multiple requirements mapped to single testcase$")
	public void add_Traceability_Gadget_for_Release_with_multiple_requirements_mapped_to_single_testcase() throws Throwable {
	try
	 {
	 actual[63]=dp.clickOnAddGadgetSymbol();
	 String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 4);
	 actual[64]=dp.addGadget(gadget);
	 bp.waitForElement();
	 driver.navigate().refresh();
	 bp.waitForElement();
	 bp.waitForElement();
	 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
	 actual[65]=dp.configureTraceabilityGadget(project, release, refreshRate);
	 bp.waitForElement();
	 actual[66]=dp.manageTraceability();
	 bp.waitForElement();
	 actual[67]=dp.traceabilityQuickSearch(req_name2);
 	 bp.waitForElement();
	 actual[68]=req.selectAllRequirements();
	 actual[69]=dp.closeTraceabilityTable();
	 actual[70]=dp.saveTraceabilityGadget();
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

	@Then("^Should be able to add TraceAbility Gadget successfully$")
	public void should_be_able_to_add_TraceAbility_Gadget_successfully() throws Throwable {
	try
	 {
	 actual[71]=dp.reqTraceabilityTable();
	 bp.waitForElement();	
	 actual[72]=pp.backToProjectPage();
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
