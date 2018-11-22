package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
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

public class Traceability_Gadget_12 extends LaunchBrowser{

LaunchBrowser lb=new LaunchBrowser();
private String fileName="Traceability_Gadget_12";

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

boolean actual[]=new boolean[172];
SoftAssert soft=new SoftAssert();

private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
private String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 5, 1);
private String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 58, 0); 
private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 58, 0);
private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 12, 0);
private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 4);
private String testCaseNo=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Requirements", 1, 0));	

String [] Id=new String [4];
	

@Given("^Lead is requirement page and adds four requirements$")
public void lead_is_requirement_page_and_adds_four_requirements() throws Throwable {
	 try
	  {
	  pp=new ProjectPage(driver);
	  rp=new ReleasePage(driver);
	  bp=new BasePage();
	  req=new RequirementsPage(driver);
	  ex=new ExportPage(driver);
	  ctc=new CreateTestCasePage(driver);
	  tr=new TestRepositoryPage(driver);
	  pp.selectProject(project2);
	  actual[0]=pp.selectProject(project);
	  actual[1]=pp.selectRelease(release);
	  bp.waitForElement();
	  actual[2]=rp.clickOnRequirements();
	  actual[3]=bp.waitForElement();
	  String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1, 6);
 	  String JIRA=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1,7);
	  String JQL=Excel_Lib.getData(INPUT_PATH_5,"Requirements", 1, 3);
	  String enterQuerry=Excel_Lib.getData(INPUT_PATH_5,"Requirements", 1, 4);
	  actual[4]=req.clickOnImport();
	  actual[5]=req.chooseImportType(JIRA);
	  actual[6]=req.selectQuerry(JQL, enterQuerry);
	  String accessName=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1, 5);
	  actual[7]=req.selectAccessTypeAndFolderName(accessName, requirementNode);
	  bp.explicitWait(req.clickjiraSearchButton);
	  req.clickjiraSearchButton.click();
	  bp.waitForElement();
	  String testCaseNo1[]=new String[6];
	  for(int i=0;i<=5;i++)
	  { 
	    testCaseNo1[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", i+1, 0));
	  }
	  actual[8]=req.selectMultipleTestCaseFromGrid(testCaseNo1);
	  bp.waitForElement();
	  bp.explicitWait(req.clickOnImportSelected);
	  req.clickOnImportSelected.click(); 
	  bp.waitForElement();
	  String phase[]=new String[1];
	  phase[0]=requirementNode;
	  actual[9]=tr.navigateToNode(importedTree, phase);
	  bp.waitForElement();
	  actual[10]=tr.dragAndDropNode(requirementNode, release);
	  bp.waitForElement();
	  String[] node=new String[1];
	  node[0]=requirementNode;
	  actual[11]=tr.navigateToNode(release,node);
	  actual[12]=bp.waitForElement();   
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

@Given("^launch Test Repository and create four testcases and map to requirement$")
public void launch_Test_Repository_and_create_four_testcases_and_map_to_requirement() throws Throwable {
 try
 {
	  tp=new TestPlanningPage(driver);
	  actual[13]=rp.clickOnTestRep();
	  bp.waitForElement();
	  actual[14]=tr.clickOnRelease(release);
	  actual[15]=tr.addNode(phase, Desc); 
	  String node1[]=new String [1];
	  node1[0]=phase;
	  actual[16]=tr.navigateToNode(release, node1);
	  for(int i=0;i<=3;i++)
	  {
	  String testcaseNo[]=new String[1];
	  actual[17]=tr.addTestCase();
	  bp.waitForElement();
	  tr.clickOnDetails();
	  bp.waitForElement();
	  testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", i+1, 0));
	  actual[18]=ex.selectMultipleTestCaseFromGrid(testcaseNo); 
	  actual[19]=bp.waitForElement();
	  actual[20]=req.MapRequirements();
	  bp.waitForElement();
	  bp.waitForElement();
	  actual[21]=req.ExpandRelease(release);
	  bp.waitForElement();
	  String [] req_Node=new String[1];
	  req_Node[0]=requirementNode;
	  actual[22]=tr.navigateNode(req_Node);
	  bp.waitForElement();
	  String testcase1[]=new String[1];
	  testcase1[0]=testCaseNo;
	  actual[23]=tr.selectRequirementFromGrids(testcase1);
	  bp.waitForElement();
	  String tcNo[]=new String[1];
	  for(int j=0;j<=3;j++)
	  { 
		tcNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", j+1, 0));
		Id[j]=tr.mappingRequirementID(tcNo);
		System.out.println(Id[j]);	
	  }
	  bp.waitForElement();
	  bp.explicitWait(req.clickOnSavejirareq);
	  req.clickOnSavejirareq.click();
	  bp.waitForElement();
	  bp.waitForElement();
	  tr.clickOnList();
	  bp.waitForElement();
	  } 
	  bp.waitForElement();
	  rp.clickOnTestPlanning();
	  actual[24]=tp.clickOnAddTestCycleSymbol();
	  bp.waitForElement();
	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 31, 0);
	  String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
	  String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
	  String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
	  actual[25]=tp.CreateCycle(cycle, Build, Environment, hide);
	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
	  String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
	  String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
	  actual[26]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	  actual[27]=tp.saveTestCycle(); 
	  bp.waitForElement(); 
	  String [] cycle1=new String [1];
	  cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 31, 0);
	  actual[28]=tp.navigateToCycle(cycle1);
	  actual[29]=tp.addPhaseToCycle(phase);
	  actual[30]=bp.waitForElement();
	  String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	  actual[31]=tp.bulkAssignment(Bulk_type);
	  tp.goBackToCycle();
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

@Given("^Execute the testcases to Pass/Fail/WIP/Block and linka defect of status Open type$")
public void execute_the_testcases_to_Pass_Fail_WIP_Block_and_linka_defect_of_status_Open_type() throws Throwable {
  try
    {
	 ep=new ExecutionPage(driver);
	 actual[32]=rp.clickOnTestExecution();
	 bp.waitForElement();
	 String [] cycle_node =new String[2];
	 cycle_node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 31, 0);
	 cycle_node[1]=phase;
     actual[33]=tr.navigateToNode(release, cycle_node);
	 actual[34]=bp.waitForElement();
	 for(int k=0;k<=3;k++)
	 {
	 String [] testCase=new String [1];
	 testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", k+1, 0));
	 actual[35]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
	 bp.waitForElement();
	 int No[]=new int[1];
	 No[0]=Integer.parseInt( testCase[0]);
	 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", k+1, 2);
	 actual[36]=ep.changeStatusOfTestCases(No, status);
	 bp.waitForElement();
	 int tcNo=Integer.parseInt(testCase[0]);
	 actual[37]=ep.clickOnDefectButton(tcNo);
	 bp.waitForElement();
	 String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 10);
	 ep.searchDefect(defectId);
	 bp.waitForElement();
	 ep.linkDefects.click();
	 bp.waitForElement();
	 JavascriptExecutor js=((JavascriptExecutor)driver);
	 js.executeScript("arguments[0].scrollIntoView(true);",ep.cancelDefect );
	 bp.waitForElement();
	 bp.waitForElement();
	 ep.cancelDefect.click();
	 actual[88]=bp.waitForElement();
	 bp.waitForElement();
	 bp.waitForElement();
     }}
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

@When("^Create Dashboard page, add Traceability Gadget for Release having jira requirements mapped to testcases executed to status PASS$")
public void create_Dashboard_page_add_Traceability_Gadget_for_Release_having_jira_requirements_mapped_to_testcases_executed_to_status_PASS() throws Throwable {
	try
	{
	 dp=new DashBoardPage(driver);
	 actual[39]=dp.clickOnManageDashboards();
	 bp.waitForElement();
	 actual[40]=dp.clickOnAddDashBoardSymbol();
	 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
	 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
	 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
	 actual[41]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
	 bp.waitForElement();
	 actual[42]=dp.validateDashBoard(dashBoardName);
	 actual[43]=dp.selectDashboard(dashBoardName);
	 bp.waitForElement();
	 actual[44]=dp.clickOnAddGadgetSymbol();
	 actual[45]=dp.addGadget(gadget);
	 bp.waitForElement();
	 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
	 actual[46]=dp.configureTraceabilityGadget(project, release, refreshRate);
	 bp.waitForElement();
	 actual[47]=dp.manageTraceability();
	 bp.waitForElement();
	 String searchName=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1, 8);
	 System.out.println(searchName+Id[0]);
	 actual[48]=dp.advanceSearch(searchName+Id[0]);
	 bp.waitForElement();
	 actual[49]=req.selectAllRequirements();
	 bp.waitForElement();
	 actual[50]=dp.closeTraceabilityTable();
	 actual[51]=dp.saveTraceabilityGadget();
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

@Then("^Should be able to view status as Pass with Open defect type$")
public void should_be_able_to_view_status_as_Pass_with_Open_defect_type() throws Throwable {
	try
	 {
	 actual[52]=dp.reqTraceabilityTable();
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

@When("^Add Traceability Gadget for Release having jira requirements mapped to testcases executed to status Fail$")
public void add_Traceability_Gadget_for_Release_having_jira_requirements_mapped_to_testcases_executed_to_status_Fail() throws Throwable {
	try
	 {
	 actual[53]=dp.clickOnAddGadgetSymbol();
	 actual[54]=dp.addGadget(gadget);
	 bp.waitForElement();
	 driver.navigate().refresh();
	 bp.waitForElement();
	 bp.waitForElement();
	 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
	 actual[55]=dp.configureTraceabilityGadget(project, release, refreshRate);
	 bp.waitForElement();
	 actual[56]=dp.manageTraceability();
	 bp.waitForElement();
	 String searchName=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1, 8);
	 System.out.println(searchName+Id[1]);
	 actual[57]=dp.advanceSearch(searchName+Id[1]);
	 bp.waitForElement();
	 actual[58]=req.selectAllRequirements();
	 actual[59]=dp.closeTraceabilityTable();
	 actual[60]=dp.saveTraceabilityGadget();
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

@Then("^Should be able to view status as Fail with Open defect type$")
public void should_be_able_to_view_status_as_Fail_with_Open_defect_type() throws Throwable {
	try
	 {
	 actual[61]=dp.reqTraceabilityTable();
	 actual[62]=bp.waitForElement();	 
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

@When("^Add Traceability Gadget for Release having jira requirements mapped to testcases executed to status WIP$")
public void add_Traceability_Gadget_for_Release_having_jira_requirements_mapped_to_testcases_executed_to_status_WIP() throws Throwable {
	try
	 {
	 actual[63]=dp.clickOnAddGadgetSymbol();
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
	 String searchName=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1, 8);
	 System.out.println(searchName+Id[2]);
	 actual[67]=dp.advanceSearch(searchName+Id[2]);
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

@Then("^Should be able to view status as WIP with Open defect type$")
public void should_be_able_to_view_status_as_WIP_with_Open_defect_type() throws Throwable {
	try
	 {
	 actual[71]=dp.reqTraceabilityTable();
	 actual[72]=bp.waitForElement();	 
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

@When("^Add Traceability Gadget for Release having jira requirements mapped to testcases executed to status Block$")
public void add_Traceability_Gadget_for_Release_having_jira_requirements_mapped_to_testcases_executed_to_status_Block() throws Throwable {
	try
	 {
	 actual[73]=dp.clickOnAddGadgetSymbol();
	 actual[74]=dp.addGadget(gadget);
	 bp.waitForElement();
	 driver.navigate().refresh();
	 bp.waitForElement();
	 bp.waitForElement();
	 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
	 actual[75]=dp.configureTraceabilityGadget(project, release, refreshRate);
	 bp.waitForElement();
	 actual[76]=dp.manageTraceability();
	 bp.waitForElement();
	 String searchName=Excel_Lib.getData(INPUT_PATH_5, "Requirements", 1, 8);
	 System.out.println(searchName+Id[3]);
	 actual[77]=dp.advanceSearch(searchName+Id[3]);
	 bp.waitForElement();
	 actual[78]=req.selectAllRequirements();
	 actual[79]=dp.closeTraceabilityTable();
	 actual[80]=dp.saveTraceabilityGadget();
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

@Then("^Should be able to view status as Block with Open defect type$")
public void should_be_able_to_view_status_as_Block_with_Open_defect_type() throws Throwable {
	try
	{
	actual[81]=dp.reqTraceabilityTable();
	bp.waitForElement();
	pp.backToProjectPage();
	for(int l=0;l<=actual.length-1;l++)
	{
	System.out.println("Actual["+l+"]="+ actual[l]);
	soft.assertEquals(actual[l], true);
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
