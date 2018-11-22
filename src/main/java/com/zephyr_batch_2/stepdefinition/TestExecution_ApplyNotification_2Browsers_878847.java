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

public class TestExecution_ApplyNotification_2Browsers_878847 extends LaunchBrowser
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
	
	boolean[] actual=new boolean[22];
	  SoftAssert soft=new SoftAssert();
	  
	  String fileName="TestExecution_ApplyNotification_2Browsers_878847";
	  
	  @Given("^Lead Login into Zephyr Application$")
	  public void lead_Login_into_Zephyr_Application() throws Throwable 
	  {
	      try
	      {
	    	  lb=new LaunchBrowser();
			  pp=new ProjectPage(driver);
			  tr=new TestRepositoryPage(driver);
			  tp=new TestPlanningPage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[0]= pp.selectProject(projectName); 
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Selects the Project, Release$")
	  public void selects_the_Project_Release() throws Throwable 
	  {
		  try
	      {
			  
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[1]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch the TestRepository$")
	  public void launch_the_TestRepository() throws Throwable 
	  {
		  try
	      {
			  rp=new ReleasePage(driver);
	    	  rp.clickOnTestRep();
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Launch another browser, Login as Manager$")
	  public void launch_another_browser_Login_as_Manager() throws Throwable 
	  {
		  try
	      {
			  LaunchBrowser bt1=new LaunchBrowser();
	    	  actual[2]= bt1.preCond2("FBrowser");
	    		String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    		 bt1.getUrl2(url,driver2);
	    		LoginPage lpg=new LoginPage(driver2);
	    		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_2");
	    		actual[3]= lpg.enterUname2(uname,driver2);
	    		actual[4]= lpg.enterPass2(uname,driver2);
	    		actual[5]= lpg.clickOnLogin2(driver2);
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select Project and Release$")
	  public void select_Project_and_Release() throws Throwable 
	  {
		  try
	      {
			  ProjectPage pp1=new ProjectPage(driver2);
	    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    		actual[6]= pp1.selectProject2(project,driver2);
	    		
				  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				  actual[7]=pp1.selectRelease2(releaseName,driver2);
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestExicution and Select Release$")
	  public void launch_TestExicution_and_Select_Release() throws Throwable 
	  {
		  try
	      {
			  ReleasePage rp1=new ReleasePage(driver2);
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    		actual[8]= rp1.clickOnTestExecution2(driver2);
	    		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    		 actual[9]=tr1.doubleClickOnRelease2(releaseName,driver2);
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^In first Browser, Creates Phase with name and Description$")
	  public void in_first_Browser_Creates_Phase_with_name_and_Description() throws Throwable 
	  {
		  try
	      {
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",29,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",29,1);
	    	  actual[10]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Navigates to Created Phase and Adds the Testcase with Name and Description$")
	  public void navigates_to_Created_Phase_and_Adds_the_Testcase_with_Name_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",29,0);
	    	  actual[11]=tr.navigateToNode(releaseName, navigation);
	    	  actual[12]=tr.addTestCase();
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch the Testplanning and Creates the TestExicution Cycle$")
	  public void launch_the_Testplanning_and_Creates_the_TestExicution_Cycle() throws Throwable 
	  {
		  try
	      {
			 
	    	  BasePage bp=new BasePage();
	    	  actual[13]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[14]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",49,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,100);
	    	  actual[15]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",49,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",49,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",49,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",49,8));
	    	  actual[16]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	    	  bp.waitForElement();
	    	  tp.saveTestCycle();
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Adds Phase to the Cycle and Assign to Manager$")
	  public void adds_Phase_to_the_Cycle_and_Assign_to_Manager() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,0);
	    	  actual[17]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",29,0);
	    	  actual[18]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",49,9);
	    	  actual[19]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",29,0);
	    	  actual[20]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  String phase1[]=new String[1];
	    	  phase1[0]=Phase;
	    	  tp.navigateToCycle(phase1);
	    	  int[] testcase=new int[1];
	    	  testcase[0]=1;
	    	  String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User4");
	    	  tp.individualAssinTo(testcase, assignee);
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^In Second Browser, Apply the Notification for Manager$")
	  public void in_Second_Browser_Apply_the_Notification_for_Manager() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  actual[21]=tr1.applyNotification2(releaseName, driver2);
	    	  bp.waitForElement();
	    	  
	    	  log.info("Pass - Notifications are applied in another Browser");
	    	  ProjectPage pp1=new ProjectPage(driver2);
	    	  pp1.clickOnLogout(driver2);
	    	 
	    	  
	    	  bp.waitForElement();
	    	  pp.closeBrowser();
              
	    	  
	    	  
	    	  for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
	      }
	      catch(Exception e)
			{
	    	  lb.getScreenShot(fileName);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  
}
