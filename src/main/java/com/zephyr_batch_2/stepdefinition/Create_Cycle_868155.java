package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_Cycle_868155 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	
	boolean[] actual=new boolean[191];
	 SoftAssert soft=new SoftAssert();
	 String fileName="Create_Cycle_868155";
	
	@Given("^User is in a page of an test repository$")
	public void user_is_in_a_page_of_an_test_repository() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
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
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
		   	 
			}
	}

	@Given("^User Creates a Phase and creates a testcase under the phase$")
	public void user_Creates_a_Phase_and_creates_a_testcase_under_the_phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 7);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 15);
		  
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
		 bp.waitForElement();
			actual[5]=tr.addTestCase();
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@Given("^User performs the edit operation for the testcase$")
	public void user_performs_the_edit_operation_for_the_testcase() throws Throwable {
		try
		{
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		bp.waitForElement();
		actual[6]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
		
		actual[7]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
		bp.waitForElement();
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	}

	@Given("^User enters the step details and save$")
	public void user_enters_the_step_details_and_save() throws Throwable {
	    try
	    {
	    	String[] stepDetail=new String[9];
			stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
			stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
			stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);
			stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
			stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
			stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
			stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
			stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
			stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[8]=ctc.enterTestCaseStepDetail(stepDetail);
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	}

	@Given("^User performs the clone operation of a testcase$")
	public void user_performs_the_clone_operation_of_a_testcase() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=tr.selectallTestCase();
			bp.waitForElement();
			actual[11]=tr.cloneTestCase();
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@When("^User creates a cycle in TestPlanning and enters the available fields$")
	public void user_creates_a_cycle_in_TestPlanning_and_enters_the_available_fields() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
			bp.waitForElement();
		actual[12]=rp.clickOnTestPlanning();
		
		bp=new BasePage();
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 6);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[13]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[14]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[15]=tp.saveTestCycle();
		
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
		
	}

	@When("^User creates a phase by choosing an existing Phase and save$")
	public void user_creates_a_phase_by_choosing_an_existing_Phase_and_save() throws Throwable {
	    try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 6);
			bp.waitForElement();
			actual[16]=tp.navigateToCycle(cycle);
			
			
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 7);
			bp.waitForElement();
			actual[17]=tp.addPhaseToCycle(phase);
			
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[18]=tp.bulkAssignment(Bulk_Type);
			}
			catch(Exception e)
			{
				 lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User individually assigns the testcase to anyone$")
	public void user_individually_assigns_the_testcase_to_anyone() throws Throwable {
		try
	    {
			   String[] phaseName=new String[1];
			   phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",1 ,7 );
			     bp.waitForElement();
			     actual[19]=tp.navigateToCycle(phaseName);
			     
			     int[] TestCaseNo=new int[1];
					TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
					String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
					bp.waitForElement();
					actual[20]=tp.individualAssinTo(TestCaseNo, Assignee);
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User navigates to testPlanning and selects a cycle and clicks edit and check hide button$")
	public void user_navigates_to_testPlanning_and_selects_a_cycle_and_clicks_edit_and_check_hide_button() throws Throwable {
		try
		   {
			tp.goBackToCycle();
			bp.waitForElement();
			   actual[21]=rp.clickOnTestPlanning();
			   
			   
			   
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",1 ,6 );
			     bp.waitForElement();
			     actual[22]=tp.navigateToCycle(cycleName);
			     
			     String cycle=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
			     String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
			     String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
			     String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,27 );
			     bp.waitForElement();
			     bp.waitForElement();
					actual[23]=tp.editCycle(cycle, Build, environ, hide);
					bp.waitForElement();
					actual[24]=tp.saveTestCycle();
			      
		   }
		   catch(Exception e)
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			} 
	}

	@When("^User creates a phase and creates a testcase and performs the edit operation$")
	public void user_creates_a_phase_and_creates_a_testcase_and_performs_the_edit_operation() throws Throwable {
		try
		{
			rp= new ReleasePage(driver);
			bp.waitForElement();
			   actual[25]=rp.clickOnTestRep(); 
			
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 7);
		  String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 15);
		  
		  tr=new TestRepositoryPage(driver);
		  bp=new BasePage();
		  bp.waitForElement();
		  actual[26]=tr.doubleClickOnRelease(releaseName);
		 // bp.waitForElement();
		  bp.waitForElement();
		 actual[27]= tr.addNode(p_Name2,p_Desc2);
		 tr.doubleClickOnRelease(releaseName);
		 String[] phase2=new String[1];
		 phase2[0]=p_Name2;
		 tr.navigateToNode(releaseName, phase2);
		 bp.waitForElement();
			actual[28]=tr.addTestCase();
			
			bp.waitForElement();
			actual[29]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[30]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			bp.waitForElement();
			
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@When("^User performs the clone operation for the testcase$")
	public void user_performs_the_clone_operation_for_the_testcase() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			actual[31]=tr.clickOnList();
			bp.waitForElement();
			actual[32]=tr.selectallTestCase();
			bp.waitForElement();
			actual[33]=tr.cloneTestCase();
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}  
	}

	@When("^User creates a second cycle and enters the available fields and save$")
	public void user_creates_a_second_cycle_and_enters_the_available_fields_and_save() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
			bp.waitForElement();
		actual[34]=rp.clickOnTestPlanning();
		
		bp=new BasePage();
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 6);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		actual[35]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[36]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[37]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[38]=tp.saveTestCycle();
		
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User creates a phase by choosing an existing phase and click on save$")
	public void user_creates_a_phase_by_choosing_an_existing_phase_and_click_on_save() throws Throwable {
		 try
		    {
		    	String[] cycle=new String[1];
				cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 6);
				actual[39]=tp.navigateToCycle(cycle);
				
				
				String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 7);
				bp.waitForElement();
				actual[40]=tp.addPhaseToCycle(phase);
				
				
				/*String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[41]=tp.bulkAssignment(Bulk_Type);*/
				}
				catch(Exception e)
				{
					 lb.getScreenShot(fileName);
					e.printStackTrace();
					driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e;
				}
	}

	@When("^User cancels the bulk assignment popup$")
	public void user_cancels_the_bulk_assignment_popup() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[41]=tp.cancelBulkAssign();
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
		
	}

	@When("^User selects few testcases and assigns to anyone$")
	public void user_selects_few_testcases_and_assigns_to_anyone() throws Throwable {
		try
		{
		String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",2 ,7 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[42]=tp.navigateToCycle(phaseName); 
		bp.waitForElement();
		bp.waitForElement();
		int tcNo[]=new int[2];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
		tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
		bp.waitForElement();
		actual[43]=tp.selectSingleMultipleTestcase(tcNo);
		bp.waitForElement();
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		actual[44]=tp.assignAllSelected(assignee);
		tp.goBackToCycle();
//		rp.clickOnTestPlanning();
		//////tp.navigateBacktoTestPlanning();
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User is in a page TestExecution and execute few testcases by selecting status drop down$")
	public void user_is_in_a_page_TestExecution_and_execute_few_testcases_by_selecting_status_drop_down() throws Throwable {
		try
		{
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[45]=rp.clickOnTestExecution(); 
		   
			String[] cycleName=new String[3];
		    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",2 ,6 );
		    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",2 ,7 );
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
//		    bp.waitForElement();
			actual[46]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			
			/*int[] testCaseNo=new int[1];
		    ;
		    testCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,5 );
		    tp.selectSingleMultipleTestcase(testCaseNo);*/
		    
		    //status selection method should be implement here
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[47]=exep.executeStatus(tcNo1[0], statusType1);
		    
		    int[] tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
		    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[48]=exep.executeStatus(tcNo2[0], statusType2);
			}
			catch(Exception e)
			{
				 lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
		}
		

	@When("^User navigates to TestPlanning and selects second cycle and select edit and check hide option and save$")
	public void user_navigates_to_TestPlanning_and_selects_second_cycle_and_select_edit_and_check_hide_option_and_save() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    	actual[49]=rp.clickOnTestPlanning();
	    	
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",2 ,6 );
		     actual[50]=tp.navigateToCycle(cycleName);
		     
		     String cycle=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",2 ,6 );
		     String Build=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
		     String environ=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
		     String hide=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,27 );
		     bp.waitForElement();
		     bp.waitForElement();
				actual[51]=tp.editCycle(cycle, Build, environ, hide);
				bp.waitForElement();
				actual[52]=tp.saveTestCycle();
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User creates a twenty phases with few testcases each phase$")
	public void user_creates_a_twenty_phases_with_few_testcases_each_phase() throws Throwable {
		try
    	{
    		bp.waitForElement();
    		bp.waitForElement();
    		actual[53]=rp.clickOnTestRep();
    		
    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
    	  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 0);
    	  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 1);
    	  
    	  tr=new TestRepositoryPage(driver);
    	  bp=new BasePage();
    	  bp.waitForElement();
    	  actual[54]=tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	 actual[55]= tr.addNode(p_Name1,p_Desc1);
    	 bp.waitForElement();
    	 tr.doubleClickOnRelease(releaseName);
   	     bp.waitForElement();
    	 actual[56]=tr.selectPhase(p_Name1);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 0);
    	  String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 1);
    	  actual[57]=tr.addNode(p_Name2, p_Desc2);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  actual[58]=tr.selectPhase(p_Name2);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
    	 String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 0);
    	  String p_Desc3=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 1);
    	  actual[59]=tr.addNode(p_Name3, p_Desc3);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	 actual[60]=tr.selectPhase(p_Name3);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 0);
    	  String p_Desc4=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 1);
    	  actual[61]=tr.addNode(p_Name4, p_Desc4);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[62]=tr.selectPhase(p_Name4);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 5, 0);
    	  String p_Desc5=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 5, 1);
    	  actual[63]=tr.addNode(p_Name5, p_Desc5);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[64]=tr.selectPhase(p_Name5);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 6, 0);
    	  String p_Desc6=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 6, 1);
    	  actual[65]=tr.addNode(p_Name6, p_Desc6);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[66]=tr.selectPhase(p_Name6);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 7, 0);
    	  String p_Desc7=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 7, 1);
    	  actual[67]=tr.addNode(p_Name7, p_Desc7);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[68]=tr.selectPhase(p_Name7);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	     bp.waitForElement();
    	 String p_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 8, 0);
    	  String p_Desc8=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 8, 1);
    	  actual[69]=tr.addNode(p_Name8, p_Desc8);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[70]=tr.selectPhase(p_Name8);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 9, 0);
    	  String p_Desc9=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 9, 1);
    	  actual[71]=tr.addNode(p_Name9, p_Desc9);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[72]=tr.selectPhase(p_Name9);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 10, 0);
    	  String p_Desc10=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 10, 1);
    	  actual[73]=tr.addNode(p_Name10, p_Desc10);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[74]=tr.selectPhase(p_Name10);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name11=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 11, 0);
    	  String p_Desc11=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 11, 1);
    	  actual[75]=tr.addNode(p_Name11, p_Desc11);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[76]=tr.selectPhase(p_Name11);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name12=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 12, 0);
    	  String p_Desc12=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 12, 1);
    	  actual[77]=tr.addNode(p_Name12, p_Desc12);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[78]=tr.selectPhase(p_Name12);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name13=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 13, 0);
    	  String p_Desc13=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 13, 1);
    	  actual[79]=tr.addNode(p_Name13, p_Desc13);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[80]=tr.selectPhase(p_Name13);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name14=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 14, 0);
    	  String p_Desc14=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 14, 1);
    	  actual[81]=tr.addNode(p_Name14, p_Desc14);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[82]=tr.selectPhase(p_Name14);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name15=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 15, 0);
    	  String p_Desc15=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 15, 1);
    	  actual[83]=tr.addNode(p_Name15, p_Desc15);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[84]=tr.selectPhase(p_Name15);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name16=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 16, 0);
    	  String p_Desc16=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 16, 1);
    	  actual[85]=tr.addNode(p_Name16, p_Desc16);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[86]=tr.selectPhase(p_Name16);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name17=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 17, 0);
    	  String p_Desc17=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 17, 1);
    	  actual[87]=tr.addNode(p_Name17, p_Desc17);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[88]=tr.selectPhase(p_Name17);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name18=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 18, 0);
    	  String p_Desc18=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 18, 1);
    	  actual[89]=tr.addNode(p_Name18, p_Desc18);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[90]=tr.selectPhase(p_Name18);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name19=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 19, 0);
    	  String p_Desc19=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 19, 1);
    	  actual[91]=tr.addNode(p_Name19, p_Desc19);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[92]=tr.selectPhase(p_Name19);
    	 tr.addTestCase();
    	 
    	 tr.doubleClickOnRelease(releaseName);
   	  bp.waitForElement();
    	 String p_Name20=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 20, 0);
    	  String p_Desc20=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 20, 1);
    	  actual[93]=tr.addNode(p_Name20, p_Desc20);
    	  bp.waitForElement();
    	  tr.doubleClickOnRelease(releaseName);
    	  bp.waitForElement();
    	  actual[94]=tr.selectPhase(p_Name20);
    	 tr.addTestCase();
    	}
    	catch(Exception e)
    	{
    		 lb.getScreenShot(fileName);
    		e.printStackTrace();
    		driver.close();
          	Relogin_TPE rl=new Relogin_TPE();
          	rl.reLogin();
          	throw e;
       	 
    	}  	
	}

	@When("^User creates a third cycle with all the available fields and save$")
	public void user_creates_a_third_cycle_with_all_the_available_fields_and_save() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[95]=rp.clickOnTestPlanning();
		
		bp=new BasePage();
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		actual[96]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[97]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[98]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[99]=tp.saveTestCycle();
		
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User creates a twenty phases by choosing an existing phases$")
	public void user_creates_a_twenty_phases_by_choosing_an_existing_phases() throws Throwable {
		try
	    {
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[100]=tp.navigateToCycle(cycle1);
			
			String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 0);
			bp.waitForElement();
			actual[101]=tp.addPhaseToCycle(phase1);
			
			String Bulk_Type1=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[102]=tp.bulkAssignment(Bulk_Type1);
			
			bp.waitForElement();
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			//////tp.navigateBacktoTestPlanning();
			
			String[] cycle2=new String[1];
			cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[103]=tp.navigateToCycle(cycle2);
			
			String phase2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 0);
			bp.waitForElement();
			actual[104]=tp.addPhaseToCycle(phase2);
			
			String Bulk_Type2=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[105]=tp.bulkAssignment(Bulk_Type2);
			
			bp.waitForElement();
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			//////tp.navigateBacktoTestPlanning();
			String[] cycle3=new String[1];
			cycle3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[106]=tp.navigateToCycle(cycle3);
			
			String phase3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 0);
			bp.waitForElement();
			actual[107]=tp.addPhaseToCycle(phase3);
			
			String Bulk_Type3=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[108]=tp.bulkAssignment(Bulk_Type3);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			//////tp.navigateBacktoTestPlanning();
			String[] cycle4=new String[1];
			cycle4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[109]=tp.navigateToCycle(cycle4);
			
			String phase4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 0);
			bp.waitForElement();
			actual[110]=tp.addPhaseToCycle(phase4);
			
			String Bulk_Type4=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[111]=tp.bulkAssignment(Bulk_Type4);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			//////tp.navigateBacktoTestPlanning();
			String[] cycle5=new String[1];
			cycle5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[112]=tp.navigateToCycle(cycle5);
			
			String phase5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 5, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[113]=tp.addPhaseToCycle(phase5);
			
			String Bulk_Type5=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[114]=tp.bulkAssignment(Bulk_Type5);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			//////tp.navigateBacktoTestPlanning();
			String[] cycle6=new String[1];
			cycle6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[115]=tp.navigateToCycle(cycle6);
			
			String phase6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 6, 0);
			bp.waitForElement();
			actual[116]=tp.addPhaseToCycle(phase6);
			
			String Bulk_Type6=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[117]=tp.bulkAssignment(Bulk_Type6);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle7=new String[1];
			cycle7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[118]=tp.navigateToCycle(cycle7);
			
			String phase7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 7, 0);
			bp.waitForElement();
			actual[119]=tp.addPhaseToCycle(phase7);
			
			String Bulk_Type7=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[120]=tp.bulkAssignment(Bulk_Type7);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle8=new String[1];
			cycle8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[121]=tp.navigateToCycle(cycle8);
			
			String phase8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 8, 0);
			bp.waitForElement();
			actual[122]=tp.addPhaseToCycle(phase8);
			
			String Bulk_Type8=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[123]=tp.bulkAssignment(Bulk_Type8);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle9=new String[1];
			cycle9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[124]=tp.navigateToCycle(cycle9);
			
			String phase9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 9, 0);
			bp.waitForElement();
			actual[125]=tp.addPhaseToCycle(phase9);
			
			String Bulk_Type9=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[126]=tp.bulkAssignment(Bulk_Type9);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle10=new String[1];
			cycle10[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[127]=tp.navigateToCycle(cycle10);
			
			String phase10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 10, 0);
			bp.waitForElement();
			actual[128]=tp.addPhaseToCycle(phase10);
			
			String Bulk_Type10=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[129]=tp.bulkAssignment(Bulk_Type10);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle11=new String[1];
			cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[130]=tp.navigateToCycle(cycle11);
			
			String phase11=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 11, 0);
			bp.waitForElement();
			actual[131]=tp.addPhaseToCycle(phase11);
			
			String Bulk_Type11=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[132]=tp.bulkAssignment(Bulk_Type11);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle12=new String[1];
			cycle12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[133]=tp.navigateToCycle(cycle12);
			
			String phase12=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 12, 0);
			bp.waitForElement();
			actual[134]=tp.addPhaseToCycle(phase12);
			
			String Bulk_Type12=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[135]=tp.bulkAssignment(Bulk_Type12);
			
			tp.goBackToCycle();
			
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle13=new String[1];
			cycle13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[136]=tp.navigateToCycle(cycle13);
			
			String phase13=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 13, 0);
			bp.waitForElement();
			actual[137]=tp.addPhaseToCycle(phase13);
			
			String Bulk_Type13=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[138]=tp.bulkAssignment(Bulk_Type13);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle14=new String[1];
			cycle14[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[139]=tp.navigateToCycle(cycle14);
			
			String phase14=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 14, 0);
			bp.waitForElement();
			actual[140]=tp.addPhaseToCycle(phase14);
			
			String Bulk_Type14=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[141]=tp.bulkAssignment(Bulk_Type14);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle15=new String[1];
			cycle15[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[142]=tp.navigateToCycle(cycle15);
			
			String phase15=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 15, 0);
			bp.waitForElement();
			actual[143]=tp.addPhaseToCycle(phase15);
			
			String Bulk_Type15=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[144]=tp.bulkAssignment(Bulk_Type15);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle16=new String[1];
			cycle16[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[145]=tp.navigateToCycle(cycle16);
			
			String phase16=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 16, 0);
			bp.waitForElement();
			actual[146]=tp.addPhaseToCycle(phase16);
			
			String Bulk_Type16=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[147]=tp.bulkAssignment(Bulk_Type16);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle17=new String[1];
			cycle17[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[148]=tp.navigateToCycle(cycle17);
			
			String phase17=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 17, 0);
			bp.waitForElement();
			actual[149]=tp.addPhaseToCycle(phase17);
			
			String Bulk_Type17=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[150]=tp.bulkAssignment(Bulk_Type17);
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle18=new String[1];
			cycle18[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[151]=tp.navigateToCycle(cycle18);
			
			String phase18=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 18, 0);
			bp.waitForElement();
			actual[152]=tp.addPhaseToCycle(phase18);
			
			String Bulk_Type18=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[153]=tp.bulkAssignment(Bulk_Type18);
			
			tp.goBackToCycle();
			
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle19=new String[1];
			cycle19[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[154]=tp.navigateToCycle(cycle19);
			
			String phase19=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 19, 0);
			bp.waitForElement();
			actual[155]=tp.addPhaseToCycle(phase19);
			
			String Bulk_Type19=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[156]=tp.bulkAssignment(Bulk_Type19);
			
			tp.goBackToCycle();
			bp.waitForElement();
			rp.clickOnTestPlanning();
			////tp.navigateBacktoTestPlanning();
			String[] cycle20=new String[1];
			cycle20[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 6);
			actual[157]=tp.navigateToCycle(cycle20);
			
			String phase20=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 20, 0);
			bp.waitForElement();
			actual[158]=tp.addPhaseToCycle(phase20);
			
			String Bulk_Type20=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[159]=tp.bulkAssignment(Bulk_Type20);
			
			}
			catch(Exception e)
			{
				 lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User navigates to TestPlanning and selects third cycle and select edit and check hide$")
	public void user_navigates_to_TestPlanning_and_selects_third_cycle_and_select_edit_and_check_hide() throws Throwable {
		try
	    {
			tp.goBackToCycle();
	    	bp.waitForElement();
	    	rp.clickOnTestPlanning();
	    	////tp.navigateBacktoTestPlanning();
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",3 ,6 );
		     actual[160]=tp.navigateToCycle(cycleName);
		     
		     String cycle=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
		     String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
		     String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
		     String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,27 );
		     bp.waitForElement();
		     bp.waitForElement();
				actual[161]=tp.editCycle(cycle, Build, environ, hide);
				bp.waitForElement();
				bp.waitForElement();
				actual[162]=tp.saveTestCycle();
				bp.waitForElement();
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User creates a phase within a phase upto (\\d+)th leavel$")
	public void user_creates_a_phase_within_a_phase_upto_th_leavel(int arg1) throws Throwable {
	    	try
	    	{
	    		bp.waitForElement();
	    		driver.navigate().refresh();
	    		bp.waitForElement();
	    		bp.waitForElement();
	    		bp.waitForElement();
	    		//rp=new ReleasePage(driver);
	    		actual[163]=rp.clickOnTestRep();
	    		
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 3);
	    	  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 4);
	    	  
	    	  tr=new TestRepositoryPage(driver);
	    	  bp=new BasePage();
	    	  bp.waitForElement();
	    	  actual[164]=tr.doubleClickOnRelease(releaseName);
	    	 // bp.waitForElement();
	    	  bp.waitForElement();
	    	 actual[165]= tr.addNode(p_Name1,p_Desc1);
	    	 //tr.doubleClickOnRelease(releaseName);
	    	 /*String[] phase=new String[1];
	    	 phase[0]=p_Name1;
	    	 tr.navigateToNode(releaseName, phase);
	    	 tr.doubleClickOnRelease(releaseName);*/
	    	 bp.waitForElement();
	    	 tr.doubleClickOnRelease(releaseName);
	    	 actual[166]=tr.selectPhase(p_Name1);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 3);
	    	  String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 2, 4);
	    	  actual[167]=tr.addNode(p_Name2, p_Desc2);
	    	  bp.waitForElement();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[168]=tr.selectPhase(p_Name2);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 3);
	    	  String p_Desc3=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 3, 4);
	    	  actual[169]=tr.addNode(p_Name3, p_Desc3);
	    	  bp.waitForElement();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[170]=tr.selectPhase(p_Name3);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 3);
	    	  String p_Desc4=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 4);
	    	  actual[171]=tr.addNode(p_Name4, p_Desc4);
	    	  bp.waitForElement();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[172]=tr.selectPhase(p_Name4);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 5, 3);
	    	  String p_Desc5=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 5, 4);
	    	  actual[173]=tr.addNode(p_Name5, p_Desc5);
	    	  bp.waitForElement();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[174]=tr.selectPhase(p_Name5);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 6, 3);
	    	  String p_Desc6=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 6, 4);
	    	  actual[175]=tr.addNode(p_Name6, p_Desc6);
	    	  bp.waitForElement();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[176]=tr.selectPhase(p_Name6);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 7, 3);
	    	  String p_Desc7=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 7, 4);
	    	  actual[177]=tr.addNode(p_Name7, p_Desc7);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[178]=tr.selectPhase(p_Name7);
	    	 tr.addTestCase();
	    	 
	    	 tr.clickOnRelease(releaseName);
	    	 String p_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 8, 3);
	    	  String p_Desc8=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 8, 4);
	    	  actual[179]=tr.addNode(p_Name8, p_Desc8);
	    	  bp.waitForElement();
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[180]=tr.selectPhase(p_Name8);
	    	 tr.addTestCase();
	    	}
	    	catch(Exception e)
	    	{
	    		 lb.getScreenShot(fileName);
	    		e.printStackTrace();
	    		driver.close();
	          	Relogin_TPE rl=new Relogin_TPE();
	          	rl.reLogin();
	          	throw e;
	       	 
	    	}  	
	    }
	 

	@When("^User creates a cycle with all the available fields and save$")
	public void user_creates_a_cycle_with_all_the_available_fields_and_save() throws Throwable {
		try
		{
		bp.waitForElement();
		rp.clickOnTestPlanning();
		
		bp=new BasePage();
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 6);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		actual[181]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[182]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[183]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[184]=tp.saveTestCycle();
		
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User creates a phase by choosing an existing phase with upto (\\d+)th level$")
	public void user_creates_a_phase_by_choosing_an_existing_phase_with_upto_th_level(int arg1) throws Throwable {
		 try
		    {
		    	String[] cycle=new String[1];
				cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 4, 6);
				actual[185]=tp.navigateToCycle(cycle);
				
				
				String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155", 1, 3);
				bp.waitForElement();
				actual[186]=tp.addPhaseToCycle(phase);
				
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[187]=tp.bulkAssignment(Bulk_Type);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e;
				}
	}

	@When("^User navigates to TestPlanning and selects a third cycle and select edit and check hide and save$")
	public void user_navigates_to_TestPlanning_and_selects_a_third_cycle_and_select_edit_and_check_hide_and_save() throws Throwable {
		try
	    {
			tp.goBackToCycle();
	    	bp.waitForElement();
	    	rp.clickOnTestPlanning();
	    	////tp.navigateBacktoTestPlanning();
	    	
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",3 ,6 );
		     actual[188]=tp.navigateToCycle(cycleName);
		     
		     String cycle=Excel_Lib.getData(INPUT_PATH_3, "CreateCycle_868155",100 ,100 );
		     String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
		     String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",100 ,100 );
		     String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,27 );
		     bp.waitForElement();
		     bp.waitForElement();
				actual[189]=tp.editCycle(cycle, Build, environ, hide);
				bp.waitForElement();
				actual[190]=tp.saveTestCycle();
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@Then("^User successfully edit and hidden a cycle$")
	public void user_successfully_edit_and_hidden_a_cycle() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully edit and hidden a cycle");
		}
		catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
}
