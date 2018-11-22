package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assign_868133 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	boolean[] actual=new boolean[33];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868133";
	@Given("^user in repository to create Phase$")
	public void user_in_repository_to_create_Phase() throws Throwable 
	{
		 try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}  
	}

	@Given("^create a phase add testcase and clone upto (\\d+) testcases$")
	public void create_a_phase_add_testcase_and_clone_upto_testcases(int arg1) throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 19, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 19, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
		   bp.waitForElement();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		   actual[5]=tr.doubleClickOnRelease(releaseName);
		   String[] navigation=new String[1];
		   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 19, 0);
		   actual[6]=tr.navigateToNode(releaseName, navigation);
		   actual[7]=tr.addTestCase();
		   bp.waitForElement();
		   ctc=new CreateTestCasePage(driver);
		   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 14, 0);
		   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 14, 1);
		   tr.clickOnDetails();
		   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		   bp.waitForElement();
		   bp.waitForElement();
		   tr.clickOnList();
		   actual[9]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[10]=tr.cloneTestCase();
		   bp.waitForElement();
		   actual[11]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[12]=tr.cloneTestCase();
		   bp.waitForElement();
		}
	   catch (Exception e) 
			{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch test planning create cycle and add phase save and cancel assign popup$")
	public void launch_test_planning_create_cycle_and_add_phase_save_and_cancel_assign_popup() throws Throwable 
	{
		try
		{
			actual[13]=rp.clickOnTestPlanning();
			bp.waitForElement();
			tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 12, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 12, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 12, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[14]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[15]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[16]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[17]=tl.saveTestCycle();
			bp.waitForElement();
			
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 12, 0);
			actual[18]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 19, 0);
			actual[19]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   /////////ccancel bulk assign
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[20]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@When("^select all test cases and assign to Anyone$")
	public void select_all_test_cases_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			String nodeName[]=new String[1];
			nodeName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 19, 0);
			actual[21]=tl.navigateToCycle(nodeName);
			bp.waitForElement(); 
			actual[22]=tl.selectallTestCase();
			bp.waitForElement();
			String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			actual[23]=tl.assignAllSelected(Assignee);
			bp.waitForElement();
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@When("^select single testcase Assign to manager$")
	public void select_single_testcase_Assign_to_manager() throws Throwable 
	{
		try
		{
			int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		  // tl.selectSingleMultipleTestcase(tcNo);
		   //String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		   actual[24]=tl.individualAssinTo(tcNo, Assignee);
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^select multiple test case assign to Tester One$")
	public void select_multiple_test_case_assign_to_Tester_One() throws Throwable 
	{
		try
		{
			int[] tcNo=new int[2];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
			actual[25]=tl.selectSingleMultipleTestcase(tcNo);
		   bp.waitForElement();
		   //String tester=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		   String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		   actual[26]=tl.assignAllSelected(tester);
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^select single testcase Assin to manager$")
	public void select_single_testcase_Assin_to_manager() throws Throwable 
	{
		try
		{
			int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		  // tl.selectSingleMultipleTestcase(tcNo);
		   //String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		   actual[27]=tl.individualAssinTo(tcNo, Assignee);
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^select single testcase Assin to Test Lead$")
	public void select_single_testcase_Assin_to_Test_Lead() throws Throwable 
	{
		try
		{
			int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		  // tl.selectSingleMultipleTestcase(tcNo);
		   //String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 10, 0);
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		   actual[28]=tl.individualAssinTo(tcNo, Assignee);
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^select single testcase Assin to TesterOne$")
	public void select_single_testcase_Assin_to_TesterOne() throws Throwable 
	{
		try
		{
			int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		  // tl.selectSingleMultipleTestcase(tcNo);
		   //String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		   actual[29]=tl.individualAssinTo(tcNo, Assignee);
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^select single testcase Assin to unassign$")
	public void select_single_testcase_Assin_to_unassign() throws Throwable 
	{
		try
		{
			int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		  // tl.selectSingleMultipleTestcase(tcNo);
		   String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 7, 0);
		   actual[30]=tl.individualAssinTo(tcNo, Assignee);
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^Select all test cases Assign to Unassign$")
	public void select_all_test_cases_Assign_to_Unassign() throws Throwable 
	{
		try
		{
			actual[31]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 7, 0);
		    actual[32]=tl.assignAllSelected(Assignee);
		    tl.goBackToCycle();
		    bp.waitForElement();
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@Then("^all the selected testcases should be assigned to Unassign$")
	public void all_the_selected_testcases_should_be_assigned_to_Unassign() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	     {
			soft.assertEquals(actual[k], true);
	     }
	    soft.assertAll();
		}
		   catch (Exception e) 
				{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}
}
