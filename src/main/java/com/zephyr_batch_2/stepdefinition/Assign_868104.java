package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assign_868104 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	boolean[] actual=new boolean[29];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868104";
	@Given("^user in repository Page to create Node$")
	public void user_in_repository_Page_to_create_Node() throws Throwable 
	{
		 try
		   {
			   pp=new ProjectPage(driver);
			  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}  
	}

	@Given("^create a node add testcase and clone testcses$")
	public void create_a_node_add_testcase_and_clone_testcses() throws Throwable
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 22, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 22, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
		   bp.waitForElement();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		   tr.doubleClickOnRelease(releaseName);
		   String[] navigation=new String[1];
		   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 22, 0);
		   tr.navigateToNode(releaseName, navigation);
		   bp.waitForElement();
		   tr.addTestCase();
		   bp.waitForElement();
		   ctc=new CreateTestCasePage(driver);
		   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 17, 0);
		   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 17, 1);
		   tr.clickDetailButton();
		   actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		   bp.waitForElement();
		   tr.clickOnList();
		   bp.waitForElement();
		   tr.selectallTestCase();
		   bp.waitForElement();
		   actual[6]=tr.cloneTestCase();
		   bp.waitForElement();
		   tr.selectallTestCase();
		   bp.waitForElement();
		   actual[7]=tr.cloneTestCase();
		   bp.waitForElement();
		}
	   catch (Exception e) 
			{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testplanning create cycle and add phase$")
	public void launch_testplanning_create_cycle_and_add_phase() throws Throwable 
	{
		try
		{
				actual[8]=rp.clickOnTestPlanning();
				bp.waitForElement();
				tl=new TestPlanningPage(driver);
				String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 3, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 3, 1);
				String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 3, 2);
				String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
				tl.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				actual[9]=tl.CreateCycle(cyclename, Build, Environment,hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
				String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
				tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				tl.saveTestCycle();
				bp.waitForElement();
				String cyclename1[]=new String[1];
				cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 3, 0);
				actual[10]=tl.navigateToCycle(cyclename1);
				bp.waitForElement();
				String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 22, 0);
				actual[11]=tl.addPhaseToCycle(nodeName);
			   bp.waitForElement();
			   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
			   actual[12]=tl.bulkAssignment(Bulk_type);
			   bp.waitForElement();
			   
			   tl.goBackToCycle();
			   bp.waitForElement();
		  }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch test execution and execute testcases by status dropdown$")
	public void launch_test_execution_and_execute_testcases_by_status_dropdown() throws Throwable 
	{
		try
		{
		    rp=new ReleasePage(driver);
		    actual[13]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement(); 
		    String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 3, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 22, 0);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
	//		actual[14]=tl.navigateToCycle(cyclename1);
			actual[14]=tr.navigateToNode(releaseName, cyclename1);
		  //  tl.navigateToCycle(cyclename1);
		    bp.waitForElement();
		    epp=new ExecutionPage(driver);
		    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames", 1,0);
		    String status=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    actual[15]=epp.executeStatus(tcNo, status);
		    bp.waitForElement();
		    
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",2 ,0);
		   // String status2=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    actual[16]=epp.executeStatus(tcNo2, status);
		    bp.waitForElement();
		    
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames", 3,0);
		   // String status=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    actual[17]=epp.executeStatus(tcNo3, status);
		    bp.waitForElement();
		    
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames", 4,0);
		   // String status=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    actual[18]=epp.executeStatus(tcNo4, status);
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testplanning select phase and assign and view status$")
	public void launch_testplanning_select_phase_and_assign_and_view_status() throws Throwable 
	{
		try
		{
			actual[19]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   String[] cycleName=new String[1];
		   cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 3, 0);
		   bp.waitForElement();
		   actual[20]=tl.navigateToCycle(cycleName);
		   bp.waitForElement();
		   tl.navigateToCycle(cycleName);
		   bp.waitForElement();
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 22, 0);
		   tl.navigateToCycle(phase);
		   bp.waitForElement();
		   actual[21]= tl.assignPhase();
		   bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^select test case assign to lead$")
	public void select_test_case_assign_to_lead() throws Throwable 
	{
		try
		{
			String nodeName[]=new String[1];
			nodeName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 22, 0);
			actual[13]=tl.navigateToCycle(nodeName);
			bp.waitForElement();
			int[] TestcaseNo=new int[1];
			TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
	//	    tl.selectSingleMultipleTestcase(tcNo);
			//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
			String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			actual[22]=tl.individualAssinTo(TestcaseNo, lead);
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^select test case and delete$")
	public void select_test_case_and_delete() throws Throwable 
	{
		try
		{
			int[] TestcaseNo=new int[1];
			TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			actual[23]=tl.selectSingleMultipleTestcase(TestcaseNo);
			bp.waitForElement();
			actual[24]=tl.deleteAllSelectedTestCases();
			bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^select two more testcase and delete$")
	public void select_two_more_testcase_and_delete() throws Throwable 
	{
		try
		{
			int[] TestcaseNo=new int[2];
			TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			TestcaseNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
			actual[25]=tl.selectSingleMultipleTestcase(TestcaseNo);
			bp.waitForElement();
			actual[26]=tl.deleteAllSelectedTestCases();
			bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^select remaining testcases and delete$")
	public void select_remaining_testcases_and_delete() throws Throwable 
	{
		try
		{
			actual[27]=tl.selectallTestCase();
		    bp.waitForElement();
		    actual[28]=tl.deleteAllSelectedTestCases();
		    bp.waitForElement();
		    
		    tl.goBackToCycle();
		    bp.waitForElement();
		    for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
