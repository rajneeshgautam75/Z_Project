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

public class Sync_After_DeletingNode_868122 extends LaunchBrowser
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
	String fileName="Sync_868122";
	
	boolean[] actual=new boolean[24];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^Select the ProjectON For the TestPlanning$")
	  public void select_the_ProjectON_For_the_TestPlanning() throws Throwable 
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
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on rElese in release summaryY$")
	  public void click_on_rElese_in_release_summaryY() throws Throwable 
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

	  @When("^Launch TestRepository and Create a phaseON$")
	  public void launch_TestRepository_and_Create_a_phaseON() throws Throwable 
	  {
		  try
	      {
			  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,1);
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

	  @Then("^Navigate to Created Phase and Add Testcase and edit the Testcase Nmae and Description$")
	  public void navigate_to_Created_Phase_and_Add_Testcase_and_edit_the_Testcase_Nmae_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",15,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",15,1);
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

	  @When("^Select tHe Added Testcase and CloNe it$")
	  public void select_tHe_Added_Testcase_and_CloNe_it() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  tr.selectallTestCase();
	    	  bp.waitForElement();
	    	  actual[6]=tr.cloneTestCase();
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

	  @Then("^Launch TestPlanning and Create exieution Cycle$")
	  public void launch_TestPlanning_and_Create_exieution_Cycle() throws Throwable 
	  {
		  try
	      {
			  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[7]= rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  actual[8]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",28,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,100);
	    	  actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",28,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",28,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",28,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",28,8));
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

	  @Then("^Add a Phase in Created Exicution Cycle Choose Existing PhaSe Save it and Choose 'Assign to Anyone'$")
	  public void add_a_Phase_in_Created_Exicution_Cycle_Choose_Existing_PhaSe_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,0);
	    	  actual[11]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  actual[12]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,9);
	    	  actual[13]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  actual[14]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  //rp.clickOnTestRep();
	    	  //actual[15]=rp.clickOnTestPlanning();
	    	  actual[15]=tp.goBackToCycle();
	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,0);
	    	  actual[16]=tp.doubleClickOnCycle(cycleName1);
	    	  bp.waitForElement();
	    	  String cycleName11[]=new String[2];
	    	  cycleName11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,0);
	    	  cycleName11[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  actual[17]=tp.navigateToCycle(cycleName11);
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

	  @When("^Launch TestRepository, Navigate to Created Phase, ContextClick and Delete the Phase$")
	  public void launch_TestRepository_Navigate_to_Created_Phase_ContextClick_and_Delete_the_Phase() throws Throwable 
	  {
		  try
	      {
			  bp=new BasePage();
			  rp=new ReleasePage(driver);
			  bp.waitForElement();
			  rp.clickOnTestRep();
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[18]=tr.navigateToNode(releaseName, navigation);
	    	  bp.waitForElement();
	    	  actual[19]=tr.deleteNode();
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

	  @When("^Launch TestPlanning, Navigate to Phase in Exicution Cycle and ContextClick choose Assign and Cancel the Popup$")
	  public void launch_TestPlanning_Navigate_to_Phase_in_Exicution_Cycle_and_ContextClick_choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
		  try
	      {
			  bp=new BasePage();
			  actual[20]=rp.clickOnTestPlanning();
//			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,0);
	    	  actual[21]=tp.doubleClickOnCycle(cycleName1);
	    	  bp.waitForElement();
	    	  String cycleName11[]=new String[2];
	    	  cycleName11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,0);
	    	  cycleName11[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",21,0);
	    	  actual[22]=tp.navigateToCycle(cycleName11);
	    	  bp.waitForElement();
	    	  tp.assignPhase();
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

	  @Then("^Click on Sync and Select the 'remove the Deleted Node from this Schedule' option, save it and View the Message in last Popup$")
	  public void click_on_Sync_and_Select_the_remove_the_Deleted_Node_from_this_Schedule_option_save_it_and_View_the_Message_in_last_Popup() throws Throwable 
	  {
		  try
	      {
			  bp=new BasePage();
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",28,11);
	    	  actual[23]=tp.sync(check);
	    	  bp.waitForElement();
	    	  bp.waitForElement();
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	    	  
	    	  log.info("Pass - Sync Node is not present in TestPlanning, when user Deletes a node");
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
