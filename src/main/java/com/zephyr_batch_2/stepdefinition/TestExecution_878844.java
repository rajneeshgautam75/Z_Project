package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878844 extends LaunchBrowser {
	 BasePage bp;
	 LaunchBrowser lb=new LaunchBrowser();
	 LoginPage lp;
	 ProjectPage pp;
	 ReleasePage rp;
	 TestRepositoryPage tr;
	 TestPlanningPage tp;
	 ExecutionPage ep;
	 
	 boolean actual[]=new boolean[34];
	 SoftAssert soft=new SoftAssert();
	
	 String filename="TestExecution_878844";
	
	@Given("^Lead is in Test RepositoryPage of Normal Project$")
	public void lead_is_in_Test_RepositoryPage_of_Normal_Project() throws Throwable {
		try 
		{   pp=new ProjectPage(driver);
		    rp=new ReleasePage(driver);
		    bp=new BasePage();
			String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[0]=pp.selectProject(Project);
			bp.waitForElement();
			actual[1]=pp.selectRelease(Release);
			actual[2]=rp.clickOnTestRep();
			bp.waitForElement();
			}
		catch(Exception e)
		{
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	    }

	@When("^Create new phase and add a testcase to created phase$")
	public void create_new_phase_and_add_a_testcase_to_created_phase() throws Throwable {
		try 
		{   tr=new TestRepositoryPage(driver);
		    String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		    actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 1);
			actual[4]=tr.addNode(Phase, Desc);
			bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=Phase;
			bp.waitForElement();
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();
			tr.selectPhase(Phase);
			bp.waitForElement();
			actual[5]=tr.addTestCase();
			bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			
			}
		catch(Exception e)
		{ lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	    }

	@When("^Launch Test Planning and create new cycle$")
	public void launch_Test_Planning_and_create_new_cycle() throws Throwable {
		try 
		{   
			tp=new TestPlanningPage(driver);
			actual[6]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[7]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 12, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String Hide =Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[8]=tp.CreateCycle(cycle, Build, Environment, Hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[10]=tp.saveTestCycle();
			bp.waitForElement();
		}
		catch(Exception e)
		{  lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	   }

	@When("^Add phase to cycle and assign testcase to Tester$")
	public void add_phase_to_cycle_and_assign_testcase_to_Tester() throws Throwable {
		try 
		{   
			tp=new TestPlanningPage(driver);
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 12, 0);
			actual[11]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 0);
			actual[12]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			actual[13]=tp.cancelBulkAssign();
			bp.waitForElement();
			String Phase1[]=new String[1];
			Phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 0);
			actual[14]=tp.navigateToCycle(Phase1);
			int tcno[]=new int[1];
			tcno[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			actual[15]=tp.selectSingleMultipleTestcase(tcno);
			bp.waitForElement();
			int testcase[]=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[16]=tp.individualAssinTo(testcase, assignee);
			bp.waitForElement();
			}
		catch(Exception e)
		{  lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	   }

	@Then("^Testcase should be assigned to Tester in TestPlanning$")
	public void testcase_should_be_assigned_to_Tester_in_TestPlanning() throws Throwable {
		try 
		{
			int tcno[]=new int[1];
			tcno[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");	
			actual[17]=tp.validateAllAssigned(tcno, assignee);
			//rp.clickOnTestPlanning();
			tp.goBackToCycle();
			bp.waitForElement();
			pp.clickOnLogout();
			
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			 e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	    }

	@When("^Login as Tester and Launch Test Execution$")
	public void login_as_Tester_and_Launch_Test_Execution() throws Throwable {
		try 
		{  
		 lp=new LoginPage(driver);
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 tp=new TestPlanningPage(driver);
		 rp=new ReleasePage(driver);
		 String  Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
		 actual[18]=lp.enterUname(Uname);
		 String Upwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Password_1");
		 actual[19]=lp.enterPass(Upwd);
		 actual[20]=lp.clickOnLogin();
		 bp.waitForElement();
		 String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
		 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		 actual[21]=pp.selectProject(Project);
		 actual[22]=pp.selectRelease(Release);
		 bp.waitForElement();
		 actual[23]=rp.clickOnTestExecution();
		 bp.waitForElement();
		 String cycle[]=new String[3];
		 cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		 cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 12, 0);
		 cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 0);
		 actual[24]=tp.navigateToCycle(cycle);
		 bp.waitForElement();
		 
		 }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	   }

	@When("^Select a testcase, Execute the status of a testcase and attempt to modify the Actual Execution time by entering text$")
	public void select_a_testcase_Execute_the_status_of_a_testcase_and_attempt_to_modify_the_Actual_Execution_time_by_entering_text() throws Throwable {
		try 
		{   ep=new ExecutionPage(driver);
			String tcno[]=new String[1];
			tcno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[25]=ep.selectMultipleTestCaseFromExecutionGrid(tcno);
			bp.waitForElement();
			int testcase[]=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[26]=ep.changeStatusOfTestCases(testcase, status);
			bp.waitForElement();
			String day=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 1, 1);
			String hr=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 2, 1);
			String mn=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 3, 1);
			tr.clickOnDetails();
			actual[27]=ep.actualTime(day, hr, mn);
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	   }

	@Then("^Selected testcase Actual Execution time should not be modified by entered text$")
	public void selected_testcase_Actual_Execution_time_should_not_be_modified_by_entered_text() throws Throwable {
		try 
		{  
			String tcno[]=new String[1];
			tcno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[28]=ep.selectMultipleTestCaseFromExecutionGrid(tcno);
			bp.waitForElement();
			String day=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 1, 1);
			String hr=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 2, 1);
			String mn=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 3, 1);
			actual[29]=ep.validateActualTime(day, hr, mn);
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	    }

	@When("^Attempt to modify the Actual Execution time of testcase by entering Special characters$")
	public void attempt_to_modify_the_Actual_Execution_time_of_testcase_by_entering_Special_characters() throws Throwable {
		try 
		{    
			String day=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 1, 2);
			String hr=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 2, 2);
			String mn=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 3, 2);
			actual[30]=ep.actualTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	   }

	@Then("^Selected testcase Actual Execution time should not be modified by entered Special characters$")
	public void selected_testcase_Actual_Execution_time_should_not_be_modified_by_entered_Special_characters() throws Throwable {
		try 
		{
			String day=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 1, 2);
			String hr=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 2, 2);
			String mn=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 3, 2);
			actual[31]=ep.validateActualTime(day, hr, mn);
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	     }

	@When("^Attempt to modify the Actual Execution time of testcase by entering Alpha Numeric$")
	public void attempt_to_modify_the_Actual_Execution_time_of_testcase_by_entering_Alpha_Numeric() throws Throwable {
		try 
		{
			String day=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 1, 3);
			String hr=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 2, 3);
			String mn=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 3, 3);
			actual[32]=ep.actualTime(day, hr, mn);
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	   }

	@Then("^Selected testcase Actual Execution time should not be modified by entered`Alpha Numeric$")
	public void selected_testcase_Actual_Execution_time_should_not_be_modified_by_entered_Alpha_Numeric() throws Throwable {
		try 
		{    
			String day=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 1, 3);
			String hr=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 2, 3);
			String mn=Excel_Lib.getData(INPUT_PATH_5, "ExecutionTime", 3, 3);
			actual[33]=ep.validateActualTime(day, hr, mn);
			tr.clickOnList();
			bp.waitForElement();
//			pp.clickOnLogout();
//			bp.waitForElement();
//		    pp.closeBrowser();
			for(int k=0;k<=actual.length-1;k++)
			{   
				System.out.println("Actual["+k+"]=" + actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
			
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}
	    }
     }
