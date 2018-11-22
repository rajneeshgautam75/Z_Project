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

public class Set_Reset_Dirty_Flags_868125 extends LaunchBrowser {
	
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
	String fileName="Set_Reset_868125";
	
	boolean[] actual=new boolean[43];
	SoftAssert soft=new SoftAssert();
	@Given("^User is in a page of TestRepository$")
	public void user_is_in_a_page_of_TestRepository() throws Throwable {
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

	@Given("^User creates a phase under cycle$")
	public void user_creates_a_phase_under_cycle() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 12);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 12);
		  
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
		 actual[5]=tr.navigateToNode(releaseName, phase);
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

	@When("^User creates a testcase under a phase$")
	public void user_creates_a_testcase_under_a_phase() throws Throwable {
		try
		{
			//bp=new BasePage();
			bp.waitForElement();
			actual[6]=tr.addTestCase();
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
	   	 
		}	}

	@When("^User performs the edit operation on the created testcase$")
	public void user_performs_the_edit_operation_on_the_created_testcase() throws Throwable {
		try
		{
		actual[7]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
		
		actual[8]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
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

	@When("^User selects created testcase and clicks on clone button$")
	public void user_selects_created_testcase_and_clicks_on_clone_button() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[9]=tr.clickOnList();
		bp.waitForElement();
		actual[10]=tr.selectallTestCase();
	    actual[11]=tr.cloneTestCase();
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

	@Then("^User is in a page of TestPlanning$")
	public void user_is_in_a_page_of_TestPlanning() throws Throwable {
		try
		{
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		actual[12]=rp.clickOnTestPlanning();
		bp.waitForElement();
		rp.clickOnTestPlanning();
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

	@Then("^User clicks on the plus symbol and enters the available fields$")
	public void user_clicks_on_the_plus_symbol_and_enters_the_available_fields() throws Throwable {
		try
		{
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 11);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
//		int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
//		int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
//		actual[13]=tp.CreateCycle(cycle, Build, environ, start_date, end_date);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[13]=tp.CreateCycle(cycle, Build, environ, hide);
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

	@When("^User creates a phase under an test cycle$")
	public void user_creates_a_phase_under_an_test_cycle() throws Throwable {
		try
		{
			/*bp=new BasePage();
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	exep=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_3");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_3");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   rp=new ReleasePage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 bp.waitForElement();
			    	 pp.selectRelease(releaseName);*/
			    	 
			    	 bp.waitForElement();
			    	 rp=new ReleasePage(driver);
			    	 //rp.clickOnTestPlanning();
			
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,11 );
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[14]=tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		     bp.waitForElement();
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 12);
		actual[15]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment",2 ,0 );
		actual[16]=tp.bulkAssignment(Bulk_type);
		
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

	@When("^User sets a flag for a testcase when it is not assigned$")
	public void user_sets_a_flag_for_a_testcase_when_it_is_not_assigned() throws Throwable {
		try
		{
			String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,12 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[17]=tp.navigateToCycle(phaseName);
			bp.waitForElement();
			bp.waitForElement();
			/*int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);*/
			/*tp.selectallTestCase();
			bp.waitForElement();
			String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7,9 );
			actual[18]=tp.assignAllSelected(Assignee);
			bp.waitForElement();
			bp.waitForElement();*/
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8);
			//tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 5);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			actual[18]=tp.selectSingleMultipleTestcase(tcNo);
			actual[19]=bp.waitForElement();
			bp.waitForElement();
		actual[20]=tp.setFlags();
		
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

	@When("^User unsets a flag for a testcase when it is not assigned$")
	public void user_unsets_a_flag_for_a_testcase_when_it_is_not_assigned() throws Throwable {
		try
		{
			bp.waitForElement();
			bp.waitForElement();
			actual[21]=tp.unSetFlags();
		
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

	@Then("^User selects a single testcase and assigns to a testlead$")
	public void user_selects_a_single_testcase_and_assigns_to_a_testlead() throws Throwable {
		
		try
		{
			    /*String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1,4 );
			    bp.waitForElement();
			    actual[16]=tp.assignAllSelected(assignee);*/
			int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			actual[22]=tp.individualAssinTo(TestCaseNo, Assignee);
			bp.waitForElement();
			/*int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 5);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			tp.selectSingleMultipleTestcase(tcNo);*/
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

	@Then("^User sets a flag for the same testcase$")
	public void user_sets_a_flag_for_the_same_testcase() throws Throwable {
	    try
	    {
	    	int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8);
			//tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 5);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			tp.selectSingleMultipleTestcase(tcNo);
			actual[23]=bp.waitForElement();
	    	bp.waitForElement();
	    	//tp.selectallTestCase();
	    	bp.waitForElement();
		actual[24]=tp.setFlags();
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

	@When("^User selects a same previous testcase and unset the dirty flag$")
	public void user_selects_a_same_previous_testcase_and_unset_the_dirty_flag() throws Throwable {
		try
		{
			bp.waitForElement();
			bp.waitForElement();
		actual[25]=tp.unSetFlags();
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

	@When("^User is in a page of TestExecution$")
	public void user_is_in_a_page_of_TestExecution() throws Throwable {
		try
		{
			
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	exep=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   rp=new ReleasePage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 pp.selectRelease(releaseName);
			
		rp= new ReleasePage(driver);
		   actual[26]=rp.clickOnTestExecution();
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

	@Then("^User executes the previous assigned testcase by selecting the status drop down$")
	public void user_executes_the_previous_assigned_testcase_by_selecting_the_status_drop_down() throws Throwable {
		try
		{
		tp=new TestPlanningPage(driver);
		/*bp.waitForElement();
		String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		tp.doubleClickOnCycle(cycleName);
		bp.waitForElement();*/
			
		String[] cycleName1=new String[3];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,11 );
	    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,12 );
	    
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
		actual[27]=tp.navigateToCycle(cycleName1);
		bp.waitForElement();
		
		int[] tcNo=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[28]=exep.executeStatus(tcNo[0], statusType);
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

	@When("^User is in a page of TestPlanning page$")
	public void user_is_in_a_page_of_TestPlanning_page() throws Throwable {
		try
		{
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[29]=rp.clickOnTestPlanning();
		   bp.waitForElement();
//		   rp.clickOnTestPlanning();
//		   bp.waitForElement();
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

	@Then("^User navigates to a phase in cycle tree and chooses assign$")
	public void user_navigates_to_a_phase_in_cycle_tree_and_chooses_assign() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
			actual[30]=bp.waitForElement();
			   //actual[30]=rp.clickOnTestPlanning();
			   tp=new TestPlanningPage(driver);
			   String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,11 );
			   bp.waitForElement();
			   tp.doubleClickOnCycle(cycleName1);
			   String[] cycleName=new String[2];
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,11 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,12 );
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[31]=tp.navigateToCycle(cycleName);
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
			   actual[32]=tp.assignPhase();
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

	@When("^User selects a executed testcase by clicking on it and sets the flag$")
	public void user_selects_a_executed_testcase_by_clicking_on_it_and_sets_the_flag() throws Throwable {
		try 
		{
			String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,12 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[33]=tp.navigateToCycle(phaseName);
		   
			int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			actual[34]=tp.individualAssinTo(TestCaseNo, Assignee);
		    bp.waitForElement();
		    actual[35]=tp.selectallTestCase();
		    bp.waitForElement();
		    actual[36]=tp.setFlags();
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

	@Then("^User selects a same executed testcase and unsets the dirty flag$")
	public void user_selects_a_same_executed_testcase_and_unsets_the_dirty_flag() throws Throwable {
		 
		try
		{
		actual[37]=tp.unSetFlags();
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

	@When("^User selects a each testcase and assign each testcase to different user by choosing assign drop down$")
	public void user_selects_a_each_testcase_and_assign_each_testcase_to_different_user_by_choosing_assign_drop_down() throws Throwable {
		try
		{
			int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			actual[38]=tp.individualAssinTo(TestCaseNo, Assignee1);
			
			int[] TestCaseNo1=new int[1];
			TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
			String Assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,9 );
			actual[39]=tp.individualAssinTo(TestCaseNo1, Assignee2);
	    
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

	@Then("^User selects all testcases by clicking on All Select check box and sets the flag$")
	public void user_selects_all_testcases_by_clicking_on_All_Select_check_box_and_sets_the_flag() throws Throwable {
		try 
		{
		bp.waitForElement();	
		actual[40]=tp.selectallTestCase();
	    bp.waitForElement();
	    actual[41]=tp.setFlags();
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

	@Then("^User selects all testcases by clicking on All Select check box and unsets the flag$")
	public void user_selects_all_testcases_by_clicking_on_All_Select_check_box_and_unsets_the_flag() throws Throwable {
		try 
		{
		//actual[42]=tp.selectallTestCase();
	    //actual[43]=tp.selectallTestCase();
	    bp.waitForElement();
	    actual[42]=tp.unSetFlags();
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

	@Then("^User successfully performs the flags operation$")
	public void user_successfully_performs_the_flags_operation() throws Throwable {
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
