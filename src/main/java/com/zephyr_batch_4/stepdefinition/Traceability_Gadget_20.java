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
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Traceability_Gadget_20 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="Traceability_Gadget_20";

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
	ExternalJiraPage ej;

	boolean actual[]=new boolean[66];
	SoftAssert soft=new SoftAssert();

	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String req_phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 7, 1);
	private String req_name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 7, 2);
	private String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 59, 0); 
	private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 59, 0);
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 14, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 4);	
	private String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 11, 10);
	private String testCaseNo=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Requirements", 1, 0));
	private int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Requirements", 0,0 );
	
	private String [] cycle_node =new String[2];
	{
	cycle_node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 33, 0);
	cycle_node[1]=phase;
	}
	
	
	@Given("^Lead is in RequirementPage and adds new requirement$")
	public void lead_is_in_RequirementPage_and_adds_new_requirement() throws Throwable {
	 try
	   {
		  pp=new ProjectPage(driver);
		  rp=new ReleasePage(driver);
	      bp=new BasePage();
		  ctc=new CreateTestCasePage(driver);
		  ex=new ExportPage(driver);
		  req=new RequirementsPage(driver);
		  tr=new TestRepositoryPage(driver);
		  pp.selectProject(project2);
		  actual[0]=pp.selectProject(project);
		  actual[1]=pp.selectRelease(release);
		  bp.waitForElement();
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

	@Given("^Launch Test Repository page, add testcase and map to requirement$")
	public void launch_Test_Repository_page_add_testcase_and_map_to_requirement() throws Throwable {
		try
		  {
			tp=new TestPlanningPage(driver);
			actual[8]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[9]=tr.clickOnRelease(release);
			bp.waitForElement();
			actual[10]=tr.addNode(phase, Desc);
			bp.waitForElement();
			String node1[]=new String [1];
			node1[0]=phase;
			actual[11]=tr.navigateToNode(release, node1);
			String testcaseNo[]=new String[1];
			actual[12]=tr.addTestCase();
			actual[13]=tr.clickOnDetails();
			bp.waitForElement();
			testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 1, 0));
			actual[14]=ex.selectMultipleTestCaseFromGrid(testcaseNo); 
			 bp.waitForElement();
			actual[15]=req.MapRequirements();
			bp.waitForElement();
			actual[16]=req.ExpandRelease(release);
			String [] req_Node=new String[1];
			req_Node[0]=req_phase;
		    actual[17]=tr.navigateNode(req_Node);
		    bp.waitForElement();
			String testcase1[]=new String[1];
			testcase1[0]=testCaseNo;
			actual[18]=tr.selectRequirementFromGrids(testcase1);
			bp.waitForElement();
			String tcNo[]=new String[1];
			tcNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 1, 0));
			actual[19]=bp.waitForElement();
		    bp.explicitWait(req.clickOnSavejirareq);
		    req.clickOnSavejirareq.click();
		    bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			actual[20]=rp.clickOnTestPlanning();
			actual[21]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 33, 0);
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
			String [] cycle1=new String [1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 33, 0);
			actual[25]=tp.navigateToCycle(cycle1);
			actual[26]=tp.addPhaseToCycle(phase);
			actual[27]=bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			actual[28]=tp.bulkAssignment(Bulk_type);
			actual[29]=tp.goBackToCycle();
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

	@Given("^Execute the testcase, link a defect of type Open and add Traceability Gadget$")
	public void execute_the_testcase_link_a_defect_of_type_Open_and_add_Traceability_Gadget() throws Throwable {
		try
		  {
			ep=new ExecutionPage(driver);
			dp=new DashBoardPage(driver);
			actual[30]=rp.clickOnTestExecution();
		    actual[31]=tr.navigateToNode(release, cycle_node);
			actual[32]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[33]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int No[]=new int[1];
			No[0]=Integer.parseInt( testCase[0]);
			String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[34]=ep.changeStatusOfTestCases(No, status);
			int tcNo=Integer.parseInt(testCase[0]);
			actual[35]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			actual[36]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[37]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[38]=dp.clickOnAddDashBoardSymbol();
			String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			actual[39]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			bp.waitForElement();
			actual[40]=dp.validateDashBoard(dashBoardName);
			actual[41]=dp.selectDashboard(dashBoardName);
			bp.waitForElement();
			actual[42]=dp.clickOnAddGadgetSymbol();
			actual[43]=dp.addGadget(gadget);
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			actual[44]=dp.configureTraceabilityGadget(project, release, refreshRate);
			bp.waitForElement();
			actual[45]=dp.manageTraceability();
			bp.waitForElement();
			actual[46]=dp.traceabilityQuickSearch(req_name);
			bp.waitForElement();
			actual[47]=req.selectAllRequirements();
			bp.waitForElement();
			actual[48]=dp.closeTraceabilityTable();
			actual[49]=dp.saveTraceabilityGadget();
			bp.waitForElement();
			actual[50]=dp.reqTraceabilityTable();
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

	@When("^Change status of defect\\(Open to Inprogress\\) linked to executed testcase$")
	public void change_status_of_defect_Open_to_Inprogress_linked_to_executed_testcase() throws Throwable {
		try
		{
			ej=new ExternalJiraPage(driver);
			actual[51]=pp.selectProject(project);
			actual[52]=pp.selectRelease(release);
			bp.waitForElement();
			actual[53]=pp.clickOnDefectTracking();
			bp.waitForElement();
			actual[54]=dp.searchAndSelectDefect(defectId);
			bp.waitForElement();
			int tabNo1=Integer.parseInt(testCaseNo);
			bp.switchWindowTab(tabNo1);
			bp.waitForElement();
			bp.waitForElement();
			String username=Excel_Lib.getData(INPUT_PATH_5, "LogIn",0 ,0 );
			String password=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,0 );
			actual[55]=ej.loginToExternalJira(username, password);
			bp.waitForElement();
			bp.waitForElement();
			String statusType=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 11);
			actual[56]=ej.changeDefectStatusInExternalJira(statusType);
			bp.waitForElement();
			bp.switchWindowTab(tabNo0);
			bp.waitForElement();
			actual[57]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[58]=dp.searchDashboard(dashBoardName);
			actual[59]=dp.selectDashboard(dashBoardName);
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

	@Then("^Should be able to update the gadget with updated details$")
	public void should_be_able_to_update_the_gadget_with_updated_details() throws Throwable {
		try
		{
			actual[60]=dp.reqTraceabilityTable();
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

	@When("^Change status of defect\\(Inprogress to Closed\\) linked to executed testcase$")
	public void change_status_of_defect_Inprogress_to_Closed_linked_to_executed_testcase() throws Throwable {
		try
		{
			int tabNo1=Integer.parseInt(testCaseNo);
			bp.switchWindowTab(tabNo1);
			String statusType=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 11);
			actual[61]=ej.changeDefectStatusInExternalJira(statusType);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.switchWindowTab(tabNo0);
			bp.waitForElement();
			driver.navigate().refresh();
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

	@Then("^Should be able to update the Gadget with updated status$")
	public void should_be_able_to_update_the_Gadget_with_updated_status() throws Throwable {
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

	@When("^Change status of defect\\(Closed to Reopened\\) linked to executed testcase$")
	public void change_status_of_defect_Closed_to_Reopened_linked_to_executed_testcase() throws Throwable {
		try
		{
            ej=new ExternalJiraPage(driver);
			int tabNo1=Integer.parseInt(testCaseNo);
			bp.switchWindowTab(tabNo1);
			String statusType=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 11);
			actual[63]=ej.changeDefectStatusInExternalJira(statusType);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			ej.logOutFromExternal_JIRA();
			bp.waitForElement();
			bp.switchWindowTab(tabNo0);
			bp.waitForElement();
			driver.navigate().refresh();
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

	@Then("^should be able to Update the Gadget with updated status$")
	public void should_be_able_to_Update_the_Gadget_with_updated_status() throws Throwable {
		try
		{
			actual[64]=dp.reqTraceabilityTable();
			bp.waitForElement();
			actual[65]=pp.backToProjectPage();
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
