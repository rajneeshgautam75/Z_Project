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

public class Assign_868136 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[39];
	SoftAssert soft=new SoftAssert();
	String filename="Assign_868136";
	@Given("^User is in a page of the TestRepository Page$")
	public void user_is_in_a_page_of_the_TestRepository_Page() throws Throwable {
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

	@Given("^User Creates a Phase under a node$")
	public void user_Creates_a_Phase_under_a_node() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 12);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 15);
		  
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
		 bp.waitForElement();
		 bp.waitForElement();
		 actual[6]=tr.navigateToNode(releaseName, phase);
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

	@When("^User creates a testcase under Phase node$")
	public void user_creates_a_testcase_under_Phase_node() throws Throwable {
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

	@When("^User performs the edit operation on the testcase$")
	public void user_performs_the_edit_operation_on_the_testcase() throws Throwable {
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

	@When("^User selects the testcase and performs the clone operation on it$")
	public void user_selects_the_testcase_and_performs_the_clone_operation_on_it() throws Throwable {
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

	@When("^User creates a system under a phase$")
	public void user_creates_a_system_under_a_phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 12);
		
		actual[3]=tr.doubleClickOnRelease(releaseName);
		 // bp.waitForElement();
		  bp.waitForElement();
		  String[] phase=new String[1];
			phase[0]=p_Name1;
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 13);
			String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 16);
			bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName,phase );
			bp.waitForElement();
			bp.waitForElement();
			actual[7]=tr.addNode(s_Name1,s_Desc1);
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

	@Then("^User creates a testcase under a system$")
	public void user_creates_a_testcase_under_a_system() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			  
			//tr.doubleClickOnRelease(releaseName);
			 // bp.waitForElement();
			  bp.waitForElement();
			 //actual[4]= tr.addNode(p_Name1,p_Desc1);
			actual[8]= tr.doubleClickOnRelease(releaseName);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 12);
			  String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 13);
			 String[] system=new String[2];
			 system[0]=p_Name1;
			 system[1]=s_Name1;
			 
			 
			 actual[9]=tr.navigateToNode(releaseName, system);
			bp.waitForElement();
			actual[10]=tr.addTestCase();
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

	@When("^User performs the edit operation on testcase created$")
	public void user_performs_the_edit_operation_on_testcase_created() throws Throwable {
		try
	    {
		actual[11]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
		
		actual[12]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
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

	@Then("^User selects the testcase and performs the clone operation of a testcase$")
	public void user_selects_the_testcase_and_performs_the_clone_operation_of_a_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[13]=tr.clickOnList();
			bp.waitForElement();
			tr.selectallTestCase();
			actual[14]=tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			actual[15]=tr.cloneTestCase();
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

	@When("^User creates the subsystem under a system$")
	public void user_creates_the_subsystem_under_a_system() throws Throwable {
		 try
		 {
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		actual[16]=tr.doubleClickOnRelease(releaseName);
		
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 12);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 13);
		
		String[] system= new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 14);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 17);
		bp.waitForElement();
		bp.waitForElement();
		actual[17]=tr.navigateToNode(releaseName, system);
		bp.waitForElement();
		actual[18]=tr.addNode(ss_Name1,ss_Desc1);
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
	

	@When("^User creates a testcase and performs the edit operation$")
	public void user_creates_a_testcase_and_performs_the_edit_operation() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			actual[16]=tr.doubleClickOnRelease(releaseName);
			
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 12);
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 13);
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 14);
			
			String[] subsystem= new String[3];
			subsystem[0]=p_Name1;
			subsystem[1]=s_Name1;
			subsystem[2]=ss_Name1;
			//tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[17]=tr.navigateToNode(releaseName, subsystem);
			
			
			
			bp.waitForElement();
			actual[19]=tr.addTestCase();
			actual[20]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[21]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			
			bp.waitForElement();
			actual[22]=tr.clickOnList();
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

	@Then("^User is in the page of a Testplanning$")
	public void user_is_in_the_page_of_a_Testplanning() throws Throwable {
		try
		{
			
			rp= new ReleasePage(driver);
		actual[23]=rp.clickOnTestPlanning();
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

	@Then("^User creates a test cycle and enters all the available fields$")
	public void user_creates_a_test_cycle_and_enters_all_the_available_fields() throws Throwable {
		try
		  {
			tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[24]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			bp.waitForElement();
			actual[25]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[26]=tp.saveTestCycle();
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

	@When("^User creates an phase under an test cycle$")
	public void user_creates_an_phase_under_an_test_cycle() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",11 ,11 );
		     actual[27]=tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		     bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 12);
		actual[28]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		actual[29]=tp.bulkAssignment(Bulk_Type);
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

	@Then("^User navigates to phase and deletes the selected testcase$")
	public void user_navigates_to_phase_and_deletes_the_selected_testcase() throws Throwable {
		try
		{
		String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",11 ,12 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[30]=tp.navigateToCycle(phaseName); 
		bp.waitForElement();
		bp.waitForElement();
		int tcNo[]=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
		bp.waitForElement();
		actual[31]=tp.selectSingleMultipleTestcase(tcNo);
		bp.waitForElement();
		bp.waitForElement();
		actual[32]=tp.deleteAllSelectedTestCases();
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
		

	@When("^User navigates to the system node and deletes the selected testcase$")
	public void user_navigates_to_the_system_node_and_deletes_the_selected_testcase() throws Throwable {
		try
		{
		String[] systemName=new String[1];
	     systemName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",11 ,13 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[33]=tp.navigateToCycle(systemName); 
		bp.waitForElement();
		bp.waitForElement();
		int tcNo[]=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
		bp.waitForElement();
		actual[34]=tp.selectSingleMultipleTestcase(tcNo);
		bp.waitForElement();
		bp.waitForElement();
		actual[35]=tp.deleteAllSelectedTestCases();
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

	@When("^User navigates to the subsystem node and deletes the selected testcase$")
	public void user_navigates_to_the_subsystem_node_and_deletes_the_selected_testcase() throws Throwable {
		try
		{
		String[] subsystemName=new String[1];
	     subsystemName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",11 ,14 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[36]=tp.navigateToCycle(subsystemName); 
		bp.waitForElement();
		bp.waitForElement();
		int tcNo[]=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
		bp.waitForElement();
		actual[37]=tp.selectSingleMultipleTestcase(tcNo);
		bp.waitForElement();
		bp.waitForElement();
		actual[38]=tp.deleteAllSelectedTestCases();
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

	@Then("^User successfully deletes the testcases at all levels$")
	public void user_successfully_deletes_the_testcases_at_all_levels() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully deletes the testcases at different levels");
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
