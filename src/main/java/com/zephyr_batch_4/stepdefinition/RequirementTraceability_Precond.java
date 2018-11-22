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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequirementTraceability_Precond extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exe;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="RequirementTraceability_Precond";
	
	boolean[] actual=new boolean[64];
	 SoftAssert soft=new SoftAssert();
	 
	

@Given("^User navigate to Test Repository page$")
public void user_navigate_to_Test_Repository_page() throws Throwable {
    try
    {
	pp=new ProjectPage(driver);
    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
    actual[0]= pp.selectProject(projectName);
    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
    actual[1]=pp.selectRelease(releaseName);
    
    rp=new ReleasePage(driver);
    actual[2]=rp.clickOnTestRep();
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

@When("^User add a node with name and description$")
public void user_add_a_node_with_name_and_description() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	tr=new TestRepositoryPage(driver);
	actual[3]=tr.clickOnRelease(releaseName);
	
	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 2);
	actual[4]=tr.addNode(name, desc);
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

@Then("^node created successfully$")
public void node_created_successfully() throws Throwable {
 
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	String[] navigation=new String[1];
	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	
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

@When("^user add multiple testcases to the node$")
public void user_add_multiple_testcases_to_the_node() throws Throwable {
   try
   {
	
	   actual[6]=tr.addTestCase();
	for(int i=1;i<=5;i++)
	{
		actual[7]=tr.selectallTestCase();
		actual[8]=tr.cloneTestCase();
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

@Then("^testcases should be added successfully$")
public void testcases_should_be_added_successfully() throws Throwable {
   try
   {
	   actual[9]=tr.verifyPresentTestCase();
	
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

@When("^user create a test cycle and assign phase$")
public void user_create_a_test_cycle_and_assign_phase() throws Throwable {
   
	try
	{
	tp=new TestPlanningPage(driver);
	actual[10]= rp.clickOnTestPlanning();
    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 3);
    String build=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 4);
    String environ=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 5);
    String hide=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 6);
    String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 7));
    String smonth=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 8);
    String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 9));
    String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 10));
    
    String emonth=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 11);
    String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 12));
    
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	
    
	actual[11]=tp.clickOnAddTestCycleSymbol();
	actual[12]=tp.CreateCycle(cycleName, build, environ, hide);
	actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	actual[14]=tp.saveTestCycle();
    
	actual[15]=tp.doubleClickOnCycle(cycleName);
	actual[16]=tp.addPhaseToCycle(phaseName);
    
	actual[17]=tp.cancelBulkAssign();
	actual[18]= tp.doubleClickOnCycle(phaseName);
   
    
    //tp.selectSingleMultipleTestcase(tcNo);
	actual[19]=tp.selectallTestCase();
    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
    actual[20]=tp.assignAllSelected(assignee);
    
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

@Then("^test case successfully assigned$")
public void test_case_successfully_assigned() throws Throwable {
	
	try
	{
	 String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
	int[] tcNo=new int[30];
	
	for(int i=0;i<=tcNo.length-1;i++)
	{
      tcNo[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i+1, 14);
	}
	actual[21]= tp.validateAllAssigned(tcNo, assignee);
    tp.goBackToCycle();
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

@When("^user navigate to test execution$")
public void user_navigate_to_test_execution() throws Throwable {
	try
	{
		
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	actual[22]=rp.clickOnTestExecution();
   String[] navigation=new String[2];
   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 3);
   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
   actual[23]=tr.navigateToNode(releaseName, navigation);
   
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

@When("^change the execution Status to Pass for multiple testcases$")
public void change_the_execution_Status_to_Pass_for_multiple_testcases() throws Throwable {
   try
   {
	exe=new ExecutionPage(driver);
    int[] tcNo=new int[6];
    for(int i=0;i<=4;i++)
	{
      tcNo[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",i+1, 14);
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",26, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1,15);
    actual[24]=exe.changeStatusOfTestCases(tcNo, status);
	
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

@Then("^eecution status successfully changed to Pass$")
public void eecution_status_successfully_changed_to_Pass() throws Throwable {
   
	try
	{
    int[] tcNo=new int[6];
    for(int i=0;i<=4;i++)
	{
      tcNo[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i+1, 14);
	}
    String status=Excel_Lib.getData(INPUT_PATH_3, "ReqTraceability", 1,15);
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",26, 14);
    actual[25]=exe.ValidateStatusOfTestCases(tcNo, status);
	
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

@When("^user link defect with open ,In progress,Closed,Reopen ,Resoved status$")
public void user_link_defect_with_open_In_progress_Closed_Reopen_Resoved_status() throws Throwable {
 
	try
	{
	 for(int i=1;i<=5;i++)
		{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[26]=exe.clickOnDefectButton(testcase);
	actual[27]=exe.linkDefect(defectId);
		}
	 
	 
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 26, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 26, 16);
	actual[28]=exe.clickOnDefectButton(testcase);
	actual[29]=exe.linkDefect(defectId);
		
	 
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

@Then("^defect successfully link to the testcases$")
public void defect_successfully_link_to_the_testcases1() throws Throwable {
 
	try
	{
	for(int i=1;i<=5;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[30]=exe.validateLinkedDefect(testcase, defectId);
	}
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 26, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 26, 16);
	actual[31]=exe.validateLinkedDefect(testcase, defectId);
	
	
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

@When("^user change the execution status to Fail for multiple testcases$")
public void user_change_the_execution_status_to_Fail_for_multiple_testcases() throws Throwable {
	try
	{
	int[] tcNo=new int[6];
	int k=0;
    for(int i=6;i<=10;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",27, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 15);
    actual[32]=exe.changeStatusOfTestCases(tcNo, status);
	
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

@Then("^testcase status successfully changed to Fail$")
public void testcase_status_successfully_changed_to_Fail() throws Throwable {
	try
	{
	
	int[] tcNo=new int[6];
	int k=0;
    for(int i=6;i<=10;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",27, 14);
    String status=Excel_Lib.getData(INPUT_PATH_3, "ReqTraceability", 6,15);
    actual[33]=exe.ValidateStatusOfTestCases(tcNo, status);
	
	
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

@When("^user link defect with Open ,In progress,Closed,Reopen ,Resoved status$")
public void user_link_defect_with_Open_In_progress_Closed_Reopen_Resoved_status() throws Throwable {
	try
	{
	for(int i=6;i<=10;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[34]=exe.clickOnDefectButton(testcase);
	actual[35]=exe.linkDefect(defectId);
	
	}
	
	 
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 27, 14);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 27, 16);
		actual[36]=exe.clickOnDefectButton(testcase);
		actual[37]=exe.linkDefect(defectId);
	
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

@Then("^Defect successfully link to the testcases$")
public void defect_successfully_link_to_the_testcases() throws Throwable {
	try
	{
	for(int i=6;i<=10;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[38]=exe.validateLinkedDefect(testcase, defectId);
	}
	 
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 27, 14);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 27, 16);
		actual[39]=exe.validateLinkedDefect(testcase, defectId);
		
	
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

@When("^user change the execution status to WIP for multiple testcases$")
public void user_change_the_execution_status_to_WIP_for_multiple_testcases() throws Throwable {
	try
	{
	int[] tcNo=new int[6];
	int k=0;
    for(int i=11;i<=15;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",28, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 11, 15);
    actual[40]=exe.changeStatusOfTestCases(tcNo, status);
	
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

@Then("^testcase status successfully changed to WIP$")
public void testcase_status_successfully_changed_to_WIP() throws Throwable {
	try
	{
	int[] tcNo=new int[6];
	int k=0;
    for(int i=11;i<=15;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",28, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",11, 15);
    actual[41]=exe.ValidateStatusOfTestCases(tcNo, status);
	
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

@When("^user link defect with Open ,In Progress,Closed,Reopen ,Resoved status$")
public void user_link_defect_with_Open_In_Progress_Closed_Reopen_Resoved_status() throws Throwable {
	try
	{
	for(int i=11;i<=15;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[42]=exe.clickOnDefectButton(testcase);
	actual[43]=exe.linkDefect(defectId);
	
	}
	

	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 28, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 28, 16);
	actual[44]=exe.clickOnDefectButton(testcase);
	actual[45]=exe.linkDefect(defectId);
	
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

@Then("^Defect Successfully link to the testcases$")
public void defect_Successfully_link_to_the_testcases() throws Throwable {
	try
	{
	for(int i=11;i<=15;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[46]= exe.validateLinkedDefect(testcase, defectId);
	}

	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 28, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 28, 16);
	actual[47]=exe.validateLinkedDefect(testcase, defectId);
	
	
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

@When("^user change the execution status to Blocked for multiple testcases$")
public void user_change_the_execution_status_to_Blocked_for_multiple_testcases() throws Throwable {
	try
	{
	
	int[] tcNo=new int[6];
	int k=0;
    for(int i=16;i<=20;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",29, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",16,15);
    actual[48]=exe.changeStatusOfTestCases(tcNo, status);
	
	
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

@Then("^testcase status successfully changed to Blocked$")
public void testcase_status_successfully_changed_to_Blocked() throws Throwable {
	try
	{
	int[] tcNo=new int[6];
	int k=0;
    for(int i=16;i<=20;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",29, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",16,15);
    actual[49]=exe.ValidateStatusOfTestCases(tcNo, status);
	
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


@When("^user link defect with Open ,InProgress,Closed,Reopen,Resoved status$")
public void user_link_defect_with_Open_InProgress_Closed_Reopen_Resoved_status() throws Throwable {
	try
	{
	for(int i=16;i<=20;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[50]=exe.clickOnDefectButton(testcase);
	actual[51]=exe.linkDefect(defectId);
	
	}
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 29, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 29, 16);
	actual[52]=exe.clickOnDefectButton(testcase);
	actual[53]=exe.linkDefect(defectId);
	
	
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

@Then("^Defect Successfully Link to the testcases$")
public void defect_Successfully_Link_to_the_testcases() throws Throwable {
	try
	{
	for(int i=16;i<=20;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[54]=exe.validateLinkedDefect(testcase, defectId);
	}
	
	
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 29, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 29, 16);
	actual[55]=exe.validateLinkedDefect(testcase, defectId);
	
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

@When("^user change the execution status to Custom Status for multiple testcases$")
public void user_change_the_execution_status_to_Custom_Status_for_multiple_testcases() throws Throwable {
	try
	{
	int[] tcNo=new int[6];
	int k=0;
    for(int i=21;i<=25;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",30, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 15);
    actual[56]=exe.changeStatusOfTestCases(tcNo, status);
	
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

@Then("^testcase status successfully changed to Custom Status$")
public void testcase_status_successfully_changed_to_Custom_Status() throws Throwable {
	try
	{
	int[] tcNo=new int[6];
	int k=0;
    for(int i=21;i<=25;i++)
	{
      tcNo[k]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
      k++;
	}
    tcNo[5]=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",30, 14);
    String status=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 15);
    actual[57]=exe.ValidateStatusOfTestCases(tcNo, status);
	
	
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

@When("^user link defects with Open ,In Progress,Closed,Reopen,Resoved status$")
public void user_link_defects_with_Open_In_Progress_Closed_Reopen_Resoved_status() throws Throwable {
	try
	{
	for(int i=21;i<=25;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[58]=exe.clickOnDefectButton(testcase);
	actual[59]=exe.linkDefect(defectId);
	
	}
	
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 30, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 30, 16);
	actual[60]=exe.clickOnDefectButton(testcase);
	actual[61]=exe.linkDefect(defectId);
	
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

@Then("^defect successfully link to the test cases$")
public void defect_successfully_link_to_the_test_cases() throws Throwable {
	try
	{
	for(int i=21;i<=25;i++)
	{
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", i, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i, 16);
	actual[62]=exe.validateLinkedDefect(testcase, defectId);
	}
	
	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 30, 14);
	String defectId=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 30, 16);
	actual[63]=exe.validateLinkedDefect(testcase, defectId);
	
	

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
