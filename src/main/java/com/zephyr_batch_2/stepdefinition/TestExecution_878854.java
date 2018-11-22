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

public class TestExecution_878854 extends LaunchBrowser
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
	
	boolean[] actual=new boolean[45];
	  SoftAssert soft=new SoftAssert();
	
	  String fileName="TestExecution_878854";



@Given("^User Selects the Project, Release$")
public void user_Selects_the_Project_Release() throws Throwable {
	try
    {

           lb=new LaunchBrowser();
  	      pp=new ProjectPage(driver);
		  tr=new TestRepositoryPage(driver);
		  tp=new TestPlanningPage(driver);
		  bp=new BasePage();
	    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	 actual[0]= pp.selectProject(projectName); 
	    	  
		    	 actual[1]= pp.selectRelease(releaseName);
    }
    catch(Exception e)
		{
    	lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^launch the TestRepository module$")
public void launch_the_TestRepository_module() throws Throwable {
	try
    {
		  rp=new ReleasePage(driver);
		  actual[2]= rp.clickOnTestRep();
    }
    catch(Exception e)
		{
    	lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^launch another browser, Login as Manager$")
public void launch_another_browser_Login_as_Manager() throws Throwable {
	 try
     {
		  LaunchBrowser bt1=new LaunchBrowser();
   	  actual[3]= bt1.preCond2("FBrowser");
   		String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
   		 bt1.getUrl2(url,driver2);
   		LoginPage lpg=new LoginPage(driver2);
   		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_2");
   		actual[4]= lpg.enterUname2(uname,driver2);
   		actual[5]= lpg.enterPass2(uname,driver2);
   		actual[6]= lpg.clickOnLogin2(driver2);
     }
     catch(Exception e)
		{
    	 lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^select Project and Release$")
public void select_Project_and_Release() throws Throwable {
	 try
     {
		  ProjectPage pp1=new ProjectPage(driver2);
   		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
   		actual[7]= pp1.selectProject2(project,driver2);
   		
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			  actual[8]=pp1.selectRelease2(releaseName,driver2);
     }
     catch(Exception e)
		{
    	 lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^Launch Test Execution Module and Select release$")
public void launch_Test_Execution_Module_and_Select_release() throws Throwable {
	 try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		ReleasePage rp1=new ReleasePage(driver);
		actual[9]= rp1.clickOnTestExecution2(driver2);
		TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		actual[10]= tr1.doubleClickOnRelease2(releaseName, driver2);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^In first Browser, Creates Phase, System and Subsystem with name and Description$")
public void in_first_Browser_Creates_Phase_System_and_Subsystem_with_name_and_Description() throws Throwable {
	 try
     {
	 
	   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
   	  tr.doubleClickOnRelease(releaseName);
   	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,0);
   	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,1);
   	  actual[11]= tr.addNode(Name, Desc);
   	  
   	  
   	  bp.waitForElement();
   	  
  	String[] phase=new String[1];
 	  phase[0]=Name;
 	  
 	  actual[12]=tr.navigateToNode(releaseName, phase);
   	  //bp.waitForElement();
   	  //actual[12]= tr.selectPhase(Name);
   	  
   	 String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",39,0);
   	  String Desc2=Excel_Lib.getData(INPUT_PATH,"TP_Phases",39,1);
     	actual[13]= tr.addNode(Name2, Desc2);
   	  
     	actual[14]= tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
   	  
   	  String[] navigation=new String[2];
   	  navigation[0]=Name;
   	  navigation[1]=Name2;
   	   actual[15]= tr.navigateToNode(releaseName, navigation);
   	  String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",40,0);
   	  String Desc3=Excel_Lib.getData(INPUT_PATH,"TP_Phases",40,1);
   	  
   	  actual[16]=  tr.addNode(Name3, Desc3);
   	  
   	  actual[17]= tr.doubleClickOnRelease(releaseName);
     }
	 catch(Exception e)
		{
		 lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@Then("^Navigates to Created Node and Adds the Testcase with Name and Description$")
public void navigates_to_Created_Node_and_Adds_the_Testcase_with_Name_and_Description() throws Throwable {
	 try
     {
		  BasePage bp=new BasePage();
   	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
   	  String navigation[]=new String[3];
   	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,0);
   	  navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",39,0);
   	  navigation[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",40,0);
   	  actual[18]=tr.navigateToNode(releaseName, navigation);
   	  actual[19]=tr.addTestCase();
   	  bp.waitForElement();
//   	  tr.clickDetailButton();
//   	  ctc=new CreateTestCasePage(driver);
//   	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",26,0);
//   	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",26,1);
//   	  ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
//   	  
//   	  
//   	  bp.waitForElement();
//   	  tr.clickOnList();
   	  tr.selectPhase(navigation[1]);
   	  
   	  actual[20]=tr.addTestCase();
  	  bp.waitForElement();
//  	  tr.clickDetailButton();
//  	  ctc=new CreateTestCasePage(driver);
//  	  String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",27,0);
//  	  String testCaseDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",27,1);
//  	  ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
  	  
  	  
  	bp.waitForElement();
 	 // tr.clickOnList();
 	  tr.selectPhase(navigation[0]);
 	  
 	  actual[21]=tr.addTestCase();
//	  bp.waitForElement();
//	  tr.clickDetailButton();
//	  ctc=new CreateTestCasePage(driver);
//	  String testCaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",28,0);
//	  String testCaseDesc3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",28,1);
//	  ctc.enterTestCaseNameAndDesc(testCaseName3, testCaseDesc3);
     }
     catch(Exception e)
		{
    	 lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^Launch the Testplanning and Creates the TestExecution Cycle$")
public void launch_the_Testplanning_and_Creates_the_TestExecution_Cycle() throws Throwable {
	try
    {
		 
  	  BasePage bp=new BasePage();
  	  actual[22]= rp.clickOnTestPlanning();
  	  bp.waitForElement();
  	  //tp=new TestPlanningPage(driver);
  	  actual[23]= tp.clickOnAddTestCycleSymbol();
  	  bp.waitForElement();
  	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,0);
  	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",67,1));
  	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,2);
  	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,100);
  	  actual[24]=tp.CreateCycle(cycle, Build, environ, hide);
  	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",67,3));
  	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,4);
  	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",67,5));
  	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",67,6));
  	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,7);
  	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",67,8));
  	  actual[25]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
  	  bp.waitForElement();
  	 actual[26]= tp.saveTestCycle();
    }
    catch(Exception e)
		{
    	lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@When("^Adds Phase to the cycle and Assign to the Manager$")
public void adds_Phase_to_the_cycle_and_Assign_to_the_Manager() throws Throwable {
	 try
     {
		  BasePage bp=new BasePage();
   	  bp.waitForElement();
   	  String cycleName[]=new String[1];
   	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,0);
   	  actual[27]=tp.navigateToCycle(cycleName);
   	  bp.waitForElement();
   	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,0);
   	  actual[28]= tp.addPhaseToCycle(Phase);
   	  bp.waitForElement();
   	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe CTP_Phasesycle",67,9);
   	  actual[29]=tp.bulkAssignment(Bulk_type);
   	  bp.waitForElement();
   	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,0);
   	  actual[30]=tp.getPhaseCount(phaseName);
   	  bp.waitForElement();
   	  
   	String phase[]=new String[1];
	  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,0);
	  actual[31]= tp.navigateToCycle(phase);
	  int[] testcase=new int[1];
	  testcase[0]=+Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3);
	  String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User4");
	  actual[32]= tp.individualAssinTo(testcase, assignee);
	  
	  tp.goBackToCycle();
     }
     catch(Exception e)
		{
    	 lb.getScreenShot(fileName);
			driver.close();
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
}

@Then("^In Second Browser, Apply the Notifications for Manager$")
public void in_Second_Browser_Apply_the_Notifications_for_Manager() throws Throwable {
	  try
	    {
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	  	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	  	  actual[33]=tr1.applyNotification2(releaseName, driver2);
	  	  
	  	  
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

@When("^In first Browser, Launch test planning and delete phase$")
public void in_first_Browser_Launch_test_planning_and_delete_phase() throws Throwable {
	try
    {
		//String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		String[] nodes=new String[2];
		
		nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,0);
		nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",38,0);
		//rp=new ReleasePage(driver);
		actual[34]= rp.clickOnTestPlanning();
  	  
		actual[35]= tp.doubleClickOnCycle(nodes[0]);
		actual[36]= tp.navigateToCycle(nodes);
		actual[37]=  tp.deleteNode();
    }
  	catch(Exception e)
	{
  		lb.getScreenShot(fileName);
		driver.close();
//		Relogin_TPE rl=new Relogin_TPE();
//		rl.reLogin();
		throw e;
	}
  	 
}

@Then("^In Second Browser, check and Apply Notifications$")
public void in_Second_Browser_check_and_Apply_Notifications() throws Throwable {
	
	try
	{
	TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	  actual[38]=tr1.applyNotification2(releaseName, driver2);
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
//		Relogin_TPE rl=new Relogin_TPE();
//		rl.reLogin();
		throw e;
	}
  	 
}

@When("^In first Browser, Launch test planning and delete cycle$")
public void in_first_Browser_Launch_test_planning_and_delete_cycle() throws Throwable {
	
	try
	{
	String[] nodes=new String[1];
	
	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",67,0);
	//nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
	//rp=new ReleasePage(driver);
	actual[39]= rp.clickOnTestPlanning();
	  
	actual[40]= tp.navigateToCycle(nodes);
	actual[41]= tp.deleteNode();
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
//		Relogin_TPE rl=new Relogin_TPE();
//		rl.reLogin();
		throw e;
	}
  	 
}

@Then("^In Second Browser, Check and Apply Notifications$")
public void in_Second_Browser_Check_and_Apply_Notifications() throws Throwable {
	try
	{
		 BasePage bp=new BasePage();
	TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	  actual[42]=tr1.applyNotification2(releaseName, driver2);
	log.info("Pass - Notifications are applied in another Browser");
	
	 bp.waitForElement();
	ProjectPage pp1=new ProjectPage(driver2);
	actual[43]= pp1.clickOnLogout(driver2);
	  
	 
	  bp.waitForElement();
	  actual[44]= pp.closeBrowser();
	  
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
//		Relogin_TPE rl=new Relogin_TPE();
//		rl.reLogin();
		throw e;
	}
}


}
