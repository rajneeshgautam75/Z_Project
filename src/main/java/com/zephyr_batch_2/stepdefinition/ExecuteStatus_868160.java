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

public class ExecuteStatus_868160 extends LaunchBrowser{

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
	String fileName="ExecuteStatus_868160";
	
	boolean[] actual=new boolean[97];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page TestRepositOry$")
	public void user_is_in_a_page_TestRepositOry() throws Throwable {
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
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User creates a phase and add testcase with estimated time$")
	public void user_creates_a_phase_and_add_testcase_with_estimated_time() throws Throwable {
	    
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 2, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 2, 4);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				String day1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,12 ));
				String hour1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,12 ));
				String min1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,12 ));
				actual[7]=tr.clickDetailButton();
				bp=new BasePage();
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				actual[8]=ctc.enterEstimatedTime(day1, hour1, min1);
				bp.waitForElement();
				actual[9]=tr.clickOnList();
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

	@When("^User Launches TestPlanning and creates a phase by choosing an existing phase$")
	public void user_Launches_TestPlanning_and_creates_a_phase_by_choosing_an_existing_phase() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[10]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 2, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[11]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[12]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[14]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 2, 0);
				actual[15]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 2, 1);
				actual[16]=tp.addPhaseToCycle(Phase);
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

	@When("^User assigns the testcases to Anyone and Launches TestExecution and executes testcase$")
	public void user_assigns_the_testcases_to_Anyone_and_Launches_TestExecution_and_executes_testcase() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[17]=tp.bulkAssignment(Bulk_Type);
			tp.goBackToCycle();
				
				bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[18]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[19]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[20]=exep.executeStatus(tcNo1[0], statusType1);
				    
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

	@When("^User creates a phase in TestRepository and add testcase with estimated time$")
	public void user_creates_a_phase_in_TestRepository_and_add_testcase_with_estimated_time() throws Throwable {
		try
	    {
			bp.waitForElement();
			rp.clickOnTestRep();
			
			bp.waitForElement();
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 3, 1);
				String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 3, 4);
				
				bp=new BasePage();
				actual[21]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[22]=tr.addNode(p_Name2,p_Desc2);
				bp.waitForElement();
				actual[23]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name2;
				 bp.waitForElement();
				actual[24]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				String day1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,13 ));
				String hour1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,13 ));
				String min1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,13 ));
				ctc=new CreateTestCasePage(driver);
				actual[25]=tr.clickDetailButton();
				bp=new BasePage();
				bp.waitForElement();
				actual[26]=ctc.enterEstimatedTime(day1, hour1, min1);
				bp.waitForElement();
				actual[27]=tr.clickOnList();
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

	@When("^User Launches TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to creator$")
	public void user_Launches_TestPlanning_and_creates_a_phase_by_choosing_an_existing_phase_and_assigns_the_testcase_to_creator() throws Throwable {
		try
		{
			bp.waitForElement();
		  actual[28]=rp.clickOnTestPlanning();
		  bp.waitForElement();
		  //rp.clickOnTestPlanning();
		  bp.waitForElement();
		  
		  tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 3, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[29]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[30]=tp.CreateCycle(cycle2, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[31]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[32]=tp.saveTestCycle();
			
			String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 3, 0);
			actual[33]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 3, 1);
			actual[34]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[35]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User Launch TestExecution and executes the testcase$")
	public void user_Launch_TestExecution_and_executes_the_testcase() throws Throwable {
	   try
	   {
		   bp.waitForElement();
			rp= new ReleasePage(driver);
			bp.waitForElement();
			   actual[36]=rp.clickOnTestExecution(); 
			   
			   String[] cycleName2=new String[3];
			    cycleName2[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
			    cycleName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",3 ,0 );
			    cycleName2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",3 ,1 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[37]=tp.navigateToCycle(cycleName2);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[38]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				tp.doubleClickOnCycle(cycleName);
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

	@When("^User creates a phase in the TestRepository and add testcase with estimated time$")
	public void user_creates_a_phase_in_the_TestRepository_and_add_testcase_with_estimated_time() throws Throwable {
		try
	    {
			bp.waitForElement();
			rp.clickOnTestRep();
			bp.waitForElement();
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 1);
				String p_Desc3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 4);
				
				bp=new BasePage();
				actual[39]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[40]=tr.addNode(p_Name3,p_Desc3);
				bp.waitForElement();
				actual[41]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name3;
				 bp.waitForElement();
				actual[42]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				String day1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,14 ));
				String hour1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,14 ));
				String min1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,14 ));
				ctc=new CreateTestCasePage(driver);
				actual[43]=tr.clickDetailButton();
				bp=new BasePage();
				bp.waitForElement();
				actual[44]=ctc.enterEstimatedTime(day1, hour1, min1);
				bp.waitForElement();
				actual[45]=tr.clickOnList();
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

	@When("^User Launches TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to individual$")
	public void user_Launches_TestPlanning_and_creates_a_phase_by_choosing_an_existing_phase_and_assigns_the_testcase_to_individual() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[46]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  //rp.clickOnTestPlanning();
			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[47]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[48]=tp.CreateCycle(cycle3, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[49]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[50]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 0);
				actual[51]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 1);
				actual[52]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 3, 0);
				bp.waitForElement();
				actual[53]=tp.bulkAssignment(Bulk_Type);
				
				String[] phase=new String[1];
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 1);
				bp.waitForElement();
				bp.waitForElement();
				actual[54]=tp.navigateToCycle(phase);
				bp.waitForElement();
				
				 int[] TestCaseNo1=new int[1];
					TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
					String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
					bp.waitForElement();
					actual[55]=tp.individualAssinTo(TestCaseNo1, Assignee1);
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

	@When("^User Launches TestExecution and Executes the testcase$")
	public void user_Launches_TestExecution_and_Executes_the_testcase() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[56]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName3=new String[3];
				    cycleName3[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",4 ,0 );
				    cycleName3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",4 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[57]=tp.navigateToCycle(cycleName3);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[58]=exep.executeStatus(tcNo1[0], statusType1);
				    
				    String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName);
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

	@When("^User creates a phase in Testrepository and add testcase with Estimated time$")
	public void user_creates_a_phase_in_Testrepository_and_add_testcase_with_Estimated_time() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[59]=rp.clickOnTestRep();
			bp.waitForElement();
			
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 5, 1);
				String p_Desc4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 5, 4);
				
				bp=new BasePage();
				actual[60]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[61]=tr.addNode(p_Name4,p_Desc4);
				bp.waitForElement();
				actual[62]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name4;
				 bp.waitForElement();
				actual[63]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				String day1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,15 ));
				String hour1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,15 ));
				String min1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,15 ));
				ctc=new CreateTestCasePage(driver);
				actual[64]=tr.clickDetailButton();
				bp=new BasePage();
				bp.waitForElement();
				actual[65]=ctc.enterEstimatedTime(day1, hour1, min1);
				bp.waitForElement();
				actual[66]=tr.clickOnList();
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

	@When("^User Launches a TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to Anyone$")
	public void user_Launches_a_TestPlanning_and_creates_a_phase_by_choosing_an_existing_phase_and_assigns_the_testcase_to_Anyone() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[67]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  //rp.clickOnTestPlanning();
			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 5, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[68]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[69]=tp.CreateCycle(cycle4, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[70]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[71]=tp.saveTestCycle();
				bp.waitForElement();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 5, 0);
				bp.waitForElement();
				actual[72]=tp.navigateToCycle(cycle1);
				bp.waitForElement();
				
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 5, 1);
				bp.waitForElement();
				actual[73]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[74]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User Launches TestExecution and executes the Testcase$")
	public void user_Launches_TestExecution_and_executes_the_Testcase() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[75]=rp.clickOnTestExecution(); 
				   bp.waitForElement();
				   
				   String[] cycleName4=new String[3];
				    cycleName4[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",5 ,0 );
				    cycleName4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",5 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[76]=tp.navigateToCycle(cycleName4);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[77]=exep.executeStatus(tcNo1[0], statusType1);
				    bp.waitForElement();
				    
				    String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName);
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

	@When("^User creates a phase in the TestRepository and add testcase with an estimated time$")
	public void user_creates_a_phase_in_the_TestRepository_and_add_testcase_with_an_estimated_time() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[78]=rp.clickOnTestRep();
			bp.waitForElement();
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 6, 1);
				String p_Desc5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 6, 4);
				
				bp=new BasePage();
				actual[79]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[80]=tr.addNode(p_Name5,p_Desc5);
				bp.waitForElement();
				actual[81]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name5;
				 bp.waitForElement();
				actual[82]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				String day1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,16 ));
				String hour1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,16 ));
				String min1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,16 ));
				ctc=new CreateTestCasePage(driver);
				actual[83]=tr.clickDetailButton();
				bp=new BasePage();
				bp.waitForElement();
				actual[84]=ctc.enterEstimatedTime(day1, hour1, min1);
				bp.waitForElement();
				actual[85]=tr.clickOnList();
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
	
	@When("^User Launches TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to the creator$")
	public void user_Launches_TestPlanning_and_creates_a_phase_by_choosing_an_existing_phase_and_assigns_the_testcase_to_the_creator() throws Throwable {
		try
		{
			bp.waitForElement();
		  actual[86]=rp.clickOnTestPlanning();
		  bp.waitForElement();
		  //rp.clickOnTestPlanning();
		  bp.waitForElement();
		  
		  tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 6, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[87]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[88]=tp.CreateCycle(cycle5, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[89]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[90]=tp.saveTestCycle();
			
			String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 6, 0);
			bp.waitForElement();
			actual[91]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 6, 1);
			bp.waitForElement();
			actual[92]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[93]=tp.bulkAssignment(Bulk_Type);
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

	@Then("^User Launches the TestExecution and executes the testcase$")
	public void user_Launches_the_TestExecution_and_executes_the_testcase() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[94]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName5=new String[3];
				    cycleName5[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",6 ,0 );
				    cycleName5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",6 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[95]=tp.navigateToCycle(cycleName5);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[96]=exep.executeStatus(tcNo1[0], statusType1);
				    bp.waitForElement();
				    
				    String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName);
					bp.waitForElement();
				    
				    for(int k=0;k<=actual.length-1;k++)
				     {
						System.out.println(actual[k]);
				      soft.assertEquals(actual[k], true);
				     }
				     soft.assertAll();
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
