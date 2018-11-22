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

public class TestExecution_878853 extends LaunchBrowser
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
	ExecutionPage exe;
	boolean[] actual=new boolean[39];
	  SoftAssert soft=new SoftAssert();
	
	  String fileName="TestExecution_878853";

	  
	  

@Given("^User Selects the Project and release$")
public void user_Selects_the_Project_and_release() throws Throwable {
	try
    {
		lb=new LaunchBrowser();
  	        pp=new ProjectPage(driver);
  	        tr=new TestRepositoryPage(driver);
  	        tp=new TestPlanningPage(driver);
  	        ctc=new CreateTestCasePage(driver);
  	        exe=new ExecutionPage(driver);
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

@When("^Launch the TestRepository Module$")
public void launch_the_TestRepository_Module() throws Throwable {
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

@When("^Launch another Browser, Login as Manager$")
public void launch_another_Browser_Login_as_Manager() throws Throwable {
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
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}

}

@When("^Select project and Release$")
public void select_project_and_Release() throws Throwable {
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
//			Relogin_TPE rl=new Relogin_TPE();
//			rl.reLogin();
			throw e;
		}


}

@When("^Launch Test Execution Module and Select Release$")
public void launch_Test_Execution_Module_and_Select_Release() throws Throwable {
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
//		Relogin_TPE rl=new Relogin_TPE();
//		rl.reLogin();
		throw e;
	}
}
	  
	  
	  @When("^In first Browser, Creates Phase with Name and Descriptions$")
	  public void in_first_Browser_Creates_Phase_with_Name_and_Descriptions() throws Throwable {
		  try
		     {
			  //tr=new TestRepositoryPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		   	  tr.doubleClickOnRelease(releaseName);
		   	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,0);
		   	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,1);
		   	  actual[10]= tr.addNode(Name, Desc);
		   	  
		   	  
		   	  bp.waitForElement();
		   	  
		   	  
		    	String[] phase=new String[1];
		   	  phase[0]=Name;
		   	  
		   	  actual[11]=tr.navigateToNode(releaseName, phase);
		   	  bp.waitForElement();
		   	//actual[11]=tr.selectPhase(Name);
		   	  
		   	 String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",36,0);
		   	  String Desc2=Excel_Lib.getData(INPUT_PATH,"TP_Phases",36,1);
		   	actual[12]=tr.addNode(Name2, Desc2);
		   	  
		   	actual[13]=tr.doubleClickOnRelease(releaseName);
		   	  bp.waitForElement();
		   	  
		   	  String[] navigation=new String[2];
		   	  navigation[0]=Name;
		   	  navigation[1]=Name2;
		   	actual[14]=tr.navigateToNode(releaseName, navigation);
		   	  String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",37,0);
		   	  String Desc3=Excel_Lib.getData(INPUT_PATH,"TP_Phases",37,1);
		   	  
		   	actual[15]=tr.addNode(Name3, Desc3);
		   	  
		   	actual[16]= tr.doubleClickOnRelease(releaseName);
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

	  @Then("^Navigates to the Created Phase and Adds the Testcase with Name and Description$")
	  public void navigates_to_the_Created_Phase_and_Adds_the_Testcase_with_Name_and_Description() throws Throwable {
		  try
		     {
				  BasePage bp=new BasePage();
		   	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		   	  String navigation[]=new String[1];
		   	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,0);
		   	  actual[17]=tr.navigateToNode(releaseName, navigation);
		   	  actual[18]=tr.addTestCase();
		   	  bp.waitForElement();
		   	  //tr.clickDetailButton();
		   	  ctc=new CreateTestCasePage(driver);
		   	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",25,0);
		   	String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",25,1);
		   	  //ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	  @When("^Launch the Testplanning and Creates the Test Execution Cycle$")
	  public void launch_the_Testplanning_and_Creates_the_Test_Execution_Cycle() throws Throwable {
			 try
		     {
				 
		   	  BasePage bp=new BasePage();
		   	 
		   	  actual[19]= rp.clickOnTestPlanning();
		   	  bp.waitForElement();
		   	 
		   	  actual[20]= tp.clickOnAddTestCycleSymbol();
		   	  bp.waitForElement();
		   	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,0);
		   	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",66,1));
		   	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,2);
		   	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,100);
		   	  actual[21]=tp.CreateCycle(cycle, Build, environ, hide);
		   	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",66,3));
		   	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,4);
		   	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",66,5));
		   	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",66,6));
		   	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,7);
		   	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",66,8));
		   	  actual[22]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		   	  bp.waitForElement();
		   	  tp.saveTestCycle();
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

	  @When("^Adds created Phase to the Cycle and Assign to the Manager$")
	  public void adds_created_Phase_to_the_Cycle_and_Assign_to_the_Manager() throws Throwable {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,0);
	    	  actual[23]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,0);
	    	  actual[24]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,9);
	    	  actual[25]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,0);
	    	  actual[26]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  String phase[]=new String[1];
	    	  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,0);
	    	  actual[27]=tp.navigateToCycle(phase);
	    	  int[] testcase=new int[1];
	    	  testcase[0]=Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3);
	    	  String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User4");
	    	  actual[28]=tp.individualAssinTo(testcase, assignee);
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

	  @Then("^In Second Browser,Apply the Notifications for Manager$")
	  public void in_Second_Browser_Apply_the_Notifications_for_Manager() throws Throwable {
		  try
		    {
				  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		  	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		  	  actual[29]=tr1.applyNotification2(releaseName, driver2);
		  	  
		  	  
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

	  @When("^In first Browser, Launch test execution module and execute testcase to Pass$")
	  public void in_first_Browser_Launch_test_execution_module_and_execute_testcase_to_Pass() throws Throwable {
		  try
		    {
			    BasePage bp=new BasePage();
				//String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				String[] nodes=new String[3];
				nodes[0]=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",66,0);
				nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",35,0);
				//rp=new ReleasePage(driver);
				actual[30]= rp.clickOnTestExecution();
				bp.waitForElement();
				actual[31]= exe.selectAllExecutions();
		  	  
				actual[32]=tp.navigateToCycle(nodes);
		
		  	int tcNo=Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3);
		  	
		  	 String status=Excel_Lib.getData(INPUT_PATH,"T_Execution",1,1);
		  	actual[33]=exe.executeStatus(tcNo,status);
		  	 
		  	  
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

	  @When("^add attachement and notes to testcase$")
	  public void add_attachement_and_notes_to_testcase() throws Throwable {
		  try
			{
			tr.clickDetailButton();
			bp.waitForElement();
			String[] testCase=new String[1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3));
			actual[34]=exe.selectMultipleTestCaseFromExecutionGrid(testCase);
		
			String[] file1=new String[1];
			file1[0]=Excel_Lib.getData(INPUT_PATH,"Import_Job",13,2);
			actual[35]=exe.uploadAttachement(file1);
			bp.waitForElement();
			
			
			
			String notes=Excel_Lib.getData(INPUT_PATH,"T_Execution",1,3);
			actual[36]=exe.enterNotes(notes);
			bp.waitForElement();
			tr.clickOnList();
			
			bp.waitForElement();
			String release=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			actual[37]=tp.doubleClickOnCycle(release);
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

	  @Then("^In Second Browser, Apply Notification$")
	  public void in_Second_Browser_Apply_Notification() throws Throwable {
		  try
			{
			  BasePage bp=new BasePage();
			TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		 	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		 	  actual[38]=tr1.applyNotification2(releaseName, driver2);
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
//					Relogin_TPE rl=new Relogin_TPE();
//					rl.reLogin();
					throw e;
				}
	  }
}

