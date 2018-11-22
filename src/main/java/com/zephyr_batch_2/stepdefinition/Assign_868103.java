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

public class Assign_868103 extends LaunchBrowser
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
	boolean[] actual=new boolean[21];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868103";
	@Given("^user in repository page to create Node$")
	public void user_in_repository_page_to_create_Node() throws Throwable 
	{
		 try
		   {
			   pp=new ProjectPage(driver);
			  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
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

	@Given("^Create a node add testcase and clone Testcases$")
	public void create_a_node_add_testcase_and_clone_Testcases() throws Throwable 
	{
		try
		{
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 21, 0);
		String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 21, 1);
		actual[4]=tr.addNode(nodeName, nodeDesc);
	   bp.waitForElement();
	   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
	   tr.doubleClickOnRelease(releaseName);
	   String[] navigation=new String[1];
	   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 21, 0);
	   tr.navigateToNode(releaseName, navigation);
	   tr.addTestCase();
	   bp.waitForElement();
	   ctc=new CreateTestCasePage(driver);
	   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 16, 0);
	   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 16, 1);
	   tr.clickDetailButton();
	   actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	   bp.waitForElement();
	   tr.clickOnList();
	   bp.waitForElement();
	   tr.selectallTestCase();
	   bp.waitForElement();
	   actual[6]=tr.cloneTestCase();
	   bp.waitForElement();
	   tr.selectallTestCase();
	   bp.waitForElement();
	   actual[7]=tr.cloneTestCase();
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

	@When("^create a cycle and add phase cancel popup$")
	public void create_a_cycle_and_add_phase_cancel_popup() throws Throwable 
	{
		try
		{
		actual[8]=rp.clickOnTestPlanning();
		bp.waitForElement();
		tl=new TestPlanningPage(driver);
		String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
		tl.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[9]=tl.CreateCycle(cyclename, Build, Environment,hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
		tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		tl.saveTestCycle();
		bp.waitForElement();
		String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 0);
		actual[10]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 21, 0);
		actual[11]=tl.addPhaseToCycle(nodeName);
	   bp.waitForElement();
	   bp.waitForElement();
	   actual[12]=tl.cancelBulkAssign();
	   bp.waitForElement();
//	   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
//	   actual[12]=tl.bulkAssignment(Bulk_type);
//	   bp.waitForElement();
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

	@When("^select testcase and delete$")
	public void select_testcase_and_delete() throws Throwable 
	{
		try
		{
			String nodeName[]=new String[1];
			nodeName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 21, 0);
			actual[13]=tl.navigateToCycle(nodeName);
			bp.waitForElement();
			int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			System.out.println(tcNo[0]);
			actual[14]=tl.selectSingleMultipleTestcase(tcNo);
			//System.out.println(actual[14]);
			bp.waitForElement();
			actual[15]=tl.deleteAllSelectedTestCases();
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
	@When("^select testcase and assing to manager/lead and delete$")
	public void select_testcase_and_assing_to_manager_lead_and_delete() throws Throwable
	{
		try
		{
			int[] TestcaseNo=new int[1];
			TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
			String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
			actual[16]=tl.individualAssinTo(TestcaseNo, manager);
		   bp.waitForElement();
		   bp.waitForElement();
		   int[] tcNo=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
			actual[17]=tl.selectSingleMultipleTestcase(tcNo);
		   bp.waitForElement();
		   actual[18]=tl.deleteAllSelectedTestCases();
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

	@Then("^delete the remaining testcases$")
	public void delete_the_remaining_testcases() throws Throwable 
	{
		try
		{
			actual[19]=tl.selectallTestCase();
			bp.waitForElement();
			actual[20]=tl.deleteAllSelectedTestCases();
			bp.waitForElement();
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

	@Then("^Should be able to delete testcases$")
	public void should_be_able_to_delete_testcases() throws Throwable 
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
