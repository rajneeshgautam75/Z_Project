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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Set_Reset_Flags_868128 extends LaunchBrowser{

	LaunchBrowser lb;
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
	String fileName="Set_Reset_868128";
	
	boolean[] actual=new boolean[26];
	SoftAssert soft=new SoftAssert();
	@Given("^User is in a page TestRepository$")
	public void user_is_in_a_page_TestRepository() throws Throwable {
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,1);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		   try
		   {
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
		        lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
		   	 
			}
	}

	@Given("^User creates a Phase$")
	public void user_creates_a_Phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 12);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 5, 12);
		  
		  tr=new TestRepositoryPage(driver);
		  bp=new BasePage();
		  bp.waitForElement();
		  actual[3]=tr.doubleClickOnRelease(releaseName);
		 // bp.waitForElement();
		  bp.waitForElement();
		 actual[4]= tr.addNode(p_Name1,p_Desc1);
		 tr.doubleClickOnRelease(releaseName);
		 String[] phase=new String[1];
		 phase[0]=p_Name1;
		 tr.navigateToNode(releaseName, phase);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@When("^User creates a testcase$")
	public void user_creates_a_testcase() throws Throwable {
		
		try
		{
			bp.waitForElement();
			actual[5]=tr.addTestCase();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		} 
		
	}

	@When("^User performs edit operation on the testcase created$")
	public void user_performs_edit_operation_on_the_testcase_created() throws Throwable {
	    try
	    {
		actual[6]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
		
		actual[7]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
	    	e.printStackTrace();
	    	driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}   
	}

	@When("^User selects a created testcase and clicks clone button$")
	public void user_selects_a_created_testcase_and_clicks_clone_button() throws Throwable {
	    
		try
		{
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			tr.selectallTestCase();
			actual[8]=tr.cloneTestCase();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@Then("^User is in a page TestPlanning$")
	public void user_is_in_a_page_TestPlanning() throws Throwable {
		
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
			bp.waitForElement();
		actual[9]=rp.clickOnTestPlanning();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@Then("^User creates clicks on the plus symbol and enters the available fields$")
	public void user_creates_clicks_on_the_plus_symbol_and_enters_the_available_fields() throws Throwable {
	  try
	  {
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 11);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		//actual[10]=tp.CreateCycle(cycle, Build, environ, start_date, end_date);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		tp.clickOnAddTestCycleSymbol();
		//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		bp.waitForElement();
		//bp.waitForElement();
		actual[10]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 24));
		bp.waitForElement();
		bp.waitForElement();
		tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		//bp.waitForElement();
		tp.saveTestCycle();
	}
	  catch(Exception e)
		{
		  lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
		  e.printStackTrace();
		  driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
		}  

	@When("^User creates a phase under the test cycle$")
	public void user_creates_a_phase_under_the_test_cycle() throws Throwable {
	    
		try
		{
			
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,11 );
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[11]= tp.navigateToCycle(cycleName);
		     bp.waitForElement();
			
			bp.waitForElement();
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 12);
		actual[12]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		actual[13]=tp.bulkAssignment(Bulk_Type);
		bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
		
	}

	@Then("^User assigns the testcase to Anyone$")
	public void user_assigns_the_testcase_to_Anyone() throws Throwable {
		
		try
		{
			String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,12 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[14]=tp.navigateToCycle(phaseName);
		bp.waitForElement();
		
		int[] TestCaseNo=new int[1];
		TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
		String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		bp.waitForElement();
		actual[15]=tp.individualAssinTo(TestCaseNo, Assignee);
		bp.waitForElement();
	    
//		String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1,4 );
//	    actual[15]=tp.assignAllSelected(assignee);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^User selectes all testcases and clicks on the set flag icon$")
	public void user_selectes_all_testcases_and_clicks_on_the_set_flag_icon() throws Throwable {
	    try
	    {
		//String phaseName=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,3 );
		//actual[16]=tr.doubleClickOnRelease(phaseName);
	    	bp.waitForElement();
	    	actual[16]=tp.selectallTestCase();
		bp.waitForElement();
		actual[17]=tp.setFlags();
		tp.goBackToCycle();
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^User is in a page TestExecution$")
	public void user_is_in_a_page_TestExecution() throws Throwable {
		try
		{
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[18]=rp.clickOnTestExecution();
		   bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User executes testcases and selects status by pass or fail or wip or blocked$")
	public void user_executes_testcases_and_selects_status_by_pass_or_fail_or_wip_or_blocked() throws Throwable {
		try
		{
		String[] cycleName=new String[3];
	    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,11 );
	    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,12 );
	    
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
		actual[19]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		
		/*int[] testCaseNo=new int[1];
	    ;
	    testCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,5 );
	    tp.selectSingleMultipleTestcase(testCaseNo);*/
	    
	    //status selection method should be implement here
		int[] tcNo=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[20]=exep.executeStatus(tcNo[0], statusType);
	    bp.waitForElement();
	    
	    String cycleName1=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		tp.doubleClickOnCycle(cycleName1);
		bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User is a page of TestPlanning and selects a phase and clicks assign$")
	public void user_is_a_page_of_TestPlanning_and_selects_a_phase_and_clicks_assign() throws Throwable {
		try
		{
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[21]=rp.clickOnTestPlanning();
		   bp.waitForElement();
//		   rp.clickOnTestPlanning();
//		   bp.waitForElement();
		   tp=new TestPlanningPage(driver);
		   String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,11 );
		   bp.waitForElement();
		   tp.doubleClickOnCycle(cycleName1);
		   bp.waitForElement();
		   String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,11 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,12 );
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[22]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		   actual[23]=tp.assignPhase();
		  
		   String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,12 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[24]=tp.navigateToCycle(phaseName);
		 //String phaseName=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,3 );
			//tr.doubleClickOnRelease(phaseName);
		   
			int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			bp.waitForElement();
			actual[25]=tp.individualAssinTo(TestCaseNo, Assignee);
			bp.waitForElement();
			tp.goBackToCycle();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@Then("^User views the flags across testcases successfully$")
	public void user_views_the_flags_across_testcases_successfully() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User views the flags across testcases successfully");
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
}
