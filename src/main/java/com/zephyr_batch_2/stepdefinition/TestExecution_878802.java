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

public class TestExecution_878802  extends LaunchBrowser {
LaunchBrowser lb=new LaunchBrowser();
LoginPage lp;
BasePage bp;
ProjectPage pp;
ReleasePage rp;
TestRepositoryPage tr;
CreateTestCasePage ctc;
ExportPage epp;
TestPlanningPage tp;
ExecutionPage ep;
String ad="TestExecution_878802";
boolean actual[]=new boolean[33];
SoftAssert soft=new SoftAssert();


@Given("^Lead is in Test Repository page of Normal_Project$")
public void lead_is_in_Test_Repository_page_of_Normal_Project() throws Throwable {
 try 
 {
	 bp=new BasePage();
	 pp=new ProjectPage(driver);
	 rp=new ReleasePage(driver);
	 
	// pp=new ProjectPage(driver);
     pp.clickOnLogout();
     bp.waitForElement();
lp=new LoginPage(driver);
 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
 lp.enterUname(Uname);
 lp.enterPass(Pass);
 lp.clickOnLogin();
 bp.waitForElement();
	 String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
	 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases",1, 0);
     actual[0]=pp.selectProject(Project);
     actual[1]=pp.selectRelease(Release);
     bp.waitForElement();
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

@When("^Add phase and add testcases with teststeps to created phase$")
public void add_phase_and_add_testcases_with_teststeps_to_created_phase() throws Throwable {
	 try 
	 {
		 tr=new TestRepositoryPage(driver);
		 ctc=new CreateTestCasePage(driver);
		 epp=new ExportPage(driver);
		 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		 String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 25, 0);
		 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 25, 1);
		 actual[3]=tr.doubleClickOnRelease(Release);
		 bp.waitForElement();
		 actual[4]=tr.addNode(Phase, Desc);
		 actual[5]=bp.waitForElement();
		 String Phase1[]=new String[1];
		 Phase1[0]=Phase;
		 tr.navigateToNode(Release, Phase1);
	     bp.waitForElement();
		 actual[6]=tr.addTestCase();
		 bp.waitForElement();
		 actual[7]=tr.clickOnDetails();
		 bp.waitForElement();
		 String stepDetails1[]=new String[3];
		 for (int i=0;i<=stepDetails1.length-1;i++)
		 {
		  stepDetails1[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, i);
		 }
		 actual[8]=ctc.enterTestCaseStepDetail(stepDetails1);
		 bp.waitForElement();
		 actual[9]=tr.clickOnList();
		 bp.waitForElement();
		 actual[10]=tr.addTestCase();
		 String testcase[]=new String[1];
		 testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
		 actual[11]=epp.selectMultipleTestCaseFromGrid(testcase);
		 bp.waitForElement();
		 actual[12]=tr.clickOnDetails();
		 bp.waitForElement();
		 String stepDetails2[]=new String[3];
		 for (int i=0;i<=stepDetails1.length-1;i++)
		 {
		  stepDetails2[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, i);
		 }
		 actual[13]=ctc.enterTestCaseStepDetail(stepDetails2);
		 bp.waitForElement();
		 actual[14]=tr.clickOnList();
		 bp.waitForElement();
		 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
		 }
	 catch (Exception e)
	 {    lb.getScreenShot(ad);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
	 }  
}

@When("^Launch Test planning and create new cycle$")
public void launch_Test_planning_and_create_new_cycle() throws Throwable {
	 try 
	 {
		    tp=new TestPlanningPage(driver);
			actual[15]=rp.clickOnTestPlanning();
			actual[16]=tp.clickOnAddTestCycleSymbol();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 18, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle" , 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 100, 100);
			actual[17]=tp.CreateCycle(cycle, Build, environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[18]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[19]=tp.saveTestCycle();
			bp.waitForElement(); 
		 
	 }
	 catch (Exception e)
	 {    lb.getScreenShot(ad);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
	 }  
}

@When("^Add phase to created cycle and assign testcases to lead$")
public void add_phase_to_created_cycle_and_assign_testcases_to_lead() throws Throwable {
	 try 
	 {
		    String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 18, 0);
			actual[20]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 25, 0);
			actual[21]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
			actual[22]=tp.bulkAssignment(Bulk_type);
			bp.waitForElement();
		 
	 }
	 catch (Exception e)
	 {    lb.getScreenShot(ad);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
	 }  
}

@Then("^Testcaes should be assigned to lead in TestPlanning page$")
public void testcaes_should_be_assigned_to_lead_in_TestPlanning_page() throws Throwable {
	 try 
	 {
		 String cycle[]=new String[1];
	     cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 25, 0);
		 actual[23]=tp.navigateToCycle(cycle);
		 bp.waitForElement();
		 int testcase[]=new int[2];
		 for(int i=0;i<=testcase.length-1;i++)
		 {
			 testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", i+1, 0);
		 }
		 String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
		 bp.waitForElement();
		 actual[24]=tp.validateAllAssigned(testcase, Assignee);
		 bp.waitForElement();
		 tp.goBackToCycle();
         bp.waitForElement();
		actual[25]=pp.clickOnLogout();
		 
	 }
	 catch (Exception e)
	 {    lb.getScreenShot(ad);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
	 }  
}

@When("^Login as Tester and Launch TestExecution Page and navigate to phase$")
public void login_as_Tester_and_Launch_TestExecution_Page_and_navigate_to_phase() throws Throwable {
	 try 
	 {
		 
		 lp=new LoginPage(driver);
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
		 actual[26]=lp.enterUname(userName);
		 String Password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
		 actual[27]=lp.enterPass(Password);
		 bp.waitForElement();
		 actual[28]=lp.clickOnLogin();
		 bp.waitForElement();
		 String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
		 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases",1, 0);
	     actual[29]=pp.selectProject(Project);
	     actual[30]=pp.selectRelease(Release);
	     actual[31]=rp.clickOnTestExecution();
	     bp.waitForElement();
	 }
	 catch (Exception e)
	 {    lb.getScreenShot(ad);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
	 }  
}

@Then("^Check for all testcases assigned to Tester and Anyone$")
public void check_for_all_testcases_assigned_to_Tester_and_Anyone() throws Throwable {
	 try 
	 {
		 ep=new ExecutionPage(driver);
		 String nodes[]=new String[3];
		 nodes[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		 nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 18, 0);
		 nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 25, 0);
		 actual[32]=ep.validateExecutions(nodes);
		 bp.waitForElement();
//		 pp.clickOnLogout();
//		 pp.closeBrowser();
		 for(int k=0;k<=actual.length-1;k++)
		 {
			 System.out.println("Actual["+k+"]="+ actual[k]);
			 soft.assertEquals(actual[k], true);
			 }
		 soft.assertAll();
	 }
	 catch (Exception e)
	 {    lb.getScreenShot(ad);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
	 } 
}}
