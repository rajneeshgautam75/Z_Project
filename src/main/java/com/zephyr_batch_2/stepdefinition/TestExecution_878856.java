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

public class TestExecution_878856 extends LaunchBrowser 
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
	
	boolean[] actual=new boolean[24];
	  SoftAssert soft=new SoftAssert();
	  
	  String fileName="TestExecution_878856";
	@Given("^User Selects the Project and select the release$")
	public void user_Selects_the_Project_and_select_the_release() throws Throwable {
		try
	    {

           lb=new LaunchBrowser();
	  	    bp=new BasePage();  
			pp=new ProjectPage(driver);
			  tr=new TestRepositoryPage(driver);
			  tp=new TestPlanningPage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[0]= pp.selectProject(projectName); 
		    	  
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

	@When("^Launch the Test Repository Module$")
	public void launch_the_Test_Repository_Module() throws Throwable {
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

	@When("^launch Another browser, Login as manager$")
	public void launch_Another_browser_Login_as_manager() throws Throwable {
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

	@When("^Select the Project and Click on release$")
	public void select_the_Project_and_Click_on_release() throws Throwable {
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

	@When("^Launch Test Execution module and select Release$")
	public void launch_Test_Execution_module_and_select_Release() throws Throwable {
		 try
			{
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			ReleasePage rp1=new ReleasePage(driver);
			 actual[8]=rp1.clickOnTestExecution2(driver2);
			TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			 actual[9]=tr1.doubleClickOnRelease2(releaseName, driver2);
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

	@When("^In first Browser, Creates Phase,System and Subsystem with name and description$")
	public void in_first_Browser_Creates_Phase_System_and_Subsystem_with_name_and_description() throws Throwable {
		try
	     {
		  //tr=new TestRepositoryPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	   	  tr.doubleClickOnRelease(releaseName);
	   	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,0);
	   	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,1);
	   	  actual[10]= tr.addNode(Name, Desc);
	   	  
	   	  
	   	  bp.waitForElement();
	   	  
	   	String[] phase=new String[1];
	   	  phase[0]=Name;
	   	  
	   	  tr.navigateToNode(releaseName, phase);
//	   	  bp.waitForElement();
//	   	  tr.selectPhase(Name);
	   	  
	   	 String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",45,0);
	   	  String Desc2=Excel_Lib.getData(INPUT_PATH,"TP_Phases",45,1);
	   	  tr.addNode(Name2, Desc2);
	   	  
	   	  tr.doubleClickOnRelease(releaseName);
	   	  bp.waitForElement();
	   	  
	   	  String[] navigation=new String[2];
	   	  navigation[0]=Name;
	   	  navigation[1]=Name2;
	   	  tr.navigateToNode(releaseName, navigation);
	   	  String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",46,0);
	   	  String Desc3=Excel_Lib.getData(INPUT_PATH,"TP_Phases",46,1);
	   	  
	   	  tr.addNode(Name3, Desc3);
	   	  
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

	@Then("^Navigates to Created Nodes and Adds the Testcase with Name and Description$")
	public void navigates_to_Created_Nodes_and_Adds_the_Testcase_with_Name_and_Description() throws Throwable {
		 try
	     {
			  BasePage bp=new BasePage();
	   	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	   	  String navigation[]=new String[3];
	   	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,0);
	   	  navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",45,0);
	   	  navigation[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",46,0);
	   	  actual[11]=tr.navigateToNode(releaseName, navigation);
	   	  actual[12]=tr.addTestCase();
	   	  bp.waitForElement();
	   	  tr.clickDetailButton();
	   	  ctc=new CreateTestCasePage(driver);
	   	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",32,0);
	      String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",32,1);
	   	  ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	   	  
	   	  
	   	  bp.waitForElement();
	   	  tr.clickOnList();
	   	  tr.selectPhase(navigation[1]);
	   	  
	   	  actual[13]=tr.addTestCase();
	  	  bp.waitForElement();
	  	  tr.clickDetailButton();
	  	  ctc=new CreateTestCasePage(driver);
	  	  String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",33,0);
	      String testCaseDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",33,1);
	      ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
	      bp.waitForElement();
	   	  tr.clickOnList();
	   	  tr.selectPhase(navigation[0]);
	   	  tr.addTestCase();
	  	  //ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
	  	  bp.waitForElement();
	  	 tr.clickDetailButton();
	  	  ctc=new CreateTestCasePage(driver);
	  	  String testCaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",34,0);
	      String testCaseDesc3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",34,1);
	      
	  	  ctc.enterTestCaseNameAndDesc(testCaseName3, testCaseDesc3);
	  	tr.clickOnList();
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

	@When("^Launch the Test Planning module and Creates the Test execution Cycle$")
	public void launch_the_Test_Planning_module_and_Creates_the_Test_execution_Cycle() throws Throwable {
		 try
	     {
			 
	   	  BasePage bp=new BasePage();
	   	  actual[14]= rp.clickOnTestPlanning();
	   	  bp.waitForElement();
	   	  //tp=new TestPlanningPage(driver);
	   	  actual[15]= tp.clickOnAddTestCycleSymbol();
	   	  bp.waitForElement();
	   	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,0);
	   	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",69,1));
	   	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,2);
	   	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,100);
	   	  actual[16]=tp.CreateCycle(cycle, Build, environ, hide);
	   	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",69,3));
	   	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,4);
	   	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",69,5));
	   	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",69,6));
	   	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,7);
	   	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",69,8));
	   	  actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
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

	@When("^Adds Phase to the created Cycle and Assign to the Manager$")
	public void adds_Phase_to_the_created_Cycle_and_Assign_to_the_Manager() throws Throwable {
		 try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,0);
	    	  actual[18]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,0);
	    	  actual[19]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",69,9);
	    	  actual[20]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,0);
	    	  actual[21]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  tp.goBackToCycle();
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

	@Then("^In Second browser, apply the notification for Manager$")
	public void in_Second_browser_apply_the_notification_for_Manager() throws Throwable {
		 try
		    {
				  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		  	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		  	  actual[22]=tr1.applyNotification2(releaseName, driver2);
		  	  
		  	  
		    }
		    catch(Exception e)
				{
		    	lb.getScreenShot(fileName);
					driver.close();
//					Relogin_TPE rl=new Relogin_TPE();
//					rl.reLogin();
					throw e;
				}
	}

	@When("^In First Browser, Launch test Planning and re-assign testcases from Manager to Anyone$")
	public void in_First_Browser_Launch_test_Planning_and_re_assign_testcases_from_Manager_to_Anyone() throws Throwable {
		try
	    {
			String[] nodes=new String[1];
			
			nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,0);
			
	  	    rp.clickOnTestPlanning();
	  	  
	  	  tp.navigateToCycle(nodes);
	  	  tp.assignPhase();
	  	  bp.waitForElement();
	  	  tp.cancelBulkAssign();
	  	  
	  	  
	   	  String[] phase=new String[1];  
	   	  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",44,0);
	  	  tp.navigateToCycle(phase);
	  	  bp.waitForElement();
	  	  int[] testcase=new int[1];
	  	  testcase[0]=Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3);
	  	  String assignee=Excel_Lib.getData(INPUT_PATH,"T_Execution",1,2);
	  	  tp.individualAssinTo(testcase, assignee);
	  	    
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

	@Then("^In Second Browser, check and Apply Notification in Manager Window$")
	public void in_Second_Browser_check_and_Apply_Notification_in_Manager_Window() throws Throwable {
		try
		{
			  BasePage bp=new BasePage();
		TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	 	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	 	 actual[23]=tr1.applyNotification2(releaseName, driver2);
		log.info("Pass - Notifications are applied in another Browser");
		
		bp.waitForElement();
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
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}
	}
	

}
