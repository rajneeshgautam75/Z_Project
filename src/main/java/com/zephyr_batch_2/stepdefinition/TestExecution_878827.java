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

public class TestExecution_878827 extends LaunchBrowser{
	LaunchBrowser lb=new LaunchBrowser();
	BasePage bp;
	
	 LoginPage lp;
	 ProjectPage pp;
	 ReleasePage rp;
	 TestRepositoryPage tr;
	 CreateTestCasePage ctc;
	 ExportPage epp;
	 TestPlanningPage tp;
	 ExecutionPage ep;
	 
	 boolean actual[]=new boolean[71];
	 SoftAssert soft=new SoftAssert();
	
	 String filename="TestExecution_878827";
	
	
	@Given("^Lead is in TestRepositoryPage of NormalProject$")
	public void lead_is_in_TestRepositoryPage_of_NormalProject() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			 pp.clickOnLogout();
		     bp.waitForElement();
		   lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		 lp.enterUname(Uname);
		 lp.enterPass(Pass);
		 lp.clickOnLogin();
		 bp.waitForElement();
			
			
			actual[0]=pp.selectProject(Project);
			actual[1]=pp.selectRelease(Release);
			bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
			bp.waitForElement();
		     }
		catch(Exception e)
		{
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^create a new phase and add two systems to a created phase$")
	public void create_a_new_phase_and_add_two_systems_to_a_created_phase() throws Throwable {
		try
		{
			ctc=new CreateTestCasePage(driver);
			tr=new TestRepositoryPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 1);
			actual[4]=tr.addNode(Phase, Desc);
			bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=Phase;
			bp.waitForElement();
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();
			actual[5]=tr.selectPhase(Phase);
			bp.waitForElement();
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 4);
			String s1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 5);
			actual[6]=tr.addNode(system1, s1_Desc);
			bp.waitForElement();
			tr.clickOnRelease(Release);
			bp.waitForElement();
			actual[7]=tr.selectPhase(Phase);
			bp.waitForElement();
			String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 4);
			String s2_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 5);
			actual[8]=tr.addNode(system2, s2_Desc);
			bp.waitForElement();
		     }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^Add ten testcases with teststeps to each node$")
	public void add_ten_testcases_with_teststeps_to_each_node() throws Throwable {
		try
		{   epp=new ExportPage(driver);
		    String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		    tr.clickOnRelease(Release);
		    bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 0);
			actual[9]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[10]=tr.addTestCase();
			bp.waitForElement();
			actual[11]=tr.clickOnDetails();
			bp.waitForElement();
			String stepDetails1[]=new String [3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
			actual[12]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[13]=tr.clickOnList();
			bp.waitForElement();
			actual[14]=tr.addTestCase();
			bp.waitForElement();
			actual[15]=tr.clickOnDetails();
			String []tcno2 =new String [1];
			tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 2, 0));
			actual[16]=epp.selectMultipleTestCaseFromGrid(tcno2);
			bp.waitForElement();
			
			bp.waitForElement();
			String stepDetails2[]=new String [3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
			actual[17]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[18]=tr.clickOnList();
			bp.waitForElement();
			actual[19]=tr.selectallTestCase();
			bp.waitForElement();
			int length=Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 4, 0);
			for (int i=0;i<=length-1;i++)
			{
				actual[20]=tr.cloneTestCase();
			}
			  bp.waitForElement();
			    String[] phase=new String[2];
				phase[0]=Phase;
				phase[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 4);
				bp.waitForElement();
			    tr.navigateToNode(Release, phase);
				bp.waitForElement();
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 4);
			actual[21]=tr.selectPhase(system1);
			bp.waitForElement();
			actual[22]=tr.addTestCase();
			bp.waitForElement();
			actual[23]=tr.clickOnDetails();
			bp.waitForElement();
		    actual[24]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[25]=tr.clickOnList();
			bp.waitForElement();
			actual[26]=tr.addTestCase();
			bp.waitForElement();
			actual[27]=tr.clickOnDetails();
			bp.waitForElement();
		    actual[28]=epp.selectMultipleTestCaseFromGrid(tcno2);
			bp.waitForElement();
			
			
			actual[29]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[30]=tr.clickOnList();
			bp.waitForElement();
			actual[31]=tr.selectallTestCase();
			bp.waitForElement();
			for (int j=0;j<=length-1;j++)
			{
				actual[32]=tr.cloneTestCase();
			}
			 bp.waitForElement();
			    String[] phase1=new String[2];
				phase1[0]=Phase;
				phase1[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 4);
				bp.waitForElement();
			    tr.navigateToNode(Release, phase1);
				bp.waitForElement();
			String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 4);
			actual[33]=tr.selectPhase(system2);
			bp.waitForElement();
			actual[34]=tr.addTestCase();
			bp.waitForElement();
			actual[35]=tr.clickOnDetails();
			bp.waitForElement();
			actual[36]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[37]=tr.clickOnList();
			bp.waitForElement();
			actual[38]=tr.addTestCase();
			bp.waitForElement();
			actual[39]=tr.clickOnDetails();
			bp.waitForElement();
			actual[40]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[41]=tr.clickOnList();
			bp.waitForElement();
			actual[42]=tr.selectallTestCase();
			bp.waitForElement();
			for (int k=0;k<=length-1;k++)
			{
				actual[43]=tr.cloneTestCase();
			}
			bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			
			 }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^Launch Test Planning Page and create new cycle$")
	public void launch_Test_Planning_Page_and_create_new_cycle() throws Throwable {
		try
		{
	       tp=new TestPlanningPage(driver);
	       actual[44]=rp.clickOnTestPlanning();
	       bp.waitForElement();
	       actual[45]=tp.clickOnAddTestCycleSymbol();
	       bp.waitForElement();
	       String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 13, 0);
	       String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
	       String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
	       String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
	       actual[46]=tp.CreateCycle(cycle, Build, Environment, hide);
	       String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
	       String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
	       String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
	       String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
	       String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
	       String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
	       actual[47]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	       actual[48]=tp.saveTestCycle();
	       bp.waitForElement();
	      
		     }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }
	
	@When("^Add phase to created cycle and assign testcases to creator$")
	public void add_phase_to_created_cycle_and_assign_testcases_to_creator() throws Throwable {
		try
		{    String cycle[]=new String[1];
			 cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 13, 0);
		     actual[49]=tp.navigateToCycle(cycle);
		     bp.waitForElement();
			 String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 0);
			 actual[50]=tp.addPhaseToCycle(Phase);
			 bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
		     actual[51]=tp.bulkAssignment(Bulk_type);
		     bp.waitForElement();
		     //rp.clickOnTestPlanning();
		     tp.goBackToCycle();
			 bp.waitForElement();
		     }
		catch(Exception e)
		{  lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^Launch Test Execution page and navigate to nodes$")
	public void launch_Test_Execution_page_and_navigate_to_nodes() throws Throwable {
		try
		{ 
			ep=new ExecutionPage(driver);
			actual[1]=rp.clickOnTestExecution();
			bp.waitForElement();
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 13, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 0);
			actual[52]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 4);
			actual[53]=tr.selectPhase(system2);
			bp.waitForElement();

			 }
		catch(Exception e)
		{  lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }
	
	@When("^Execute testcases to Pass/Fail$")
	public void execute_testcases_to_Pass_Fail() throws Throwable {
		try
		{
			actual[54]=ep.selectAndDeselectAllTestCase();
			String status12=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[55]=ep.changeMultiSelectedStatus(status12);
			bp.waitForElement();
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 4);
			actual[56]=tr.selectPhase(system1);
			bp.waitForElement();
			actual[57]=ep.selectAndDeselectAllTestCase();
			String status11=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
			actual[58]=ep.changeMultiSelectedStatus(status11);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 0);
			actual[59]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[60]=ep.selectAndDeselectAllTestCase();
			String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[61]=ep.changeMultiSelectedStatus(status1);
			bp.waitForElement();
			
		     }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^click on \\[D\\] button, search a defect and link a defect$")
	public void click_on_D_button_search_a_defect_and_link_a_defect() throws Throwable {
		try
		{  
			String tcno1[]=new String [1];
			tcno1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[62]=ep.selectMultipleTestCaseFromExecutionGrid(tcno1);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			actual[63]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
			actual[64]=ep.linkDefect(defectId);
			bp.waitForElement();
			bp.waitForElement();
		     }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@Then("^Defect should be linked to selected testcase$")
	public void defect_should_be_linked_to_selected_testcase() throws Throwable {
		try
		{    
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
			actual[65]=ep.validateLinkedDefect(testcase1, defectId);
			bp.waitForElement();
		     }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^Refresh the page and Launch Test Execution$")
	public void refresh_the_page_and_Launch_Test_Execution() throws Throwable {
		try
		{
			driver.navigate().refresh();
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 13, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 0);
			actual[66]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			
			 }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@When("^Search that testcase which is Linked to defect and De-Link the defect by clicking on Delete button$")
	public void search_that_testcase_which_is_Linked_to_defect_and_De_Link_the_defect_by_clicking_on_Delete_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			String tcno1[]=new String [1];
			tcno1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[67]=ep.selectMultipleTestCaseFromExecutionGrid(tcno1);
			bp.waitForElement();
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			actual[68]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			int testcase[]=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			actual[69]=ep.deleteDefect(testcase);
			bp.waitForElement();
			
		 }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }

	@Then("^Selected testcase defect should be De-linked$")
	public void selected_testcase_defect_should_be_De_linked() throws Throwable {
		try
		{
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
			actual[70]=ep.validateLinkedDefect(testcase1, defectId);
			bp.waitForElement();
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
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	          }


}
