package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;
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

public class Retrieve_868194 extends LaunchBrowser
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
	 String filename="Retrieve_868194";
	@Given("^User in repository Page to create phase and add testcases$")
	public void user_in_repository_Page_to_create_phase_and_add_testcases() throws Throwable 
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

	@Given("^Create Phase and add hundred testcases$")
	public void create_Phase_and_add_hundred_testcases() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 40, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 40, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 40, 0);
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

	@When("^launch testplanning create cycle add phase to cycle and assign to Anyone assign few Testcases to Manager/lead/Tester$")
	public void launch_testplanning_create_cycle_add_phase_to_cycle_and_assign_to_Anyone_assign_few_Testcases_to_Manager_lead_Tester() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 40, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   
		   String cyclename2[]=new String[1];
		   cyclename2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 40, 0);
			actual[40]=tl.navigateToCycle(cyclename2);
			bp.waitForElement();
			
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
			int TestcaseNo[]=new int[1];
			TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			tl.individualAssinTo(TestcaseNo, Assignee);
			bp.waitForElement();
			String Assignee1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			int TestcaseNo1[]=new int[1];
			TestcaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
			tl.individualAssinTo(TestcaseNo1, Assignee1);
			bp.waitForElement();
			String Assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			int TestcaseNo2[]=new int[1];
			TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
			tl.individualAssinTo(TestcaseNo2, Assignee2);
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

	@When("^launch testplanning Add phase again donot assign to creator of testcases$")
	public void launch_testplanning_Add_phase_again_donot_assign_to_creator_of_testcases() throws Throwable 
	{
		try
		{
		actual[35]=rp.clickOnTestPlanning();
		bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 40, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
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

	@Then("^launch test execution execute few testcases in that two phases$")
	public void launch_test_execution_execute_few_testcases_in_that_two_phases() throws Throwable 
	{
		try
		{
	    rp.clickOnTestExecution();
	    bp.waitForElement();
	    bp.waitForElement();
	    String cyclename1[]=new String[3];
	    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 0);
		cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 40, 0);
		actual[40]=tr.navigateToNode(cyclename1[0], cyclename1);
		bp.waitForElement();
	    epp=new ExecutionPage(driver);
	    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
	    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
	    epp.executeStatus(tcNo, statusType);
	    bp.waitForElement();
	    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
	    epp.executeStatus(tcNo2, statusType);  
	    bp.waitForElement();
	    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
	    epp.executeStatus(tcNo3, statusType);
	    bp.waitForElement();
	    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 40, 0);
	   // driver.findElement(By.xpath(tl.phase1+phase+tl.phase2)).click();
	    bp.waitForElement();
	    epp=new ExecutionPage(driver);
	    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
	    epp.executeStatus(tcNo4, statusType);
	    bp.waitForElement();
	    int tcNo5=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
	    epp.executeStatus(tcNo5, statusType);    
	    bp.waitForElement();
	    int tcNo6=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
	    epp.executeStatus(tcNo6, statusType);
	    bp.waitForElement();
	    
	    //tl.goBackToCycle();
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

	@When("^launch testplanning create new cycle and create Freeform and save$")
	public void launch_testplanning_create_new_cycle_and_create_Freeform_and_save() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
			bp.waitForElement();
		
			   tl=new TestPlanningPage(driver);
			   actual[36]=tl.clickOnAddTestCycleSymbol();
			   bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 5);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 5);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();


			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 4);
			tl.createFreeFormPhase(freeFormName);
			bp.waitForElement();
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 4);
			actual[40]=tl.navigateToCycle(freeFormName1);
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

	@When("^click on Add testcase window launch other cycles$")
	public void click_on_Add_testcase_window_launch_other_cycles() throws Throwable 
	{
		try
		{
		tl.clickOnAddTestcasesToFreeForm();
		bp.waitForElement();
		
		 tl.launchOtherCycles();
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

	@When("^search for cycle which all testcases are assigned to Anyone and Save$")
	public void search_for_cycle_which_all_testcases_are_assigned_to_Anyone_and_Save() throws Throwable 
	{
		try
		{
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 30, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		    tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
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

	@When("^search for cycle which few testcases are assigned and Save$")
	public void search_for_cycle_which_few_testcases_are_assigned_and_Save() throws Throwable 
	{
		try
		{
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 2, 0);
		    tl.selectPhasebyIndexInSearch(index);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		    tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
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

	@Then("^Should retrieve testcases from another cycle, if same phase was scheduled multiple times in same cycle$")
	public void should_retrieve_testcases_from_another_cycle_if_same_phase_was_scheduled_multiple_times_in_same_cycle() throws Throwable 
	{
	   try
	   {
		   tl.validateRetrieveTestcases();
		   bp.waitForElement();
		   tl.closeFreeFormPage();
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
