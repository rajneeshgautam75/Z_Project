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

public class TestExecution_878816  extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;

	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage ep;
	ExportPage epp;
	String ad="TestExecution_878816";
	boolean []actual=new boolean[63];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in TestRepository page of normal project$")
	public void user_is_in_TestRepository_page_of_normal_project() throws Throwable {
		 try
		   {  
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",1,0);
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp= new ReleasePage(driver);
			   tr=new TestRepositoryPage(driver);
			  actual[0]=pp.selectProject(projectName);
			  actual[1]=pp.selectRelease(releaseName);
			  actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb.getScreenShot(ad);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
		    }

	@When("^User creates new phase and adds two system to phase$")
	public void user_creates_new_phase_and_adds_two_system_to_phase() throws Throwable {
		try
		{     
		     epp= new ExportPage(driver);
			 ctc=new CreateTestCasePage(driver);
		     String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		     String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 0);
		     String p_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 1);
		     actual[3]=tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     actual[4]= tr.addNode(p_Name1,p_Desc1);
		     bp.waitForElement();
			    String[] phase=new String[1];
				phase[0]=p_Name1;
				bp.waitForElement();
			    tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
		     tr.selectPhase(p_Name1);
		     bp.waitForElement();
		     String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 4);
		     String s_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 5);
		     actual[5]= tr.addNode(s_Name1,s_Desc1);
		     bp.waitForElement();
		     tr.clickOnRelease(releaseName);
		     bp.waitForElement();
		     actual[6]=tr.selectPhase(p_Name1);
		     bp.waitForElement();
		     String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 4);
		     String s_Desc2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 5);
		     actual[7]= tr.addNode(s_Name2,s_Desc2);
		     bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(ad);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}
	}
	@When("^User adds testcases with teststeps to phase in Test Repository$")
	public void user_adds_testcases_with_teststeps_to_phase_in_Test_Repository() throws Throwable {
		try{
			
		  String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 0);
		  actual[8]= tr.doubleClickOnRelease(releaseName);
		  String[] phase=new String[1];
		  phase[0]=p_Name1;
		  actual[9]=tr.navigateToNode(releaseName, phase);
		  bp.waitForElement();
		  actual[10]=tr.addTestCase();
		  bp.waitForElement();
		  String []testcaseNo1=new String[1];
		  testcaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0));
		  actual[11]=epp.selectMultipleTestCaseFromGrid(testcaseNo1);
		  bp.waitForElement();
		  actual[12]=tr.clickOnDetails();
		  bp.waitForElement();
					String[] stepDetails1=new String[3];
					stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
					stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
					stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
					actual[13]=ctc.enterTestCaseStepDetail(stepDetails1);
					bp.waitForElement();
					actual[14]=tr.clickOnList();
					bp.waitForElement();
					testcaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0));
					actual[15]=epp.selectMultipleTestCaseFromGrid(testcaseNo1);
					bp.waitForElement();
					actual[16]=tr.addTestCase();
					String []testcaseNo2=new String[1];
					testcaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
					actual[17]=epp.selectMultipleTestCaseFromGrid(testcaseNo2);
					bp.waitForElement();
					actual[18]=tr.clickOnDetails();
					bp.waitForElement();
					String[] stepDetails2=new String[3];
					stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 0);
					stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 1);
					stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 2);
					actual[19]=ctc.enterTestCaseStepDetail(stepDetails2);
					bp.waitForElement();
					actual[20]=tr.clickOnList();
					bp.waitForElement();
					testcaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
					actual[21]=epp.selectMultipleTestCaseFromGrid(testcaseNo2);
					bp.waitForElement();
					actual[22]=tr.addTestCase();
					bp.waitForElement();
					String []testcaseNo3=new String[1];
					testcaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
					actual[23]=epp.selectMultipleTestCaseFromGrid(testcaseNo3);
					bp.waitForElement();
					actual[24]=tr.clickOnDetails();
				    bp.waitForElement();
						String[] stepDetails3=new String[3];
						stepDetails3[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 0);
						stepDetails3[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 1);
						stepDetails3[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 2);
			             actual[25]=ctc.enterTestCaseStepDetail(stepDetails3);
						bp.waitForElement();
						actual[26]=tr.clickOnList();
						bp.waitForElement();
						testcaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
						actual[27]=epp.selectMultipleTestCaseFromGrid(testcaseNo3);
						bp.waitForElement();
						actual[28]=tr.addTestCase();
						bp.waitForElement();
						String []testcaseNo4=new String[1];
						testcaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
						actual[29]=epp.selectMultipleTestCaseFromGrid(testcaseNo4);
						bp.waitForElement();
						actual[30]=tr.clickOnDetails();
						bp.waitForElement();
						String[] stepDetails4=new String[3];
						stepDetails4[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 0);
						stepDetails4[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 1);
						stepDetails4[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 2);
						actual[31]=ctc.enterTestCaseStepDetail(stepDetails4);
						actual[32]=bp.waitForElement();
						actual[33]=tr.clickOnList();
						bp.waitForElement();
						testcaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
						actual[34]=epp.selectMultipleTestCaseFromGrid(testcaseNo4);
						actual[35]=bp.waitForElement();
						tr.doubleClickOnRelease(releaseName);
						bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
		    }

	@When("^User launch Test planning and creates new cycle$")
	public void user_launch_Test_planning_and_creates_new_cycle() throws Throwable {
	try {
		tp=new TestPlanningPage(driver);
		actual[36]=rp.clickOnTestPlanning();
		bp.waitForElement();
		String cyclename0 =UNIQUE + Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 5, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5,"Create cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		actual[37]=tp.clickOnAddTestCycleSymbol();
		actual[38]=tp.CreateCycle(cyclename0, Build, Environment, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[39]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[40]=tp.saveTestCycle();
		bp.waitForElement();
	}
	catch(Exception e){  lb.getScreenShot(ad);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
		
	}

	@When("^User adds phase to created cycle$")
	public void user_adds_phase_to_created_cycle() throws Throwable {
	try {
			String cyclename[]=new String[1];
			cyclename[0] =UNIQUE + Excel_Lib.getData(INPUT_PATH_5,"Create cycle", 5, 0);
			actual[41]=tp.navigateToCycle(cyclename);
			String Phase =UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 0);
			actual[42]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			actual[43]=tp.cancelBulkAssign();
			bp.waitForElement();
		    }
		catch (Exception e){  lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
		    }

	@When("^User Assign testcases under phase to lead by individual assignment$")
	public void user_Assign_testcases_under_phase_to_lead_by_individual_assignment() throws Throwable {
		try{
			String [] Phase=new String[1];
			 Phase[0] =UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 0);
			actual[44]=tp.navigateToCycle(Phase);
			int []tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0);
			actual[45]=tp.selectSingleMultipleTestcase(tcNo1);
			int []testcaseNo1=new int[1];
			testcaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0,0);
		    String Assignee1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[46]=tp.individualAssinTo(testcaseNo1, Assignee1);
			int []tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0);
			actual[47]=tp.selectSingleMultipleTestcase(tcNo2);
			int []testcaseNo2=new int[1];
			testcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1,0);
		    String Assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[48]=tp.individualAssinTo(testcaseNo2, Assignee2);
			int []tcNo3=new int[1];
			tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0);
			actual[49]=tp.selectSingleMultipleTestcase(tcNo3);
			int []testcaseNo3=new int[1];
			testcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2,0);
		    String Assignee3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[50]=tp.individualAssinTo(testcaseNo3, Assignee3);
			int []tcNo4=new int[1];
			tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0);
			actual[51]=tp.selectSingleMultipleTestcase(tcNo4);
			int []testcaseNo4=new int[1];
			testcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3,0);
		    String Assignee4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[52]=tp.individualAssinTo(testcaseNo4, Assignee4);
			}
		catch(Exception e){  lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		 }
	     }

	@Then("^Testcases should be assigned to lead by individual assignment$")
	public void testcases_should_be_assigned_to_lead_by_individual_assignment() throws Throwable {
		
		try{
			String [] Phase=new String[1];
			Phase[0] =UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 0);
			actual[53]=tp.navigateToCycle(Phase);
			int []tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0);
			actual[54]=tp.selectSingleMultipleTestcase(tcNo1);
			int []testcaseNo1=new int[1];
			testcaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0,0);
		    String Assignee1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[55]=tp.validateAllAssigned(testcaseNo1, Assignee1);
			int []tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0);
			actual[56]=tp.selectSingleMultipleTestcase(tcNo2);
			int []testcaseNo2=new int[1];
			testcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1,0);
		    String Assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[57]=tp.validateAllAssigned(testcaseNo2, Assignee2);
			int []tcNo3=new int[1];
			tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0);
			actual[58]=tp.selectSingleMultipleTestcase(tcNo3);
			int []testcaseNo3=new int[1];
			testcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2,0);
		    String Assignee3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[59]=tp.validateAllAssigned(testcaseNo3, Assignee3);
			int []tcNo4=new int[1];
			tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0);
			actual[60]=tp.selectSingleMultipleTestcase(tcNo4);
			int []testcaseNo4=new int[1];
			testcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3,0);
		    String Assignee4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[61]=tp.validateAllAssigned(testcaseNo4, Assignee4);
		    actual[62]=tp.selectallTestCase();
		    bp.waitForElement();
		    //rp.clickOnTestPlanning();
		    tp.goBackToCycle();
			bp.waitForElement();
		    for(int k=0;k<=actual.length-1;k++)
		       {
			soft.assertEquals(actual[k], true);
		           }
		    soft.assertAll();
		     }
		catch(Exception e){  lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }
	    }
