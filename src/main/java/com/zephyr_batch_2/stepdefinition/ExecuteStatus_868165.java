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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExecuteStatus_868165 extends LaunchBrowser{

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
	RequirementsPage req;
	String fileName="ExecuteStatus_868165";
	
	boolean[] actual=new boolean[46];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page Of TestRepository$")
	public void user_is_in_a_page_Of_TestRepository() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 bp.waitForElement();
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 bp.waitForElement();
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
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

	@When("^User creates a phase and creates a testcases with different estimated time$")
	public void user_creates_a_phase_and_creates_a_testcases_with_different_estimated_time() throws Throwable {
		try{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 4);
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			actual[3]=tr.doubleClickOnRelease(releaseName);
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase);
			
			actual[5]=tr.addTestCase();
			String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,2 );
			String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 7,2 );
			String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,2 );
			ctc=new CreateTestCasePage(driver);
			actual[6]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[7]=ctc.enterEstimatedTime(day1, hour1, min1);
			bp.waitForElement();
			actual[8]=tr.clickOnList();
			
			actual[9]=tr.addTestCase();
			String day2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,3 );
			String hour2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime",7,3 );
			String min2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,3 );
			ctc=new CreateTestCasePage(driver);
			actual[10]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[11]=ctc.enterEstimatedTime(day2, hour2, min2);
			bp.waitForElement();
			actual[12]=tr.clickOnList();
			
			actual[13]=tr.addTestCase();
			String day3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,4 );
			String hour3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime",7,4 );
			String min3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,4 );
			ctc=new CreateTestCasePage(driver);
			actual[14]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[15]=ctc.enterEstimatedTime(day3, hour3, min3);
			bp.waitForElement();
			actual[16]=tr.clickOnList();
			
			actual[17]=tr.addTestCase();
			String day4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,5 );
			String hour4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime",7,5 );
			String min4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,5 );
			ctc=new CreateTestCasePage(driver);
			actual[18]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[19]=ctc.enterEstimatedTime(day4, hour4, min4);
			bp.waitForElement();
			actual[20]=tr.clickOnList();
			
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

	@When("^User Launches TestPlanning and creates a cycle and creates a phase by choosing an existing phase$")
	public void user_Launches_TestPlanning_and_creates_a_cycle_and_creates_a_phase_by_choosing_an_existing_phase() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[21]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[22]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[23]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[24]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[25]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 0);
				actual[26]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 1);
				actual[27]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[28]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User Launches TestExecution and executes the testcases$")
	public void user_Launches_TestExecution_and_executes_the_testcases() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[29]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",9 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",9 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[30]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[31]=exep.executeStatus(tcNo1[0], statusType1);
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[32]=exep.executeStatus(tcNo2[0], statusType2);
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[33]=exep.executeStatus(tcNo3[0], statusType3);
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[34]=exep.executeStatus(tcNo4[0], statusType4);
				    bp.waitForElement();
				    
				    String cycleName11=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName11);
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

	@When("^User Launches TestPlanning and selects the phase,click on the option assign$")
	public void user_Launches_TestPlanning_and_selects_the_phase_click_on_the_option_assign() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[35]=rp.clickOnTestPlanning();
		bp.waitForElement();

		//tp.navigateBacktoTestPlanning();
		bp.waitForElement();

		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",9 ,0 );
		bp.waitForElement();
		actual[36]=tp.doubleClickOnCycle(cycleName1);
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",9 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",9 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[37]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[38]=tp.assignPhase();
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

	@When("^User selects the phase contains testcases and performs the bulk re-assign operation$")
	public void user_selects_the_phase_contains_testcases_and_performs_the_bulk_re_assign_operation() throws Throwable {
	    try
	    {
	    	 String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",9 ,1 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[39]=tp.navigateToCycle(phaseName);
			bp.waitForElement();
			
			actual[40]=tp.bulkAssignTestcasesSelectedFolder();
			bp.waitForElement();
			
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 6, 9);
			String Check=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 1);
			bp.waitForElement();
			actual[41]=tp.assignAllNotexecuted(assignee, Check);
			bp.waitForElement();
			
			int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,2 );
			String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 7,2 );
			String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,2 );
			bp.waitForElement();
			actual[42]=tp.validateActualTime(tcNo1, day1, hour1, min1);
			bp.waitForElement();
			
			int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			String day2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,3 );
			String hour2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime",7,3 );
			String min2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,3 );
			bp.waitForElement();
			actual[43]=tp.validateActualTime(tcNo2, day2, hour2, min2);
			bp.waitForElement();
			
			int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			String day3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,4 );
			String hour3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime",7,4 );
			String min3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,4 );
			bp.waitForElement();
			actual[44]=tp.validateActualTime(tcNo3, day3, hour3, min3);
			bp.waitForElement();
			
			int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 );
			String day4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,5 );
			String hour4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime",7,5 );
			String min4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,5 );
			bp.waitForElement();
			actual[45]=tp.validateActualTime(tcNo4, day4, hour4, min4);
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

	@Then("^User successfully checks actual time should stay the same as before the bulk change in UI$")
	public void user_successfully_checks_actual_time_should_stay_the_same_as_before_the_bulk_change_in_UI() throws Throwable {
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     tp.goBackToCycle();
	    	log.info("User successfully checks actual time should stay the same as before the bulk change in UI");
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
