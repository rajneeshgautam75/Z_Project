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

public class Sync_AftrCopyNode_FromDiffProject_868119 extends LaunchBrowser
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
	
	boolean[] actual=new boolean[41];
	  SoftAssert soft=new SoftAssert();
	  String filename="Sync_AftrCopyNode_FromDiffProject_868119";
	  @Given("^Select the FirstProject for the TestPlanninG$")
	  public void select_the_FirstProject_for_the_TestPlanninG() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
	    	  bp=new BasePage();
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[0]= pp.selectProject(projectName); 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on relese in release Summaryy$")
	  public void click_on_relese_in_release_Summaryy() throws Throwable 
	  {
	      try
	      {
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[1]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and Create a Phase with Nmae and Descriptionn$")
	  public void launch_TestRepository_and_Create_a_Phase_with_Nmae_and_Descriptionn() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,1);
	    	  actual[2]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Navigate to Created Phase ADd Testcase and Edit the Testcase Name and Description$")
	  public void navigate_to_Created_Phase_ADd_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",8,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",8,1);
	    	  actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Select the FirstProject for the TestPlanning$")
	  public void select_the_FirstProject_for_the_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[6]= pp.selectProject(projectName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Click on relese in releasE summary$")
	  public void click_on_relese_in_releasE_summary() throws Throwable 
	  {
	      try
	      {
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[7]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and Create a Phase with Nmae and Descrption$")
	  public void launch_TestRepository_and_Create_a_Phase_with_Nmae_and_Descrption() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  rp.clickOnTestRep();
	    	  bp.waitForElement();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",12,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",12,1);
	    	  actual[8]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Navigate to Created Phase Add TestCase and Edit the Testcase Name and Description$")
	  public void navigate_to_Created_Phase_Add_TestCase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",12,0);
	    	  actual[9]=tr.navigateToNode(releaseName, navigation);
	    	  actual[10]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",9,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",9,1);
	    	  actual[11]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Launch TestPlanning and Create ExicutIon Cycle$")
	  public void launch_TestPlanning_and_Create_ExicutIon_Cycle() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_2");
		    	 actual[12]= pp.selectProject(projectName); 
		    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[13]= pp.selectRelease(releaseName);	 
		    	 bp.waitForElement();
		    	 rp.clickOnTestRep();
		    	 bp.waitForElement();
		    	  actual[14]=tr.doubleClickOnRelease(releaseName);
		    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",13,0);
		    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",13,1);
		    	  actual[15]= tr.addNode(Name, Desc);
		    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Add a Phase in Created Exicution Cycle, Choose Existing phase, Save it and Choose 'Assign to Anyone'$")
	  public void add_a_Phase_in_Created_Exicution_Cycle_Choose_Existing_phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
	      try
	      {
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",13,0);
	    	  actual[16]=tr.navigateToNode(releaseName, navigation);
	    	  actual[17]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",10,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",10,1);
	    	  actual[18]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  
	    	  tr.clickOnList();
    	  
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch another Browser and Login as Tester, Launch TestRepository, Naviagtate to Craeted Phase and ContextClick, Select Copy from Other Projects$")
	  public void launch_another_Browser_and_Login_as_Tester_Launch_TestRepository_Naviagtate_to_Craeted_Phase_and_ContextClick_Select_Copy_from_Other_Projects() throws Throwable 
	  {
	      try
	      {
	    	  
	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	  pp.selectProject(projectName);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  pp.selectRelease(releaseName);	
	    	  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  actual[19]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[20]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Expand the Created Project and Release, Select a Phase and Drag it and Drop in the Selected Project$")
	  public void expand_the_Created_Project_and_Release_Select_a_Phase_and_Drag_it_and_Drop_in_the_Selected_Project() throws Throwable 
	  {
	      try
	      {  
	    	  BasePage bp=new BasePage();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",19,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,100);
	    	  actual[21]=tp.CreateCycle(cycle, Build, environ, hide);  
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",19,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",19,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",19,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",19,8));
	    	  actual[22]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	    	  bp.waitForElement();
	    	  tp.saveTestCycle(); 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where login as manager/lead, Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup$")
	  public void browser_where_login_as_manager_lead_Launch_TestPlanning_Naviagate_to_Created_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,0);
	    	  actual[23]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,0);
	    	  actual[24]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",19,9);
	    	  actual[25]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,0);
	    	  actual[26]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();  
	    	  
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Click on Sync button aNd View the Message$")
	  public void click_on_Sync_button_aNd_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[27]=tp.sync(check);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch 'SampleProject' and Select Created Release$")
	  public void launch_SampleProject_and_Select_Created_Release() throws Throwable 
	  {
	      try
	      {   bp=new BasePage();
	    	  LaunchBrowser bt1=new LaunchBrowser();
	    	  actual[28]= bt1.preCond2("chromeBrowser");
	    		String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    		 bt1.getUrl2(url,driver2);
	    		LoginPage lpg=new LoginPage(driver2);
	    		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
	    		actual[29]= lpg.enterUname2(uname,driver2);
	    		actual[30]= lpg.enterPass2(uname,driver2);
	    		actual[31]= lpg.clickOnLogin2(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
	    	  //tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//			  Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepositOry and Create a Phase with Name and Description$")
	  public void launch_TestRepositOry_and_Create_a_Phase_with_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    		ProjectPage pp1=new ProjectPage(driver2);
	    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    		actual[32]= pp1.selectProject2(project,driver2);
	    		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    		pp1.selectRelease2(releaseName,driver2);
	    		ReleasePage rp1=new ReleasePage(driver2);
	    		actual[33]= rp1.clickOnTestRep2(driver2);
	    		bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
	    	 // tr1.driverClose(driver2);
//	    	  tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Navigate to Created Phase,Add Testcase and Edit the Testcase Name and Description$")
	  public void navigate_to_Created_Phase_Add_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	String navigation[]=new String[1];
		    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,0);
		    	actual[34]= tr1.navigateToNode2(releaseName, navigation, driver2);
		    	actual[35]=tr1.clickOnCopyFromProjects2(driver2);    
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
	    	  //tr1.driverClose(driver2);
//	    	  tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestPlanning, Naviagate To Created Phase and ContextClick, Choose Assign and Cancel the Popup$")
	  public void launch_TestPlanning_Naviagate_To_Created_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
//	    	  cfp=new CopyFromProjects(driver2);
//	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
//	    	  actual[36]=cfp.selectProjectFromGlobalArea2(projectName,driver2);
//	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
//	    	  String nodes[]=new String[1];
//	    	  nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",12,0);
//	    	  actual[37]=cfp.selectNodeFromGlobalArea2(releaseName, nodes, driver2);  
	      }
	      catch(Exception e)
			{
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
//	    	  pp.clickOnLogout2(driver2);
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where login as Tester, Launch TestRepository, Naviagtate to Craeted Phase and ContextClick, Select Copy from Other Projects$")
	  public void browser_where_login_as_Tester_Launch_TestRepository_Naviagtate_to_Craeted_Phase_and_ContextClick_Select_Copy_from_Other_Projects() throws Throwable 
	  {
	      try
	      {   
	    	  cfp=new CopyFromProjects(driver2);
	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	  actual[36]=cfp.selectProjectFromGlobalArea2(projectName,driver2);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String nodes[]=new String[1];
	    	  nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",12,0);
	    	  actual[37]=cfp.selectNodeFromGlobalArea2(releaseName, nodes, driver2);  
	    	  
	    	 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
	    	  //tr1.driverClose(driver2);
//	    	  tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Expand the Created Project and Release, Select a Phase and Drag it and Drop In the Selected Project$")
	  public void expand_the_Created_Project_and_Release_Select_a_Phase_and_Drag_it_and_Drop_In_the_Selected_Project() throws Throwable 
	  {
	      try
	      {  
	    	  String nodeName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",12,0);
	    	  String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",11,0);
	    	  actual[38]=cfp.dragAndDropNodes2(nodeName1, nodeName2,driver2);
	    	  actual[39]=cfp.closeCopyFromProjectReleasesPage2(driver2);
	    	  
	    	  bp.waitForElement();
	    	  bp.waitForElement();
	    		ProjectPage pp1=new ProjectPage(driver2);
	    		pp1.clickOnLogout(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
	    	  //tr1.driverClose(driver2);
//	    	  tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where login as manager/lead, Click on Sync button and View the Message$")
	  public void browser_where_login_as_manager_lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[40]=tp.sync(check);
	    	  bp.waitForElement();
	    	  tp.goBackToCycle();
	    	  bp.waitForElement();
	    	  pp.clickOnLogout();
			  pp.closeBrowser();
	    	  
	    	  log.info("Pass - Nodes are added to Phase from Other user in other Browser Successfully");
	    	  for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }
	
}
