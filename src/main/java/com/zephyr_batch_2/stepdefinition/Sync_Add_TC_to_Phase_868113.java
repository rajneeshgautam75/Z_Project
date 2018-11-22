package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sync_Add_TC_to_Phase_868113 extends LaunchBrowser
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
	String fileName="Sync_868113";
	
	boolean[] actual=new boolean[33];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^Select the Project For the TestPlanning$")
	  public void select_the_Project_For_the_TestPlanning() throws Throwable 
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

	  @When("^Click on relese in release summary$")
	  public void click_on_relese_in_release_summary() throws Throwable 
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

	  @When("^Launch TestRepository and Create A phase$")
	  public void launch_TestRepository_and_Create_A_phase() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,5);
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

	  @Then("^Navigate to Created Phase and Add Testcase and Edit the Testcase Nmae and Description$")
	  public void navigate_to_Created_Phase_and_Add_Testcase_and_Edit_the_Testcase_Nmae_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",1,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",1,1);
	    	  actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	  @Then("^Select the Added Testcase and Clone it$")
	  public void select_the_Added_Testcase_and_Clone_it() throws Throwable 
	  {
	      try
	      { 
	    	  BasePage bp=new BasePage();
	    	  tr.selectallTestCase();
	    	  bp.waitForElement();
	    	  actual[6]=tr.cloneTestCase();
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

	  @When("^Launch TestPlanning and Create Exicution Cycle$")
	  public void launch_TestPlanning_and_Create_Exicution_Cycle() throws Throwable 
	  {
	      try
	      {
	    	  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[7]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[8]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",1,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,100);
	    	  actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",1,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",1,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",1,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",1,8));
	    	  bp.waitForElement();
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

	  @When("^Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save it and View the counts$")
	  public void add_a_Phase_in_Created_Exicution_Cycle_Choose_Existing_Phase_Save_it_and_View_the_counts() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,0);
	    	  actual[11]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  actual[12]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,9);
	    	  actual[13]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  actual[14]=tp.getPhaseCount(phaseName);
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

	  @When("^Launch TestRepository and Add new Testcase to the Phase$")
	  public void launch_TestRepository_and_Add_new_Testcase_to_the_Phase() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[15]=rp.clickOnTestRep();
	    	  bp.waitForElement();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	 // tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[16]=tr.navigateToNode(releaseName, navigation);
	    	  tr.addTestCase();
	    	  bp.waitForElement();
	    	  tr.clickOnDetails();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",2,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",2,1);
	    	  actual[17]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	  @When("^Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup$")
	  public void launch_TestPlanning_Naviagate_to_Created_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[18]=rp.clickOnTestPlanning();
	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,0);
	    	  actual[19]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  actual[20]=tp.navigateToCycle(cycleName);
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

	  @When("^Click on Sync button and Read the Message$")
	  public void click_on_Sync_button_and_Read_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[21]=tp.sync(check);
	    	  
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

	  @When("^Launch TestRepository, Navigate to Created Phase and Add System to Phase$")
	  public void launch_TestRepository_Navigate_to_Created_Phase_and_Add_System_to_Phase() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  bp.waitForElement();
	    	  actual[22]=rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[23]=tr.navigateToNode(releaseName, navigation);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,4);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,5);
	    	  actual[24]=tr.addNode(Name, Desc);
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

	  @When("^Click on Sync button and View the Message$")
	  public void click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[25]=tp.sync(check);
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

	  @When("^Launch TestRepository,Naviagte to Created System and Add Testcase and Edit the Testcase Name and Description$")
	  public void launch_TestRepository_Naviagte_to_Created_System_and_Add_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  bp.waitForElement();
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[2];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,4);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[26]=tr.navigateToNode(releaseName, navigation);
	    	  actual[27]=tr.addTestCase();
	    	  tr.clickOnDetails();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",2,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",2,1);
	    	  actual[28]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  
	    	  tr.clickOnList();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[29]=tr.navigateToNode(releaseName, navigation);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",3,4);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",3,5);
	    	  actual[30]=tr.addNode(Name, Desc);
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

	  @Then("^Launch TestRepository,Naviagte to Created Sub_System and Add Testcase and Edit the Testcase Name and Description$")
	  public void launch_TestRepository_Naviagte_to_Created_Sub_System_and_Add_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  bp.waitForElement();
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[3];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,4);
	    	  navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,4);
	    	  navigation[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",3,4);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[31]=tr.navigateToNode(releaseName, navigation);
	    	  tr.addTestCase();
	    	  tr.clickOnDetails();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",2,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TestCase",2,1);
	    	  actual[32]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);  
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
	  
	  @Then("^Newly added testcases are Viewed Successfully$")
	  public void newly_added_testcases_are_Viewed_Successfully() throws Throwable 
	  {
		  try
		  {
		  log.info("Pass - Newly added testcases are Viewed Successfully");
		  
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
