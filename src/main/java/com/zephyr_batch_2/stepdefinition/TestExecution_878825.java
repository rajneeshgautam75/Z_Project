package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878825 extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();
	  BasePage bp;
	  ProjectPage pp;
	  ReleasePage rp;
	  TestRepositoryPage tr;      
	  CreateTestCasePage ctc;
	  ExportPage epp;
	  TestPlanningPage tp;
	  ExecutionPage ep;
	  boolean actual[]=new boolean[75];
	  SoftAssert soft=new SoftAssert(); 
	  String filename="TestExecution_878825";
	@Given("^Lead is in Testrepository Page of NormalProject$")
	public void lead_is_in_Testrepository_Page_of_NormalProject() throws Throwable {
		try
		{
	    pp=new ProjectPage(driver);
	    bp=new BasePage();
	    rp=new ReleasePage(driver);     
	    String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
		String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		actual[0]=pp.selectProject(Project);
		actual[1]=pp.selectRelease(Release);
		bp.waitForElement();
		actual[2]=rp.clickOnTestRep();
		bp.waitForElement();
		  }
		catch(Exception e)
		{ lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@When("^Add phase and two system nodes to phase$")
	public void add_phase_and_two_system_nodes_to_phase() throws Throwable {
		try
		{
		tr=new TestRepositoryPage(driver);
		String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 1);
		actual[3]=tr.doubleClickOnRelease(Release);
		bp.waitForElement();
		actual[4]=tr.addNode(Phase, Desc);
		bp.waitForElement();
	    String[] phase=new String[1];
		phase[0]=Phase;
		bp.waitForElement();
	    tr.navigateToNode(Release, phase);
		bp.waitForElement();
		actual[5]=tr.selectPhase(Phase);
		bp.waitForElement();
		String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 4);
		String s1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 5);
		actual[6]=tr.addNode(system1, s1_Desc);
		bp.waitForElement();
		tr.clickOnRelease(Release);
		bp.waitForElement();
		actual[7]=tr.selectPhase(Phase);
		bp.waitForElement();
		String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 24, 4);
		String s2_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 5);
		actual[8]=tr.addNode(system2, s2_Desc);
		bp.waitForElement();
		actual[9]=tr.selectPhase(Phase);
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

	@When("^Add ten testcases with test steps to each node$")
	public void add_ten_testcases_with_test_steps_to_each_node() throws Throwable {
		try
		{
			ctc=new CreateTestCasePage(driver);
			epp=new ExportPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation=new String[1];
			 navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			 tr.navigateToNode(Release, navigation);
			 bp.waitForElement();
			actual[10]=tr.addTestCase();
			bp.waitForElement();
			actual[11]=tr.clickOnDetails();
			bp.waitForElement();
			String stepDetails1[]=new String[3];
			for(int i=0;i<=stepDetails1.length-1;i++)
			{
			stepDetails1[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1,i);
			}
			actual[12]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[13]=tr.clickOnList();
			bp.waitForElement();
			actual[14]=tr.addTestCase();
			bp.waitForElement();
			String tcno[]=new String[1];
			tcno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
			actual[15]=epp.selectMultipleTestCaseFromGrid(tcno);
			bp.waitForElement();
			actual[16]=tr.clickOnDetails();
			bp.waitForElement();
			bp.waitForElement();
			String stepDetails2[]=new String[3];
			for(int i=0;i<=stepDetails1.length-1;i++)
			{
			stepDetails2[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2,i);
			}
			actual[17]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[18]=tr.clickOnList();
			bp.waitForElement();
			actual[19]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
				actual[19]=tr.cloneTestCase();
			}
			bp.waitForElement();
			
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 4);
			
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation61=new String[2];
			 navigation61[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			 navigation61[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 4);
			 tr.navigateToNode(Release, navigation61);
			bp.waitForElement();
			actual[20]=tr.selectPhase(system1);
			bp.waitForElement();
	        actual[21]=tr.addTestCase();
	        bp.waitForElement();
			actual[22]=tr.clickOnDetails();
			bp.waitForElement();
			actual[23]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[24]=tr.clickOnList();
			bp.waitForElement();
			actual[25]=tr.addTestCase();
			bp.waitForElement();
			actual[26]=epp.selectMultipleTestCaseFromGrid(tcno);
			bp.waitForElement();
			actual[27]=tr.clickOnDetails();
			bp.waitForElement();
			actual[28]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[29]=tr.clickOnList();
			bp.waitForElement();
			actual[30]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
				actual[31]=tr.cloneTestCase();
			}
			bp.waitForElement();
	        String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 24, 4);
	        tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation62=new String[2];
			 navigation62[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			 navigation62[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 24, 4);
			 tr.navigateToNode(Release, navigation62);
			bp.waitForElement();
			actual[32]=tr.selectPhase(system2);
			bp.waitForElement();
			actual[33]=tr.addTestCase();
			bp.waitForElement();
			actual[34]=tr.clickOnDetails();
			bp.waitForElement();
			actual[35]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[36]=tr.clickOnList();
			bp.waitForElement();
			actual[37]=tr.addTestCase();
			bp.waitForElement();
			actual[38]=epp.selectMultipleTestCaseFromGrid(tcno);
			bp.waitForElement();
			actual[39]=tr.clickOnDetails();
			bp.waitForElement();
			actual[40]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[41]=tr.clickOnList();
			bp.waitForElement();
			actual[42]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
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

	@When("^Launch Testplanning and Create new cycle$")
	public void launch_Testplanning_and_Create_new_cycle() throws Throwable {
		try
		{
			tp=new TestPlanningPage(driver);
			actual[44]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[45]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 16, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle" , 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 100, 100);
			actual[46]=tp.CreateCycle(cycle, Build, environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
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

	@When("^Add phase to created cycle$")
	public void add_phase_to_created_cycle() throws Throwable {
		try
		{
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 16, 0);
			actual[49]=tp.navigateToCycle(cycle);
			bp.waitForElement();
		    String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			actual[50]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			actual[51]=tp.cancelBulkAssign();
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

	@When("^Launch Testplanning and create another cycle$")
	public void launch_Testplanning_and_create_another_cycle() throws Throwable {
		try
		{
			actual[52]=tp.goBackToCycle();
			//actual[52]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[53]=tp.clickOnAddTestCycleSymbol();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 17, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle" , 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 100, 100);
			actual[54]=tp.CreateCycle(cycle, Build, environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[55]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[56]=tp.saveTestCycle();
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

	@When("^Add phase to newly created cycle and assign testcases to creator$")
	public void add_phase_to_newly_created_cycle_and_assign_testcases_to_creator() throws Throwable {
		try
		{
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 17, 0);
			actual[57]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			actual[58]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
			actual[59]=tp.bulkAssignment(Bulk_type);
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

	@When("^Launch TestPlanning, Edit Phase and Select one node$")
	public void launch_TestPlanning_Edit_Phase_and_Select_one_node() throws Throwable {
		try
		{
			actual[60]=tp.goBackToCycle();
			//actual[60]=rp.clickOnTestPlanning();
			bp.waitForElement();
			String Phase[]=new String [2];
			Phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 17, 0);
			Phase[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 17, 0);
			actual[61]=tp.doubleClickOnCycle(cycle);
			bp.waitForElement();
			actual[62]=tp.navigateToCycle(Phase);
			bp.waitForElement();
			tp.options.click();
			bp.waitForElement();
			tp.edit.click();
			bp.waitForElement();
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 2, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 2, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 2, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 2, 5));
			actual[63]=tp.editStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[64]=tp.saveTestCycle();
			bp.waitForElement();
			bp.waitForElement();
			actual[65]=tp.doubleClickOnCycle(cycle);
			bp.waitForElement();
			bp.waitForElement();
			actual[66]=tp.navigateToCycle(Phase);
			bp.waitForElement();
			bp.waitForElement();
		    actual[67]=tp.assignPhase();
			bp.waitForElement();
			bp.waitForElement();
			actual[68]=tp.cancelBulkAssign();
			String system1[]=new String[2];
			system1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			system1[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 4);
			actual[69]=tp.navigateToCycle(system1);
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

	@When("^Assign Testcases using Bulk Assignment window from Lead to Custom user$")
	public void assign_Testcases_using_Bulk_Assignment_window_from_Lead_to_Custom_user() throws Throwable {
		try
		{
			
			actual[70]=tp.bulkAssignTestcasesSelectedFolder();
			String from=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
			String to=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User3");
			String Check=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 0, 1);
			actual[71]=tp.assignAllAssignedNotExecuted(from, to, Check);
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

	@Then("^Testcases of selected node should be assigned to Custom user$")
	public void testcases_of_selected_node_should_be_assigned_to_Custom_user() throws Throwable {
		try
		{
			int tcno[]=new int[10];
			for(int i=0;i<=tcno.length-1;i++)
			{
				tcno[i]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", i, 0);
			}
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[72]=tp.validateAllAssigned(tcno, assignee);
			bp.waitForElement();
			//rp.clickOnTestPlanning();
			tp.goBackToCycle();
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

	@Then("^Launch TestExecution and navigate to node$")
	public void launch_TestExecution_and_navigate_to_node() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			actual[73]=rp.clickOnTestExecution();
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 17, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
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

	@Then("^check for Assigned cycle$")
	public void check_for_Assigned_cycle() throws Throwable {
		try
		{
			String cycle[]=new String[4];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 17, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 0);
			cycle[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 23, 4);
			actual[74]=ep.validateExecutions(cycle);
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Acual["+k+"]="+actual[k]);
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
