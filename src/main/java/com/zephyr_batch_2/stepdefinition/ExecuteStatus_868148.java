package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ExecuteStatus_868148 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	String fileName="ExecuteStatus_868148";
	
	boolean[] actual=new boolean[37];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page teStRepository$")
	public void user_is_in_a_page_teStRepository() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
		   
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User creates a phase and creates a testcase in phase$")
	public void user_creates_a_phase_and_creates_a_testcase_in_phase() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 4);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				
				
				
	    }
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@When("^User performs the edit operation on the created Testcase and enter step details$")
	public void user_performs_the_edit_operation_on_the_created_Testcase_and_enter_step_details() throws Throwable {
		try
		{
			bp.waitForElement();
		actual[7]=tr.clickDetailButton();
		bp.waitForElement();
		
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"Search_868221" , 1, 1);
		bp.waitForElement();
		actual[8]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
		bp.waitForElement();
		
		String[] stepDetail=new String[9];
		stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 6);
		stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 7);
		stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 8);
		stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 6);
		stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 7);
		stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 8);
		stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 6);
		stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 7);
		stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 8);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[9]=ctc.enterTestCaseStepDetail(stepDetail);
		bp.waitForElement();
		bp.waitForElement();
		
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@When("^User performs the clone operation by selecting the testcase$")
	public void user_performs_the_clone_operation_by_selecting_the_testcase() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
			actual[10]=tr.clickOnList();
			bp.waitForElement();
			actual[11]=tr.selectallTestCase();
			actual[12]=tr.cloneTestCase();
			bp.waitForElement();
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
	    	e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@When("^User Launch TestPlanning and creates A cycle$")
	public void user_Launch_TestPlanning_and_creates_A_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[13]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[14]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[15]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[16]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[17]=tp.saveTestCycle();
				bp.waitForElement();
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			} 
	}

	@When("^User clicks on cycle context menu and creates a phase by choosing an existing phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_phase_by_choosing_an_existing_phase() throws Throwable {
		try
	    {
			actual[18]=bp.waitForElement();
			//actual[18]=tp.goBackToCycle();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 0);
			actual[19]=tp.navigateToCycle(cycle);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 1);
			actual[20]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			
			}
			catch(Exception e)
			{
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User choose assign individually and save$")
	public void user_choose_assign_individually_and_save() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 3, 0);
			bp.waitForElement();
			actual[21]=tp.bulkAssignment(Bulk_Type);
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User Launch TestExecution and execute testcases to pass/fail/wip/blocked by choosing the status in status drop down$")
	public void user_Launch_TestExecution_and_execute_testcases_to_pass_fail_wip_blocked_by_choosing_the_status_in_status_drop_down() throws Throwable {
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 1);
			bp.waitForElement();
			bp.waitForElement();
			actual[22]=tp.navigateToCycle(phase);
			bp.waitForElement();
			
			 int[] TestCaseNo1=new int[1];
				TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
				String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				bp.waitForElement();
				actual[23]=tp.individualAssinTo(TestCaseNo1, Assignee1);
				
				bp.waitForElement();
				int[] TestCaseNo2=new int[1];
				TestCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
				String Assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				bp.waitForElement();
				actual[24]=tp.individualAssinTo(TestCaseNo2, Assignee2);
				tp.goBackToCycle();
			
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[25]=rp.clickOnTestExecution(); 
		   
		   String[] cycleName=new String[3];
		    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,0 );
		    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,1 );
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[26]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[27]=exep.executeStatus(tcNo1[0], statusType1);
		    
		    int[] tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
		    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
		    bp.waitForElement();
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[28]=exep.executeStatus(tcNo2[0], statusType2);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User selects the testcase and clicks on no attachment link in the attachment column across testcase and chooses file from computer$")
	public void user_selects_the_testcase_and_clicks_on_no_attachment_link_in_the_attachment_column_across_testcase_and_chooses_file_from_computer() throws Throwable {
	    try
	    {
	    	int tcNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    	String filepath=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,7 );
	    	exep=new ExecutionPage(driver);
			bp.waitForElement();
	    	actual[29]=exep.uploadAttachementInList(tcNo, filepath);
	    	
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User clicks on the no attachment link and choose file from your computer and choose file and save$")
	public void user_clicks_on_the_no_attachment_link_and_choose_file_from_your_computer_and_choose_file_and_save() throws Throwable {
		try
	    {
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			String filepath=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,7 );
			exep=new ExecutionPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[30]=exep.uploadAttachementInList(tcNo, filepath);
			
			String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
			tp.doubleClickOnCycle(cycleName);
			bp.waitForElement();
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User Launch TestPlanning and click on the previously created existing phase and chooses assign$")
	public void user_Launch_TestPlanning_and_click_on_the_previously_created_existing_phase_and_chooses_assign() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[31]=rp.clickOnTestPlanning();
		bp.waitForElement();
		//tp.navigateBacktoTestPlanning();
		bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,0 );
		bp.waitForElement();
		actual[32]=tp.doubleClickOnCycle(cycleName1);
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[33]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[34]=tp.assignPhase();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@When("^User selects the testcase for which attachment was added and choose unassign in the assign drop down$")
	public void user_selects_the_testcase_for_which_attachment_was_added_and_choose_unassign_in_the_assign_drop_down() throws Throwable {
		try
	    {
	    	String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,1 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[35]=tp.navigateToCycle(phaseName);
		   
		   int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,9 );
			actual[36]=tp.individualAssinTo(TestCaseNo, Assignee);
			tp.goBackToCycle();
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}
}
