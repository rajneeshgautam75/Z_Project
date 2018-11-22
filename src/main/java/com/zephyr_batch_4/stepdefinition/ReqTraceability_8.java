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

public class ReqTraceability_8 extends LaunchBrowser 
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
	String fileName="ReqTraceability_8";
	
	boolean[] actual=new boolean[65];
	 SoftAssert soft=new SoftAssert();
	

@Given("^User navigate to Requirement Page$")
public void user_navigate_to_Requirement_Page() throws Throwable {
	try
    {
	pp=new ProjectPage(driver);
	bp=new BasePage();
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

@When("^User Add a phase with name and description$")
public void user_Add_a_phase_with_name_and_description() throws Throwable {
	try
	{
	req=new RequirementsPage(driver);
	   tr=new TestRepositoryPage(driver);
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 2);
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

@Then("^phase Should be Created successfully$")
public void phase_Should_be_Created_successfully() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] navigation=new String[1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 4, 1);
		
		actual[5]=tr.navigateToNode(releaseName, navigation);
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

@When("^user add Five requirements to the phase$")
public void user_add_Five_requirements_to_the_phase() throws Throwable {
	try
	{
	for(int i=1;i<=5;i++)
	   {
		   String reqName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",i+10 , 18);
		   String reqDesc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 199);
		   String altID=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 99);
		   String link=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99, 19);
		   String priority=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 19);
		   actual[6]=req.addRequirement();
		  String[] reqNum=new String[1];
		  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",i , 14));
		  actual[7]=req.selectMultipleRequirementFromGrids(reqNum);
			
		  actual[8]=req.enterRequirementDetails(reqName, altID, link, priority, reqDesc);
			//req.enterRequirementNameAndDesc(reqName, reqDesc);
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

@Then("^requirements Successfully added to the phase$")
public void requirements_Successfully_added_to_the_phase() throws Throwable {
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
}

@When("^user select the First requirement$")
public void user_select_the_First_requirement() throws Throwable {
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

@When("^map to testcase executed to status PASS and linked to defect with Closed$")
public void map_to_testcase_executed_to_status_PASS_and_linked_to_defect_with_Closed() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14));
	
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

@Then("^First requirement successfully mapped to the testcase$")
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
}



@When("^user selects the Second requirement$")
public void user_selects_the_Second_requirement() throws Throwable {
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

@When("^map to testcase executed to status Fail and linked to defect with Closed$")
public void map_to_testcase_executed_to_status_Fail_and_linked_to_defect_with_Closed() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
    //tr.clickDetailButton();
	 actual[17]=req.MapTestCases();
	 actual[18]=req.ExpandRelease(releaseName);
	
	 actual[19]=tr.navigateNode(phase);
	
   String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 10, 14));
	
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

@Then("^second requirement successfully Mapped to the testcase$")
public void second_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
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
}




@Then("^user Select the third requirement$")
public void user_Select_the_third_requirement() throws Throwable {
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



@When("^map to testcase executed to status WIP and linked to defect with Closed$")
public void map_to_testcase_executed_to_status_WIP_and_linked_to_defect_with_Closed() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
    //tr.clickDetailButton();
	 actual[24]=req.MapTestCases();
	 actual[25]=req.ExpandRelease(releaseName);
	
	 actual[26]=tr.navigateNode(phase);
	
   String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 15, 14));
	
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



@Then("^third requirement success_fully mapped to the testcase$")
public void third_requirement_success_fully_mapped_to_the_testcase() throws Throwable {
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
}




@When("^user Select the fourth requirement$")
public void user_Select_the_fourth_requirement() throws Throwable {
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



@When("^map to testcase executed to status Blocked and linked to defect with Closed$")
public void map_to_testcase_executed_to_status_Blocked_and_linked_to_defect_with_Closed() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 20, 14));
	
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



@Then("^fourth requirement success_fully mapped to the testcase$")
public void fourth_requirement_success_fully_mapped_to_the_testcase() throws Throwable {
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




@When("^user Select the fifth requirement$")
public void user_Select_the_fifth_requirement() throws Throwable {
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



@When("^map to testcase executed to status Custom Status and linked to defect with Closed$")
public void map_to_testcase_executed_to_status_Custom_Status_and_linked_to_defect_with_Closed() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
    //tr.clickDetailButton();
	 actual[38]=req.MapTestCases();
	 actual[39]=req.ExpandRelease(releaseName);
	
	 actual[40]=tr.navigateNode(phase);
	
   String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 25, 14));
	
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

@Then("^fifth requirement success_fully mapped to the testcase$")
public void fifth_requirement_success_fully_mapped_to_the_testcase() throws Throwable {
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
}







@When("^navigate to Dashboard Page$")
public void navigate_to_Dashboard_Page() throws Throwable {
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

@Then("^Dash_board page should be Displayed$")
public void dash_board_page_should_be_Displayed() throws Throwable {
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

@When("^user add a new dasboard with all Details$")
public void user_add_a_new_dasboard_with_all_Details() throws Throwable {
	try
	{
		actual[46]=db.clickOnAddDashBoardSymbol();
	   String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 1);
	   String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 4);
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

@Then("^new dash_board should be created successfully$")
public void new_dash_board_should_be_created_successfully() throws Throwable {
	try
	{
	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 1);
	actual[48]=db.validateDashBoard(dashBoardName);
	actual[49]=bp.waitForElement();
		
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

@When("^user add Traceability Report Gadget$")
public void user_add_Traceability_Report_Gadget() throws Throwable {
	try
	{
	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 1);
	 String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 5);
	 actual[50]=db.selectDashboard(dashBoardName);
	 actual[51]=db.clickOnAddGadgetSymbol();
	 actual[52]=db.addGadget(gadgetName);
	
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

@Then("^traceability report Gadget added successfully$")
public void traceability_report_Gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 5);
	actual[53]=db.validateGadget(gadgetName);
		
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








@When("^user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect with status closed defect$")
public void user_selects_the_requirements_map_to_testcase_executed_to_Pass_Fail_WIP_Blocked_Custom_Status_and_linked_to_defect_with_status_closed_defect() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	   
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");

	 String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 24, 6);
	 actual[54]=db.configureTraceabilityGadget(projectName, releaseName, refreshRate);
	
	for(int i=1;i<=5;i++)
	{
		actual[55]=db.manageTraceability();
	String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i+10, 18);
	actual[56]=db.traceabilityQuickSearch(searchOption);
	//db.
	actual[57]=db.selectAllRequirements();
	actual[58]=db.closeTraceabilityTable();
	
	}
	
	actual[59]=db.saveGadget();
	
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

@Then("^Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Closed defect$")
public void should_be_able_to_view_Pass_Fail_WIP_Blocked_Custom_status_status_with_Closed_defect() throws Throwable {
	try
	{
	int reqNo1=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14);
	String executionStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 15);
	String defectStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 17);
	actual[60]=db.validateExecutionsInGadget(reqNo1, executionStatus1, defectStatus1);
	
	
	
	int reqNo2=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14);
	String executionStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 15);
	String defectStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 17);
	actual[61]=db.validateExecutionsInGadget(reqNo2, executionStatus2, defectStatus2);
	
	int reqNo3=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14);
	String executionStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 11, 15);
	String defectStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 17);
	actual[62]=db.validateExecutionsInGadget(reqNo3, executionStatus3, defectStatus3);
	
	int reqNo4=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14);
	String executionStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 16, 15);
	String defectStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 17);
	actual[63]=db.validateExecutionsInGadget(reqNo4, executionStatus4, defectStatus4);
	
	int reqNo5=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14);
	String executionStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 15);
	String defectStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 17);
	actual[64]=db.validateExecutionsInGadget(reqNo5, executionStatus5, defectStatus5);
	
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