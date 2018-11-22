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

public class Delete_868177 extends LaunchBrowser{

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
	boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
	String filename="Delete_868177";
	@Given("^user in repository page to create phase and add testcases and clone$")
	public void user_in_repository_page_to_create_phase_and_add_testcases_and_clone() throws Throwable 
	{
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
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
	@When("^User creates a phase and creates testcases$")
	public void user_creates_a_phase_and_creates_testcases() throws Throwable {
		try{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 4);
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			actual[3]=tr.doubleClickOnRelease(releaseName);
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase);
			for(int i=0;i<=3;i++)
			{
			actual[5]=tr.addTestCase();
			}
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

	@When("^User Launches TestPLanning and creates a cycle$")
	public void user_Launches_TestPLanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			
			  actual[6]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[7]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[10]=tp.saveTestCycle();
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

	@When("^User creates a phase by choosing an existing phase and assigns the testcases to creator$")
	public void user_creates_a_phase_by_choosing_an_existing_phase_and_assigns_the_testcases_to_creator() throws Throwable {
	    try
	    {
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 0);
			actual[11]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 1);
			actual[12]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[13]=tp.bulkAssignment(Bulk_Type);

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
	

	@Then("^User selects the phase and deletes the assigned testcases$")
	public void user_selects_the_phase_and_deletes_the_assigned_testcases() throws Throwable {
	    try
	    {
	    	String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",14 ,1 );
		     bp.waitForElement();
		     bp.waitForElement();
			actual[14]=tp.navigateToCycle(phaseName);
			bp.waitForElement();
			
			actual[15]=tp.selectallTestCase();
			bp.waitForElement();
			actual[16]=tp.deleteAllSelectedTestCases();
			bp.waitForElement();
			
			//rp.clickOnTestPlanning();
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
}
