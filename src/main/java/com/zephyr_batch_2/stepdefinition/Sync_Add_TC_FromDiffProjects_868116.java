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

public class Sync_Add_TC_FromDiffProjects_868116 extends LaunchBrowser
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
	String fileName="Sync_868116";
	
	boolean[] actual=new boolean[58];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^Select the Projectone for the TestPlanning$")
	  public void select_the_Projectone_for_the_TestPlanning() throws Throwable 
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

	  @Given("^Click on relese in release Summary$")
	  public void click_on_relese_in_release_Summary() throws Throwable 
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

	  @When("^Launch TestRepository and Create a Phase With Nmae and Description$")
	  public void launch_TestRepository_and_Create_a_Phase_With_Nmae_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,1);
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

	  @When("^Navigate to Created Phase Add Testcase and Edit the Testcase Name and Description$")
	  public void navigate_to_Created_Phase_Add_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",3,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",3,1);
	    	  actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	    	  tp=new TestPlanningPage(driver);
	    	  actual[6]= rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  actual[7]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,100);
	    	  actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,8));
	    	  actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	    	  bp.waitForElement();
	    	  tp.saveTestCycle();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  actual[10]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  actual[11]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,9);
	    	  actual[12]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  actual[13]=tp.getPhaseCount(phaseName);
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

	  @When("^Select the Projecttwo for the TestPlanning$")
	  public void select_the_Projecttwo_for_the_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	     pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ip=new ImportPage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_2");
		    	 actual[14]= pp.selectProject(projectName);
		    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[15]= pp.selectRelease(releaseName);
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

	  @Then("^Launch TestRepository and Create a Phase with Nmae and DescriPtion$")
	  public void launch_TestRepository_and_Create_a_Phase_with_Nmae_and_DescriPtion() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.clickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,1);
	    	  actual[16]= tr.addNode(Name, Desc);
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

	  @Then("^Navigate to Created PhasE Add Testcase and Edit the Testcase Name and Description$")
	  public void navigate_to_Created_PhasE_Add_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  actual[17]=tr.navigateToNode(releaseName, navigation);
	    	  actual[18]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",4,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",4,1);
	    	  actual[19]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	  @When("^Launch TestPlanning Craete Exicution Cycle$")
	  public void launch_TestPlanning_Craete_Exicution_Cycle() throws Throwable 
	  {
	      try
	      {
	    	  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[20]= rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  actual[21]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,100);
	    	  actual[22]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",10,8));
	    	  actual[23]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
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

	  @When("^Add a Phase in Created exicution Cycle Choose Existing Phase Save it and Choose 'Assign to Anyone'$")
	  public void add_a_Phase_in_Created_exicution_Cycle_Choose_Existing_Phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  actual[24]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  actual[25]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,9);
	    	  actual[26]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  actual[27]=tp.getPhaseCount(phaseName);
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

	  @When("^Launch TestRepository Naviagtate to Craeted Phase and ContextClick Select Copy from Other  Projects$")
	  public void launch_TestRepository_Naviagtate_to_Craeted_Phase_and_ContextClick_Select_Copy_from_Other_Projects1() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[28]=rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[29]=tr.navigateToNode(releaseName, navigation);
	    	  actual[30]=tr.clickOnCopyFromProjects();
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

	  @When("^Expand the Created Project and Release Select a Phase and Drag it  and Drop in the Selected Project$")
	  public void expand_the_Created_Project_and_Release_Select_a_Phase_and_Drag_it_and_Drop_in_the_Selected_Project1() throws Throwable 
	  {
	      try
	      {
	    	  cfp=new CopyFromProjects(driver);
	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	  actual[31]=cfp.selectProjectFromGlobalArea(projectName);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String nodes[]=new String[1];
	    	  nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  actual[32]=cfp.selectNodeFromGlobalArea(releaseName, nodes);
	    	  String nodeName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  actual[33]=cfp.dragAndDropNodes(nodeName1, nodeName2);
	    	  actual[34]=cfp.closeCopyFromProjectReleasesPage();
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

	  @Then("^Launch TestPlanning, Naviagate to Dropped Phase and  ContextClick Choose Assign and Cancel the Popup$")
	  public void launch_TestPlanning_Naviagate_to_Dropped_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup1() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[35]=rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  actual[36]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",4,0);
	    	  actual[37]=tp.navigateToCycle(cycleName);
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

	  @Then("^Click on Sync button and View The Message$")
	  public void click_on_Sync_button_and_View_The_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[38]=tp.sync(check);
	    	  
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

	  @When("^Select 'SampleProject' Select Created Release and Launch it$")
	  public void select_SampleProject_Select_Created_Release_and_Launch_it() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ip=new ImportPage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[39]= pp.selectProject(projectName);
		    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[40]= pp.selectRelease(releaseName);
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

	  @When("^Launch TestRepository and Create a Phase with Nmae and DescriptiOn$")
	  public void launch_TestRepository_and_Create_a_Phase_with_Nmae_and_DescriptiOn() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.clickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",5,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",5,1);
	    	  actual[41]= tr.addNode(Name, Desc);
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

	  @When("^NavigatE to Created Phase,Add Testcase and Edit the Testcase Name and Description$")
	  public void navigate_to_Created_Phase_Add_Testcase_and_Edit_the_Testcase_Name_and_Description1() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",5,0);
	    	  actual[42]=tr.navigateToNode(releaseName, navigation);
	    	  actual[43]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",5,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",5,1);
	    	  actual[44]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	  @When("^Select the Projectone in Project dropdown and Select Release and Launch it$")
	  public void select_the_Projectone_in_Project_dropdown_and_Select_Release_and_Launch_it() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ip=new ImportPage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[45]= pp.selectProject(projectName);
		    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[46]= pp.selectRelease(releaseName);
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

	  @Then("^Launch TestRepository Naviagtate to Craeted Phase and ContextClick Select Copy from Other Projects$")
	  public void launch_TestRepository_Naviagtate_to_Craeted_Phase_and_ContextClick_Select_Copy_from_Other_Projects() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[47]=rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  bp.waitForElement();
	    	  actual[48]=tr.navigateToNode(releaseName, navigation);
	    	  actual[49]=tr.clickOnCopyFromProjects();
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

	  @Then("^Expand the Created Project and Release Select a Phase and Drag it and Drop in the Selected Project$")
	  public void expand_the_Created_Project_and_Release_Select_a_Phase_and_Drag_it_and_Drop_in_the_Selected_Project() throws Throwable 
	  {
	      try
	      {
	    	  cfp=new CopyFromProjects(driver);
	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	  actual[50]= cfp.selectProjectFromGlobalArea(projectName);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String nodes[]=new String[1];
	    	  nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",5,0);
	    	  actual[51]=cfp.selectNodeFromGlobalArea(releaseName, nodes);
	    	  String nodeName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",5,0);
	    	  String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  actual[52]=cfp.dragAndDropNodes(nodeName1, nodeName2);
	    	  actual[53]=cfp.closeCopyFromProjectReleasesPage();
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

	  @Then("^Launch TestPlanning Naviagate to Dropped Phase and ContextClick Choose Assign and Cancel the Popup$")
	  public void launch_TestPlanning_Naviagate_to_Dropped_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[54]=rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  actual[55]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",10,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",3,0);
	    	  actual[56]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  actual[57]= tp.assignPhase();
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
	  
	  @Then("^Testcases are Added from different Projects successfully$")
	  public void testcases_are_Added_from_different_Projects_successfully() throws Throwable 
	  {
	      try
	      {
	    	  
	    	  //tp.goBackToCycle();
	    	  log.info("Pass - Testcases are Added from different Projects successfully");
	    	  
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
