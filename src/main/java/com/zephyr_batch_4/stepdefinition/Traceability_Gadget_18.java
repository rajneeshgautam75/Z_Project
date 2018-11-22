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

public class Traceability_Gadget_18 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	private String fileName="Traceability_Gadget_18";

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

	boolean actual[]=new boolean[121];
	SoftAssert soft=new SoftAssert();

	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String req_phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 8, 0);
	private String req_name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Requirements", 8, 1);
	private String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 61, 0); 
	private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 61, 0);
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 15, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 4);
	private String testCaseNo=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Requirements", 1, 0));	
	
	
	private String [] cycle_node =new String[2];
	{
	cycle_node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 34, 0);
	cycle_node[1]=phase;
	}
	
	
	@Given("^Lead is in Requirement page and adds requirement$")
	public void lead_is_in_Requirement_page_and_adds_requirement() throws Throwable {
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

	@Given("^Launch Test Repository, add a testcase and map the requirement$")
	public void launch_Test_Repository_add_a_testcase_and_map_the_requirement() throws Throwable {
		 try
		  {
			tp=new TestPlanningPage(driver);
			actual[8]=rp.clickOnTestRep();
			actual[9]=tr.clickOnRelease(release);
			bp.waitForElement();
			actual[10]=tr.addNode(phase, Desc); 
			String node1[]=new String [1];
			node1[0]=phase;
			bp.waitForElement();
			actual[11]=tr.navigateToNode(release, node1);
			String testcaseNo[]=new String[1];
			actual[12]=tr.addTestCase();
			bp.waitForElement();
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
		    actual[18]=tr.navigateNode(req_Node);
		    bp.waitForElement();
			String testcase1[]=new String[1];
			testcase1[0]=testCaseNo;
			actual[19]=tr.selectRequirementFromGrids(testcase1);
			bp.waitForElement();
			String tcNo[]=new String[1];
			tcNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 1, 0));
			bp.waitForElement();
		    bp.explicitWait(req.clickOnSavejirareq);
		    req.clickOnSavejirareq.click();
		    bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement(); 
			actual[20]=rp.clickOnTestPlanning();
			actual[21]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 34, 0);
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
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 34, 0);
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

	@Given("^Execute the testcase and add new Traceability Gadget$")
	public void execute_the_testcase_and_add_new_Traceability_Gadget() throws Throwable {
		 try
		  {
			ep=new ExecutionPage(driver);
			dp=new DashBoardPage(driver);
			actual[30]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
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
			bp.waitForElement();
			actual[35]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[36]=dp.clickOnAddDashBoardSymbol();
			String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			actual[37]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			bp.waitForElement();
			actual[38]=dp.validateDashBoard(dashBoardName);
			actual[39]=dp.selectDashboard(dashBoardName);
			bp.waitForElement();
			actual[40]=dp.clickOnAddGadgetSymbol();
			actual[41]=dp.addGadget(gadget);
			bp.waitForElement();
			String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			actual[42]=dp.configureTraceabilityGadget(project, release, refreshRate);
			bp.waitForElement();
			actual[43]=dp.manageTraceability();
			bp.waitForElement();
			actual[44]=dp.traceabilityQuickSearch(req_name);
			bp.waitForElement();
			actual[45]=req.selectAllRequirements();
			bp.waitForElement();
			actual[46]=dp.closeTraceabilityTable();
			actual[47]=dp.saveTraceabilityGadget();
			bp.waitForElement();
			actual[48]=dp.reqTraceabilityTable();
			bp.waitForElement();
			pp.backToProjectPage();
			bp.waitForElement();
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

	@When("^Link a defect\\(Bug\\) to testcase execution that is mapped to requirement in saved Traceability Gadget$")
	public void link_a_defect_Bug_to_testcase_execution_that_is_mapped_to_requirement_in_saved_Traceability_Gadget() throws Throwable {
		try
		  {
			actual[49]=pp.selectProject(project);
			actual[50]=pp.selectRelease(release);
			actual[51]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			actual[52]=tr.navigateToNode(release, cycle_node);
			actual[53]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[54]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int tcNo=Integer.parseInt(testCase[0]);
			actual[55]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 10);
			actual[55]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[56]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[57]=dp.searchDashboard(dashBoardName);
			actual[58]=dp.selectDashboard(dashBoardName);
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

	@Then("^Newly created defect\\(Bug\\) should be reflected in requirement traceability$")
	public void newly_created_defect_Bug_should_be_reflected_in_requirement_traceability() throws Throwable {
		try
		  {
			actual[59]=dp.reqTraceabilityTable();
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

	@When("^Link a defect\\(Improvement\\) to testcase execution that is mapped to requirement in saved Traceability Gadget$")
	public void link_a_defect_Improvement_to_testcase_execution_that_is_mapped_to_requirement_in_saved_Traceability_Gadget() throws Throwable {
		 try
		  {
			actual[60]=pp.selectProject(project);
			actual[61]=pp.selectRelease(release);
			actual[62]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[63]=tr.navigateToNode(release, cycle_node);
			actual[64]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[65]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int tcNo=Integer.parseInt(testCase[0]);
			actual[66]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 5, 10);
			actual[67]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[68]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[69]=dp.searchDashboard(dashBoardName);
			actual[70]=dp.selectDashboard(dashBoardName);
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

	@Then("^Newly created defect\\(Improvement\\) should be reflected in requirement traceability$")
	public void newly_created_defect_Improvement_should_be_reflected_in_requirement_traceability() throws Throwable {
		try
		  {
			actual[71]=dp.reqTraceabilityTable();
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

	@When("^Link a defect\\(New Feature\\) to testcase execution that is mapped to requirement in saved Traceability Gadget$")
	public void link_a_defect_New_Feature_to_testcase_execution_that_is_mapped_to_requirement_in_saved_Traceability_Gadget() throws Throwable {
		try
		  {
			actual[72]=pp.selectProject(project);
			actual[73]=pp.selectRelease(release);
			actual[74]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[75]=tr.navigateToNode(release, cycle_node);
			actual[76]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[77]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int tcNo=Integer.parseInt(testCase[0]);
			actual[78]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 6, 10);
			actual[79]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[80]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[81]=dp.searchDashboard(dashBoardName);
			bp.waitForElement();
			actual[82]=dp.selectDashboard(dashBoardName);
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

	@Then("^Newly created defect\\(New Feature\\) should be reflected in requirement traceability$")
	public void newly_created_defect_New_Feature_should_be_reflected_in_requirement_traceability() throws Throwable {
		try
		  {
			actual[83]=dp.reqTraceabilityTable();
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

	@When("^Link a defect\\(Task\\) to testcase execution that is mapped to requirement in saved Traceability Gadget$")
	public void link_a_defect_Task_to_testcase_execution_that_is_mapped_to_requirement_in_saved_Traceability_Gadget() throws Throwable {
		 try
		  {
			actual[84]=pp.selectProject(project);
			actual[85]=pp.selectRelease(release);
			actual[86]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[87]=tr.navigateToNode(release, cycle_node);
			actual[88]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[89]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int tcNo=Integer.parseInt(testCase[0]);
			actual[90]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 7, 10);
			actual[91]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[92]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[93]=dp.searchDashboard(dashBoardName);
			actual[94]=dp.selectDashboard(dashBoardName);
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

	@Then("^Newly created defect\\(Task\\) should be reflected in requirement traceability$")
	public void newly_created_defect_Task_should_be_reflected_in_requirement_traceability() throws Throwable {
		 try
		  {
			 actual[95]=dp.reqTraceabilityTable();
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

	@When("^Link a defect\\(Story\\) to testcase execution that is mapped to requirement in saved Traceability Gadget$")
	public void link_a_defect_Story_to_testcase_execution_that_is_mapped_to_requirement_in_saved_Traceability_Gadget() throws Throwable {
		 try
		  {
			actual[96]=pp.selectProject(project);
			actual[97]=pp.selectRelease(release);
			actual[98]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[99]=tr.navigateToNode(release, cycle_node);
			actual[100]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[101]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int tcNo=Integer.parseInt(testCase[0]);
			actual[102]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 8, 10);
			actual[103]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[104]=dp.clickOnManageDashboards();
			bp.waitForElement();
			actual[105]=dp.searchDashboard(dashBoardName);
			actual[106]=dp.selectDashboard(dashBoardName);
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

	@Then("^Newly created defect\\(Story\\) should be reflected in requirement traceability$")
	public void newly_created_defect_Story_should_be_reflected_in_requirement_traceability() throws Throwable {
		 try
		  {
			 actual[107]=dp.reqTraceabilityTable();
			 bp.waitForElement();
			 pp.backToProjectPage();
			 pp.selectProject(project2);
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

	@When("^Link a defect\\(Epic\\) to testcase execution that is mapped to requirement in saved Traceability Gadget$")
	public void link_a_defect_Epic_to_testcase_execution_that_is_mapped_to_requirement_in_saved_Traceability_Gadget() throws Throwable {
		 try
		  {
			actual[108]=pp.selectProject(project);
			actual[109]=pp.selectRelease(release);
			actual[110]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[111]=tr.navigateToNode(release, cycle_node);
			actual[112]=bp.waitForElement();
			String [] testCase=new String [1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[113]=ep.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			int tcNo=Integer.parseInt(testCase[0]);
			actual[114]=ep.clickOnDefectButton(tcNo);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 9, 10);
			actual[115]=ep.searchDefect(defectId);
			ep.linkDefects.click();
			bp.waitForElement();
			ep.cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[116]=dp.clickOnManageDashboards();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[117]=dp.searchDashboard(dashBoardName);
			bp.waitForElement();
			actual[118]=dp.selectDashboard(dashBoardName);
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

	@Then("^Newly created defect\\(Epic\\) should be reflected in requirement traceability$")
	public void newly_created_defect_Epic_should_be_reflected_in_requirement_traceability() throws Throwable {
		 try
		  {
			actual[119]=dp.reqTraceabilityTable();
			bp.waitForElement();
			actual[120]=pp.backToProjectPage();
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
