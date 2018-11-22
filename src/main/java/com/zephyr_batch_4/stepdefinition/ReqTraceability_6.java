package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_6 extends LaunchBrowser
{

	ProjectPage pp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exe;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="ReqTraceability_6";
	
	boolean[] actual=new boolean[64];
	 SoftAssert soft=new SoftAssert();
	
	
	@Given("^User navigate to Requirement page$")
	public void user_navigate_to_Requirement_page() throws Throwable {
		 try
		    {
			pp=new ProjectPage(driver);
		    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		    actual[0]= pp.selectProject(projectName);
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		    actual[1]=pp.selectRelease(releaseName);
		    
		    rp=new ReleasePage(driver);
		    actual[2]=rp.clickOnRequirements();
		    }
		    catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
		    
		    
	}

	@When("^User add a phase with name and description$")
	public void user_add_a_phase_with_name_and_description() throws Throwable {
	  try
	  {
		req=new RequirementsPage(driver);
	   tr=new TestRepositoryPage(driver);
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 2);
		  actual[3]=tr.clickOnRelease(releaseName);
		  actual[4]=req.addNode(name, desc);
		  
	  }
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	    
	}

	@Then("^phase Should be created successfully$")
	public void phase_Should_be_created_successfully() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] navigation=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 1);
			
			actual[5]=tr.navigateToNode(releaseName, navigation);
			
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	    
	
	}

	@When("^user add five requirements to the phase$")
	public void user_add_five_requirements_to_the_phase() throws Throwable {
	   try
	   {
		   req.addRequirement();
		   tr.clickDetailButton();
		for(int i=1;i<=5;i++)
	   {
		   String reqName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",i , 18);
		   String reqDesc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 199);
		   String altID=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 99);
		   String link=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99, 19);
		   String priority=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 19);
		  
		  String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",i , 14));
		  actual[6]=req.selectMultipleRequirementFromGrids(reqNum);
			
		  actual[7]=req.enterRequirementDetails(reqName, altID, link, priority, reqDesc);
			//req.enterRequirementNameAndDesc(reqName, reqDesc);
		  actual[8]=req.addRequirement();
	   }
		
	   }
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	    
	   
	   
	 
	}

	@Then("^requirements successfully added to the phase$")
	public void requirements_successfully_added_to_the_phase() throws Throwable {
	  
		try
		{
		  req.requirementCount();
		  
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	    
		//req.selectAllRequirementsFormGrid();
	}

	@When("^user select the first requirement$")
	public void user_select_the_first_requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",1 , 14));
		  actual[9]=req.selectMultipleRequirementFromGrids(reqNum);
			
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	    
			
	}

	@When("^map to testcase executed to status PASS and linked to defect with status Open$")
	public void map_to_testcase_executed_to_status_PASS_and_linked_to_defect_with_status_Open() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
	    //tr.clickDetailButton();
		 actual[10]=req.MapTestCases();
		 actual[11]=req.ExpandRelease(releaseName);
		
		 actual[12]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14));
		
		 actual[13]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		 actual[14]=req.saveRequirement();
		
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	    
		
	}

	@Then("^first requirement successfully mapped to the testcase$")
	public void first_requirement_successfully_mapped_to_the_testcase() throws Throwable {
		
		try
		{
			actual[15]=req.validateMapedTestcase();
		
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		
//		tr.clickOnList();
		
	}

	@When("^user select the second requirement$")
	public void user_select_the_second_requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",2 , 14));
		  actual[16]=req.selectMultipleRequirementFromGrids(reqNum);
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
			
			
	}

	@When("^map to testcase executed to status Fail and linked to defect with status Open$")
	public void map_to_testcase_executed_to_status_Fail_and_linked_to_defect_with_status_Open() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
		// tr.clickDetailButton();
		 actual[17]=req.MapTestCases();
		 actual[18]=req.ExpandRelease(releaseName);
		
		 actual[19]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 6, 14));
		actual[20]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[21]=req.saveRequirement();
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@Then("^second requirement successfully mapped to the testcase$")
	public void second_requirement_successfully_mapped_to_the_testcase() throws Throwable {
		
		try
		{
			actual[22]=req.validateMapedTestcase();
		
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		//tr.clickOnList();	
	}

	@When("^user select the third requirement$")
	public void user_select_the_third_requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",3 , 14));
		  actual[23]=req.selectMultipleRequirementFromGrids(reqNum);
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  	
			
			
	}

	@When("^map to testcase executed to status WIP and linked to defect with status Open$")
	public void map_to_testcase_executed_to_status_WIP_and_linked_to_defect_with_status_Open() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
		// tr.clickDetailButton();
		 actual[24]=req.MapTestCases();
		 actual[25]=req.ExpandRelease(releaseName);
		
		 actual[26]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 11, 14));
		
		actual[27]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[28]=req.saveRequirement();
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@Then("^third requirement successfully mapped to the testcase$")
	public void third_requirement_successfully_mapped_to_the_testcase() throws Throwable {
	 try
	 {
		
		 actual[29]=req.validateMapedTestcase();
		
	 }
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		//  tr.clickOnList();
	}

	@When("^user select the fourth requirement$")
	public void user_select_the_fourth_requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",4 , 14));
		  actual[30]=req.selectMultipleRequirementFromGrids(reqNum);
			
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
			
	}

	@When("^map to testcase executed to status Blocked and linked to defect with status Open$")
	public void map_to_testcase_executed_to_status_Blocked_and_linked_to_defect_with_status_Open() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
		 //tr.clickDetailButton();
		 actual[31]=req.MapTestCases();
		 actual[32]=req.ExpandRelease(releaseName);
		
		 actual[33]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 16, 14));
		
		actual[34]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[35]=req.saveRequirement();
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@Then("^fourth requirement successfully mapped to the testcase$")
	public void fourth_requirement_successfully_mapped_to_the_testcase() throws Throwable {
	   try
	   {
		   
		   actual[36]=req.validateMapedTestcase();
	   }
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@When("^user select the fifth requirement$")
	public void user_select_the_fifth_requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",5 , 14));
		  actual[37]=req.selectMultipleRequirementFromGrids(reqNum);
			
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
			
	}

	@When("^map to testcase executed to status Custom Status and linked to defect with status Open$")
	public void map_to_testcase_executed_to_status_Custom_Status_and_linked_to_defect_with_status_Open() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
		// tr.clickDetailButton();
		 actual[38]=req.MapTestCases();
		 actual[39]=req.ExpandRelease(releaseName);
		
		 actual[40]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 21, 14));
		
		actual[41]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[42]=req.saveRequirement();
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		
	}

	@Then("^fifth requirement successfully mapped to the testcase$")
	public void fifth_requirement_successfully_mapped_to_the_testcase() throws Throwable {
	 
		try
		{
			actual[43]=req.validateMapedTestcase();
			 tr.clickOnList();
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		//
	}

	@When("^navigate to Dashboard page$")
	public void navigate_to_Dashboard_page() throws Throwable {
		try
		{
		db=new DashBoardPage(driver);
		actual[44]=db.clickOnManageDashboards();
	   
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	   
	}

	@Then("^Dashboard page should be displayed$")
	public void dashboard_page_should_be_displayed() throws Throwable {
	  try
	  {
		  actual[45]=db.validateDashboards();
		
	  }
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@When("^user add a new dasboard with all details$")
	public void user_add_a_new_dasboard_with_all_details() throws Throwable {
		try
		{
			actual[46]=db.clickOnAddDashBoardSymbol();
		   String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 3);
		   String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 4);
		   actual[47]=db.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		   
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@Then("^new dashboard should be created successfully$")
	public void new_dashboard_should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 1);
		actual[48]=db.validateDashBoard(dashBoardName);
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
	}

	@When("^user add Add Traceability Report Gadget$")
	public void user_add_Add_Traceability_Report_Gadget() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 1);
		 String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 5);
		 actual[49]=db.selectDashboard(dashBoardName);
		 actual[50]=db.clickOnAddGadgetSymbol();
		 actual[51]=db.addGadget(gadgetName);
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		
	}

	@Then("^traceability report gadget added successfully$")
	public void traceability_report_gadget_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 5);
		actual[52]=db.validateGadget(gadgetName);
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		
	}

	@When("^user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect with status open defect$")
	public void user_selects_the_requirements_map_to_testcase_executed_to_Pass_Fail_WIP_Blocked_Custom_Status_and_linked_to_defect_with_status_open_defect() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");

		 String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 6);
		 actual[53]=db.configureTraceabilityGadget(projectName, releaseName, refreshRate);
		
		for(int i=1;i<=5;i++)
		{
			actual[54]=db.manageTraceability();
		String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 18);
		actual[55]=db.traceabilityQuickSearch(searchOption);
		//db.
		actual[56]=db.selectAllRequirements();
		actual[57]=db.closeTraceabilityTable();
		
		}
		
		actual[58]=db.saveGadget();
		
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		
		
	}

	@Then("^Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Open defect$")
	public void should_be_able_to_view_Pass_Fail_WIP_Blocked_Custom_status_status_with_Open_defect() throws Throwable {
		
		try
		{
		int reqNo1=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14);
		String executionStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 15);
		String defectStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 16);
		actual[59]=db.validateExecutionsInGadget(reqNo1, executionStatus1, defectStatus1);
		
		
		
		int reqNo2=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14);
		String executionStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 15);
		String defectStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 16);
		actual[60]=db.validateExecutionsInGadget(reqNo2, executionStatus2, defectStatus2);
		
		int reqNo3=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14);
		String executionStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 11, 15);
		String defectStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 11, 16);
		actual[61]=db.validateExecutionsInGadget(reqNo3, executionStatus3, defectStatus3);
		
		int reqNo4=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14);
		String executionStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 16, 15);
		String defectStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 16, 16);
		actual[62]=db.validateExecutionsInGadget(reqNo4, executionStatus4, defectStatus4);
		
		int reqNo5=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14);
		String executionStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 15);
		String defectStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 16);
		actual[63]=db.validateExecutionsInGadget(reqNo5, executionStatus5, defectStatus5);
		
		pp.backToProjectPage();

		  for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();	
		
		
		}
	    catch(Exception e)
		{
	  
	     lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
		}  
		}
		
		
	
}
