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

public class Sync_868172 extends LaunchBrowser
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
	boolean[] actual=new boolean[68];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository page to create phase and add two testcases$")
	public void user_in_repository_page_to_create_phase_and_add_two_testcases() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
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
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}  
	}

	@Given("^create a phase one and add two testcases$")
	public void create_a_phase_one_and_add_two_testcases() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   actual[7]=tr.addTestCase();
			   actual[7]=tr.addTestCase();
		  }
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}   
	}

	@When("^launch test planning create cycle and add phase to cycle and assign to creator$")
	public void launch_test_planning_create_cycle_and_add_phase_to_cycle_and_assign_to_creator() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[39]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		 }
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testrepository and add phase two and move testcases from phase one to phase two$")
	public void launch_testrepository_and_add_phase_two_and_move_testcases_from_phase_one_to_phase_two() throws Throwable 
	{
		try
		{
		 actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		   
		   String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			 //navigate to phase1
			 String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   
			   String[] tcname1=new String[2];
				tcname1[0]=Integer.toBinaryString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 1, 0));
				tcname1[1]=Integer.toBinaryString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 2, 0));
			  ep.selectMultipleTestCaseFromGrid(tcname1);
			  
			  String dest1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			  tr.dragAndDropTestCase(tl.dragEle, dest1);
		 }
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^navigate to phase one and add three testcases$")
	public void navigate_to_phase_one_and_add_three_testcases() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   actual[7]=tr.addTestCase();
			   actual[7]=tr.addTestCase();
			   actual[7]=tr.addTestCase();
		  }
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}   
	}

	@Then("^launch test planning navigate to phase one and sync with select checkbox Remove deleted testcases$")
	public void launch_test_planning_navigate_to_phase_one_and_sync_with_select_checkbox_Remove_deleted_testcases() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		   String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
		    tl.doubleClickOnCycle(cycleName);
		    String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			tl.assignPhase();
			bp.waitForElement();
			 String check=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tl.sync(check);
			bp.waitForElement();
		 }
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^Verify new added testcase to phase one$")
	public void verify_new_added_testcase_to_phase_one() throws Throwable 
	{
	   
	}

}
