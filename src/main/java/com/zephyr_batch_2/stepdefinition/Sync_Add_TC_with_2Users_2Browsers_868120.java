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

public class Sync_Add_TC_with_2Users_2Browsers_868120 extends LaunchBrowser
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
	
	boolean[] actual=new boolean[40];
	  SoftAssert soft=new SoftAssert();
	  String filename="Sync_Add_TC_with_2Users_2Browsers_868120";
	  @Given("^Select the Project For The TestPlaNning$")
	  public void select_the_Project_For_The_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
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
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on relese in Release suMmary$")
	  public void click_on_relese_in_Release_suMmary() throws Throwable 
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

	  @When("^Launch Testrepository and Create a phase$")
	  public void launch_Testrepository_and_Create_a_phase() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,1);
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

	  @Then("^Navigate to Created phase and Add Testcase and Edit the Testcase Nmae and description$")
	  public void navigate_to_Created_phase_and_Add_Testcase_and_Edit_the_Testcase_Nmae_and_description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",11,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",11,1);
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

	  @Then("^Select the Added Testcase and clone it$")
	  public void select_the_Added_Testcase_and_clone_it() throws Throwable 
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
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestPlanning and CreAte Exicution Cycle$")
	  public void launch_TestPlanning_and_CreAte_Exicution_Cycle() throws Throwable 
	  {
	      try
	      {
	    	  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[7]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[8]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",22,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,100);
	    	  actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",22,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",22,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",22,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",22,8));
	    	  actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
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

	  @When("^Add a Phase in Created ExIcution Cycle, Choose Existing Phase, Save it and View the counts$")
	  public void add_a_Phase_in_Created_ExIcution_Cycle_Choose_Existing_Phase_Save_it_and_View_the_counts() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,0);
	    	  actual[11]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[12]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,9);
	    	  actual[13]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[14]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  tp.goBackToCycle();
	      }
	      
	      catch(Exception e)
			{
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and Add new Testcase to the Phase Save it and Choose 'Assign to Anyone'$")
	  public void launch_TestRepository_and_Add_new_Testcase_to_the_Phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[15]=tr.navigateToNode(releaseName, navigation);
	    	  actual[16]=tr.addTestCase();
	    	  actual[17]= rp.clickOnTestPlanning();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,0);
	    	  actual[18]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[19]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,9);
	    	  actual[20]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[21]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  tp.goBackToCycle();
	    	  //rp.clickOnTestRep();
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

	  @Then("^Login as Tester Launch TestRepository and Navigate to Created Phase, Add Testcase and Logout$")
	  public void login_as_Tester_Launch_TestRepository_and_Navigate_to_Created_Phase_Add_Testcase_and_Logout() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  LaunchBrowser bt1=new LaunchBrowser();
	    	  actual[19]= bt1.preCond2("chromeBrowser");
	    		String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    		 bt1.getUrl2(url,driver2);
	    		LoginPage lpg=new LoginPage(driver2);
	    		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
	    		actual[22]= lpg.enterUname2(uname,driver2);
	    		actual[23]= lpg.enterPass2(uname,driver2);
	    		actual[24]= lpg.clickOnLogin2(driver2);
	    		
	    		ProjectPage pp1=new ProjectPage(driver2);
	    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    		actual[25]= pp1.selectProject2(project,driver2);
	    		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    		pp1.selectRelease2(releaseName,driver2);
	    		ReleasePage rp1=new ReleasePage(driver2);
	    		actual[26]= rp1.clickOnTestRep2(driver2);
	    		
	    		TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		    	String navigation[]=new String[1];
		    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
		    	actual[27]= tr1.navigateToNode2(releaseName, navigation, driver2);
		    	actual[28]= tr1.addTestCase2(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Login as Manager Launch TestPlanning and Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup$")
	  public void login_as_Manager_Launch_TestPlanning_and_Naviagate_to_Created_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[29]=rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,0);
	    	  actual[30]=tp.doubleClickOnCycle(cycleName1);
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
	    	  actual[31]=tp.navigateToCycle(cycleName);
	    	  
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

	  @When("^Click on Sync button and VIew the Message$")
	  public void click_on_Sync_button_and_VIew_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  actual[32]= tp.assignPhase();
	    	  
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

	  @When("^Add a Phase in Created Exicution CyclE Choose Existing Phase, Save it and Choose 'Assign to Anyone' and Logout$")
	  public void add_a_Phase_in_Created_Exicution_CyclE_Choose_Existing_Phase_Save_it_and_Choose_Assign_to_Anyone_and_Logout() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,11);
	    	  actual[33]=tp.sync(check);
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

	  @When("^Login as Tester in Different Browser and Launch TestRepository Navigate to Created Phase, Create a System with Name and Description$")
	  public void login_as_Tester_in_Different_Browser_and_Launch_TestRepository_Navigate_to_Created_Phase_Create_a_System_with_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		    	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
		    	actual[34]=tr1.selectPhase2(phaseName, driver2);
		    	String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",15,0);
	    		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",15,1);	
	    		actual[35]= tr1.addNode2(Name, Desc,driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where Logged in as Lead Click on Sync button and View the Message$")
	  public void browser_where_Logged_in_as_Lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",22,11);
	    	  actual[36]=tp.sync(check);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
				pp.closeBrowser();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Browser where Logged in as Manager Navigate to System Created and Add testcase edit Name and Description$")
	  public void browser_where_Logged_in_as_Manager_Navigate_to_System_Created_and_Add_testcase_edit_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		    	actual[37]= tr1.addTestCase2(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Browser where Logged in as Manager Navigate to System Created, ContextClick and Create Sub-System with Name and Description$")
	  public void browser_where_Logged_in_as_Manager_Navigate_to_System_Created_ContextClick_and_Create_Sub_System_with_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr1.doubleClickOnRelease2(releaseName, driver2);
		    	
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Browser where Logged in as Manager Navigate to Sub-System Created and Add testcase edit Name and Description$")
	  public void browser_where_Logged_in_as_Manager_Navigate_to_Sub_System_Created_and_Add_testcase_edit_Name_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			  String navigation[]=new String[2];
		    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",14,0);
		    	navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",15,0);
		    	actual[38]= tr1.navigateToNode2(releaseName, navigation, driver2);
		    	bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Browser where Logged in as Manager Navigate to Sub-System Created, ContextClick and Rename it$")
	  public void browser_where_Logged_in_as_Manager_Navigate_to_Sub_System_Created_ContextClick_and_Rename_it() throws Throwable 
	  {
		  try
	      {
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		    	String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",17,0);
	    		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",17,1);
		    	actual[39]=tr1.renameNode2(Name, Desc,driver2);
		    	
		    	bp.waitForElement();
		    	bp.waitForElement();
	    		ProjectPage pp1=new ProjectPage(driver2);
	    		pp1.clickOnLogout(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }  
	  
	  @Then("^Sync is Successfull while adding testcase in another Browser$")
	  public void sync_is_Successfull_while_adding_testcase_in_another_Browser() throws Throwable 
	  {
	      try
	      {
	    	  
	    	  tp.goBackToCycle();
	    	  pp.clickOnLogout();
			  pp.closeBrowser();
	    	  log.info("Pass - Sync is Successfull while adding testcase in another Browser");
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
