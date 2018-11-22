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

public class TestExecution_878820 extends LaunchBrowser {
	
	 BasePage bp;
	 ProjectPage pp;
	 ReleasePage rp;
	 TestRepositoryPage tr;
	 CreateTestCasePage ctc;
	 ExportPage epp;
	 TestPlanningPage tp;
	 ExecutionPage ep;
	 LaunchBrowser lb=new LaunchBrowser();
	 String filename="TestExecution_878820";
	 boolean actual[]=new boolean[48];
	 SoftAssert soft=new SoftAssert();
	 
	@Given("^Lead is in TestRepository of normal_Project$")
	public void lead_is_in_TestRepository_of_normal_Project() throws Throwable {
		try 
		   {
			bp=new BasePage();
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[0]=pp.selectProject(Project);
			actual[1]=pp.selectRelease(Release);
			actual[2]=rp.clickOnTestRep();
			
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

	@When("^Add Phase and add two systems to Phase$")
	public void add_Phase_and_add_two_systems_to_Phase() throws Throwable {
		try 
		   {
			tr=new TestRepositoryPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 1);
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
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 4);
			String s1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 5);
			actual[6]=tr.addNode(system1, s1_Desc);
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			actual[7]=tr.selectPhase(Phase);
			bp.waitForElement();
			String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 22, 4);
			String s2_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 22, 5);
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

	@When("^Add few testcases without stepDetails and few testcases with stepDetails to phase$")
	public void add_few_testcases_without_stepDetails_and_few_testcases_with_stepDetails_to_phase() throws Throwable {
		try 
		   {
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tr.doubleClickOnRelease(Release);
			ctc=new CreateTestCasePage(driver);
			epp=new ExportPage(driver);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			actual[9]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[10]=tr.addTestCase();
			bp.waitForElement();
			actual[11]=tr.clickOnDetails();
			bp.waitForElement();
			String []stepDetails1=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
			actual[12]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[13]=tr.clickOnList();
			bp.waitForElement();
			actual[14]=tr.addTestCase();
			bp.waitForElement();
			String [] tcno=new String[1];
			tcno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
			actual[15]=epp.selectMultipleTestCaseFromGrid(tcno);
			bp.waitForElement();
			actual[16]=tr.clickOnDetails();
			bp.waitForElement();
			String []stepDetails2=new String[3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
			actual[17]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[18]=tr.clickOnList();
			bp.waitForElement();
			actual[19]=epp.selectMultipleTestCaseFromGrid(tcno);
			bp.waitForElement();
			actual[20]=tr.addTestCase();
			bp.waitForElement();
			actual[21]=tr.addTestCase();
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

	@When("^Launch TestPlanning and create new Cycle$")
	public void launch_TestPlanning_and_create_new_Cycle() throws Throwable {
		try 
		   {
			tp=new TestPlanningPage(driver);
			actual[22]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[23]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 15, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 0);
			String environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[24]=tp.CreateCycle(cycle, Build, environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date",1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[25]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[26]=tp.saveTestCycle();
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

	@When("^Add phase to created cycle and select Assign individually using BulkAssignment$")
	public void add_phase_to_created_cycle_and_select_Assign_individually_using_BulkAssignment() throws Throwable {
		try 
		   {
			String cycle[]=new String [1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 15, 0);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			actual[27]=tp.navigateToCycle(cycle);
			actual[28]=tp.addPhaseToCycle(Phase);
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 3,0 );
			actual[29]=tp.bulkAssignment(Bulk_type);
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

	@When("^Assign Testcases to Lead by Individual assignment$")
	public void assign_Testcases_to_Lead_by_Individual_assignment() throws Throwable {
		try 
		   {
			String [] Phase=new String[1];
			Phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			actual[30]=tp.navigateToCycle(Phase);
			int [] tcno=new int[4];
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			for (int i=0;i<=tcno.length-1;i++)
			{
				int j=i+1;
				tcno[i]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", j, 0);
				
			}
			actual[31]=tp.individualAssinTo(tcno, Assignee);
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

	@When("^Launch TestExecution and Enable the version to make it visible in the datagrid of the TCE$")
	public void launch_TestExecution_and_Enable_the_version_to_make_it_visible_in_the_datagrid_of_the_TCE() throws Throwable {
		try 
		   {
			ep=new ExecutionPage(driver);
			actual[32]=rp.clickOnTestExecution();
			bp.waitForElement();
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 15, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			actual[33]=tp.navigateToCycle(cycle);
			String sortName[]=new String[1];
			sortName[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 7);
			actual[34]=ep.sort(sortName);
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

	@Then("^Verion should be visible in datagrid of TCE$")
	public void verion_should_be_visible_in_datagrid_of_TCE() throws Throwable {
		try 
		   {
			String sortName[]=new String[1];
			sortName[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 7);
			actual[35]=ep.validateSort(sortName);
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

	@When("^Execute the  status of testcases,which has only stepdetails and check the version$")
	public void execute_the_status_of_testcases_which_has_only_stepdetails_and_check_the_version() throws Throwable {
		try 
		   {
			int [] tcno1=new int[1];
			tcno1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String status1=Excel_Lib.getData(INPUT_PATH_5,"Execution" ,1, 2);
			actual[36]=ep.changeStatusOfTestCases(tcno1, status1);
			bp.waitForElement();
			int [] tcno2=new int[1];
			tcno2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
			String status2=Excel_Lib.getData(INPUT_PATH_5,"Execution" ,2, 2);
			actual[37]=ep.changeStatusOfTestCases(tcno2, status2);
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

	@Then("^Version should be visible across the testcases$")
	public void version_should_be_visible_across_the_testcases() throws Throwable {
		try 
		   {
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			int testcase[]=new int[2];
			for (int i=0;i<=testcase.length-1;i++)
			{
			testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", i+1, 0);
			}
			String version=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 8);
			actual[38]=ep.checkVersionInList(testcase, version);
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] release=new String[1];
			release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(release);
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

	@When("^launch TestRepository and delete stepdeatils of a executed testcase$")
	public void launch_TestRepository_and_delete_stepdeatils_of_a_executed_testcase() throws Throwable {
		try 
		   {
			actual[39]=rp.clickOnTestRep();
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			String Phase =UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			actual[40]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			actual[41]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[42]=tr.clickOnDetails();
			bp.waitForElement();
			String testStepNo=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[43]=ctc.deleteTestSteps(testStepNo);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
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

	@When("^Launch TestExecution and Execute testcase of modified stepdetails and check the version$")
	public void launch_TestExecution_and_Execute_testcase_of_modified_stepdetails_and_check_the_version() throws Throwable {
		try 
		   {
			actual[44]=rp.clickOnTestExecution();
			String cycle[]=new String[2];
			String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 15, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 0);
			actual[45]=tr.navigateToNode(releaseName, cycle);
			bp.waitForElement();
			int testcase[]=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
			actual[46]=ep.changeStatusOfTestCases(testcase, status);
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

	@Then("^version should be visible$")
	public void version_should_be_visible() throws Throwable {
		try 
		   {
			int testcase[]=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1, 0);
			String version=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 8);
			actual[47]=ep.checkVersionInList(testcase, version);
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			for (int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
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
