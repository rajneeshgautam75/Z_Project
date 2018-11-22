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

public class Assign_868102 extends LaunchBrowser
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
	boolean[] actual=new boolean[31];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868102";
	@Given("^user in repository to create node$")
	public void user_in_repository_to_create_node() throws Throwable 
	{
	   try
	   {
		   
		   pp=new ProjectPage(driver);
		   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   bp=new BasePage();
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   actual[3]=tr.clickOnRelease(releaseName);
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

	@Given("^create node Add testcase and clone$")
	public void create_node_Add_testcase_and_clone() throws Throwable 
	{
		try
		{
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 20, 0);
		String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 20, 1);
		actual[4]=tr.addNode(nodeName, nodeDesc);
	   bp.waitForElement();
	   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
	   tr.doubleClickOnRelease(releaseName);
	   String[] navigation=new String[1];
	   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 20, 0);
	   tr.navigateToNode(releaseName, navigation);
	   tr.addTestCase();
	   bp.waitForElement();
	   ctc=new CreateTestCasePage(driver);
	   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 15, 0);
	   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 15, 1);
	   tr.clickDetailButton();
	   actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	   bp.waitForElement();
	   tr.clickOnList();
	   tr.selectallTestCase();
	   bp.waitForElement();
	   actual[6]=tr.cloneTestCase();
	   bp.waitForElement();
	   tr.selectallTestCase();
	   bp.waitForElement();
	   actual[7]=tr.cloneTestCase();
	   bp.waitForElement();
		}	   catch (Exception e) 
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

	@When("^navigate to test planning and create cycle$")
	public void navigate_to_test_planning_and_create_cycle() throws Throwable 
	{
		try
		{
			actual[8]=rp.clickOnTestPlanning();
			bp.waitForElement();
			tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[9]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[10]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[11]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[12]=tl.saveTestCycle();
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

	@When("^add pahse to cycle and navigate to phase$")
	public void add_pahse_to_cycle_and_navigate_to_phase() throws Throwable 
	{
		try
		{
		String cyclename[]=new String[1];
		cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 0);
		actual[13]=tl.navigateToCycle(cyclename);
		bp.waitForElement();
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 20, 0);
		actual[14]=tl.addPhaseToCycle(nodeName);
	   bp.waitForElement();
	   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
	   actual[15]=tl.bulkAssignment(Bulk_type);
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

	@When("^select testcase and assign to different users$")
	public void select_testcase_and_assign_to_different_users() throws Throwable 
	{
		try
		{
		String nodeName[]=new String[1];
		nodeName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 20, 0);
		actual[16]=tl.navigateToCycle(nodeName);
		bp.waitForElement();
//		String[] tcname=new String[1];
//		tcname[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 1, 0));
//		tr.selectTestCase(tcname);
		bp.waitForElement();
		int[] tcname1=new int[1];
		tcname1[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 1, 0);
		//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[17]=tl.individualAssinTo(tcname1, manager);
		bp.waitForElement();
		
		int[] tcname2=new int[1];
		tcname2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 2, 0);
		//String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[18]=tl.individualAssinTo(tcname2, lead);
		bp.waitForElement();
		int[] tcname3=new int[1];
		tcname3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[19]=tl.individualAssinTo(tcname3, tester);
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

	@Then("^select all testcase assign to different users$")
	public void select_all_testcase_assign_to_different_users() throws Throwable 
	{
		try
		{
		tl.selectallTestCase();
		bp.waitForElement();
		//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[20]=tl.assignAllSelected(manager);
		bp.waitForElement();
		int[] tcname1=new int[4];
		tcname1[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		tcname1[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		tcname1[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		tcname1[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		actual[21]=tl.validateAllAssigned(tcname1, manager);
		bp.waitForElement();
		actual[22]=tl.selectallTestCase();
		bp.waitForElement();
		//String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[23]=tl.assignAllSelected(lead);
		bp.waitForElement();
		actual[24]=tl.validateAllAssigned(tcname1, lead);
		bp.waitForElement();
		actual[25]=tl.selectallTestCase();
		bp.waitForElement();
		String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[26]=tl.assignAllSelected(Assignee3);
		bp.waitForElement();
		actual[27]=tl.validateAllAssigned(tcname1, Assignee3);
		bp.waitForElement();
		actual[28]=tl.selectallTestCase();
		bp.waitForElement();
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 7, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[29]=tl.assignAllSelected(tester);
		bp.waitForElement();
		actual[30]=tl.validateAllAssigned(tcname1, tester);
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

	@Then("^Should be able to assign testcases to different users$")
	public void should_be_able_to_assign_testcases_to_different_users() throws Throwable 
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
