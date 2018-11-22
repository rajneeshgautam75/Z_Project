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

public class Assign_868134 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[26];
	SoftAssert soft=new SoftAssert();
	String filename="Assign_868134";
	@Given("^User in a page of TestRepository$")
	public void user_in_a_page_of_TestRepository() throws Throwable {
		try
		   {
				bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   bp.waitForElement();
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   
			   bp.waitForElement();
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep(); 
		   }
		   catch(Exception e)
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

	@Given("^User creates a phase under a node$")
	public void user_creates_a_phase_under_a_node() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 12);
			  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 15);
			  
			  tr=new TestRepositoryPage(driver);
			  bp=new BasePage();
			  bp.waitForElement();
			  actual[3]=tr.doubleClickOnRelease(releaseName);
			 // bp.waitForElement();
			  bp.waitForElement();
			 actual[4]= tr.addNode(p_Name1,p_Desc1);
			actual[5]= tr.doubleClickOnRelease(releaseName);
			 String[] phase=new String[1];
			 phase[0]=p_Name1;
			 actual[6]=tr.navigateToNode(releaseName, phase);
			// actual[7]=tr.addTestCase();//
		}
		catch(Exception e)
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

	@When("^User creates a testcase under Phase$")
	public void user_creates_a_testcase_under_Phase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[7]=tr.addTestCase();
		}
		catch(Exception e)
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

	@When("^User performs edit operation on the testcase$")
	public void user_performs_edit_operation_on_the_testcase() throws Throwable {
		try
	    {
			actual[8]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[9]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	    }
	    catch(Exception e)
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

	@When("^User selects the testcase and performs the clone operation$")
	public void user_selects_the_testcase_and_performs_the_clone_operation() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[10]=tr.clickOnList();
			bp.waitForElement();
			tr.selectallTestCase();
			actual[11]=tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			actual[12]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
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

	@Then("^User is in a page of Testplanning page$")
	public void user_is_in_a_page_of_Testplanning_page() throws Throwable {
		try
		{
			
			rp= new ReleasePage(driver);
			actual[13]=rp.clickOnTestPlanning();
			bp.waitForElement();
		}
		catch(Exception e)
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

	@Then("^User creates a cycle with all available fields$")
	public void user_creates_a_cycle_with_all_available_fields() throws Throwable {
		try
		  {
			tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[14]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3, 24));
			bp.waitForElement();
			bp.waitForElement();
			tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			tp.saveTestCycle();
		}
		  catch(Exception e)
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

	@When("^User Creates phase under the test cycle$")
	public void user_Creates_phase_under_the_test_cycle() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,11 );
		     tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		     bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 12);
		actual[15]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		actual[16]=tp.bulkAssignment(Bulk_Type);
		bp.waitForElement();
		 tp.goBackToCycle();
		}
		catch(Exception e)
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

	@Then("^User is in a page of TestExecution page$")
	public void user_is_in_a_page_of_TestExecution_page() throws Throwable {
		try
		{
			
			rp= new ReleasePage(driver);
		   actual[17]=rp.clickOnTestExecution(); 
		}
		catch(Exception e)
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

	@Then("^User executes the testcases and selects the status drop down$")
	public void user_executes_the_testcases_and_selects_the_status_drop_down() throws Throwable {
		try
		{
			
		String[] cycleName=new String[3];
	    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,11 );
	    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,12 );
	    
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[18]=tp.navigateToCycle(cycleName);
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
	    actual[19]=exep.executeStatus(tcNo[0], statusType);
		}
		catch(Exception e)
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

	@Then("^User is in a page of Testplanning$")
	public void user_is_in_a_page_of_Testplanning() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[20]=rp.clickOnTestPlanning();
		}
		catch(Exception e)
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

	@When("^User selects a phase and clicks on assign$")
	public void user_selects_a_phase_and_clicks_on_assign() throws Throwable {
		try
		{
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[21]=rp.clickOnTestPlanning();
		   tp=new TestPlanningPage(driver);
		   
		   String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,11 );
			bp.waitForElement();
			tp.doubleClickOnCycle(cycleName1);
		   
		   String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,11 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,12 );
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
			actual[22]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		   actual[23]=tp.assignPhase();
		}
		catch(Exception e)
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

	@When("^User assigns the testcases to anyone$")
	public void user_assigns_the_testcases_to_anyone() throws Throwable {
	    try
	    {
	    	String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",10 ,12 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[24]=tp.navigateToCycle(phaseName);
		 //String phaseName=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,3 );
			//tr.doubleClickOnRelease(phaseName);
		   
		   int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			//String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,9 );
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			actual[25]=tp.individualAssinTo(TestCaseNo, Assignee);
			bp.waitForElement();
			bp.waitForElement();
			 tp.goBackToCycle();
			bp.waitForElement();
		}
		catch(Exception e)
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

	@Then("^User successfully assigns the testcases$")
	public void user_successfully_assigns_the_testcases() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully assigns the testcase");
		}
		catch(Exception e)
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
