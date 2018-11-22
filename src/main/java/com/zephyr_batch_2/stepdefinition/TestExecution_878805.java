package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TestExecution_878805 extends LaunchBrowser{

	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	
	boolean[] actual=new boolean[47];
	SoftAssert soft=new SoftAssert();	
	
	String filrname="TestExecution_878805";
	
	 String Release=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	
	@Given("^Lead Launch TestRepository and create a phase and create testcases with teststeps$")
	public void lead_Launch_TestRepository_and_create_a_phase_and_create_testcases_with_teststeps() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	// pp=new ProjectPage(driver);
	         pp.clickOnLogout();
	    lp=new LoginPage(driver);
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   
			   tr=new TestRepositoryPage(driver);
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 19, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 19, 4);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				
				actual[6]=tr.clickDetailButton();
				String[] stepDetail1=new String[3];
				stepDetail1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail1[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail1[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterTestCaseStepDetail(stepDetail1);
				bp.waitForElement();
				actual[8]=tr.clickOnList();
				bp.waitForElement();
				
				tr.addTestCase();
				actual[9]=tr.clickDetailButton();
				String[] stepDetail2=new String[3];
				stepDetail2[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail2[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail2[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[10]=ctc.enterTestCaseStepDetail(stepDetail2);
				bp.waitForElement();
				actual[11]=tr.clickOnList();
				bp.waitForElement();
				
				tr.addTestCase();
				actual[12]=tr.clickDetailButton();
				String[] stepDetail3=new String[3];
				stepDetail3[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail3[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail3[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[13]=ctc.enterTestCaseStepDetail(stepDetail3);
				bp.waitForElement();
				actual[14]=tr.clickOnList();
				bp.waitForElement();
				
				tr.addTestCase();
				actual[15]=tr.clickDetailButton();
				String[] stepDetail4=new String[3];
				stepDetail4[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail4[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail4[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[16]=ctc.enterTestCaseStepDetail(stepDetail4);
				bp.waitForElement();
				actual[17]=tr.clickOnList();
				bp.waitForElement();
				
				tr.addTestCase();
				actual[18]=tr.clickDetailButton();
				String[] stepDetail5=new String[3];
				stepDetail5[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail5[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail5[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[19]=ctc.enterTestCaseStepDetail(stepDetail5);
				bp.waitForElement();
				actual[20]=tr.clickOnList();
				bp.waitForElement();
				
				tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
		   }
		   catch(Exception e)
			{
			   lb.getScreenShot(filrname);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
	}

	@When("^Launch TestPlanning and create a cycle,create a phase and assign to anyone$")
	public void launch_TestPlanning_and_create_a_cycle_create_a_phase_and_assign_to_anyone() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[21]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 19, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[22]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[23]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[24]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[25]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 19, 0);
				bp.waitForElement();
				actual[26]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 19, 1);
				actual[27]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[28]=tp.bulkAssignment(Bulk_Type);
				bp.waitForElement();
				tp.goBackToCycle();
				
				actual[29]=pp.clickOnLogout();
				bp.waitForElement();
		   }
		catch(Exception e)
		{lb.getScreenShot(filrname);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^As a Tester,Launch TestExecution and change the status to Pass,search and link a defect$")
	public void as_a_Tester_Launch_TestExecution_and_change_the_status_to_Pass_search_and_link_a_defect() throws Throwable {
        try
		{
          
		lp=new LoginPage(driver);
		
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 pp.selectProject(projectName);
	    	 pp.selectRelease(releaseName);
			
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[30]=rp.clickOnTestExecution();
		
		String[] cycleName1=new String[3];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",19 ,0 );
	    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",19 ,1 );
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[31]=tp.navigateToCycle(cycleName1);
		bp.waitForElement();
		
		int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[32]=exep.executeStatus(tcNo1[0], statusType1);
	    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
	    bp.waitForElement();
	    actual[33]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    bp.waitForElement();
	    actual[34]=exep.linkDefect(defectId);
	    bp.waitForElement();
	    bp.waitForElement();

		}
        catch(Exception e)
		{lb.getScreenShot(filrname);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^execute the testcase status to Fail,search and link a defect$")
	public void execute_the_testcase_status_to_Fail_search_and_link_a_defect() throws Throwable {
	   try
	   {
		   int[] tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
		    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[35]=exep.executeStatus(tcNo2[0], statusType2);
		    bp.waitForElement();
		    
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
		    bp.waitForElement();
		    actual[36]=exep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
		    bp.waitForElement();
		    actual[37]=exep.linkDefect(defectId);
		    bp.waitForElement();
		    bp.waitForElement();

	   }
	   catch(Exception e)
		{lb.getScreenShot(filrname);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^execute testcase status to the WIP,search and link a defect$")
	public void execute_testcase_status_to_the_WIP_search_and_link_a_defect() throws Throwable {
		try
		{
		int[] tcNo3=new int[1];
		tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
	    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[38]=exep.executeStatus(tcNo3[0], statusType3);
	    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
	    bp.waitForElement();
	    actual[39]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    bp.waitForElement();
	    actual[40]=exep.linkDefect(defectId);
	    bp.waitForElement();
	    bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filrname);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^execute testcase status to Blocked,search and link a defect$")
	public void execute_testcase_status_to_Blocked_search_and_link_a_defect() throws Throwable {
		try
		{
		int[] tcNo4=new int[1];
		tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
	    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[41]=exep.executeStatus(tcNo4[0], statusType4);
	    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 );
	    bp.waitForElement();
	    actual[42]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    bp.waitForElement();
	    actual[43]=exep.linkDefect(defectId);
	    bp.waitForElement();
	    bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filrname);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^execute testcase to a status CustomStatus and search and link a defect$")
	public void execute_testcase_to_a_status_CustomStatus_and_search_and_link_a_defect() throws Throwable {
		try
		{
		int[] tcNo5=new int[1];
		tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
	    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[44]=exep.executeStatus(tcNo5[0], statusType5);
	    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,8 );
	    bp.waitForElement();
	    actual[45]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    bp.waitForElement();
	    actual[46]=exep.linkDefect(defectId);
	    bp.waitForElement();
	    bp.waitForElement();
//	    pp.clickOnLogout();
//	    bp.waitForElement();
//	    pp.closeBrowser();
	    
	    
	    for(int k=0;k<=actual.length-1;k++)
	     {
			System.out.println(actual[k]);
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		}
		catch(Exception e)
		{lb.getScreenShot(filrname);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

}
