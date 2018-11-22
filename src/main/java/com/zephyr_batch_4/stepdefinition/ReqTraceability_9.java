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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_9 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exe;
	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "ReqTraceability_9";

	boolean[] actual = new boolean[61];
	SoftAssert soft = new SoftAssert();

	@When("^User add a Phase with Name and description$")
	public void user_add_a_Phase_with_Name_and_description() throws Throwable {

		try
		{
			pp=new ProjectPage(driver);
		req = new RequirementsPage(driver);
		tr = new TestRepositoryPage(driver);
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 1);
		String desc = Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 2);
		actual[0]=tr.clickOnRelease(releaseName);
		actual[1]=req.addNode(name, desc);
		
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

	@Then("^Phase Should be created successfully$")
	public void phase_Should_be_created_successfully() throws Throwable {
		try
		{
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
		String[] navigation = new String[1];
		navigation[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 1);

		actual[2] = tr.navigateToNode(releaseName, navigation);
		tr.clickDetailButton();
		
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

	@When("^user Add five requirements to the Phase$")
	public void user_Add_five_requirements_to_the_Phase() throws Throwable {
		try
		{
		for (int i = 1; i <= 5; i++) {
			String reqName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i + 15, 18);
			String reqDesc = Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 99, 199);
			String altID = Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 99, 99);
			String link = Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 99, 19);
			String priority = Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 99, 19);
			actual[3]=req.addRequirement();
			String[] reqNum = new String[1];
			reqNum[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14));
			actual[4]=req.selectMultipleRequirementFromGrids(reqNum);

			actual[5]=req.enterRequirementDetails(reqName, altID, link, priority, reqDesc);
			
			// req.enterRequirementNameAndDesc(reqName, reqDesc);
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

	@Then("^five requirements successfully added to the phase$")
	public void five_requirements_successfully_added_to_the_phase() throws Throwable {
		try {
			req.requirementCount();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user selects the first requirement$")
	public void user_selects_the_first_requirement() throws Throwable {
		try {
			String[] reqNum = new String[1];
			reqNum[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14));
			actual[6]=req.selectMultipleRequirementFromGrids(reqNum);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Map to testcase executed to status PASS and linked to defect with status ReOpened$")
	public void map_to_testcase_executed_to_status_PASS_and_linked_to_defect_with_status_ReOpened() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);

			// tr.clickDetailButton();
			actual[7]=req.MapTestCases();
			actual[8]=req.ExpandRelease(releaseName);

			actual[9]=tr.navigateNode(phase);

			String[] testcaseNo = new String[1];

			testcaseNo[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14));

			actual[10]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
			actual[11]=req.saveRequirement();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^First requirement successfully Mapped to the testcase$")
	public void first_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
		try
		{
			actual[12]=req.validateMapedTestcase();
		
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

	@When("^user selects the second requirement$")
	public void user_selects_the_second_requirement() throws Throwable {
		try {
			String[] reqNum = new String[1];
			reqNum[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14));
			actual[13]=req.selectMultipleRequirementFromGrids(reqNum);

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Map to testcase executed to status Fail and linked to defect with status ReOpened$")
	public void map_to_testcase_executed_to_status_Fail_and_linked_to_defect_with_status_ReOpened() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String[] phase = new String[1];
			phase[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);

			// tr.clickDetailButton();
			actual[14]=req.MapTestCases();
			actual[15]=req.ExpandRelease(releaseName);

			actual[16]=tr.navigateNode(phase);

			String[] testcaseNo = new String[1];

			testcaseNo[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 7, 14));

			actual[17]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
			actual[18]=req.saveRequirement();

		} catch (Exception e) {

			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^Second requirement successfully Mapped to the testcase$")
	public void second_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
		try
		{
			actual[19]=req.validateMapedTestcase();
		
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

	@When("^user selects the third requirement$")
	public void user_selects_the_third_requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",3 , 14));
			actual[20]=req.selectMultipleRequirementFromGrids(reqNum);
			
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

	@When("^map to testcase executed to status WIP and linked to defect with status ReOpened$")
	public void map_to_testcase_executed_to_status_WIP_and_linked_to_defect_with_status_ReOpened() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
	    //tr.clickDetailButton();
			actual[21]=req.MapTestCases();
			actual[22]=req.ExpandRelease(releaseName);
		
			actual[23]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 12, 14));
		
		actual[24]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[25]=req.saveRequirement();
		
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

	@Then("^Third requirement successfully mapped to the testcase$")
	public void third_requirement_successfully_mapped_to_the_testcase() throws Throwable {
		try
		   {
			actual[26]=req.validateMapedTestcase();
			
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

	@When("^user selects the fourth Requirement$")
	public void user_selects_the_fourth_Requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",4 , 14));
		  actual[27]=req.selectMultipleRequirementFromGrids(reqNum);
			
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

	@When("^map to testcase executed to status Blocked and linked to defect with status ReOpened$")
	public void map_to_testcase_executed_to_status_Blocked_and_linked_to_defect_with_status_ReOpened()
			throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
	    //tr.clickDetailButton();
		 actual[28]=req.MapTestCases();
		 actual[29]=req.ExpandRelease(releaseName);
		
		 actual[30]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 17, 14));
		
		actual[31]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[32]=req.saveRequirement();
		
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

	@Then("^Fourth requirement successfully mapped to the testcase$")
	public void fourth_requirement_successfully_mapped_to_the_testcase() throws Throwable {
		try
		{
			actual[33]=req.validateMapedTestcase();
		
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

	@When("^user selects the fifth Requirement$")
	public void user_selects_the_fifth_Requirement() throws Throwable {
		try
		{
		String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",5 , 14));
		  actual[34]=req.selectMultipleRequirementFromGrids(reqNum);
			
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

	@When("^map to testcase executed to status Custom Status and linked to defect with status ReOpened$")
	public void map_to_testcase_executed_to_status_Custom_Status_and_linked_to_defect_with_status_ReOpened()
			throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
		 
	    //tr.clickDetailButton();
		 actual[35]=req.MapTestCases();
		 actual[36]=req.ExpandRelease(releaseName);
		
		 actual[37]=tr.navigateNode(phase);
		
	   String[] testcaseNo=new String[1];
		
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 22, 14));
		
		actual[38]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
		actual[39]=req.saveRequirement();
		
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

	@Then("^Fifth requirement successfully mapped to the testcase$")
	public void fifth_requirement_successfully_mapped_to_the_testcase() throws Throwable {
		try
		{
			actual[40]=req.validateMapedTestcase();
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
	}

	@When("^User click on Dashboard link$")
	public void user_click_on_Dashboard_link() throws Throwable {
		
		try
		{
		db=new DashBoardPage(driver);
		actual[41]=db.clickOnManageDashboards();
		   
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

	@Then("^dashboard page should be Displayed$")
	public void dashboard_page_should_be_Displayed() throws Throwable {
		try
		{
			actual[42]=db.validateDashboards();
		
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

	@When("^user add a Dasboard with all details$")
	public void user_add_a_Dasboard_with_all_details() throws Throwable {
		
		try
		{
			actual[43]=db.clickOnAddDashBoardSymbol();
		   String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 3);
		   String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 4);
		   actual[44]=db.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		   
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

	@Then("^new dashboard should be Created successfully$")
	public void new_dashboard_should_be_Created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 1);
		actual[45]=db.validateDashBoard(dashBoardName);
			
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

	@When("^user Add Traceability Report Gadget$")
	public void user_Add_Traceability_Report_Gadget() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 1);
		 String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 5);
		 actual[46]=db.selectDashboard(dashBoardName);
		 actual[47]=db.clickOnAddGadgetSymbol();
		 actual[48]=db.addGadget(gadgetName);
		
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

	@Then("^Traceability Report gadget Added successfully$")
	public void traceability_Report_gadget_Added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 5);
		actual[49]=db.validateGadget(gadgetName);
			
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

	@When("^user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect ReOpened status$")
	public void user_selects_the_requirements_map_to_testcase_executed_to_Pass_Fail_WIP_Blocked_Custom_Status_and_linked_to_defect_ReOpened_status()
			throws Throwable {
		
		
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");

		 String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 25, 6);
		 actual[50]=db.configureTraceabilityGadget(projectName, releaseName, refreshRate);
		
		for(int i=1;i<=5;i++)
		{
			actual[51]=db.manageTraceability();
		String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i+15, 18);
		actual[52]=db.traceabilityQuickSearch(searchOption);
		//db.
		actual[53]=db.selectAllRequirements();
		actual[54]=db.closeTraceabilityTable();
		
		}
		
		actual[55]=db.saveGadget();
		
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

	@Then("^Should be able to view Pass/Fail/WIP/Blocked/Custom status status with ReOpened defect$")
	public void should_be_able_to_view_Pass_Fail_WIP_Blocked_Custom_status_status_with_ReOpened_defect()
			throws Throwable {
		try
		{
		int reqNo1=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14);
		String executionStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 15);
		String defectStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 17);
		actual[56]=db.validateExecutionsInGadget(reqNo1, executionStatus1, defectStatus1);
		
		
		
		int reqNo2=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14);
		String executionStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 7, 15);
		String defectStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 17);
		actual[57]=db.validateExecutionsInGadget(reqNo2, executionStatus2, defectStatus2);
		
		int reqNo3=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14);
		String executionStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 12, 15);
		String defectStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 17);
		actual[58]=db.validateExecutionsInGadget(reqNo3, executionStatus3, defectStatus3);
		
		int reqNo4=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14);
		String executionStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 17, 15);
		String defectStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 17);
		actual[59]=db.validateExecutionsInGadget(reqNo4, executionStatus4, defectStatus4);
		
		int reqNo5=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14);
		String executionStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 22, 15);
		String defectStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 17);
		actual[60]=db.validateExecutionsInGadget(reqNo5, executionStatus5, defectStatus5);
		
		
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
