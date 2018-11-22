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

public class TestExecution_878852 extends LaunchBrowser 
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
	ExecutionPage exe; 
	CopyFromProjects cfp;
	
	boolean[] actual=new boolean[35];
	  SoftAssert soft=new SoftAssert();
	  
	  String fileName="TestExecution_878852";
	  
	  
	  @Given("^User Selects the Project and Release$")
	  public void user_Selects_the_Project_and_Release() throws Throwable {
		  try
		    {
			  lb=new LaunchBrowser();
		  	      pp=new ProjectPage(driver);
				  tr=new TestRepositoryPage(driver);
				  tp=new TestPlanningPage(driver);
				  ctc=new CreateTestCasePage(driver);
				  exe=new ExecutionPage(driver);
			    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			    	 actual[0]= pp.selectProject(projectName); 
			    	  
				    actual[1]= pp.selectRelease(releaseName);
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

	  @When("^Launch the TestRepository module$")
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
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch another browser, Login as manager$")
	  public void launch_another_browser_Login_as_manager() throws Throwable {
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
//					Relogin_TPE rl=new Relogin_TPE();
//					rl.reLogin();
					throw e;
				}

	  }

	  @When("^Select the Project and Click on Release$")
	  public void select_the_Project_and_Click_on_Release() throws Throwable {
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
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch Test Execution and Select Release$")
	  public void launch_Test_Execution_and_Select_Release() throws Throwable {
		  try
			{
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			ReleasePage rp1=new ReleasePage(driver);
			 actual[9]=rp1.clickOnTestExecution2(driver2);
			TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			 actual[10]=tr1.doubleClickOnRelease2(releaseName, driver2);
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

	  @When("^In first Browser, Creates Phase with name and Descriptions$")
	  public void in_first_Browser_Creates_Phase_with_name_and_Descriptions() throws Throwable {
		  try
		     {
			  
				  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				  actual[11]= tr.doubleClickOnRelease(releaseName);
		   	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
		   	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,1);
		   	  actual[12]= tr.addNode(Name, Desc);
		   	 actual[13]=tr.doubleClickOnRelease(releaseName);
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

	  @Then("^Navigates to Created Phase and Adds the TestCase with Name and Description$")
	  public void navigates_to_Created_Phase_and_Adds_the_TestCase_with_Name_and_Description() throws Throwable {
		  try
		     {
				  BasePage bp=new BasePage();
		   	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		   	  String navigation[]=new String[1];
		   	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
		   	  actual[14]=tr.navigateToNode(releaseName, navigation);
		   	  actual[15]=tr.addTestCase();
		   	  bp.waitForElement();
		   	 actual[16]=tr.clickDetailButton();
		   	  bp.waitForElement();
		   	  ctc=new CreateTestCasePage(driver);
		   	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",24,0);
		   	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",24,1);
		   	  //ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		   	  bp.waitForElement();
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

	  @When("^Launch the Test Planning and Creates the Test Execution Cycle$")
	  public void launch_the_Test_Planning_and_Creates_the_Test_Execution_Cycle() throws Throwable {
		  try
		     {
				 
		   	  BasePage bp=new BasePage();
		   	  actual[17]= rp.clickOnTestPlanning();
		   	  bp.waitForElement();
		   	  //tp=new TestPlanningPage(driver);
		   	  actual[18]= tp.clickOnAddTestCycleSymbol();
		   	  bp.waitForElement();
		   	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,0);
		   	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",65,1));
		   	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,2);
		   	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,100);
		   	  actual[19]=tp.CreateCycle(cycle, Build, environ, hide);
		   	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",65,3));
		   	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,4);
		   	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",65,5));
		   	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",65,6));
		   	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,7);
		   	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",65,8));
		   	  actual[20]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		   	  bp.waitForElement();
		   	 actual[21]=tp.saveTestCycle();
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

	  @When("^Adds Phase to the Cycle and Assign to the Manager$")
	  public void adds_Phase_to_the_Cycle_and_Assign_to_the_Manager() throws Throwable {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,0);
	    	  actual[22]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
	    	  actual[23]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,9);
	    	  actual[24]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
	    	  actual[25]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  String phase[]=new String[1];
	    	  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
	    	  actual[26]=tp.navigateToCycle(phase);
	    	  int[] testcase=new int[1];
	    	  testcase[0]=Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3);
	    	  String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User4");
	    	  actual[27]=tp.individualAssinTo(testcase, assignee);
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

	  @Then("^In second browser, apply the notifications for Manager$")
	  public void in_second_browser_apply_the_notifications_for_Manager() throws Throwable {
		  try
		    {
				  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
		  	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		  	  actual[28]=tr1.applyNotification2(releaseName, driver2);
		  	  
		  	  
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

	  @When("^In first Browser, Launch test execution and execute testcase to Pass$")
	  public void in_first_Browser_Launch_test_execution_and_execute_testcase_to_Pass() throws Throwable {
		  try
		    {
			  BasePage bp=new BasePage();
				//String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				String[] nodes=new String[3];
				nodes[0]=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",65,0);
				nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",34,0);
				//rp=new ReleasePage(driver);
				 actual[29]=rp.clickOnTestExecution();
				 bp.waitForElement();
				 actual[30]= exe.selectAllExecutions();

				 actual[31]=tp.navigateToCycle(nodes);
		  	  
		  	  
		  	  
		  
		  	int testcase=Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS", 1, 3);
		  	String status=Excel_Lib.getData(INPUT_PATH,"T_Execution",1,1);
		  	exe.executeStatus(testcase, status);
		  	
		  	 actual[32]=tp.doubleClickOnCycle(nodes[0]);
		  	 
		  	  
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

	  @Then("^In second Browser, check and Apply Notifications in Manager Window$")
	  public void in_second_Browser_check_and_Apply_Notifications_in_Manager_Window() throws Throwable {
		 try
		 {
			 BasePage bp=new BasePage();
		  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	 	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	 	  actual[33]=tr1.applyNotification2(releaseName, driver2);
		log.info("Pass - Notifications are applied in another Browser");
		 bp.waitForElement();
		ProjectPage pp1=new ProjectPage(driver2);
		 actual[34]=pp1.clickOnLogout(driver2);
		 
		
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

