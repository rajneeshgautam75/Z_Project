package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Sync_TC_AddedBy_OtherUser_OtherBrowser_868118 extends LaunchBrowser
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
	
	boolean[] actual=new boolean[33];
	  SoftAssert soft=new SoftAssert();
	  
	  String filename="Sync_TC_AddedBy_OtherUser_OtherBrowser_868118";
	  @Given("^Select the ProjectOnE for the TestPlanning$")
	  public void select_the_ProjectOnE_for_the_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	  
//	    	  LaunchBrowser bt1=new LaunchBrowser();
//	    	  actual[15]= bt1.preCond2("ieBrowser");
//	    	  String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
//	    		 bt1.getUrl2(url,driver2);
//	    		LoginPage lpg=new LoginPage(driver2);
//	    		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
//	    		actual[16]= lpg.enterUname2(uname,driver2);
//	    		actual[17]= lpg.enterPass2(uname,driver2);
//	    		actual[18]= lpg.clickOnLogin2(driver2);
//	    		
//	    		ProjectPage pp1=new ProjectPage(driver2);
//	    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
//	    		pp1.selectProject2(project,driver2);
//	    		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
//	    		pp1.selectRelease2(releaseName,driver2);
//	    		ReleasePage rp1=new ReleasePage(driver2);
//	    		rp1.clickOnTestRep2(driver2);
//	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
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
				//Relogin_TPE rl=new Relogin_TPE();
				//rl.reLogin();
				throw e;
			}
	  }

	  @Given("^Click on rElese in release summary$")
	  public void click_on_rElese_in_release_summary() throws Throwable 
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
				//Relogin_TPE rl=new Relogin_TPE();
				//rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepositorY and Create a Phase with Nmae and Description$")
	  public void launch_TestRepositorY_and_Create_a_Phase_with_Nmae_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,1);
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

	  @When("^Navigate to CreatEd Phase Add Testcase and Edit the Testcase Name and Description$")
	  public void navigate_to_CreatEd_Phase_Add_Testcase_and_Edit_the_Testcase_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",7,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",7,1);
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

	  @When("^Select tHe Added Testcase and Clone it$")
	  public void select_tHe_Added_Testcase_and_Clone_it() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  tr.selectallTestCase();
	    	  bp.waitForElement();
	    	  actual[6]=tr.cloneTestCase();
	    	  bp.waitForElement();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
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

	  @Then("^Launch TestPlanning and Create EXicution Cycle$")
	  public void launch_TestPlanning_and_Create_EXicution_Cycle() throws Throwable 
	  {
	      try
	      {
	    	  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[7]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[8]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",16,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,100);
	    	  actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",16,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",16,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",16,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",16,8));
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

	  @Then("^Add a phase in Created Exicution Cycle Choose Existing Phase, Save it and Choose 'Assign to Anyone'$")
	  public void add_a_phase_in_Created_Exicution_Cycle_Choose_Existing_Phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,0);
	    	  actual[11]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    	  actual[12]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",16,9);
	    	  actual[13]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    	  actual[14]=tp.getPhaseCount(phaseName);
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

	  @When("^Login as Tester and Launch TestRepository Navigate to Created Phase, Add Testcase and Logout$")
	  public void login_as_Tester_and_Launch_TestRepository_Navigate_to_Created_Phase_Add_Testcase_and_Logout() throws Throwable 
	  {
	      try
	      {
	    	  LaunchBrowser bt1=new LaunchBrowser();
	    	  actual[15]= bt1.preCond2("chromeBrowser");
	    	  String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    		 bt1.getUrl2(url,driver2);
	    		LoginPage lpg=new LoginPage(driver2);
	    		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
	    		actual[16]= lpg.enterUname2(uname,driver2);
	    		actual[17]= lpg.enterPass2(uname,driver2);
	    		actual[18]= lpg.clickOnLogin2(driver2);
	    		
	    		ProjectPage pp1=new ProjectPage(driver2);
	    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    		pp1.selectProject2(project,driver2);
	    		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    		pp1.selectRelease2(releaseName,driver2);
	    		ReleasePage rp1=new ReleasePage(driver2);
	    		rp1.clickOnTestRep2(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
	    	  ///tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Login as Manager/Lead Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup$")
	  public void login_as_Manager_Lead_Launch_TestPlanning_Naviagate_to_Created_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    		String navigation[]=new String[1];
	    		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    		actual[19]= tr1.navigateToNode2(releaseName, navigation, driver2);
	    		actual[20]= tr1.addTestCase2(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	 // tr1.driverClose(driver2);
	    	  pp.closeBrowser();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Click on Sync button and ViEw the Message$")
	  public void click_on_Sync_button_and_ViEw_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",1,10);
	    	  actual[21]=tp.sync(check);
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

	  @Then("^Add a Phase in Created Exicution Cycle Choose Existing Phase, Save it and Choose 'Assign to Anyone' and Logout$")
	  public void add_a_Phase_in_Created_Exicution_Cycle_Choose_Existing_Phase_Save_it_and_Choose_Assign_to_Anyone_and_Logout() throws Throwable 
	  {
	      try
	      {
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    		actual[22]=tr1.selectPhase2(phaseName,driver2);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  //tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
	    	  pp.closeBrowser();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Login as Tester in Different Browser and Launch TestRepository, Navigate to Created Phase, Create a System with Name and Description$")
	  public void login_as_Tester_in_Different_Browser_and_Launch_TestRepository_Navigate_to_Created_Phase_Create_a_System_with_Name_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",9,0);
	    		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",9,1);	
	    		actual[23]= tr1.addNode2(Name, Desc,driver2);
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
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where login as manager/lead Click on Sync button and View the Message$")
	  public void browser_where_login_as_manager_lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[24]=tp.sync(check);
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

	  @When("^Browser where login as tester Navigate to Created Phase, Add Testcase and Edit its Name and Description and Save it$")
	  public void browser_where_login_as_tester_Navigate_to_Created_Phase_Add_Testcase_and_Edit_its_Name_and_Description_and_Save_it() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    		actual[25]= tr1.addTestCase2(driver2);
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

	  @Then("^Browser where login as manageR/lead Click on Sync button and View the Message$")
	  public void browser_where_login_as_manageR_lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[26]=tp.sync(check);
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

	  @When("^Browser where login as tester Navigate to Created Phase, Create System with Nmae and Description$")
	  public void browser_where_login_as_tester_Navigate_to_Created_Phase_Create_System_with_Nmae_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  
	    		actual[27]= tr1.addTestCase2(driver2);
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
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where login as managere/lead Click on Sync button and View the Message$")
	  public void browser_where_login_as_managere_lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[28]=tp.sync(check);
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

	  @When("^Browser where login as tester Navigate to Created System, Add Testcase and Edit its Name and Description and Save it$")
	  public void browser_where_login_as_tester_Navigate_to_Created_System_Add_Testcase_and_Edit_its_Name_and_Description_and_Save_it() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    		actual[29]= tr1.addTestCase2(driver2);
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

	  @Then("^Browser where login as manaGer/lead Click on Sync button and View the Message$")
	  public void browser_where_login_as_manaGer_lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[30]=tp.sync(check);
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

	  @When("^Browser where login as tester Navigate to Created System, ContextClick and Rename it$")
	  public void browser_where_login_as_tester_Navigate_to_Created_System_ContextClick_and_Rename_it() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",8,0);
	    		tr1.selectPhase2(phaseName,driver2);
	    		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",10,0);
	    		String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",10,1);
	    		actual[31]= tr1.renameNode2(name, desc,driver2);
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
//	    	  pp.clickOnLogout();
//	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Browser where login as Manager/lead Click on Sync button and View the Message$")
	  public void browser_where_login_as_Manager_lead_Click_on_Sync_button_and_View_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[32]=tp.sync(check);
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
