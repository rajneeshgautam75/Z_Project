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

public class Delete_868152 extends LaunchBrowser
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
	 String filename="Delete_868152";
	@Given("^User is in test repository to create phase and clone$")
	public void user_is_in_test_repository_to_create_phase_and_clone() throws Throwable 
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

	@When("^User creates a phase and creates testcase in phase$")
	public void user_creates_a_phase_and_creates_testcase_in_phase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 51, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 51, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 51, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			ctc=new CreateTestCasePage(driver);
			tr.clickOnDetails();
			bp.waitForElement();
			String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 28, 0);
			String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 28, 1);
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

	@When("^Edit the testcase and expand step details and perform clone$")
	public void edit_the_testcase_and_expand_step_details_and_perform_clone() throws Throwable 
	{
		try
		{
			String stepdetails[]=new String[3];
			stepdetails[0]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 5, 0);
			stepdetails[1]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 5, 1);
			stepdetails[2]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 5, 2);
		    ctc.enterTestCaseStepDetail(stepdetails);
		    bp.waitForElement();
		    tr.clickOnList();
		    bp.waitForElement();
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

	@When("^Launche TestPlanning and create a cycle$")
	public void launche_TestPlanning_and_create_a_cycle() throws Throwable 
	{
		try
		{
				actual[35]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   tl=new TestPlanningPage(driver);
		   actual[36]=tl.clickOnAddTestCycleSymbol();
		   bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 41, 0);
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

	@When("^create a phase by choosing an existing phase and assign individually$")
	public void create_a_phase_by_choosing_an_existing_phase_and_assign_individually() throws Throwable 
	{
		try
		{
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 41, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 51, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   
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
	}

	@When("^Launch TestExecution and executes the testcases to pass/fail/wip/blocked by choosing status drop down$")
	public void launch_TestExecution_and_executes_the_testcases_to_pass_fail_wip_blocked_by_choosing_status_drop_down() throws Throwable 
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
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 41, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 51, 0);
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

	@When("^select the testcase and click on no attachment link in attachment column and choose file from your computer$")
	public void select_the_testcase_and_click_on_no_attachment_link_in_attachment_column_and_choose_file_from_your_computer() throws Throwable 
	{
		try
		{
			bp=new BasePage();
			int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			String filePath=Excel_Lib.getData(INPUT_PATH_4,"path", 1, 0);
		    epp.uploadAttachementInList(tcNo1, filePath);
		    bp.waitForElement();
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.uploadAttachementInList(tcNo2, filePath);
		    bp.waitForElement();
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    epp.uploadAttachementInList(tcNo3, filePath);
		    bp.waitForElement();
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.uploadAttachementInList(tcNo4, filePath);
		    bp.waitForElement();
		    int tcNo5=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 5, 0);
		    epp.uploadAttachementInList(tcNo5, filePath);
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

	@When("^select the testcase and click on no attachment link in attachment column choose file from your computer$")
	public void select_the_testcase_and_click_on_no_attachment_link_in_attachment_column_choose_file_from_your_computer() throws Throwable 
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
			    bp=new BasePage();
			    bp.waitForElement();
			    rp.clickOnTestPlanning();
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

	@When("^Launch Testrepository and navigate to phase and delete the testcases which has attachments$")
	public void launch_Testrepository_and_navigate_to_phase_and_delete_the_testcases_which_has_attachments() throws Throwable 
	{
		try
		{
			actual[2]=rp.clickOnTestRep();
			bp.waitForElement();
		   
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 51, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
		   
			tr.selectallTestCase();
			bp.waitForElement();
			tr.deleteTestCase();
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

	@When("^Launch TestPlanning and click on phase context menu and click on assign$")
	public void launch_TestPlanning_and_click_on_phase_context_menu_and_click_on_assign() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
//		    tl.navigateBacktoTestPlanning();
		    String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 41, 0);
		    tl.doubleClickOnCycle(cyclename);
		    bp.waitForElement();
		    String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 41, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 51, 0);
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

	@Then("^click on sync choose option remove deleted nodes should able to display removed deleted nodes$")
	public void click_on_sync_choose_option_remove_deleted_nodes_should_able_to_display_removed_deleted_nodes() throws Throwable 
	{
		try
		{
			String check=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		    tl.sync(check);
		    bp.waitForElement();
		    
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
	}

}
