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

public class Delete_868149 extends LaunchBrowser
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
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	 String filename="Delete_868149";
	@Given("^User is in a test TestRepository to crate phase and add testcase$")
	public void user_is_in_a_test_TestRepository_to_crate_phase_and_add_testcase() throws Throwable 
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
			   actual[3]=tr.clickOnRelease(releaseName);
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

	@When("^User creates a phase and creates a testcase and performs the edit operation on the testcase$")
	public void user_creates_a_phase_and_creates_a_testcase_and_performs_the_edit_operation_on_the_testcase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 48, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 48, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 48, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			ctc=new CreateTestCasePage(driver);
			tr.clickOnDetails();
			bp.waitForElement();
			String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 25, 0);
			String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 25, 1);
			ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^User expand step details and enters the step details$")
	public void user_expand_step_details_and_enters_the_step_details() throws Throwable 
	{
		try
		{
			String stepdetails[]=new String[3];
			stepdetails[0]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 2, 0);
			stepdetails[1]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 2, 1);
			stepdetails[2]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 2, 2);
		    ctc.enterTestCaseStepDetail(stepdetails);
		    bp.waitForElement();
		    tr.clickOnList();
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

	@When("^User performs the clone operation of the testcase$")
	public void user_performs_the_clone_operation_of_the_testcase() throws Throwable 
	{
		try
		{
		   tr.selectallTestCase();
		   bp.waitForElement();
		   tr.cloneTestCase();
		   bp.waitForElement();
		   tr.selectallTestCase();
		   bp.waitForElement();
		   tr.cloneTestCase();
		   bp.waitForElement();
		   tr.selectallTestCase();
		   bp.waitForElement();
		   tr.cloneTestCase();
		   bp.waitForElement();
		   bp.waitForElement();
		   tr.selectallTestCase();
		   bp.waitForElement();
		   tr.cloneTestCase();
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

	@When("^User Launches TestPlanning and creates a cycle,creates a phase by choosing existing phase and assign individually and save$")
	public void user_Launches_TestPlanning_and_creates_a_cycle_creates_a_phase_by_choosing_existing_phase_and_assign_individually_and_save() throws Throwable 
	{
		try
		{
				actual[35]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   tl=new TestPlanningPage(driver);
		   actual[36]=tl.clickOnAddTestCycleSymbol();
		   bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 38, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 38, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 48, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();		   
//		   tp.navigateBacktoTestPlanning();
//		   bp.waitForElement();	
//		   rp.clickOnTestPlanning();
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

	@When("^User Launches TestExecution and executes the testcases to pass/fail/wip/blocked by choosing status drop down$")
	public void user_Launches_TestExecution_and_executes_the_testcases_to_pass_fail_wip_blocked_by_choosing_status_drop_down() throws Throwable 
	{
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		    rp.clickOnTestExecution();
		    bp.waitForElement();
		    bp.waitForElement();
		    String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 38, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 48, 0);
			actual[40]=tr.navigateToNode(releaseName, cyclename1);
			bp.waitForElement();
		    epp=new ExecutionPage(driver);
		    
		    //status pass
		    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    epp.executeStatus(tcNo, statusType);
		    bp.waitForElement();
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.executeStatus(tcNo2, statusType);  
		    bp.waitForElement();
		    
		    //status Not Executed
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    String statusType2=Excel_Lib.getData(INPUT_PATH_4, "status", 2, 0);
		    epp.executeStatus(tcNo3, statusType2);
		    bp.waitForElement();
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.executeStatus(tcNo4, statusType2);
		    bp.waitForElement();
		    //status Fail
		    int tcNo5=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 5, 0);
		    String statusType3=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    epp.executeStatus(tcNo5, statusType3);    
		    bp.waitForElement();
		    int tcNo6=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 6, 0);
		    epp.executeStatus(tcNo6, statusType3);
		    bp.waitForElement();
		    //status blocked
		    int tcNo7=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 7, 0);
		    String statusType4=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    epp.executeStatus(tcNo7, statusType4);    
		    bp.waitForElement();
		    int tcNo8=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 8, 0);
		    epp.executeStatus(tcNo8, statusType4);
		    bp.waitForElement();
		    //status Wip
		    int tcNo9=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 9, 0);
		    String statusType5=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    epp.executeStatus(tcNo9, statusType5);    
		    bp.waitForElement();
		    int tcNo10=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 10, 0);
		    epp.executeStatus(tcNo10, statusType5);
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

	@When("^User selects the testcase and click on no attachment link in the attachment column and choose file from your computer$")
	public void user_selects_the_testcase_and_click_on_no_attachment_link_in_the_attachment_column_and_choose_file_from_your_computer() throws Throwable 
	{
		try
		{
			int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			String filePath=Excel_Lib.getData(INPUT_PATH_4,"path", 1, 0);
		    epp.uploadAttachementInList(tcNo1, filePath);
		   
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.uploadAttachementInList(tcNo2, filePath);
		    
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    epp.uploadAttachementInList(tcNo3, filePath);
		    
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.uploadAttachementInList(tcNo4, filePath);
		    
		    int tcNo5=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 5, 0);
		    epp.uploadAttachementInList(tcNo5, filePath);
		    
		  
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

	@When("^User clicks on the no attachment link and choose file from your computer$")
	public void user_clicks_on_the_no_attachment_link_and_choose_file_from_your_computer() throws Throwable 
	{
		try
		{
			  int tcNo6=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 6, 0);
			  String filePath=Excel_Lib.getData(INPUT_PATH_4,"path", 1, 0);
			    epp.uploadAttachementInList(tcNo6, filePath);
			    
			    int tcNo7=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 7, 0);
			    epp.uploadAttachementInList(tcNo7, filePath);
			    
			    int tcNo8=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 8, 0);
			    epp.uploadAttachementInList(tcNo8, filePath);
			    
			    int tcNo9=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 9, 0);
			    epp.uploadAttachementInList(tcNo9, filePath);
			    
			    int tcNo10=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 10, 0);
			    epp.uploadAttachementInList(tcNo10, filePath);
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

	@When("^User Launch TestPlanning and click on phase,selects assign$")
	public void user_Launch_TestPlanning_and_click_on_phase_selects_assign() throws Throwable 
	{
		try
		{
			
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
//   Navigating back to Test Planning is now handled in clickOnTestPlanning() function		    
//		    tl.navigateBacktoTestPlanning();
//		    bp.waitForElement();
		    String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 38, 0);
		    tl.doubleClickOnCycle(cyclename);
		    bp.waitForElement();
		    String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 38, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 48, 0);
			tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			tl.assignPhase();
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

	@When("^User selects the testcase for which attachment was added and choose unassign option in the assign drop down$")
	public void user_selects_the_testcase_for_which_attachment_was_added_and_choose_unassign_option_in_the_assign_drop_down() throws Throwable 
	{
		try
		{
		 	String cyclename1[]=new String[1];
		 	cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 48, 0);
			tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			tl.selectallTestCase();
			bp.waitForElement();
			String Unassign=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 7, 0);
			tl.assignAllSelected(Unassign);
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

	@When("^User select select the testcase with attachment and clicks on delete button in action column across testcase$")
	public void user_select_select_the_testcase_with_attachment_and_clicks_on_delete_button_in_action_column_across_testcase() throws Throwable 
	{
		try
		{
			int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			tl.deleteTestcaseInActionColumn(tcNo1);
			bp.waitForElement();
			
			int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
			tl.deleteTestcaseInActionColumn(tcNo2);
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

	@Then("^User successfully verify that testcase execution attachment is deleted from zephyrdata including the releaseTestSchedule_id folder$")
	public void user_successfully_verify_that_testcase_execution_attachment_is_deleted_from_zephyrdata_including_the_releaseTestSchedule_id_folder() throws Throwable 
	{
		try
		{
			
			int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
			tl.deleteTestcaseInActionColumn(tcNo3);
			bp.waitForElement();
			
			int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
			tl.deleteTestcaseInActionColumn(tcNo4); 
			
			//rp.clickOnTestPlanning();
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
	

}}
