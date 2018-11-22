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

public class TestExecution_878838 extends LaunchBrowser {
	
	  BasePage bp;
	  ProjectPage pp;
	  ReleasePage rp;
	  TestRepositoryPage tr;
	  ExportPage epp;
	  CreateTestCasePage ctc;
	  TestPlanningPage tp;
	  ExecutionPage ep;
	  LaunchBrowser lb=new LaunchBrowser();
	  String filename="TestExecution_878838";
	  boolean actual[]=new boolean[108];
	  SoftAssert soft=new SoftAssert();
	  
	
	@Given("^Lead is in Test repository Page$")
	public void lead_is_in_Test_repository_Page() throws Throwable {
		try 
		{    
			pp=new ProjectPage(driver);
		    rp=new ReleasePage(driver);
		    bp=new BasePage();
			String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[0]=pp.selectProject( Project);
			actual[1]=pp.selectRelease(Release);
			actual[2]=rp.clickOnTestRep();
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

	@When("^Lead add a phase and add System, Subsystem to Phase$")
	public void lead_add_a_phase_and_add_System_Subsystem_to_Phase() throws Throwable {
		try 
		{
			tr=new TestRepositoryPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			String Phase_N=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 1);
			actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			actual[4]=tr.addNode(Phase_N, Desc);
			bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=Phase_N;
			bp.waitForElement();
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();
			actual[5]=tr.selectPhase(Phase_N);
			bp.waitForElement();
			String System=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 4);
			String S_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 5);
			actual[6]=tr.addNode(System, S_Desc);
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String []node1=new String[2];
			node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
			node1[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 4);
			tr.navigateToNode(Release, node1);
			bp.waitForElement();
			actual[7]=tr.selectPhase(System);
			bp.waitForElement();
			String Sub_system=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 6);
			String Sub_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 7);
			actual[8]=tr.addNode(Sub_system, Sub_Desc);
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

   @When("^Add four testcases with four teststeps to each node$")
	public void add_four_testcases_with_four_teststeps_to_each_node() throws Throwable {
	   try 
		{
		   epp=new ExportPage(driver);
		   ctc=new CreateTestCasePage(driver);
		   String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		   String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14,0);
		   tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String []node1=new String[1];
			node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
			tr.navigateToNode(Release, node1);
			bp.waitForElement();
		   actual[9]=tr.selectPhase(Phase);
		   bp.waitForElement();
		   actual[10]=tr.addTestCase();
		   bp.waitForElement();
		   actual[11]=tr.clickOnDetails();
		   bp.waitForElement();
		   String StepDetails11[]=new String[12];
		   StepDetails11[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails11[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails11[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails11[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails11[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails11[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails11[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails11[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails11[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails11[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails11[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails11[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[12]=ctc.enterTestCaseStepDetail(StepDetails11);
		   bp.waitForElement();
		   actual[13]=tr.clickOnList();
		   bp.waitForElement();
		   actual[14]=tr.addTestCase();
		   bp.waitForElement();
		   actual[15]=tr.clickOnDetails();
		   String testcase12[]=new String [1];
		   testcase12[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository",2, 0));
		   actual[16]=epp.selectMultipleTestCaseFromGrid(testcase12);
		   bp.waitForElement();
		  
		   bp.waitForElement();
		   String StepDetails12[]=new String[12];
		   StepDetails12[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails12[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails12[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails12[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails12[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails12[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails12[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails12[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails12[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails12[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails12[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails12[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[17]=ctc.enterTestCaseStepDetail(StepDetails12);
		   bp.waitForElement();
		   actual[19]=epp.selectMultipleTestCaseFromGrid(testcase12);
		   bp.waitForElement();
		   actual[18]=tr.clickOnList();
		   
		  
		   bp.waitForElement();
		   
		   actual[20]=tr.addTestCase();
		   bp.waitForElement();
		   actual[21]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase13[]=new String [1];
		   testcase13[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",3, 0));
		   actual[22]=epp.selectMultipleTestCaseFromGrid(testcase13);
		  
		  
		   bp.waitForElement();
		   String StepDetails13[]=new String[12];
		   StepDetails13[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails13[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails13[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails13[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails13[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails13[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails13[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails13[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails13[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails13[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails13[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails13[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[23]=ctc.enterTestCaseStepDetail(StepDetails13);
		   bp.waitForElement();
		   actual[24]=epp.selectMultipleTestCaseFromGrid(testcase13);
		   bp.waitForElement();
		   actual[25]=tr.clickOnList();
		  
		  
		   bp.waitForElement();
		   actual[26]=tr.addTestCase();
		   bp.waitForElement();
		   actual[27]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase14[]=new String [1];
		   testcase14[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",4, 0));
		   actual[28]=epp.selectMultipleTestCaseFromGrid(testcase14);
		   bp.waitForElement();
		  
		  
		   String StepDetails14[]=new String[12];
		   StepDetails14[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails14[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails14[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails14[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails14[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails14[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails14[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails14[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails14[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails14[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails14[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails14[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[29]=ctc.enterTestCaseStepDetail(StepDetails14);
		   bp.waitForElement();
		   actual[30]=epp.selectMultipleTestCaseFromGrid(testcase14);
		   bp.waitForElement();
		   actual[31]=tr.clickOnList();
		   bp.waitForElement();
		  
		   
		   tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String []node2=new String[2];
			node2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
			node2[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 4);
			tr.navigateToNode(Release, node2);
			bp.waitForElement();
		   String System=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 4);
		   actual[32]=tr.selectPhase(System);
		   bp.waitForElement();
		   actual[33]=tr.addTestCase();
		   bp.waitForElement();
		   actual[34]=tr.clickOnDetails();
		   bp.waitForElement();
		   String StepDetails21[]=new String[12];
		   StepDetails21[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails21[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails21[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails21[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails21[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails21[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails21[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails21[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails21[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails21[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails21[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails21[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[35]=ctc.enterTestCaseStepDetail(StepDetails21);
		   bp.waitForElement();
		   actual[36]=tr.clickOnList();
		   bp.waitForElement();
		   actual[37]=tr.addTestCase();
		   bp.waitForElement();
		   actual[38]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase22[]=new String [1];
		   testcase22[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",2, 0));
		   actual[39]=epp.selectMultipleTestCaseFromGrid(testcase22);
		  
		
		   bp.waitForElement();
		   String StepDetails22[]=new String[12];
		   StepDetails22[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails22[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails22[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails22[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails22[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails22[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails22[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails22[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails22[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails22[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails22[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails22[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[40]=ctc.enterTestCaseStepDetail(StepDetails22);
		   bp.waitForElement();
		   actual[41]=epp.selectMultipleTestCaseFromGrid(testcase22);
		   bp.waitForElement();
		   actual[42]=tr.clickOnList();
		  
		  
		   bp.waitForElement();
		   actual[43]=tr.addTestCase();
		   bp.waitForElement();
		   actual[44]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase23[]=new String [1];
		   testcase23[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",3, 0));
		   actual[45]=epp.selectMultipleTestCaseFromGrid(testcase23);
		   bp.waitForElement();
		   
		  
		   String StepDetails23[]=new String[12];
		   StepDetails23[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails23[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails23[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails23[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails23[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails23[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails23[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails23[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails23[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails23[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails23[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails23[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[46]=ctc.enterTestCaseStepDetail(StepDetails23);
		   bp.waitForElement();
		   actual[47]=epp.selectMultipleTestCaseFromGrid(testcase23);
		   bp.waitForElement();
		   actual[48]=tr.clickOnList();
		   bp.waitForElement();
		  
		   actual[49]=tr.addTestCase();
		   bp.waitForElement();
		   actual[50]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase24[]=new String [1];
		   testcase24[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",4, 0));
		   actual[51]=epp.selectMultipleTestCaseFromGrid(testcase24);
		   bp.waitForElement();
		  
		   String StepDetails24[]=new String[12];
		   StepDetails24[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails24[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails24[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails24[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails24[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails24[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails24[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails24[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails24[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails24[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails24[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails24[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[52]=ctc.enterTestCaseStepDetail(StepDetails24);
		   bp.waitForElement();
		   actual[53]=epp.selectMultipleTestCaseFromGrid(testcase24);
		   bp.waitForElement();
		   actual[54]=tr.clickOnList();
		   bp.waitForElement();
		  
		   
		   
		   tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String []node21=new String[3];
			node21[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
			node21[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 4);
			node21[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 6);
			tr.navigateToNode(Release, node21);
			bp.waitForElement();
		   String Sub_system=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 6);
		   actual[55]=tr.selectPhase(Sub_system);
		   bp.waitForElement();
		   actual[56]=tr.addTestCase();
		   bp.waitForElement();
		   actual[57]=tr.clickOnDetails();
		   bp.waitForElement();
		   String StepDetails31[]=new String[12];
		   StepDetails31[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails31[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails31[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails31[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails31[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails31[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails31[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails31[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails31[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails31[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails31[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails31[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[58]=ctc.enterTestCaseStepDetail(StepDetails31);
		   bp.waitForElement();
		   actual[59]=tr.clickOnList();
		   bp.waitForElement();
		   actual[60]=tr.addTestCase();
		   bp.waitForElement();
		   actual[61]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase32[]=new String [1];
		   testcase32[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",2, 0));
		   actual[62]=epp.selectMultipleTestCaseFromGrid(testcase32);
		   bp.waitForElement();
		  
		   String StepDetails32[]=new String[12];
		   StepDetails32[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails32[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails32[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails32[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails32[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails32[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails32[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails32[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails32[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails32[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails32[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails32[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[63]=ctc.enterTestCaseStepDetail(StepDetails32);
		   bp.waitForElement();
		   actual[64]=epp.selectMultipleTestCaseFromGrid(testcase32);
		   bp.waitForElement();
		   actual[65]=tr.clickOnList();
		   bp.waitForElement();
		   
		   actual[66]=tr.addTestCase();
		   bp.waitForElement();
		   actual[67]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase33[]=new String [1];
		   testcase33[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",3, 0));
		   actual[68]=epp.selectMultipleTestCaseFromGrid(testcase33);
		   bp.waitForElement();
		  
		   String StepDetails33[]=new String[12];
		   StepDetails33[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails33[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails33[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails33[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails33[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails33[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails33[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails33[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails33[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails33[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails33[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails33[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[69]=ctc.enterTestCaseStepDetail(StepDetails33);
		   bp.waitForElement();
		   actual[70]=epp.selectMultipleTestCaseFromGrid(testcase33);
		   bp.waitForElement();
		   actual[71]=tr.clickOnList();
		   bp.waitForElement();
		  
		   
		   actual[72]=tr.addTestCase();
		   bp.waitForElement();
		   actual[73]=tr.clickOnDetails();
		   bp.waitForElement();
		   String testcase34[]=new String [1];
		   testcase34[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository",4, 0));
		   actual[74]=epp.selectMultipleTestCaseFromGrid(testcase34);
		   bp.waitForElement();
		  
		   String StepDetails34[]=new String[12];
		   StepDetails34[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		   StepDetails34[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		   StepDetails34[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		   
		   StepDetails34[3]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		   StepDetails34[4]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		   StepDetails34[5]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		 
		   StepDetails34[6]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
		   StepDetails34[7]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
		   StepDetails34[8]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
		 
		   StepDetails34[9]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
		   StepDetails34[10]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
		   StepDetails34[11]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
		   actual[75]=ctc.enterTestCaseStepDetail(StepDetails34);
		   bp.waitForElement();
		   actual[76]=tr.clickOnList();
		   actual[77]=bp.waitForElement();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
		 }
	   
		catch(Exception e)
		{
		e.printStackTrace();	
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		
		}
	      }

	@When("^Lead is in TestPlanning Page and create new cycle$")
	public void lead_is_in_TestPlanning_Page_and_create_new_cycle() throws Throwable {
		try 
		{
			tp=new TestPlanningPage(driver);
			actual[78]=rp.clickOnTestPlanning();
			actual[79]=tp.clickOnAddTestCycleSymbol();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 10, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[80]=tp.CreateCycle(cycle, Build, Environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[81]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[82]=tp.saveTestCycle();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		
		}
	      }

	@When("^Add phase to cycle and assign all testcases to creater$")
	public void add_phase_to_cycle_and_assign_all_testcases_to_creater() throws Throwable {
		try 
		{
		   String cycle[]=new String[1];
		   cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 10,0);
		   actual[83]=tp.navigateToCycle(cycle);
		   bp.waitForElement();
		   String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
		   actual[84]=tp.addPhaseToCycle(Phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
		   actual[85]=tp.bulkAssignment(Bulk_type);
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

	@When("^Launch TestExecution Expand Release,Expand cycle and Expand Phase$")
	public void launch_TestExecution_Expand_Release_Expand_cycle_and_Expand_Phase() throws Throwable {
		try 
		{
			ep=new ExecutionPage(driver);
			actual[86]=rp.clickOnTestExecution();
			bp.waitForElement();
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1,0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 10, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 0);
			actual[87]=tp.navigateToCycle(cycle);
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
	
	@When("^Change All Execution status of first testcase steps to Pass$")
	public void change_All_Execution_status_of_first_testcase_steps_to_Pass() throws Throwable {
		try 
		{
			tr.clickDetailButton();
			bp.waitForElement();
			String tcno1[]=new String [1];
			tcno1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
		    actual[88]=ep.selectMultipleTestCaseFromExecutionGrid(tcno1);
		    bp.waitForElement();
		    int testcase[]=new int[4];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
		    testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0);
		    testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0);
		    String[] status=new String[4];
		    status[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		    status[1]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		    status[2]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		    status[3]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		    actual[89]=ep.changeStepDetailStatus(testcase, status);
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

	@Then("^First Testcase status should update to status Pass$")
	public void first_Testcase_status_should_update_to_status_Pass() throws Throwable {
		try 
		{
			String tcno1[]=new String [1];
			tcno1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
		    actual[90]=ep.selectMultipleTestCaseFromExecutionGrid(tcno1);
		    bp.waitForElement();
		    int testcase1[]=new int[1];
		    testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		    actual[91]=ep.ValidateStatusOfTestCases(testcase1, status);
		    actual[92]=ep.selectMultipleTestCaseFromExecutionGrid(tcno1);
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
	
	@When("^Change All Execution status of second testcase steps to Fail$")
	public void change_All_Execution_status_of_second_testcase_steps_to_Fail() throws Throwable {
		try 
		{
			
			String tcno2[]=new String [1];
			tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
		    actual[93]=ep.selectMultipleTestCaseFromExecutionGrid(tcno2);
		    bp.waitForElement();
		    bp.waitForElement();
		    int testcase[]=new int[4];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
		    testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0);
		    testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0);
		    String[] status=new String[4];
		    status[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
		    status[1]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
		    status[2]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
		    status[3]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
		    actual[94]=ep.changeStepDetailStatus(testcase, status);
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

	@Then("^Second Testcase status should update to status Fail$")
	public void second_Testcase_status_should_update_to_status_Fail() throws Throwable {
		try 
		{
			String tcno2[]=new String [1];
			tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
		    actual[95]=ep.selectMultipleTestCaseFromExecutionGrid(tcno2);
		    bp.waitForElement();
		    int testcase2[]=new int[1];
		    testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
		    actual[96]=ep.ValidateStatusOfTestCases(testcase2, status);
		    actual[97]=ep.selectMultipleTestCaseFromExecutionGrid(tcno2);
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

	@When("^Change All Execution status of third testcase steps to WIP$")
	public void change_All_Execution_status_of_third_testcase_steps_to_WIP() throws Throwable {
		try 
		{
			String tcno3[]=new String [1];
			tcno3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0));
		    actual[98]=ep.selectMultipleTestCaseFromExecutionGrid(tcno3);
		    bp.waitForElement();
		    int testcase[]=new int[4];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
		    testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0);
		    testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0);
		    String[] status=new String[4];
		    status[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
		    status[1]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
		    status[2]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
		    status[3]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
		    actual[99]=ep.changeStepDetailStatus(testcase, status);
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

	@Then("^Third Testcase status should update to status WIP$")
	public void third_Testcase_status_should_update_to_status_WIP() throws Throwable {
		try 
		{
			String tcno3[]=new String [1];
			tcno3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0));
		    actual[100]=ep.selectMultipleTestCaseFromExecutionGrid(tcno3);
		    bp.waitForElement();
		    int testcase3[]=new int[1];
		    testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3,0);
		    String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
		    actual[101]=ep.ValidateStatusOfTestCases(testcase3, status);
		    actual[102]=ep.selectMultipleTestCaseFromExecutionGrid(tcno3);
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
	
	@When("^Change All Execution status of fourth testcase steps to Blocked$")
	public void change_All_Execution_status_of_fourth_testcase_steps_to_Blocked() throws Throwable {
		try 
		{
			String tcno4[]=new String [1];
			tcno4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0));
		    actual[103]=ep.selectMultipleTestCaseFromExecutionGrid(tcno4);
		    bp.waitForElement();
		    int testcase[]=new int[4];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
		    testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0);
		    testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0);
		    String[] status=new String[4];
		    status[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
		    status[1]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
		    status[2]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
		    status[3]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
		    actual[104]=ep.changeStepDetailStatus(testcase, status);
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

	@Then("^Fourth Testcase status should update to status Blocked$")
	public void fourth_Testcase_status_should_update_to_status_Blocked() throws Throwable {
		try 
		{
			String tcno4[]=new String [1];
			tcno4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0));
		    actual[105]=ep.selectMultipleTestCaseFromExecutionGrid(tcno4);
		    bp.waitForElement();
		    int testcase4[]=new int[1];
		    testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,0);
		    String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
		    actual[106]=ep.ValidateStatusOfTestCases(testcase4, status);
		    actual[107]=ep.selectMultipleTestCaseFromExecutionGrid(tcno4);
		    bp.waitForElement();
		    
		    tr.clickOnList();
		    bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			
			
		    for(int k=0;k<=actual.length-1;k++)
		    {
		    	System.out.println("Actual["+ k +"]=" + actual[k]);
		    	soft.assertEquals(actual[k], true);
		    	
		    }
		    soft.assertAll();
		    log.info("User sucessfully executed tescases");
			
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
