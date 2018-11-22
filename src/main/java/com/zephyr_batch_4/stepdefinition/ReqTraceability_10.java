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

public class ReqTraceability_10 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exe;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="RequirementTraceability_10";
	
	boolean[] actual=new boolean[64];
	 SoftAssert soft=new SoftAssert();

@Given("^User Navigate to Requirement page$")
public void user_Navigate_to_Requirement_page() throws Throwable {
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

@When("^User add a Phase with Name and Description$")
public void user_add_a_Phase_with_Name_and_Description() throws Throwable {
	 try
	  {
		req=new RequirementsPage(driver);
	   tr=new TestRepositoryPage(driver);
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 2);
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

@Then("^phase should be Created Successfully$")
public void phase_should_be_Created_Successfully() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] navigation=new String[1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 1);
		
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

@When("^user Add five requirements in the Phase$")
public void user_Add_five_requirements_in_the_Phase() throws Throwable {
	try
	   {
		for(int i=1;i<=5;i++)
	   {
		   String reqName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",i+20 , 18);
		   String reqDesc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 199);
		   String altID=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 99);
		   String link=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99, 19);
		   String priority=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 19);
		   actual[6]= req.addRequirement();
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

@Then("^five requirements successfully Added to the phase$")
public void five_requirements_successfully_Added_to_the_phase() throws Throwable {
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

@When("^user selects the First requirement$")
public void user_selects_the_First_requirement() throws Throwable {
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

@When("^Map to testcase executed to status PASS and linked to defect with status Resolved$")
public void map_to_testcase_executed_to_status_PASS_and_linked_to_defect_with_status_Resolved() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14));
	
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

@Then("^First Requirement successfully Mapped to the testcase$")
public void first_Requirement_successfully_Mapped_to_the_testcase() throws Throwable {
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



@When("^user selects the second Requirement$")
public void user_selects_the_second_Requirement() throws Throwable {
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



@When("^Map to testcase executed to status Fail and linked to defect with status Resolved$")
public void map_to_testcase_executed_to_status_Fail_and_linked_to_defect_with_status_Resolved() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 9, 14));
	
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

@Then("^Second Requirement successfully Mapped to the testcase$")
public void second_Requirement_successfully_Mapped_to_the_testcase() throws Throwable {
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

@When("^user selects the third Requirement$")
public void user_selects_the_third_Requirement() throws Throwable {
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

@When("^map to testcase executed to status WIP and linked to defect with status Resolved$")
public void map_to_testcase_executed_to_status_WIP_and_linked_to_defect_with_status_Resolved() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 14, 14));
	
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

@Then("^Third requirement successfully Mapped to the testcase$")
public void third_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
    
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

@When("^user selects the Fourth requirement$")
public void user_selects_the_Fourth_requirement() throws Throwable {
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

@When("^map to testcase executed to status Blocked and linked to defect with status Resolved$")
public void map_to_testcase_executed_to_status_Blocked_and_linked_to_defect_with_status_Resolved() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 19, 14));
	
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

@Then("^fourth Requirement successfully Mapped to the testcase$")
public void fourth_Requirement_successfully_Mapped_to_the_testcase() throws Throwable {
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

@When("^user selects the Fifth requirement$")
public void user_selects_the_Fifth_requirement() throws Throwable {
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

@When("^map to testcase executed to status Custom Status and linked to defect with status Resolved$")
public void map_to_testcase_executed_to_status_Custom_Status_and_linked_to_defect_with_status_Resolved() throws Throwable {
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
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 24, 14));
	
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

@Then("^Fifth requirement successfully Mapped to the testcase$")
public void fifth_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
 
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

@When("^User click on Dashboard Page$")
public void user_click_on_Dashboard_Page() throws Throwable {
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

@Then("^dashboard page Should be displayed$")
public void dashboard_page_Should_be_displayed() throws Throwable {
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

@When("^user adds a new Dasboard with all details$")
public void user_adds_a_new_Dasboard_with_all_details() throws Throwable {
	try
	{
		actual[46]=db.clickOnAddDashBoardSymbol();
	   String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 1);
	   String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 4);
	   actual[47]= db.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
	   
	   
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

@Then("^new Dashboard should be Created successfully$")
public void new_Dashboard_should_be_Created_successfully() throws Throwable {
	try
	{
	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 1);
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

@When("^user Add a Traceability Report Gadget$")
public void user_Add_a_Traceability_Report_Gadget() throws Throwable {
	try
	{
	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 1);
	 String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 5);
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

@Then("^Traceability Report gadget Added Successfully$")
public void traceability_Report_gadget_Added_Successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 5);
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

@When("^user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect Resolved status$")
public void user_selects_the_requirements_map_to_testcase_executed_to_Pass_Fail_WIP_Blocked_Custom_Status_and_linked_to_defect_Resolved_status() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	   
    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");

 String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 26, 6);
 actual[53]=db.configureTraceabilityGadget(projectName, releaseName, refreshRate);

for(int i=1;i<=5;i++)
{
	actual[54]=db.manageTraceability();
String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i+20, 18);
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

@Then("^Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Resolved defect$")
public void should_be_able_to_view_Pass_Fail_WIP_Blocked_Custom_status_status_with_Resolved_defect() throws Throwable {
	try
	{
	int reqNo1=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14);
	String executionStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 15);
	String defectStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 17);
	actual[59]=db.validateExecutionsInGadget(reqNo1, executionStatus1, defectStatus1);
	
	
	
	int reqNo2=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14);
	String executionStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 15);
	String defectStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 17);
	actual[60]=db.validateExecutionsInGadget(reqNo2, executionStatus2, defectStatus2);
	
	int reqNo3=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14);
	String executionStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 11, 15);
	String defectStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 17);
	actual[61]=db.validateExecutionsInGadget(reqNo3, executionStatus3, defectStatus3);
	
	int reqNo4=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14);
	String executionStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 16, 15);
	String defectStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 17);
	actual[62]=db.validateExecutionsInGadget(reqNo4, executionStatus4, defectStatus4);
	
	int reqNo5=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14);
	String executionStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 15);
	String defectStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 5, 17);
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
