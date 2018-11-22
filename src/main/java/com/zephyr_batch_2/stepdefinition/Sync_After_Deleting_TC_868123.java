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

public class Sync_After_Deleting_TC_868123 extends LaunchBrowser
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
	String fileName="Sync_868123";
	
	boolean[] actual=new boolean[23];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^Select the ProjectoNE For the TestPlanning$")
	  public void select_the_ProjectoNE_For_the_TestPlanning() throws Throwable {
		  try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 pp.selectProject(projectName); 
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
	  
	  /*@Given("^Select the Project(\\d+) For the TestPlanning$")
	  public void select_the_Project_For_the_TestPlanning(int arg1) throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[0]= pp.selectProject(projectName); 
	      }
	      catch(Exception e)
			{
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }*/

	  @When("^Click on rElese in release summAry$")
	  public void click_on_rElese_in_release_summAry() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[0]= pp.selectRelease(releaseName);
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

	  @When("^Launch TestRepository and Create a phase(\\d+)$")
	  public void launch_TestRepository_and_Create_a_phase(int arg1) throws Throwable 
	  {
	      try
	      {
	    	  rp=new ReleasePage(driver);
	    	  tr=new TestRepositoryPage(driver);
	    	  actual[1]=rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,1);
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

	  @Then("^Navigate to Created PhAse and Add Testcase and edit the Testcase Nmae and Description$")
	  public void navigate_to_Created_PhAse_and_Add_Testcase_and_edit_the_Testcase_Nmae_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",16,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",16,1);
	    	  ctc=new CreateTestCasePage(driver);
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

	  @When("^Select tHe Added TestCase and Clone it$")
	  public void select_tHe_Added_TestCase_and_Clone_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  tr.selectallTestCase();
	    	  bp.waitForElement();
	    	  actual[6]=tr.cloneTestCase();
	    	  bp.waitForElement();
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

	  @When("^Launch TestPlanning and Create execution Cycle$")
	  public void launch_TestPlanning_and_Create_execution_Cycle() throws Throwable 
	  {
		  try
	      {
			  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[7]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  actual[8]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",31,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,100);
	    	  actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",31,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",31,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",31,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",31,8));
	    	  actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
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

	  @When("^Add a Phase in Created Exicution Cycle, Choose EXisting Phase Save it and Choose 'Assign to Anyone'$")
	  public void add_a_Phase_in_Created_Exicution_Cycle_Choose_EXisting_Phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,0);
	    	  actual[11]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,0);
	    	  actual[12]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,9);
	    	  actual[13]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,0);
	    	  actual[14]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	    	  //rp.clickOnTestRep();
	    	  actual[15]=rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,0);
	    	  bp.waitForElement();
	    	  actual[16]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName11[]=new String[2];
	    	  cycleName11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,0);
	    	  cycleName11[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,0);
	    	  actual[17]=tp.navigateToCycle(cycleName11);
	    	  bp.waitForElement();
	    	  tp.assignPhase();
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

	  @When("^Select the Testcase by choosing Checkbox and Delete it$")
	  public void select_the_Testcase_by_choosing_Checkbox_and_Delete_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String cycleName[]=new String[1];
			  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",22,0);
			  actual[18]=tp.navigateToCycle(cycleName);
			  bp.waitForElement();
	    	  int tcNo[]=new int[1];
	    	  tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH,"T_Execution",2,0);
	    	  System.out.println(tcNo[0]);
	    	  actual[19]=tp.selectSingleMultipleTestcase(tcNo);
	    	  bp.waitForElement();
	    	  actual[20]=tp.deleteAllSelectedTestCases();
	    	  bp.waitForElement();
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

	  @Then("^sync it by Selecting the option 'Remove the Deleted node' and View Last popup Message$")
	  public void sync_it_by_Selecting_the_option_Remove_the_Deleted_node_and_View_Last_popup_Message() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",31,11);
	    	  actual[21]=tp.sync(check);
	    	  bp.waitForElement();
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

	  @Then("^sync it without Selecting the option 'Remove the Deleted node' and View Last popup Message$")
	  public void sync_it_without_Selecting_the_option_Remove_the_Deleted_node_and_View_Last_popup_Message() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[22]=tp.sync(check);
	    	  bp.waitForElement();
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	    	  
	    	  log.info("Pass - Sync is done with/without selecting Option'Remove the Deleted node' Successfully");
	    	  for(int k=0;k<=actual.length-1;k++)
		       {
		           System.out.println(actual[k]);
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
