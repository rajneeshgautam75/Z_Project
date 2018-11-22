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

public class ExecuteStatus_868162 extends LaunchBrowser{

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
	String fileName="ExecuteStatus_868162";
	
	boolean[] actual=new boolean[76];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is In a page TestRepository$")
	public void user_is_In_a_page_TestRepository() throws Throwable {
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

	@Given("^User creates a phase and creates testcases with different estimated time$")
	public void user_creates_a_phase_and_creates_testcases_with_different_estimated_time() throws Throwable {
		try{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 8, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 8, 4);
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
			String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,24 );
			String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,24 );
			String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,24 );
			ctc=new CreateTestCasePage(driver);
			actual[6]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[7]=ctc.enterEstimatedTime(day1, hour1, min1);
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=tr.clickOnList();
			bp.waitForElement();
			
			actual[9]=tr.addTestCase();
			String day2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,25 );
			String hour2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,25 );
			String min2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,25 );
			ctc=new CreateTestCasePage(driver);
			actual[10]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[11]=ctc.enterEstimatedTime(day2, hour2, min2);
			bp.waitForElement();
			bp.waitForElement();
			actual[12]=tr.clickOnList();
			
			actual[13]=tr.addTestCase();
			String day3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,26 );
			String hour3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,26 );
			String min3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,26 );
			ctc=new CreateTestCasePage(driver);
			actual[14]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[15]=ctc.enterEstimatedTime(day3, hour3, min3);
			bp.waitForElement();
			bp.waitForElement();
			actual[16]=tr.clickOnList();
			
			actual[17]=tr.addTestCase();
			String day4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,27 );
			String hour4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,27 );
			String min4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,27 );
			ctc=new CreateTestCasePage(driver);
			actual[18]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[19]=ctc.enterEstimatedTime(day4, hour4, min4);
			bp.waitForElement();
			bp.waitForElement();
			actual[20]=tr.clickOnList();
			
			actual[21]=tr.addTestCase();
			String day5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,28 );
			String hour5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,28 );
			String min5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,28 );
			ctc=new CreateTestCasePage(driver);
			actual[22]=tr.clickDetailButton();
			bp=new BasePage();
			bp.waitForElement();
			actual[23]=ctc.enterEstimatedTime(day5, hour5, min5);
			bp.waitForElement();
			bp.waitForElement();
			actual[24]=tr.clickOnList();
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

	@When("^User Launches TestPlanning and creates a cycle,creates a phase by choosing an existing phase$")
	public void user_Launches_TestPlanning_and_creates_a_cycle_creates_a_phase_by_choosing_an_existing_phase() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[25]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  //rp.clickOnTestPlanning();
			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 8, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[26]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[27]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[28]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[29]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 8, 0);
				actual[30]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 8, 1);
				actual[31]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[32]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User Launches TestExecution and executes the testcases,unexecutes testcases again$")
	public void user_Launches_TestExecution_and_executes_the_testcases_unexecutes_testcases_again() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[33]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[34]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[35]=exep.executeStatus(tcNo1[0], statusType1);
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[36]=exep.executeStatus(tcNo2[0], statusType2);
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[37]=exep.executeStatus(tcNo3[0], statusType3);
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[38]=exep.executeStatus(tcNo4[0], statusType4);
				    bp.waitForElement();
				    
				    int[] tcNo5=new int[1];
					tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
				    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[39]=exep.executeStatus(tcNo5[0], statusType5);
				    bp.waitForElement();
				    
				    String cycleName11=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName11);
					bp.waitForElement();
				    
				    /*driver.navigate().refresh();
			    	bp.waitForElement();
			    	bp.waitForElement();*/
			    	
			    	String[] cycleName1=new String[3];
				    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
				    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[40]=tp.navigateToCycle(cycleName1);
					bp.waitForElement();
			    	
			    	int[] tcNo6=new int[1];
					tcNo6[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[41]=exep.executeStatus(tcNo6[0], statusType6);
				    
				    int[] tcNo7=new int[1];
					tcNo7[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType7=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[42]=exep.executeStatus(tcNo7[0], statusType7);
				    
				    int[] tcNo8=new int[1];
					tcNo8[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType8=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[43]=exep.executeStatus(tcNo8[0], statusType8);
				    
				    int[] tcNo9=new int[1];
					tcNo9[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType9=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[44]=exep.executeStatus(tcNo9[0], statusType9);
				    
				    int[] tcNo10=new int[1];
					tcNo10[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
				    String statusType10=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[45]=exep.executeStatus(tcNo10[0], statusType10);
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

	@When("^User edits the actual time of an unexecuted testcases$")
	public void user_edits_the_actual_time_of_an_unexecuted_testcases() throws Throwable {
	    try
	    {
	    	exep=new ExecutionPage(driver);
	    	String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,24 );
			String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,24 );
			String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,24 );
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			
			String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1,8 ));
			actual[48]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo1);
			bp.waitForElement();
			actual[46]=exep.actualTime(day1, hour1, min1);
	    	bp.waitForElement();
	    	/*driver.navigate().refresh();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	
	    	String[] cycleName1=new String[3];
		    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
		    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[47]=tp.navigateToCycle(cycleName1);
			bp.waitForElement();*/
			
			String day11=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,24 );
			String hour11=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,24 );
			String min11=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,24 );
			actual[47]=exep.validateActualTime(day11, hour11, min11);
			bp.waitForElement();
			
			String[] testCaseNo2=new String[1];
			testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2,8 ));
			actual[48]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo2);
			bp.waitForElement();
			
			String day2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,25 );
			String hour2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,25 );
			String min2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,25 );
			actual[49]=exep.actualTime(day2, hour2, min2);
	    	bp.waitForElement();
	    	/*driver.navigate().refresh();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	
	    	String[] cycleName2=new String[3];
		    cycleName2[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
		    cycleName2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[51]=tp.navigateToCycle(cycleName2);
			bp.waitForElement();*/
			
			String[] testCaseNo22=new String[1];
			testCaseNo22[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2,8 ));
			actual[50]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo22);
			bp.waitForElement();
			String day22=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,25 );
			String hour22=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,25 );
			String min22=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,25 );
			bp.waitForElement();
			actual[51]=exep.validateActualTime(day22, hour22, min22);
			
			String[] testCaseNo3=new String[1];
			testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3,8 ));
			actual[52]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo3);
			bp.waitForElement();
			
			String day3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,26 );
			String hour3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,26 );
			String min3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,26 );
			actual[53]=exep.actualTime(day3, hour3, min3);
	    	bp.waitForElement();
	    	/*driver.navigate().refresh();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	
	    	String[] cycleName3=new String[3];
		    cycleName3[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
		    cycleName3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[56]=tp.navigateToCycle(cycleName3);
			bp.waitForElement();*/
			
			String[] testCaseNo33=new String[1];
			testCaseNo33[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3,8 ));
			actual[54]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo33);
			bp.waitForElement();
			
			String day33=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,26 );
			String hour33=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,26 );
			String min33=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,26 );
			actual[55]=exep.validateActualTime(day33, hour33, min33);
			
			String[] testCaseNo4=new String[1];
			testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 4,8 ));
			actual[56]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo4);
			
			String day4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,27 );
			String hour4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,27 );
			String min4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,27 );
			actual[57]=exep.actualTime(day4, hour4, min4);
	    	bp.waitForElement();
	    	/*driver.navigate().refresh();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	
	    	String[] cycleName4=new String[3];
		    cycleName4[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
		    cycleName4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[61]=tp.navigateToCycle(cycleName4);
			bp.waitForElement();*/
			
			String[] testCaseNo44=new String[1];
			testCaseNo44[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 4,8 ));
			actual[58]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo44);
			bp.waitForElement();
			
			String day44=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,27 );
			String hour44=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,27 );
			String min44=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,27 );
			actual[59]=exep.validateActualTime(day44, hour44, min44);
			bp.waitForElement();
			
			
			String[] testCaseNo5=new String[1];
			testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5,8 ));
			actual[60]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo5);
			bp.waitForElement();
			
			String day5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,28 );
			String hour5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,28 );
			String min5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,28 );
			actual[61]=exep.actualTime(day5, hour5, min5);
	    	bp.waitForElement();
	    	/*driver.navigate().refresh();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	
	    	String[] cycleName5=new String[3];
		    cycleName5[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
		    cycleName5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[66]=tp.navigateToCycle(cycleName5);
			bp.waitForElement();*/
			
			String[] testCaseNo55=new String[1];
			testCaseNo55[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5,8 ));
			actual[62]=exep.selectMultipleTestCaseFromExecutionGrid(testCaseNo55);
			bp.waitForElement();
			
			String day55=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,28 );
			String hour55=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,28 );
			String min55=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,28 );
			actual[63]=exep.validateActualTime(day55, hour55, min55);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			String cycleName=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
			actual[64]=tp.doubleClickOnCycle(cycleName);
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

	@Then("^User Launches TestPlanning and view the edited values of an actual time$")
	public void user_Launches_TestPlanning_and_view_the_edited_values_of_an_actual_time() throws Throwable {
		try
		{
			actual[65]=bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[65]=rp.clickOnTestPlanning();
		actual[66]=bp.waitForElement();
//		actual[66]=rp.clickOnTestPlanning();
//		bp.waitForElement();
//		tp.navigateBacktoTestPlanning();
//		bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
		bp.waitForElement();
		actual[67]=tp.doubleClickOnCycle(cycleName1);
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[68]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[69]=tp.assignPhase();
	   
	   String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8 ,1 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[70]=tp.navigateToCycle(phaseName);
		
		String[] sortName=new String[1];
		sortName[0]="Actual Time";
		tp.sort(sortName);
		bp.waitForElement();
		
		int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
		String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,24 );
		String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,24 );
		String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,24 );
		bp.waitForElement();
		actual[71]=tp.validateActualTime(tcNo1, day1, hour1, min1);
		bp.waitForElement();
		
		int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
		String day2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,25 );
		String hour2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,25 );
		String min2=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,25 );
		bp.waitForElement();
		actual[72]=tp.validateActualTime(tcNo2, day2, hour2, min2);
		bp.waitForElement();
		
		int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
		String day3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,26 );
		String hour3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,26 );
		String min3=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,26 );
		bp.waitForElement();
		actual[73]=tp.validateActualTime(tcNo3, day3, hour3, min3);
		bp.waitForElement();
		
		int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 );
		String day4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,27 );
		String hour4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,27 );
		String min4=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,27 );
		bp.waitForElement();
		actual[74]=tp.validateActualTime(tcNo4, day4, hour4, min4);
		bp.waitForElement();
		
		int tcNo5=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,8 );
		String day5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 1,28 );
		String hour5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 2,28 );
		String min5=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 3,28 );
		bp.waitForElement();
		actual[75]=tp.validateActualTime(tcNo5, day5, hour5, min5);
		bp.waitForElement();
		tp.goBackToCycle();
		
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
