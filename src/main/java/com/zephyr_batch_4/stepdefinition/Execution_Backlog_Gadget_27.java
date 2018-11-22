package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
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

public class Execution_Backlog_Gadget_27 extends LaunchBrowser{

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
	DashBoardPage dp;
	String fileName="Execution_Backlog_Gadget_27";
	
	boolean[] actual=new boolean[48];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As a Lead,Launch TestRepository and add testcases$")
	public void as_a_Lead_Launch_TestRepository_and_add_testcases() throws Throwable {
	  try
	  {
		     pp=new ProjectPage(driver);
		     bp=new BasePage();
		     rp=new ReleasePage(driver);
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		     String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 0,43);
			 String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
			 String[] phase=new String[1];
			 phase[0]=p_Name1;
			// pp.backToProjectPage();//
			 actual[0]=pp.selectProject(projectName);
		     actual[1]=pp.selectRelease(releaseName);
		     bp.waitForElement();
		     actual[2]=rp.clickOnTestRep();
			 
			    tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				ep=new ExportPage(driver);
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				for(int i=0;i<=2;i++)
				{
					tr.selectallTestCase();
					tr.cloneTestCase();
				}
				bp.waitForElement();
				//select  1st testcase
				String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 1, 15));
				
				String[] testCaseNo2=new String[1];
				testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 2, 15));
				
				String[] testCaseNo3=new String[1];
				testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 3, 15));
				
				String[] testCaseNo4=new String[1];
				testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 4, 15));
				
				String[] testCaseNo5=new String[1];
				testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 5, 15));
				
				String[] testCaseNo6=new String[1];
				testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 6, 15));
				
				String[] testCaseNo7=new String[1];
				testCaseNo7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 7, 15));
				
				String[] testCaseNo8=new String[1];
				testCaseNo8[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards", 8, 15));
				
				String priority1[]=new String[1];
				priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 41);
				
				String priority2[]=new String[1];
				priority2[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 41);
				
				String priority3[]=new String[1];
				priority3[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 42);
				
				String tags1[]=new String[1];////
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 44);////
				
				String tags2[]=new String[1];////
				tags2[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 44);////
				
				bp.waitForElement();
				tr.clickDetailButton();
				actual[7]=ep.selectMultipleTestCaseFromGrid(testCaseNo1);
				//tr.clickDetailButton();
				bp.waitForElement();
				
				actual[8]=ctc.enterPriority(priority1);
				bp.waitForElement();
				bp.waitForElement();
				ctc.enterMultipleTags(tags1);
				//tr.clickOnList();
				bp.waitForElement();
				
				//select  2nd testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				bp.waitForElement();
				
				actual[9]=ctc.enterPriority(priority2);
				bp.waitForElement();
				ctc.enterMultipleTags(tags2);
				//tr.clickOnList();
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				
				//select  3rd testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				bp.waitForElement();
				//tr.clickDetailButton();
				bp.waitForElement();
				
				actual[10]=ctc.enterPriority(priority3);
				bp.waitForElement();
				//tr.clickOnList();
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				
				//select  4th testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				bp.waitForElement();
				//tr.clickDetailButton();
				bp.waitForElement();
				String priority4[]=new String[1];
				priority4[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 42);
				actual[11]=ctc.enterPriority(priority4);
				//System.out.println(priority4);
				bp.waitForElement();
				//tr.clickOnList();
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				
				//select  5th testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo5);
				bp.waitForElement();
				String text=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
				String longText=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
				String number=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
				String checkBox=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
				String pickupList1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 46);
				String date=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
				ctc.customFieldOption.click();
				actual[12]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList1, date);
				
				//select  6th testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo6);
				bp.waitForElement();
				String pickupList2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 46);
				actual[13]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList2, date);
			 
				//select  7th testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo7);
				bp.waitForElement();
				bp.waitForElement();
				String pickupList3=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 47);
				actual[14]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList3, date);
				ctc.enterMultipleTags(tags2);
				
				//select  8th testcase
				ep.selectMultipleTestCaseFromGrid(testCaseNo8);
				bp.waitForElement();
				bp.waitForElement();
				String pickupList4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 47);
				actual[15]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList4, date);
				ctc.enterMultipleTags(tags2);
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
	
	@When("^Launch TestPlanning and add a phase to cycle$")
	public void launch_TestPlanning_and_add_a_phase_to_cycle() throws Throwable {
		try
		   {
			   bp.waitForElement();
			   actual[16]=rp.clickOnTestPlanning();
			  
			    tp=new TestPlanningPage(driver);
		
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				
				bp.waitForElement();
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 0, 43);
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				
				bp.waitForElement();
				actual[17]=tp.clickOnAddTestCycleSymbol();
				actual[18]=tp.CreateCycle(cycle, Build, environ, hide);
				actual[19]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				actual[20]=tp.saveTestCycle();
				bp.waitForElement();
				actual[21]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				
				actual[22]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				actual[23]=tp.bulkAssignment(Bulk_Type);
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
	
	@When("^Launch TestExecution and execute testcases$")
	public void launch_TestExecution_and_execute_testcases() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			    tp=new TestPlanningPage(driver);
			    String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",100 ,100 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",0 ,43 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );   
		
			   bp.waitForElement();
			   actual[24]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			    
			    bp.waitForElement();
				actual[25]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    exep.selectAndDeselectAllTestCase();
			    bp.waitForElement();
			    actual[26]=exep.changeMultiSelectedStatus(statusType1);
			    tp.doubleClickOnCycle(releaseName);
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

	@When("^launch dashboard page$")
	public void launch_dashboard_page() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[27]=dp.clickOnManageDashboards();
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

	@When("^add the dashboard with the available fields$")
	public void add_the_dashboard_with_the_available_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,39);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[28]=dp.clickOnAddDashBoardSymbol();
			actual[29]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[30]=dp.validateDashBoard(dashboardName);
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

	@When("^add the execution backlog gadget$")
	public void add_the_execution_backlog_gadget() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,39);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[31]=dp.selectDashboard(dashboardName);
			actual[32]=dp.clickOnAddGadgetSymbol();
			actual[33]=dp.addGadget(gadgetName);
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

	@When("^configure the execution backlog gadget$")
	public void configure_the_execution_backlog_gadget() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String[] value=new String[1];
			value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			actual[34]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
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

	@Then("^Should be able to modify gadget with any one priority$")
	public void should_be_able_to_modify_gadget_with_any_one_priority() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,40);
			String[] value=new String[2];
			value[0]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,41);
			value[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,42);
			actual[35]=dp.filterBy(filterByName, value);
			bp.waitForElement();
			actual[36]=dp.saveGadget();
			actual[37]=dp.validateSavedGadget(projectName, release);
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

	@When("^edit the execution backlog gadget to delete any one priority$")
	public void edit_the_execution_backlog_gadget_to_delete_any_one_priority() throws Throwable {
		try
		   {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		       String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");   
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   dp=new DashBoardPage(driver);
			   pp.backToProjectPage();//
			   pp.selectProject(projectName1);
			   pp.selectProject(projectName);
		       pp.selectRelease(releaseName);
			   bp.waitForElement();
			   actual[38]=rp.clickOnTestPlanning();
			   
			    tp=new TestPlanningPage(driver);
			    String[] cycleName=new String[2];
			    String[] cycleName1=new String[1];
			    int[] tcNo=new int[2];
			    tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards",3 ,15 );
			    tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards",4 ,15 );
			    cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",0 ,43); //2,28
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",100,100 ); //2,30
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",0 ,43 ); //2,28
				tp.doubleClickOnCycle(cycleName[0]);
				actual[39]=tp.navigateToCycle(cycleName);
				actual[40]=tp.assignPhase();
				tp.navigateToCycle(cycleName1);
				actual[41]=tp.selectSingleMultipleTestcase(tcNo);
				bp.waitForElement();
				actual[42]=tp.deleteAllSelectedTestCases();
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

	@Then("^Should be able to delete any one priority$")
	public void should_be_able_to_delete_any_one_priority() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,39);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String filterName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,40);
			bp.waitForElement();
			actual[43]=dp.clickOnManageDashboards();
			actual[44]=dp.searchDashboard(dashboardName);
			actual[45]=dp.selectDashboard(dashboardName);
			actual[46]=dp.validateSavedGadget(projectName, releaseName);
			actual[47]=dp.viewMsg(filterName);
			bp.waitForElement();
			pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
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
