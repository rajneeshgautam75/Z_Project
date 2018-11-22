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

public class Retrieve_868197 extends LaunchBrowser
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
	 String filename="Retrieve_868197";
	@Given("^user in repository page to create phase$")
	public void user_in_repository_page_to_create_phase() throws Throwable 
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

	@Given("^Launch test repository create phase add hundred testcases to phase$")
	public void launch_test_repository_create_phase_add_hundred_testcases_to_phase() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 43, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 43, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 43, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   for(int i=0;i<5;i++)
			   {
				   actual[7]=tr.addTestCase();
				   
			   }
			   bp.waitForElement();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			   for(int i=0;i<3;i++)
			   {
				   tr.selectallTestCase();
				   tr.cloneTestCase();
				   bp.waitForElement();
				   bp.waitForElement();
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

	@Given("^launch test planning create a cycle C One add phase assign to anyone$")
	public void launch_test_planning_create_a_cycle_C_One_add_phase_assign_to_anyone() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 43, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
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

	@Then("^Launch test execution execute test cases to different status$")
	public void launch_test_execution_execute_test_cases_to_different_status() throws Throwable 
	{
		try
		{
	    rp.clickOnTestExecution();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    String cyclename1[]=new String[3];
	    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
		cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 43, 0);
		actual[40]=tr.navigateToNode(cyclename1[0],cyclename1);
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
	    //status cuctom status
	    int tcNo11=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 11, 0);
	    String statusType6=Excel_Lib.getData(INPUT_PATH_4, "status", 6, 0);
	    epp.executeStatus(tcNo11, statusType6);    
	    bp.waitForElement();
	    int tcNo12=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 12, 0);
	    epp.executeStatus(tcNo12, statusType6);
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

	@Then("^Launch test planning create a free form phase Launch Add testcase and launch Other cycles$")
	public void launch_test_planning_create_a_free_form_phase_Launch_Add_testcase_and_launch_Other_cycles() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 4);
			tl.createFreeFormPhase(freeFormName);
			bp.waitForElement();
			
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 4);
			actual[40]=tl.navigateToCycle(freeFormName1);
			bp.waitForElement();
			
//			tl.clickOnAddTestcasesToFreeForm();
//			bp.waitForElement();
//			
//			 tl.launchOtherCycles();
//			   bp.waitForElement();
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

	@Then("^search for cycle/phase filter by status pass search select testcases add to free form phase$")
	public void search_for_cycle_phase_filter_by_status_pass_search_select_testcases_add_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			 tl.launchOtherCycles();
			   bp.waitForElement();
			   
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
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

	@Then("^search for cycle/phase filter by status fail search select testcases add to free form phase$")
	public void search_for_cycle_phase_filter_by_status_fail_search_select_testcases_add_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			 tl.launchOtherCycles();
			   bp.waitForElement();
			   
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 2, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
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

	@Then("^search for cycle/phase filter by status wip search select testcases add to free form phase$")
	public void search_for_cycle_phase_filter_by_status_wip_search_select_testcases_add_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			 tl.launchOtherCycles();
			   bp.waitForElement();
			   
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
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

	@Then("^search for cycle/phase filter by status blocked search select testcases add to free form phase$")
	public void search_for_cycle_phase_filter_by_status_blocked_search_select_testcases_add_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			 tl.launchOtherCycles();
			   bp.waitForElement();
			   
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
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

	@Then("^search for cycle/phase filter by status custom status  search select testcases add to free form phase$")
	public void search_for_cycle_phase_filter_by_status_custom_status_search_select_testcases_add_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			 tl.launchOtherCycles();
			   bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
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

	@Then("^search for cycle/phase filter by status Not executed  search select testcases add to free form phase$")
	public void search_for_cycle_phase_filter_by_status_Not_executed_search_select_testcases_add_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			 tl.launchOtherCycles();
			   bp.waitForElement();
			   
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 33, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 6, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
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

	@Then("^Should be able to filter by execution status and add testcases to free form phase$")
	public void should_be_able_to_filter_by_execution_status_and_add_testcases_to_free_form_phase() throws Throwable 
	{
	    try
	    {
	    	 tl.validateAddtestcaesToFreeForm();
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
}
