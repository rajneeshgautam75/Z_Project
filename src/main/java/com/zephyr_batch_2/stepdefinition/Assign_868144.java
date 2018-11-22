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

public class Assign_868144 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[19];
	SoftAssert soft=new SoftAssert();
	String filename="Assign_868144";
	
	@Given("^User is in a page of the TestRepository page$")
	public void user_is_in_a_page_of_the_TestRepository_page() throws Throwable 
	{
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

	@Given("^User creates a phase under the release$")
	public void user_creates_a_phase_under_the_release() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 12);
			  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 2, 15);
			  
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

	@When("^User creates a testcase under phase$")
	public void user_creates_a_testcase_under_phase() throws Throwable {
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

	@When("^User performs the edit operation on testcase$")
	public void user_performs_the_edit_operation_on_testcase() throws Throwable {
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

	@When("^User clones the testcase by clicking on the clone button$")
	public void user_clones_the_testcase_by_clicking_on_the_clone_button() throws Throwable {
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

	@Then("^User is in a page of a TestPlanning page$")
	public void user_is_in_a_page_of_a_TestPlanning_page() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[13]=rp.clickOnTestPlanning();
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

	@Then("^User clicks on create cycle and enter all available fields$")
	public void user_clicks_on_create_cycle_and_enter_all_available_fields() throws Throwable {
		try
		  {
			tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 6, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			bp.waitForElement();
			tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[14]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
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

	@When("^User creates a phase under a cycle$")
	public void user_creates_a_phase_under_a_cycle() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,11 );
		     tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		     bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 12);
			actual[15]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			actual[16]=tp.bulkAssignment(Bulk_Type);
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

	@Then("^User chooses assign option$")
	public void user_chooses_assign_option() throws Throwable {
	    try
	    {
	    	String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,12 );
		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[17]=tp.navigateToCycle(phaseName);
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

	@Then("^User selects the testcase and chooses a tester in the assignee drop down$")
	public void user_selects_the_testcase_and_chooses_a_tester_in_the_assignee_drop_down() throws Throwable {
		try
		{
//			String[] phaseName=new String[1];
//		     phaseName[0]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,3 );
//		     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
//			actual[12]=tp.navigateToCycle(phaseName);
			
			int[] TestCaseNo=new int[1];
			TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			//String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,9 );
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[18]=tp.individualAssinTo(TestCaseNo, Assignee);
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

	@Then("^User successfully assigns the testcase$")
	public void user_successfully_assigns_the_testcase() throws Throwable {
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
