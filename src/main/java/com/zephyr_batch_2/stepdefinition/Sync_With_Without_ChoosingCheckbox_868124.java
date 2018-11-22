package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sync_With_Without_ChoosingCheckbox_868124 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp; 
	CopyFromProjects cfp;
	String fileName="Sync_868124";
	
	boolean[] actual=new boolean[44];
	  SoftAssert soft=new SoftAssert();
	  
	  
	  @Given("^Select the ProjecTone For the TestPlanning$")
	  public void select_the_ProjecTone_For_the_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ip=new ImportPage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[0]= pp.selectProject(projectName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on rElese in releAse summary$")
	  public void click_on_rElese_in_releAse_summary() throws Throwable 
	  {
		  try
	      {
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[1]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and Create a phasEone$")
	  public void launch_TestRepository_and_Create_a_phasEone() throws Throwable 
	  {
		  try
	      {
			  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,1);
	    	  actual[2]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Navigate to Created Phase and Add Testcase and edit the Testcase NmaE and Description$")
	  public void navigate_to_Created_Phase_and_Add_Testcase_and_edit_the_Testcase_NmaE_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",17,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",17,1);
	    	  actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select tHe Added Testcase and ClonE it$")
	  public void select_tHe_Added_Testcase_and_ClonE_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  tr.selectallTestCase();
	    	  bp.waitForElement();
	    	  actual[6]=tr.cloneTestCase();
	    	  bp.waitForElement();
	    	  actual[7]=tr.cloneTestCase();
	    	  bp.waitForElement();
	    	  actual[8]=tr.cloneTestCase();
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestPlanning and CreatE exicution Cycle$")
	  public void launch_TestPlanning_and_CreatE_exicution_Cycle() throws Throwable 
	  {
		  try
	      {
			  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[9]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[10]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",34,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,100);
	    	  actual[11]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",34,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",34,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",34,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",34,8));
	    	  actual[12]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	    	  bp.waitForElement();
	    	  tp.saveTestCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save it and choose 'Assign to Anyone'$")
	  public void add_a_Phase_in_Created_Exicution_Cycle_Choose_Existing_Phase_Save_it_and_choose_Assign_to_Anyone() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  actual[13]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  actual[14]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,9);
	    	  actual[15]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  actual[16]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  //actual[17]=rp.clickOnTestPlanning();
	    	  actual[17]=tp.goBackToCycle();
	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  actual[18]=tp.doubleClickOnCycle(cycleName1);
	    	  bp.waitForElement();
	    	  String cycleName11[]=new String[2];
	    	  cycleName11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  cycleName11[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  actual[19]=tp.navigateToCycle(cycleName11);
	    	  bp.waitForElement();
	    	  tp.assignPhase();
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Launch TestExicution, choose option in the status dropdown$")
	  public void launch_TestExicution_choose_option_in_the_status_dropdown() throws Throwable 
	  {
		  try
	      {
			  bp=new BasePage();
			  exp=new ExecutionPage(driver);
			  bp.waitForElement();
	    	  rp.clickOnTestExecution();
	    	  //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  //tr.doubleClickOnRelease(releaseName);
	    	  String navigation[]=new String[3];
	    	  navigation[0]=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  navigation[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  bp.waitForElement();
	    	  actual[20]=tp.navigateToCycle(navigation);
	    	  bp.waitForElement();
	    	  
	    	  int tcNo1=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 1, 0);
	    	  String statusType1=Excel_Lib.getData(INPUT_PATH, "T_Execution", 3, 1);
	    	  actual[21]=exp.executeStatus(tcNo1, statusType1);
	    	  
	    	  int tcNo2=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 2, 0);
	    	  String statusType2=Excel_Lib.getData(INPUT_PATH, "T_Execution", 3, 1);
	    	  actual[22]=exp.executeStatus(tcNo2, statusType2);
	    	  
	    	  int tcNo3=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 3, 0);
	    	  String statusType3=Excel_Lib.getData(INPUT_PATH, "T_Execution", 6, 1);
	    	  actual[23]=exp.executeStatus(tcNo3, statusType3);
	    	  
	    	  int tcNo4=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 4, 0);
	    	  String statusType4=Excel_Lib.getData(INPUT_PATH, "T_Execution", 6, 1);
	    	  actual[24]=exp.executeStatus(tcNo4, statusType4);
	    	  
	    	  bp.waitForElement();
	    	  tp.doubleClickOnCycle(navigation[0]);
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestPlanning, Naviagate to Phase in the Exicution Cycle and Choose Assign$")
	  public void launch_TestPlanning_Naviagate_to_Phase_in_the_Exicution_Cycle_and_Choose_Assign() throws Throwable 
	  {
		  try
	      {
			  bp=new BasePage();
			  bp.waitForElement();
			  actual[25]=rp.clickOnTestPlanning();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  actual[26]=tp.doubleClickOnCycle(cycleName1);
	    	  bp.waitForElement();
	    	  String cycleName11[]=new String[2];
	    	  cycleName11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,0);
	    	  cycleName11[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  actual[27]=tp.navigateToCycle(cycleName11);
	    	  bp.waitForElement();
	    	  actual[28]=tp.assignPhase();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  actual[29]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  actual[30]=tp.selectallTestCase();
	    	  String assignee=Excel_Lib.getData(INPUT_PATH,"T_Execution",1,2);
	    	  actual[31]=tp.assignAllSelected(assignee);
	    	 bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select a Testcase as, Assigned to 'anyone' and 'not exicuted' statuS and Delete it$")
	  public void select_a_Testcase_as_Assigned_to_anyone_and_not_exicuted_statuS_and_Delete_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  int tcNo[]=new int[1];
			  tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 2, 0);
			  actual[32]=tp.selectSingleMultipleTestcase(tcNo);
			  bp.waitForElement();
			  actual[33]=tp.deleteAllSelectedTestCases();
			  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^sync it by Selecting the oPtion 'Remove the Deleted node' and View Last popup Message$")
	  public void sync_it_by_Selecting_the_oPtion_Remove_the_Deleted_node_and_View_Last_popup_Message() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",34,10);
	    	  actual[34]=tp.sync(check);
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select a Testcase as, Assigned to 'anyone' and 'not exicuted' status and Delete it$")
	  public void select_a_Testcase_as_Assigned_to_anyone_and_not_exicuted_status_and_Delete_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  tp.navigateToCycle(cycleName);
			  int tcNo[]=new int[1];
			  tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 2, 0);
			  actual[35]=tp.selectSingleMultipleTestcase(tcNo);
			  bp.waitForElement();
			  actual[36]=tp.deleteAllSelectedTestCases();
			  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^sync it without Selecting the Option 'Remove the Deleted node' and View Last popup Message$")
	  public void sync_it_without_Selecting_the_Option_Remove_the_Deleted_node_and_View_Last_popup_Message() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[37]=tp.sync(check);
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select a Testcase as, Assigned to 'anyone' and 'exicuted' statuS and Delete it$")
	  public void select_a_Testcase_as_Assigned_to_anyone_and_exicuted_statuS_and_Delete_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  tp.navigateToCycle(cycleName);
			  int tcNo[]=new int[1];
			  tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 2, 0);
			  actual[38]=tp.selectSingleMultipleTestcase(tcNo);
			  bp.waitForElement();
			  actual[39]=tp.deleteAllSelectedTestCases();
			  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^sync it by Selecting the optIon 'Remove the Deleted node' and View Last popup Message$")
	  public void sync_it_by_Selecting_the_optIon_Remove_the_Deleted_node_and_View_Last_popup_Message() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[40]=tp.sync(check);
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select a Testcase as, Assigned to 'anyone' and 'exicuted' status and Delete it$")
	  public void select_a_Testcase_as_Assigned_to_anyone_and_exicuted_status_and_Delete_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",23,0);
	    	  tp.navigateToCycle(cycleName);
			  int tcNo[]=new int[1];
			  tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH, "T_Execution", 2, 0);
			  actual[41]=tp.selectSingleMultipleTestcase(tcNo);
			  bp.waitForElement();
			  actual[42]=tp.deleteAllSelectedTestCases();
			  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^sync it without Selecting the option 'Remove the Deleted node' and View Last popup MessagE$")
	  public void sync_it_without_Selecting_the_option_Remove_the_Deleted_node_and_View_Last_popup_MessagE() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[43]=tp.sync(check);
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	    	  
	    	  log.info("Pass - Sync is done with/without selecting the 'Remove the Deleted node' checkbox Successfully");
	    	  for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }
}
