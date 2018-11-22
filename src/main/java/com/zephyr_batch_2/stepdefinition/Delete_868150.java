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

public class Delete_868150 extends LaunchBrowser
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
	 String filename="Delete_868150";
	@Given("^User is in a page TestReposiTory$")
	public void user_is_in_a_page_TestReposiTory() throws Throwable 
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
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^User creates a phase and creates a testcase and performs edit operation on testcase$")
	public void user_creates_a_phase_and_creates_a_testcase_and_performs_edit_operation_on_testcase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 49, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 49, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 49, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 26, 0);
			String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 26, 1);
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

	@When("^User expands step details and enters the step details$")
	public void user_expands_step_details_and_enters_the_step_details() throws Throwable 
	{
		try
		{
			String stepdetails[]=new String[3];
			stepdetails[0]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 3, 0);
			stepdetails[1]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 3, 1);
			stepdetails[2]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 3, 2);
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

	@When("^User performs the clone operation of an testcase$")
	public void user_performs_the_clone_operation_of_an_testcase() throws Throwable 
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

	@When("^User Launches TestPlanning and creates a cycle,create a phase by choosing an existing phase and assign individually and save$")
	public void user_Launches_TestPlanning_and_creates_a_cycle_create_a_phase_by_choosing_an_existing_phase_and_assign_individually_and_save() throws Throwable 
	{
		try
		{
				actual[35]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   tl=new TestPlanningPage(driver);
		   actual[36]=tl.clickOnAddTestCycleSymbol();
		   bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 49, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   tl.goBackToCycle();
		    //rp.clickOnTestPlanning();
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

	@When("^User Launches TestExecution and executes the testcases to pass/fail/wip/blocked by choosing status from status drop down$")
	public void user_Launches_TestExecution_and_executes_the_testcases_to_pass_fail_wip_blocked_by_choosing_status_from_status_drop_down() throws Throwable 
	{
		try
		{
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		    rp.clickOnTestExecution();
		    bp.waitForElement();
		    bp.waitForElement();
		   // bp.waitForElement();
		    String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 49, 0);
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

	@When("^User selects the testcase and click on no attachment link in attachment column and choose file from your computer$")
	public void user_selects_the_testcase_and_click_on_no_attachment_link_in_attachment_column_and_choose_file_from_your_computer() throws Throwable 
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

	@When("^User selects the testcase and click on no attachment link and choose file from your computer$")
	public void user_selects_the_testcase_and_click_on_no_attachment_link_and_choose_file_from_your_computer() throws Throwable 
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

	@When("^User Launches TestPlanning and click on phase context menu and click on assign and select the testcase for which attachment was added and$")
	public void user_Launches_TestPlanning_and_click_on_phase_context_menu_and_click_on_assign_and_select_the_testcase_for_which_attachment_was_added_and() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
			bp.waitForElement();
		//   Navigating back to Test Planning is now handled in clickOnTestPlanning() function
//			tl.navigateBacktoTestPlanning();
//		    bp.waitForElement();
		    String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
		    tl.doubleClickOnCycle(cyclename);
		    bp.waitForElement();
		    String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 49, 0);
			tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			tl.assignPhase();
			bp.waitForElement();
			
			String cyclename2[]=new String[1];
		 	cyclename2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 49, 0);
			actual[40]=tl.navigateToCycle(cyclename2);
			bp.waitForElement();
			
			tl.selectallTestCase();
			bp.waitForElement();
			String Unassign=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 7, 0);
			tl.assignAllSelected(Unassign);
			bp.waitForElement();
			
			tl.goBackToCycle();
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

	@When("^User Launch TestPlanning and selects the phase and perorms delete operation of a phase$")
	public void user_Launch_TestPlanning_and_selects_the_phase_and_perorms_delete_operation_of_a_phase() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
//		    tl.navigateBacktoTestPlanning();
		    bp.waitForElement();
		    String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
		    tl.doubleClickOnCycle(cyclename);
		    bp.waitForElement();
		    String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 39, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 49, 0);
			tl.navigateToCycle(cyclename1);
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

	@Then("^Verify that testcase execution attachment is deleted$")
	public void verify_that_testcase_execution_attachment_is_deleted() throws Throwable 
	{
		try
		{
			tl.deleteNode(); 
			bp.waitForElement();
			
			//rp.clickOnTestPlanning();
			//tl.goBackToCycle();
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
}
