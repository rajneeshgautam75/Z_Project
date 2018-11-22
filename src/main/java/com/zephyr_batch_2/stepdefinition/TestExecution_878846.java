package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.pom.ExecutionPage_POM;
import com.zephyr.reusablemethods.BasePage;
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

public class TestExecution_878846 extends LaunchBrowser {
	
	 BasePage bp;
	 ProjectPage pp;
	 ReleasePage rp;
	 TestRepositoryPage tr;
	 ExportPage rpp;
	 TestPlanningPage tp;
	 ExecutionPage ep;
	 ExecutionPage_POM epp;
	 LoginPage lp;
	 boolean actual[]=new boolean[29];
	 SoftAssert soft=new SoftAssert();
	 
	
	@Given("^Lead is in Test Repository Page of Normal Project$")
	public void lead_is_in_Test_Repository_Page_of_Normal_Project() throws Throwable {
		try 
		{    
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			
			pp=new ProjectPage(driver);
		     pp.clickOnLogout();
		     bp.waitForElement();
		lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		 lp.enterUname(Uname);
		 lp.enterPass(Pass);
		 lp.clickOnLogin();
		 bp.waitForElement();
			String Project =Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[0]=pp.selectProject(Project);
			actual[1]=pp.selectRelease(Release);
			bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
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

	@When("^Add a phase and add testcases to created phase$")
	public void add_a_phase_and_add_testcases_to_created_phase() throws Throwable {
		try 
		{ 
			tr=new TestRepositoryPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1,0);
			actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String Phase=UNIQUE +Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 15,1);
			actual[4]=tr.addNode(Phase, Desc);
			bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=Phase;
			bp.waitForElement();
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();
			actual[5]= tr.selectPhase(Phase);
			bp.waitForElement();
			actual[6]=tr.addTestCase();
			bp.waitForElement();
			actual[7]=tr.addTestCase();
			bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
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

	@When("^Launch TestPlanning and create new cycle$")
	public void launch_TestPlanning_and_create_new_cycle() throws Throwable {
		try 
		{
			
		 tp=new TestPlanningPage(driver);
		 actual[8]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 actual[9]=tp.clickOnAddTestCycleSymbol();
		 String cycle=UNIQUE +Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 11, 0);
		 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		 String Hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		 actual[10]=tp.CreateCycle(cycle, Build, Environment, Hide);
		 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,2));
		 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,5));
		 actual[11]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		 actual[12]=tp.saveTestCycle();
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

	@When("^add phase to created cycle and assign testcases to creator$")
	public void add_phase_to_created_cycle_and_assign_testcases_to_creator() throws Throwable {
		try 
		{
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 11, 0);
			actual[13]=tp.navigateToCycle(cycle);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 0);
			actual[14]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
			actual[15]=tp.bulkAssignment(Bulk_type);
			bp.waitForElement();
			//rp.clickOnTestPlanning();
			tp.goBackToCycle();
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

	@When("^Launch TestExecution Expand all nodes$")
	public void launch_TestExecution_Expand_all_nodes() throws Throwable {
		try 
		{
			ep=new ExecutionPage(driver);
			actual[16]=rp.clickOnTestExecution();
			bp.waitForElement();
			String cycle[]=new String [3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 11, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 0);
			actual[17]=tp.navigateToCycle(cycle);
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

	@When("^Select a testcase and change Execution status, add notes and click on save$")
	public void select_a_testcase_and_change_Execution_status_add_notes_and_click_on_save() throws Throwable {
		try 
		{   
			epp=new ExecutionPage_POM(driver);
			String testcase1[]=new String[1];
			testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[18]=ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			int testcase[]=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[19]=ep.changeStatusOfTestCases(testcase, status);
			bp.waitForElement();
			
			tr.clickOnDetails();
			String note=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1,5);
			actual[20]=ep.enterNotes(note);
			//epp.notesSave.click();
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

	@Then("^selected testcase Execution status should be changed and notes should be added$")
	public void selected_testcase_Execution_status_should_be_changed_and_notes_should_be_added() throws Throwable {
		try 
		{
			String testcase1[]=new String[1];
			testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[21]=ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
		   int tcno[]=new int[1];
		    tcno[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[22]=ep.ValidateStatusOfTestCases(tcno, status);
			bp.waitForElement();
			String note=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1,5);
			actual[23]=ep.validateNotes(note);
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

	@When("^Select another testcase and change Execution status, add notes and click on cancel$")
	public void select_another_testcase_and_change_Execution_status_add_notes_and_click_on_cancel() throws Throwable {
		try 
		{    
			tr.clickOnList();
			String tcno2[]=new String[1] ;
			  tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
		      actual[24]=ep.selectMultipleTestCaseFromExecutionGrid(tcno2);
		      bp.waitForElement();
		      int testcase2[]=new int[1];
		      testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
				String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
				actual[25]=ep.changeStatusOfTestCases(testcase2, status);
				bp.waitForElement();
				tr.clickOnDetails();
				
				String note=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1,5);
				actual[26]=ep.enterNotes(note);
				//epp.notesCancel.click();
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

	@Then("^Selected testcase Execution status should be changed and notes should not be added$")
	public void selected_testcase_Execution_status_should_be_changed_and_notes_should_not_be_added() throws Throwable {
		try 
		{
			String tcno2[]=new String[1];
			tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
			ep.selectMultipleTestCaseFromExecutionGrid(tcno2);
			bp.waitForElement();
			int tcno[]=new int[1];
		    tcno[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
			String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
			actual[27]=ep.ValidateStatusOfTestCases(tcno, status);
			bp.waitForElement();
			String note=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1,5);
			actual[28]=ep.validateNotes(note);
			bp.waitForElement();
			tr.clickOnList();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]=" + actual[k]);
				soft.assertEquals(actual[k], true);
				
			}
			soft.assertAll();
			
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

	

}
