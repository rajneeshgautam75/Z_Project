package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Set_Reset_Flags_868127 extends LaunchBrowser {

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
	String fileName="Set_Reset_868127";
	
	boolean[] actual=new boolean[62];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page of the TestRepository$")
	public void user_is_in_a_page_of_the_TestRepository() throws Throwable {
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

	@When("^User creates a testcase under a Phase$")
	public void user_creates_a_testcase_under_a_Phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 3);
		  
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

	@When("^User performs the editing operation on the created testcase$")
	public void user_performs_the_editing_operation_on_the_created_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[6]=tr.addTestCase();
			bp.waitForElement();
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

	@When("^User selects a created testcase and clicks on clone button$")
	public void user_selects_a_created_testcase_and_clicks_on_clone_button() throws Throwable {
		try
		{
			bp.waitForElement();
			tr.clickOnList();
			tr.addTestCase();
			tr.addTestCase();
			tr.selectallTestCase();
			actual[9]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			for(int i=0;i<=7;i++)
			{
				tr.addTestCase();
			}
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

	@Then("^User creates a system node s(\\d+) under a phase node$")
	public void user_creates_a_system_node_s_under_a_phase_node(int arg1) throws Throwable {
		try
		{
	    tr=new TestRepositoryPage(driver);
	    bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
		actual[10]=tr.doubleClickOnRelease(releaseName);
		
		String[] phase=new String[1];
		phase[0]=p_Name1;
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 4);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 4);
		bp.waitForElement();
		actual[11]=tr.navigateToNode(releaseName,phase );
		bp.waitForElement();
		bp.waitForElement();
		actual[12]=tr.addNode(s_Name1,s_Desc1);
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

	@Then("^User creates a testcase under a system node s(\\d+)$")
	public void user_creates_a_testcase_under_a_system_node_s(int arg1) throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			  
			//tr.doubleClickOnRelease(releaseName);
			 // bp.waitForElement();
			  bp.waitForElement();
			 //actual[4]= tr.addNode(p_Name1,p_Desc1);
			actual[13]= tr.doubleClickOnRelease(releaseName);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
			  String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 4);
			 String[] system=new String[2];
			 system[0]=p_Name1;
			 system[1]=s_Name1;
			 
			 
			 actual[14]=tr.navigateToNode(releaseName, system);
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

	@Then("^User performs edit operation on a created testcase$")
	public void user_performs_edit_operation_on_a_created_testcase() throws Throwable {
		try
		{
			actual[15]=tr.addTestCase();
			bp.waitForElement();
			actual[16]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[17]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			
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

	@Then("^User selects a newly created testcase under a system node s(\\d+) and clicks on clone button$")
	public void user_selects_a_newly_created_testcase_under_a_system_node_s_and_clicks_on_clone_button(int arg1) throws Throwable {
		try
		{
			bp.waitForElement();
			tr.clickOnList();
			tr.addTestCase();
			tr.addTestCase();
			tr.selectallTestCase();
			actual[18]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			for(int i=0;i<=7;i++)
			{
				tr.addTestCase();
			}
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

	@When("^User creates a new system node s(\\d+) under a system node s(\\d+)$")
	public void user_creates_a_new_system_node_s_under_a_system_node_s(int arg1, int arg2) throws Throwable {
		try
		{
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		actual[19]=tr.doubleClickOnRelease(releaseName);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 4);
		
		
		String[] system= new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 5);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 5);
		bp.waitForElement();
		//tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[20]=tr.navigateToNode(releaseName, system);
		bp.waitForElement();
		actual[21]=tr.addNode(ss_Name1,ss_Desc1);
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

	@Then("^User creates a testcase under a newly created system node s(\\d+)$")
	public void user_creates_a_testcase_under_a_newly_created_system_node_s(int arg1) throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			actual[22]=tr.doubleClickOnRelease(releaseName);
			
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 4);
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 5);
			
			String[] subsystem= new String[3];
			subsystem[0]=p_Name1;
			subsystem[1]=s_Name1;
			subsystem[2]=ss_Name1;
			//tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[23]=tr.navigateToNode(releaseName, subsystem);
		bp.waitForElement();
		actual[24]=tr.addTestCase();
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

	@Then("^User performs the edit operation on a testcase of a newly created system node s(\\d+)$")
	public void user_performs_the_edit_operation_on_a_testcase_of_a_newly_created_system_node_s(int arg1) throws Throwable {
		try
		{
			bp.waitForElement();
			actual[25]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[26]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			
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

	@When("^User selects a testcase under a newly created system node s(\\d+) and clicks clone button$")
	public void user_selects_a_testcase_under_a_newly_created_system_node_s_and_clicks_clone_button(int arg1) throws Throwable {
		try
		{
			bp.waitForElement();
			tr.clickOnList();
			tr.addTestCase();
			tr.addTestCase();
			tr.selectallTestCase();
			actual[27]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			for(int i=0;i<=7;i++)
			{
				tr.addTestCase();
			}
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

	@Then("^User creates a system node s(\\d+) under system node s(\\d+)$")
	public void user_creates_a_system_node_s_under_system_node_s(int arg1, int arg2) throws Throwable {
		try
		{
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		actual[28]=tr.doubleClickOnRelease(releaseName);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 4);
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 5);
		
		
		String[] subsystem= new String[3];
		subsystem[0]=p_Name1;
		subsystem[1]=s_Name1;
		subsystem[2]=ss_Name1;
		
		String sss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 6);
		String sss_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 6);
		bp.waitForElement();
		bp.waitForElement();
		actual[29]=tr.navigateToNode(releaseName, subsystem);
		bp.waitForElement();
		actual[30]=tr.addNode(sss_Name1,sss_Desc1);
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

	@Then("^User performs edit operation on the created testcase$")
	public void user_performs_edit_operation_on_the_created_testcase() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			actual[31]=tr.doubleClickOnRelease(releaseName);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 4);
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 5);
			String sss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 6);
			
			
			String[] subsubsystem= new String[4];
			subsubsystem[0]=p_Name1;
			subsubsystem[1]=s_Name1;
			subsubsystem[2]=ss_Name1;
			subsubsystem[3]=sss_Name1;
			
			
			bp.waitForElement();
			bp.waitForElement();
			actual[32]=tr.navigateToNode(releaseName, subsubsystem);
			bp.waitForElement();
			actual[33]=tr.addTestCase();
			bp.waitForElement();
			actual[34]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[35]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			
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

	@Then("^User selects a newly created testcase under a system node s(\\d+) and clicks clone button$")
	public void user_selects_a_newly_created_testcase_under_a_system_node_s_and_clicks_clone_button(int arg1) throws Throwable {
		try
		{
			bp.waitForElement();
			tr.clickOnList();
			tr.addTestCase();
			tr.addTestCase();
			tr.selectallTestCase();
			actual[36]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			for(int i=0;i<=7;i++)
			{
				tr.addTestCase();
			}
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

	@When("^User is in a page TestPlanning page$")
	public void user_is_in_a_page_TestPlanning_page() throws Throwable {
		
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[37]=rp.clickOnTestPlanning();
		bp.waitForElement();
//		rp.clickOnTestPlanning();
//		bp.waitForElement();
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

	@When("^User clicks on plus button and enter all the available fields$")
	public void user_clicks_on_plus_button_and_enter_all_the_available_fields() throws Throwable {
	    try
	    {
	    	tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 15, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[38]=tp.clickOnAddTestCycleSymbol();
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			bp.waitForElement();
			//bp.waitForElement();
			actual[39]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 24));
			bp.waitForElement();
			bp.waitForElement();
			actual[40]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			//bp.waitForElement();
			actual[41]=tp.saveTestCycle();
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

	@When("^User creates a phase under a test cycle$")
	public void user_creates_a_phase_under_a_test_cycle() throws Throwable {
		
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",15 ,11 );
		     tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		     bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 3);
		actual[42]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment",1 ,0 );
		actual[43]=tp.bulkAssignment(Bulk_type);
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

	@When("^User assigns the testcase to a Anyone$")
	public void user_assigns_the_testcase_to_a_Anyone() throws Throwable {
		
		try
		{
			
			String[] cycleName1=new String[1];
		    //cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,0 );
		    cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,3 );
		    
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[44]=tp.navigateToCycle(cycleName1);
			
		    int[] TestCaseNo1=new int[1];
			TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,9 );
			actual[45]=tp.individualAssinTo(TestCaseNo1, Assignee1);
			
			 int[] TestCaseNo2=new int[1];
				TestCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
				String Assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				actual[46]=tp.individualAssinTo(TestCaseNo2, Assignee2);
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

	@Then("^User selects the phase node and sets the toggle flag$")
	public void user_selects_the_phase_node_and_sets_the_toggle_flag() throws Throwable {
	 try
	 {
		 bp.waitForElement();
			bp.waitForElement();
			int tcNo[]=new int[3];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			tcNo[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			bp.waitForElement();
			bp.waitForElement();
			actual[47]=tp.selectSingleMultipleTestcase(tcNo);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		 actual[48]=tp.setToggleFlags();
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

	@Then("^User again selects the phase node and resets the toggle flag$")
	public void user_again_selects_the_phase_node_and_resets_the_toggle_flag() throws Throwable {
		try
		 {
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[49]=tp.resetToggleFlag();
			
			String[] cycleName2=new String[1];
			cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,4 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
		     bp.waitForElement();
			actual[50]=tp.navigateToCycle(cycleName2); 
			bp.waitForElement();
			bp.waitForElement();
			int tcNo[]=new int[3];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			tcNo[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			bp.waitForElement();
			bp.waitForElement();
			actual[51]=tp.selectSingleMultipleTestcase(tcNo);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[52]=tp.setToggleFlags();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[53]=tp.resetToggleFlag();
			
			String[] cycleName3=new String[1];
			cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,5 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
		     bp.waitForElement();
			actual[54]=tp.navigateToCycle(cycleName3); 
			bp.waitForElement();
			bp.waitForElement();
			int tcNo1[]=new int[3];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			tcNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			tcNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			bp.waitForElement();
			bp.waitForElement();
			actual[55]=tp.selectSingleMultipleTestcase(tcNo1);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[56]=tp.setToggleFlags();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[57]=tp.resetToggleFlag();
			
			
			String[] cycleName4=new String[1];
			cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,6 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
		     bp.waitForElement();
			actual[58]=tp.navigateToCycle(cycleName4); 
			bp.waitForElement();
			bp.waitForElement();
			int tcNo2[]=new int[3];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			tcNo2[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			tcNo2[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			bp.waitForElement();
			bp.waitForElement();
			actual[59]=tp.selectSingleMultipleTestcase(tcNo2);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[60]=tp.setToggleFlags();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[61]=tp.resetToggleFlag();
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

	@Then("^User successfully set/reset the flags successfully$")
	public void user_successfully_set_reset_the_flags_successfully() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
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
